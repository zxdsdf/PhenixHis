package cn.ekgc.phenix.system.admin.service.impl;


import cn.ekgc.phenix.system.admin.dao.AdminDao;
import cn.ekgc.phenix.system.admin.pojo.entity.Admin;
import cn.ekgc.phenix.system.admin.pojo.util.AdminPojoMapper;
import cn.ekgc.phenix.system.admin.pojo.vo.AdminVO;
import cn.ekgc.phenix.system.admin.service.AdminService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao adminDao;
	@Override
	public AdminVO getVoByCellphone(String cellphone) throws Exception {
		QueryWrapper<Admin> qw = new QueryWrapper<Admin>();
		qw.eq("cellphone", cellphone);
		List<Admin> adminList = adminDao.selectList(qw);
		if (adminList != null && !adminList.isEmpty()) {
			return AdminPojoMapper.INSTANCE.parseEntityToVO(adminList.get(0));
		}
		return null;
	}
}
