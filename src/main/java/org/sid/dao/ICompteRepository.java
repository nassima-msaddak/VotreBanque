package org.sid.dao;
 
import org.sid.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;




public interface ICompteRepository extends JpaRepository<Compte,String>  {   //interface qui herite d'une interface  -----  le ID de compte est de type String (2 eme parametre)

}
