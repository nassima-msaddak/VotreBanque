package org.sid.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
//puisque cette classe h�rite de la classe 'Compte' et que que la creation d'un compte courant attribut � la colonne "TYPE_CPTE" de la table "Compte" la valeur "CC" --> alors l'annotation sera la suivante : 
@DiscriminatorValue("CC") 
public class CompteCourant extends Compte { //un compte courant est un compte

	private double decouvert;
	
	
	public CompteCourant(String codeCompte, Date dateCreation, double solde,Client client, double decouvert) {
		super(codeCompte, dateCreation, solde,client);
		this.decouvert = decouvert;
	}


	public CompteCourant() {
		super();// TODO Auto-generated constructor stub
	}


	public double getDecouvert() {
		return decouvert;
	}


	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	
	
	
}

