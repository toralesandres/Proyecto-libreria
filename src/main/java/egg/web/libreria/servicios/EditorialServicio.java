
package egg.web.libreria.servicios;

import egg.web.libreria.entidades.Editorial;
import egg.web.libreria.errores.ErrorServicio;
import egg.web.libreria.repositorios.EditorialRepositorio;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditorialServicio {
   
    @Autowired
    private EditorialRepositorio editorialRepositorio;
    
    public void crearEditorial(String nombre, boolean alta) throws ErrorServicio {
        
        validar(nombre);
        
        Editorial editorial = new Editorial();
        editorial.setNombre(nombre);
        editorial.setAlta(alta);
        editorialRepositorio.save(editorial);
    }
    
    public void modificarEditorial(String id, String nombre) throws ErrorServicio{
        
        validar(nombre);
        
        Optional<Editorial> respuesta=editorialRepositorio.findById(id);
        
        if(respuesta.isPresent()){
            Editorial editorial= respuesta.get();
            editorial.setNombre(nombre);
            editorialRepositorio.save(editorial);
        }else {
            throw new ErrorServicio("No se encontro la Editorial Solicitada");
        }
    }
    
    public void desabilitarEditorial(String id,boolean alta) throws ErrorServicio{
        Optional<Editorial> respuesta=editorialRepositorio.findById(id);
        
        if(respuesta.isPresent()){
            Editorial editorial= respuesta.get();
            editorial.setAlta(alta);
            editorialRepositorio.save(editorial);
        }else {
            throw new ErrorServicio("No se encontro la Editorial Solicitada");
        }
    }
    
    
     public void habilitarEditorial(String id,boolean alta) throws ErrorServicio{
        Optional<Editorial> respuesta=editorialRepositorio.findById(id);
        
        if(respuesta.isPresent()){
            Editorial editorial= respuesta.get();
            editorial.setAlta(alta);
            editorialRepositorio.save(editorial);
        }else {
            throw new ErrorServicio("No se encontro la Editorial Solicitada");
        }
    }
     
    public void validar(String nombre) throws ErrorServicio {
         
        if(nombre == null || nombre.isEmpty()){
            throw new ErrorServicio("El nombre de la editorial no puede ser nulo. ");
        }
    }

}