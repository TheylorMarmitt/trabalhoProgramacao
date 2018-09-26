package principal;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import principal.model.TipoAluguel;

public class TipoDialogFabrica {
	
	private Stage stageDono;

	public TipoDialogFabrica(Stage stageDono) {
		this.stageDono = stageDono;
	}

	public TipoAluguel showDialog() {
		TipoAluguel tipo = null;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("TipoAluguelDialog.fxml"));
		try {
			AnchorPane tipoDialog = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("seleciona tipo de aluguel");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(stageDono);
			Scene scene = new Scene(tipoDialog);
			dialogStage.setScene(scene);
			TipoAluguelDialogController controller = loader.getController();
			controller.setStageDialog(dialogStage);
			dialogStage.showAndWait();
			tipo = controller.getTipo();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return tipo;
	}

}
