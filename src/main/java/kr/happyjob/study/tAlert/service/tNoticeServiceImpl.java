package kr.happyjob.study.tAlert.service;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import kr.happyjob.study.common.comnUtils.FileUtilCho;
import kr.happyjob.study.tAlert.dao.tNoticeDao;
import kr.happyjob.study.tAlert.model.tNoticeVO;

@Service
public class tNoticeServiceImpl implements tNoticeService {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private final String className = this.getClass().toString();

    @Value("${fileUpload.rootPath}")
    private String rootPath;
    
    @Value("${fileUpload.virtualRootPath}")
    private String virtualRootPath;
    
    @Value("${fileUpload.noticePath}")
    private String noticePath;
    
    @Autowired
    tNoticeDao tNoticeDao;
    
    //공지 리스트 
    public List<tNoticeVO> searchNotice(Map<String, Object> paramMap) throws Exception {
        return tNoticeDao.searchNotice(paramMap);
    }
    // 공지 갯수
    public int totalcntNotice(Map<String, Object> paramMap) throws Exception {
        return tNoticeDao.totalcntNotice(paramMap);
    }
    //공지 조회
    public tNoticeVO selectNotice(Map<String, Object> paramMap) throws Exception {
        return tNoticeDao.selectNotice(paramMap);
    }
    //공지 등록
    public int insertNotice(Map<String, Object> paramMap, HttpServletRequest request) throws Exception {
        logger.info("Starting insertNotice");

        if (request instanceof MultipartHttpServletRequest) {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            // 파일 업로드는 한 번만 수행
            Map<String, Object> fileInfo = fileUpload(multipartRequest);
            logger.info("File uploaded: " + fileInfo);

            if (fileInfo != null && !fileInfo.isEmpty()) {
                if (fileInfo.get("file_nm") != null && !fileInfo.get("file_nm").toString().isEmpty()) {
                    logger.info("Saving file");
                    int fileNo = saveFile(fileInfo);
                    logger.info("File saved with fileNo: " + fileNo);

                    paramMap.put("fileExits", "Y");
                    paramMap.put("file_no", fileNo);
                }
            }
        }

        logger.info("Inserting notice");
        int result = tNoticeDao.insertNotice(paramMap);
        logger.info("Notice inserted with result: " + result);

        return result;
    }
    	//공지 삭제 + 파일같이 
    public int deleteNotice(Map<String, Object> paramMap) throws Exception {
    	String url = tNoticeDao.selectFilePath(paramMap);
    	System.out.println("::::::::::::::::::::::::" +  url);
    	if (url != null && !url.isEmpty()) {
    		new File(url).delete();
    	}
    	
        return tNoticeDao.deleteNotice(paramMap) + tNoticeDao.deleteFileByNoticeNo(paramMap);
    }
    	//공지 수정 
    public int updateNotice(Map<String, Object> paramMap, HttpServletRequest request) throws Exception {
        logger.info("Starting updateNotice");

        if (request instanceof MultipartHttpServletRequest) {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            // 파일 업로드는 한 번만 수행
            Map<String, Object> fileInfo = fileUpload(multipartRequest);
            logger.info("File uploaded: " + fileInfo);

            if (fileInfo != null && !fileInfo.isEmpty()) {
                if (fileInfo.get("file_nm") != null && !fileInfo.get("file_nm").toString().isEmpty()) {
                    logger.info("Saving file");
                    int fileNo = saveFile(fileInfo);
                    logger.info("File saved with fileNo: " + fileNo);

                    paramMap.put("fileExits", "Y");
                    paramMap.put("file_no", fileNo);
                }
            }
        }

        logger.info("Updateing notice");
        int result = tNoticeDao.updateNotice(paramMap);
        logger.info("Notice updated with result: " + result);

        return result;
    }
    
    
    
    
    	//파일 세이브
    private int saveFile(Map<String, Object> fileInfo) throws Exception {
        logger.info("Starting saveFile");

        tNoticeVO file = new tNoticeVO();
        file.setFile_origin(fileInfo.get("file_nm").toString());
        file.setFile_local_path(fileInfo.get("vrfile_loc").toString());
        file.setFile_server_path(fileInfo.get("file_loc").toString());
        file.setFile_extension(fileInfo.get("fileExtension").toString());
        file.setFile_size(Integer.parseInt(fileInfo.get("file_size").toString()));
        
        tNoticeDao.saveFile(file);
        logger.info("File saved with file_no: " + file.getFile_no());

        return file.getFile_no();
    }
    // 파일업로드 
    private Map<String, Object> fileUpload(MultipartHttpServletRequest request) throws Exception {
        logger.info("Starting fileUpload");
        String itemFilePath = noticePath + File.separator;
        FileUtilCho fileUpload = new FileUtilCho(request, rootPath, virtualRootPath, itemFilePath);
        Map<String, Object> fileInfo = fileUpload.uploadFiles();
        logger.info("File uploaded inside fileUpload: " + fileInfo);
        return fileInfo;
    }
}