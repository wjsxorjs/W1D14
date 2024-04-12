package homework;

import java.io.Serializable;

public class EmpVO implements Serializable {
	
	String empNo, empName, empDept, empPos, empDoe;

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}

	public void setEmpPos(String empPos) {
		this.empPos = empPos;
	}

	public void setEmpDoe(String empDoe) {
		this.empDoe = empDoe;
	}

	public String getEmpNo() {
		return empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public String getEmpDept() {
		return empDept;
	}

	public String getEmpPos() {
		return empPos;
	}

	public String getEmpDoe() {
		return empDoe;
	}
	
	
	
	

}
