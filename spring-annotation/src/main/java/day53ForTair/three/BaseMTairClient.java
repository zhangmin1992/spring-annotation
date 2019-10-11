package day53ForTair.three;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.meituan.service.movie.tair.service.enums.MTairCodeEnum;
import com.taobao.tair3.client.Result;
import com.taobao.tair3.client.ResultMap;
import com.taobao.tair3.client.TairClient;
import com.taobao.tair3.client.impl.MultiTairClient;
import com.taobao.tair3.client.util.ByteArray;
import com.taobao.tair3.client.util.SerializableUtil;

@Service
public class BaseMTairClient implements MTairClient {

	private static final Logger logger = LoggerFactory.getLogger(BaseMTairClient.class);

    public MultiTairClient tairClient = null;

    public short area;
    
    /**
     * 缓存对象，超时时间默认timeOut(单位：毫秒)，缓存有效期为expireTime(单位：秒)
     *
     * @param key
     * @param object
     * @param timeOut
     * @param expireTime
     * @return
     */
    public boolean put(String key, Object object, long timeOut, int expireTime) {
        TairClient.TairOption option = new TairClient.TairOption(timeOut, (short) 0, expireTime);
        try {
            Result<Void> result = tairClient.putObj(area, key, object, option);
            String msg = "put Object key = " + key + " value=" + object.toString() + ", option=" + ToStringBuilder.reflectionToString(option);
            return  assertTairResult(msg,result);
        } catch (Exception e) {
            logger.error("key:" + key, e);
        }
        return false;
    }
    
    /**
     * 对缓存操作的结果进行判断
     *
     * @param msg
     * @param result
     * @throws Exception
     */
    public boolean assertTairResult(String msg, Result<?> result) throws Exception {
        if (result == null) {
            throw new Exception("assertTairResult fail. result IS NULL , msg=" + msg);
        }
        if (result.getCode() == Result.ResultCode.OK) {
            return true;
        }
        if (result.getCode() == Result.ResultCode.PART_OK) {
        	throw new Exception("msg = " + msg + " code = " + MTairCodeEnum.PART_OK.getDesc());
        }
        if (result.getCode() == Result.ResultCode.NOTEXISTS) {
        	throw new Exception("msg = " + msg + " code = " + MTairCodeEnum.KEY_NOT_EXSIT.getDesc());
        }
        throw new Exception("assertTairResult fail. ResultCode IS NOT OK, result=" + result.toString() + " , msg=" + msg);
    }
    
    /**
     * 获取缓存对象，超时时间为timeOut（单位：毫秒）
     *
     * @param key
     * @param clazz
     * @param timeOut 超时时间（单位：毫秒）
     * @param <T>
     * @return
     */
    public <T> T get(String key, Class<T> clazz, long timeOut) {
        try {
            TairClient.TairOption option = new TairClient.TairOption(timeOut, (short) 0, 0);
            Result<Object> result = tairClient.getObj(area, key, clazz, option);
            if (result.getCode() == Result.ResultCode.NOTEXISTS) {
            	throw new Exception("code = " + MTairCodeEnum.KEY_NOT_EXSIT.getDesc());
            }
            return (T) result.getResult();
        } catch (Exception e) {
            logger.error("key:" + key, e);
        }
        return null;
    }
    
    /**
     * 缓存List类型对象，超时时间为timeOut(单位：毫秒) 缓存有效期为expireTime（单位：秒）
     *
     * @param key
     * @param list
     * @param timeOut
     * @param expireTime
     * @param <T>
     * @return
     */
    public <T> boolean putList(String key, List<T> list, long timeOut, int expireTime) {
        if (list == null  || list.isEmpty()) {
            return false;
        }
        TairClient.TairOption option = new TairClient.TairOption(timeOut, (short) 0, expireTime);
        try {
            byte[] keyBytes = key.getBytes();
            byte[] valueBytes = SerializableUtil.serializeList(list);
            Result<Void> result = tairClient.putAsync(area, keyBytes, valueBytes, option).get();
            String msg = "putInternal key= " + key + " value= " + valueBytes.toString() + ", option=" + ToStringBuilder.reflectionToString(option);
            return assertTairResult(msg, result);
        } catch (Exception e) {
            logger.error("key:" + key, e);
        }
        return false;
    }
    
    /**
     * 获取缓存List类型对象
     *
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> List<T> getList(String key, Class<T> clazz) {
        byte[] keyBytes = key.getBytes();
        try {
            Result<byte[]> getResult = tairClient.getAsync(area, keyBytes, null).get();
            List<T> list = SerializableUtil.deserializeList(getResult.getResult(), clazz);
            return list;
        } catch (Exception e) {
            logger.error("key:" + key, e);
        }
        return null;
    }
    
    /**
     * 将对象追加到缓存Set中，超时时间为timeOut（单位:毫秒），缓存有效期为expireTime（单位：秒）
     *
     * @param key
     * @param obj
     * @param timeOut    单位:毫秒
     * @param expireTime 单位：秒
     * @return
     */
    public boolean setAdd(String key, Object obj, long timeOut, int expireTime) {
        TairClient.TairOption option = new TairClient.TairOption(timeOut, (short) 0, expireTime);
        Set<byte[]> set = new HashSet<byte[]>();
        try {
            set.add(SerializableUtil.serialize(obj));
            ResultMap<ByteArray, Result<Void>> result = tairClient.setAdd(area, key.getBytes(), set, option);
            return assertTairResult("addToSet key=" + key, result);
        } catch (Exception e) {
            logger.error("key:" + key, e);
        }
        return false;
    }
    
    /**
     * 删除缓存set
     *
     * @param key
     * @param timeOut 超时时间 单位：毫秒
     * @return
     */
    public boolean setRemoveAll(String key, long timeOut) {
        TairClient.TairOption option = new TairClient.TairOption(timeOut, (short) 0, 0);
        try {
            Result<Void> result = tairClient.setRemoveAll(area, key.getBytes(), option);
            return assertTairResult("addToSet key=" + key, result);
        } catch (Exception e) {
            logger.error("key:" + key, e);
        }
        return false;
    }
    
    // 移除set成员
    public <T> boolean setRemove(String key, Set<T> members) {
        try {
            if (CollectionUtils.isEmpty(members)) {
                return true;
            }
            Set<byte[]> set = Sets.newHashSet();
            for (T member : members) {
                set.add(SerializableUtil.serialize(member));
            }
            ResultMap<ByteArray, Result<Void>> resultMap = tairClient.setRemove(area, key.getBytes(), set, null);
            return assertTairResult("setRemove. key=" + key, resultMap);
        } catch (Exception e) {
            logger.error("setRemove. error. key:{},members:{}", key, members, e);
        }
        return false;
    }
    
    /**
     * 获取缓存set
     *
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> Set<T> getSetMembers(String key, Class<T> clazz) {
        try {
            Result<Set<byte[]>> result = tairClient.setMembers(area, key.getBytes(), null);
            Set<byte[]> set = result.getResult();
            if (CollectionUtils.isEmpty(set)) {
                return null;
            }
            Set<T> resultSet = new HashSet<T>();
            for (byte[] array : set) {
                resultSet.add(SerializableUtil.deserialize(array, clazz));
            }
            return resultSet;
        } catch (Exception e) {
            logger.error("key:" + key, e);
        }
        return null;
    }
    
    /**
     * 自增缓存计数值，每次自增num (缓存计数值将被持久化，本方法为原子操作)
     *
     * @param key
     * @param num 每次自增值
     * @return 返回值为自增后结果。返回负数表示自增失败
     */
    public int incrByNum(String key, int num) {
        int resultValue;
        try {
            byte[] keyBytes = key.getBytes();
            TairClient.TairOption option = null;
            Result<Integer> incrResult = tairClient.incrAsync(area, keyBytes, num, 0, option).get();
            assertTairResult("incr key=" + key + ",num=" + num, incrResult);
            resultValue = incrResult.getResult();
            return resultValue;
        } catch (Exception e) {
            logger.error("key:" + key, e);
        }
        return MTairCodeEnum.RESULT_ERROR.getValue();
    }
    
    /**
     * 批量获取缓存对象
     *
     * @param keys
     * @return
     */
    public <T> Map<String, T> batchGet(List<String> keys, Class<T> clazz) {
        try {
            Map<String, T> result = Maps.newHashMap();
            if (CollectionUtils.isEmpty(keys)) {
                return result;
            }
            Map<String, Class> keyMap = Maps.newHashMap();
            for (String key : keys) {
                keyMap.put(key, clazz);
            }
            ResultMap<String, Result<Object>> resultMap = tairClient.batchGetObj(area, keyMap, null);
            assertTairResult("get key=" + JSON.toJSONString(keys), resultMap);
            if (MapUtils.isEmpty(resultMap.getResult())) {
                return result;
            }
            for (Map.Entry<String, Result<Object>> entry : resultMap.getResult().entrySet()) {
                if (entry.getValue().isSuccess() && null != entry.getValue().getResult()) {
                    result.put(entry.getKey(), (T) entry.getValue().getResult());
                }
            }
            return result;
        } catch (Exception e) {
            logger.warn("batch get obj from tair get exception:", e);
        }
        return null;
    }

    // 批量删除缓存对象
    public boolean batchDelete(List<String> keys) {
        try {
            ResultMap<ByteArray, Result<Void>> resultMap = tairClient.batchDeleteObj(area, keys, null);
            assertTairResult("delete keys=" + keys, resultMap);
            return true;
        } catch (Exception e) {
            logger.error("keys:" + keys, e);
        }
        return false;
    }

    public boolean delete(String key, long timeOut) {
        try {
            TairClient.TairOption option = new TairClient.TairOption(timeOut, (short) 0, 0);
            Result<Void> result = tairClient.deleteObj(area, key, option);
            return assertTairResult("delete key=" + key, result);
        } catch (Exception e) {
            logger.error("key:" + key, e);
        }
        return false;
    }
}
