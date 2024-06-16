package kr.happyjob.study.information.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.happyjob.study.information.model.SurveyModel;
import kr.happyjob.study.information.model.SurveyQuestionModel;
import kr.happyjob.study.information.service.SurveyService;

@Controller
@RequestMapping("/survey/")
public class SurveyController {
	
	@Autowired
	SurveyService surveyService;
	
	   // Set logger
		private final Logger logger = LogManager.getLogger(this.getClass());

		   // Get class name for logger
		private final String className = this.getClass().toString();
		
		//설문지 리스트 출력
		@RequestMapping("SurveyList.do")
		@ResponseBody
		public Map<String, Object> surveyList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	               HttpServletResponse response, HttpSession session) throws Exception {
			logger.info("+ Start " + className + ".surveyList");
			logger.info("   - paramMap : " + paramMap);
			
			List<SurveyModel> surveyListModel = surveyService.surveyList(paramMap);
			
			Map<String, Object> resultMap = new HashMap<>();
			
			resultMap.put("listdate", surveyListModel);
			
			logger.info("+ End " + className + ".surveyList");
				return resultMap;
		}
		
		//설문지 상세질문 목록 출력
		@RequestMapping("QuestionList.do")
		@ResponseBody
		public Map<String, Object> questionList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	               HttpServletResponse response, HttpSession session) throws Exception {
			logger.info("+ Start " + className + ".questionList");
			logger.info("   - paramMap : " + paramMap);
			
			
			 // survey_no 파라미터가 있는지 확인
		    String surveyNo = (String) paramMap.get("survey_no");
		    if (surveyNo == null) {
		        // survey_no 파라미터가 없으면 에러 처리
		        throw new IllegalArgumentException("survey_no parameter is required");
		    }
		    
		    List<SurveyQuestionModel> questionListModel = surveyService.questionList(paramMap);
			
			Map<String, Object> resultMap = new HashMap<>();
			
			resultMap.put("listdate", questionListModel);
			
			
			logger.info("+ End " + className + ".questionList");
				return resultMap;
		}
		
		
}
