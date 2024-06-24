package kr.happyjob.study.tCourse.controller;

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

import kr.happyjob.study.tCourse.model.LearningMaterialsDTO;
import kr.happyjob.study.tCourse.service.ResourceService;

@Controller
@RequestMapping("/tCourse/")
public class ResourceController {

	@Autowired
	private ResourceService resourceService;

	// 로거 설정
	private final Logger logger = LogManager.getLogger(this.getClass());

	// 로거를 위한 클래스 이름 가져오기
	private final String className = this.getClass().toString();

	@RequestMapping("resourceList")
	@ResponseBody
	public Map<String, Object> getResourceList(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("+ Start " + className + ".resourceList");
		logger.info("   - paramMap : " + paramMap);

		// 현재 로그인한 강사의 loginID를 세션에서 가져와서 paramMap에 추가
		String loginID = (String) session.getAttribute("loginId");
		logger.info("   - loginID from session: " + loginID); // 세션에서 가져온
																// loginID 로그 출력

		// loginID가 null이면, 에러 로그 출력
		if (loginID == null) {
			logger.error("   - Error: loginID is null");
			throw new Exception("로그인이 필요합니다.");
		}
		paramMap.put("loginID", loginID); // loginID를 paramMap에 추가

		int currentPage = Integer
				.parseInt((String) (paramMap.get("currentPage") == null ? "1" : paramMap.get("currentPage")));
		int pageSize = Integer.parseInt((String) (paramMap.get("pageSize") == null ? "10" : paramMap.get("pageSize")));
		int startPoint = (currentPage - 1) * pageSize;

		paramMap.put("pageSize", pageSize);
		paramMap.put("startPoint", startPoint);

		Map<String, Object> returnMap = new HashMap<>();
		List<LearningMaterialsDTO> resourceList = resourceService.getResourceList(paramMap);
		int totalCnt = resourceService.countResourceList(paramMap);

		returnMap.put("resourceList", resourceList);
		returnMap.put("totalCnt", totalCnt);

		logger.info("+ End ResourceController.getResourceList");

		return returnMap;
	}

	@RequestMapping("addResource")
	@ResponseBody
	public Map<String, Object> addResource(@RequestParam Map<String, Object> paramMap, HttpSession session,
			HttpServletRequest request) throws Exception {
		logger.info("+ Start " + className + ".addResource");
		logger.info("   - paramMap : " + paramMap);

		String loginID = (String) session.getAttribute("loginId");
		if (loginID == null) {
			throw new Exception("로그인이 필요합니다.");
		}

		paramMap.put("loginID", loginID);
		paramMap.put("resource_created_at", new java.util.Date());
		paramMap.put("resource_writer", loginID);

		if (paramMap.get("course_no") == null || paramMap.get("course_no").toString().trim().isEmpty()) {
			throw new Exception("course_no가 필요합니다.");
		}

		int result = resourceService.addResource(paramMap, request);

		Map<String, Object> returnMap = new HashMap<>();
		returnMap.put("result", result > 0 ? "success" : "fail");

		logger.info("+ End " + className + ".addResource");
		return returnMap;
	}

	@RequestMapping("reCourseList")
	@ResponseBody
	public Map<String, Object> getCourseList(HttpSession session) throws Exception {
		logger.info("+ Start ResourceController.getCourseList");

		String loginID = (String) session.getAttribute("loginId");
		if (loginID == null) {
			throw new Exception("로그인이 필요합니다.");
		}

		List<LearningMaterialsDTO> courseList = resourceService.getCourseListByLoginID(loginID);

		Map<String, Object> returnMap = new HashMap<>();
		returnMap.put("courseList", courseList);

		logger.info("+ End ResourceController.getCourseList");
		return returnMap;
	}

	// 학습자료 조회
	@RequestMapping("getResource")
	@ResponseBody
	public Map<String, Object> getResource(@RequestParam int resourceNo) throws Exception {
		logger.info("+ Start " + className + ".getResource");

		LearningMaterialsDTO resource = resourceService.getResourceById(resourceNo);
		Map<String, Object> returnMap = new HashMap<>();
		returnMap.put("resource", resource);

		logger.info("+ End " + className + ".getResource");
		return returnMap;
	}

	// 학습자료 수정
	@RequestMapping("updateResource")
	@ResponseBody
	public Map<String, Object> updateResource(@RequestParam Map<String, Object> paramMap, HttpSession session,
			HttpServletRequest request) throws Exception {
		logger.info("+ Start " + className + ".updateResource");
		logger.info("   - paramMap : " + paramMap);

		String loginID = (String) session.getAttribute("loginId");
		if (loginID == null) {
			throw new Exception("로그인이 필요합니다.");
		}

		paramMap.put("loginID", loginID);
		paramMap.put("resource_edited_at", new java.util.Date());
		paramMap.put("resource_editor", loginID);

		LearningMaterialsDTO existingResource = resourceService
				.getResourceById(Integer.parseInt(paramMap.get("resource_no").toString()));
		if (paramMap.get("fileExits").equals("N") && existingResource != null) {
			paramMap.put("file_no", existingResource.getFile_no());
		}

		int result = resourceService.updateResource(paramMap, request);

		Map<String, Object> returnMap = new HashMap<>();
		returnMap.put("result", result > 0 ? "success" : "fail");

		logger.info("+ End " + className + ".updateResource");
		return returnMap;
	}

	// 학습자료 삭제
	@RequestMapping("deleteResource")
	@ResponseBody
	public Map<String, Object> deleteResource(@RequestParam int resourceNo) throws Exception {
		logger.info("+ Start " + className + ".deleteResource");
		logger.info("   - resourceNo : " + resourceNo);

		int result = resourceService.deleteResource(resourceNo);

		Map<String, Object> returnMap = new HashMap<>();
		returnMap.put("result", result > 0 ? "success" : "fail");

		logger.info("+ End " + className + ".deleteResource");
		return returnMap;
	}

	

}
