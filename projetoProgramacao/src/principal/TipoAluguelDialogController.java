package principal;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import principal.dao.AbstractFactory;
import principal.dao.TipoAluguelDAO;
import principal.model.TipoAluguel;

public class TipoAluguelDialogController {

    @FXML
    private TableView<TipoAluguel> tblTipoAluguel;

    @FXML
    private TableColumn<TipoAluguel, String> tbcDescricao;

    @FXML
    private TableColumn<TipoAluguel, Double> tbcValor;

    @FXML
    private TableColumn<TipoAluguel, Double> tbcTaxa;
    
	private Stage dialogStage;

	private TipoAluguel tipo;
	
	TipoAluguelDAO tipoDao = AbstractFactory.get().tipoAluguelDao();
	
	public void setStageDialog(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public TipoAluguel getTipo() {
		return this.tipo;
	}
    
	@FXML
	private void initialize() {
		tbcDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
		tbcValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
		tbcTaxa.setCellValueFactory(new PropertyValueFactory<>("taxa"));
		tblTipoAluguel.setItems(FXCollections.observableArrayList(tipoDao.listar()));
	}
	

    @FXML
    void selecionaTipoAluguel(MouseEvent event) {
    	if (tblTipoAluguel.getSelectionModel().getSelectedItem() != null) {
			tipo = tblTipoAluguel.getSelectionModel().getSelectedItem();
		}
		if (event.getClickCount() > 1) {
			dialogStage.close();
		}
    }
}
