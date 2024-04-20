package com.lee.onstage.service;

import org.springframework.data.redis.core.BoundSetOperations;

import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * redis接口
 * @author Acxfoxer
 * @Date  20240420
 */
 public interface BlogRedisService {

    /**
     * 缓存基本的对象，Integer、String、实体类等
     *
     * @param key 缓存的键值
     * @param value 缓存的值
     */
     <T> void setCacheObject(final String key, final T value);

    /**
     * 缓存基本的对象，Integer、String、实体类等
     *
     * @param key 缓存的键值
     * @param value 缓存的值
     * @param timeout 时间
     * @param timeUnit 时间颗粒度
     */
     <T> void setCacheObject(final String key, final T value, final Integer timeout, final TimeUnit timeUnit);

    /**
     * 设置有效时间
     *
     * @param key Redis键
     * @param timeout 超时时间
     * @return true=设置成功；false=设置失败
     */
    boolean expire(final String key, final long timeout);

    /**
     * 设置有效时间
     *
     * @param key Redis键
     * @param timeout 超时时间
     * @param unit 时间单位
     * @return true=设置成功；false=设置失败
     */
     boolean expire(final String key, final long timeout, final TimeUnit unit);

    /**
     * 获得缓存的基本对象。
     *
     * @param key 缓存键值
     * @return 缓存键值对应的数据
     */
     <T> T getCacheObject(final String key);

    /**
     * 删除单个对象
     *
     * @param key key
     */
     Boolean deleteObject(final String key);

    /**
     * 删除集合对象
     *
     * @param keys 多个对象
     * @return long
     */
    Long deleteObject(List<String> keys);
    /**
     * 缓存List数据
     *
     * @param key 缓存的键值
     * @param dataList 待缓存的List数据
     * @return 缓存的对象
     */
     <T> Long setCacheList(final String key, final List<T> dataList);

    /**
     * 获得缓存的list对象
     *
     * @param key 缓存的键值
     * @return 缓存键值对应的数据
     */
     <T> List<T> getCacheList(final String key);

    /**
     * 缓存Set集合数据
     *
     * @param key 缓存键值
     * @param dataSet 缓存的数据
     * @return 缓存数据的对象
     */
     <T> BoundSetOperations<String, T> setCacheSet(final String key, final Set<T> dataSet);

    /**
     * 缓存Set集合数据
     *
     * @param key 缓存键值
     * @param values 缓存的数据
     * @return 缓存数据的对象
     */
     <T> void setSet(String key, T... values);
    /**
     * 获得缓存的set
     *
     * @param key
     * @return
     */
     <T> Set<T> getCacheSet(final String key);

    /**
     * 从缓存中获取对象
     * @param key
     * @return
     * @param <T>
     */
     <T> T getObject(String key);

    /**
     * 设置缓存
     * @param key
     * @param value
     * @param <T>
     */
     <T> void setObject(String key, T value);
    /**
     * 添加zset类型缓存
     * @param key
     * @param value
     * @param score
     * @param <T>
     */
     <T> void setCacheZSet(final  String key,  Object value,  double score);
    /**
     * 获取zset的降序排列
     *
     * @param key
     * @param beginIndex
     * @param endIndex
     * @return
     */
     <T> Set<T> getCacheZSet(final String key, int beginIndex, int endIndex);



    /**
     * 对key的值进行原子增加
     * @param key   键
     * @param delta 增长数
     * @return
     */
     Long incr(String key,long delta);

    /**
     * 对key的值进行原子性减少
     * @param key   键
     * @param delta 减少数
     * @return
     */
     Long decr(String key,long delta);
    /**
     * 获取zset的降序排列,并返回map集合
     * @param key 键
     * @param start 起始分
     * @param end   结束分
     * @return Map<Object,Double>
     */
    Map<Object,Double> getCacheZSetWithScore(final String key, int start, int end);

    /**
     * 获取zset的所有集合
     * @param key 键
     * @return Map<Object,Double>
     */
    Map<Object,Double> getCacheZSetWith(final String key);

    /**
     *
     * @param key
     * @param value
     * @return
     * @param <T>
     */
     <T> T getCacheZSetScore(final String key, final String value);

    /**
     * 缓存Map
     * @param key 键
     * @param object 缓存Map对象
     */
     <T> void setCacheMap(final String key, final Map<String, T> object);

    /**
     * 获得缓存的Map
     *
     * @param key 值
     * @return T
     */
     <T> T getCacheMap(final String key);

    /**
     * 往Hash中存入数据
     *
     * @param key Redis键
     * @param hKey Hash键
     * @param value 值
     */
     <T> void setCacheMapValue(final String key, final String hKey, final T value);

    /**
     * 获取Hash中的数据
     *
     * @param key Redis键
     * @param hKey Hash键
     * @return Hash中的对象
     */
     <T> T getCacheMapValue(final String key, final String hKey);

    /**
     * 删除Hash中的数据
     *
     * @param key 健
     * @param hashKey hashKey
     */
     void delCacheMapValue(final String key, final String hashKey);
    /**
     * 获取多个Hash中的数据
     *
     * @param key Redis键
     * @param hKeys Hash键集合
     * @return Hash对象集合
     */
     <T> List<T> getMultiCacheMapValue(final String key, final Collection<Object> hKeys);
    /**
     * 获得缓存的基本对象列表
     *
     * @param pattern 字符串前缀
     * @return 对象列表
     */
     Set<String> keys(final String pattern);

    /**
     *获取key对应的所有map键值对
     *
     * @param key  键
     * @return Map
     */
     <T> Map<String,T> getHashAll(String key) ;
    /**
     * 查看该key 是否有值
     * @param key 键
     * @param value 值
     * @return  Boolean
     */
     <T> Boolean hasSetValue(String key,T value);

    /**
     *
     * @param key    键
     * @param value  需要增加的对象
     * @param v 增加值
     * @return Double
     */
     <T> Double incrZSet( String key,  T value, Double v);

    /**
     *
     * @param key 键
     * @param hashKey hashKey
     * @return Integer
     */
    <T> Integer getHash(String key, T hashKey);
}
