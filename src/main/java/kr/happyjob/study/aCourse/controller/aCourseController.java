package kr.happyjob.study.aCourse.controller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.happyjob.study.aCourse.model.aCourseModel;
import kr.happyjob.study.aCourse.service.aCourseService;

@Controller
@RequestMapping("/acourse/")
public class aCourseController {
	
	@Autowired
	aCourseService acourseService;
	
	   // Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	   // Get class name for logger
	private final String className = this.getClass().toString();
	   
	   // 강의 코드 리스트 출력
	   @RequestMapping("aCourseList.do")
	   @ResponseBody
	   public Map<String, Object> aCourseList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
               HttpServletResponse response, HttpSession session) throws Exception {
				logger.info("+ Start " + className + ".aCourseList");
				logger.info("   - paramMap : " + paramMap);
				
				List<aCourseModel> aCourseListModel = acourseService.aCourseList(paramMap);
				
				Map<String, Object> resultMap = new HashMap<>();
				
				
				resultMap.put("listdate", aCourseListModel);
				
				logger.info("+ End " + className + ".aCourseList");
					return resultMap;
				}
	   
	   // 강의 등록
	    @RequestMapping("aCourseInsert.do")
	    @ResponseBody
	   public String aCourseInsert(@RequestParam("detail_name") String detail_name) throws Exception{
	        try {
	        	logger.info("+ Start " + className + ".aCourseInsert");
				logger.info("   - detail_name : " + detail_name);
	            int result = acourseService.aCourseInsert(detail_name);
//	            String detail_code = acourseService.selectDetailCode();
//	            model.addAttribute(detail_code);
	            
	            if (result > 0) {
	                return "등록 성공";
	            } else {
	                return "등록 실패";
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            return "Error adding course: " + e.getMessage();
	        }finally {
	        	logger.info("+ End " + className + ".aCourseInsert");
			}

	   }
	    
	    //다음강의코드번호 출력
	    @RequestMapping("nextCodeSelect.do")
	    @ResponseBody
	    public String nextCodeSelect(Model model) {
	        try {
	            String detail_code = acourseService.nextCodeSelect();
	            logger.info("+ Start " + className + ".nextCodeSelect");
				logger.info("   - nextCodeSelect : " + detail_code);
//				model.addAttribute("newCode",newCode);
	            return detail_code;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return "Error course code";
	        }finally {
	        	logger.info("+ End " + className + ".nextCodeSelect");
			}
	    }
	    
	    // vue에서 처리하게 변경함
//	    @RequestMapping("codeSelect.do")
//	    @ResponseBody
//	    public String codeSelect(Model model,@RequestParam("detail_name") String detail_name) {
//	        try {
//	            String detail_code = acourseService.codeSelect();
//	            logger.info("+ Start " + className + ".codeSelect");
//				logger.info("   - codeSelect : " + detail_code);
////				model.addAttribute("newCode",newCode);
//	            return detail_code;
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	            return "Error course code";
//	        }finally {
//	        	logger.info("+ End " + className + ".codeSelect");
//			}
//	    }
	    
	    // 선택 강의코드 이름 수정
	    //@PutMapping("/codeUpdate") @ResopnseBody  @RequestBody

	    @RequestMapping("/codeUpdate.do")
	    public String codeUpdate(@RequestParam Map<String, Object> paramMap) {
	    	 try {
	    		 System.out.println("test22");
	    		 System.out.println(paramMap);
	    		 paramMap.get("detail_code");
	             paramMap.get("detail_name");

	             int result = acourseService.codeUpdate(paramMap);
	             String response;
	             if (result > 0) {
	            	 System.out.println("수정 성공");
	                 return response = "수정 성공";
	             } else {
	            	 System.out.println("수정 실패");
	                 return response = "수정 실패";
	             }
	    	  } catch (Exception e) {
		            e.printStackTrace();
		            return "Error : " + e.getMessage();
		        }finally {
		        	logger.info("+ End " + className + ".codeUpdate");
				}
	    	
	    }
	    
	    
	    
	    
	    
	    
	    //선택 강의코드 삭제
	    @RequestMapping("codeDelete.do")
	    @ResponseBody
	    public String codeDelete(@RequestParam("detail_code") String detail_code) throws Exception{
	        try {
	        	logger.info("+ Start " + className + ".codeDelete");
				logger.info("   - detail_code : " + detail_code);
	            int result = acourseService.codeDelete(detail_code);
//	            String detail_code = acourseService.selectDetailCode();
//	            model.addAttribute(detail_code);
	            
	            if (result > 0) {
	            	System.out.println("삭제 성공");
	                return "삭제 성공";
	            } else {
	            	System.out.println("삭제 실패");
	                return "삭제 실패";
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            return "Error : " + e.getMessage();
	        }finally {
	        	logger.info("+ End " + className + ".codeDelete");
			}

	   }
	    
	 // 키워드 검색
		   @RequestMapping("codeSearch.do")
		   @ResponseBody
		   public Map<String, Object> codeSearch(Model model, @RequestParam String word, HttpServletRequest request,
	               HttpServletResponse response, HttpSession session) throws Exception {
					logger.info("+ Start " + className + ".codeSearch");
					logger.info("   - 검색단어 : " + word);
					
					List<aCourseModel> aCourseListModel = acourseService.codeSearch(word);
					
					Map<String, Object> resultMap = new HashMap<>();
					
					
					resultMap.put("listdate", aCourseListModel);
					
					logger.info("+ End " + className + ".codeSearch");
						return resultMap;
					}
	   
}
