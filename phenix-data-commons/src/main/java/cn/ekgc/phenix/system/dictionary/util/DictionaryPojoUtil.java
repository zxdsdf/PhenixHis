package cn.ekgc.phenix.system.dictionary.util;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * <b>系统功能模块 -字典模块转换类</b>
 *
 * @author JLS
 * @date 2023/2/8
 */
@Mapper
public interface DictionaryPojoUtil {
	DictionaryPojoUtil ds = Mappers.getMapper(DictionaryPojoUtil.class);

}
