package cn.edu.point.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.point.bean.PointChange;
import cn.edu.point.dao.PointChangeDao;
import cn.edu.util.PageBean;

@Service
public class PointChangeService {

	private PointChangeDao pointChangeDao;

	@Autowired
	public void setPointChangeDao(PointChangeDao pointChangeDao) {
		this.pointChangeDao = pointChangeDao;
	}

	public void saveOrUpdate(PointChange pointChange) {
		pointChangeDao.saveOrUpdate(pointChange);
	}

	public PointChange getById(Integer id) {
		return pointChangeDao.getById(id);
	}

	public List<PointChange> getAll() {
		return pointChangeDao.getAll();
	}

	public PageBean<PointChange> getAllByPage(int pageNum, int pageSize, String line, String way) {
		PageBean<PointChange> pageBean = new PageBean<PointChange>();
		int totalPage;
		int totalCount = pointChangeDao.size();
		pageBean.setPageNum(pageNum);
		pageBean.setPageSize(pageSize);
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		List<PointChange> pointChanges = pointChangeDao.getAllByPage(pageNum, pageSize, line, way);
		pageBean.setList(pointChanges);
		return pageBean;
	}

}
