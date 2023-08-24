package com.lee.onstage.serializer;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

/**
 * redis序列化配置
 * @author  lei
 */
public class FastJsonRedisSerializer<T> implements RedisSerializer {
    /**
     * 默认序列化编码:UTF-8
     */
    public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;
    /**
     * 泛型参数
     */
    private Class<T> clazz;

    public FastJsonRedisSerializer(Class<T> clazz)
    {
        super();
        this.clazz = clazz;
    }

    /**
     * @param o
     * @return
     * @throws SerializationException
     */
    @Override
    public byte[] serialize(Object o) throws SerializationException {
        if(o==null){
            return new byte[0];
        }
        return JSON.toJSONString(o, JSONWriter.Feature.WriteClassName).getBytes(DEFAULT_CHARSET);
    }

    /**
     * @param bytes
     * @return
     * @throws SerializationException
     */
    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        if(bytes==null||bytes.length<=0){
            return null;
        }
        String str = new String(bytes,DEFAULT_CHARSET);
        return JSON.parseObject(str,clazz);
    }
    protected JavaType getJavaType(Class<?> clazz){
        return TypeFactory.defaultInstance().constructType(clazz);
    }

    /**
     * @return
     */
    @Override
    public Class<?> getTargetType() {
        return RedisSerializer.super.getTargetType();
    }

    /**
     * @param type
     * @return
     */
    @Override
    public boolean canSerialize(Class type) {
        return RedisSerializer.super.canSerialize(type);
    }
}
