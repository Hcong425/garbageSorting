package cn.edu.rubbish.service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.rubbish.bean.Rubbish;
import cn.edu.rubbish.bean.RubbishItem;
import cn.edu.rubbish.dao.RubbishDao;
import cn.edu.rubbish.dao.RubbishItemDao;
import cn.edu.util.PageBean;

@Service
public class RubbishService {

	private RubbishDao rubbishDao;
	private RubbishItemDao rubbishItemDao;

	@Autowired
	public void setRubbishDao(RubbishDao rubbishDao) {
		this.rubbishDao = rubbishDao;
	}

	@Autowired
	public void setRubbishItemDao(RubbishItemDao rubbishItemDao) {
		this.rubbishItemDao = rubbishItemDao;
	}

	public Rubbish getById(Integer id) {
		return rubbishDao.getById(id);
	}

	public List<Rubbish> getAll() {
		return rubbishDao.getAll();
	}

	public int size() {
		return rubbishDao.size();
	}

	public void saveOrUpdate(Rubbish rubbish) {
		if (rubbishDao.getByName(rubbish.getName()) == null)
			;
		rubbishDao.saveOrUpdate(rubbish);
	}

	public void saveOrUpdate(Set<Rubbish> rubbishs) {
		for (Rubbish rubbish : rubbishs) {
			if (rubbishDao.getByName(rubbish.getName()) == null)
				rubbishDao.saveOrUpdate(rubbish);
		}
	}

	public Rubbish getByName(String name) {
		return rubbishDao.getByName(name);
	}

	public void delete(Rubbish rubbish) {
		rubbishDao.delete(rubbish);
	}

	public PageBean<Rubbish> getAllChildByPage(int pageNum, int pageSize, Integer parRubbishId) {
		PageBean<Rubbish> pageBean = new PageBean<Rubbish>();
		int totalPage;
		int totalCount = 0;
		if (parRubbishId == null) {
			totalCount = rubbishDao.size();
		} else {
			totalCount = rubbishDao.sizeByParId(parRubbishId);
		}
		pageBean.setPageNum(pageNum);
		pageBean.setPageSize(pageSize);
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		List<Rubbish> rubbishs = rubbishDao.getAllChildByPage(pageNum, pageSize, parRubbishId);
		pageBean.setList(rubbishs);
		return pageBean;
	}

	public PageBean<Rubbish> getByConditionPage(int pageNum, int pageSize, String condition) {
		PageBean<Rubbish> pageBean = new PageBean<Rubbish>();
		int totalPage;
		int totalCount = 0;
		totalCount = rubbishDao.sizeByCondition(condition);
		pageBean.setPageNum(pageNum);
		pageBean.setPageSize(pageSize);
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		List<Rubbish> rubbishs = rubbishDao.getByConditionPage(pageNum, pageSize, condition);
		pageBean.setList(rubbishs);
		return pageBean;
	}

	public List<Rubbish> getRankBySpell(int pageNum, int pageSize, Date start, Date end) {
		List<Rubbish> rubbishs = rubbishDao.getChildRubbish();
		for (Rubbish rubbish : rubbishs) {
			List<RubbishItem> rubbishItems = rubbishItemDao.getBySpellRubbishId(rubbish.getId(), start, end);
			BigDecimal weight = new BigDecimal(0);
			if (rubbishItems.size() > 0) {
				for (RubbishItem rubbishItem : rubbishItems) {
					weight = weight.add(rubbishItem.getWeight());
				}
				rubbish.setSortKey(weight);
			} else {
				rubbish.setSortKey(new BigDecimal(0));
			}
		}
		Collections.sort(rubbishs);
		return rubbishs.subList((pageNum - 1) * pageSize, pageNum * pageSize);
	}

	public List<Rubbish> getByParPage(String name, Integer pageNum, Integer pageSize) {
		return rubbishDao.getByParPage(name, pageNum, pageSize);
	}

	public List<Rubbish> getParRubbish() {
		return rubbishDao.getParRubbish();
	}

}
