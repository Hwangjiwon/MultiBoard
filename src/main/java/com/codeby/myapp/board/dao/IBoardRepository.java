package com.codeby.myapp.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.codeby.myapp.board.model.Board;
import com.codeby.myapp.board.model.BoardUploadFile;

//BoardService class에서 사용 : 게시글 입력/수정/삭제/조회 기능 수행

public interface IBoardRepository {
	int selectMaxArticleNo();
	int selectMaxFileId();
	
	void insertArticle(Board board);
	void insertFileData(BoardUploadFile file);
	
	List<Board> selectArticleListByCategory(@Param("categoryId") int categoryId, @Param("start") int start, @Param("end") int end);
	
	Board selectArticle(int boardId);
	BoardUploadFile getFile(int fileId);
	
	void updateReadCount(int boardId);
	void updateReplyNumber(@Param("masterId") int masterId, @Param("replyNumber") int replyNumber);
	void replyArticle(Board boardId);
	
	String getPassword(int boardId);
	void updateArticle(Board board);
	void updateFileData(BoardUploadFile file);
	
	void deleteFileData(int boardId);
	void deleteReplyFileData(int boardId);
	Board selectDeleteArticle(int boardId);
	void deleteArticleByBoardId(int boardId);
	void deleteArticleByMasterId(int boardId);
	
	int selectTotalArticleCount();
	int selectTotalArticleCountByCategoryId(int categoryId);
	List<Board> searchListByContentKeyword(String keyword);
	
}
