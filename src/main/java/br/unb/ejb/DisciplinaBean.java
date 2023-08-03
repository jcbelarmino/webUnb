package br.unb.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.unb.dominio.Disciplina;

@Stateless
@LocalBean
public class DisciplinaBean {
	@PersistenceContext
	private EntityManager em;

	public void adicionarDisciplina(Disciplina d) {
		em.persist(d);
	}

	public List<Disciplina> listarDisciplinas() {
		Query query = em.createQuery("SELECT d FROM Disciplina d");
		return query.getResultList();
	}

	public void excluirDisciplina(int id) {
		Disciplina d = em.find(Disciplina.class, id);
		if (d != null) {
			em.remove(d);
		}
	}
}
