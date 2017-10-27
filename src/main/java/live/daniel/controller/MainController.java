package live.daniel.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import live.daniel.entity.Registry;
import live.daniel.service.RegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import javax.annotation.PostConstruct;
import java.util.List;

@SuppressWarnings("SpringJavaAutowiringInspection")
public class MainController {

    @Autowired
    private RegistryService registryService;

    @FXML private TableView<Registry> table;
    @FXML private TextField txtLink;
    @FXML private TextField txtIP;
    @FXML private TextField txtDate;
    @FXML private Label countSites;

    @FXML
    protected TableColumn<Registry, String> link;
    @FXML
    protected TableColumn<Registry, String> ip;
    @FXML
    protected TableColumn<Registry, String> date;

    private ObservableList<Registry> data;

    /**
     * Инициализация контроллера от JavaFX.
     * Метод вызывается после того как FXML загрузчик произвел инъекции полей.
     *
     * Также на этом этапе еще отсутствуют бины спринга
     * и для инициализации лучше использовать метод,
     * описанный аннотацией @PostConstruct,
     * который вызовется спрингом, после того, как им будут произведены все инъекции.
     * {@link MainController#init()}
     */
    @FXML
    public void initialize() {
        // Этап инициализации JavaFX
    }

    /**
     * На этом этапе уже произведены все возможные инъекции.
     */
    @PostConstruct
    public void init() {
        List<Registry> registries = registryService.findAll();
        data = FXCollections.observableArrayList(registries);

        link.setCellValueFactory(new PropertyValueFactory<>("link"));
        ip.setCellValueFactory(new PropertyValueFactory<>("ip"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));

        table.setItems(data);
        updateCountSites();
    }

    private void updateCountSites() {
        Long countSitesL = registryService.countSites();
        countSites.setText("Всего сайтов в реестре: " + countSitesL.toString());
    }

    @FXML
    public void addSite() {
        String link = txtLink.getText();
        String ip = txtIP.getText();
        String date = txtDate.getText();

        if (StringUtils.isEmpty(link) || StringUtils.isEmpty(ip) || StringUtils.isEmpty(date)) {
            return;
        }

        Registry registry = new Registry(link, ip, date);
        registryService.save(registry);
        data.add(registry);

        txtLink.setText("");
        txtIP.setText("");
        txtDate.setText("");

        updateCountSites();
    }

    @FXML
    public void delSite() {
        Registry selectedRegistry = table.getSelectionModel().getSelectedItem();
        registryService.remove(selectedRegistry);
        data.remove(selectedRegistry);
        updateCountSites();
    }
}
