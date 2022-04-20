/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egg.web.libreria.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;


/**
 *
 * @author Andes
 */
@Entity
public class Libro {
    @Id
    @GeneratedValue(generator = "uuid" )
    @GenericGenerator(name= "uuid", strategy = "uuid2")
    private String id;
    private String isbn;
    private String titulo;
    private Integer anio;
    private Integer ejemplares;
    private Integer ejemplaresPrestados;
    private Integer ejemplaresRestantes;
    private Boolean alta;
    @ManyToOne
    private Autor autor;
    @ManyToOne
    private Editorial editorial;
    @OneToOne
    private Foto foto;

    public Libro() {
    }

    
    public String getId() {
        return id;
    }

    
    public void setId(String id) {
        this.id = id;
    }

    
    public String getIsbn() {
        return isbn;
    }

    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    
    public String getTitulo() {
        return titulo;
    }

    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    
    public Integer getAnio() {
        return anio;
    }

    
    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    
    public Integer getEjemplares() {
        return ejemplares;
    }

    
    public void setEjemplares(Integer ejemplares) {
        this.ejemplares = ejemplares;
    }

    
    public Integer getEjemplaresPrestados() {
        return ejemplaresPrestados;
    }

    
    public void setEjemplaresPrestados(Integer ejemplaresPrestados) {
        this.ejemplaresPrestados = ejemplaresPrestados;
    }

    
    public Integer getEjemplaresRestantes() {
        return ejemplaresRestantes;
    }

   
    public void setEjemplaresRestantes(Integer ejemplaresRestantes) {
        this.ejemplaresRestantes = ejemplaresRestantes;
    }

    
    public Boolean getAlta() {
        return alta;
    }

    
    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

    
    public Autor getAutor() {
        return autor;
    }

    
    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    
    public Editorial getEditorial() {
        return editorial;
    }

    
    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }
    
    public Foto getFoto() {
        return foto;
    }

    
    
    public void setFoto(Foto foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Libro{" + "id=" + getId() + ", isbn=" + getIsbn() + ", titulo=" + getTitulo() + ", anio=" + getAnio() + ", ejemplares=" + getEjemplares() + ", ejemplaresPrestados=" + getEjemplaresPrestados() + ", ejemplaresRestantes=" + getEjemplaresRestantes() + ", alta=" + getAlta() + ", autor=" + getAutor() + ", editorial=" + getEditorial() + '}';
    }

   
    
    
    
    
    
}
