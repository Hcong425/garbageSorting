package cn.edu.point.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.point.bean.Commodity;
import cn.edu.point.bean.ConvertItem;
import cn.edu.point.dao.CommodityDao;
import cn.edu.point.dao.ConvertItemDao;
import cn.edu.util.PageBean;

@Service
public class CommodityService {

	private CommodityDao commodityDao;
	private ConvertItemDao convertItemDao;

	@Autowired
	public void setConvertItemDao(ConvertItemDao convertItemDao) {
		this.convertItemDao = convertItemDao;
	}

	@Autowired
	public void setCommodityDao(CommodityDao commodityDao) {
		this.commodityDao = commodityDao;
	}

	public void saveOrUpdate(Commodity commodity) {
		commodityDao.saveOrUpdate(commodity);
	}

	public Commodity getById(Integer id) {
		return commodityDao.getById(id);
	}

	public void delete(Commodity commodity) {
		commodityDao.delete(commodity);
	}

	public PageBean<Commodity> getAllByPage(int pageNum, int pageSize, String line, String way) {
		PageBean<Commodity> pageBean = new PageBean<Commodity>();
		int totalPage;
		int totalCount = commodityDao.size();
		pageBean.setPageNum(pageNum);
		pageBean.setPageSize(pageSize);
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		List<Commodity> commodities = commodityDao.getAllByPage(pageNum, pageSize, line, way, "Commodity");
		pageBean.setList(commodities);
		return pageBean;
	}

	public List<Commodity> getRankBySpell(int pageNum, int pageSize, Date start, Date end) {
		List<Commodity> commodities = commodityDao.getAll();
		for (Commodity commodity : commodities) {
			List<ConvertItem> commodityItems = convertItemDao.getBySpellCommodityId(commodity.getId(), start, end);
			int amount = 0;
			if (commodityItems.size() > 0) {
				for (ConvertItem convertItem : commodityItems) {
					amount += convertItem.getQuantity();
				}
			}
			commodity.setSortKey(amount);
		}
		Collections.sort(commodities);
		return commodities.subList((pageNum - 1) * pageSize, pageNum * pageSize);
	}
}
