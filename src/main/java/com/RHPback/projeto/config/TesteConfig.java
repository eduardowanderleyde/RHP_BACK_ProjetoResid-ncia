package com.RHPback.projeto.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.RHPback.projeto.entities.Funcionario;
import com.RHPback.projeto.entities.Reuniao;
import com.RHPback.projeto.repository.FuncionarioRepository;
import com.RHPback.projeto.repository.ReuniaoRepository;



@Configuration 
@Profile("test") 

public class TesteConfig implements CommandLineRunner {
	
    @Autowired
	private FuncionarioRepository userRepository; 
    @Autowired
    private ReuniaoRepository ReuniaoRepository;
    
    
	@Override
	public void run(String... args) throws Exception { // tudo que colocar dentro desse método, vai ser executado quando a aplicação for inicializada.
	    
		
		

		/////////////////////// Funcionario ////////////////////////////////////
		//////////////////////////////////////////////////////////////////
		//public Funcionario(UUID id,String nome, String email, String senha)
		
		Funcionario p1 = new Funcionario(null,  "Ana Maria da Silva","ana@gmail.com","sds" );
		Funcionario p2 = new Funcionario(null,  "Fabio De Arruda","fabio@gmail.com","1234" );
		Funcionario p3 = new Funcionario(null,  "Almir Santos Figueredo","almir@gmail.com","unicap123" );
		Funcionario p4 = new Funcionario(null,  "Elson Barcelos","elson@gmail.com","elisabb" );
		Funcionario p5 = new Funcionario(null,  "Claudia Beatriz","claudia@gmail.com","100%" );
		
		
		
		

		/////////////////// REUNIAO ///////////////////////////////
		//////////////////////////////////////////////////////////
		/// public Reuniao(UUID idReuniao, Instant moment, Object sala, Funcionario criador)
		
		
		Reuniao r1=new Reuniao(null, Instant.parse("2022-07-20T19:53:07Z"),"SDS2",p1.getNome());
		Reuniao r2=new Reuniao(null, Instant.parse("2022-06-20T21:53:07Z"),"SDS2",p1.getNome());
		Reuniao r3=new Reuniao(null, Instant.parse("2022-05-20T10:53:07Z"),"SDS2",p2.getNome());
		
		ReuniaoRepository.saveAll(Arrays.asList(r1,r2,r3));
		userRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		
		
		///////////////// ASSOCIAÇÕES ////////////////////////////
		/////////////////////////////////////////////////////////
		
		
		r1.getConvidados().add(p1);
		r1.getConvidados().add(p2);
		r1.getConvidados().add(p3);
		
		r2.getConvidados().add(p3);
		r2.getConvidados().add(p4);
		r2.getConvidados().add(p5);
		r1.getConvidados().add(p1);
		
		r3.getConvidados().add(p1);
		r3.getConvidados().add(p2);
		r3.getConvidados().add(p5);
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		
		p1.getReuniao().add(r3);
		
		p2.getReuniao().add(r1);
		p2.getReuniao().add(r2);
		p2.getReuniao().add(r3);
		
	    p3.getReuniao().add(r3);
		
		p4.getReuniao().add(r2);
		p4.getReuniao().add(r1);
		
		p5.getReuniao().add(r3);
		p5.getReuniao().add(r2);*/
		
		//userRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		ReuniaoRepository.saveAll(Arrays.asList(r1,r2,r3));
		
		//r1.setCriador(p1);
		//r2.setCriador(p2);
		//r3.setCriador(p3);
		
		//ReuniaoRepository.save(r1);
		//ReuniaoRepository.save(r2);
		//ReuniaoRepository.save(r3);
	}
}

