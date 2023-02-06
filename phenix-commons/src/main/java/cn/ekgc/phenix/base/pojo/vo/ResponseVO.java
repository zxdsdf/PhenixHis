package cn.ekgc.phenix.base.pojo.vo;


import cn.ekgc.phenix.base.pojo.enums.ResponseCodeEnum;

import java.io.Serializable;

/**
 * <b>系统响应视图信息</b>
 *
 * @author JLS
 * @date 2023/2/6
 */
public class ResponseVO<E> implements Serializable {
	private static final long serialVersionUID = -3686820732404726599L;
	private Integer code;            // 系统响应编码
	private String message;         // 系统响应结果信息
	private E data;                 // 系统响应结果数据

	private ResponseVO(ResponseCodeEnum responseCode, String message, E data) {
		this.code = responseCode.getCode();
		this.message = message;
		this.data = data;
	}

	/**
	 * <b>获得系统业务处理成功响应视图信息</b>
	 * @param message
	 * @return
	 */
	public static ResponseVO successResponseVO(String message) {
		return new ResponseVO(ResponseCodeEnum.RESPONSE_CODE_SUCCESS,message, "");
	}
	/**
	 * <b>获得系统业务处理成功响应视图信息</b>
	 * @param message
	 * @return
	 */
	public static ResponseVO successResponseVO(String message,Object data) {
		return new ResponseVO(ResponseCodeEnum.RESPONSE_CODE_SUCCESS,message, data);
	}

	/**
	 * <b>获得该用户未进行系统认证</b>
	 * @return
	 */
	public static ResponseVO unauthResponseVO() {
		return new ResponseVO(ResponseCodeEnum.RESPONSE_CODE_UNAUTH,ResponseCodeEnum.RESPONSE_CODE_UNAUTH.getRemark(),"");
	}

	/**
	 * <b>获得系统业务处理失败视图</b>
	 * @param errorMessage
	 * @return
	 */
	public static ResponseVO failureResponseVO(String errorMessage) {
		return new ResponseVO(ResponseCodeEnum.RESPONSE_CODE_FAILURE,errorMessage,"");
	}

	/**
	 * <b>获得系统响应异常视图</b>
	 * @param exception
	 * @return
	 */
	public static ResponseVO exceptionResponseVO(Exception exception) {
		return new ResponseVO(ResponseCodeEnum.RESPONSE_CODE_EXCEPTION,exception.getMessage(),exception);
	}
}
