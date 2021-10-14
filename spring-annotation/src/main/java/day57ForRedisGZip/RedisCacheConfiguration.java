package day57ForRedisGZip;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import sun.applet.Main;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class RedisCacheConfiguration {
    public static void main(String args[]) {
        try {
            nameClass data = new  nameClass("name",21);
            //压缩数据
            byte[] bytes = new RedisSerializerGzip().serialize(data);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(bytes);
            //关闭流
            oos.close();

            // 读取 Byte格式 存入的数据
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            byte[] o = (byte[]) objectInputStream.readObject();
            //解压数据
            Object object = new RedisSerializerGzip().deserialize(o);
            System.out.println("--"+JSONObject.toJSONString(object));
        } catch (Exception e) {
            System.out.println("--"+e.getMessage());
        }

    }
}

class nameClass {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    //要有默认构造函数，否则会报错--Gzip deserizelie error; nested exception is org.springframework.data.redis.serializer.SerializationException: Could not read JSON: Can not construct instance of day57ForRedisGZip.nameClass: no suitable constructor found, can not deserialize from Object value (missing default constructor or creator, or perhaps need to add/enable type information?)
    public nameClass() {

    }

    public nameClass(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
