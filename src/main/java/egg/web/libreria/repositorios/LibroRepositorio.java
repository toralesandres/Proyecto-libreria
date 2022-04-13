
package egg.web.libreria.repositorios;

import egg.web.libreria.entidades.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro, String>{
    @Query("SELECT c fROM Libro c WHERE c.titulo = :titulo")
    public Libro buscarPorTitulo(@Param("titulo") String titulo);
}
