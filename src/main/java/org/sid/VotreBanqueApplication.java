package org.sid;

import java.util.Date;

import org.sid.dao.IClientRepository;
import org.sid.dao.ICompteRepository;
import org.sid.dao.IOperationRepository;
import org.sid.entities.Client;
import org.sid.entities.Compte;
import org.sid.entities.CompteCourant;
import org.sid.entities.CompteEpargne;
import org.sid.entities.Operation;
import org.sid.entities.Retrait;
import org.sid.entities.Versement;
import org.sid.metier.IBanqueMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository; 

@SpringBootApplication
public class VotreBanqueApplication  implements CommandLineRunner{   //cette implementation de cette interface permet de tester dans la meme class et obligne de redefinir la methode run de cette interface
    @Autowired
	private IClientRepository iClientRepository;
	
    @Autowired
   	private ICompteRepository iCompteRepository;
    
    @Autowired
   	private IOperationRepository iOperationRepository;
    
    //pour tester la couche metier
    @Autowired
   	private IBanqueMetier iBanqueMetier;
    
    
	public static void main(String[] args) { 
		
		  SpringApplication.run(VotreBanqueApplication.class, args);
	
	//IClientRepository iClientRepository = applicationContext.getBean(IClientRepository.class);
	 
	}

	
	
	@Override  //annotation averride puisqu'elle est de l'interfaceCommandLineRunner et sa redefinition est obligatoire ----->  ceci permet de faire le test dans cette methode
	public void run(String... arg0) throws Exception {
	/*	
		Client client1 = iClientRepository.save(new Client("Hassan","hassan@gmail.com"));  // ici, la methode save de IClientRepository qui extends de JpaRepository<Client,Long>  enregistre  dans la base et en plus retourne le  Client enregistrÃ©
		Client client2 = iClientRepository.save(new Client("nassima","nassima@gmail.com"));
		 
		Compte compte1 = iCompteRepository.save(new CompteCourant("compte1",new Date(),90000.0 ,client1,6000.0));
		Compte compte2 = iCompteRepository.save(new CompteEpargne("compte2",new Date(),6000.0, client2, 5.5));
		 
		//operations de compte1
		  iOperationRepository.save(new Versement( new Date(), 9000.0,compte1));
		  iOperationRepository.save(new Versement( new Date(), 6000.0,compte1));
	      iOperationRepository.save(new Versement( new Date(), 2300.0,compte1));
		
		 iOperationRepository.save(new Retrait( new Date(),9000.0,compte1));
		
		
		//operations de compte2
		  iOperationRepository.save(new Versement( new Date(), 2300.0,compte2));
		  iOperationRepository.save(new Versement( new Date(), 400.0,compte2));
	      iOperationRepository.save(new Versement( new Date(), 2300.0,compte2));
		
		 iOperationRepository.save(new Retrait( new Date(),3000.0,compte2));
	
		 	
		 //Tester la couche Metier
		 iBanqueMetier.versement("compte1", 111111.0);
	//	 iOperationRepository.listOperation("compte1",new  PageRequest(2,2));
	//   System.out.println(	 iOperationRepository.listOperation(   "compte1",  new  PageRequest(2,2)   )      ); 
	*/
	}
}
