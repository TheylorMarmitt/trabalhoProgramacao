package principal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import principal.dao.AbstractFactory;
import principal.dao.CarroDAO;
import principal.dao.ClienteDAO;
import principal.dao.FilialDAO;
import principal.dao.FuncionarioDAO;
import principal.dao.TipoAluguelDAO;
import principal.model.Carro;
import principal.model.Cliente;
import principal.model.Filial;
import principal.model.Funcionario;
import principal.model.TipoAluguel;

public class CadastroAluguelController {

    @FXML
    private DatePicker dtAluguel;

    @FXML
    private ComboBox<TipoAluguel> cbTipoAluguel;

    @FXML
    private ComboBox<Carro> cbCarro;

    @FXML
    private TextField tfKmSaida;

    @FXML
    private ComboBox<Cliente> cbCliente;
    
    @FXML
    private ComboBox<Funcionario> cbFuncionario;

    @FXML
    private ComboBox<Filial> cbFilial;
    
    @FXML
    private Button btnBuscarCarro;

    @FXML
    private Button btnBuscarCliente;

    @FXML
    private Button btnBuscarTipoAluguel;

    @FXML
    private Button btnBuscarFilial;

    @FXML
    private Button btnBuscarFuncioanario;
    
    @FXML
    private Button btnRealizarAluguel;

    private TipoAluguelDAO tipoDao = AbstractFactory.get().tipoAluguelDao();
    private CarroDAO carroDao = AbstractFactory.get().carroDao();
    private ClienteDAO clienteDao = AbstractFactory.get().clienteDao();
    private FilialDAO filialDao = AbstractFactory.get().filialDao();
    private FuncionarioDAO funcionarioDao = AbstractFactory.get().funcionarioDao();
    
    @FXML
    void buscarCarro(ActionEvent event) {
    	Stage stageDono = (Stage)btnBuscarCarro.getScene().getWindow();
    	CarroDialogFabrica carroDialog = new CarroDialogFabrica(stageDono);
    	Carro carro = carroDialog.showDialog();
    	if(carro != null) {
    		populaComboCarro();
    		cbCarro.setValue(carro);
    	}
    }
    
    @FXML
    void buscarCliente(ActionEvent event) {
    	Stage stageDono = (Stage)btnBuscarCliente.getScene().getWindow();
    	ClienteDialogFabrica clienteDialog = new ClienteDialogFabrica(stageDono);
    	Cliente cliente = clienteDialog.showDialog();
    	if(cliente != null) {
    		populaComboCliente();
    		cbCliente.setValue(cliente);
    	}
    }

    @FXML
    void buscarFilial(ActionEvent event) {
    	Stage stageDono = (Stage)btnBuscarFilial.getScene().getWindow();
    	FilialDialogFabrica filialDialog = new FilialDialogFabrica(stageDono);
    	Filial filial = filialDialog.showDialog();
    	if(filial != null) {
    		populaComboFilial();
    		cbFilial.setValue(filial);
    	}
    }

    @FXML
    void buscarFuncionario(ActionEvent event) {

    }

    @FXML
    void buscarTipoAluguel(ActionEvent event) {

    }

    @FXML
    void realizarAluguel(ActionEvent event) {

    }
    
    /**
     * metodos de popular comboboxes
     */
    private void populaComboTipoAluguel(){
    	cbTipoAluguel.getSelectionModel().clearSelection();
		for(TipoAluguel tipo: tipoDao.listar()){
			cbTipoAluguel.getItems().add(tipo);
		}
	}
    
    private void populaComboCarro(){
    	cbCarro.getSelectionModel().clearSelection();
		for(Carro car: carroDao.listar()){
			cbCarro.getItems().add(car);
		}
	}
    
    private void populaComboCliente(){
    	cbCliente.getSelectionModel().clearSelection();
		for(Cliente cliente: clienteDao.listar()){
			cbCliente.getItems().add(cliente);
		}
	}
    
    private void populaComboFilial(){
    	cbFilial.getSelectionModel().clearSelection();
		for(Filial filial: filialDao.listar()){
			cbFilial.getItems().add(filial);
		}
	}
    
    private void populaComboFuncionario(){
    	cbFuncionario.getSelectionModel().clearSelection();
		for(Funcionario funcionario: funcionarioDao.listar()){
			cbFuncionario.getItems().add(funcionario);
		}
	}
}
