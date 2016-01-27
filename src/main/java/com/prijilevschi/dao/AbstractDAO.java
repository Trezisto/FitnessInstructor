package com.prijilevschi.dao;

import java.util.List;

public interface AbstractDAO<T> {
	void persist(T entity);
	T findById(Long id);
	List<T> findAll();
	void delete(T entity);
	void deleteAll();
}
