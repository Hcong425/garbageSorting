package cn.edu.manger.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.manger.bean.User;
import cn.edu.manger.dao.UserDao;
import cn.edu.util.PageBean;

@Service
public class UserService {

	private UserDao userDao;

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public List<User> getUser() {
		return userDao.getAll();
	}

	public int size() {
		return userDao.size();
	}

	public User getById(Integer id) {
		return userDao.getById(id);
	}

	public void saveOrUpdate(User user) {
		userDao.saveOrUpdate(user);
	}

	public List<User> getBySpell(Date start, Date end) {
		if (start.getTime() - end.getTime() < 0)
			return userDao.getBySpell(start, end);
		return null;
	}

	public List<User> getTodayRegistUser() {
		Date start = null;
		Date end = null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_MONTH, 0);
		start = calendar.getTime();
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		end = calendar.getTime();
		return userDao.getBySpell(start, end);
	}

	public int getPointById(Integer id) {
		int point = 0;
		User user = getById(id);
		if (user != null)
			point = user.getPoint();
		return point;

	}

	public PageBean<User> getAllByPage(int pageNum, int pageSize, String line, String way) {
		PageBean<User> pageBean = new PageBean<User>();
		int totalPage;
		int totalCount = userDao.size();
		pageBean.setPageNum(pageNum);
		pageBean.setPageSize(pageSize);
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		List<User> users = userDao.getAllByPage(pageNum, pageSize, line, way);
		pageBean.setList(users);
		return pageBean;
	}

	public void delete(User user) {
		userDao.delete(user);
	}

}
