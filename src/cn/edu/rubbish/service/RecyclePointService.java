package cn.edu.rubbish.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.rubbish.bean.RecyclePoint;
import cn.edu.rubbish.dao.RecyclePointDao;
import cn.edu.util.PageBean;

@Service
public class RecyclePointService {

	private RecyclePointDao recyclePointDao;

	@Autowired
	public void setRecyclePointDao(RecyclePointDao recyclePointDao) {
		this.recyclePointDao = recyclePointDao;
	}

	public RecyclePoint getById(Integer id) {
		return recyclePointDao.getById(id);
	}

	public List<RecyclePoint> getAll() {
		return recyclePointDao.getAll();
	}

	public PageBean<RecyclePoint> getAllByPage(int pageNum, int pageSize, String line, String way) {
		PageBean<RecyclePoint> pageBean = new PageBean<RecyclePoint>();
		int totalPage;
		int totalCount = recyclePointDao.size();
		pageBean.setPageNum(pageNum);
		pageBean.setPageSize(pageSize);
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		List<RecyclePoint> recyclePoints = recyclePointDao.getAllByPage(pageNum, pageSize, line, way, "RecyclePoint");
		pageBean.setList(recyclePoints);
		return pageBean;
	}

	public int size() {
		return recyclePointDao.size();
	}

	public BigDecimal getWeight(Integer id) {
		return recyclePointDao.getWeight(id);
	}

	public BigDecimal getAllWeight() {
		BigDecimal weight = new BigDecimal(0);
		List<RecyclePoint> recyclePoint = getAll();
		for (RecyclePoint point : recyclePoint) {
			weight = weight.add(recyclePointDao.getWeight(point.getId()));
		}
		return weight;
	}

	public void saveOrUpdate(RecyclePoint recyclePoint) {
		recyclePointDao.saveOrUpdate(recyclePoint);
	}

	public boolean deleteById(Integer id) {
		RecyclePoint recyclePoint = recyclePointDao.getById(id);
		if (recyclePoint != null)
			return recyclePointDao.delete(recyclePoint);
		return false;
	}
}
