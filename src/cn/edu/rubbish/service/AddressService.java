package cn.edu.rubbish.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.rubbish.bean.Address;
import cn.edu.rubbish.dao.AddressDao;

@Service
public class AddressService {

	private AddressDao addressDao;

	@Autowired
	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}

	public void saveOrUpdate(Address address) {
		addressDao.saveOrUpdate(address);
	}

	public Address getById(Integer id) {
		return addressDao.getById(id);
	}

	public Address getByName(String name) {
		return addressDao.getByName(name);
	}

	public Address getByCity(String city, String county) {
		return addressDao.getByCity(city, county);
	}

	public void delete(Address address) {
		addressDao.delete(address);
	}

	public List<Address> getParAddress() {
		return addressDao.getParAddress();
	}

	public List<Address> getChildAddress(Integer parAddressId) {
		return addressDao.getChildAddress(parAddressId);
	}

}
