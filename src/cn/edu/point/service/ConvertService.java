package cn.edu.point.service;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.manger.bean.User;
import cn.edu.point.bean.Convert;
import cn.edu.point.dao.ConvertDao;
import cn.edu.util.PageBean;

@Service
public class ConvertService {

	private ConvertDao convertDao;

	@Autowired
	public void setConvertDao(ConvertDao convertDao) {
		this.convertDao = convertDao;
	}

	public Convert getById(Integer id) {
		return convertDao.getById(id);
	}

	public void saveOrUpdate(Convert convert, User user) {
		user.setPoint(user.getPoint() - convert.getPoint());
		convertDao.saveOrUpdate(convert);
	}

	public void delete(Convert convert) {
		convertDao.delete(convert);
	}

	public PageBean<Convert> getAllByPage(int pageNum, int pageSize, String line, String way) {

		PageBean<Convert> pageBean = new PageBean<Convert>();
		int totalPage;
		int totalCount = convertDao.size();
		pageBean.setPageNum(pageNum);
		pageBean.setPageSize(pageSize);
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		List<Convert> converts = convertDao.getAllByPage(pageNum, pageSize, line, way, "Convert");
		pageBean.setList(converts);
		return pageBean;

	}

	public PageBean<Convert> getPageByUserId(int pageNum, int pageSize, String line, String way, Integer userId) {

		PageBean<Convert> pageBean = new PageBean<Convert>();
		int totalPage;
		int totalCount = convertDao.sizeByUserId(userId);
		pageBean.setPageNum(pageNum);
		pageBean.setPageSize(pageSize);
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		List<Convert> converts = convertDao.getByPageUserId(pageNum, pageSize, line, way, userId);
		pageBean.setList(converts);
		return pageBean;

	}

	public PageBean<Convert> getPageByCommodityId(int pageNum, int pageSize, String line, String way,
			Integer commodityId) {

		PageBean<Convert> pageBean = new PageBean<Convert>();
		int totalPage;
		int totalCount = convertDao.sizeByCommodityId(commodityId);
		pageBean.setPageNum(pageNum);
		pageBean.setPageSize(pageSize);
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		List<Convert> converts = convertDao.getPageByCommodityId(pageNum, pageSize, line, way, commodityId);
		pageBean.setList(converts);
		return pageBean;
	}

	public int getTodayAmount() throws ParseException {
		int amount = 0;
		Date start = null;
		Date end = null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_MONTH, 0);
		start = calendar.getTime();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		end = calendar.getTime();
		List<Convert> items = convertDao.getBySpell(start, end);
		for (Convert convert : items) {
			amount += convert.getAmount();
		}
		return amount;
	}

	public int getTotalAmount() {
		int totalAmount = 0;
		List<Convert> items = convertDao.getAll();
		for (Convert convert : items) {
			totalAmount += convert.getAmount();
		}
		return totalAmount;
	}

}
