package com.codeby.myapp.board.dao;

import java.util.List;

import com.codeby.myapp.board.model.BoardCategory;

public interface IBoardCategoryRepository {
	int selectMaxCategoryId();
	List<BoardCategory> selectAllCategory();
	List<BoardCategory> selectAllCategoryByClass1(int class1); //´ëºÐ·ù
	void insertNewCategory(BoardCategory boardCategory);
	void updateCategory(BoardCategory boardCategory);
	void deleteCategory(int categoryId);
}
