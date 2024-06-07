package kr.happyjob.study.aAlert.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.happyjob.study.aAlert.model.ASuggestionDTO;
import kr.happyjob.study.aAlert.service.ASuggestionService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ASuggestionController {
	
	private final ASuggestionService aSuggestionService;
	
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	//임시 URL
	@RequestMapping("/aSuggestion")
	public List<ASuggestionDTO> searchSuggestion(Model model,@RequestParam Map<String, Object> paramMap) throws Exception{
		return aSuggestionService.searchSuggestion(paramMap);
	}

}
