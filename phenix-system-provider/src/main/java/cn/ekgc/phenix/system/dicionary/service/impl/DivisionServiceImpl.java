package cn.ekgc.phenix.system.dicionary.service.impl;

import cn.ekgc.phenix.base.pojo.vo.PageVO;
import cn.ekgc.phenix.system.dicionary.dao.DivisionDao;
import cn.ekgc.phenix.system.dicionary.service.DivisionService;
import cn.ekgc.phenix.system.dictionary.pojo.entity.Division;
import cn.ekgc.phenix.system.dictionary.pojo.vo.DivisionVO;
import cn.ekgc.phenix.system.dictionary.util.DivisionPojoUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <b></b>
 *
 * @author JLS
 * @date 2023/2/11
 */
@Service("divisionService")
@Transactional
public class DivisionServiceImpl implements DivisionService {
	@Autowired
	private DivisionDao divisionDao;
	/**
	 * <b>分页查询</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageVO<DivisionVO> pageHelperToVO(DivisionVO queryVO, PageVO<DivisionVO> pageVO) throws Exception {
		QueryWrapper<Division> qw = new QueryWrapper<Division>(DivisionPojoUtil.INSTANCE.parseVOToEntity(queryVO));
		PageHelper.startPage(pageVO.getPageNum(),pageVO.getPageSize());
		List<Division> list = divisionDao.selectList(qw);
		PageInfo<Division> pageInfo = new PageInfo<Division>(list);
		pageVO.setList(DivisionPojoUtil.INSTANCE.list(pageInfo.getList()));
		pageVO.setTotalCount(pageInfo.getTotal());
		pageVO.setTotalPage(pageInfo.getPages());
		return pageVO;
	}
	/**
	 * <b>根据查询视图获得列表信息</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<DivisionVO> queryListByVO(DivisionVO queryVO) throws Exception {
		QueryWrapper<Division> qw = new QueryWrapper<Division>(DivisionPojoUtil.INSTANCE.parseVOToEntity(queryVO));
		List<Division> list = divisionDao.selectList(qw);

		return DivisionPojoUtil.INSTANCE.list(list);
	}
	/**
	 * <b>根据id获得视图信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public DivisionVO queryById(Long id) throws Exception {
		QueryWrapper<Division> qw = new QueryWrapper<Division>();
		qw.eq("id", id);

		return DivisionPojoUtil.INSTANCE.parseEntityToVO(
				divisionDao.selectOne(qw));
	}
	/**
	 * <b>根据code获得视图信息</b>
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@Override
	public DivisionVO queryByCode(String code) throws Exception {
		QueryWrapper<Division> qw = new QueryWrapper<Division>();
		qw.eq("code", code);

		return DivisionPojoUtil.INSTANCE.parseEntityToVO(
				divisionDao.selectOne(qw));
	}
	/**
	 * <b>添加用户视图</b>
	 * @param insertVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean insertVO(DivisionVO insertVO) throws Exception {
		Division query = DivisionPojoUtil.INSTANCE.parseVOToEntity(insertVO);

		return divisionDao.insert(query) > 0;
	}
	/**
	 * <b>修改用户信息</b>
	 * @param updateVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean updateVO(DivisionVO updateVO) throws Exception {
		Division query = DivisionPojoUtil.INSTANCE.parseVOToEntity(updateVO);

		return divisionDao.updateById(query)>0;
	}
	/**
	 * <b>修改系统状态</b>
	 * @param id
	 * @param status
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean changeStatusById(Long id, String status) throws Exception {
		Division query = new Division();
		query.setId(id);
		query.setStatus(status);
		return divisionDao.updateById(query)>0;
	}
}
