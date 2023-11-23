package com.urbanisation.demomssecurite.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
@Document(collection = "gestionprevdb")
public class GestionnairePrevoyance {

    @Id
    private String id;

    @Indexed(unique = true)
    @NotBlank
    private String mail;

    @NotBlank
    private String motdepasse;

    @NotBlank
    private String nomcomplet;

    private boolean active;

    @DBRef
    private Set<Role> roles;

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	 public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }

	    public String getMail() {
	        return mail;
	    }

	    public void setMail(String mail) {
	        this.mail = mail;
	    }

	    public String getMotdepasse() {
	        return motdepasse;
	    }

	    public void setMotdepasse(String motdepasse) {
	        this.motdepasse = motdepasse;
	    }

	    public String getNomcomplet() {
	        return nomcomplet;
	    }

	    public void setNomcomplet(String nomcomplet) {
	        this.nomcomplet = nomcomplet;
	    }

	    public Set<Role> getRoles() {
	        return roles;
	    }

	    public void setRoles(Set<Role> roles) {
	        this.roles = roles;
	    }
}

