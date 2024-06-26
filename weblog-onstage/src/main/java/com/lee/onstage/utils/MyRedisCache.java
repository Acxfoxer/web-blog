package com.lee.onstage.utils;

import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@SuppressWarnings(value = { "unchecked", "rawtypes" })
@Component
public class MyRedisCache {
    @Resource
    private  RedisTemplate<String,Object> redisTemplate;

    /**
     * 缓存基本的对象，Integer、String、实体类等
     *
     * @param key 缓存的键值
     * @param value 缓存的值
     */
    public <T> void setCacheObject(final String key, final T value)
    {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 缓存基本的对象，Integer、String、实体类等
     *
     * @param key 缓存的键值
     * @param value 缓存的值
     * @param timeout 时间
     * @param timeUnit 时间颗粒度
     */
    public <T> void setCacheObject(final String key, final T value, final Integer timeout, final TimeUnit timeUnit)
    {
        redisTemplate.opsForValue().set(key, value, timeout, timeUnit);
    }

    /**
     * 设置有效时间
     *
     * @param key Redis键
     * @param timeout 超时时间
     * @return true=设置成功；false=设置失败
     */
    public boolean expire(final String key, final long timeout)
    {
        return expire(key, timeout, TimeUnit.SECONDS);
    }

    /**
     * 设置有效时间
     *
     * @param key Redis键
     * @param timeout 超时时间
     * @param unit 时间单位
     * @return true=设置成功；false=设置失败
     */
    public boolean expire(final String key, final long timeout, final TimeUnit unit)
    {
        return Boolean.TRUE.equals(redisTemplate.expire(key, timeout, unit));
    }

    /**
     * 获得缓存的基本对象。
     *
     * @param key 缓存键值
     * @return 缓存键值对应的数据
     */
    public <T> Object getCacheObject(final String key)
    {
        ValueOperations<String, Object> operation = redisTemplate.opsForValue();
        return operation.get(key);
    }

    /**
     * 删除单个对象
     *
     * @param key
     */
    public boolean deleteObject(final String key)
    {
        return Boolean.TRUE.equals(redisTemplate.delete(key));
    }

    /**
     * 删除集合对象
     *
     * @param collection 多个对象
     * @return
     */
    public long deleteObject(final Collection collection)
    {
        return redisTemplate.delete(collection);
    }

    /**
     * 缓存List数据
     *
     * @param key 缓存的键值
     * @param dataList 待缓存的List数据
     * @return 缓存的对象
     */
    public <T> long setCacheList(final String key, final List<T> dataList)
    {
        Long count = redisTemplate.opsForList().rightPushAll(key, dataList);
        return count == null ? 0 : count;
    }

    /**
     * 获得缓存的list对象
     *
     * @param key 缓存的键值
     * @return 缓存键值对应的数据
     */
    public <T> List<Object> getCacheList(final String key)
    {
        return redisTemplate.opsForList().range(key, 0, -1);
    }

    /**
     * 缓存Set集合数据
     *
     * @param key 缓存键值
     * @param dataSet 缓存的数据
     * @return 缓存数据的对象
     */
    public <T> BoundSetOperations<String, Object> setCacheSet(final String key, final Set<T> dataSet)
    {
        BoundSetOperations<String, Object> setOperation = redisTemplate.boundSetOps(key);
        Iterator<T> it = dataSet.iterator();
        while (it.hasNext())
        {
            setOperation.add(it.next());
        }
        return setOperation;
    }
    public <T> void setSet(String key, T... values){
        redisTemplate.opsForSet().add(key, values);
    }
    /**
     * 获得缓存的set
     *
     * @param key
     * @return
     */
    public <T> Set<Object> getCacheSet(final String key)
    {
        return redisTemplate.opsForSet().members(key);
    }

    /**
     * 从缓存中获取对象
     * @param key
     * @return
     * @param <T>
     */
    public <T> T getObject(String key){
        return (T)redisTemplate.opsForValue().get(key);
    }

    /**
     * 设置缓存
     * @param key
     * @param value
     * @param <T>
     */
    public <T> void setObject(String key, T value) {
        redisTemplate.opsForValue().set(key, value);
    }
    /**
     * 添加zset类型缓存
     * @param key
     * @param value
     * @param score
     * @param <T>
     */
    public <T> void setCacheZSet(final @NotNull String key, @NotNull Object value, @NotNull double score){
        redisTemplate.opsForZSet().add(key, value, score);
    }

    /**
     * 获取zset的降序排列
     *
     * @param key
     * @param beginIndex
     * @param endIndex
     * @return
     */
    public Set<Object> getCacheZSet(final String key, int beginIndex, int endIndex)
    {
        return redisTemplate.opsForZSet().reverseRange(key,beginIndex,endIndex);
    }



    /**
     * 对key的值进行原子增加
     * @param key   键
     * @param delta 增长数
     * @return
     */
    public Long incr(String key,long delta){
        return redisTemplate.opsForValue().increment(key,delta);
    }

    /**
     * 对key的值进行原子性减少
     * @param key   键
     * @param delta 减少数
     * @return
     */
    public Long decr(String key,long delta){
        return redisTemplate.opsForValue().decrement(key,delta);
    }
    /**
     * 获取zset的降序排列,并返回map集合
     * @param key
     * @param start
     * @param end
     * @return
     */
    public <T> Map<Object,Double> getCacheZSetWithScore(final String key,int start,int end){
        return Objects.requireNonNull(redisTemplate.opsForZSet().rangeWithScores(key, start, end))
                .stream()
                .collect(Collectors.toMap(ZSetOperations.TypedTuple::getValue, ZSetOperations.TypedTuple::getScore));
    }

    /**
     * 获取zset的所有集合
     * @param key
     * @return
     * @param <T>
     */
    public <T> Map<Object,Double> getCacheZSetWith(final String key){
        return Objects.requireNonNull(redisTemplate.opsForZSet().rangeWithScores(key, 0,-1))
                .stream()
                .collect(Collectors.toMap(ZSetOperations.TypedTuple::getValue, ZSetOperations.TypedTuple::getScore));
    }

    public Double getCacheZSetScore(final String key, final String value){
        return redisTemplate.opsForZSet().score(key,value);
    }

    /**
     * 缓存Map
     * @param key
     * @param dataMap
     */
    public <T> void setCacheMap(final String key, final Map<String, T> dataMap)
    {
        if (dataMap != null) {
            redisTemplate.opsForHash().putAll(key, dataMap);
        }
    }

    /**
     * 获得缓存的Map
     *
     * @param key
     * @return
     */
    public <T> Map getCacheMap(final String key)
    {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * 往Hash中存入数据
     *
     * @param key Redis键
     * @param hKey Hash键
     * @param value 值
     */
    public <T> void setCacheMapValue(final String key, final String hKey, final T value)
    {
        redisTemplate.opsForHash().put(key, hKey, value);
    }

    /**
     * 获取Hash中的数据
     *
     * @param key Redis键
     * @param hKey Hash键
     * @return Hash中的对象
     */
    public <T> T getCacheMapValue(final String key, final String hKey)
    {
        HashOperations<String, String, T> opsForHash = redisTemplate.opsForHash();
        return opsForHash.get(key, hKey);
    }

    /**
     * 删除Hash中的数据
     *
     * @param key
     * @param hkey
     */
    public void delCacheMapValue(final String key, final String hkey)
    {
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.delete(key, hkey);
    }

    /**
     * 获取多个Hash中的数据
     *
     * @param key Redis键
     * @param hKeys Hash键集合
     * @return Hash对象集合
     */
    public <T> List<Object> getMultiCacheMapValue(final String key, final Collection<Object> hKeys)
    {
        return redisTemplate.opsForHash().multiGet(key, hKeys);
    }

    /**
     * 获得缓存的基本对象列表
     *
     * @param pattern 字符串前缀
     * @return 对象列表
     */
    public Collection<String> keys(final String pattern)
    {
        return redisTemplate.keys(pattern);
    }

    /**
     *获取key对应的所有map键值对
     *
     * @param key
     * @return
     */
    public <T> Map<String,T> getHashAll(String key) {
        HashOperations<String, String, T> stringObjectObjectHashOperations = redisTemplate.opsForHash();
        return stringObjectObjectHashOperations.entries(key);
    }

    /**
     * 查看该key 是否有值
     * @param key
     * @param value
     * @return
     * @param <T>
     */
    public <T> Boolean hasSetValue(String key,T value){
        return redisTemplate.opsForSet().isMember(key,value);
    }

    public <T> Double incrZSet(@NotNull String key, @NotNull T value,@NotNull double v) {
        return redisTemplate.opsForZSet().incrementScore(key,value,v);
    }

    public  <T> Integer getHash(String key, String id) {
        return (Integer) redisTemplate.opsForHash().get(key,id);
    }
}
