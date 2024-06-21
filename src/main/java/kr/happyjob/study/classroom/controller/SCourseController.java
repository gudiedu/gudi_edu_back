package kr.happyjob.study.classroom.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

		// 강의관리 필터링(수업만족도 응답 여부에 따라)
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String status = (String) paramMap.get("status");
		if (status != null && !status.isEmpty()) {
			sStudentCourseInfo = sStudentCourseInfo.stream().filter(course -> {
				if ("completed".equals(status)) {
					return "Y".equals(course.getSurvey_completed());
				} else if ("incompleted".equals(status)) {
					Date courseEndDate;
					try {
						courseEndDate = dateFormat.parse(course.getCourse_end_date());
						return "N".equals(course.getSurvey_completed()) && new Date().after(courseEndDate);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return true;
			}).collect(Collectors.toList());
			totalCnt = sStudentCourseInfo.size();
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

	// 특정 강의 세부 정보 조회_Minji
	@RequestMapping("sCourseInfo.do")
	@ResponseBody
	public Map<String, Object> sCourseInfo(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("+ Start " + className + ".sCourseInfo");
		logger.info("   - paramMap : " + paramMap);

		paramMap.put("currentLoginID", (String) session.getAttribute("loginId"));

		Map<String, Object> returnMap = new HashMap<String, Object>();

		List<SCourseDto> sCourseInfo = sCourseService.sCourseInfo(paramMap);

		returnMap.put("infoResult", sCourseInfo);

		logger.info("+ End " + className + ".sCourseInfo");

		return returnMap;

	}

	// 특정 강의 세부 정보 조회_Minji
	@RequestMapping("sCourseDetail.do")
	@ResponseBody
	public Map<String, Object> sCourseDetail(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("+ Start " + className + ".sCourseDetail");
		logger.info("   - paramMap : " + paramMap);

		paramMap.put("loginID", (String) session.getAttribute("loginId"));

		Map<String, Object> returnMap = new HashMap<String, Object>();

		List<SCourseDto> sCourseDetail = sCourseService.sCourseDetail(paramMap);

		returnMap.put("detailResult", sCourseDetail);

		logger.info("+ End " + className + ".sCourseDetail");

		return returnMap;

	}

	// 수강신청 가능 강의 목록 조회_Minji
	@RequestMapping("sEnrollList.do")
	@ResponseBody
	public Map<String, Object> sEnrollList(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("+ Start " + className + ".sEnrollList");
		logger.info("   - paramMap : " + paramMap);

		paramMap.put("studentSignedID", (String) session.getAttribute("loginId"));

		Map<String, Object> returnMap = new HashMap<String, Object>();

		List<SCourseDto> sEnrollList = sCourseService.sEnrollList(paramMap);

		returnMap.put("enrollList", sEnrollList);
		returnMap.put("studentSignedID", (String) session.getAttribute("loginId"));

		logger.info("+ End " + className + ".sEnrollList");

		return returnMap;

	}

	// 수강신청 + 수강신청 중복 방지
	@RequestMapping("sEnrollInsert.do")
	@ResponseBody
	public Map<String, Object> sEnrollInsert(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("+ Start " + className + ".sEnrollInsert");
		logger.info("   - paramMap : " + paramMap);

		Map<String, Object> returnMap = new HashMap<String, Object>();

		String resultMsg = "";
		String studentSignedID = (String) session.getAttribute("loginId");
		paramMap.put("studentSignedID", studentSignedID);

		// 수강신청 중복 여부 확인
		int alreadyEnrolled = sCourseService.checkEnrollment(paramMap);
		System.out.println("alreadyEnrolled :" + alreadyEnrolled);

		if (alreadyEnrolled > 0) {
			resultMsg = "이미 수강신청한 과목입니다. 다시 확인해주세요.";
			returnMap.put("result", -1);
			returnMap.put("resultMsg", resultMsg);
		} else {
			int sqlReturn = sCourseService.sEnrollInsert(paramMap, request);

			if (sqlReturn >= 0) {
				resultMsg = "수강신청이 완료되었습니다.";
				returnMap.put("result", 1); // 성공 코드
			} else {
				resultMsg = "수강신청이 되지 않았습니다. 다시 확인해주세요.";
				returnMap.put("result", 0); // 실패 코드
			}
			returnMap.put("resultMsg", resultMsg);
		}

		logger.info("+ End " + className + ".sEnrollInsert");

		return returnMap;
	}

	// 시험관련 리스트 조회하기_Minji
	@RequestMapping("sTestList.do")
	@ResponseBody
	public Map<String, Object> sTestList(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("+ Start " + className + ".sTestList");
		logger.info("   - paramMap : " + paramMap);

		paramMap.put("studentSignedID", (String) session.getAttribute("loginId"));

		Map<String, Object> returnMap = new HashMap<String, Object>();

		List<SCourseDto> sTestList = sCourseService.sTestList(paramMap);

		returnMap.put("testList", sTestList);
		returnMap.put("studentSignedID", (String) session.getAttribute("loginId"));

		logger.info("+ End " + className + ".sTestList");

		return returnMap;
	}

	// 시험 문제 조회하기_Minji
	@RequestMapping("sCreateTest.do")
	@ResponseBody
	public Map<String, Object> sCreateTest(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("+ Start " + className + ".sCreateTest");
		logger.info("   - paramMap : " + paramMap);

		paramMap.put("studentSignedID", (String) session.getAttribute("loginId"));

		Map<String, Object> returnMap = new HashMap<String, Object>();

		List<SCourseDto> sCreateTest = sCourseService.sCreateTest(paramMap);

		returnMap.put("createTest", sCreateTest);
		returnMap.put("studentSignedID", (String) session.getAttribute("loginId"));

		logger.info("+ End " + className + ".sCreateTest");

		return returnMap;

	}

	// 시험응시하기_Minji
	@RequestMapping("sTestSubmit.do")
	@ResponseBody
	public Map<String, Object> sTestSubmit(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("+ Start " + className + ".sTestSubmit");
		logger.info("   - paramMap : " + paramMap);

		Map<String, Object> returnMap = new HashMap<String, Object>();

		int sqlReturn = 0;
		String resultMsg = "";

		// selectedChoice 값을 쉼표로 구분된 문자열로 가져옴
		String selectedChoiceStr = (String) paramMap.get("selectedChoice");
		// 배열로 변환
		String[] answerSelected = selectedChoiceStr.split(",");
		System.out.println(Arrays.toString(answerSelected)); // 배열에 넣었쥬

		String testQuestionNoStr = (String) paramMap.get("testNo");
		String[] testQuestionNo = testQuestionNoStr.split(",");
		System.out.println("testQuestionNo" + Arrays.toString(testQuestionNo));

		// paramMap에 변환된 배열을 추가
		paramMap.put("answerSelected", answerSelected);
		paramMap.put("testQuestionNo", testQuestionNo);

		String studentSignedID = (String) session.getAttribute("loginId");
		paramMap.put("studentSignedID", studentSignedID);

		sqlReturn = sCourseService.sTestSubmit(paramMap, request);

		if (sqlReturn > 0) {
			resultMsg = "시험이 제출되었습니다. 수고하셨습니다.";
		} else {
			resultMsg = "시험이 제출되지 않았습니다. 다시 확인해주세요.";
		}

		returnMap.put("result", sqlReturn);
		returnMap.put("resultMsg", resultMsg);

		logger.info("+ End " + className + ".sTestSubmit");

		return returnMap;

	}

	// 시험 채점후 등록하기_Minji
	@RequestMapping("sTestCalculate.do")
	@ResponseBody
	public Map<String, Object> sTestCalculate(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("+ Start " + className + ".sTestCalculate");
		logger.info("   - paramMap : " + paramMap);

		Map<String, Object> returnMap = new HashMap<String, Object>();

		int sqlReturn = 0;
		String resultMsg = "";

		List<SCourseDto> sCreateTest = sCourseService.sCreateTest(paramMap);

		String studentSignedID = (String) session.getAttribute("loginId");
		paramMap.put("studentSignedID", studentSignedID);

		sqlReturn = sCourseService.sTestCalculate(paramMap, request);

		if (sqlReturn >= 0) {
			resultMsg = "시험 채점이 완료되었습니다. 시험결과를 확인해주세요.";
		} else {
			resultMsg = "시험이 채첨되지 않았습니다. 다시 확인해주세요.";
		}

		returnMap.put("createTest", sCreateTest);

		returnMap.put("calculateResult", sqlReturn);
		returnMap.put("calculateResultMsg", resultMsg);
		returnMap.put("studentSignedID", (String) session.getAttribute("loginId"));

		logger.info("+ End " + className + ".sTestCalculate");

		return returnMap;

	}

	// 시험 문제 조회하기_Minji
	@RequestMapping("sShowingTestResult.do")
	@ResponseBody
	public Map<String, Object> sShowingTestResult(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("+ Start " + className + ".sShowingTestResult");
		logger.info("   - paramMap : " + paramMap);

		paramMap.put("studentSignedID", (String) session.getAttribute("loginId"));

		Map<String, Object> returnMap = new HashMap<String, Object>();

		List<SCourseDto> sShowingTestResult = sCourseService.sShowingTestResult(paramMap);

		returnMap.put("showingResult", sShowingTestResult);
		returnMap.put("studentSignedID", (String) session.getAttribute("loginId"));

		logger.info("+ End " + className + ".sShowingTestResult");

		return returnMap;

	}
}