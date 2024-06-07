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
	    
	    @RequestMapping("/codeSelect")
	    @ResponseBody
	    public String codeSelect(Model model) {
	        try {
	            String detail_code = acourseService.codeSelect();
	            logger.info("+ Start " + className + ".codeSelect");
				logger.info("   - codeSelect : " + detail_code);
//				model.addAttribute("newCode",newCode);
	            return detail_code;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return "Error course code";
	        }finally {
	        	logger.info("+ End " + className + ".codeSelect");
			}
	    }
	    
	    
	    
	   
	   
}
