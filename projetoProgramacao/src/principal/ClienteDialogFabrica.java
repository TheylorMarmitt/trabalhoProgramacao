package principal;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import principal.model.Cliente;

public class ClienteDialogFabrica {

	private Stage stageDono;
	
	public ClienteDialogFabrica(Stage stageDono) {
		this.stageDono = stageDono;
	}

	public Cliente showDialog() {
		Cliente cliente = null;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("ClienteDialogController.fxml"));
		try {
			AnchorPane clienteDialog = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("seleciona cliente");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(stageDono);
			Scene scene = new Scene(clienteDialog);
			dialogStage.setScene(scene);
			ClienteDialogController controller = loader.getController();
			controller.setStageDialog(dialogStage);
			dialogStage.showAndWait();
			cliente = controller.getCliente();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return cliente;

	}

}
