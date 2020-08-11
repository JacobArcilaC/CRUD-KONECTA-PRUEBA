package com.jacobarcilacardenas.crud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.jacobarcilacardenas.crud.commons.GenericServiceImpl;
import com.jacobarcilacardenas.crud.dao.api.SolicitudDaoAPI;
import com.jacobarcilacardenas.crud.model.Solicitud;
import com.jacobarcilacardenas.crud.service.api.SolicitudServiceAPI;

@Service
public class SolicitudServiceImpl extends GenericServiceImpl<Solicitud, Integer> implements SolicitudServiceAPI{

	@Autowired
	private SolicitudDaoAPI solicitudDaoAPI;
	
	@Override
	public CrudRepository<Solicitud, Integer> getDao() {
		return solicitudDaoAPI;
	}


}
