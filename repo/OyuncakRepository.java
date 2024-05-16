package tr.edu.medipol.ilerijava.H5220022.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.edu.medipol.ilerijava.H5220022.entity.Oyuncak;

@Repository

public interface OyuncakRepository extends JpaRepository<Oyuncak, Long>{


}
