package com.mycompany.teacher.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.teacher.model.entity.Lesson;

@Repository
public class LessonDaoImpl implements BaseDao<Lesson>{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public void seve(Lesson entity) {
		getSession().save(entity);
	}

	@Override
	public void update(Lesson entity) {
		getSession().update(entity);
	}

	@Override
	public void delete(Lesson entity) {
		// TODO Auto-generated method stub
	}

	@Override
	public Lesson byId(Serializable id) {
		return getSession().get(Lesson.class, id);
	}

	@Override
	public List<Lesson> getList(String qery) {
		// TODO Auto-generated method stub
		return null;
	}


}
