package cn.ekgc.phenix.system.admin.transport;

import cn.ekgc.phenix.system.admin.pojo.vo.AdminVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <b></b>
 *
 * @author JLS
 * @date 2023/2/7
 */
@FeignClient(name = "phenix-system-provider")
public interface AdminTransport {
	@PostMapping("/trans/system/admin/login")
	AdminVO getVoByCellphone(@RequestParam String cellphone) throws Exception;
}
