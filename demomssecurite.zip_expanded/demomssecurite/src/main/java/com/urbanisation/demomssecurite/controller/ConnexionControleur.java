package com.urbanisation.demomssecurite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.urbanisation.demomssecurite.entity.GestionnairePrevoyance;
import com.urbanisation.demomssecurite.services.GestionnairePrevoyanceService;

import javax.validation.Valid;

@Controller
public class ConnexionControleur {

    private final GestionnairePrevoyanceService gestionnairePrevoyanceService;

    @Autowired
    public ConnexionControleur(GestionnairePrevoyanceService gestionnairePrevoyanceService) {
        this.gestionnairePrevoyanceService = gestionnairePrevoyanceService;
    }

    @RequestMapping(value = {"/", "/accueil"}, method = RequestMethod.GET)
    public ModelAndView accueil() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("accueil");
        return modelAndView;
    }

    @RequestMapping(value = "/connecter", method = RequestMethod.GET)
    public ModelAndView connecter() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("connecter");
        return modelAndView;
    }

    @RequestMapping(value = "/enregistrer", method = RequestMethod.GET)
    public ModelAndView enregistrer() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("gestionnairePrevoyance", new GestionnairePrevoyance());
        modelAndView.setViewName("enregistrer");
        return modelAndView;
    }

    @RequestMapping(value = "/enregistrer", method = RequestMethod.POST)
    public ModelAndView creerGestionnairePrevoyance(@Valid GestionnairePrevoyance gestionnairePrevoyance, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();

        GestionnairePrevoyance existant = gestionnairePrevoyanceService.findByMail(gestionnairePrevoyance.getMail());

        if (existant != null) {
            bindingResult.rejectValue("mail", "error.gestionnairePrevoyance", "Ce mail est déjà enregistré");
        }

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("enregistrer");
        } else {
            gestionnairePrevoyanceService.sauveGestionnairePrevoyance(gestionnairePrevoyance);
            modelAndView.setViewName("connecter");
        }

        return modelAndView;
    }

    @RequestMapping(value = "/afficher", method = RequestMethod.GET)
    public ModelAndView afficher(Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView();

        String mail = authentication.getName();

        GestionnairePrevoyance gestionnairePrevoyance = gestionnairePrevoyanceService.findByMail(mail);

        modelAndView.addObject("gestionnairePrevoyance", gestionnairePrevoyance);
        modelAndView.setViewName("afficher");

        return modelAndView;
    }
}
