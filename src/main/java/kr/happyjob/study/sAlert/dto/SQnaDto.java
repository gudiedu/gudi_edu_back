package kr.happyjob.study.sAlert.dto;

import kr.happyjob.study.sAlert.model.SCourseModel;
import kr.happyjob.study.sAlert.model.SEnrollmentModel;
import kr.happyjob.study.sAlert.model.SFileModel;
import kr.happyjob.study.sAlert.model.SQuestionModel;
import kr.happyjob.study.sAlert.model.SQuestionReplyModel;
import kr.happyjob.study.sAlert.model.SUserInfoModel;

public class SQnaDto extends SQuestionModel {
	
	private SUserInfoModel sUserInfo = new SUserInfoModel();
	private SQuestionReplyModel sQuestionReply = new SQuestionReplyModel();
	private SCourseModel sCourse = new SCourseModel();
	private SEnrollmentModel sEnrollment = new SEnrollmentModel();
	
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
	
	
	// sCourse Getter & Setter
	
	public String getCourse_name() {
		return sCourse.getCourse_name();
	}
	
	public void setCourse_name(String course_name) {
		sCourse.setCourse_name(course_name);
	}
	
	
	//sEnrollment Getter & Setter
	
	public int getEnrollment_no() {
		return sEnrollment.getEnrollment_no();
	}

	public void setEnrollment_no(int enrollment_no) {
		sEnrollment.setEnrollment_no(enrollment_no);
	}
	
	public int getCourse_no() {
		return sEnrollment.getCourse_no();
	}

	public void setCourse_no(int course_no) {
		sEnrollment.setCourse_no(course_no);
	}

	
}