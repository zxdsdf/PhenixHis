package cn.ekgc.phenix.base.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <b>Token 操作工具类</b>
 *
 * @author JLS
 * @date 2023/2/6
 */
@Component("tokenUtil")
public class TokenUtil {
	// 设置加密Token 时所使用的算法
	private static final Algorithm ALGORITHM = Algorithm.HMAC256(BaseConstantUtil.BASE_SECRET);
	public static final Map<String, Object> header = new HashMap<String, Object>();
	public static final String PAYLOAD_KEY = "payload";
	static {
		// 使用静态代码块设置头部信息
		header.put("alg","HS256");
		header.put("typ","JWT");
	}

	/**
	 * <b>根据所给定有效载荷和存储时长，创建 Token</b>
	 * @param payload
	 * @param expireSec
	 * @return
	 */
	public static String createToken(Object payload, Long expireSec) {
		JWTCreator.Builder builder = JWT.create();
		// 设置头部信息
		builder.withHeader(header);
		// 设置有效载荷信息
		JsonMapper jsonMapper = new JsonMapper();
		try {
			String json = jsonMapper.writeValueAsString(payload);
			// 将已经转换为JSON 格式的数据存入到Token 有效载荷部分
			builder.withClaim(PAYLOAD_KEY,json);

			// 设置 Token 生成的有效时长
			if (expireSec != null && expireSec > 0) {
				// 所给定的时间有效，那么换算对应的java.util.Date
				Date expireDate = new Date(new Date().getTime() + expireSec * 1000);
				// 设置过期时间
				builder.withExpiresAt(expireDate);
				return builder.sign(ALGORITHM);
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * <b>效验所给定的token信息 是否合法</b>
	 * @param token
	 * @return
	 */
	public static boolean verifyToken(String token) {
		// 判断所给定的Token 是否有效
		if (token != null && !"".equals(token)) {
			JWTVerifier verifier = JWT.require(ALGORITHM).build();
			try {
				// 对给定的Token 进行效验解析,如果成功获得
				DecodedJWT decodedJWT = verifier.verify(token);
				if (decodedJWT != null) {
					return true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

}