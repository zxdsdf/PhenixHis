package cn.ekgc.phenix.system.admin.pojo.vo;


import cn.ekgc.phenix.base.pojo.vo.BaseVO;
import lombok.Data;

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
	private String no;//工号
	private String cellphone;//手机号
	private String password;//密码
}
