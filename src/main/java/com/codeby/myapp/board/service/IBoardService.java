package com.codeby.myapp.board.service;

import java.util.List;

import com.codeby.myapp.board.model.Board;
import com.codeby.myapp.board.model.BoardUploadFile;

//BoardController���� �Խñ� ������ �Է�/���/����/��ȸ�ϱ� ���� ���
public interface IBoardService {
	void insertArticle(Board boardId);
	void insertArticle(Board boardId, BoardUploadFile file);
	
	List<Board> selectArticleListByCategory(int categoryId);
	List<Board> selectArticleListByCategory(int categoryId, int page);
	
	Board selectArticle(int boardId);
	
	BoardUploadFile getFile(int fileId);
	
	void replyArticle(Board board);
	void replyArticle(Board board, BoardUploadFile file);
	
	String getPassword(int boardId);
	
	void updateArticle(Board board);
	void updateArticle(Board board, BoardUploadFile file);
	
	Board selectDeleteArticle(int boardId);
	void deleteArticle(int boardId, int replyNumber);
	
	int selectTotalArticleCount();
	int selectTotalArticleCountByCategoryId(int categoryId);
	
	List<Board> searchListByContentKeyword(String keyword, int page);
	int selectTotalArticleCountByKeyword(String keyword);
}
