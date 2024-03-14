package es.accenture.emisora.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import es.accenture.emisora.daos.IGrupoDAO;
import es.accenture.emisora.entidades.Grupo;
import es.accenture.emisora.excepcion.ExcepcionPropia;

@Controller
@RequestMapping("/emisora")
public class Controlador {
	@Autowired
	private IGrupoDAO grupoDAO;
	
	@GetMapping("/lista")
	public String mostrarListaGrupos(Model model) {
		List<Grupo> listaGrupos = null;
		
		try {
			listaGrupos = grupoDAO.getGrupos();
		} catch (ExcepcionPropia e) {
			model.addAttribute("error", "Se ha producido un error al obtener la lista de grupos" + e.getMessage());
		}
		
		model.addAttribute("listaGrupos", listaGrupos);
		
		return "GruposMusicales";
	}
	
	@GetMapping("/detalle/{grupoId}")
	public String mostrarDetalle(@PathVariable("grupoId") int grupoId, Model model) {
		Grupo grupo = null;
		try {
			grupo = grupoDAO.getGrupo(grupoId);
		} catch (ExcepcionPropia e) {
			model.addAttribute("error", "Se ha producido un error al obtener el grupo" + e.getMessage());
		}
		
		model.addAttribute("grupo", grupo);
		
		return "DetalleGrupo";
	}
	
	@GetMapping("/modificar/{grupoId}")
	public String modificarGrupo(@PathVariable("grupoId") int grupoId, Model model) {
		Grupo grupo = null;
		try {
			grupo = grupoDAO.getGrupo(grupoId);
		} catch (ExcepcionPropia e) {
			model.addAttribute("error", "Se ha producido un error al obtener el grupo" + e.getMessage());
		}
		
		model.addAttribute("grupo", grupo);
		
		return "ActualizarGrupo";
	}
	
	@PostMapping("/modificar")
	public ModelAndView actualizarGrupo(@ModelAttribute("grupo") Grupo grupo, ModelMap model) {
		try {
			grupoDAO.actualizaGrupo(grupo);
			model.addAttribute("error", "El grupo " + grupo.getNombre() + " se ha modificado exitosamente");
		} catch (ExcepcionPropia e) {
			model.addAttribute("error", "Se ha producido un error al actualizar el grupo" + e.getMessage());
		}
		
		return new ModelAndView("redirect:/emisora/lista", model);
	}
	
	@GetMapping("/baja/{grupoId}")
	public String bajaGrupo(@PathVariable("grupoId") int grupoId, Model model) {
		try {
			grupoDAO.eliminaGrupo(grupoId);
			model.addAttribute("error", "El grupo con id" + grupoId + " se ha dado de baja exitosamente");
		} catch (Exception e) {
			model.addAttribute("error", "Se ha producido un error al dar de baja el grupo" + e.getMessage());
		}
		
		return "redirect:/emisora/lista";
	}
	
	@GetMapping("/alta")
	public String altaGrupo(Model model) {
		model.addAttribute("grupo", new Grupo());
		return "NuevoGrupo";
	}
	
	@PostMapping("/insertar")
	public ModelAndView insertarGrupo(@ModelAttribute("grupo") Grupo grupo, ModelMap model) {
		try {
			grupoDAO.altaGrupo(grupo);
			model.addAttribute("error", "El grupo " + grupo.getNombre() + " se ha dado de alta exitosamente");
		} catch (ExcepcionPropia e) {
			model.addAttribute("error", "Se ha producido un error al dar de alta el grupo " + grupo.getNombre() + e.getMessage());
		}
		
		return new ModelAndView("redirect:/emisora/lista", model);
	}
}
