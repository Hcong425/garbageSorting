package cn.edu.point.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.point.bean.Category;
import cn.edu.point.dao.CategoryDao;

@Service
public class CategoryService {

	private CategoryDao categoryDao;

	@Autowired
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	public Category getById(Integer id) {
		return categoryDao.getById(id);
	}

	public Category getByName(String name) {
		return categoryDao.getByName(name);
	}

	public void saveOrUpdate(Category category) {
		categoryDao.saveOrUpdate(category);
	}

	public void delete(Category category) {
		categoryDao.delete(category);
	}

	public List<Category> getTopCategory() {
		return new ArrayList<Category>(categoryDao.getTopCategory());
	}

	public List<Category> getChildCategoryById(Integer id) {
		return categoryDao.getChildCategoryById(id);
	}

}
