package cn.ekgc.phenix.system.admin.pojo.entity;

import cn.ekgc.phenix.base.pojo.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * <b>系统功能模块 - 管理员实体信息</b>
 *
 * @author JLS
 * @date 2023/2/6
 */
@Data
@TableName("sys_admin")
public class Admin extends BaseEntity {
	private static final long serialVersionUID = -1457351697231132630L;
	@TableId(type = IdType.AUTO)
	private String id;//主键
	private String no;
	private  String name;
	private String cellphone;//手机号
	private String password;//密码
}
