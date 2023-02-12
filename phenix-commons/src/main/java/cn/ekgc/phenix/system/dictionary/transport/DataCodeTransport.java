package cn.ekgc.phenix.system.dictionary.transport;

import cn.ekgc.phenix.base.pojo.vo.PageVO;
import cn.ekgc.phenix.base.pojo.vo.QueryPageVO;
import cn.ekgc.phenix.system.dictionary.pojo.vo.DataCodeVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <b></b>
 *
 * @author JLS
 * @date 2023/2/11
 */
@FeignClient(name="phenix-system-provider")
public interface DataCodeTransport {
	/**
	 * <b>分页查询</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/trans/system/data/code/page")
	PageVO<DataCodeVO> pageHelperToVO(@RequestBody QueryPageVO<DataCodeVO> query) throws Exception;
	/**
	 * <b>根据查询视图获得列表信息</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/trans/system/data/code/queryList")
	List<DataCodeVO> queryList(@RequestBody DataCodeVO queryVO) throws Exception;

	/**
	 * <b>根据id获得视图信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/trans/system/data/code/id")
	DataCodeVO queryById(@RequestParam Long id) throws Exception;
	/**
	 * <b>根据code获得视图信息</b>
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/trans/system/data/code/code")
	DataCodeVO queryByCode(@RequestParam String code) throws Exception;
	/**
	 * <b>添加用户视图</b>
	 * @param insertVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/trans/system/data/code/insert")
	boolean insertVO(@RequestBody DataCodeVO insertVO) throws Exception;
	/**
	 * <b>修改用户信息</b>
	 * @param updateVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/trans/system/data/code/update")
	boolean updateVO(DataCodeVO updateVO) throws Exception;
	/**
	 * <b>修改系统状态</b>
	 * @param id
	 * @param status
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/trans/system/data/code/status")
	boolean changeStatusById(Long id, String status) throws Exception;
}
