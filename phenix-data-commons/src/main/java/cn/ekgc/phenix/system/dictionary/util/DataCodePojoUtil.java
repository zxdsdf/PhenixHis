package cn.ekgc.phenix.system.dictionary.util;

import cn.ekgc.phenix.system.dictionary.pojo.entity.DataCode;
import cn.ekgc.phenix.system.dictionary.pojo.vo.DataCodeVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <b></b>
 *
 * @author JLS
 * @date 2023/2/11
 */
@Mapper
public interface DataCodePojoUtil {
	DataCodePojoUtil INSTANCE = Mappers.getMapper(DataCodePojoUtil.class);
	@Mapping(source = "parentVO.id",target = "parent")
	public DataCode parseVOToEntity(DataCodeVO queryVO);
	@Mapping(source = "parent",target = "parentVO.id")
	public DataCodeVO parseEntityToVO(DataCode query);
	@Mapping(source = "parent",target = "parentVO.id")
	public List<DataCodeVO> list (List<DataCode> queryList);
}
