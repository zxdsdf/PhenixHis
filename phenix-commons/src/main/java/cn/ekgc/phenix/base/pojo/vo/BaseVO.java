package cn.ekgc.phenix.base.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <b>基础视图信息</b>
 *
 * @author JLS
 * @date 2023/2/6
 */
@Data
public class BaseVO implements Serializable {

	private static final long serialVersionUID = 5690962881734723821L;
	private String status;        // 系统状态 0:禁用,1:启用
	private Date createdTime;      // 创建时间
	private Date modifiedTime;     // 修改时间
}
