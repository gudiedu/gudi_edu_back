package kr.happyjob.study.sAlert.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.happyjob.study.sAlert.dto.SQnaDto;
import kr.happyjob.study.sAlert.service.SQnaService;
import lombok.extern.slf4j.Slf4j;

@Slf4j

@Controller
public class SQnaController {
	
	@Autowired
	SQnaService sQnaService;
	
	// 질문 내역 조회_created_at_240605_by Minji
	@RequestMapping("/sAlert/qna.do")
	@ResponseBody
	public Map<String, Object> sListQna (Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	         HttpServletResponse response, HttpSession session) throws Exception {
		
		Map<String, Object> sQnaMap = new HashMap<String, Object>();
		
		List<SQnaDto> listQna = sQnaService.sListQna(paramMap);
		
		//logger.info("info log={}", listQna);
		
		// listQna 
		sQnaMap.put("listQna", listQna);
	
		return sQnaMap;
		
	}
	
	

}
