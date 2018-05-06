package cn.edu.point.dao;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import cn.edu.point.bean.Category;
import cn.edu.util.BaseDao;

@Repository
public class CategoryDao extends BaseDao<Category> {

	@SuppressWarnings("unchecked")
	public Set<Category> getAll() {
		String sql = "from Category";
		return (Set<Category>) getSession().createQuery(sql).list();
	}

	public Category getById(Integer id) {
		String sql = "from Category c where c.id = ?";
		return (Category) getSession().createQuery(sql).setInteger(0, id).setMaxResults(1).uniqueResult();
	}

	public Category getByName(String name) {
		String sql = "from Category c where c.name= ?";
		return (Category) getSession().createQuery(sql).setString(0, name).setMaxResults(1).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Category> getTopCategory() {
		String sql = "from Category c where c.parentCategory is null";
		return (List<Category>) getSession().createQuery(sql).list();
	}

	@SuppressWarnings("unchecked")
	public List<Category> getChildCategoryById(Integer id) {
		String sql = "from Category c where c.parentCategory.id = ?";
		return getSession().createQuery(sql).setInteger(0, id).list();

	}
}
