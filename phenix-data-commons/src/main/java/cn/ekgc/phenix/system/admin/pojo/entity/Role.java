package cn.ekgc.phenix.system.admin.pojo.entity;


import cn.ekgc.phenix.base.pojo.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * <b>管理员角色信息</b>
 *
 * @author H
 * @date 31/1/2023
 */
@Data
@TableName("sys_role")
public class Role extends BaseEntity {

	private static final long serialVersionUID = 6774567826148463810L;
	private Long id;//主键（自增长）
	private String code;    // 角色编码
	private String name;//角色名称
}
