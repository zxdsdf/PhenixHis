package cn.ekgc.phenix.system.admin.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <b></b>
 *
 * @author JLS
 * @date 2023/2/7
 */
@Data
public class Router {
	private String name;
	private String component;   // Vue 组件名
	private String path;        // 路由链接地址
	private Meta meta;          // 路由信息
	private List<Router> children;   // 二级路由列表
	public Router() {}

	public Router(String name, String component, String path, String title,String icon) {
		this.name = name;
		this.component = component;
		this.path = path;
		this.meta = new Meta(title,icon);
	}

	private class Meta implements Serializable {
		private String title;       // 菜单文本
		private String icon;        // 菜单图标

		public Meta(String title, String icon) {
			this.title = title;
			this.icon = icon;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}
		public String getIcon() {
			return icon;
		}

		public void setIcon(String icon) {
			this.icon = icon;
		}

	}
}
