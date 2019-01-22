package com.codeby.myapp.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codeby.myapp.board.dao.IBoardRepository;
import com.codeby.myapp.board.model.Board;
import com.codeby.myapp.board.model.BoardUploadFile;
import com.codeby.myapp.board.service.IBoardService;

//IBoardRepository를 이용해 구현, BoardService클래스에서 트랜젝션 처리
@Service
public class BoardService implements IBoardService{

	@Autowired
	IBoardRepository boardRepository;
	
	@Transactional //이후 에러가 나면 여기서 처리한 쿼리는 자동 ROLLBACK 
	public void insertArticle(Board board) {
		// TODO Auto-generated method stub
		board.setBoardId(boardRepository.selectMaxArticleNo()+1);
		boardRepository.insertArticle(board);
	}

	@Transactional
	public void insertArticle(Board board, BoardUploadFile file) {
		// TODO Auto-generated method stub
		board.setBoardId(boardRepository.selectMaxArticleNo()+1);
		boardRepository.insertArticle(board);
		if(file != null && file.getFileName() != null && !file.getFileName().equals("")) {
			file.setBoardId(board.getBoardId());
			file.setFileId(boardRepository.selectMaxFileId()+1);
			boardRepository.insertFileData(file);
		}
	}

	@Override
	public List<Board> selectArticleListByCategory(int categoryId) {
		// TODO Auto-generated method stub
		
		return boardRepository.selectArticleListByCategory(categoryId,0,100);
	}

	@Override
	public List<Board> selectArticleListByCategory(int categoryId, int page) {
		// TODO Auto-generated method stub
		int start = (page-1)*10;
		return boardRepository.selectArticleListByCategory(categoryId,start,start+10);
	}

	@Transactional
	public Board selectArticle(int boardId) {
		// TODO Auto-generated method stub
		boardRepository.updateReadCount(boardId);
		return boardRepository.selectArticle(boardId);
	}

	@Override
	public BoardUploadFile getFile(int fileId) {
		// TODO Auto-generated method stub
		return boardRepository.getFile(fileId);
	}

	@Transactional
	public void replyArticle(Board board) {
		// TODO Auto-generated method stub
		boardRepository.updateReplyNumber(board.getMasterId(), board.getReplyNumber());
		board.setBoardId(boardRepository.selectMaxArticleNo()+1);
		board.setReplyNumber(board.getReplyStep()+1);
		boardRepository.replyArticle(board);
	}

	@Transactional
	public void replyArticle(Board board, BoardUploadFile file) {
		// TODO Auto-generated method stub
		boardRepository.updateReplyNumber(board.getMasterId(), board.getReplyNumber());
		board.setBoardId(boardRepository.selectMaxArticleNo()+1);
		board.setReplyNumber(board.getReplyStep()+1);
		boardRepository.replyArticle(board);
		if(file != null && file.getFileName() != null && !file.getFileName().equals("")) {
			file.setBoardId(board.getBoardId());
			boardRepository.insertFileData(file);
		}
	}

	@Override
	public String getPassword(int boardId) {
		// TODO Auto-generated method stub
		return boardRepository.getPassword(boardId);
	}

	@Override
	public void updateArticle(Board board) {
		// TODO Auto-generated method stub
		boardRepository.updateArticle(board);
	}

	@Transactional
	public void updateArticle(Board board, BoardUploadFile file) {
		// TODO Auto-generated method stub
		boardRepository.updateArticle(board);
		if(file != null && file.getFileName() != null && !file.getFileName().equals("")) {
			file.setBoardId(board.getBoardId());
			
			if(file.getFileId() > 0) {
				boardRepository.updateFileData(file);
			} else {
				boardRepository.insertFileData(file);
			}
		}
	}

	@Override
	public Board selectDeleteArticle(int boardId) {
		// TODO Auto-generated method stub
		return boardRepository.selectDeleteArticle(boardId);
	}

	@Transactional
	public void deleteArticle(int boardId, int replyNumber) {
		// TODO Auto-generated method stub
		if(replyNumber > 0) {
			boardRepository.deleteReplyFileData(boardId);
			boardRepository.deleteArticleByBoardId(boardId);
		} else if(replyNumber == 0) {
			boardRepository.deleteFileData(boardId);
			boardRepository.deleteArticleByMasterId(boardId);
		} else {
			throw new RuntimeException("WRONT_REPLYNUMBER");
		}
	}

	@Override
	public int selectTotalArticleCount() {
		// TODO Auto-generated method stub
		return boardRepository.selectTotalArticleCount();
	}

	@Override
	public int selectTotalArticleCountByCategoryId(int categoryId) {
		// TODO Auto-generated method stub
		return boardRepository.selectTotalArticleCountByCategoryId(categoryId);
	}

	@Override
	public List<Board> searchListByContentKeyword(String keyword, int page) {
		// TODO Auto-generated method stub
		int start = (page-1)*10;
		return boardRepository.searchListByContentKeyword("%"+keyword+"%",start, start+10);
	}

	@Override
	public int selectTotalArticleCountByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return boardRepository.selectTotalArticleCountByKeyword("%"+keyword+"%");
	}

}
