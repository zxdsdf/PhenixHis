package cn.ekgc.phenix.system.dictionary.pojo.entity;

import cn.ekgc.phenix.base.pojo.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * <b>系统功能字典实体模块</b>
 *
 * @author JLS
 * @date 2023/2/7
 */
@Data
@TableName("sys_dictionary")
public class Dictionary extends BaseEntity {
	private static final long serialVersionUID = -1262463273524366275L;
	@TableId(type = IdType.AUTO)
	private Long id;
	private Long parent;    // 所属字典
	private String code;    // 字典编码
	private String text;    // 字典文本
}
