package com.prijilevschi.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.prijilevschi.dao.AbstractDAO;

@Repository
public class AbstractDAOImpl<T> implements AbstractDAO<T> {
	@PersistenceContext
	EntityManager entityManager;	
	
	@Override
	public void persist(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	
}
