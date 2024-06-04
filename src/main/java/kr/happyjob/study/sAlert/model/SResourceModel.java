package kr.happyjob.study.sAlert.model;

public class SResourceModel {

	private int resource_no;
	
	private int course_no;
	
	private String loginID;
	
	private String resource_title;
	
	private String resource_content;
	
	private String resource_created_at;
	
	private String resource_edited_at;

	private String resouce_writer;
	
	private String resource_editor;

	public int getResource_no() {
		return resource_no;
	}

	public void setResource_no(int resource_no) {
		this.resource_no = resource_no;
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

	public String getResource_title() {
		return resource_title;
	}

	public void setResource_title(String resource_title) {
		this.resource_title = resource_title;
	}

	public String getResource_content() {
		return resource_content;
	}

	public void setResource_content(String resource_content) {
		this.resource_content = resource_content;
	}

	public String getResource_created_at() {
		return resource_created_at;
	}

	public void setResource_created_at(String resource_created_at) {
		this.resource_created_at = resource_created_at;
	}

	public String getResource_edited_at() {
		return resource_edited_at;
	}

	public void setResource_edited_at(String resource_edited_at) {
		this.resource_edited_at = resource_edited_at;
	}

	public String getResouce_writer() {
		return resouce_writer;
	}

	public void setResouce_writer(String resouce_writer) {
		this.resouce_writer = resouce_writer;
	}

	public String getResource_editor() {
		return resource_editor;
	}

	public void setResource_editor(String resource_editor) {
		this.resource_editor = resource_editor;
	}

}
