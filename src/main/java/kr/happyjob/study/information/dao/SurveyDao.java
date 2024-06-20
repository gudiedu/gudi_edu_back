package kr.happyjob.study.information.dao;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.information.model.SurveyChoiceContentModel;
import kr.happyjob.study.information.model.SurveyModel;
import kr.happyjob.study.information.model.SurveyQuestionModel;

public interface SurveyDao {
	/************ 설문 ************/
	//설문지 목록 리스트
	public List<SurveyModel> surveyList() throws Exception;
	
	//선택한 설문지 상세 질문들 목록
	public List<SurveyQuestionModel> questionList(Map<String, Object> paramMap) throws Exception;
	
	//다음 설문코드 출력
	public int nextSurveyCode() throws Exception;
	
	//설문지 이름 입력받아 등록
	public int surveyInsert(String survey_name) throws Exception;
	
	//설문지 삭제
	public int surveyDelete(int survey_no) throws Exception;

	//설문지 수정
	public int surveyUpdate(Map<String, Object> paramMap) throws Exception;
	
	//설문지 문항수 반영
	public void surveyUpdateCount() throws Exception;
	
	/************질문************/
	//질문 등록
	public void questionInsert(Map<String, Object> paramMap) throws Exception;
	
	//카테고리 리스트 출력
	public List<SurveyChoiceContentModel> categoryList(Map<String, Object> paramMap) throws Exception;
	
	// 질문 선택문항 출력
	public List<SurveyChoiceContentModel> choiceList(Map<String, Object> paramMap) throws Exception;
	
	//질문 삭제
	public int questionDelete(Map<String, Object> paramMap) throws Exception;
	
	//질문 업데이트
	public int questionUpdate(Map<String, Object> paramMap) throws Exception;
	
	//강의에 설문등록하기
	public int surveyIntoCourse(Map<String, Object> paramMap) throws Exception;
}
