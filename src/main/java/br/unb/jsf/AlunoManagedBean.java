// AlunoManagedBean.java
package br.unb.jsf;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.unb.dominio.Aluno;
import br.unb.ejb.AlunoBean;

@Named("alunoManagedBean")
@RequestScoped
public class AlunoManagedBean implements Serializable {
    @EJB
    private AlunoBean alunoBean;

    private Aluno novoAluno = new Aluno();
    private List<Aluno> alunos;

    public void cadastrarAluno() {
        alunoBean.adicionarAluno(novoAluno);
        setNovoAluno(new Aluno()); // Limpar campos após o cadastro
        atualizarListaAlunos();
    }

    public void excluirAluno(int id) {
        alunoBean.excluirAluno(id);
        atualizarListaAlunos();
    }

    public List<Aluno> getAlunos() {
        if (alunos == null) {
            atualizarListaAlunos();
        }
        return alunos;
    }

    private void atualizarListaAlunos() {
        alunos = alunoBean.listarAlunos();
    }

	public Aluno getNovoAluno() {
		return novoAluno;
	}

	public void setNovoAluno(Aluno novoAluno) {
		this.novoAluno = novoAluno;
	}

	  
}
