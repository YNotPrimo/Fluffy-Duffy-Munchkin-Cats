package primo.fdmc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import primo.fdmc.domains.entities.Cat;

import java.util.Set;

@Repository
public interface CatRepository extends JpaRepository<Cat, Integer> {
}
