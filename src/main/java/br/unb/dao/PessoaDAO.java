package br.unb.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import br.unb.dominio.Pessoa;

public class PessoaDAO {

	public void salvar() {
		// Configuração da sessão do Hibernate (SessionFactory)
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		// Iniciando a transação
		Transaction tx = session.beginTransaction();

		// Criando uma nova pessoa
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("João da Silva");
		pessoa.setIdade(30);

		// Salvando a pessoa no banco de dados
		session.save(pessoa);

		// Comitando a transação
		tx.commit();

		// Fechando a sessão
		session.close();

	}

}
