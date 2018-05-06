package cn.edu.manger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.manger.bean.Manger;
import cn.edu.manger.dao.MangerDao;
import cn.edu.util.PageBean;

@Service
public class MangerService {

	private MangerDao mangerDao;

	@Autowired
	public void setMangerDao(MangerDao mangerDao) {
		this.mangerDao = mangerDao;
	}

	public Manger getByName(String name) {
		return mangerDao.getByName(name);
	}

	public void saveOrUpdate(Manger manger) {
		mangerDao.saveOrUpdate(manger);
	}

	public void delete(Manger manger) {
		mangerDao.delete(manger);
	}

	public Manger getById(Integer id) {
		return mangerDao.getById(id);
	}

	public PageBean<Manger> getAllByPage(int pageNum, int pageSize, String line, String way) {
		PageBean<Manger> pageBean = new PageBean<Manger>();
		int totalPage;
		int totalCount = mangerDao.size();
		pageBean.setPageNum(pageNum);
		pageBean.setPageSize(pageSize);
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		List<Manger> mangers = mangerDao.getAllByPage(pageNum, pageSize, line, way, "Manger");
		pageBean.setList(mangers);
		return pageBean;
	}
}
