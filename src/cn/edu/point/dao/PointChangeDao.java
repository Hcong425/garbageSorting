package cn.edu.point.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.point.bean.PointChange;
import cn.edu.util.BaseDao;

@Repository
public class PointChangeDao extends BaseDao<PointChange> {

	public PointChange getById(Integer id) {
		String sql = "from PointChange p where p.id = ?";
		return (PointChange) getSession().createQuery(sql).setInteger(0, id).setMaxResults(1).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<PointChange> getAll() {
		String sql = "from PointChange";
		return getSession().createQuery(sql).list();
	}

	public int size() {
		String hql = "select count(*)  from PointChange";
		return ((Long) getSession().createQuery(hql).iterate().next()).intValue();
	}

	@SuppressWarnings("unchecked")
	public List<PointChange> getAllByPage(int pageNum, int pageSize, String line, String way) {
		String sql = "from PointChange p";
		if (line != null && way.equalsIgnoreCase("desc") || way.equalsIgnoreCase("asc")) {
			sql = sql + " ORDER BY p." + line + " " + way;
		}
		return (List<PointChange>) getSession().createQuery(sql).setFirstResult((pageNum - 1) * pageSize)
				.setMaxResults(pageSize).list();
	}

}
