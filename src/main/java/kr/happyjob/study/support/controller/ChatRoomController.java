package kr.happyjob.study.support.controller;

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

import kr.happyjob.study.support.service.ChatRoomService;

@Controller
@RequestMapping("/support/")
public class ChatRoomController {
	
	@Autowired
	ChatRoomService chatRoomService;
	
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();

	@RequestMapping("chatRoomList")
	@ResponseBody
	public Map<String, Object> chatRoomList(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("+ Start " + className + ".chatRoomList");
		logger.info("   - paramMap : " + paramMap);

		Map<String, Object> returnmap = new HashMap<String, Object>();
		
		returnmap.put("listdata", chatRoomService.ChatRoomList(paramMap));


		logger.info("+ End " + className + ".chatRoomList");

		return returnmap;
	}
	
	@RequestMapping("chatRoomJoin")
	@ResponseBody
	public Map<String, Object> chatRoomJoin(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("+ Start " + className + ".chatRoomJoin");
		logger.info("   - paramMap : " + paramMap);
		
		paramMap.put("loginID", session.getAttribute("loginId"));
		
		
		Map<String, Object> returnmap = chatRoomService.ChatRoomJoin(paramMap);
		

		logger.info("+ End " + className + ".chatRoomJoin");

		return returnmap;
	}
	
	@RequestMapping("myChatRoomList")
	@ResponseBody
	public Map<String, Object> myChatRoomList(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		
		paramMap.put("loginID", session.getAttribute("loginId"));
		
		logger.info("+ Start " + className + ".myChatRoomList");
		logger.info("   - paramMap : " + paramMap);
		
		
		
		Map<String, Object> returnmap = new HashMap<String, Object>();
		
		returnmap.put("listdata", chatRoomService.myChatRoomList(paramMap));
		returnmap.put("loginID", session.getAttribute("loginId"));
		logger.info("+ End " + className + ".myChatRoomList");

		return returnmap;
	}
	
}
