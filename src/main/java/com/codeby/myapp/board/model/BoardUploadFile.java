package com.codeby.myapp.board.model;

public class BoardUploadFile {
	private int fileId; //파일id 1씩증가
	private int boardId; //첨부파일이 있는 게시글의 아이디(글번호)
	private String fileName;
	private long fileSize;
	private String fileContentType;
	private byte[] fildData;
	
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	public byte[] getFildData() {
		return fildData;
	}
	public void setFildData(byte[] fildData) {
		this.fildData = fildData;
	}
	
	@Override
	public String toString() {
		return "BoardUploadFile [fileId=" + fileId + ", boardId=" + boardId + ", fileName=" + fileName + ", fileSize="
				+ fileSize + ", fileContentType=" + fileContentType + "]";
	}
}
