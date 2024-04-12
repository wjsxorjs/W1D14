package pmWork;

import java.io.Serializable;

public class EmpVO implements Serializable {

	String empno, ename, pos, dept, hireDate;

	
	
	public EmpVO() {};
	
	public EmpVO(String empno, String ename, String pos, String dept, String hireDate) {
		
		this.empno = empno;
		this.ename = ename;
		this.pos = pos;
		this.dept = dept;
		this.hireDate = hireDate;
	}

	// SETTERS
	
	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	
	
	// GETTERS


	public String getEmpno() {
		return empno;
	}

	public String getEname() {
		return ename;
	}

	public String getPos() {
		return pos;
	}

	public String getDept() {
		return dept;
	}

	public String getHireDate() {
		return hireDate;
	}
	
	
}
