package org.sid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_OP",discriminatorType=DiscriminatorType.STRING,length=1) // "V" : si Versement et "R": si retrait
public abstract class Operation implements Serializable {

	//attributs de l'entit�
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numeroOperation;
	private Date dateOperation;
	private double montant;
	
	//attributs d'association
	 
    @ManyToOne
    @JoinColumn(name="CODE_COMPTE")   //"CODE_COMPTE" est la cl� �trang�re vers la table 'COMPTE'
	private Compte compte; // une operation appartient � un compte
	 
	
	
	
	//on ne garde pas dans le constructeur en parametres  les attributs d'association
	public Operation(Date dateOperation, double montant,Compte compte) {
		super();
		this.dateOperation = dateOperation;
		this.montant = montant;
		this.compte=compte;
	}




	public Operation() {
		super();// TODO Auto-generated constructor stub
	}




	public Long getNumeroOperation() {
		return numeroOperation;
	}




	public void setNumeroOperation(Long numeroOperation) {
		this.numeroOperation = numeroOperation;
	}




	public Date getDateOperation() {
		return dateOperation;
	}




	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}




	public double getMontant() {
		return montant;
	}




	public void setMontant(double montant) {
		this.montant = montant;
	}






	public Compte getCompte() {
		return compte;
	}




	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	
	
}
