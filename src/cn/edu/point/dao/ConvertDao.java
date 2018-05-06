package cn.edu.point.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.point.bean.Convert;
import cn.edu.util.BaseDao;

@Repository
public class ConvertDao extends BaseDao<Convert> {

	@SuppressWarnings("unchecked")
	public List<Convert> getAll() {
		String sql = "from Convert";
		return getSession().createQuery(sql).list();
	}

	public Convert getById(Integer id) {
		String sql = "from Convert c where c.id = ?";
		return (Convert) getSession().createQuery(sql).setInteger(0, id).setMaxResults(1).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Convert> getByUserId(Integer id) {
		String sql = "from Convert c left join fecth c.convertItems where c.user.id = ?";
		return getSession().createQuery(sql).setInteger(0, id).list();
	}

	@SuppressWarnings("unchecked")
	public List<Convert> getBySpell(Date start, Date end) {
		String sql = "from Convert c where c.time between ? and ?";
		return getSession().createQuery(sql).setDate(0, start).setDate(1, end).list();
	}

	public int size() {
		String sql = "select count(*) from Convert";
		return ((Long) getSession().createQuery(sql).iterate().next()).intValue();
	}

	public int sizeByUserId(Integer id) {
		String sql = "select count(*) from Convert c where c.user.id = ?";
		return ((Long) (getSession().createQuery(sql).setInteger(0, id).iterate().next())).intValue();
	}

	public int sizeByCommodityId(Integer id) {
		String sql = "select count(*) from Convert c left join c.convertItems i where i.commodity.id = ?";
		return ((Long) (getSession().createQuery(sql).setInteger(0, id).iterate().next())).intValue();
	}

	@SuppressWarnings("unchecked")
	public List<Convert> getByPageUserId(int pageNum, int pageSize, String line, String way, Integer id) {
		String sql = "from Convert c where c.user.id = ?";
		if (line != null && way.equalsIgnoreCase("desc") || way.equalsIgnoreCase("asc")) {
			sql = sql + " ORDER BY c." + line + " " + way;
		}
		return (List<Convert>) getSession().createQuery(sql).setInteger(0, id).setFirstResult((pageNum - 1) * pageSize)
				.setMaxResults(pageSize).list();
	}

	@SuppressWarnings("unchecked")
	public List<Convert> getPageByCommodityId(int pageNum, int pageSize, String line, String way, Integer id) {
		String sql = "from Convert c left join fetch c.convertItems i where i.commodity.id = ?";
		List<Convert> list = getSession().createQuery(sql).setInteger(0, id).list();
		List<Integer> ids = new ArrayList<Integer>();
		for (Convert convert : list) {
			ids.add(convert.getId());
		}
		if (ids.size() < 1)
			return null;
		getSession().clear();
		sql = "from Convert c where c.id in (:ids)";
		if (line != null && way.equalsIgnoreCase("desc") || way.equalsIgnoreCase("asc")) {
			sql = sql + " ORDER BY c." + line + " " + way;
		}
		return (List<Convert>) getSession().createQuery(sql).setParameterList("ids", ids)
				.setFirstResult((pageNum - 1) * pageSize).setMaxResults(pageSize).list();
	}

}
