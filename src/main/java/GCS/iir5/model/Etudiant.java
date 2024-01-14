package GCS.iir5.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Etudiant {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private String nom;
	 private String prenom;
	 private String filiere;
	 private int groupe;
	 private String tele;
	 private String mail;
	 

}
