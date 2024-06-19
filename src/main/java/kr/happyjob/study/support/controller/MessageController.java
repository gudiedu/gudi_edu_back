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
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.happyjob.study.common.socket.MessageVO;
import kr.happyjob.study.support.service.ChatRoomService;

@Controller
public class MessageController {
	
	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();

	
	@MessageMapping("/chat/{chatRoomId}")
	@SendTo("/topic/messages/{chatRoomId}")
	public MessageVO sendMessage(MessageVO message) throws Exception {
		System.out.println(">>>>" + message.toString());
		return message;
	}
	
	public void broadcastMessage(String chatRoomId, MessageVO message) {
        messagingTemplate.convertAndSend("/topic/messages/" + chatRoomId, message);
    }
}
