package kr.happyjob.study.aAlert.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
@RequiredArgsConstructor
public class AFileDTO {
	
	private int file_no;
	private String file_server_path;
	private String file_local_path; 
	private String file_origin;
	private String file_rename;
	private String file_extension;
	private int file_size;
	
}
