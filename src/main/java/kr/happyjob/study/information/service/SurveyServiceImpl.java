package kr.happyjob.study.information.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.information.dao.SurveyDao;
import kr.happyjob.study.information.model.SurveyChoiceContentModel;
import kr.happyjob.study.information.model.SurveyModel;
import kr.happyjob.study.information.model.SurveyQuestionModel;

@Service
public class SurveyServiceImpl implements SurveyService{
	
	@Autowired
	private SurveyDao surveyDao;
	
	//설문지 목록 리스트
	@Override
	public List<SurveyModel> surveyList(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return surveyDao.surveyList(paramMap);
	}
	
	//선택한 설문지 상세 질문들 목록
	@Override
	public List<SurveyQuestionModel> questionList(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return surveyDao.questionList(paramMap);
	}
	
	//다음 설문코드 출력
	@Override
	public int nextSurveyCode() throws Exception{
		return surveyDao.nextSurveyCode();
	}
	
	//설문지 등록
	@Override
	public int surveyInsert(String survey_name) throws Exception{
		return surveyDao.surveyInsert(survey_name);
	}
	
	//설문지 삭제
	@Override
	public int surveyDelete(int survey_no) throws Exception{
		return surveyDao.surveyDelete(survey_no);
	}
	
	//설문지 수정
	@Override
	public int surveyUpdate(Map<String, Object> paramMap) throws Exception{
		return surveyDao.surveyUpdate(paramMap);
	}

	//설문지 문항수 반영
	public void surveyUpdateCount() throws Exception{
		surveyDao.surveyUpdateCount();
	}
	
	/************질문************/
	//질문 등록
	public void questionInsert(Map<String, Object> paramMap) throws Exception{
		surveyDao.questionInsert(paramMap);
	}
	
	//카테고리 리스트 출력
	public List<SurveyChoiceContentModel> categoryList(Map<String, Object> paramMap) throws Exception{
		return surveyDao.categoryList(paramMap);
	}
	
	// 질문 선택문항 출력
	public List<SurveyChoiceContentModel> choiceList(Map<String, Object> paramMap) throws Exception{
		return surveyDao.choiceList(paramMap);
	}
	
	//질문 삭제
	public int questionDelete(Map<String, Object> paramMap) throws Exception{
		return surveyDao.questionDelete(paramMap);
		}
	
	//질문 업데이트
	public int questionUpdate(Map<String, Object> paramMap) throws Exception{
		return surveyDao.questionUpdate(paramMap);
	}
	
	//강의에 설문등록하기
	public int surveyIntoCourse(Map<String, Object> paramMap) throws Exception{
		return surveyDao.surveyIntoCourse(paramMap);
	}
	
	//설문 총 갯수 가져오기
	public int totalcntSurvey(Map<String, Object> paramMap) throws Exception{
		return surveyDao.totalcntSurvey(paramMap);
	}
	
}
