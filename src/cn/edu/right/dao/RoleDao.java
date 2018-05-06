package cn.edu.right.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.right.bean.Role;
import cn.edu.util.BaseDao;

@Repository
public class RoleDao extends BaseDao<Role> {

	@SuppressWarnings("unchecked")
	public List<Role> getAll() {
		String sql = "from Role";
		return getSession().createQuery(sql).list();
	}

	public Role getById(Integer id) {
		String sql = "from Role r where r.id = ?";
		return (Role) getSession().createQuery(sql).setInteger(0, id).setMaxResults(id).uniqueResult();
	}

	public int size() {
		String hql = "select count(*)  from Role";
		return ((Long) getSession().createQuery(hql).iterate().next()).intValue();
	}

}
