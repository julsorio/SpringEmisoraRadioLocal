package es.accenture.emisora.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "componentes")
public class Componente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int componenteId;
	private String nombre;
	private String instrumento;
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name="grupoId", nullable=false)
	private Grupo grupo;

	public Componente() {
		// TODO Auto-generated constructor stub
	}

	public Componente(String nombre, String instrumento) {
		this.nombre = nombre;
		this.instrumento = instrumento;
	}

	public int getComponenteId() {
		return componenteId;
	}

	public void setComponenteId(int componenteId) {
		this.componenteId = componenteId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getInstrumento() {
		return instrumento;
	}

	public void setInstrumento(String instrumento) {
		this.instrumento = instrumento;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

}
