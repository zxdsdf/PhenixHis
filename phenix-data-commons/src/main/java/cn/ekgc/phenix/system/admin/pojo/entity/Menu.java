package cn.ekgc.phenix.system.admin.pojo.entity;

import cn.ekgc.phenix.base.pojo.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * <b></b>
 *
 * @author JLS
 * @date 2023/2/7
 */
@Data
@TableName("sys_menu")
public class Menu extends BaseEntity {
	private static final long serialVersionUID = 1720935219941181169L;
	@TableId(type = IdType.AUTO)
	private Long id;
	private Long parent;
	private String name;        // 路由名称
	private String component;   // Vue组件名
	private String path;        // 路由链接地址
	private String title;      // 菜单文本
	private String icon;        // 菜单图标
	private Long order;         // 顺序
}
