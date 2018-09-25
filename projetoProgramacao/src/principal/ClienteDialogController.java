package principal;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import principal.dao.AbstractFactory;
import principal.dao.ClienteDAO;
import principal.model.Cliente;

public class ClienteDialogController {

    @FXML
    private TextField tfBuscar;

    @FXML
    private Button btnBuscar;

    @FXML
    private TableView<Cliente> tblClientes;

    @FXML
    private TableColumn<Cliente, String> tbcNome;

    @FXML
    private TableColumn<Cliente, String> tbcSobrenome;

    @FXML
    private TableColumn<Cliente, String> tbcCpf;
    
    private ObservableList<Cliente> clientes = FXCollections.observableArrayList();
    
    private Stage dialogStage;
    
    private Cliente cliente;
    
    @FXML
   	private void initialize() {
    	tbcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	tbcSobrenome.setCellValueFactory(new PropertyValueFactory<>("sobrenome"));
    	tbcCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
    	tblClientes.setItems(atualizaTabela());
   	}

    @FXML
    void buscarCliente(ActionEvent event) {
    	tblClientes.setItems(buscar());
    }
    
    public ObservableList<Cliente> atualizaTabela(){
    	ClienteDAO clienteDao = AbstractFactory.get().clienteDao();
    	clientes = FXCollections.observableArrayList(clienteDao.listar());
		return clientes;
	}
    
    private ObservableList<Cliente> buscar() {
		ObservableList<Cliente> clientePesquisa = FXCollections.observableArrayList();
		for(int x = 0; x < clientes.size(); x++) {
			if(clientes.get(x).getCpf().toLowerCase().contains(tfBuscar.getText().toLowerCase())) {
				clientePesquisa.add(clientes.get(x));
			}
		}
		return clientePesquisa;
	}

    @FXML
    void selecionaCliente(MouseEvent event) {
    	if (tblClientes.getSelectionModel().getSelectedItem() != null) {
			cliente = tblClientes.getSelectionModel().getSelectedItem();
		}
		if(event.getClickCount() > 1) {
			dialogStage.close();
		}
    }
    
    public void setStageDialog(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
    
	public Cliente getCliente() {
		return this.cliente;
	}

}
