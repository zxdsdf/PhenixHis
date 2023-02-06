package cn.ekgc.phenix.base.util;

import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * <b>Redis 工具类</b>
 *
 * @author JLS
 * @date 2023/2/6
 */
@Component("redisUtil")
public class RedisUtil {
	@Autowired
	private StringRedisTemplate redisTemplate;

	/**
	 * <b>将所给定的值添加到Redis</b>
	 * @param key
	 * @param value
	 * @param expireSec
	 * @return
	 * @throws Exception
	 */
	public boolean saveToRedis(String key,Object value,Long expireSec) throws Exception {
		// 创建 JsonMapper 对象，用于将Object 类型的 value,转换成 String JSON 格式数据
		JsonMapper jsonMapper = new JsonMapper();
		try {
			// 将 Object 类型的 value,转换成 String JSON 格式数据
			String valueJSON = jsonMapper.writeValueAsString(value);
			// 将数据存入到Redis 中
			redisTemplate.opsForValue().set(key, valueJSON);
			if (expireSec != null && expireSec > 0) {
				redisTemplate.expire(key,expireSec, TimeUnit.SECONDS);
			}
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * <b>根据key获取Redis中的值</b>
	 * @param key
	 * @param valueType
	 * @return
	 */
	public Object getFormRedis(String key,Class valueType) {
		// 在 Redis 中根据 key 获得对应的 JSON 格式的 value
		String jsonValue = redisTemplate.opsForValue().get(key);
		// 判断此时该数据是否存在
		if (jsonValue != null && !"".equals(jsonValue.trim())) {
			// 创建 JsonMapper 对象
			JsonMapper jsonMapper = new JsonMapper();
			// 按照给定的数据类型麻将JSON 格式的数据转换为对应的对象
			try {
				return jsonMapper.readValue(jsonValue,valueType);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * <b>根据key 删除数据</b>
	 * @param key
	 * @return
	 */
	public boolean deleteFormRedis(String key) {
		return redisTemplate.delete(key);
	}
}
