package com.desarrollo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.desarrollo.services.UsuarioService;

@Controller
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	@RequestMapping("/login")
    public String showLogin(Model model) {
   	 return "login";
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String name, @RequestParam("pass") String pass) {
        boolean isLogin = usuarioService.login(name, pass);
        if(isLogin) {
        	return "index";
        }
        else {
        	return "login";
        }
    }
	
	@RequestMapping("/cambiarpassword")
    public String showCambiarPassword(Model model) {
        return "cambiarpassword";
    }
    @RequestMapping(value="/cambiarpassword", method = RequestMethod.POST)
    public String cambiarPassword(@RequestParam("username") String username, @RequestParam("antiguaPassword") String antiguaPassword, @RequestParam("nuevaPassword") String nuevaPassword, Model model){
        boolean isCambio = usuarioService.cambiarPassword(username, antiguaPassword, nuevaPassword);
    	if(isCambio){
            return "login";
        }
        else{
            model.addAttribute("error", "Actualizacion malograda");
            return "login";
        }
    }
	
}
