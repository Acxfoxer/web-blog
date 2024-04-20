package com.lee.onstage.service.impl;

import com.lee.onstage.service.BlogRedisService;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
@SuppressWarnings("all")
public class BlogRedisServiceImpl implements BlogRedisService {
    @Resource
    RedisTemplate<String,Object> redisTemplate;
    /**
     * 缓存基本的对象，Integer、String、实体类等
     *
     * @param key   缓存的键值
     * @param value 缓存的值
     */
    @Override
    public <T> void setCacheObject(String key, T value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 缓存基本的对象，Integer、String、实体类等
     *
     * @param key      缓存的键值
     * @param value    缓存的值
     * @param timeout  时间
     * @param timeUnit 时间颗粒度
     */
    @Override
    public <T> void setCacheObject(String key, T value, Integer timeout, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value, timeout, timeUnit);
    }

    /**
     * 设置有效时间
     *
     * @param key     Redis键
     * @param timeout 超时时间
     * @return true=设置成功；false=设置失败
     */
    @Override
    public boolean expire(String key, long timeout) {
        return expire(key, timeout, TimeUnit.SECONDS);
    }

    /**
     * 设置有效时间
     *
     * @param key     Redis键
     * @param timeout 超时时间
     * @param unit    时间单位
     * @return true=设置成功；false=设置失败
     */
    @Override
    public boolean expire(String key, long timeout, TimeUnit unit) {
        return Boolean.TRUE.equals(redisTemplate.expire(key, timeout, unit));
    }

    /**
     * 获得缓存的基本对象。
     *
     * @param key 缓存键值
     * @return 缓存键值对应的数据
     */
    @Override
    public <T> T getCacheObject(String key) {
        return (T)redisTemplate.opsForValue().get(key);
    }

    /**
     * 删除单个对象
     *
     * @param key key
     */
    @Override
    public Boolean deleteObject(String key) {
        return Boolean.TRUE.equals(redisTemplate.delete(key));
    }

    /**
     * 删除集合对象
     *
     * @param keys 多个对象
     * @return long
     */
    @Override
    public Long deleteObject(List<String> keys) {
        return redisTemplate.delete(keys);
    }

    /**
     * 缓存List数据
     *
     * @param key      缓存的键值
     * @param dataList 待缓存的List数据
     * @return 缓存的对象
     */
    @Override
    public <T> Long setCacheList(String key, List<T> dataList) {
        return redisTemplate.opsForList().rightPushAll(key, dataList);
    }

    /**
     * 获得缓存的list对象
     *
     * @param key 缓存的键值
     * @return 缓存键值对应的数据
     */
    @Override
    public <T> List<T> getCacheList(String key) {
        return (List<T>) redisTemplate.opsForList().range(key, 0, -1);
    }

    /**
     * 缓存Set集合数据
     *
     * @param key     缓存键值
     * @param dataSet 缓存的数据
     * @return 缓存数据的对象
     */
    @Override
    public <T> BoundSetOperations<String, T> setCacheSet(String key, Set<T> dataSet) {
        BoundSetOperations<String, Object> setOperation = redisTemplate.boundSetOps(key);
        Iterator<T> it = dataSet.iterator();
        while (it.hasNext())
        {
            setOperation.add(it.next());
        }
        return (BoundSetOperations<String, T>) setOperation;
    }

    /**
     * 缓存Set集合数据
     *
     * @param key    缓存键值
     * @param values 缓存的数据
     * @return 缓存数据的对象
     */
    @Override
    public <T> void setSet(String key, T... values) {
        redisTemplate.opsForSet().add(key, values);
    }

    /**
     * 获得缓存的set
     *
     * @param key
     * @return
     */
    @Override
    public <T> Set<T> getCacheSet(String key) {
        return (Set<T>) redisTemplate.opsForSet().members(key);
    }

    /**
     * 从缓存中获取对象
     *
     * @param key
     * @return
     */
    @Override
    public <T> T getObject(String key) {
        return (T)redisTemplate.opsForValue().get(key);
    }

    /**
     * 设置缓存
     *
     * @param key
     * @param value
     */
    @Override
    public <T> void setObject(String key, T value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 添加zset类型缓存
     *
     * @param key
     * @param value
     * @param score
     */
    @Override
    public <T> void setCacheZSet(String key, Object value, double score) {
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
    @Override
    public <T> Set<T> getCacheZSet(String key, int beginIndex, int endIndex) {
        return (Set<T>) redisTemplate.opsForZSet().reverseRange(key,beginIndex,endIndex);
    }

    /**
     * 对key的值进行原子增加
     *
     * @param key   键
     * @param delta 增长数
     * @return
     */
    @Override
    public Long incr(String key, long delta) {
        return redisTemplate.opsForValue().increment(key,delta);
    }

    /**
     * 对key的值进行原子性减少
     *
     * @param key   键
     * @param delta 减少数
     * @return
     */
    @Override
    public Long decr(String key, long delta) {
        return redisTemplate.opsForValue().decrement(key,delta);
    }

    /**
     * 获取zset的降序排列,并返回map集合
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    @Override
    public Map<Object, Double> getCacheZSetWithScore(String key, int start, int end) {
        return Objects.requireNonNull(redisTemplate.opsForZSet().rangeWithScores(key, 0, -1))
                .stream()
                .collect(Collectors.toMap(ZSetOperations.TypedTuple::getValue, ZSetOperations.TypedTuple::getScore));
    }

    /**
     * 获取zset的所有集合
     *
     * @param key
     * @return
     */
    @Override
    public Map<Object, Double> getCacheZSetWith(String key) {
        return Objects.requireNonNull(redisTemplate.opsForZSet().rangeWithScores(key, 0,-1))
                .stream()
                .collect(Collectors.toMap(ZSetOperations.TypedTuple::getValue, ZSetOperations.TypedTuple::getScore));
    }

    /**
     * @param key
     * @param value
     * @return
     */
    @Override
    public <T> T getCacheZSetScore(String key, String value) {
        return (T) redisTemplate.opsForZSet().score(key,value);
    }

    /**
     * 缓存Map
     *
     * @param key    键
     * @param object 缓存Map对象
     */
    @Override
    public <T> void setCacheMap(String key, Map<String, T> object) {
        if (object != null) {
            redisTemplate.opsForHash().putAll(key, object);
        }

    }

    /**
     * 获得缓存的Map
     *
     * @param key 值
     * @return T
     */
    @Override
    public <T> T getCacheMap(String key) {
        return (T) redisTemplate.opsForHash().entries(key);
    }

    /**
     * 往Hash中存入数据
     *
     * @param key   Redis键
     * @param hKey  Hash键
     * @param value 值
     */
    @Override
    public <T> void setCacheMapValue(String key, String hKey, T value) {
        redisTemplate.opsForHash().put(key, hKey, value);
    }

    /**
     * 获取Hash中的数据
     *
     * @param key  Redis键
     * @param hKey Hash键
     * @return Hash中的对象
     */
    @Override
    public <T> T getCacheMapValue(String key, String hKey) {
        HashOperations<String, String, T> opsForHash = redisTemplate.opsForHash();
        return opsForHash.get(key, hKey);
    }

    /**
     * 删除Hash中的数据
     *
     * @param key     健
     * @param hashKey hashKey
     */
    @Override
    public void delCacheMapValue(String key, String hashKey) {
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.delete(key, hashKey);
    }

    /**
     * 获取多个Hash中的数据
     *
     * @param key   Redis键
     * @param hKeys Hash键集合
     * @return Hash对象集合
     */
    @Override
    public <T> List<T> getMultiCacheMapValue(String key, Collection<Object> hKeys) {
        return (List<T>) redisTemplate.opsForHash().multiGet(key, hKeys);
    }

    /**
     * 获得缓存的基本对象列表
     *
     * @param pattern 字符串前缀
     * @return 对象列表
     */
    @Override
    public Set<String> keys(String pattern) {
        return redisTemplate.keys(pattern);
    }

    /**
     * 获取key对应的所有map键值对
     *
     * @param key 键
     * @return Map
     */
    @Override
    public <T> Map<String, T> getHashAll(String key) {
        HashOperations<String, String, T> stringObjectObjectHashOperations = redisTemplate.opsForHash();
        return stringObjectObjectHashOperations.entries(key);
    }

    /**
     * 查看该key 是否有值
     *
     * @param key   键
     * @param value 值
     * @return Boolean
     */
    @Override
    public <T> Boolean hasSetValue(String key, T value) {
        return redisTemplate.opsForSet().isMember(key,value);
    }

    /**
     * @param key   键
     * @param value 需要增加的对象
     * @param v     增加值
     * @return Double
     */
    @Override
    public <T> Double incrZSet(String key, T value, Double v) {
        return redisTemplate.opsForZSet().incrementScore(key,value,v);
    }

    /**
     * @param key     键
     * @param hashKey hashKey
     * @return Integer
     */
    @Override
    public <T> Integer getHash(String key, T hashKey) {
        return (Integer) redisTemplate.opsForHash().get(key,hashKey);
    }
}
