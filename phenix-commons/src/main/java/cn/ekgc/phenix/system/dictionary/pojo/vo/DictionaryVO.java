package cn.ekgc.phenix.system.dictionary.pojo.vo;

import cn.ekgc.phenix.base.pojo.vo.BaseVO;
import lombok.Data;

/**
 * <b>系统功能字典视图模块</b>
 *
 * @author JLS
 * @date 2023/2/7
 */
@Data

public class DictionaryVO extends BaseVO {
	private static final long serialVersionUID = -8741341195589056751L;
	private Long id;
	private DictionaryVO parentVO;    // 所属字典
	private String code;    // 字典编码
	private String text;    // 字典文本
}
