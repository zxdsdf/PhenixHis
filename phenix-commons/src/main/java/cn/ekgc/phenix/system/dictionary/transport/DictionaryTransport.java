package cn.ekgc.phenix.system.dictionary.transport;

import cn.ekgc.phenix.base.pojo.vo.PageVO;
import cn.ekgc.phenix.base.pojo.vo.QueryPageVO;
import cn.ekgc.phenix.system.dictionary.pojo.vo.DictionaryVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <b>系统功能模块 - 系统字典传输层接口</b>
 *
 * @author JLS
 * @date 2023/2/7
 */
@FeignClient(name="phenix-system-provider")
public interface DictionaryTransport {
	/**
	 * <b>分页查询</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/trans/system/dic/dic/page")
	PageVO<DictionaryVO> pageHelperToVO(@RequestBody QueryPageVO<DictionaryVO> query) throws Exception;
	/**
	 * <b>根据查询视图获得列表信息</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/trans/system/dic/dic/queryList")
	List<DictionaryVO> queryList(@RequestBody DictionaryVO queryVO) throws Exception;

	/**
	 * <b>根据id获得视图信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/trans/system/dic/dic/id")
	DictionaryVO queryById(@RequestParam Long id) throws Exception;
	/**
	 * <b>根据code获得视图信息</b>
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/trans/system/dic/dic/code")
	DictionaryVO queryByCode(@RequestParam String code) throws Exception;
	/**
	 * <b>添加用户视图</b>
	 * @param insertVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/trans/system/dic/dic/insert")
	boolean insertVO(@RequestBody DictionaryVO insertVO) throws Exception;
	/**
	 * <b>修改用户信息</b>
	 * @param updateVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/trans/system/dic/dic/update")
	boolean updateVO(DictionaryVO updateVO) throws Exception;
	/**
	 * <b>修改系统状态</b>
	 * @param id
	 * @param status
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/trans/system/dic/dic/status")
	boolean changeStatusById(Long id, String status) throws Exception;
}
