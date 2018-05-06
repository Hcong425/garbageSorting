package cn.edu.right.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.right.bean.Classes;
import cn.edu.util.BaseDao;

@Repository
public class ClassesDao extends BaseDao<Classes> {

	@SuppressWarnings("unchecked")
	public List<Classes> getAll() {
		String sql = "from Classes";
		return (List<Classes>) getSession().createQuery(sql).list();
	}

	public Classes getById(Integer id) {
		String sql = "from Classes c where c.id = ?";
		return (Classes) getSession().createQuery(sql).setInteger(0, id).setMaxResults(1).uniqueResult();
	}

	public Classes getByName(String name) {
		String sql = "from Classes c where c.name = ?";
		return (Classes) getSession().createQuery(sql).setString(0, name).setMaxResults(1).uniqueResult();
	}

}
