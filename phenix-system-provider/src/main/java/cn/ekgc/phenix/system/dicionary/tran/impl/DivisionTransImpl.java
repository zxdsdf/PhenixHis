package cn.ekgc.phenix.system.dicionary.tran.impl;

import cn.ekgc.phenix.base.pojo.vo.PageVO;
import cn.ekgc.phenix.base.pojo.vo.QueryPageVO;
import cn.ekgc.phenix.system.dicionary.service.DivisionService;
import cn.ekgc.phenix.system.dictionary.pojo.vo.DivisionVO;
import cn.ekgc.phenix.system.dictionary.transport.DivisionTransport;
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
@RequestMapping("/trans/system/div/div")
public class DivisionTransImpl implements DivisionTransport {
	@Resource(name = "divisionService")
	private DivisionService divisionService;
	/**
	 * <b>分页查询</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	@Override
	public PageVO<DivisionVO> pageHelperToVO(QueryPageVO<DivisionVO> query) throws Exception {
		return divisionService.pageHelperToVO(query.getQuery(),query.getPageVO());
	}
	/**
	 * <b>根据查询视图获得列表信息</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/queryList")
	@Override
	public List<DivisionVO> queryList(DivisionVO queryVO) throws Exception {
		return divisionService.queryListByVO(queryVO);
	}
	/**
	 * <b>根据id获得视图信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	@Override
	public DivisionVO queryById(Long id) throws Exception {
		return divisionService.queryById(id);
	}
	/**
	 * <b>根据code获得视图信息</b>
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/code")
	@Override
	public DivisionVO queryByCode(String code) throws Exception {
		return divisionService.queryByCode(code);
	}
	/**
	 * <b>添加用户视图</b>
	 * @param insertVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/insert")
	@Override
	public boolean insertVO(DivisionVO insertVO) throws Exception {

		return divisionService.insertVO(insertVO);
	}
	/**
	 * <b>修改用户信息</b>
	 * @param updateVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	@Override
	public boolean updateVO(DivisionVO updateVO) throws Exception {
		return divisionService.updateVO(updateVO);
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
		return divisionService.changeStatusById(id,status);
	}
}
