package cn.ekgc.phenix.system.dictionary.controller;

import cn.ekgc.phenix.base.pojo.vo.ResponseVO;
import cn.ekgc.phenix.system.dictionary.pojo.vo.DictionaryVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <b>系统功能模块 - 系统字典模块控制层</b>
 *
 * @author JLS
 * @date 2023/2/8
 */
@RestController("dictionaryController")
@RequestMapping("system/dic")
public class DictionaryController {
	/**
	 * <b>分页视图</b>
	 * @param queryVO
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page/{pageNum}/{pageSSize}")
	public ResponseVO queryByPage(
			@RequestBody DictionaryVO queryVO,
			@PathVariable("pageNum") Integer pageNum,
			@PathVariable("pageSize") Integer pageSize)
			throws Exception {
		return null;
	}

	/**
	 * <b>根据查询视图获得列表信息</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	public ResponseVO queryList(@RequestBody DictionaryVO queryVO) throws Exception{
		return null;
	}

	/**
	 * <b>根据id获得视图信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/id/{id}")
	public ResponseVO queryById(@PathVariable("id") Long id) throws Exception {
		return null;
	}
	/**
	 * <b>根据code获得视图信息</b>
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/code/{code}")
	public ResponseVO queryByCode(@PathVariable("code") String code) throws Exception {
		return null;
	}

	/**
	 * <b>添加用户视图</b>
	 * @param insertVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping
	public ResponseVO insertVO(@Validated @RequestBody DictionaryVO insertVO) throws Exception {
		return null;
	}

	@PutMapping
	public ResponseVO updateVO(@Validated @RequestBody DictionaryVO insertVO) throws Exception {
		return null;
	}

	@PutMapping("/status/{id}/{status}")
	public ResponseVO changeStatus(@PathVariable("id") Long id, @PathVariable("status") String status) throws Exception {
		return null;
	}
}
