package cn.edu.point.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.point.bean.ConvertItem;
import cn.edu.util.BaseDao;

@Repository
public class ConvertItemDao extends BaseDao<ConvertItem> {

	public ConvertItem getById(Integer id) {
		String sql = "from ConvertItem c where c.id = ?";
		return (ConvertItem) getSession().createQuery(sql).setInteger(1, id).setMaxResults(1).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<ConvertItem> getBySpellCommodityId(Integer id, Date start, Date end) {
		String sql = "from ConvertItem c where c.commodity.id = ? and c.convert.time between ? and ?";
		return getSession().createQuery(sql).setInteger(0, id).setDate(1, start).setDate(2, end).list();
	}

}
