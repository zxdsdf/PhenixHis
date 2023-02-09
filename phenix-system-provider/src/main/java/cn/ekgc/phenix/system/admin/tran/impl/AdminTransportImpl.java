package cn.ekgc.phenix.system.admin.tran.impl;


import cn.ekgc.phenix.system.admin.pojo.vo.AdminVO;
import cn.ekgc.phenix.system.admin.service.AdminService;
import cn.ekgc.phenix.system.admin.transport.AdminTransport;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController("adminTransport")
@RequestMapping("/trans/system/admin")
public class AdminTransportImpl implements AdminTransport {

	@Resource(name = "adminService")
	private AdminService adminService;

	@PostMapping("/login")
	public AdminVO getVoByCellphone(@RequestParam String cellphone) throws Exception {

		return adminService.getVoByCellphone(cellphone);
	}
}
