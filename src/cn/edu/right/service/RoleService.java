package cn.edu.right.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.right.bean.Role;
import cn.edu.right.dao.RoleDao;
import cn.edu.util.PageBean;

@Service
public class RoleService {

	private RoleDao roleDao;

	@Autowired
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public void saveOrUpdate(Role role) {
		roleDao.saveOrUpdate(role);
	}

	public Role getById(Integer id) {
		return roleDao.getById(id);
	}

	public PageBean<Role> getAllByPage(int pageNum, int pageSize, String line, String way) {
		PageBean<Role> pageBean = new PageBean<Role>();
		int totalPage;
		int totalCount = roleDao.size();
		pageBean.setPageNum(pageNum);
		pageBean.setPageSize(pageSize);
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		List<Role> roles = roleDao.getAllByPage(pageNum, pageSize, line, way, "Role");
		pageBean.setList(roles);
		return pageBean;
	}

	public List<Role> getAll() {
		return roleDao.getAll();
	}

	public void delete(Role role) {
		roleDao.delete(role);
	}
}
