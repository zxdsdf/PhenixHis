package cn.ekgc.phenix.base.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * <b></b>
 *
 * @author JLS
 * @date 2023/2/11
 */
@Data
public class QueryPageVO<E extends BaseVO> implements Serializable {
	private static final long serialVersionUID = 8022939120301553917L;
	private E query;
	private PageVO<E> pageVO;
	public QueryPageVO() {}
	public QueryPageVO(E query,Integer pageNum,Integer pageSize) {
		this.query = query;
		this.pageVO = new PageVO<>(pageNum,pageSize);
	}
}
