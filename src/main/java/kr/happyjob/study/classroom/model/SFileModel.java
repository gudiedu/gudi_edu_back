package kr.happyjob.study.classroom.model;

public class SFileModel {

	private int file_no;
	
	private String file_server_path;
	
	private String file_local_path;
	
	private String file_origin;
	
	private String file_rename;
	
	private String file_extension;

	private int file_size;

	public int getFile_no() {
		return file_no;
	}

	public void setFile_no(int file_no) {
		this.file_no = file_no;
	}

	public String getFile_server_path() {
		return file_server_path;
	}

	public void setFile_server_path(String file_server_path) {
		this.file_server_path = file_server_path;
	}

	public String getFile_local_path() {
		return file_local_path;
	}

	public void setFile_local_path(String file_local_path) {
		this.file_local_path = file_local_path;
	}

	public String getFile_origin() {
		return file_origin;
	}

	public void setFile_origin(String file_origin) {
		this.file_origin = file_origin;
	}

	public String getFile_rename() {
		return file_rename;
	}

	public void setFile_rename(String file_rename) {
		this.file_rename = file_rename;
	}

	public String getFile_extension() {
		return file_extension;
	}

	public void setFile_extension(String file_extension) {
		this.file_extension = file_extension;
	}

	public int getFile_size() {
		return file_size;
	}

	public void setFile_size(int file_size) {
		this.file_size = file_size;
	}

	
}
