package es.accenture.emisora.daos;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.accenture.emisora.entidades.Grupo;
import es.accenture.emisora.excepcion.ExcepcionPropia;

@Transactional
@Service
public class GrupoDAO implements IGrupoDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<Grupo> getGrupos() throws ExcepcionPropia {
		List<Grupo> listaGrupos = null;
		
		try {
			listaGrupos = getSession().createQuery("FROM Grupo", Grupo.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExcepcionPropia(e.getMessage());
		}

		return listaGrupos;
	}

	@Override
	public Grupo getGrupo(int id) throws ExcepcionPropia {
		Grupo grupo = getSession().load(Grupo.class, id);
		
		return grupo;
	}

	@Override
	public void altaGrupo(Grupo grupo) throws ExcepcionPropia {
		try {
			getSession().save(grupo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExcepcionPropia(e.getMessage());
		}

	}

	@Override
	public void eliminaGrupo(int id) throws ExcepcionPropia {
		Grupo grupo = null;
		
		try {
			grupo = getSession().load(Grupo.class, id);
			getSession().delete(grupo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExcepcionPropia(e.getMessage());
		}
	}

	@Override
	public void actualizaGrupo(Grupo grupo) throws ExcepcionPropia {
		try {
			Grupo entidad = getSession().load(Grupo.class, grupo.getGrupoId());
			entidad.setCreacion(grupo.getCreacion());
			entidad.setGenero(grupo.getGenero());
			entidad.setNombre(grupo.getNombre());
			entidad.setOrigen(grupo.getOrigen());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExcepcionPropia(e.getMessage());
		}
	}

}
