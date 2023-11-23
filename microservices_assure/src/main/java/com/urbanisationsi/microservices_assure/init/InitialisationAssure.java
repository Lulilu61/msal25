package com.urbanisationsi.microservices_assure.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.urbanisationsi.microservices_assure.dao.AssureRepository;
import com.urbanisationsi.microservices_assure.entity.Assure;

@Component
public class InitialisationAssure implements ApplicationRunner{

	@Autowired
	AssureRepository assureRepo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Assure a1 = new Assure();
		a1.setNom("Potter");
		a1.setPrenom("Harry");
		a1.setNumeroPersonne(421);
		a1.setNumeroAssure(12345);

		assureRepo.save(a1);
		
		Assure a2 = new Assure();
		a1.setNom("Granger");
		a1.setPrenom("Hermione");
		a1.setNumeroPersonne(422);
		a1.setNumeroAssure(12346);

		assureRepo.save(a2);
		
		Assure a3 = new Assure();
		a1.setNom("Weasley");
		a1.setPrenom("Ron");
		a1.setNumeroPersonne(423);
		a1.setNumeroAssure(12347);

		assureRepo.save(a3);
		
		Assure a4 = new Assure();
		a1.setNom("Weasley");
		a1.setPrenom("Ginny");
		a1.setNumeroPersonne(424);
		a1.setNumeroAssure(12348);

		assureRepo.save(a4);
		
		Assure a5 = new Assure();
		a1.setNom("Black");
		a1.setPrenom("Sirius");
		a1.setNumeroPersonne(425);
		a1.setNumeroAssure(12349);

		assureRepo.save(a5);
	}

}
