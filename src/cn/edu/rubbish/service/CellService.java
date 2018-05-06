package cn.edu.rubbish.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.rubbish.bean.Cell;
import cn.edu.rubbish.dao.CellDao;

@Service
public class CellService {

	private CellDao cellDao;

	@Autowired
	public void setCellDao(CellDao cellDao) {
		this.cellDao = cellDao;
	}

	public Cell getById(Integer id) {
		return cellDao.getById(id);
	}

	public void delete(Cell cell) {
		cellDao.delete(cell);
	}

	public void saveOrUpdate(Cell cell) {
		cellDao.saveOrUpdate(cell);
	}

	public List<Cell> getAll() {
		return cellDao.getAll();
	}

	public List<Cell> getByAddressId(Integer addressId) {
		return cellDao.getByAddressId(addressId);
	}

}
