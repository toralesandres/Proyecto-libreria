
package egg.web.libreria.servicios;

import egg.web.libreria.entidades.Autor;
import egg.web.libreria.entidades.Foto;
import egg.web.libreria.errores.ErrorServicio;
import egg.web.libreria.repositorios.AutorRepositorio;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AutorServicio {
    
    @Autowired
    private AutorRepositorio autorRepositorio;
    @Autowired
    private FotoServicio fotoServicio;
    
    public void crearAutor(MultipartFile archivo, String nombre, boolean alta) throws ErrorServicio {
        
        validar(nombre);
        
        Autor autor = new Autor();
        autor.setNombre(nombre);
        autor.setAlta(alta);
        Foto foto = fotoServicio.guardar(archivo);
        autor.setFoto(foto);
        autorRepositorio.save(autor);
    }
    public void modificarAutor(MultipartFile archivo, String id, String nombre) throws ErrorServicio{
        
        validar(nombre);
        
        Optional<Autor> respuesta=autorRepositorio.findById(id);
        
        if(respuesta.isPresent()){
            Autor autor= respuesta.get();
            autor.setNombre(nombre);
            String idFoto =null;
            if (autor.getFoto() != null ){
                idFoto = autor.getFoto().getId();
            }
            Foto foto = fotoServicio.Actualizar(idFoto, archivo);
            autor.setFoto(foto);
            autorRepositorio.save(autor);
        }else {
            throw new ErrorServicio("No se encontro el Autor Solicitado");
        }
    }
    
    public void desabilitarAutor(String id,boolean alta) throws ErrorServicio{
        Optional<Autor> respuesta=autorRepositorio.findById(id);
        
        if(respuesta.isPresent()){
            Autor autor= respuesta.get();
            autor.setAlta(alta);
            autorRepositorio.save(autor);
        }else {
            throw new ErrorServicio("No se encontro el Autor Solicitado");
        }
    }
    
    
     public void habilitarAutor(String id,boolean alta) throws ErrorServicio{
        Optional<Autor> respuesta=autorRepositorio.findById(id);
        
        if(respuesta.isPresent()){
            Autor autor= respuesta.get();
            autor.setAlta(alta);
            autorRepositorio.save(autor);
        }else {
            throw new ErrorServicio("No se encontro el Autor Solicitado");
        }
    }
    
    public void validar(String nombre) throws ErrorServicio {
         
        if(nombre == null || nombre.isEmpty()){
            throw new ErrorServicio("El nombre del Autor no puede ser nulo. ");
        }
    }
}
