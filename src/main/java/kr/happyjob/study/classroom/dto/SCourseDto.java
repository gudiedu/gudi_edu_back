package kr.happyjob.study.classroom.dto;

import kr.happyjob.study.classroom.model.SAttendanceModel;
import kr.happyjob.study.classroom.model.SCourseDetailModel;
import kr.happyjob.study.classroom.model.SCourseModel;
import kr.happyjob.study.classroom.model.SEnrollmentModel;
import kr.happyjob.study.classroom.model.SFileModel;
import kr.happyjob.study.classroom.model.SSurveyAnswerModel;
import kr.happyjob.study.classroom.model.SSurveyModel;
import kr.happyjob.study.classroom.model.SSurveyQuestionModel;
import kr.happyjob.study.classroom.model.STestModel;
import kr.happyjob.study.classroom.model.STestResultModel;
import kr.happyjob.study.classroom.model.STestSubmissionModel;
import kr.happyjob.study.classroom.model.SUserInfoModel;

public class SCourseDto extends SCourseModel {

	private SCourseDetailModel sCourseDetail = new SCourseDetailModel();
	private SFileModel sFile = new SFileModel();
	private SEnrollmentModel sEnrollment = new SEnrollmentModel();
	private SAttendanceModel sAttendance = new SAttendanceModel();
	private SUserInfoModel sUserInfo = new SUserInfoModel();
	private STestModel sTest = new STestModel();
	private STestResultModel sTestResult = new STestResultModel();
	private STestSubmissionModel sTestSubmission = new STestSubmissionModel();
	private SSurveyModel sSurvey = new SSurveyModel();
	private SSurveyQuestionModel sSurveyQuestion = new SSurveyQuestionModel();
	private SSurveyAnswerModel sSurveyAnswer = new SSurveyAnswerModel();
	private String student_name;
	private String teacher_name;

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	// sCourseDetail Getter & Setter
	public int getCourse_detail_no() {
		return sCourseDetail.getCourse_detail_no();
	}

	public void setCourse_detail_no(int course_detail_no) {
		sCourseDetail.setCourse_detail_no(course_detail_no);
	}

	public int getCourse_detail_week_no() {
		return sCourseDetail.getCourse_detail_week_no();
	}

	public void setCourse_detail_week_no(int course_detail_week_no) {
		sCourseDetail.setCourse_detail_week_no(course_detail_week_no);
	}

	public String getCourse_detail_goal() {
		return sCourseDetail.getCourse_detail_goal();
	}

	public void setCourse_detail_goal(String course_detail_goal) {
		sCourseDetail.setCourse_detail_goal(course_detail_goal);
	}

	public String getCourse_detail_content() {
		return sCourseDetail.getCourse_detail_content();
	}

	public void setCourse_detail_content(String course_detail_content) {
		sCourseDetail.setCourse_detail_content(course_detail_content);
	}

	// sFile Getter & Setter
	public int getFile_no() {
		return sFile.getFile_no();
	}

	public String getFile_server_path() {
		return sFile.getFile_server_path();
	}

	public String getFile_local_path() {
		return sFile.getFile_local_path();
	}

	public String getFile_origin() {
		return sFile.getFile_origin();
	}

	public String getFile_rename() {
		return sFile.getFile_rename();
	}

	public String getFile_extension() {
		return sFile.getFile_extension();
	}

	public int getFile_size() {
		return sFile.getFile_size();
	}

	// sEnrollment Getter & Setter
	public int getEnrollment_no() {
		return sEnrollment.getEnrollment_no();
	}

	public void setEnrollment_no(int enrollment_no) {
		sEnrollment.setEnrollment_no(enrollment_no);
	}

	public boolean isEnrollment_confirmed() {
		return sEnrollment.isEnrollment_confirmed();
	}

	public void setEnrollment_confirmed(boolean enrollment_confirmed) {
		sEnrollment.setEnrollment_confirmed(enrollment_confirmed);
	}

	// sAttendance Getter & Setter
	public int getAttendance_no() {
		return sAttendance.getAttendance_no();
	}

	public void setAttendance_no(int attendance_no) {
		sAttendance.setAttendance_no(attendance_no);
	}

	public String getAttendance_date() {
		return sAttendance.getAttendance_date();
	}

	public void setAttendance_date(String attendance_date) {
		sAttendance.setAttendance_date(attendance_date);
	}

	public String getAttendance_status() {
		return sAttendance.getAttendance_status();
	}

	public void setAttendance_status(String attendance_status) {
		sAttendance.setAttendance_status(attendance_status);
	}

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
		;
	}

	// sSurvey Getter & Setter
	public int getSurvey_no() {
		return sSurvey.getSurvey_no();
	}

	public void setSurvey_no(int survey_no) {
		sSurvey.setSurvey_no(survey_no);
	}

	public String getSurvey_name() {
		return sSurvey.getSurvey_name();
	}

	public void setSurvey_name(String survey_name) {
		sSurvey.setSurvey_name(survey_name);
	}

	public int getTotal_questions() {
		return sSurvey.getTotal_questions();
	}

	public void setTotal_questions(int total_questions) {
		sSurvey.setTotal_questions(total_questions);
	}

	public int getChoice_questions() {
		return sSurvey.getChoice_questions();
	}

	public void setChoice_questions(int choice_questions) {
		sSurvey.setChoice_questions(choice_questions);
	}

	public int getWritten_questions() {
		return sSurvey.getWritten_questions();
	}

	public void setWritten_questions(int written_questions) {
		sSurvey.setWritten_questions(written_questions);
	}

	// sSurveyQuestion Getter & Setter
	public int getSurvey_question_no() {
		return sSurveyQuestion.getSurvey_question_no();
	}

	public void setSurvey_question_no(int survey_question_no) {
		sSurveyQuestion.setSurvey_question_no(survey_question_no);
	}

	public boolean isSurvey_question_essential() {
		return sSurveyQuestion.isSurvey_question_essential();
	}

	public void setSurvey_question_essential(boolean survey_question_essential) {
		sSurveyQuestion.setSurvey_question_essential(survey_question_essential);
	}

	public String getSurvey_question_text() {
		return sSurveyQuestion.getSurvey_question_text();
	}

	public void setSurvey_question_text(String survey_question_text) {
		sSurveyQuestion.setSurvey_question_text(survey_question_text);
	}

	public int getSurvey_question_choiced() {
		return sSurveyQuestion.getSurvey_question_choiced();
	}

	public void setSurvey_question_choiced(int survey_question_choiced) {
		sSurveyQuestion.setSurvey_question_choiced(survey_question_choiced);
	}

	public String getSurvey_question_type() {
		return sSurveyQuestion.getSurvey_question_type();
	}

	public void setSurvey_question_type(String survey_question_type) {
		sSurveyQuestion.setSurvey_question_type(survey_question_type);
	}

	// sSurveyAnswer Getter & Setter
	public int getQuestion_choiced() {
		return sSurveyAnswer.getQuestion_choiced();
	}

	public void setQuestion_choiced(int question_choiced) {
		sSurveyAnswer.setQuestion_choiced(question_choiced);
	}

	public int getChoice_no() {
		return sSurveyAnswer.getChoice_no();
	}

	public void setChoice_no(int choice_no) {
		sSurveyAnswer.setChoice_no(choice_no);
	}

	public String getWritten_anwers() {
		return sSurveyAnswer.getWritten_anwers();
	}

	public void setWritten_anwers(String written_anwers) {
		sSurveyAnswer.setWritten_anwers(written_anwers);
	}

	// sTest Getter & Setter
	public int getTest_no() {
		return sTest.getTest_no();
	}

	public void setTest_no(int test_no) {
		sTest.setTest_no(test_no);
	}

	public String getTest_question() {
		return sTest.getTest_question();
	}

	public void setTest_question(String test_question) {
		sTest.setTest_question(test_question);
	}

	public String getTest_choice1() {
		return sTest.getTest_choice1();
	}

	public void setTest_choice1(String test_choice1) {
		sTest.setTest_choice1(test_choice1);
	}

	public String getTest_choice2() {
		return sTest.getTest_choice2();
	}

	public void setTest_choice2(String test_choice2) {
		sTest.setTest_choice2(test_choice2);
	}

	public String getTest_choice3() {
		return sTest.getTest_choice3();
	}

	public void setTest_choice3(String test_choice3) {
		sTest.setTest_choice3(test_choice3);
	}

	public String getTest_choice4() {
		return sTest.getTest_choice4();
	}

	public void setTest_choice4(String test_choice4) {
		sTest.setTest_choice4(test_choice4);
	}

	public String getTest_answer() {
		return sTest.getTest_answer();
	}

	public void setTest_answer(String test_answer) {
		sTest.setTest_answer(test_answer);
	}

	// sTestResult Getter & Setter
	public int getResult_no() {
		return sTestResult.getResult_no();
	}

	public void setResult_no(int result_no) {
		sTestResult.setResult_no(result_no);
	}

	// sTestSubmission Getter & Setter
	public int getSubmission_no() {
		return sTestSubmission.getSubmission_no();
	}

	public void setSubmission_no(int submission_no) {
		sTestSubmission.setSubmission_no(submission_no);
	}

	public String getAnswer_selected() {
		return sTestSubmission.getAnswer_selected();
	}

	public void setAnswer_selected(String answer_selected) {
		sTestSubmission.setAnswer_selected(answer_selected);
	}

	public int getResult_score() {
		return sTestSubmission.getResult_score();
	}

	public void setResult_score(int result_score) {
		sTestSubmission.setResult_score(result_score);
	}

}