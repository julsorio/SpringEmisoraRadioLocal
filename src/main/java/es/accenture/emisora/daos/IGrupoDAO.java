package es.accenture.emisora.daos;

import java.util.List;

import org.springframework.stereotype.Service;

import es.accenture.emisora.entidades.Grupo;

@Service
public interface IGrupoDAO {
	public List<Grupo> getGrupos();

	public Grupo getGrupo(int id);

	public void altaGrupo(Grupo grupo);

	public void eliminaGrupo(int id);

	public void actualizaGrupo(Grupo grupo);
}
