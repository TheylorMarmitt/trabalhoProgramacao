package principal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class CadastroVeiculoController {

	 @FXML
	    private ComboBox<?> cbFilial;

	    @FXML
	    private TextField tfMarca;

	    @FXML
	    private TextField tfModelo;

	    @FXML
	    private TextField tfValor;

	    @FXML
	    private TextField tfCor;

	    @FXML
	    private DatePicker dtAno;

	    @FXML
	    private TextField tfPlaca;

	    @FXML
	    private CheckBox chekDisponivel;

	    @FXML
	    private Button btnCadastrar;

	    @FXML
	    private Button btnNovo;

	    @FXML
	    void cadastrar(ActionEvent event) {

	    }

	    @FXML
	    void novo(ActionEvent event) {

	    }

}
