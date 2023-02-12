package cn.ekgc.phenix.system.dicionary.service.impl;

import cn.ekgc.phenix.base.pojo.vo.PageVO;
import cn.ekgc.phenix.system.dicionary.dao.DataCodeDao;
import cn.ekgc.phenix.system.dicionary.service.DataCodeService;
import cn.ekgc.phenix.system.dictionary.pojo.entity.DataCode;
import cn.ekgc.phenix.system.dictionary.pojo.vo.DataCodeVO;
import cn.ekgc.phenix.system.dictionary.util.DataCodePojoUtil;
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
@Service("dataCodeService")
@Transactional
public class DataCodeServiceImpl implements DataCodeService {
	@Autowired
	private DataCodeDao dataCodeDao;
	/**
	 * <b>分页查询</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageVO<DataCodeVO> pageHelperToVO(DataCodeVO queryVO, PageVO<DataCodeVO> pageVO) throws Exception {
		// 创建queryWrapper查询对象
		QueryWrapper<DataCode> query = new QueryWrapper<DataCode>(DataCodePojoUtil.INSTANCE.parseVOToEntity(queryVO));
		// 启动pageHelper
		PageHelper.startPage(pageVO.getPageNum(), pageVO.getPageSize());

		List<DataCode> list = dataCodeDao.selectList(query);
		PageInfo<DataCode> pageInfo = new PageInfo<DataCode>(list);
		pageVO.setList(DataCodePojoUtil.INSTANCE.list(pageInfo.getList()));
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
	public List<DataCodeVO> queryListByVO(DataCodeVO queryVO) throws Exception {
		QueryWrapper<DataCode> query = new QueryWrapper<DataCode>(DataCodePojoUtil.INSTANCE.parseVOToEntity(queryVO));
		List<DataCode> queryList = dataCodeDao.selectList(query);
		return DataCodePojoUtil.INSTANCE.list(queryList);
	}
	/**
	 * <b>根据id获得视图信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public DataCodeVO queryById(Long id) throws Exception {
		QueryWrapper<DataCode> query = new QueryWrapper<DataCode>();
		query.eq("id",id);

		return DataCodePojoUtil.INSTANCE.parseEntityToVO(dataCodeDao.selectOne(query));
	}
	/**
	 * <b>根据code获得视图信息</b>
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@Override
	public DataCodeVO queryByCode(String code) throws Exception {
		QueryWrapper<DataCode> query = new QueryWrapper<DataCode>();
		query.eq("code",code);

		return DataCodePojoUtil.INSTANCE.parseEntityToVO(dataCodeDao.selectOne(query));
	}
	/**
	 * <b>添加用户视图</b>
	 * @param insertVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean insertVO(DataCodeVO insertVO) throws Exception {
		DataCode query = DataCodePojoUtil.INSTANCE.parseVOToEntity(insertVO);

		return dataCodeDao.insert(query) > 0;
	}
	/**
	 * <b>修改用户信息</b>
	 * @param updateVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean updateVO(DataCodeVO updateVO) throws Exception {
		DataCode query = DataCodePojoUtil.INSTANCE.parseVOToEntity(updateVO);

		return dataCodeDao.updateById(query) > 0;
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
		DataCode query = new DataCode();
		query.setId(id);
		query.setStatus(status);
		return dataCodeDao.updateById(query) > 0;

	}
}
