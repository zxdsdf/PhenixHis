package cn.ekgc.phenix.system.dicionary.tran.impl;

import cn.ekgc.phenix.base.pojo.vo.PageVO;
import cn.ekgc.phenix.base.pojo.vo.QueryPageVO;
import cn.ekgc.phenix.system.dicionary.service.DataCodeService;
import cn.ekgc.phenix.system.dictionary.pojo.vo.DataCodeVO;
import cn.ekgc.phenix.system.dictionary.transport.DataCodeTransport;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <b></b>
 *
 * @author JLS
 * @date 2023/2/11
 */
@RestController
@RequestMapping("/trans/system/data/code")
public class DataCodeTransImpl implements DataCodeTransport {
	@Resource(name = "dataCodeService")
	private DataCodeService dataCodeService;
	/**
	 * <b>分页查询</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	@Override
	public PageVO<DataCodeVO> pageHelperToVO(QueryPageVO<DataCodeVO> query) throws Exception {
		return dataCodeService.pageHelperToVO(query.getQuery(),query.getPageVO());
	}
	/**
	 * <b>根据查询视图获得列表信息</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/queryList")
	@Override
	public List<DataCodeVO> queryList(DataCodeVO queryVO) throws Exception {
		return dataCodeService.queryListByVO(queryVO);
	}
	/**
	 * <b>根据id获得视图信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	@Override
	public DataCodeVO queryById(Long id) throws Exception {
		return dataCodeService.queryById(id);
	}
	/**
	 * <b>根据code获得视图信息</b>
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/code")
	@Override
	public DataCodeVO queryByCode(String code) throws Exception {
		return dataCodeService.queryByCode(code);
	}
	/**
	 * <b>添加用户视图</b>
	 * @param insertVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/insert")
	@Override
	public boolean insertVO(DataCodeVO insertVO) throws Exception {

		return dataCodeService.insertVO(insertVO);
	}
	/**
	 * <b>修改用户信息</b>
	 * @param updateVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	@Override
	public boolean updateVO(DataCodeVO updateVO) throws Exception {
		return dataCodeService.updateVO(updateVO);
	}
	/**
	 * <b>修改系统状态</b>
	 * @param id
	 * @param status
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/status")
	@Override
	public boolean changeStatusById(Long id, String status) throws Exception {
		return dataCodeService.changeStatusById(id,status);
	}
}
