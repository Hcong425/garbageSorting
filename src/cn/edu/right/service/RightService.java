package cn.edu.right.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.right.bean.Right;
import cn.edu.right.dao.RightDao;
import cn.edu.util.PageBean;

@Service
public class RightService {

	private RightDao rightDao;

	@Autowired
	public void setRightDao(RightDao rightDao) {
		this.rightDao = rightDao;
	}

	public void saveOrUpdate(Right right) {
		rightDao.saveOrUpdate(right);
	}

	public Right getById(Integer id) {
		return rightDao.getById(id);
	}

	public List<Right> getAll() {
		return rightDao.getAll();
	}

	public void delete(Right right) {
		rightDao.delete(right);
	}

	public PageBean<Right> getAllByPage(int pageNum, int pageSize, String line, String way) {
		PageBean<Right> pageBean = new PageBean<Right>();
		int totalPage;
		int totalCount = rightDao.size();
		pageBean.setPageNum(pageNum);
		pageBean.setPageSize(pageSize);
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		List<Right> rights = rightDao.getAllByPage(pageNum, pageSize, line, way, "Right");
		pageBean.setList(rights);
		return pageBean;
	}

	public List<Right> getByRoleId(Integer id) {
		return rightDao.getBYRoleId(id);
	}

}
