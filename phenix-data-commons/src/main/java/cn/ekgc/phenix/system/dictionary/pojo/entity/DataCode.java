package cn.ekgc.phenix.system.dictionary.pojo.entity;

import cn.ekgc.phenix.base.pojo.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * <b>系统功能模块-数据元值域实体信息</b>
 *
 * @author JLS
 * @date 2023/2/7
 */
@Data
@TableName("sys_data_code")
public class DataCode extends BaseEntity {
	private static final long serialVersionUID = 585861961714240968L;
	@TableId(type = IdType.AUTO)
	private Long id;
	private Long parent;    // 上级数据元
	private String code;    // 数据元值域
	private String text;    // 数据元值域文本
	private String remark;  // 数据元值域说明
}
