/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egg.web.libreria.servicios;

import egg.web.libreria.entidades.Foto;
import egg.web.libreria.errores.ErrorServicio;
import egg.web.libreria.repositorios.FotoRepositorio;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



@Service
public class FotoServicio {     
    
    @Autowired
    private FotoRepositorio fotoRepositorio;
    
    
    public Foto guardar(MultipartFile archivo) throws ErrorServicio{
        if (archivo != null){
            try {
                Foto foto = new Foto();
                foto.setMime(archivo.getContentType());
                foto.setNombre(archivo.getName());
                foto.setContenido(archivo.getBytes());
                
                return fotoRepositorio.save(foto);
                
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return null;
    }
    
    
    public Foto Actualizar(String idfoto, MultipartFile archivo) throws ErrorServicio{
        if (archivo != null){
            try {
                Foto foto = new Foto();
                if (idfoto != null){
                    Optional<Foto>respuesta =fotoRepositorio.findById(idfoto);
                    if (respuesta.isPresent()){
                        foto = respuesta.get();
                    }
                }
                foto.setMime(archivo.getContentType());
                foto.setNombre(archivo.getName());
                foto.setContenido(archivo.getBytes());
                
                return fotoRepositorio.save(foto);
                
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return null;
    }
    
    
}
