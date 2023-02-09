package cn.ekgc.phenix.system.admin.controller;

import cn.ekgc.phenix.base.pojo.enums.StatusUtil;
import cn.ekgc.phenix.base.pojo.vo.ResponseVO;
import cn.ekgc.phenix.base.util.BaseConstantUtil;
import cn.ekgc.phenix.base.util.RedisUtil;
import cn.ekgc.phenix.base.util.TokenUtil;
import cn.ekgc.phenix.system.admin.pojo.vo.AdminLoginVO;
import cn.ekgc.phenix.system.admin.pojo.vo.AdminVO;
import cn.ekgc.phenix.system.admin.pojo.vo.Router;
import cn.ekgc.phenix.system.admin.transport.AdminTransport;
import cn.ekgc.phenix.system.admin.transport.MenuTransport;
import cn.hutool.crypto.digest.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController("adminController")
@RequestMapping("system/admin")
@CrossOrigin
public class AdminController {
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private AdminTransport adminTransport;
	@Autowired
	private MenuTransport menuTransport;
	@Autowired
	private RedisUtil redisUtil;
	@PostMapping("/login")
	public ResponseVO loginAdmin(@RequestBody@Validated AdminLoginVO adminLoginVO,
	                             BindingResult bindingResult)
			throws Exception{
		// 效验验证信息
		if (bindingResult.hasErrors()) {
			return ResponseVO.failureResponseVO(bindingResult);
		}
		AdminVO adminVO = adminTransport.getVoByCellphone(adminLoginVO.getCellphone());
		if (adminVO == null) {
			return ResponseVO.failureResponseVO("手机号码或登陆密码错误");
		}
		if (!adminVO.getPassword().equals(MD5.create()
				.digestHex(adminLoginVO.getPassword()))) {
			return ResponseVO.failureResponseVO("手机号码或登陆密码错误");
		}
		// 判断账号是否是禁用状态
		if (StatusUtil.STATUS_DISABLE.equals(adminVO.getStatus())) {
			return ResponseVO.failureResponseVO("该账号处于禁用状态");
		}
		// 此用户登录成功，使用当前登录用户创建Token 信息
		String token = TokenUtil.createToken(adminVO, BaseConstantUtil.BASE_TOKEN_EXPIRE);
		// 将生成的Token 作为key 存储到Redis中
		redisUtil.saveToRedis(token,adminVO,BaseConstantUtil.BASE_TOKEN_EXPIRE);

		return ResponseVO.successResponseVO("登录成功",token);
	}
	@GetMapping("/info")
	public ResponseVO checkAdmin() throws Exception{
		String token = request.getHeader(BaseConstantUtil.BASE_TOKEN_HEADER);
		AdminVO adminVO = (AdminVO) redisUtil.getFormRedis(token, AdminVO.class);
		// 根据当前登录用户信息，获得该用户角色对应的菜单
		List<Router> routerList = menuTransport.getRouterByRole(adminVO.getRoleVO());
		// 将查询到的该用户对应角色功能路由列表设置到用户
		adminVO.setRouterList(routerList);
		return ResponseVO.successResponseVO("获得用户信息成功",adminVO);
	}
}
