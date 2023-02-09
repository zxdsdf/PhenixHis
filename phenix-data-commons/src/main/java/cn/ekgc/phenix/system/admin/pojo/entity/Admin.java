package cn.ekgc.phenix.system.admin.pojo.entity;

import cn.ekgc.phenix.base.pojo.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * <b>系统功能模块 - 管理员实体信息</b>
 *
 * @author JLS
 * @date 2023/2/6
 */
@Data
@TableName("sys_admin")
public class Admin extends BaseEntity {
	private static final long serialVersionUID = -1457351697231132630L;
	@TableId(type = IdType.INPUT)
	private String id;//主键
	private String no;
	private  String name;
	private String cellphone;//手机号
	private String password;//密码
	private Long role;    //管理员角色
	private Long idType;  // 证件类型
	private String  idNo;        //证件类型
	private Date idEffDate;      //证件生效日期
	private Date idExpDate;       //证件失效日期
	private String idOrgName;     // 证件提供机构名称
	private Long university;        // 毕业院校
	private Long major;             // 所学专业
	private Long eduBg;             //学历
	private Long techTitle;         // 专业技术职称
}
