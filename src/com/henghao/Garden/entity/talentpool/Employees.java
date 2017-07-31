package com.henghao.Garden.entity.talentpool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.henghao.Garden.entity.fileMassage.Talentpoolmassage;

/**
 * employees entity. 从业人员库表实体
 * 
 * 
 * date 2017-05-18
 * 
 * @author 严彬荣
 */
@Entity
@Table(name = "employees", catalog = "garden")
public class Employees implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7439095567805595607L;
	// 表id
	private Integer eid;
	// 姓名
	private String name;
	// 性别
	private Integer gender;
	// 企业名称
	private String companyName;
	// 职称
	private String titled;
	// 职位
	private String position;
	// 做过的项目
	private String oldProject;
	// 正在施工项目
	private String newProject;
	// 录入时间
	private String dates;
	// 资质证书文件编号
	private String fileId;
	// 状态参数
	private Integer isNo;
	// 资质证书文件路径
	private List<Talentpoolmassage> url;

	public Employees() {
		super();
		this.isNo = 0;
		this.dates = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(new Date());
		// TODO Auto-generated constructor stub
	}

	public Employees(Integer eid, String name, Integer gender,
			String companyName, String titled, String position,
			String oldProject, String newProject, String dates, String fileId,
			Integer isNo, List<Talentpoolmassage> url) {
		super();
		this.eid = eid;
		this.name = name;
		this.gender = gender;
		this.companyName = companyName;
		this.titled = titled;
		this.position = position;
		this.oldProject = oldProject;
		this.newProject = newProject;
		this.dates = dates;
		this.fileId = fileId;
		this.isNo = isNo;
		this.url = url;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "eid", unique = true, nullable = false)
	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "gender", nullable = false, length = 1)
	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	@Column(name = "companyName", nullable = false, length = 100)
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column(name = "titled", nullable = true, length = 50)
	public String getTitled() {
		return titled;
	}

	public void setTitled(String titled) {
		this.titled = titled;
	}

	@Column(name = "position", nullable = true, length = 50)
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Column(name = "oldProject", nullable = true, length = 3000)
	public String getOldProject() {
		return oldProject;
	}

	public void setOldProject(String oldProject) {
		this.oldProject = oldProject;
	}

	@Column(name = "newProject", nullable = true, length = 3000)
	public String getNewProject() {
		return newProject;
	}

	public void setNewProject(String newProject) {
		this.newProject = newProject;
	}

	@Column(name = "dates", nullable = false, length = 20)
	public String getDates() {
		return dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	@Column(name = "fileId", nullable = false, length = 32)
	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	@Column(name = "isNo", nullable = false, length = 1)
	public Integer getIsNo() {
		return isNo;
	}

	public void setIsNo(Integer isNo) {
		this.isNo = isNo;
	}

	@Transient
	public List<Talentpoolmassage> getUrl() {
		return url;
	}

	public void setUrl(List<Talentpoolmassage> url) {
		this.url = url;
	}

}
