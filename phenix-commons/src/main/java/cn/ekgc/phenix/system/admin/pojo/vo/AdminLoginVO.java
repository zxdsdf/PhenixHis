package cn.ekgc.phenix.system.admin.pojo.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * <b>管理员登录试图信息</b>
 *
 * @author H
 * @date 31/1/2023
 */
@Data
public class AdminLoginVO implements Serializable {
	private static final long serialVersionUID = 7692345530706352283L;
	@NotNull
	@Pattern(regexp = "1[0-9]{10}")
	private String cellphone;
	@NotNull
	@Pattern(regexp = "(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,15}")
	private String password;
}
