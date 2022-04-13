
package egg.web.libreria.repositorios;

import egg.web.libreria.entidades.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor, String> {
    
    @Query("SELECT c fROM Autor c WHERE c.nombre = :nombre")
    public Autor buscarPorTitulo(@Param("nombre") String nombre);
}
