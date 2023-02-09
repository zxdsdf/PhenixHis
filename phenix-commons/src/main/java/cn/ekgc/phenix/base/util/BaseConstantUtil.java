package cn.ekgc.phenix.base.util;

import java.io.IOException;
import java.util.Properties;

/**
 * <b>基础功能常量工具类</b>
 *
 * @author JLS
 * @date 2023/2/6
 */
public class BaseConstantUtil {
	private static Properties props = new Properties();

	static {
		// 使用静态代码块
		try {
			props.load(BaseConstantUtil.class.getClassLoader().getResourceAsStream("props.base/base.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static final String BASE_SECRET = props.getProperty("base.secret");
	public static final String BASE_TOKEN_HEADER = props.getProperty("base.token.header");
	/**
	 * <b>默认储存时间</b>
	 */
	public static final Long BASE_TOKEN_EXPIRE = Long.parseLong(props.getProperty("base.token.expire"));
}
