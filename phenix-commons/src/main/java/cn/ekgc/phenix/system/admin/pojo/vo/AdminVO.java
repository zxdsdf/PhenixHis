package cn.ekgc.phenix.system.admin.pojo.vo;


import cn.ekgc.phenix.base.pojo.vo.BaseVO;
import lombok.Data;

import java.util.List;

/**
 * <b>管理员试图信息</b>
 *
 * @author H
 * @date 31/1/2023
 */
@Data
public class AdminVO extends BaseVO {
	private static final long serialVersionUID = 9107233584850458486L;
	private String id;//主键
	private String name; // 姓名
	private String no;//工号
	private String cellphone;//手机号
	private String password;//密码
	private RoleVO roleVO;   // 管理员角色
	private List<Router> routerList;    // 管理员功能路由列表
}
