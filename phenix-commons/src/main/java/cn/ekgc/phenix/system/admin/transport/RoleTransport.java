package cn.ekgc.phenix.system.admin.transport;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * <b>系统功能模块 - 管理员角色</b>
 *
 * @author JLS
 * @date 2023/2/9
 */
@FeignClient(name = "phenix-system-provider")
public interface RoleTransport {

}
