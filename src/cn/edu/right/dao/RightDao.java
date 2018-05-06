package cn.edu.right.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.right.bean.Right;
import cn.edu.util.BaseDao;

@Repository
public class RightDao extends BaseDao<Right> {

	@SuppressWarnings("unchecked")
	public List<Right> getAll() {
		String sql = "from Right";
		return getSession().createQuery(sql).list();
	}

	public Right getById(Integer id) {
		String sql = "from Right r where r.id = ?";
		return (Right) getSession().createQuery(sql).setInteger(0, id).setMaxResults(id).uniqueResult();
	}

	public int size() {
		String hql = "select count(*)  from Right";
		return ((Long) getSession().createQuery(hql).iterate().next()).intValue();
	}

	@SuppressWarnings("unchecked")
	public List<Right> getBYRoleId(Integer id) {
		String sql = "from Right r left join fetch r.roles o where o.id = ?";
		return (List<Right>) getSession().createQuery(sql).setInteger(0, id).list();
	}

}
