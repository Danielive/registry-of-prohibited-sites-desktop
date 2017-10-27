package live.daniel.service;

import live.daniel.entity.Registry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import live.daniel.repository.RegistryRepository;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RegistryService {

    private final RegistryRepository repository;

    @Autowired
    public RegistryService(RegistryRepository repository) {
        this.repository = repository;
    }

    public Registry save(Registry registry) {
        return repository.save(registry);
    }

    public List<Registry> findAll() {
        return repository.findAll();
    }

    public void remove(Registry selectedRegistry) {
        repository.delete(selectedRegistry.getId());
    }

    public long countSites() {
        return repository.count();
    }
}
