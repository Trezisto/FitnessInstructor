package com.prijilevschi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prijilevschi.dao.AbstractDAO;
import com.prijilevschi.model.AbstractEntity;
import com.prijilevschi.service.AbstractService;

@Service
public class AbstractServiceImpl<T extends AbstractEntity> implements AbstractService<T> {
	@Autowired
	AbstractDAO<T> genericDAO;

	@Override
	@Transactional
	public void save(T entity) {
		genericDAO.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public T findById(Long id) {
		return genericDAO.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> findAll() {
		return genericDAO.findAll();
	}

	@Override
	@Transactional
	public void delete(T entity) {
		genericDAO.delete(entity);
	}

	@Override
	@Transactional
	public int deleteAll() {
		return genericDAO.deleteAll();
	}
}
