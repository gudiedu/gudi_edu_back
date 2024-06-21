package kr.happyjob.study.sAlert.dto;

import kr.happyjob.study.sAlert.model.SCourseModel;
import kr.happyjob.study.sAlert.model.SFileModel;
import kr.happyjob.study.sAlert.model.SResourceModel;
import kr.happyjob.study.sAlert.model.SUserInfoModel;

public class SResourceDto extends SResourceModel {
	
	private SUserInfoModel sUserInfo = new SUserInfoModel();
	private SResourceModel sResource = new SResourceModel();
	private SCourseModel sCourse = new SCourseModel();
	private SFileModel sFile = new SFileModel();
	
	// sUserInfo Getter & Setter
	public String getUser_type() {
		return sUserInfo.getUser_type();
	}
	
	public void setUser_type(String user_type) {
		sUserInfo.setUser_type(user_type);
	}
	
	public String getName() {
		return sUserInfo.getName();
	}

	public void setName(String name) {
		sUserInfo.setName(name);;
	}
	
	// sResource Getter & Setter
	public int getResource_no() {
		return sResource.getResource_no();
	}

	public void setResource_no(int resource_no) {
		sResource.setResource_no(resource_no);
	}

	public int getCourse_no() {
		return sResource.getCourse_no();
	}

	public void setCourse_no(int course_no) {
		sResource.setCourse_no(course_no);
	}

	public String getLoginID() {
		return sResource.getLoginID();
	}

	public void setLoginID(String loginID) {
		sResource.setLoginID(loginID);
	}

	public String getResource_title() {
		return sResource.getResource_title();
	}

	public void setResource_title(String resource_title) {
		sResource.setResource_title(resource_title);
	}

	public String getResource_content() {
		return sResource.getResource_content();
	}

	public void setResource_content(String resource_content) {
		sResource.setResource_content(resource_content);
	}

	public String getResource_created_at() {
		return sResource.getResource_created_at();
	}

	public void setResource_created_at(String resource_created_at) {
		sResource.setResource_created_at(resource_created_at);
	}

	public String getResource_edited_at() {
		return sResource.getResource_edited_at();
	}

	public void setResource_edited_at(String resource_edited_at) {
		sResource.setResource_edited_at(resource_edited_at);
	}

	public String getResouce_writer() {
		return sResource.getResouce_writer();
	}

	public void setResouce_writer(String resouce_writer) {
		sResource.setResouce_writer(resouce_writer);
	}

	public String getResource_editor() {
		return sResource.getResource_editor();
	}

	public void setResource_editor(String resource_editor) {
		sResource.setResource_editor(resource_editor);;
	}
	
	// sCourse Getter & Setter
	public String getCourse_name() {
		return sCourse.getCourse_name();
	}

	public void setCourse_name(String course_name) {
		sCourse.setCourse_name(course_name);
	}
	
	public String getCourse_subject() {
		return sCourse.getCourse_subject();
	}

	public void setCourse_subject(String course_subject) {
		sCourse.setCourse_subject(course_subject);
	}
	
	// sFile Getter & Setter
	public int getFile_no() {
		return sFile.getFile_no();
	}

	public void setFile_no(int file_no) {
		sFile.setFile_no(file_no);
	}
	
	public String getFile_server_path() {
		return sFile.getFile_server_path();
	}

	public void setFile_server_path(String file_server_path) {
		sFile.setFile_server_path(file_server_path);
		
	}

	public String getFile_local_path() {
		return sFile.getFile_local_path();
	}

	public void setFile_local_path(String file_local_path) {
		sFile.setFile_local_path(file_local_path);
	}

	public String getFile_origin() {
		return sFile.getFile_origin();
	}

	public void setFile_origin(String file_origin) {
		sFile.setFile_origin(file_origin);
	}

	public String getFile_rename() {
		return sFile.getFile_rename();
	}

	public void setFile_rename(String file_rename) {
		sFile.setFile_rename(file_rename);
	}

	public String getFile_extension() {
		return sFile.getFile_extension();
	}

	public void setFile_extension(String file_extension) {
		sFile.setFile_extension(file_extension);
	}

	public int getFile_size() {
		return sFile.getFile_size();
	}

	public void setFile_size(int file_size) {
		sFile.setFile_size(file_size);
	}
	
}