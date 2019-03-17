package org.sid.metier;

  
import java.util.List;

import org.sid.entities.Compte; 
import org.sid.entities.Operation;
import org.springframework.data.domain.Page;

public interface IBanqueMetier {

	 public Compte getCompte(String codeCompte);
	 public void versement(String codeCompte, double montant );
	 public void retrait(String codeCompte, double montant );
	 public void virement(String codeCompteRetrait,String codeCompteVersement,double montant);
    

	  public Page<Operation> listOperationsCompte(String codeCompte,int page,int sizePage);
	/* 
	 public List<Operation> listOperationsCompte(String codeCompte);
	*/	
}
