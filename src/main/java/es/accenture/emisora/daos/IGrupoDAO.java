package es.accenture.emisora.daos;

import java.util.List;

import org.springframework.stereotype.Service;

import es.accenture.emisora.entidades.Grupo;
import es.accenture.emisora.excepcion.ExcepcionPropia;

@Service
public interface IGrupoDAO {
	public List<Grupo> getGrupos() throws ExcepcionPropia;

	public Grupo getGrupo(int id) throws ExcepcionPropia;

	public void altaGrupo(Grupo grupo) throws ExcepcionPropia;

	public void eliminaGrupo(int id) throws ExcepcionPropia;

	public void actualizaGrupo(Grupo grupo) throws ExcepcionPropia;
}
