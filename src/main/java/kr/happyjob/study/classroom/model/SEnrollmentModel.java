package kr.happyjob.study.classroom.model;

public class SEnrollmentModel {
	
	private int enrollment_no;
	private int course_no;
	private String loginID;
	private boolean enrollment_confirmed;
	
	public int getEnrollment_no() {
		return enrollment_no;
	}
	public void setEnrollment_no(int enrollment_no) {
		this.enrollment_no = enrollment_no;
	}
	public int getCourse_no() {
		return course_no;
	}
	public void setCourse_no(int course_no) {
		this.course_no = course_no;
	}
	public String getLoginID() {
		return loginID;
	}
	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}
	public boolean isEnrollment_confirmed() {
		return enrollment_confirmed;
	}
	public void setEnrollment_confirmed(boolean enrollment_confirmed) {
		this.enrollment_confirmed = enrollment_confirmed;
	}
	

	
}
