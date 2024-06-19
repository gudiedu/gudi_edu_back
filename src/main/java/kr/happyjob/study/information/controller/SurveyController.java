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

import kr.happyjob.study.information.model.SurveyChoiceContentModel;
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

	// 설문지 리스트 출력
	@RequestMapping("SurveyList.do")
	@ResponseBody
	public Map<String, Object> surveyList(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		logger.info("+ Start " + className + ".surveyList");
		logger.info("   - paramMap : " + paramMap);

		List<SurveyModel> surveyListModel = surveyService.surveyList();

		Map<String, Object> resultMap = new HashMap<>();

		resultMap.put("listdate", surveyListModel);

		logger.info("+ End " + className + ".surveyList");
		return resultMap;
	}

	// 설문지 상세질문 목록 출력
	@RequestMapping("QuestionList.do")
	@ResponseBody
	public Map<String, Object> questionList(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
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

	// 다음 설문코드 출력
	@RequestMapping("nextSurveyCode.do")
	@ResponseBody
	public int nextSurveyCode(Model model) {
		try {
			int nextsurvey_no = surveyService.nextSurveyCode();
			logger.info("+ Start " + className + ".nextSurveyCode");
			logger.info("   - survey_no : " + nextsurvey_no);
			// model.addAttribute("newCode",newCode);
			return nextsurvey_no;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			logger.info("+ End " + className + ".nextSurveyCode");
		}
	}

	// 설문지 등록
	@RequestMapping("surveyInsert.do")
	@ResponseBody
	public String surveyInsert(@RequestParam("survey_name") String survey_name) throws Exception {
		try {
			logger.info("+ Start " + className + ".surveyInsert");
			logger.info("   - survey_name : " + survey_name);
			int result = surveyService.surveyInsert(survey_name);
			// String detail_code = acourseCodeService.selectDetailCode();
			// model.addAttribute(detail_code);

			if (result > 0) {
				return "등록 성공";
			} else {
				return "등록 실패";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Error adding survey_name: " + e.getMessage();
		} finally {
			logger.info("+ End " + className + ".surveyInsert");
		}
	}

	// 설문지 삭제
	@RequestMapping("surveyDelete.do")
	@ResponseBody
	public int surveyDelete(@RequestParam("survey_no") int survey_no) throws Exception {
		try {
			logger.info("+ Start " + className + ".surveyDelete");
			logger.info("   - survey_no : " + survey_no);
			int result = surveyService.surveyDelete(survey_no);
			surveyService.surveyUpdateCount();
			// String detail_code = acourseCodeService.selectDetailCode();
			// model.addAttribute(detail_code);

			if (result > 0) {
				System.out.println("삭제 성공");
				return result;
			} else {
				System.out.println("삭제 실패");
				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			logger.info("+ End " + className + ".surveyDelete");
		}
	}
	
	//설문지 수정
	@RequestMapping("/surveyUpdate.do")
	@ResponseBody
	public String surveyUpdate(@RequestParam Map<String, Object> paramMap) {
	    	 try {
	    		 System.out.println("test22");
	    		 System.out.println(paramMap);
	    		 paramMap.get("survey_no");
	             paramMap.get("survey_name");
	             
	             int result = surveyService.surveyUpdate(paramMap);
	             if (result > 0) {
	            	 System.out.println("수정 성공");
	                 return "수정 성공";
	             } else {
	            	 System.out.println("수정 실패");
	                 return "수정 실패";
	             }
	    	 }catch (Exception e) {
			            e.printStackTrace();
			            return "Error : " + e.getMessage();
			        }finally {
			        	logger.info("+ End " + className + ".surveyUpdate");
					}
		    	
		    }
	
	//질문등록
	@RequestMapping("/questionInsert.do")
	@ResponseBody
	public Map<String, Object> questionInsert (Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
			
			int survey_no = Integer.parseInt((String) paramMap.get("survey_no")); 
			//웹에서 가져온 survey_no을 String으로 캐스팅하고 다시 Int형으로 변환해줌
		    String survey_question_text = (String) paramMap.get("survey_question_text");
		    String question_choiced = (String) paramMap.get("question_choiced");
		    String survey_question_type = (String) paramMap.get("survey_question_type");
		    
		    paramMap.put("survey_no", survey_no);
		    paramMap.put("survey_question_text", survey_question_text);
		    paramMap.put("question_choiced", question_choiced);
		    paramMap.put("survey_question_type", survey_question_type);
			
			surveyService.questionInsert(paramMap);
			surveyService.surveyUpdateCount();
			
			
			logger.info("+ Start " + className + ".surveyInsert");
			logger.info("   - paramMap : " + paramMap);
			
			Map<String, Object> resultMap = new HashMap<String, Object>();
		
			return resultMap; 
		
	}
	
	//질문관리 입력창 들어갔을 때
	@RequestMapping("/categoryList.do")
	@ResponseBody
	public Map<String, Object> categoryList (Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
			
			logger.info("+ Start " + className + ".categoryList");
			logger.info("   - paramMap : " + paramMap);
			
			
			Map<String, Object> resultMap = new HashMap<String, Object>();
			
			List<SurveyChoiceContentModel> categoryList = surveyService.categoryList(paramMap);
			List<SurveyChoiceContentModel> choiceList = surveyService.choiceList(paramMap);
			
			resultMap.put("categoryList", categoryList);
			resultMap.put("choiceList", choiceList);
			
			logger.info("+ End " + className + ".categoryList");

			return resultMap;
		
	}
	
	//질문삭제
	@RequestMapping("/questionDelete.do")
	@ResponseBody
	public String questionDelete (Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		try {
			int survey_no = Integer.parseInt((String) paramMap.get("survey_no")); 
			int survey_question_no = Integer.parseInt((String) paramMap.get("survey_question_no")); 
			System.out.println(survey_no);
			System.out.println(survey_question_no);
			
			logger.info("+ Start " + className + ".questionDelete");
			logger.info("   - paramMap : " + paramMap);
			
			int result = surveyService.questionDelete(paramMap);
			surveyService.surveyUpdateCount();
            if (result > 0) {
            	System.out.println(survey_question_no+"이 삭제 되었습니다.");
                return "삭제 성공";
            } else {
            	System.out.println(survey_question_no+"삭제 실패");
                return "삭제 실패";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error : " + e.getMessage();
        }finally {
        	logger.info("+ End " + className + ".questionDelete");
		}
	}
	
	//질문수정
	@RequestMapping("/questionUpdate.do")
	@ResponseBody
		public String questionUpdate (Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
				HttpServletResponse response, HttpSession session) throws Exception {
			try {
				int survey_no = Integer.parseInt((String) paramMap.get("survey_no")); 
				int survey_question_no = Integer.parseInt((String) paramMap.get("survey_question_no")); 
			    String survey_question_text = (String) paramMap.get("survey_question_text");
			    String question_choiced = (String) paramMap.get("question_choiced");
			    String survey_question_type = (String) paramMap.get("survey_question_type");
				
			    System.out.println(survey_no);
			    System.out.println(survey_question_no);
			    System.out.println(survey_question_text);
			    System.out.println(question_choiced);
			    System.out.println(survey_question_type);
			    
				logger.info("+ Start " + className + ".questionUpdate");
				logger.info("   - paramMap : " + paramMap);
				
				int result = surveyService.questionUpdate(paramMap);
				surveyService.surveyUpdateCount();
	            if (result > 0) {
	            	System.out.println(survey_question_no+"번 질문이 수정 되었습니다.");
	                return "수정 성공";
	            } else {
	            	System.out.println(survey_question_no+"번 질문 수정 실패");
	                return "수정 실패";
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            return "Error : " + e.getMessage();
	        }finally {
	        	logger.info("+ End " + className + ".questionUpdate");
			}
		}
		
		// 강의에 설문등록하기
	@RequestMapping("/surveyIntoCourse.do")
	@ResponseBody
	public String surveyIntoCourse (Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		try {
			int survey_no = Integer.parseInt((String) paramMap.get("survey_no")); 
			int course_no = Integer.parseInt((String) paramMap.get("course_no")); 
		    
			logger.info("+ Start " + className + ".surveyIntoCourse");
			logger.info("   - paramMap : " + paramMap);
			
			int result = surveyService.surveyIntoCourse(paramMap);
            if (result > 0) {
            	System.out.println(survey_no+"번 설문이 "+ course_no +"강의에 등록 되었습니다.");
                return "등록 성공";
            } else {
            	System.out.println(survey_no+"번 설문 등록 실패");
                return "등록 실패";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error : " + e.getMessage();
        }finally {
        	logger.info("+ End " + className + ".surveyIntoCourse");
		}
	}	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	

}
