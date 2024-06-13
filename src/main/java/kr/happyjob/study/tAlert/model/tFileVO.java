package kr.happyjob.study.tAlert.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class tFileVO {
	
	
		private int file_no;
		private String file_server_path;
		private String file_local_path; 
		private String file_origin;
		private String file_rename;
		private String file_extension;
		private int file_size;
	
}
