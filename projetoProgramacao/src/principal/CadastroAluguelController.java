package principal;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class CadastroAluguelController {

    @FXML
    private DatePicker dtAluguel;

    @FXML
    private ComboBox<?> cbTipoAluguel;

    @FXML
    private ComboBox<?> cbCarro;

    @FXML
    private TextField tfKmSaida;

    @FXML
    private ComboBox<?> cbCliente;

    @FXML
    private ComboBox<?> cbFilial;

}
