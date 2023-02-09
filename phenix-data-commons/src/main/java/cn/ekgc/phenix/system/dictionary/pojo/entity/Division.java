package cn.ekgc.phenix.system.dictionary.pojo.entity;

import cn.ekgc.phenix.base.pojo.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * <b>系统模块-行政区划实体信息</b>
 *
 * @author JLS
 * @date 2023/2/7
 */
@Data
@TableName("sys_division")
public class Division extends BaseEntity {
	private static final long serialVersionUID = 8536557440571912871L;
	@TableId(type = IdType.AUTO)
	private Long id;
	private Long parent;    // 上级区划
	private String code;    // 区划编码
	private String name;    // 区划名称

}

