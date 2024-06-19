package kr.happyjob.study.support.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.happyjob.study.tCourse.model.EnrollmentDTO;
import kr.happyjob.study.support.service.AttendanceService;

@Controller
@RequestMapping("/support/")
public class AttendanceController {

	@Autowired
	AttendanceService attendanceService;

	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();

	@RequestMapping("listAttendance")
	@ResponseBody
	public Map<String, Object> listAttendance(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("+ Start " + className + ".listAttendance");
		logger.info("   - paramMap : " + paramMap);

		// 1 page : 0 2 page : 10

		int currentpage = Integer.parseInt((String) paramMap.get("currentPage"));
		int pagesize = Integer.parseInt((String) paramMap.get("pageSize"));
		int startpoint = (currentpage - 1) * pagesize;
		String loginid = (String) session.getAttribute("loginId");

		paramMap.put("loginID", loginid);
		paramMap.put("pagesize", pagesize);
		paramMap.put("startpoint", startpoint);

		Map<String, Object> returnmap = new HashMap<String, Object>();

		returnmap.put("listdata", attendanceService.listAttendance(paramMap));
		returnmap.put("totalcnt", attendanceService.totalAttendance(paramMap));

		logger.info("+ End " + className + ".listAttendance");

		return returnmap;
	}

	@RequestMapping("infoAttendance")
	@ResponseBody
	public Map<String, Object> infoAttendance(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("+ Start " + className + ".listAttendance");
		logger.info("   - paramMap : " + paramMap);

		Map<String, Object> returnmap = new HashMap<String, Object>();
//		LocalDate att_today = LocalDate.now();
//		
//		paramMap.put("att_today", att_today.toString());
		
		returnmap.put("listDay", attendanceService.listDay(paramMap));
		returnmap.put("listdata", attendanceService.infoAttendance(paramMap));
		returnmap.put("totalcnt", attendanceService.totalInfoAttendance(paramMap));
		returnmap.put("attend", attendanceService.keyAttendance(paramMap));
		logger.info("+ End " + className + ".listAttendance");

		return returnmap;
	}
	
	@RequestMapping("allListAttendance")
	@ResponseBody
	public Map<String, Object> allListAttendance(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("+ Start " + className + ".allListAttendance");
		logger.info("   - paramMap : " + paramMap);

		Map<String, Object> returnmap = new HashMap<String, Object>();
		
		returnmap.put("listDay", attendanceService.listDay(paramMap));
		returnmap.put("allAttendance", attendanceService.allListAttendance(paramMap));

		logger.info("+ End " + className + ".allListAttendance");

		return returnmap;
	}
	
	@RequestMapping("/attendanceExcelDownload")
	public void responseStatExcel(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("+ Start " + className + ".attendanceExcelDownload");
	    logger.info("   - paramMap : " + paramMap);
	    
	    List<EnrollmentDTO> records =  attendanceService.allListAttendance(paramMap);
		
	    Set<String> uniqueDates = records.stream()
                .map(record -> record.getAttendance_date().substring(0,10))
                .collect(Collectors.toCollection(TreeSet::new));
	    
	    Map<String, EnrollmentDTO> studentMap = new LinkedHashMap<>();
	    for (EnrollmentDTO record : records) {
	    	String name  = record.getName();
	    	if (!studentMap.containsKey(name)) {
	    		studentMap.put(name, new EnrollmentDTO(name, record.getHp(), uniqueDates.size()));
	    	}
	    	String sdate = record.getAttendance_date().substring(0,10);
	    	studentMap.get(name).addAttendance(sdate, record.getAttendance_status());
	    }
	    
	    Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Attendance");

        Row headerRow = sheet.createRow(0);
        
        headerRow.createCell(0).setCellValue("이름");
        headerRow.createCell(1).setCellValue("휴대폰");
        int colIdx = 2;
        for (String date : uniqueDates) {
            headerRow.createCell(colIdx++).setCellValue(date);
        }
        headerRow.createCell(colIdx).setCellValue("출석률");
      

        int rowIdx = 1;
        for (EnrollmentDTO student : studentMap.values()) {
            Row row = sheet.createRow(rowIdx++);
            row.createCell(0).setCellValue(student.getName());
            row.createCell(1).setCellValue(student.getHp());

            int dateColIdx = 2;
            for (String date : uniqueDates) {
                row.createCell(dateColIdx++).setCellValue(student.attendanceStatus(date));
            }
            row.createCell(dateColIdx).setCellValue(student.attendanceRate());
        }

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=attendance.xlsx");

        workbook.write(response.getOutputStream());
        workbook.close();
	}
	

	

	@RequestMapping("saveAttendance")
	@ResponseBody
	public Map<String, Object> saveAttendance(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("+ Start " + className + ".saveAttendance");
		logger.info("   - paramMap : " + paramMap);

//		Map<String, Object> returnmap = new HashMap<String, Object>();

		Map<String, Object> returnmap = attendanceService.insertAttendance(paramMap);

		logger.info("+ End " + className + ".saveAttendance");

		return returnmap;
	}
	


}
