package cn.ekgc.phenix.system.admin.service.impl;

import cn.ekgc.phenix.system.admin.pojo.vo.RoleVO;
import cn.ekgc.phenix.system.admin.pojo.vo.Router;
import cn.ekgc.phenix.system.admin.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <b></b>
 *
 * @author JLS
 * @date 2023/2/9
 */
@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {
	@Override
	public List<Router> getRouterByRole(RoleVO roleVO) throws Exception {
		return null;
	}
}
