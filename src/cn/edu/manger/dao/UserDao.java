package cn.edu.manger.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.manger.bean.User;
import cn.edu.util.BaseDao;

@Repository
public class UserDao extends BaseDao<User> {

	public User getByName(String name) {
		String sql = "from User u where u.name = ?";
		return (User) getSession().createQuery(sql).setString(0, name).setMaxResults(1).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<User> getAll() {
		String sql = "from User u";
		return getSession().createQuery(sql).list();
	}

	public int size() {
		String hql = "select count(*)  from User ";
		return ((Long) getSession().createQuery(hql).iterate().next()).intValue();
	}

	public User getById(Integer id) {
		String sql = "from User u where u.id = ?";
		return (User) getSession().createQuery(sql).setInteger(0, id).setMaxResults(1).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<User> getBySpell(Date start, Date end) {
		String sql = "from User u where u.time bewteen ? and end";
		return getSession().createQuery(sql).setDate(0, start).setDate(1, end).list();
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllByPage(int pageNum, int pageSize, String line, String way) {
		String sql = "from User r";
		if (line != null && way.equalsIgnoreCase("desc") || way.equalsIgnoreCase("asc")) {
			sql = sql + " ORDER BY r." + line + " " + way;
		}
		return (List<User>) getSession().createQuery(sql).setFirstResult((pageNum - 1) * pageSize)
				.setMaxResults(pageSize).list();
	}

}
