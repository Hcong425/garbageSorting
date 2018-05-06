package cn.edu.rubbish.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.manger.bean.User;
import cn.edu.manger.dao.UserDao;
import cn.edu.rubbish.bean.RubbishItem;
import cn.edu.rubbish.dao.RubbishItemDao;
import cn.edu.util.PageBean;

@Service
public class RubbishItemService {

	private RubbishItemDao rubbishItemDao;
	private UserDao userDao;

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Autowired
	public void setRubbishItemDao(RubbishItemDao rubbishItemDao) {
		this.rubbishItemDao = rubbishItemDao;
	}

	public RubbishItem getById(Integer id) {
		return rubbishItemDao.getById(id);
	}

	public void saveOrUpdate(RubbishItem rubbishItem) {
		rubbishItemDao.saveOrUpdate(rubbishItem);
	}

	public void saveOrUpdate(Set<RubbishItem> rubbishItems) {
		for (RubbishItem rubbishItem : rubbishItems) {
			saveOrUpdate(rubbishItem);
		}
	}

	public List<RubbishItem> getBySpellRubbishId(Integer id, Date start, Date end) {
		return rubbishItemDao.getBySpellRubbishId(id, start, end);
	}

	public BigDecimal getWeightBySpell(Date start, Date end) {
		BigDecimal weight = new BigDecimal(0);
		List<RubbishItem> items = rubbishItemDao.getBySpell(start, end);
		for (RubbishItem recycleItem : items) {
			weight = weight.add(recycleItem.getWeight());
		}
		return weight;
	}

	public PageBean<RubbishItem> getByPageSpellRubbishId(int pageNum, int pageSize, String line, String way, Integer id,
			Date start, Date end) {
		PageBean<RubbishItem> pageBean = new PageBean<RubbishItem>();
		int totalPage;
		int totalCount = rubbishItemDao.sizeBySpellRubbishId(id, start, end);
		pageBean.setPageNum(pageNum);
		pageBean.setPageSize(pageSize);
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		List<RubbishItem> items = rubbishItemDao.getByPageSpellRubbishId(pageNum, pageSize, line, way, id, start, end);
		pageBean.setList(items);
		return pageBean;
	}

	public BigDecimal getTodayWegiht() throws ParseException {
		BigDecimal weight = new BigDecimal(0);
		Date start = null;
		Date end = null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_MONTH, 0);
		start = calendar.getTime();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		end = calendar.getTime();
		List<RubbishItem> rubbishItems = rubbishItemDao.getBySpell(start, end);
		for (RubbishItem rubbishItem : rubbishItems) {
			weight = weight.add(rubbishItem.getWeight());
		}
		return weight;
	}

	public PageBean<RubbishItem> getByPage(int pageNum, int pageSize, String line, String way) {
		PageBean<RubbishItem> pageBean = new PageBean<RubbishItem>();
		int totalPage;
		int totalCount = rubbishItemDao.size();
		pageBean.setPageNum(pageNum);
		pageBean.setPageSize(pageSize);
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		List<RubbishItem> rubbishItems = rubbishItemDao.getAllByPage(pageNum, pageSize, line, way);
		pageBean.setList(rubbishItems);
		return pageBean;
	}

	public PageBean<RubbishItem> getByPageUserId(int pageNum, int pageSize, String line, String way, Integer id) {

		PageBean<RubbishItem> pageBean = null;
		User user = userDao.getById(id);
		if (user != null) {
			pageBean = new PageBean<RubbishItem>();
			int totalPage;
			int totalCount = rubbishItemDao.sizeByUserId(id);
			pageBean.setPageNum(pageNum);
			pageBean.setPageSize(pageSize);
			if (totalCount % pageSize == 0) {
				totalPage = totalCount / pageSize;
			} else {
				totalPage = totalCount / pageSize + 1;
			}
			pageBean.setTotalPage(totalPage);
			List<RubbishItem> rubbishItems = rubbishItemDao.getByPageUserId(pageNum, pageSize, line, way, id);
			pageBean.setList(rubbishItems);
		}
		return pageBean;

	}

	public void saveOrUpdate(RubbishItem rubbishItem, User user) {
		user.setPoint(user.getPoint() + rubbishItem.getPoint());
		rubbishItemDao.saveOrUpdate(rubbishItem);
	}

	public void delete(RubbishItem rubbishItem) {
		rubbishItemDao.delete(rubbishItem);
	}
}
