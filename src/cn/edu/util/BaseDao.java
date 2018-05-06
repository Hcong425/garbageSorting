package cn.edu.util;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDao<T> {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public boolean saveOrUpdate(T object) {
		try {
			getSession().saveOrUpdate(object);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Object object) {
		try {
			getSession().delete(object);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> getAllByPage(int pageNum, int pageSize, String line, String way, String tableName) {
		String sql = "from " + tableName + " r";
		if (line != null && way.equalsIgnoreCase("desc") || way.equalsIgnoreCase("asc")) {
			sql = sql + " ORDER BY r." + line + " " + way;
		}
		return (List<T>) getSession().createQuery(sql).setFirstResult((pageNum - 1) * pageSize).setMaxResults(pageSize)
				.list();
	}

}
