package com.mycompany.teacher.model.repositories;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public abstract class BaeseRepository<T> {
	
	@Autowired
	protected SessionFactory sessionFactory;
	
	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	public void save(T entity){
		getSession().save(entity);
	}
	
	public void update(T entity){
		getSession().update(entity);
	}
	
	public abstract T byId(final Serializable id);
	
	public abstract List<T> getList();
}
