package cn.ekgc.phenix.system.dicionary.service;

import cn.ekgc.phenix.base.pojo.vo.PageVO;
import cn.ekgc.phenix.system.dictionary.pojo.vo.DataCodeVO;

import java.util.List;

/**
 * <b></b>
 *
 * @author JLS
 * @date 2023/2/11
 */
public interface DataCodeService {
	/**
	 * <b>分页查询</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	PageVO<DataCodeVO> pageHelperToVO(DataCodeVO query, PageVO<DataCodeVO> pageVO) throws Exception;

	/**
	 * <b>根据查询视图获得列表信息</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	List<DataCodeVO> queryListByVO(DataCodeVO queryVO) throws Exception;
	/**
	 * <b>根据id获得视图信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	DataCodeVO queryById(Long id) throws Exception;
	/**
	 * <b>根据code获得视图信息</b>
	 * @param code
	 * @return
	 * @throws Exception
	 */
	DataCodeVO queryByCode(String code) throws Exception;
	/**
	 * <b>添加用户视图</b>
	 * @param insertVO
	 * @return
	 * @throws Exception
	 */
	boolean insertVO(DataCodeVO insertVO) throws Exception;
	/**
	 * <b>修改用户信息</b>
	 * @param updateVO
	 * @return
	 * @throws Exception
	 */
	boolean updateVO(DataCodeVO updateVO) throws Exception;
	/**
	 * <b>修改系统状态</b>
	 * @param id
	 * @param status
	 * @return
	 * @throws Exception
	 */
	boolean changeStatusById(Long id, String status) throws Exception;
}
