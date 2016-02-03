package com.prijilevschi.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.prijilevschi.dao.AbstractDAO;
import com.prijilevschi.model.AbstractEntity;

public abstract class AbstractDAOImpl<T extends AbstractEntity> implements AbstractDAO<T> {
	@PersistenceContext
	protected EntityManager entityManager;	
	
	protected final Class<T> typeClass;
	
	public AbstractDAOImpl(Class<T> typeParameterClass) {
        this.typeClass = typeParameterClass;
    }
	
	@Override
	public void save(T entity) {
		if(entity.getId() == null) {
			entityManager.persist(entity);
		} else {
			entityManager.merge(entity);
		}
	}

	@Override
	public T findById(Long id) {
		T entity = entityManager.find(typeClass, id);
		return entity;
	}

	@Override
	public List<T> findAll() {
		String hqlSelect = "from " + typeClass.getName();
		TypedQuery<T> query = entityManager.createQuery(hqlSelect, typeClass);
		return query.getResultList(); 
	}

	@Override
	public void delete(T entity) {
		entityManager.remove(entity);		
	}

	@Override
	public int deleteAll() {
		String hqlDelete = "DELETE " + typeClass.getName();
		int deletedRows = entityManager.createQuery(hqlDelete).executeUpdate();
		return deletedRows;
	}
	
}
