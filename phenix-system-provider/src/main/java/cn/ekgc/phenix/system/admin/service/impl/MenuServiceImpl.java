package cn.ekgc.phenix.system.admin.service.impl;

import cn.ekgc.phenix.base.pojo.enums.StatusUtil;
import cn.ekgc.phenix.system.admin.dao.MenuDao;
import cn.ekgc.phenix.system.admin.pojo.entity.Menu;
import cn.ekgc.phenix.system.admin.pojo.vo.RoleVO;
import cn.ekgc.phenix.system.admin.pojo.vo.Router;
import cn.ekgc.phenix.system.admin.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * <b>系统模块-菜单功能</b>
 *
 * @author JLS
 * @date 2023/2/9
 */
@Service("menuService")
@Transactional
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuDao menuDao;
	@Override
	public List<Router> getRouterByRole(RoleVO roleVO) throws Exception {
		List<Router> routerList = new ArrayList<Router>();
		if (roleVO != null && roleVO.getId() != null) {
			// 创建查询参数集合
			Map<String,Object> params = new HashMap<String,Object>();
			// 设置查询参数
			params.put("role",roleVO.getId());
			params.put("status", StatusUtil.STATUS_ENABLE.getCode());
			List<Menu> menuList = menuDao.findMenuListForRole(params);
			if (menuList != null && !menuList.isEmpty()){
				// 将一级菜单转换为一级路由
				for (int i = 0; i < menuList.size();i++) {
					Menu menu = menuList.get(i);
					Router router = new Router(menu.getName(),menu.getComponent(), menu.getPath()
							,menu.getTitle(),menu.getIcon());
					params.put("parent",menu.getId());
					List<Menu> secMenuList = menuDao.findMenuListForRole(params);
					// 判断是否能够查询到二级菜单
					if (secMenuList != null && !secMenuList.isEmpty()) {
						List<Router> secRouterList = new ArrayList<Router>();
						for (int j = 0; j < secMenuList.size();j++){
							Menu secMenu = secMenuList.get(j);
							Router secRouter = new Router(menu.getName(),menu.getComponent(), menu.getPath()
									,menu.getTitle(),menu.getIcon());
							// 查询三级菜单
							params.put("parent",secMenu.getId());
							List<Menu> thirdMenuList = menuDao.findMenuListForRole(params);

							if (thirdMenuList != null && !thirdMenuList.isEmpty()) {
								List<Router> thirdRouterList = new ArrayList<Router>();
								for (int k = 0; k < thirdMenuList.size(); k++) {
									Menu thirdMenu = secMenuList.get(j);
									Router thirdRouter = new Router(menu.getName(),menu.getComponent(), menu.getPath()
											,menu.getTitle(),menu.getIcon());
									thirdRouterList.add(thirdRouter);
								}
								secRouter.setChildren(thirdRouterList);
							}
							secRouterList.add(secRouter);
						}
						router.setChildren(secRouterList);
					}
					routerList.add(router);
				}
			}
		}
		return routerList;
	}
}
