
package egg.web.libreria.repositorios;

import egg.web.libreria.entidades.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorialRepositorio extends JpaRepository<Editorial, String> {
    
    @Query("SELECT c fROM Editorial c WHERE c.nombre = :nombre")
    public Editorial buscarPorNombre(@Param("nombre") String nombre);
    
}
