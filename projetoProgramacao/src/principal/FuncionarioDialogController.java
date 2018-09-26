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
import principal.dao.FuncionarioDAO;
import principal.model.Funcionario;

public class FuncionarioDialogController {

	@FXML
	private TextField tfBuscar;

	@FXML
	private Button btnBuscar;

	@FXML
	private TableView<Funcionario> tblFuncionarios;

	@FXML
	private TableColumn<Funcionario, String> tbcNome;

	@FXML
	private TableColumn<Funcionario, String> tbcSobrenome;

	@FXML
	private TableColumn<Funcionario, String> tbcCpf;

	private ObservableList<Funcionario> funcionarios = FXCollections.observableArrayList();

	private Stage dialogStage;

	private Funcionario funcionario;

	@FXML
	private void initialize() {
		tbcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tbcSobrenome.setCellValueFactory(new PropertyValueFactory<>("sobrenome"));
		tbcCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		tblFuncionarios.setItems(atualizaTabela());
	}

	@FXML
	void buscarFuncionario(ActionEvent event) {
		tblFuncionarios.setItems(buscar());
	}

	@FXML
	void selecionaFuncionario(MouseEvent event) {
		if (tblFuncionarios.getSelectionModel().getSelectedItem() != null) {
			funcionario = tblFuncionarios.getSelectionModel().getSelectedItem();
		}
		if (event.getClickCount() > 1) {
			dialogStage.close();
		}
	}

	public ObservableList<Funcionario> atualizaTabela() {
		FuncionarioDAO funcionarioDao = AbstractFactory.get().funcionarioDao();
		funcionarios = FXCollections.observableArrayList(funcionarioDao.listar());
		return funcionarios;
	}

	private ObservableList<Funcionario> buscar() {
		ObservableList<Funcionario> funcionarioPesquisa = FXCollections.observableArrayList();
		for (int x = 0; x < funcionarios.size(); x++) {
			if (funcionarios.get(x).getCpf().toLowerCase().contains(tfBuscar.getText().toLowerCase())) {
				funcionarioPesquisa.add(funcionarios.get(x));
			}
		}
		return funcionarioPesquisa;
	}

	public void setStageDialog(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public Funcionario getFuncionario() {
		return this.funcionario;
	}
}
