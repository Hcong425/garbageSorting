package cn.edu.rubbish.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import cn.edu.rubbish.bean.RecyclePoint;
import cn.edu.rubbish.bean.RubbishItem;
import cn.edu.util.BaseDao;

@Repository
public class RecyclePointDao extends BaseDao<RecyclePoint> {

	public BigDecimal getWeight(Integer id) {
		BigDecimal weight = new BigDecimal(0);
		Set<RubbishItem> rubbishItems = getById(id).getRubbishItems();
		for (RubbishItem rubbishItem : rubbishItems) {
			weight = weight.add(rubbishItem.getWeight());
		}
		return weight;
	}

	@SuppressWarnings("unchecked")
	public List<RecyclePoint> getAll() {
		String sql = "from RecyclePoint";
		return getSession().createQuery(sql).list();
	}

	public int size() {
		String hql = "select count(*)  from RecyclePoint";
		return ((Long) getSession().createQuery(hql).iterate().next()).intValue();
	}

	public RecyclePoint getById(Integer id) {
		String sql = "from RecyclePoint r where r.id = ?";
		return (RecyclePoint) getSession().createQuery(sql).setInteger(0, id).setMaxResults(1).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<RecyclePoint> getAllByPage(int pageNum, int pageSize, String line, String way) {
		String sql = "from RecyclePoint r";
		if (line != null && way.equalsIgnoreCase("desc") || way.equalsIgnoreCase("asc")) {
			sql = sql + " ORDER BY r." + line + " " + way;
		}
		return (List<RecyclePoint>) getSession().createQuery(sql).setFirstResult((pageNum - 1) * pageSize)
				.setMaxResults(pageSize).list();
	}

	/**
	 * 
	 * @param id
	 * @return -1:已激活
	 */
	public int active(Integer id) {
		if (getById(id).getActive() == 0) {
			String sql = "update RecyclePoint r set r.active = ? where r.id = ?";
			return getSession().createQuery(sql).setInteger(0, 1).setInteger(1, id).executeUpdate();
		}
		return -1;
	}

}
