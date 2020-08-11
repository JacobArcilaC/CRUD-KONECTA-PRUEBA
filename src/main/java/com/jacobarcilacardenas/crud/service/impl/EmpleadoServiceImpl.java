package com.jacobarcilacardenas.crud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.jacobarcilacardenas.crud.commons.GenericServiceImpl;
import com.jacobarcilacardenas.crud.dao.api.EmpleadoDaoAPI;
import com.jacobarcilacardenas.crud.model.Empleado;
import com.jacobarcilacardenas.crud.service.api.EmpleadoServiceAPI;

@Service
public class EmpleadoServiceImpl extends GenericServiceImpl<Empleado, Integer> implements EmpleadoServiceAPI {

	@Autowired
	private EmpleadoDaoAPI empleadoDaoAPI;
	
	@Override
	public CrudRepository<Empleado, Integer> getDao() {
		return empleadoDaoAPI;
	}

}
