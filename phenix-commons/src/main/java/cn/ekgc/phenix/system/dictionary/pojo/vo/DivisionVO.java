package cn.ekgc.phenix.system.dictionary.pojo.vo;

import cn.ekgc.phenix.base.pojo.vo.BaseVO;
import lombok.Data;

/**
 * <b>系统模块-行政区划视图信息</b>
 *
 * @author JLS
 * @date 2023/2/7
 */
@Data
public class DivisionVO extends BaseVO {
	private static final long serialVersionUID = 6444279164423623268L;
	private Long id;
	private DivisionVO parentVO;    // 上级区划
	private String code;    // 区划编码
	private String name;    // 区划名称

}

