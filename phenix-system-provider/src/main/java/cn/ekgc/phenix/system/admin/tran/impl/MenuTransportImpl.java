package cn.ekgc.phenix.system.admin.tran.impl;

import cn.ekgc.phenix.system.admin.pojo.vo.RoleVO;
import cn.ekgc.phenix.system.admin.pojo.vo.Router;
import cn.ekgc.phenix.system.admin.service.MenuService;
import cn.ekgc.phenix.system.admin.transport.MenuTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b></b>
 *
 * @author JLS
 * @date 2023/2/9
 */
@RestController
@RequestMapping("/trans/system/menu")
public class MenuTransportImpl implements MenuTransport {
	@Autowired
	private MenuService menuService;
	/**
	 * <b>根据角色视图信息获得对应的路由列表</b>
	 * @param roleVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/routerlist")
	@Override
	public List<Router> getRouterByRole(@RequestBody RoleVO roleVO) throws Exception {
		return menuService.getRouterByRole(roleVO);
	}
}
