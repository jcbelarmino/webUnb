package br.unb.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.unb.dominio.Aluno;

@Stateless
@LocalBean
public class AlunoBean {
 @PersistenceContext
 private EntityManager em;

 public void adicionarAluno(Aluno aluno) {
     em.persist(aluno);
 }

 public List<Aluno> listarAlunos() {
     Query query = em.createQuery("SELECT a FROM Aluno a");
     return query.getResultList();
 }

 public void excluirAluno(int id) {
     Aluno aluno = em.find(Aluno.class, id);
     if (aluno != null) {
         em.remove(aluno);
     }
 }
}
