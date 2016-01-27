package com.prijilevschi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prijilevschi.dao.AbstractDAO;
import com.prijilevschi.model.AbstractEntity;
import com.prijilevschi.service.AbstractService;

@Service
public class AbstractServiceImpl implements AbstractService {
	@Autowired
	AbstractDAO<? extends AbstractEntity> genericDAO;
}
