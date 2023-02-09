package cn.ekgc.phenix.system.admin.dao;

import cn.ekgc.phenix.system.admin.pojo.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <b></b>
 *
 * @author JLS
 * @date 2023/2/9
 */
@Repository
public interface MenuDao extends BaseMapper<Menu> {
	/**
	 * <b>根据查询信息查询角色信息</b>
	 * @param params
	 * @return
	 * @throws Exception
	 */
	List<Menu> findMenuListForRole(Map<String,Object> params) throws Exception;
}
