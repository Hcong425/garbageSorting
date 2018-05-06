package cn.edu.rubbish.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import cn.edu.rubbish.bean.Rubbish;
import cn.edu.rubbish.bean.RubbishItem;
import cn.edu.util.BaseDao;

@Repository
public class RubbishDao extends BaseDao<Rubbish> {

	public BigDecimal getWeight(Integer id) {
		BigDecimal weight = new BigDecimal(0);
		Set<RubbishItem> items = getById(id).getRubbishItems();
		for (RubbishItem rubbishItem : items) {
			weight = weight.add(rubbishItem.getWeight());
		}
		return weight;
	}

	@SuppressWarnings("unchecked")
	public List<Rubbish> getAll() {
		String sql = "from Rubbish";
		return getSession().createQuery(sql).list();
	}

	public int size() {
		String sql = "select count(*) from Rubbish";
		return ((Long) getSession().createQuery(sql).iterate().next()).intValue();
	}

	public int sizeByParId(Integer id) {
		String sql = "select count(*) from Rubbish r where r.parRubbish.id = ?";
		return ((Long) getSession().createQuery(sql).setInteger(0, id).iterate().next()).intValue();
	}

	public Rubbish getByName(String name) {
		String sql = "from Rubbish r where r.name = ?";
		return (Rubbish) getSession().createQuery(sql).setString(0, name).setMaxResults(1).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Rubbish> getAllChildByPage(int pageNum, int pageSize, Integer parRubbishId) {
		String sql = "";
		if (parRubbishId != null) {
			sql = "from Rubbish r where r.parRubbish is not null and r.parRubbish.id = ?";
			return (List<Rubbish>) getSession().createQuery(sql).setFirstResult((pageNum - 1) * pageSize)
					.setInteger(0, parRubbishId).setMaxResults(pageSize).list();
		} else {
			sql = "from Rubbish r where r.parRubbish is not null";
			return (List<Rubbish>) getSession().createQuery(sql).setFirstResult((pageNum - 1) * pageSize)
					.setMaxResults(pageSize).list();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Rubbish> getByParPage(String name, int pageNum, int pageSize) {
		String sql = "from Rubbish r where r.parRubbish.name = ?";
		return (List<Rubbish>) getSession().createQuery(sql).setString(0, name).setFirstResult((pageNum - 1) * pageSize)
				.setMaxResults(pageSize).list();
	}

	public Rubbish getById(Integer id) {
		String sql = "from Rubbish r where r.id = ?";
		return (Rubbish) getSession().createQuery(sql).setInteger(0, id).setMaxResults(1).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Rubbish> getParRubbish() {
		String sql = "from Rubbish r where r.parRubbish is null";
		return (List<Rubbish>) getSession().createQuery(sql).list();
	}

	@SuppressWarnings("unchecked")
	public List<Rubbish> getChildRubbish() {
		String sql = "from Rubbish r where r.parRubbish is not null";
		return (List<Rubbish>) getSession().createQuery(sql).list();
	}

	public int sizeByCondition(String condition) {
		String sql = "select count(*) from Rubbish r where r.name like ?";
		return ((Long) getSession().createQuery(sql).setString(0, "%" + condition + "%").iterate().next()).intValue();
	}

	@SuppressWarnings("unchecked")
	public List<Rubbish> getByConditionPage(int pageNum, int pageSize, String condition) {
		String sql = "from Rubbish r where r.name like ?";
		return (List<Rubbish>) getSession().createQuery(sql).setString(0, "%" + condition + "%")
				.setFirstResult((pageNum - 1) * pageSize).setMaxResults(pageSize).list();
	}

}
