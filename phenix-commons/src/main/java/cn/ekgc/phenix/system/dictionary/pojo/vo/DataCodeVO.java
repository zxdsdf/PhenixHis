package cn.ekgc.phenix.system.dictionary.pojo.vo;

import cn.ekgc.phenix.base.pojo.vo.BaseVO;
import lombok.Data;

/**
 * <b>系统功能模块-数据元值域视图信息</b>
 *
 * @author JLS
 * @date 2023/2/7
 */
@Data
public class DataCodeVO extends BaseVO {
	private static final long serialVersionUID = -3135678050686888804L;
	private Long id;
	private DataCodeVO parentVO;    // 上级数据元
	private String code;    // 数据元值域
	private String text;    // 数据元值域文本
	private String remark;  // 数据元值域说明
}
