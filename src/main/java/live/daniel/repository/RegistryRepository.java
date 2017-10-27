package live.daniel.repository;

import live.daniel.entity.Registry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional(propagation = Propagation.MANDATORY)
public interface RegistryRepository extends CrudRepository<Registry, Long> {
    List<Registry> findAll();
}
