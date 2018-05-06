package cn.edu.rubbish.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.rubbish.bean.RubbishItem;
import cn.edu.util.BaseDao;

@Repository
public class RubbishItemDao extends BaseDao<RubbishItem> {

	@SuppressWarnings("unchecked")
	public List<RubbishItem> getAll() {
		String sql = "from RubbishItem";
		return getSession().createQuery(sql).list();
	}

	public int size() {
		String hql = "select count(*) from RubbishItem";
		return ((Long) getSession().createQuery(hql).iterate().next()).intValue();
	}

	public int sizeBySpellRubbishId(Integer id, Date start, Date end) {
		String sql = "slect count(*) form RubbishItem r where r.rubbish.id = ? and r.time between ? and ?";
		return ((Long) getSession().createQuery(sql).setInteger(0, id).setDate(1, start).setDate(2, end).iterate()
				.next()).intValue();
	}

	public RubbishItem getById(Integer id) {
		String sql = "from RubbishItem r where r.id = ?";
		return (RubbishItem) getSession().createQuery(sql).setInteger(0, id).setMaxResults(1).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<RubbishItem> getByRubbishId(Integer id) {
		String sql = "from RubbishItem r where r.rubbish.id = ?";
		return getSession().createQuery(sql).setInteger(0, id).list();
	}

	@SuppressWarnings("unchecked")
	public List<RubbishItem> getBySpellRubbishId(Integer id, Date start, Date end) {
		String sql = "from RubbishItem r where r.rubbish.id = ? and r.time between ? and ?";
		return getSession().createQuery(sql).setInteger(0, id).setDate(1, start).setDate(2, end).list();
	}

	@SuppressWarnings("unchecked")
	public List<RubbishItem> getByPageSpellRubbishId(int pageNum, int pageSize, String line, String way, Integer id,
			Date start, Date end) {
		String sql = "from RubbishItem r where r.rubbish.id = ? and r.time between ? and ?";
		if (line != null && way.equalsIgnoreCase("desc") || way.equalsIgnoreCase("asc")) {
			sql = sql + " ORDER BY r." + line + " " + way;
		}
		return (List<RubbishItem>) getSession().createQuery(sql).setInteger(0, id).setDate(1, start).setDate(2, end)
				.setFirstResult((pageNum - 1) * pageSize).setMaxResults(pageSize).list();
	}

	@SuppressWarnings("unchecked")
	public List<RubbishItem> getBySpell(Date start, Date end) {
		String sql = "from RubbishItem r where r.time between ? and ?";
		return getSession().createQuery(sql).setDate(0, start).setDate(1, end).list();

	}

	public int sizeByUserId(Integer userId) {
		String sql = "select count(*) from RubbishItem r where r.user.id = ?";
		return ((Long) getSession().createQuery(sql).setInteger(0, userId).iterate().next()).intValue();
	}

	@SuppressWarnings("unchecked")
	public List<RubbishItem> getAllByPage(int pageNum, int pageSize, String line, String way) {
		String sql = "from RubbishItem r";
		if (line != null && way.equalsIgnoreCase("desc") || way.equalsIgnoreCase("asc")) {
			sql = sql + " ORDER BY r." + line + " " + way;
		}
		return (List<RubbishItem>) getSession().createQuery(sql).setFirstResult((pageNum - 1) * pageSize)
				.setMaxResults(pageSize).list();
	}

	@SuppressWarnings("unchecked")
	public List<RubbishItem> getByPageUserId(int pageNum, int pageSize, String line, String way, Integer id) {
		String sql = "from RubbishItem r where r.user.id = ?";
		if (line != null && way.equalsIgnoreCase("desc") || way.equalsIgnoreCase("asc")) {
			sql = sql + " ORDER BY r." + line + " " + way;
		}
		return (List<RubbishItem>) getSession().createQuery(sql).setInteger(0, id)
				.setFirstResult((pageNum - 1) * pageSize).setMaxResults(pageSize).list();
	}

}
