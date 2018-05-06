package cn.edu.point.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.point.bean.ConvertItem;
import cn.edu.point.dao.ConvertItemDao;

@Service
public class ConvertItemService {

	private ConvertItemDao convertItemDao;

	@Autowired
	public void setConvertItemDao(ConvertItemDao convertItemDao) {
		this.convertItemDao = convertItemDao;
	}

	public ConvertItem getById(Integer id) {
		return convertItemDao.getById(id);
	}

	public void saveOrUpdate(ConvertItem convertItem) {
		convertItemDao.saveOrUpdate(convertItem);
	}

}
