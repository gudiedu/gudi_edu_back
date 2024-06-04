package kr.happyjob.study.sAlert.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.happyjob.study.sAlert.dto.SNoticeDto;
import kr.happyjob.study.sAlert.service.SNoticeService;

@Controller
public class SNoticeController {
	
	@Autowired
	SNoticeService sNoticeService;
	
	@RequestMapping("/sListNotice.do")
	@ResponseBody
	 public Map<String, Object> sListNotice(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	         HttpServletResponse response, HttpSession session) throws Exception {
	      
//	      int currentPage = Integer.parseInt((String)paramMap.get("currentPage"));
//	      int pageSize = Integer.parseInt((String)paramMap.get("pageSize"));
//	      
//	      int startPoint = (currentPage - 1) * pageSize;
//	      
//	      paramMap.put("startPoint", startPoint);
//	      paramMap.put("pageSize", pageSize);
	      
	      Map<String, Object> returnMap = new HashMap<String, Object>();
	      
	      List<SNoticeDto> listData = sNoticeService.sListNotice(paramMap);
//	      int totalCnt = sampleNoticeService.totalCntNotice(paramMap);
	      
	      returnMap.put("listData", listData);
//	      returnMap.put("totalCnt", totalCnt);
	      
	      return returnMap;
	   } 
}