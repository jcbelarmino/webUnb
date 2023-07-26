package com.example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.unb.dao.PessoaDAO;
import br.unb.dominio.Endereco;
import br.unb.dominio.Pessoa;
import br.unb.dominio.heranca.PessoaFisica;
import br.unb.dominio.heranca.PessoaJuridica;
import br.unb.dominio.heranca.PessoaSingleTable;

public class HelloAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		HelloForm helloForm = (HelloForm) form;
		PessoaDAO dao = new PessoaDAO();
		// Criando uma nova pessoa
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("joao da Silva");
		pessoa.setIdade(30);

		Endereco e = new Endereco();
		e.setCidade("Brasilia");
		e.setEstado("DF");
		e.setRua("SQS108");

		pessoa.setEndereco(e);
		pessoa = dao.salvar(pessoa);
		System.out.println("Pessoa Salva -> "+pessoa);
		helloForm.setMessage("Pessoa, " + pessoa+ "!");
		PessoaFisica pf = new PessoaFisica();
		pf.setCpf("111.111.111-11");
		pf.setNome("pessoa física");
		PessoaJuridica pj = new PessoaJuridica();
		pj.setCnpj("16.747.513/0001-09");
		pj.setNome("pessoa Juridica");
		br.unb.dominio.heranca.dao.PessoaDAO hDao = new br.unb.dominio.heranca.dao.PessoaDAO();
		pj = (PessoaJuridica)hDao.salvar(pj);
		pf = (PessoaFisica)hDao.salvar(pf);
		return mapping.findForward("success");
//		HelloForm helloForm = (HelloForm) form;
//		helloForm.setMessage("Hello, World!");
//
//		return mapping.findForward("success");
	}
}
