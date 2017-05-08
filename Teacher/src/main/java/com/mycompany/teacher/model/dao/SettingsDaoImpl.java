package com.mycompany.teacher.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mycompany.teacher.model.entity.Settings;

public class SettingsDaoImpl implements BaseDao<Settings> {

	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	@Override
	public void seve(Settings entity) {
		getSession().save(entity);
	}

	@Override
	public void update(Settings entity) {
		
	}

	@Override
	public void delete(Settings entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Settings byId(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Settings> getList(String qery) {
		// TODO Auto-generated method stub
		return null;
	}

}
