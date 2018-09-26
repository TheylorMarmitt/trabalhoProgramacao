package principal;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import principal.model.Funcionario;

public class FuncionarioDialogFabrica {
	
	private Stage stageDono;

	public FuncionarioDialogFabrica(Stage stageDono) {
		this.stageDono = stageDono;
	}

	public Funcionario showDialog() {
		Funcionario funcionario = null;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("FuncionarioDialogController.fxml"));
		try {
			AnchorPane funcionarioDialog = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("seleciona funcionario");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(stageDono);
			Scene scene = new Scene(funcionarioDialog);
			dialogStage.setScene(scene);
			FuncionarioDialogController controller = loader.getController();
			controller.setStageDialog(dialogStage);
			dialogStage.showAndWait();
			funcionario = controller.getFuncionario();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return funcionario;
	}
}
