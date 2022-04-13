/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egg.web.libreria.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;



/**
 *
 * @author Andes
 */
@Entity
public class Editorial {
    @Id
    @GeneratedValue(generator = "uuid" )
    @GenericGenerator(name= "uuid", strategy = "uuid2")
    private String id;
    private String nombre;
    private Boolean alta;
    @OneToOne
    private Foto foto;

    public Editorial() {
    }

    public Editorial(String nombre, Boolean alta) {
        this.nombre = nombre;
        this.alta = alta;
    }

    
    
    public String getId() {
        return id;
    }

    
    public void setId(String id) {
        this.id = id;
    }

    
    public String getNombre() {
        return nombre;
    }

    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    public Boolean getAlta() {
        return alta;
    }

    
    public void setAlta(Boolean alta) {
        this.alta = alta;
    }
    
     public Foto getFoto() {
        return foto;
    }

   
    public void setFoto(Foto foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Editorial{" + "id=" + getId() + ", nombre=" + getNombre() + ", alta=" + getAlta() + '}';
    }


    
}
