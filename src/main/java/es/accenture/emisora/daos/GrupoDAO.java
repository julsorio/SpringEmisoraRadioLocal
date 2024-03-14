package es.accenture.emisora.daos;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.accenture.emisora.entidades.Grupo;

@Transactional
@Service
public class GrupoDAO implements IGrupoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Grupo> getGrupos() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Grupo> listaGrupos = session.createQuery("FROM Grupo", Grupo.class).list();

		return listaGrupos;
	}

	@Override
	public Grupo getGrupo(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Grupo grupo = session.load(Grupo.class, id);
		
		return grupo;
	}

	@Override
	public void altaGrupo(Grupo grupo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminaGrupo(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizaGrupo(Grupo grupo) {
		// TODO Auto-generated method stub

	}

}
