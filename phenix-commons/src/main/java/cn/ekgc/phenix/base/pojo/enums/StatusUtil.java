package cn.ekgc.phenix.base.pojo.enums;

public enum StatusUtil {
	STATUS_ENABLE("1","启用"),
	STATUS_DISABLE("0","禁用");
	private String code;   //系统响应编码
	private String remark;  //系统响应编码说明

	private StatusUtil(String code, String remark) {
		this.code = code;
		this.remark = remark;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
