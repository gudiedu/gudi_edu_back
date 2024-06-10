package kr.happyjob.study.sAlert.dto;

import kr.happyjob.study.sAlert.model.SFileModel;
import kr.happyjob.study.sAlert.model.SNoticeModel;
import kr.happyjob.study.sAlert.model.SUserInfoModel;

public class SNoticeDto extends SNoticeModel {
	
	private SUserInfoModel sUserInfo = new SUserInfoModel();
	private SFileModel sFile = new SFileModel();
	
	// sUserInfo Getter & Setter
	public String getUser_type() {
		return sUserInfo.getUser_type();
	}
	
	public void setsUserInfo(String user_type) {
		sUserInfo.setUser_type(user_type);
	}

	public String getName() {
		return sUserInfo.getName();
	}

	public void setName(String name) {
		sUserInfo.setName(name);
	}
	
	// sFile Getter & Setter
	public int getFile_no() {
		return sFile.getFile_no();
	}

	public void setFile_no(int file_no) {
		sFile.setFile_no(file_no);
	}
	
	public String getFile_server_path() {
		return sFile.getFile_server_path();
	}

	public void setFile_server_path(String file_server_path) {
		sFile.setFile_server_path(file_server_path);
		
	}

	public String getFile_local_path() {
		return sFile.getFile_local_path();
	}

	public void setFile_local_path(String file_local_path) {
		sFile.setFile_local_path(file_local_path);
	}

	public String getFile_origin() {
		return sFile.getFile_origin();
	}

	public void setFile_origin(String file_origin) {
		sFile.setFile_origin(file_origin);
	}

	public String getFile_rename() {
		return sFile.getFile_rename();
	}

	public void setFile_rename(String file_rename) {
		sFile.setFile_rename(file_rename);
	}

	public String getFile_extension() {
		return sFile.getFile_extension();
	}

	public void setFile_extension(String file_extension) {
		sFile.setFile_extension(file_extension);
	}

	public int getFile_size() {
		return sFile.getFile_size();
	}

	public void setFile_size(int file_size) {
		sFile.setFile_size(file_size);
	}
	
}