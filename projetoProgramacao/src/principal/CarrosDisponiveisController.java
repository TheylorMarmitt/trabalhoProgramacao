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
import principal.dao.CarroDAO;
import principal.model.Carro;

public class CarrosDisponiveisController {

	@FXML
    private TableView<Carro> tblCarros;

    @FXML
    private TableColumn<Carro, String> tbcPlaca;

    @FXML
    private TableColumn<Carro, String> tbcMarca;

    @FXML
    private TableColumn<Carro, String> tbcModelo;

    @FXML
    private TableColumn<Carro, Boolean> tbcDisponibilidade;

    @FXML
    private TableColumn<Carro, Number> tbcValor;

    @FXML
    private TableColumn<Carro, String> tbcCor;

    @FXML
    private Button tbnBuscar;

    @FXML
    private TextField tfPlaca;
    
    private ObservableList<Carro> carros = FXCollections.observableArrayList();
    
    private Stage dialogStage;
    
    private Carro carro;
    
    @FXML
	private void initialize() {
		tbcPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
		tbcMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
		tbcModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
		tbcDisponibilidade.setCellValueFactory(new PropertyValueFactory<>("disponivel"));
		tbcValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
		tbcCor.setCellValueFactory(new PropertyValueFactory<>("cor"));
		tblCarros.setItems(atualizaTabela());
	}

    @FXML
    void buscar(ActionEvent event) {
    	tblCarros.setItems(buscarCarro());
    }
    
    
    public ObservableList<Carro> atualizaTabela(){
    	CarroDAO carroDao = AbstractFactory.get().carroDao();
		carros = FXCollections.observableArrayList(carroDao.carrosDisponiveis());
		return carros;
	}
    
    private ObservableList<Carro> buscarCarro() {
		ObservableList<Carro> carroPesquisa = FXCollections.observableArrayList();
		for(int x = 0; x < carros.size(); x++) {
			if(carros.get(x).getPlaca().toLowerCase().contains(tfPlaca.getText().toLowerCase())) {
				carroPesquisa.add(carros.get(x));
			}
		}
		return carroPesquisa;
	}
    
    @FXML
    void selecionaCarro(MouseEvent event) {
    	if (tblCarros.getSelectionModel().getSelectedItem() != null) {
			carro = tblCarros.getSelectionModel().getSelectedItem();
		}
		if(event.getClickCount() > 1) {
			dialogStage.close();
		}
    }
    
    public void setStageDialog(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
    
	public Carro getCarro() {
		return this.carro;
	}
    
}
