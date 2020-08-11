package com.jacobarcilacardenas.crud.dao.api;

import org.springframework.data.repository.CrudRepository;

import com.jacobarcilacardenas.crud.model.Empleado;;

public interface EmpleadoDaoAPI extends CrudRepository<Empleado, Integer> {

}
