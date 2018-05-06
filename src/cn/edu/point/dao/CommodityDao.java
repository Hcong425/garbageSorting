package cn.edu.point.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.point.bean.Commodity;
import cn.edu.util.BaseDao;

@Repository
public class CommodityDao extends BaseDao<Commodity> {

	public Commodity getById(Integer id) {
		String sql = "from Commodity c where c.id = ?";
		return (Commodity) getSession().createQuery(sql).setInteger(0, id).setMaxResults(1).uniqueResult();
	}

	public int size() {
		String sql = "select count(*) from Commodity";
		return ((Long) getSession().createQuery(sql).iterate().next()).intValue();
	}

	public Commodity getWithConvertItemById(Integer id) {
		String sql = "from Commodity c left join fecth c.convertItems where c.id = ?";
		return (Commodity) getSession().createQuery(sql).setInteger(0, id).setMaxResults(1).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Commodity> getAll() {
		String sql = "from Commodity c";
		return getSession().createQuery(sql).list();
	}

}
