package day57ForRedisGZip;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

public class RedisSerializerGzip extends JdkSerializationRedisSerializer {

    public static final int BUFFER_SIZE = 4096;
    // 序列化器
    private RedisSerializer<Object> innerSerializer;

    public RedisSerializerGzip() {
        this.innerSerializer = getValueSerializer();
    }

    @Override
    public byte[] serialize(Object graph) throws SerializationException {
        if (graph == null) {
            return new byte[0];
        }
        ByteArrayOutputStream bos = null;
        GZIPOutputStream gzip = null;
        try {
            // 先序列化
            byte[] bytes = innerSerializer.serialize(graph);
            bos = new ByteArrayOutputStream();
            gzip = new GZIPOutputStream(bos);
            // 再压缩
            gzip.write(bytes);
            gzip.finish();
            byte[] result = bos.toByteArray();
            return result;
        } catch (Exception e) {
            throw new SerializationException("Gzip Serialization Error", e);
        } finally {
            IOUtils.closeQuietly(bos);
            IOUtils.closeQuietly(gzip);
        }
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        ByteArrayOutputStream bos = null;
        ByteArrayInputStream bis = null;
        GZIPInputStream gzip = null;
        try {
            bos = new ByteArrayOutputStream();
            bis = new ByteArrayInputStream(bytes);
            gzip = new GZIPInputStream(bis);
            byte[] buff = new byte[BUFFER_SIZE];
            int n;
            // 先解压
            while ((n = gzip.read(buff, 0, BUFFER_SIZE)) > 0) {
                bos.write(buff, 0, n);
            }
            // 再反序列化
            Object result = innerSerializer.deserialize(bos.toByteArray());
            return result;
        } catch (Exception e) {
            throw new SerializationException("Gzip deserizelie error", e);
        } finally {
            IOUtils.closeQuietly(bos);
            IOUtils.closeQuietly(bis);
            IOUtils.closeQuietly(gzip);
        }
    }

    private static RedisSerializer getValueSerializer() {
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        return jackson2JsonRedisSerializer;
    }
}