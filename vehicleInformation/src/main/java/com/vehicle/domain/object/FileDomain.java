package com.vehicle.domain.object;

/**  FileDomain Contains file related information */

public class FileDomain {
	private String FileName;
	private Long FileSize;
	private String FileMimeType;
	private String FileExt;
	private String filePath;
	
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	
	public String getFileExt() {
		return FileExt;
	}
	public void setFileExt(String fileExt) {
		FileExt = fileExt;
	}	
	
	public String getFileName() {
		return FileName;
	}
	public void setFileName(String fileName) {
		FileName = fileName;
	}
	public Long getFileSize() {
		return FileSize;
	}
	public void setFileSize(Long fileSize) {
		FileSize = fileSize;
	}
	public String getFileMimeType() {
		return FileMimeType;
	}
	public void setFileMimeType(String fileMimeType) {
		FileMimeType = fileMimeType;
	}
	
	
	

}
