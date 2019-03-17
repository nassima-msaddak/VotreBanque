package org.sid.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
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
import javax.persistence.OneToMany; 



@Entity
//Puisque je n'utiliserai pas l'annotation @Table --> la table dans la base de donn�e (l'entity) sera cr�er avec le nom de la classe $qui est Compte$( et c'est la valeur par defaut)
 // @Table(name="compte") : on ne va pas utiliser cette annotation (car on a h�ritage) --> un compte peut etre un compte courant ou un compte epargne
// En plus , on va metre tous les comptes (courants et �pargne) dans la meme table -->  d'o� l'annotation suivante :
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_CPTE",discriminatorType=DiscriminatorType.STRING,length=2) //la comonne nomm�e "Type_CPTE" contient "CC" si le compte est courant && "CE" si le compte est epargne
public abstract class Compte implements Serializable{
//attributs normales
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY): le code est string donc not auto increment
	//@Column(name="CODE_COMPTE")
	private String codeCompte;
	private Date dateCreation;
	private double solde;
//attributs d'association
	@ManyToOne //donc on aura un cl� etrang�re qui est client (jointure)
	@JoinColumn(name ="CODE_CLI")
	private Client client;   //un compte appartient � un client
 
	@OneToMany(mappedBy="compte") //association � travers 
	private Collection<Operation>  operations; //un compte peut subir plusieurs operations

	
	//dans le constructeur en parametre : on ne met pas les attributs d'association
	public Compte(String codeCompte, Date dateCreation, double solde,Client client) {
		super();
		this.codeCompte = codeCompte;
		this.dateCreation = dateCreation;
		this.solde = solde;
		this.client = client;
	}








	public String getCodeCompte() {
		return codeCompte;
	}








	public void setCodeCompte(String codeCompte) {
		this.codeCompte = codeCompte;
	}








	public Date getDateCreation() {
		return dateCreation;
	}








	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}








	public double getSolde() {
		return solde;
	}








	public void setSolde(double solde) {
		this.solde = solde;
	}








	public Client getClient() {
		return client;
	}








	public void setClient(Client client) {
		this.client = client;
	}








 







	public Collection<Operation> getOperations() {
		return operations;
	}








	public void setOperations(Collection<Operation> operations) {
		this.operations = operations;
	}








	public Compte() {
		super();// TODO Auto-generated constructor stub
	}

}
