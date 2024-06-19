package kr.happyjob.study.support.service;

import java.nio.charset.StandardCharsets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import kr.happyjob.study.support.dao.ClassScheduleDao;
import kr.happyjob.study.tCourse.model.DayoffVO;

@Service
public class ClassScheduleServiceImpl implements ClassScheduleService {
	
	@Autowired
	ClassScheduleDao classScheduleDao;
	
	@Value("${api.key}")
	String apiKey;
	
	@Value("${api.url}")
	String apiUrl;

	@Override
	public List<DayoffVO> listClassSchedule(Map<String, Object> paramMap) throws Exception {
		return classScheduleDao.listClassSchedule(paramMap);
	}

	@Override
	public int totalClassSchedule(Map<String, Object> paramMap) throws Exception {
		return classScheduleDao.totalClassSchedule(paramMap);
	}

	@Override
	public DayoffVO keySchedule(Map<String, Object> paramMap) throws Exception {
		return classScheduleDao.keySchedule(paramMap);
	}

	@Override
	public Map<String, Object> saveSchedule(Map<String, Object> paramMap) throws Exception {
		Map<String, Object> returnMap = new HashMap<>();
		
		String action = (String) paramMap.get("paction");
		String msg = "";
		
		if ("I".equals(action)) {
			
			int sql1 = classScheduleDao.insertSchedule(paramMap);
			
			if (sql1 >= 0) {
				msg = "저장 되었습니다.";
			} else {
				msg = "저장 실패 되었습니다.";
			}
		} else if ("U".equals(action)) {
			
			int sql1 = classScheduleDao.updateSchedule(paramMap);
			
			if (sql1 >= 0) {
				msg = "수정 되었습니다.";
			} else {
				msg = "수정 실패 되었습니다.";
			}
			
		} else if ("D".equals(action)) {
			
			int sql1 = classScheduleDao.deleteSchedule(paramMap);
			
			if (sql1 >= 0) {
				msg = "삭제 되었습니다.";
			} else {
				msg = "삭제 실패 되었습니다.";
			}
			
		} else {
			msg = "잘못된 요청 입니다.";
		}
		
		returnMap.put("resultMsg", msg);
		
		return returnMap;
	}


//	@Override
//	public Map<String, Object> apiHoliday(Map<String, Object> paramMap) throws Exception {
//	    Map<String, Object> returnMap = new HashMap<>();
//	    String msg = "API 요청 오류";
//
//	    // 데이터베이스 초기화
//	    classScheduleDao.deleteAll(paramMap);
//	    String apiKey = "qfq8h6i9plPKAxWMcw7%2FcYnBez%2F36rdwpuEVLr6Ix8jYZMUvzNMfkJhmqZPaSVyuM%2BM7NRxFz68sEHgCASRsyw%3D%3D";
//	    String apiUrl = "http://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService/getRestDeInfo";
//	    int solYear = 2024;
//	    int numOfRows = 50; 
//	    RestTemplate restTemplate = new RestTemplate();
//
//	    List<DayoffVO> holidays = new ArrayList<>();
//
//	    for (int solMonth = 1; solMonth <= 12; solMonth++) {
//	        String fullUrl = apiUrl + "?serviceKey=" + apiKey + "&solYear=" + solYear
//	                + "&solMonth=" + solMonth + "&numOfRows=" + numOfRows + "&pageNo=1";
//
//	        try {
//	            byte[] xmlbyte = restTemplate.getForObject(fullUrl, byte[].class);
//	            String xmlResponse = new String(xmlbyte, StandardCharsets.UTF_8);
//
//	            XmlMapper xmlMapper = new XmlMapper();
//	            JsonNode jsonNode = xmlMapper.readTree(xmlResponse);
//
//	            JsonNode itemnode = jsonNode.path("body").path("items").path("item");
//
//	            for (JsonNode item : itemnode) {
//	                DayoffVO holiday = DayoffVO.builder()
//	                        .dayoff_date(item.path("locdate").asText())
//	                        .dayoff_detail(item.path("dateName").asText())
//	                        .build();
//	                holidays.add(holiday);
//	            }
//	        } catch (HttpClientErrorException e) {
//	            msg = "Client Error: " + e.getMessage();
//	            e.printStackTrace();
//	            returnMap.put("resultMsg", msg);
//	            return returnMap;
//	        } catch (HttpServerErrorException e) {
//	            msg = "Server Error: " + e.getMessage();
//	            e.printStackTrace();
//	            returnMap.put("resultMsg", msg);
//	            return returnMap;
//	        } catch (Exception e) {
//	            msg = "Error: " + e.getMessage();
//	            e.printStackTrace();
//	            returnMap.put("resultMsg", msg);
//	            return returnMap;
//	        }
//	    }
//
//	    int sqlresult = classScheduleDao.insertApi(holidays);
//
//	    if (sqlresult >= 0) msg = "성공적으로 가져왔습니다.";
//	    else msg = "SQL 오류";
//
//	    returnMap.put("resultMsg", msg);
//
//	    return returnMap;
//	}
	
	
	@Override
	public Map<String, Object> apiHoliday(Map<String, Object> paramMap) throws Exception {
		Map<String, Object> returnMap = new HashMap<>();
		String msg = "API요청 오류";
		
		classScheduleDao.deleteAll(paramMap);
		
		int solYear = 2024;
		int numOfRows = 50;
		int pageNo = 1;
		
        String fullUrl = apiUrl + "?serviceKey=" + apiKey + "&solYear=" + solYear
                + "&numOfRows=" + numOfRows + "&pageNo=" + pageNo;
//		String fullUrl = "";
        
        RestTemplate restTemplate = new RestTemplate();
        
        byte[] xmlbyte  = restTemplate.getForObject(fullUrl, byte[].class);
        String xmlResponse = new String(xmlbyte, StandardCharsets.UTF_8);
        
        XmlMapper xmlMapper = new XmlMapper();
        JsonNode jsonNode = xmlMapper.readTree(xmlResponse);
        
        List<DayoffVO> holidays = new ArrayList<>();
		
		JsonNode itemnode = jsonNode.path("body").path("items").path("item");
		
		
        for (JsonNode item : itemnode) {
        	DayoffVO holiday = DayoffVO.builder().dayoff_date(item.path("locdate").asText())
        					  .dayoff_detail(item.path("dateName").asText())
        					  .build();
            holidays.add(holiday);
        }
        
        int sqlresult = classScheduleDao.insertApi(holidays);
        
        if (sqlresult >= 0) msg = "성공적으로 가져왔습니다.";
        else msg = "SQL오류";
		
		returnMap.put("resultMsg", msg);
        
		return returnMap;
	}
	


}
