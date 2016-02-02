package com.prijilevschi.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.prijilevschi.dao.AbstractDAO;
import com.prijilevschi.model.AbstractEntity;

public class AbstractDAOImpl<T extends AbstractEntity> implements AbstractDAO<T> {
	@PersistenceContext
	private EntityManager entityManager;	
	
	private final Class<T> typeParameterClass;
	
	public AbstractDAOImpl(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
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
		T entity = entityManager.find(typeParameterClass, id);
		return entity;
	}

	@Override
	public List<T> findAll() {
		String hqlSelect = "from " + typeParameterClass.getName();
		TypedQuery<T> query = entityManager.createQuery(hqlSelect, typeParameterClass);
		return query.getResultList(); 
	}

	@Override
	public void delete(T entity) {
		entityManager.remove(entity);		
	}

	@Override
	public int deleteAll() {
		String hqlDelete = "DELETE " + typeParameterClass.getName();
		int deletedRows = entityManager.createQuery(hqlDelete).executeUpdate();
		return deletedRows;
	}
	
}
