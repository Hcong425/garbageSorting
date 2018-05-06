package cn.edu.rubbish.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.rubbish.bean.Cell;
import cn.edu.util.BaseDao;

@Repository
public class CellDao extends BaseDao<Cell> {

	public Cell getById(Integer id) {
		String sql = "from Cell c where c.id = ?";
		return (Cell) getSession().createQuery(sql).setInteger(0, id).setMaxResults(1).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Cell> getAll() {
		String sql = "from Cell";
		return getSession().createQuery(sql).list();
	}

	@SuppressWarnings("unchecked")
	public List<Cell> getByAddressId(Integer addressId) {
		String sql = "from Cell c where c.address.id = ?";
		return getSession().createQuery(sql).setInteger(0, addressId).list();
	}

}
