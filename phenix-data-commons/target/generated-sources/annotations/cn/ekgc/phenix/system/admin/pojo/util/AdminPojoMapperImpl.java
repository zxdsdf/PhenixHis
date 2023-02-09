package cn.ekgc.phenix.system.admin.pojo.util;

import cn.ekgc.phenix.system.admin.pojo.entity.Admin;
import cn.ekgc.phenix.system.admin.pojo.vo.AdminVO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-07T15:41:26+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_341 (Oracle Corporation)"
)
public class AdminPojoMapperImpl implements AdminPojoMapper {

    @Override
    public AdminVO parseEntityToVO(Admin entity) {
        if ( entity == null ) {
            return null;
        }

        AdminVO adminVO = new AdminVO();

        adminVO.setStatus( entity.getStatus() );
        adminVO.setCreatedTime( entity.getCreatedTime() );
        adminVO.setModifiedTime( entity.getModifiedTime() );
        adminVO.setId( entity.getId() );
        adminVO.setNo( entity.getNo() );
        adminVO.setCellphone( entity.getCellphone() );
        adminVO.setPassword( entity.getPassword() );

        return adminVO;
    }
}
