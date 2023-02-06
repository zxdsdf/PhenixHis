package cn.ekgc.phenix.base.pojo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <b>基础实体类</b>
 *
 * @author JLS
 * @date 2023/2/6
 */
@Data
public class BaseEntity implements Serializable {
	private static final long serialVersionUID = -329886326091989181L;
	private String status;         // 系统状态 0:禁用,1:启用
	private String createdBy;      // 创建人
	private Date createdTime;      // 创建时间
	private String modifiedBy;      // 修改人
	private Date modifiedTime;     // 修改时间
}
