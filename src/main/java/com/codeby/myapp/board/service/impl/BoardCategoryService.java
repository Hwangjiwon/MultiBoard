package com.codeby.myapp.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.codeby.myapp.board.dao.IBoardCategoryRepository;
import com.codeby.myapp.board.model.BoardCategory;
import com.codeby.myapp.board.service.IBoardCategoryService;

public class BoardCategoryService implements IBoardCategoryService {

	@Autowired
	IBoardCategoryRepository boardCategoryRepository;
	
	@Override
	public List<BoardCategory> selectAllCategory() {
		// TODO Auto-generated method stub
		return boardCategoryRepository.selectAllCategory();
	}

	@Override
	public List<BoardCategory> selectAllCategoryByClass1(int class1) {
		// TODO Auto-generated method stub
		return boardCategoryRepository.selectAllCategoryByClass1(class1);
	}

	@Override
	public void insertNewCategory(BoardCategory boardCategory) {
		// TODO Auto-generated method stub
		boardCategory.setCategoryId(boardCategoryRepository.selectMaxCategoryId());
		boardCategoryRepository.insertNewCategory(boardCategory);
	}

	@Override
	public void updateCategory(BoardCategory boardCategory) {
		// TODO Auto-generated method stub
		boardCategoryRepository.updateCategory(boardCategory);
	}

	@Override
	public void deleteCategory(int categoryId) {
		// TODO Auto-generated method stub
		boardCategoryRepository.deleteCategory(categoryId);
	}

}
