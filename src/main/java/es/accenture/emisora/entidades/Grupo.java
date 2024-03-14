package es.accenture.emisora.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "grupos")
public class Grupo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int grupoId;
	private String nombre;
	private int creacion;
	private String origen;
	private String genero;
	@OneToMany(mappedBy = "grupo", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Componente> componentes = new ArrayList<>();

	public Grupo() {
		
	}

	public Grupo(String nombre, int creacion, String origen, String genero) {
		this.nombre = nombre;
		this.creacion = creacion;
		this.origen = origen;
		this.genero = genero;
	}
	
	public void agregarComponente(Componente componente) {
		this.componentes.add(componente);
	}

	public int getGrupoId() {
		return grupoId;
	}

	public void setGrupoId(int grupoId) {
		this.grupoId = grupoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCreacion() {
		return creacion;
	}

	public void setCreacion(int creacion) {
		this.creacion = creacion;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public List<Componente> getComponentes() {
		return componentes;
	}

	public void setComponentes(List<Componente> componentes) {
		this.componentes = componentes;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(grupoId).append(" - ").append(nombre).append(" - ").append(origen).append(" - ").append(creacion).append(" - ").append(genero);
		sb.append("\n").append("Componentes: ");
		for(Componente comp : componentes) {
			sb.append(comp.getNombre()).append("(").append(comp.getInstrumento()).append(") ");
		}
		
		return sb.toString();
	}
}
