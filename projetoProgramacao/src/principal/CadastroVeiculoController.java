package principal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import principal.dao.AbstractFactory;
import principal.dao.CarroDAO;
import principal.model.Carro;
import principal.model.Filial;

public class CadastroVeiculoController {

	 @FXML
	    private ComboBox<Filial> cbFilial;

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
	    private CheckBox cbDisponivel;

	    @FXML
	    private Button btnCadastrar;

	    @FXML
	    private Button btnNovo;
	    
	    
	    private Carro carro;
	    private CarroDAO carroDao = AbstractFactory.get().carroDao();
	    
	    @FXML
	    void cadastrar(ActionEvent event) {
	    	populaCarro();
	    	carroDao.inserir(carro);
	    	novoCarro();
	    }

	    @FXML
	    void novo(ActionEvent event) {
	    	novoCarro();
	    }
	    
	    /**
	    *popula carro com as entradas do usuario
	    */
	    public void populaCarro() {
	    	carro = new Carro();
			carro.setAno(dtAno.getValue());
			carro.setCor(tfCor.getText());
			carro.setDisponivel(cbDisponivel.isArmed());
			carro.setMarca(tfMarca.getText());
			carro.setModelo(tfModelo.getText());
			carro.setPlaca(tfPlaca.getText());
			carro.setValor(Double.valueOf(tfValor.getText()));
		}
	    public void novoCarro() {
	    	tfCor.clear();
	    	tfMarca.clear();
	    	tfModelo.clear();
	    	tfPlaca.clear();
	    	tfValor.clear();
	    	if(cbDisponivel.isSelected()) {
	    		cbDisponivel.setSelected(false);;
	    	}
	    }

}
