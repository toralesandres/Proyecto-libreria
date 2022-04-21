/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egg.web.libreria.controladores;

import egg.web.libreria.entidades.Autor;
import egg.web.libreria.entidades.Editorial;
import egg.web.libreria.entidades.Foto;
import egg.web.libreria.errores.ErrorServicio;
import egg.web.libreria.servicios.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Andes
 */
@Controller
@RequestMapping("/")  
public class LibroControlador {
   
    @Autowired
    private LibroServicio libroServicio;
    
    
    
     @GetMapping("/libroRegistrar")
    public String libroRegistrar(){  
    return "libroRegistrar.html";
    }
    
     @PostMapping("/registrarLibro")
    public String registrarLibro( @RequestParam String isbn, @RequestParam String titulo, @RequestParam Integer anio, @RequestParam Integer ejemplares, @RequestParam Boolean alta /* Autor autor,  Editorial editorial */  ) throws ErrorServicio{  
         System.out.println(isbn + titulo + anio + ejemplares + alta );
         try {
             libroServicio.crearLibro( isbn, titulo, anio, ejemplares, true, null, null, null);
             return "libroRegistrar.html";
         } catch (ErrorServicio e) {
             return "libroRegistrar.html";
         }
        
        
        
    
    }
    
    
     @GetMapping("/libroModificar")
    public String libroModificar(){  
    return "libroModificar.html";
    }
    
}
