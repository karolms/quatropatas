package com.cesar.quatropatas.projeto.ws.controller;

import com.cesar.quatropatas.projeto.ws.controller.model.Usuario;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author João Carlos
 */

@RestController
public class ClientController {
    
    Map<Integer,Usuario> usuarios = new HashMap<>();;
;
    Integer tempId =1;
    
    private Usuario cadastro(Usuario user){
        
        user.setId(tempId);
        tempId++;
        usuarios.put(user.getId(),user);
        return user;
    }
    private Collection<Usuario> busca(){
        return usuarios.values();
    }
    
    
    @RequestMapping(method=RequestMethod.POST,value="/cliente",
            consumes=MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    
    
    public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario user){
        Usuario passedUser = cadastro(user);
        return new ResponseEntity<>(passedUser,HttpStatus.CREATED);
    }
    
    @RequestMapping(method=RequestMethod.GET,value="/clienterequest",
            produces=MediaType.APPLICATION_JSON_VALUE)
    
    public ResponseEntity<Collection<Usuario>> procurar(){
        System.out.println("pass");
        Collection<Usuario> usuariosBuscados = busca();
        return new ResponseEntity<>(usuariosBuscados,HttpStatus.OK);
    }
    
}
