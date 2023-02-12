package cn.ekgc.phenix.system.dicionary.tran.impl;

import cn.ekgc.phenix.base.pojo.vo.PageVO;
import cn.ekgc.phenix.base.pojo.vo.QueryPageVO;
import cn.ekgc.phenix.system.dicionary.service.DictionaryService;
import cn.ekgc.phenix.system.dictionary.pojo.vo.DictionaryVO;
import cn.ekgc.phenix.system.dictionary.transport.DictionaryTransport;
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
@RequestMapping("/trans/system/dic/dic")
public class DictionaryTransImpl implements DictionaryTransport {
	@Resource(name = "dictionaryService")
	private DictionaryService dictionaryService;
	/**
	 * <b>分页查询</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	@Override
	public PageVO<DictionaryVO> pageHelperToVO(QueryPageVO<DictionaryVO> query) throws Exception {
		return dictionaryService.pageHelperToVO(query.getQuery(),query.getPageVO());
	}
	/**
	 * <b>根据查询视图获得列表信息</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/queryList")
	@Override
	public List<DictionaryVO> queryList(DictionaryVO queryVO) throws Exception {
		return dictionaryService.queryListByVO(queryVO);
	}
	/**
	 * <b>根据id获得视图信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	@Override
	public DictionaryVO queryById(Long id) throws Exception {
		return dictionaryService.queryById(id);
	}
	/**
	 * <b>根据code获得视图信息</b>
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/code")
	@Override
	public DictionaryVO queryByCode(String code) throws Exception {
		return dictionaryService.queryByCode(code);
	}
	/**
	 * <b>添加用户视图</b>
	 * @param insertVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/insert")
	@Override
	public boolean insertVO(DictionaryVO insertVO) throws Exception {

		return dictionaryService.insertVO(insertVO);
	}
	/**
	 * <b>修改用户信息</b>
	 * @param updateVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	@Override
	public boolean updateVO(DictionaryVO updateVO) throws Exception {
		return dictionaryService.updateVO(updateVO);
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
		return dictionaryService.changeStatusById(id,status);
	}
}
