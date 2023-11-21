package com.urbanisationsi.orchestrateur.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.urbanisationsi.orchestrateur.dto.AssureDTO;
import com.urbanisationsi.orchestrateur.proxy.AssureProxy;

@Controller
public class orchAssureController {
	
	@Autowired
	AssureProxy assureProxy;

	@GetMapping("/")
	public String accueil(Model model) {
		List<AssureDTO> assures = (List<AssureDTO>) assureProxy.getAllAssures();
		model.addAttribute("listeAssures", assures);
		
		AssureDTO assureRech = new AssureDTO();
		model.addAttribute("assureRecherche", assureRech);
		return "index";
	}
	
	@PostMapping(value="/saisir-assure")
	public String rechercherAssure(AssureDTO assure, Model model) {
		List<AssureDTO> lesAssures = (List<AssureDTO>) assureProxy.getByNomPrenom(assure.getNom(), assure.getPrenom());
		model.addAttribute("assuresRech", lesAssures);
		return "assures";
	}
}
