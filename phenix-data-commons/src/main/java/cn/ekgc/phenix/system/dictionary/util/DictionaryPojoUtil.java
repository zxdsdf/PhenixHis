package cn.ekgc.phenix.system.dictionary.util;

import cn.ekgc.phenix.system.dictionary.pojo.entity.Dictionary;
import cn.ekgc.phenix.system.dictionary.pojo.vo.DictionaryVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <b>系统功能模块 -字典模块转换类</b>
 *
 * @author JLS
 * @date 2023/2/8
 */
@Mapper
public interface DictionaryPojoUtil {
	DictionaryPojoUtil INSTANCE = Mappers.getMapper(DictionaryPojoUtil.class);
	@Mapping(source = "parentVO.id",target = "parent")
	public Dictionary parseVOToEntity(DictionaryVO queryVO);
	@Mapping(source = "parent",target = "parentVO.id")
	public DictionaryVO parseEntityToVO(Dictionary query);
	@Mapping(source = "parent",target = "parentVO.id")
	public List<DictionaryVO> list (List<Dictionary> queryList);
}
