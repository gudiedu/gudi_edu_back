package kr.happyjob.study.aCourse.service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.happyjob.study.aCourse.dao.aCourseCodeDao;
import kr.happyjob.study.aCourse.model.aCourseCodeModel;

@Service
public class aCourseCodeServiceImpl implements aCourseCodeService  {
	// Set logger
		private final Logger logger = LogManager.getLogger(this.getClass());
		// Get class name for logger
		private final String className = this.getClass().toString();
		
		
		@Autowired
		private aCourseCodeDao acourseCodeDao;

		public List<aCourseCodeModel> aCourseList(Map<String, Object> paramMap) throws Exception {
			// TODO Auto-generated method stub
			return acourseCodeDao.aCourseList(paramMap);
		}
		
	
		public int aCourseInsert(String detail_name) throws Exception {
	        return acourseCodeDao.aCourseInsert(detail_name);
	    }
		
		// 다음 강의 코드번호 추출
		public String nextCodeSelect() throws Exception{
			return acourseCodeDao.nextCodeSelect();
		}
		
		// 공통코드에 있는 강의코드 수정
		public int codeUpdate(Map<String, Object> paramMap) throws Exception {
	        return acourseCodeDao.codeUpdate(paramMap);
	    }
		
		// 공통코드에 있는 강의코드 삭제 
		public int codeDelete(String detail_code) throws Exception {
			return acourseCodeDao.codeDelete(detail_code);
		}
		
		public List<aCourseCodeModel> codeSearch(String word) throws Exception{;
			return acourseCodeDao.codeSearch(word);
		}
		
		// 코드목록 총 갯수 조회 
		public int totalCountCode(Map<String, Object> paramMap) throws Exception{
			
			return acourseCodeDao.totalCountCode(paramMap);
		
		}
		
		
		
		// 선택한 강의 코드번호 추출
//		public String codeSelect() throws Exception{
//			return acourseCodeDao.codeSelect();
//				}
		
		
}
