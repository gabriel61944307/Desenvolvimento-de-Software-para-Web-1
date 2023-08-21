package br.ufscar.dc.dsw;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.ufscar.dc.dsw.dao.IEstadoDAO;
import br.ufscar.dc.dsw.dao.IPessoaDAO;
import br.ufscar.dc.dsw.domain.Estado;
import br.ufscar.dc.dsw.domain.Pessoa;

@SpringBootApplication
public class LivrariaMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivrariaMvcApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(IEstadoDAO estadoDAO, IPessoaDAO pessoaDAO) {
		return (args) -> {
			
			Estado e1 = new Estado();
			e1.setNome("São Paulo");
			e1.setSigla("SP");
			e1.setTamanho("248,209");
			e1.setPopulacao("1200000");
			e1.setQtdCidades("10");
			estadoDAO.save(e1);

			Estado e2 = new Estado();
			e2.setNome("Tocantins");
			e2.setSigla("TO");
			e2.setTamanho("277,621");
			e2.setPopulacao("123456");
			e2.setQtdCidades("100");
			estadoDAO.save(e2);
			
			Estado e3 = new Estado();
			e3.setNome("Goias");
			e3.setSigla("GO");
			e3.setTamanho("340,086");
			e3.setPopulacao("9654321");
			e3.setQtdCidades("456");
			estadoDAO.save(e3);
			
			Pessoa p1 = new Pessoa();
			p1.setNome("Gabriel");
			p1.setIdade("23");
			p1.setEstado(e1);
			p1.setCidade("Salto");
			p1.setBairro("Marilia");
			pessoaDAO.save(p1);
			
			Pessoa p2 = new Pessoa();
			p2.setNome("Rafaela");
			p2.setIdade("22");
			p2.setEstado(e2);
			p2.setCidade("Palmas");
			p2.setBairro("Crisandalias");
			pessoaDAO.save(p2);
			
			Pessoa p3 = new Pessoa();
			p3.setNome("Lucas");
			p3.setIdade("21");
			p3.setCidade("Rio Branco");
			p3.setBairro("Manchuria");
			p3.setEstado(e3);
			pessoaDAO.save(p3);
		};
	}
}
