package com.mycompany.teacher.model.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {

	void seve(T entity);
	void update(T entity);
	void delete(T entity);
	T byId(final Serializable id);
	List<T> getList(String qery);
}