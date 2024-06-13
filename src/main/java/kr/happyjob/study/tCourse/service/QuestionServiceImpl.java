package kr.happyjob.study.tCourse.service;


import java.util.List;
import java.util.Map;





import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.tCourse.dao.QuestionDao;
import kr.happyjob.study.tCourse.model.QuestionVO;

@Service
public class QuestionServiceImpl implements QuestionService {

	    // Set logger
	 	private final Logger logger = LogManager.getLogger(this.getClass());
		
		// Get class name for logger
		private final String className = this.getClass().toString();


@Autowired
QuestionDao questionDao;


/** qna 목록 조회 */
public List<QuestionVO> listquestion(Map<String, Object> paramMap) throws Exception {
	
	return questionDao.listquestion(paramMap);
}

/** qna 목록 카운트 조회 */
public int totalcntquestion(Map<String, Object> paramMap) throws Exception {
	 
	return questionDao.totalcntquestion(paramMap);
}


		
		
}
