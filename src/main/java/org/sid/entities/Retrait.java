package org.sid.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("R") //l'enregistrement d'une instance de Retrait attribue la valeur "R" � la colonne "TYPE_OP" dans la table "Operation"
public class Retrait extends Operation {

	
	public Retrait() {
		super();// TODO Auto-generated constructor stub
	}

	public Retrait(Date dateOperation, double montant,Compte compte) {
		super(dateOperation, montant,compte);
		// TODO Auto-generated constructor stub
	}

	
	
}
