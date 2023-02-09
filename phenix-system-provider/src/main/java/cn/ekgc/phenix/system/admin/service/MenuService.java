package cn.ekgc.phenix.system.admin.service;

import cn.ekgc.phenix.system.admin.pojo.vo.RoleVO;
import cn.ekgc.phenix.system.admin.pojo.vo.Router;

import java.util.List;

/**
 * <b></b>
 *
 * @author JLS
 * @date 2023/2/9
 */
public interface MenuService {
	List<Router> getRouterByRole(RoleVO roleVO) throws Exception;
}
