package cn.edu.rubbish.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.rubbish.bean.Address;
import cn.edu.util.BaseDao;

@Repository
public class AddressDao extends BaseDao<Address> {

	public Address getByName(String name) {
		String sql = "from Address a where a.name = ?";
		return (Address) getSession().createQuery(sql).setString(0, name).setMaxResults(1).uniqueResult();
	}

	public Address getById(Integer id) {
		String sql = "from Address a where a.id = ?";
		return (Address) getSession().createQuery(sql).setInteger(0, id).setMaxResults(1).uniqueResult();
	}

	public Address getByCity(String city, String county) {
		String sql = "from Address a where a.name = ? and a.parAddress.name = ?";
		return (Address) getSession().createQuery(sql).setString(0, county).setString(1, city).setMaxResults(1)
				.uniqueResult();

	}

	@SuppressWarnings("unchecked")
	public List<Address> getParAddress() {
		String sql = "from Address a where a.parAddress is null";
		return getSession().createQuery(sql).list();
	}

	@SuppressWarnings("unchecked")
	public List<Address> getChildAddress(Integer parAddressId) {
		String sql = "from Address a where a.parAddress.id = ?";
		return getSession().createQuery(sql).setInteger(0, parAddressId).list();
	}

}
