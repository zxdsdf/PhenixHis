package cn.ekgc.phenix.system.dictionary.controller;

import cn.ekgc.phenix.base.pojo.vo.PageVO;
import cn.ekgc.phenix.base.pojo.vo.QueryPageVO;
import cn.ekgc.phenix.base.pojo.vo.ResponseVO;
import cn.ekgc.phenix.system.dictionary.pojo.vo.DivisionVO;
import cn.ekgc.phenix.system.dictionary.transport.DivisionTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <b></b>
 *
 * @author JLS
 * @date 2023/2/11
 */
@RestController("dictionaryController")
@RequestMapping("system/div")
public class DivisionController {
	@Autowired
	private DivisionTransport divisionTransport;
	/**
	 * <b>分页视图</b>
	 * @param queryVO
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page/{pageNum}/{pageSize}")
	public ResponseVO queryByPage(
			@RequestBody DivisionVO queryVO,
			@PathVariable("pageNum") Integer pageNum,
			@PathVariable("pageSize") Integer pageSize)
			throws Exception {
		QueryPageVO<DivisionVO> queryPageVO = new QueryPageVO<DivisionVO>(queryVO,pageNum,pageSize);
		PageVO<DivisionVO> pageVO = divisionTransport.pageHelperToVO(queryPageVO);
		return ResponseVO.successResponseVO("分页查询成功",pageVO);
	}

	/**
	 * <b>根据查询视图获得列表信息</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	public ResponseVO queryList(@RequestBody DivisionVO queryVO) throws Exception{
		List<DivisionVO> list = divisionTransport.queryList(queryVO);
		return ResponseVO.successResponseVO("查询视图成功",list);
	}

	/**
	 * <b>根据id获得视图信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/id/{id}")
	public ResponseVO queryById(@PathVariable("id") Long id) throws Exception {
		DivisionVO queryVO = divisionTransport.queryById(id);
		return ResponseVO.successResponseVO("获取视图信息成功",queryVO);
	}
	/**
	 * <b>根据code获得视图信息</b>
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/code/{code}")
	public ResponseVO queryByCode(@PathVariable("code") String code) throws Exception {
		DivisionVO queryVO = divisionTransport.queryByCode(code);
		return ResponseVO.successResponseVO("获取视图信息成功",queryVO);
	}

	/**
	 * <b>添加用户视图</b>
	 * @param insertVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping
	public ResponseVO insertVO(@Validated @RequestBody DivisionVO insertVO) throws Exception {
		if (divisionTransport.insertVO(insertVO)){
			return ResponseVO.successResponseVO("添加用户成功");
		}
		return ResponseVO.successResponseVO("添加用户失败");
	}

	/**
	 * <b>修改用户信息</b>
	 * @param updateVO
	 * @return
	 * @throws Exception
	 */
	@PutMapping
	public ResponseVO updateVO(@Validated @RequestBody DivisionVO updateVO) throws Exception {
		if (divisionTransport.updateVO(updateVO)){
			return ResponseVO.successResponseVO("修改用户成功");
		}
		return ResponseVO.successResponseVO("修改用户失败");
	}
	/**
	 * <b>修改系统状态</b>
	 * @param id
	 * @param status
	 * @return
	 * @throws Exception
	 */
	@PutMapping("/status/{id}/{status}")
	public ResponseVO changeStatus(@PathVariable("id") Long id, @PathVariable("status") String status) throws Exception {
		if (divisionTransport.changeStatusById(id,status)){
			return ResponseVO.successResponseVO("修改用户系统状态成功");
		}
		return ResponseVO.successResponseVO("修改用户系统状态失败");

	}
}
