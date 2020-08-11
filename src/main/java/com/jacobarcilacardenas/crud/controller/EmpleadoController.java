package com.jacobarcilacardenas.crud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.jacobarcilacardenas.crud.model.Empleado;
import com.jacobarcilacardenas.crud.service.api.EmpleadoServiceAPI;

@Controller
public class EmpleadoController {
	
	@Autowired
	private EmpleadoServiceAPI empleadoServiceAPI;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("list", empleadoServiceAPI.getAll());
		return "index";
	}
	
	@RequestMapping("/indexEmpleado")
	public String indexEmpleado(Model model) {
		model.addAttribute("list", empleadoServiceAPI.getAll());
		return "index";
	}
	
	@GetMapping("/save/{id}")
	public String save(@PathVariable("id")Integer id, Model model) {
		if(id!=null && id !=0) {
			model.addAttribute("empleado", empleadoServiceAPI.get(id));
		}else {
			model.addAttribute("empleado", new Empleado());
		}
		return "save";
	}

	@PostMapping("/save")
	public String showSave(Empleado empleado, Model model) {
		empleadoServiceAPI.save(empleado);
		return "redirect:/indexEmpleado";
		
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, Model model) {
		empleadoServiceAPI.delete(id);
		return "redirect:/indexEmpleado";
	}
	
	
}
