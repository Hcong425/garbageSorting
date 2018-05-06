package cn.edu.manger.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.manger.bean.Manger;
import cn.edu.util.BaseDao;

@Repository
public class MangerDao extends BaseDao<Manger> {

	public Manger getByName(String name) {
		String sql = "from Manger m where m.name = ?";
		return (Manger) getSession().createQuery(sql).setString(0, name).setMaxResults(1).uniqueResult();
	}

	public Manger getById(Integer id) {
		String sql = "from Manger m where m.id = ?";
		return (Manger) getSession().createQuery(sql).setInteger(0, id).setMaxResults(1).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Manger> getAllByPage(int pageNum, int pageSize, String line, String way) {
		String sql = "from Manger m";
		if (line != null && way.equalsIgnoreCase("desc") || way.equalsIgnoreCase("asc")) {
			sql = sql + " ORDER BY m." + line + " " + way;
		}
		return (List<Manger>) getSession().createQuery(sql).setFirstResult((pageNum - 1) * pageSize)
				.setMaxResults(pageSize).list();
	}

	public int size() {
		String hql = "select count(*)  from Manger ";
		return ((Long) getSession().createQuery(hql).iterate().next()).intValue();
	}

}
