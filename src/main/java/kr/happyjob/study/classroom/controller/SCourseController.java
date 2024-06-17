package kr.happyjob.study.classroom.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.happyjob.study.classroom.dto.SCourseDto;
import kr.happyjob.study.classroom.model.SDayoffModel;
import kr.happyjob.study.classroom.service.SCourseService;

@Controller
@RequestMapping("/classroom/")
public class SCourseController {

	@Autowired
	SCourseService sCourseService;

	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();

	@RequestMapping("sStudentCourseList.do")
	@ResponseBody
	public Map<String, Object> sStudentCourseList(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("+ Start " + className + ".sStudentCourseList");
		logger.info("   - paramMap : " + paramMap);

		paramMap.put("loginID", (String) session.getAttribute("loginId"));

		int currentPage = Integer.parseInt((String) paramMap.get("currentPage"));
		int pageSize = Integer.parseInt((String) paramMap.get("pageSize"));

		int startPoint = (currentPage - 1) * pageSize;

		paramMap.put("startPoint", startPoint);
		paramMap.put("pageSize", pageSize);

		Map<String, Object> returnMap = new HashMap<String, Object>();

		List<SCourseDto> sStudentCourseInfo = sCourseService.sStudentCourseInfo(paramMap);
		int totalCnt = sCourseService.totalCntCourse(paramMap);

		for (SCourseDto course : sStudentCourseInfo) {
			paramMap.put("pCourseNo", course.getCourse_no());
			int surveyComplete = sCourseService.sSurveyComplete(paramMap);
			String surveyCompleteMsg = surveyComplete > 0 ? "Y" : "N";
			course.setSurvey_completed(surveyCompleteMsg);
		}

		returnMap.put("sStudentCourseInfo", sStudentCourseInfo);
		returnMap.put("totalCnt", totalCnt);
		

		logger.info("+ End " + className + ".sStudentCourseList");

		return returnMap;
	}

	@RequestMapping("sStudentAttendance.do")
	@ResponseBody
	public Map<String, Object> sAttendanceList(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("+ Start " + className + ".sStudentAttendance");
		logger.info("   - paramMap : " + paramMap);

		paramMap.put("loginID", (String) session.getAttribute("loginId"));

		Map<String, Object> returnMap = new HashMap<String, Object>();

		SCourseDto sStudentSelectedCourseInfo = sCourseService.sStudentSelectedCourseInfo(paramMap);
		int attendanceDays = sCourseService.sAttendanceDays(paramMap);
		int absenceDays = sCourseService.sAbsenceDays(paramMap);
		List<SCourseDto> sAttendanceNotes = sCourseService.sAttendanceNotes(paramMap);
		List<SDayoffModel> sDayoffInfo = sCourseService.sDayoffInfo(paramMap);

		returnMap.put("sStudentSelectedCourseInfo", sStudentSelectedCourseInfo);
		returnMap.put("attendanceDays", attendanceDays);
		returnMap.put("absenceDays", absenceDays);
		returnMap.put("sDayoffInfo", sDayoffInfo);
		returnMap.put("sAttendanceNotes", sAttendanceNotes);

		logger.info("+ End " + className + ".sStudentAttendance");

		return returnMap;
	}

	@RequestMapping("sStudentSatisfaction.do")
	@ResponseBody
	public Map<String, Object> sStudentSatisfaction(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("+ Start " + className + ".sStudentSatisfaction");
		logger.info("   - paramMap : " + paramMap);

		Map<String, Object> returnMap = new HashMap<String, Object>();

		List<SCourseDto> sSatisfactionQuestion = sCourseService.sSatisfactionQuestion(paramMap);
		List<SCourseDto> sSatisfactionAnswer = sCourseService.sSatisfactionAnswer(paramMap);

		returnMap.put("sSatisfactionQuestion", sSatisfactionQuestion);
		returnMap.put("sSatisfactionAnswer", sSatisfactionAnswer);

		logger.info("+ End " + className + ".sStudentSatisfaction");

		return returnMap;
	}

	@RequestMapping(value = "sInsertSurvey.do", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public Map<String, Object> sInsertSurvey(@RequestBody List<Map<String, Object>> paramMapList,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		logger.info("+ Start " + className + ".sInsertSurvey");
		logger.info("   - paramMapList : " + paramMapList);

		Map<String, Object> returnMap = new HashMap<>();

		String loginId = (String) session.getAttribute("loginId");
		int totalSqlReturn = 0;
		String resultMsg = "";

		try {
			for (Map<String, Object> paramMap : paramMapList) {
				paramMap.put("loginID", loginId);
				int sqlReturn = sCourseService.sInsertSurvey(paramMap);
				if (sqlReturn < 1) {
					throw new Exception("설문 저장 실패 되었습니다.");
				}
				totalSqlReturn += sqlReturn;
			}
			resultMsg = "설문 저장 되었습니다.";
		} catch (Exception e) {
			resultMsg = e.getMessage();
			totalSqlReturn = -1;
		}

		returnMap.put("result", totalSqlReturn);
		returnMap.put("resultMsg", resultMsg);

		logger.info("+ End " + className + ".sInsertSurvey");

		return returnMap;
	}

}