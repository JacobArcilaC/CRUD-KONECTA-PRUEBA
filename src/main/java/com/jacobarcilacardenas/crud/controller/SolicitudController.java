package com.jacobarcilacardenas.crud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.jacobarcilacardenas.crud.model.Solicitud;
import com.jacobarcilacardenas.crud.service.api.EmpleadoServiceAPI;
import com.jacobarcilacardenas.crud.service.api.SolicitudServiceAPI;

@Controller
public class SolicitudController {
	
	@Autowired
	private SolicitudServiceAPI solicitudServiceAPI;
	
	@Autowired
	private EmpleadoServiceAPI empleadoServiceAPI;
	
	@RequestMapping("/indexSolicitud")
	public String indexEmpleado(Model model) {
		model.addAttribute("list", solicitudServiceAPI.getAll());
		return "indexSolicitud";
	}
	
	@GetMapping("/saveSolicitud/{id}")
	public String saveSolicitud(@PathVariable("id")Integer id, Model model) {
		if(id!=null && id !=0) {
			model.addAttribute("solicitud", solicitudServiceAPI.get(id));
			model.addAttribute("empleados", empleadoServiceAPI.getAll());
		}else {
			model.addAttribute("solicitud", new Solicitud());
		}
		return "saveSolicitud";
	}

	@PostMapping("/saveSolicitud")
	public String showSaveSolicitud(Solicitud solicitud, Model model) {
		solicitudServiceAPI.save(solicitud);
		return "redirect:/indexSolicitud";
	}
	
	@GetMapping("/deleteSolicitud/{id}")
	public String deleteSolcitud(@PathVariable Integer id, Model model) {
		solicitudServiceAPI.delete(id);
		return "redirect:/indexSolicitud";
	}
}