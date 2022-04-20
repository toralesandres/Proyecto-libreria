

package egg.web.libreria.servicios;

import egg.web.libreria.entidades.Autor;
import egg.web.libreria.entidades.Editorial;
import egg.web.libreria.entidades.Foto;
import egg.web.libreria.entidades.Libro;
import egg.web.libreria.errores.ErrorServicio;
import org.springframework.stereotype.Service;
import egg.web.libreria.repositorios.LibroRepositorio;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

@Service
public class LibroServicio {
    @Autowired //inyescta la independencia de la interfas
    private LibroRepositorio libroRepositorio;
    @Autowired
    private FotoServicio fotoServicio;
    
    public void crearLibro( String isbn, String titulo, Integer anio, Integer ejemplares,
                            
                            boolean alta, Autor autor, Editorial editorial, MultipartFile archivo) throws ErrorServicio {
        
        validar(isbn, titulo, anio, ejemplares);
        
        Libro libro = new Libro();
        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setAnio(anio);
        libro.setEjemplares(ejemplares);
        libro.setEjemplaresPrestados(0);
        libro.setEjemplaresRestantes(ejemplares);
        libro.setAlta(alta);
        libro.setAutor(autor);
        libro.setEditorial(editorial);
        Foto foto = fotoServicio.guardar(archivo);
        libro.setFoto(foto);
        libroRepositorio.save(libro);
    }
    
    public void modificarLibro(MultipartFile archivo, String id, String isbn, String titulo, Integer anio, Integer ejemplares,
                            Integer ejemplaresPrestados,  Integer ejemplaresRestantes,
                            boolean alta, Autor autor, Editorial editorial) throws ErrorServicio{
        validar(isbn,titulo, anio,ejemplares);
        
        Optional<Libro> respuesta=libroRepositorio.findById(id);
        
        if(respuesta.isPresent()){
            Libro libro= respuesta.get();
            libro.setIsbn(isbn);
            libro.setTitulo(titulo);
            libro.setAnio(anio);
            libro.setEjemplares(ejemplares);
            libro.setEjemplaresPrestados(ejemplaresPrestados);
            libro.setEjemplaresRestantes(ejemplaresRestantes - ejemplares);
            libro.setAutor(autor);
            libro.setEditorial(editorial);
            String idFoto =null;
            if (libro.getFoto() != null ){
                idFoto = libro.getFoto().getId();
            }
            Foto foto = fotoServicio.Actualizar(idFoto, archivo);
            libro.setFoto(foto);
            libroRepositorio.save(libro);
        }else {
            throw new ErrorServicio("No se encontro el Autor Solicitado");
        }
  
    }
    
    public void desabilitarLibro(String id,boolean alta) throws ErrorServicio{
        Optional<Libro> respuesta=libroRepositorio.findById(id);
        
        if(respuesta.isPresent()){
            Libro libro= respuesta.get();
            libro.setAlta(alta);
            libroRepositorio.save(libro);
        }else {
            throw new ErrorServicio("No se encontro el Libro Solicitado");
        }
    }
    
    
     public void habilitarLibro(String id,boolean alta) throws ErrorServicio{
        Optional<Libro> respuesta=libroRepositorio.findById(id);
        
        if(respuesta.isPresent()){
            Libro libro= respuesta.get();
            libro.setAlta(alta);
            libroRepositorio.save(libro);
        }else {
            throw new ErrorServicio("No se encontro el libro Solicitado");
        }
    }
    
    
    
    public void validar(String isbn,  String titulo, Integer anio, Integer ejemplares) throws ErrorServicio {
         
        if(isbn == null || isbn.isEmpty() ){
            throw new ErrorServicio("El ISBN es invalido y no puede ser nulo ");
        } 
        
        if(titulo == null || titulo.isEmpty()){
            throw new ErrorServicio("El Titulo del Libro no puede ser nulo. ");
        }
        
        if(anio == null || anio <= 4){
            throw new ErrorServicio("El año es invalido y tiene que tener este formato " + " 2005 ");
        }
        
        if(ejemplares == null || ejemplares.toString().trim().isEmpty()){
            throw new ErrorServicio("La cantidad de ejemplares no puede ser nulo ");
        }
        
        
    }

    
}
