package principal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import principal.dao.AbstractFactory;
import principal.dao.FilialDAO;
import principal.model.Filial;

public class CadastroFilialController {

	@FXML
	private TextField tfNome;

	@FXML
	private TextField tfCidade;

	@FXML
	private TextField tfUf;

	private Filial filial;

	private FilialDAO filialDao = AbstractFactory.get().filialDao();

	void populaFilial() {
		filial.setNome(tfNome.getText());
		filial.setCidade(tfCidade.getText());
		filial.setUf(tfUf.getText());
	}

	void novaFilial() {
		filial = new Filial();
		tfNome.clear();
		tfUf.clear();
		tfCidade.clear();
	}

	@FXML
	private Button btnCadastrar;

	@FXML
	private Button btnNovo;

	@FXML
	void cadastrar(ActionEvent event) {
		populaFilial();
		AlertaFactory alerta = new AlertaFactory();
		if (alerta.confirmaAceitar()) {
			filialDao.inserir(filial);
		}
	}

	@FXML
	void novo(ActionEvent event) {
		novaFilial();
	}

}
