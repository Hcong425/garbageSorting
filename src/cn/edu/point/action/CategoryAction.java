package cn.edu.point.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

import cn.edu.point.bean.Category;
import cn.edu.point.service.CategoryService;
import cn.edu.util.form.CategoryForm;

@Controller
public class CategoryAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private CategoryService categoryService;
	private Category category;
	private String result;
	private CategoryForm categoryForm;

	public void setResult(String result) {
		this.result = result;
	}

	public String getResult() {
		return result;
	}

	public CategoryForm getCategoryForm() {
		return categoryForm;
	}

	public void setCategoryForm(CategoryForm categoryForm) {
		this.categoryForm = categoryForm;
	}

	@Autowired
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public String saveOrUpdate() {
		if (getCategoryForm().getId() != null) {
			category = categoryService.getById(getCategoryForm().getId());
		} else {
			category = new Category();
		}
		category.setName(getCategoryForm().getName());

		if (getCategoryForm().getIsPar() == null) {
			Category parCategory = categoryService.getById(getCategoryForm().getParCategoryId());
			category.setParentCategory(parCategory);
		}
		categoryService.saveOrUpdate(category);
		return "saveOrUpdate";
	}

	public String findChildById() {
		List<Category> childs = categoryService.getChildCategoryById(getCategoryForm().getId());
		for (Category category : childs) {
			category.setChildCategories(null);
			category.setCommodities(null);
			category.setParentCategory(null);
		}
		Gson json = new Gson();
		String jsonStr = json.toJson(childs);
		setResult(jsonStr);
		return "ajax";
	}

}