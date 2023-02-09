package cn.ekgc.phenix.system.dictionary.transport;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * <b>系统功能模块 - 系统字典传输层接口</b>
 *
 * @author JLS
 * @date 2023/2/7
 */
@FeignClient(name="phenix-system-provider")
public interface DictionaryTransport {
}
