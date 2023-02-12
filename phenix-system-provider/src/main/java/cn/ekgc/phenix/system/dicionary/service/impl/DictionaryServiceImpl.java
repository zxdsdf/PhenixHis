package cn.ekgc.phenix.system.dicionary.service.impl;

import cn.ekgc.phenix.base.pojo.vo.PageVO;
import cn.ekgc.phenix.system.dicionary.dao.DictionaryDao;
import cn.ekgc.phenix.system.dicionary.service.DictionaryService;
import cn.ekgc.phenix.system.dictionary.pojo.entity.Dictionary;
import cn.ekgc.phenix.system.dictionary.pojo.vo.DictionaryVO;
import cn.ekgc.phenix.system.dictionary.util.DictionaryPojoUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <b>字典业务层实现类</b>
 *
 * @author JLS
 * @date 2023/2/11
 */
@Service("dictionaryService")
@Transactional
public class DictionaryServiceImpl implements DictionaryService {
	@Autowired
	private DictionaryDao dictionaryDao;
	/**
	 * <b>分页查询</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageVO<DictionaryVO> pageHelperToVO(DictionaryVO queryVO, PageVO<DictionaryVO> pageVO) throws Exception {
		QueryWrapper<Dictionary> qw = new QueryWrapper<Dictionary>(DictionaryPojoUtil.INSTANCE.parseVOToEntity(queryVO));
		PageHelper.startPage(pageVO.getPageNum(),pageVO.getPageSize());
		List<Dictionary> list = dictionaryDao.selectList(qw);
		PageInfo<Dictionary> pageInfo = new PageInfo<Dictionary>(list);
		pageVO.setList(DictionaryPojoUtil.INSTANCE.list(pageInfo.getList()));
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
	public List<DictionaryVO> queryListByVO(DictionaryVO queryVO) throws Exception {
		QueryWrapper<Dictionary> qw = new QueryWrapper<Dictionary>(DictionaryPojoUtil.INSTANCE.parseVOToEntity(queryVO));
		List<Dictionary> list = dictionaryDao.selectList(qw);

		return DictionaryPojoUtil.INSTANCE.list(list);
	}
	/**
	 * <b>根据id获得视图信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public DictionaryVO queryById(Long id) throws Exception {
		QueryWrapper<Dictionary> qw = new QueryWrapper<Dictionary>();
		qw.eq("id", id);

		return DictionaryPojoUtil.INSTANCE.parseEntityToVO(
				dictionaryDao.selectOne(qw));
	}
	/**
	 * <b>根据code获得视图信息</b>
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@Override
	public DictionaryVO queryByCode(String code) throws Exception {
		QueryWrapper<Dictionary> qw = new QueryWrapper<Dictionary>();
		qw.eq("code", code);

		return DictionaryPojoUtil.INSTANCE.parseEntityToVO(
				dictionaryDao.selectOne(qw));
	}
	/**
	 * <b>添加用户视图</b>
	 * @param insertVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean insertVO(DictionaryVO insertVO) throws Exception {
		Dictionary query = DictionaryPojoUtil.INSTANCE.parseVOToEntity(insertVO);

		return dictionaryDao.insert(query) > 0;
	}
	/**
	 * <b>修改用户信息</b>
	 * @param updateVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean updateVO(DictionaryVO updateVO) throws Exception {
		Dictionary query = DictionaryPojoUtil.INSTANCE.parseVOToEntity(updateVO);

		return dictionaryDao.updateById(query)>0;
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
		Dictionary query = new Dictionary();
		query.setId(id);
		query.setStatus(status);
		return dictionaryDao.updateById(query)>0;
	}
}
