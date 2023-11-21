package com.urbanisationsi.orchestrateur.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.urbanisationsi.orchestrateur.dto.AssureDTO;


@FeignClient(name="msassure", url="localhost:9999/previt")
public interface AssureProxy {

	@GetMapping(path="/chercherNomPrenom/{nom}/{prenom}")
	public @ResponseBody Iterable<AssureDTO> getByNomPrenom(@PathVariable String nom, @PathVariable String prenom);
	
	@GetMapping(path="/listerAssure")
	public @ResponseBody Iterable<AssureDTO> getAllAssures();
	

}
