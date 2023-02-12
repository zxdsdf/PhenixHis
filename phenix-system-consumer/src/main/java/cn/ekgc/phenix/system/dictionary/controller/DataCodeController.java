package cn.ekgc.phenix.system.dictionary.controller;

import cn.ekgc.phenix.base.pojo.vo.PageVO;
import cn.ekgc.phenix.base.pojo.vo.QueryPageVO;
import cn.ekgc.phenix.base.pojo.vo.ResponseVO;
import cn.ekgc.phenix.system.dictionary.pojo.vo.DataCodeVO;
import cn.ekgc.phenix.system.dictionary.pojo.vo.DivisionVO;
import cn.ekgc.phenix.system.dictionary.transport.DataCodeTransport;
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
@RestController("dataCodeController")
@RequestMapping("/system/data/code")
public class DataCodeController {
	@Autowired
	private DataCodeTransport dataCodeTransport;
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
			@RequestBody DataCodeVO queryVO,
			@PathVariable("pageNum") Integer pageNum,
			@PathVariable("pageSize") Integer pageSize)
			throws Exception {
		QueryPageVO<DataCodeVO> queryPageVO = new QueryPageVO<DataCodeVO>(queryVO,pageNum,pageSize);
		PageVO<DataCodeVO> pageVO = dataCodeTransport.pageHelperToVO(queryPageVO);
		return ResponseVO.successResponseVO("分页查询成功",pageVO);
	}

	/**
	 * <b>根据查询视图获得列表信息</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	public ResponseVO queryList(@RequestBody DataCodeVO queryVO) throws Exception{
		List<DataCodeVO> list = dataCodeTransport.queryList(queryVO);
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
		DataCodeVO queryVO = dataCodeTransport.queryById(id);
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
		DataCodeVO queryVO = dataCodeTransport.queryByCode(code);
		return ResponseVO.successResponseVO("获取视图信息成功",queryVO);
	}

	/**
	 * <b>添加用户视图</b>
	 * @param insertVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping
	public ResponseVO insertVO(@Validated @RequestBody DataCodeVO insertVO) throws Exception {
		if (dataCodeTransport.insertVO(insertVO)){
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
	public ResponseVO updateVO(@Validated @RequestBody DataCodeVO updateVO) throws Exception {
		if (dataCodeTransport.updateVO(updateVO)){
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
		if (dataCodeTransport.changeStatusById(id,status)){
			return ResponseVO.successResponseVO("修改用户系统状态成功");
		}
		return ResponseVO.successResponseVO("修改用户系统状态失败");

	}
}
