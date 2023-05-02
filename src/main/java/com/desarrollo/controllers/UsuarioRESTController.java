package com.desarrollo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desarrollo.entities.*;
import com.desarrollo.services.UsuarioService;

@RestController
public class UsuarioRESTController {
     @Autowired
     private UsuarioService usuarioService;

     @PostMapping("/loginrest")
     public ResponseEntity<String> login(@RequestBody Login login) {
         boolean isLogin = usuarioService.login(login.getUsername(), login.getPass());
         if(isLogin) {
         	return new ResponseEntity<>("Usuario creado",HttpStatus.OK);
         }
         else {
         	return new ResponseEntity<>("Usuario creado", HttpStatus.NOT_FOUND);
         }
     }
     
     @PostMapping("/cambiarpasswordrest")
     public ResponseEntity<String> changePassword(@RequestBody CambioPassword cambioPassword){
         boolean isCambio = usuarioService.cambiarPassword(cambioPassword.getUsername(), cambioPassword.getOldPass(), cambioPassword.getNewPass());
    	 if(isCambio){
             return new ResponseEntity<String>("Se actualizo con exito", HttpStatus.OK);
         }
         else{
             return new ResponseEntity<String>("Actualizacion malograda", HttpStatus.NOT_FOUND);
         }
     }
}