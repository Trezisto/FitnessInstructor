package com.prijilevschi.dao;

import java.util.List;

public interface AbstractDAO<T> {
	/**
	 * Persist or merge entity depending on id presence
	 * @param entity
	 */
	void save(T entity);
	
	/**
	 * Find by primary key
	 * @param id PK
	 * @return entity
	 */
	T findById(Long id);
	
	/**
	 * 
	 * @return
	 */
	List<T> findAll();
	
	/**
	 * Remove the entity instance
	 * @param entity
	 */
	void delete(T entity);
	
	/**
	 * Delete all entity instances
	 * @return number of deleted rows
	 */
	int deleteAll();
}
