package cn.ekgc.phenix.system.admin.transport;

import cn.ekgc.phenix.system.admin.pojo.vo.RoleVO;
import cn.ekgc.phenix.system.admin.pojo.vo.Router;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * <b>系统功能模块 - 系统菜单</b>
 *
 * @author JLS
 * @date 2023/2/9
 */
@FeignClient(name = "phenix-system-provider")
public interface MenuTransport {
	/**
	 * <b>根据角色信息获得路由列表</b>
	 * @param roleVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/trans/system/menu/routerlist")
	List<Router> getRouterByRole(@RequestBody RoleVO roleVO) throws Exception;
}
