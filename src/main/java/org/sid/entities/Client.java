package org.sid.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity; //importer pour la persistance (pour pouvoir utiliser les annotations des entity)
import javax.persistence.FetchType;
import javax.persistence.Table; //pour l'annotation des tables ( @Table )
import javax.persistence.Id; //pour @Id
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

//les annotations JPA sont : @Entity , @Table, @Id, @GeneratedValue , @Inheritance ,@ManyToOne , @ManyToMany , ....


@Entity
@Table(name = "Clients")
public class Client implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //�ad code g�n�rer automatiquement
	@Column (name="CODE_CLI") //cette annotation n'est pas obligatoire (on peut l'�liminer comme pour les autres attributs et utiliser le nom de l'attribut comme non du colonne )
	private Long codeClient; //c'est l'identifiant de la table et qui est g�n�rer automatiquement
	private String nomClient;
	private String adresseClient;
		
	@OneToMany (mappedBy = "client",fetch=FetchType.LAZY)  // "client" est attribut $ d'association $ de la classe Compte (association entre la classe Client et Compte )
	private Collection<Compte>  comptes;


public Long getCodeClient() {
	return codeClient;
}

public void setCodeClient(Long codeClient) {
	this.codeClient = codeClient;
}

public String getNomClient() {
	return nomClient;
}

public void setNomClient(String nomClient) {
	this.nomClient = nomClient;
}

public String getAdresseClient() {
	return adresseClient;
}

public void setAdresseClient(String adresseClient) {
	this.adresseClient = adresseClient;
}

public Collection<Compte> getComptes() {
	return comptes;
}

public void setComptes(Collection<Compte> comptes) {
	this.comptes = comptes;
}


public Client() {
	super();
	// TODO Auto-generated constructor stub
}

public Client(String nomClient, String adresseClient ) {
	super();
	this.nomClient = nomClient;
	this.adresseClient = adresseClient; 
}



 
}
