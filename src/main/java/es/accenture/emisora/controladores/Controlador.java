package es.accenture.emisora.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import es.accenture.emisora.daos.IGrupoDAO;

@Controller
@RequestMapping("/emisora")
public class Controlador {
	@Autowired
	private IGrupoDAO grupoDAO;
	
	@GetMapping("/lista")
	public String mostrarListaGrupos(Model model) {
		
		model.addAttribute("listaGrupos", grupoDAO.getGrupos());
		
		return "GruposMusicales";
	}
	
	@GetMapping("/detalle/{grupoId}")
	public String mostrarDetalle(@PathVariable("grupoId") int grupoId, Model model) {
		
		model.addAttribute("grupo", grupoDAO.getGrupo(grupoId));
		
		return "DetalleGrupo";
	}
}
