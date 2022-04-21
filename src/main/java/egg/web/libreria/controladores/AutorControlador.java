/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egg.web.libreria.controladores;

import egg.web.libreria.errores.ErrorServicio;
import egg.web.libreria.servicios.AutorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/") 
public class AutorControlador {
    
    @Autowired
    private AutorServicio autorServicio;
    
    
    
    @GetMapping("/autorRegistrar")
    public String autorRegistrar(){  
    return "autorRegistrar.html";
    }
    
    
    @PostMapping("/registrarAutor")
    public String autorRegistrar(@RequestParam String nombre, @RequestParam Boolean alta) throws ErrorServicio{  
        System.out.println("nombre" + nombre + "alta"+ alta );
        try {
            autorServicio.crearAutor(null, nombre, true);
            return "autorRegistrar.html";
        } catch (Exception e) {
            return "autorRegistrar.html";
        }
        
    }
    
    
    
    @GetMapping("/autorModificar")
    public String autorModificar(){  
    return "autorModificar.html";
    }
}
