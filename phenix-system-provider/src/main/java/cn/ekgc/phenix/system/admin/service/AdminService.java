package cn.ekgc.phenix.system.admin.service;


import cn.ekgc.phenix.system.admin.pojo.vo.AdminVO;

public interface AdminService {

	AdminVO getVoByCellphone(String cellphone) throws Exception;
}
