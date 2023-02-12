package cn.ekgc.phenix.system.dictionary.util;

import cn.ekgc.phenix.system.dictionary.pojo.entity.Division;
import cn.ekgc.phenix.system.dictionary.pojo.vo.DivisionVO;
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
public interface DivisionPojoUtil {
	DivisionPojoUtil INSTANCE = Mappers.getMapper(DivisionPojoUtil.class);
	@Mapping(source = "parentVO.id",target = "parent")
	public Division parseVOToEntity(DivisionVO queryVO);
	@Mapping(source = "parent",target = "parentVO.id")
	public DivisionVO parseEntityToVO(Division query);
	@Mapping(source = "parent",target = "parentVO.id")
	public List<DivisionVO> list (List<Division> queryList);
}
