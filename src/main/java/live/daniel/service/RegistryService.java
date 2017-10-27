package live.daniel.service;

import javafx.scene.control.Label;
import live.daniel.entity.Registry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import live.daniel.repository.RegistryRepository;

import javax.annotation.PostConstruct;
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

//    /**
//     * Метод добавляет парочку записей в БД после запуска приложения,
//     * чтобы не было совсем пусто.
//     *
//     * Из-за того, что подключена H2 (in-memory) БД.
//     */
//    @PostConstruct
//    public void generateTestData() {
//        save(new Registry("warungharta.com", "103.11.40.1", "29.09.2017"));
//        save(new Registry("unibet.com.au", "103.227.169.1", "29.09.2017"));
//        save(new Registry("slotvalue2016.ru", "185.43.222.89", "14.09.2017"));
//        save(new Registry("sitemarathon.win", "88.150.168.144", "14.09.2017"));
//        save(new Registry("leonbetsd.com", "109.203.114.161", "07.09.2017"));
//        save(new Registry("prava-today.com", "184.168.221.10", "07.09.2017"));
//        save(new Registry("bobfilm.net", "104.27.132.44", "28.08.2017"));
//        save(new Registry("betcity.mk", "188.227.168.147", "07.09.2017"));
//    }

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
