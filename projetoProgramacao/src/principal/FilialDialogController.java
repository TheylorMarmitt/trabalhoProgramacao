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
import principal.dao.FilialDAO;
import principal.model.Filial;

public class FilialDialogController {

	@FXML
	private TableView<Filial> tblFilial;

	@FXML
	private TableColumn<Filial, String> tbcUf;

	@FXML
	private TableColumn<Filial, String> tbcCidade;

	@FXML
	private TableColumn<Filial, String> tbcNome;

	@FXML
	private TextField tfUf;

	@FXML
	private Button btnBuscar;

	private ObservableList<Filial> filiais = FXCollections.observableArrayList();

	private Stage dialogStage;

	private Filial filial;

	@FXML
	private void initialize() {
		tbcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tbcCidade.setCellValueFactory(new PropertyValueFactory<>("cidade"));
		tbcUf.setCellValueFactory(new PropertyValueFactory<>("Uf"));
		tblFilial.setItems(atualizaTabela());
	}

	@FXML
	void buscar(ActionEvent event) {
		tblFilial.setItems(buscarFilial());
	}

	public ObservableList<Filial> atualizaTabela() {
		FilialDAO filialDao = AbstractFactory.get().filialDao();
		filiais = FXCollections.observableArrayList(filialDao.listar());
		return filiais;
	}

	private ObservableList<Filial> buscarFilial() {
		ObservableList<Filial> filialPesquisa = FXCollections.observableArrayList();
		for (int x = 0; x < filiais.size(); x++) {
			if (filiais.get(x).getUf().toLowerCase().contains(tfUf.getText().toLowerCase())) {
				filialPesquisa.add(filiais.get(x));
			}
		}
		return filialPesquisa;
	}

	@FXML
	void selecionaFilial(MouseEvent event) {
		if (tblFilial.getSelectionModel().getSelectedItem() != null) {
			filial = tblFilial.getSelectionModel().getSelectedItem();
		}
		if (event.getClickCount() > 1) {
			dialogStage.close();
		}
	}

	public void setStageDialog(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public Filial getFilial() {
		return this.filial;
	}
}
