package org.sid.entities;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("V") //l'enregistrement d'une instance de Versement attribue la valeur "V" � la colonne "TYPE_OP" dans la table "Operation"
public class Versement extends Operation {

	
	public Versement(Date dateOperation, double montant,Compte compte) {
		super(dateOperation, montant,compte);
		// TODO Auto-generated constructor stub
	}

	public Versement() {
		super(); // TODO Auto-generated constructor stub
	}

}
