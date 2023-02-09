package cn.ekgc.phenix.system.admin.pojo.util;


import cn.ekgc.phenix.system.admin.pojo.entity.Admin;
import cn.ekgc.phenix.system.admin.pojo.vo.AdminVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminPojoMapper {
	AdminPojoMapper INSTANCE = Mappers.getMapper(AdminPojoMapper.class);
	@Mapping(source = "role",target = "roleVO.id")
	public AdminVO parseEntityToVO(Admin entity);
}
