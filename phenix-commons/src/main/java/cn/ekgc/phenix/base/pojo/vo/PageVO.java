package cn.ekgc.phenix.base.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <b>分页视图信息</b>
 *
 * @author JLS
 * @date 2023/2/6
 */
@Data
public class PageVO<E extends BaseVO> implements Serializable {
	private static final long serialVersionUID = 1164056489146072861L;
	private static final Integer PAGE_NUM = 1;
	private static final Integer PAGE_SIZE = 10;
	private Integer pageNum;           // 当前页码
	private Integer pageSize;          // 当前页面显示条数
	private List<E> list;              // 分页列表
	private Long totalCount;           // 总条数
	private Integer totalPage;         // 总页数
	public PageVO() {}
	public PageVO(Integer pageNum,Integer pageSize) {
		if (pageNum != null && pageNum > 0) {
			this.pageNum = pageNum;
		}else {
			this.pageNum = PAGE_NUM;
		}
		if (pageSize != null && pageSize > 0) {
			this.pageSize = pageSize;
		}else {
			this.pageSize = PAGE_SIZE;
		}
	}
}
