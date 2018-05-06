package cn.edu.right.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.right.bean.Classes;
import cn.edu.right.dao.ClassesDao;

@Service
public class ClassesService {

	private ClassesDao classesDao;

	@Autowired
	public void setClassesDao(ClassesDao classesDao) {
		this.classesDao = classesDao;
	}

	public List<Classes> getAll() {
		return classesDao.getAll();
	}

	public Classes getById(Integer id) {
		return classesDao.getById(id);
	}

	public Classes getByName(String name) {
		return classesDao.getByName(name);
	}

	public void saveOrUpdate(Classes classes) {
		classesDao.saveOrUpdate(classes);
	}

	public void delete(Classes classes) {
		classesDao.delete(classes);
	}

}
