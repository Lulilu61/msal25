package com.urbanisationsi.orchestrateur.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.urbanisationsi.orchestrateur.dto.AssureDTO;


@FeignClient(name="msassure"/*, url="localhost:9999/previt"*/)
@RibbonClient(name="msassure")
public interface AssureProxy {

	@GetMapping(path="/previt/chercherNomPrenom/{nom}/{prenom}")
	public @ResponseBody Iterable<AssureDTO> getByNomPrenom(@PathVariable String nom, @PathVariable String prenom);
	
	@GetMapping(path="/previt/listerAssure")
	public @ResponseBody Iterable<AssureDTO> getAllAssures();
	

}
