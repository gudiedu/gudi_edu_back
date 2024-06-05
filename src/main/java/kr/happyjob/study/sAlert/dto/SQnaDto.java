package kr.happyjob.study.sAlert.dto;

import kr.happyjob.study.sAlert.model.SCourseModel;
import kr.happyjob.study.sAlert.model.SFileModel;
import kr.happyjob.study.sAlert.model.SQuestionModel;
import kr.happyjob.study.sAlert.model.SQuestionReplyModel;
import kr.happyjob.study.sAlert.model.SUserInfoModel;

public class SQnaDto extends SQuestionModel {
	
	private SUserInfoModel sUserInfo = new SUserInfoModel();
	private SQuestionReplyModel sQuestionReply = new SQuestionReplyModel();
	private SFileModel sFile = new SFileModel();
	private SCourseModel sCourse = new SCourseModel();
	
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
		sUserInfo.setName(name);
	}

	// sQuestionReply Getter & Setter
	public int getReply_no() {
		return sQuestionReply.getReply_no();
	}

	public void setReply_no(int reply_no) {
		sQuestionReply.setReply_no(reply_no);
	}

	public int getQuestion_no() {
		return sQuestionReply.getQuestion_no();
	}

	public void setQuestion_no(int question_no) {
		sQuestionReply.setQuestion_no(question_no);;
	}

	public int getCategory_no() {
		return sQuestionReply.getCategory_no();
	}

	public void setCategory_no(int category_no) {
		sQuestionReply.setCategory_no(category_no);
	}

	public int getAttachment_no() {
		return sQuestionReply.getAttachment_no();
	}

	public void setAttachment_no(int attachment_no) {
		sQuestionReply.setAttachment_no(attachment_no);
	}

	public String getReply_content() {
		return sQuestionReply.getReply_content();
	}

	public void setReply_content(String reply_content) {
		sQuestionReply.setReply_content(reply_content);
	}

	public String getReply_created_at() {
		return sQuestionReply.getReply_created_at();
	}

	public void setReply_created_at(String reply_created_at) {
		sQuestionReply.setReply_created_at(reply_created_at);
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
	
	
	// sCourse Getter & Setter

	public String getCourse_name() {
		return sCourse.getCourse_name();
	}
	
	public void setCourse_name(String course_name) {
		sCourse.setCourse_name(course_name);
	}
	
}