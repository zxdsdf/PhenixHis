package cn.ekgc.phenix.system.admin.pojo.vo;

import cn.ekgc.phenix.base.pojo.vo.BaseVO;
import lombok.Data;

/**
 * <b></b>
 *
 * @author JLS
 * @date 2023/2/7
 */
@Data
public class RoleVO extends BaseVO {
	private static final long serialVersionUID = 3561825095414587414L;
	private Long id;//主键（自增长）
	private String code;    // 角色编码
	private String name;//角色名称
}
