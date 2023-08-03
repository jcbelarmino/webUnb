package br.unb.jsf;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.unb.dominio.Aluno;
import br.unb.dominio.Disciplina;
import br.unb.ejb.AlunoBean;
import br.unb.ejb.DisciplinaBean;

@Named("alunoDisciplinaBean")
@RequestScoped
public class AlunoDisciplinaBean implements Serializable {
	private Aluno aluno;
	private Disciplina disciplina;

	@EJB
	private AlunoBean alunoBean;

	@EJB
	private DisciplinaBean disciplinaBean;

	@PostConstruct
	public void init() {
		aluno = new Aluno();
		disciplina = new Disciplina();
	}

	public void vincularAlunoDisciplina() {
		if (aluno != null && disciplina != null) {
			alunoBean.adicionarDisciplinaAluno(aluno, disciplina);
		}
	}

	// Getters e setters para os atributos acima

	public List<Aluno> getAlunos() {
		return alunoBean.listarAlunos();
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinaBean.listarDisciplinas();
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

}
