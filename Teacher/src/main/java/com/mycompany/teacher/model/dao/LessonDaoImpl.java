package com.mycompany.teacher.model.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.teacher.model.entity.Lesson;

@Repository
public class LessonDaoImpl implements BaseDao<Lesson>{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void seve(Lesson entity) {
		Session session = sessionFactory.getCurrentSession();
		session.save(entity);
	}

	@Override
	public void update(Lesson entity) {
		Session session = sessionFactory.getCurrentSession();
		session.update(entity);
	}

	@Override
	public void delete(Lesson entity) {
		// TODO Auto-generated method stub
	}

	@Override
	public Lesson byId(long id) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(Lesson.class, id);
	}

	@Override
	public List<Lesson> getList(String qery) {
		Session session = sessionFactory.getCurrentSession();
		//TypedQuery<Lesson> typedQuery = session.cre
		return null;
	}

}
