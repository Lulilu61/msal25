package com.urbanisationsi.microservices_contrat_mongoDB_correction.entity;

import java.util.Date;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of= {"id", "numeroContrat"})
@ToString(of= {"id", "numeroContrat", "dateDebut", "numeroAssure", "numeroProduit"})
@Document(collection="gestionprevdb")
public class Contrat {
	
	@Id
	private String id;
	@Indexed(unique = true, direction = IndexDirection.DESCENDING)
	private Long numeroContrat;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateDebut;
	private Long numeroAssure;
	private Long numeroProduit;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	public Long getNumeroContrat() {
		return numeroContrat;
	}
	public void setNumeroContrat(Long numeroContrat) {
		this.numeroContrat = numeroContrat;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Long getNumeroAssure() {
		return numeroAssure;
	}
	public void setNumeroAssure(Long numeroAssure) {
		this.numeroAssure = numeroAssure;
	}
	public Long getNumeroProduit() {
		return numeroProduit;
	}
	public void setNumeroProduit(Long numeroProduit) {
		this.numeroProduit = numeroProduit;
	}

}

