package cn.ekgc.phenix.filter;

import cn.ekgc.phenix.base.pojo.vo.ResponseVO;
import cn.ekgc.phenix.base.util.BaseConstantUtil;
import cn.ekgc.phenix.base.util.RedisUtil;
import cn.ekgc.phenix.base.util.TokenUtil;
import cn.ekgc.phenix.system.admin.pojo.vo.AdminVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;



/**
 * <b></b>
 *
 * @author H
 * @date 4/2/2023
 */
@Component
public class AuthFilter implements GlobalFilter, Ordered {
	@Autowired
	private RedisUtil redisUtil;
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		//由于不是所有的Http请求需要认证，对于登陆不需要
		//获得此时http请求的URI信息
		String requestURI = exchange.getRequest().getURI().toString();
		//判断当前是不是登录
		if(requestURI.endsWith("/system/admin/login")){
			return chain.filter(exchange);
		}else {
			//登录直接放行
			//不是登录,获得toKen信息
			String token = exchange.getRequest().getHeaders().getFirst(BaseConstantUtil.BASE_TOKEN_HEADER);

			// 对Token 进行效验
			if (!TokenUtil.verifyToken(token) && redisUtil.getFormRedis(token, AdminVO.class)!= null) {
				// 该token有效进行放行
				return chain.filter(exchange);
			}
		}
		String json = "{}";
		try {
			json = new JsonMapper().writeValueAsString(ResponseVO.unauthResponseVO());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		// 将该结果以JSON 格式返回
		DataBuffer buffer =exchange.getResponse().bufferFactory().wrap(json.getBytes());
		exchange.getResponse().getHeaders().set("Content-type","application/json;charset=UTF-8");
		// 返回结果JSON
		return exchange.getResponse().writeWith(Mono.just(buffer));
	}

	@Override
	public int getOrder() {
		return Ordered.HIGHEST_PRECEDENCE;
	}
}
