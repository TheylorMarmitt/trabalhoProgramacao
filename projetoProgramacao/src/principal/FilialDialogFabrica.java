package principal;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import principal.model.Filial;

public class FilialDialogFabrica {

	private Stage stageDono;

	public FilialDialogFabrica(Stage stageDono) {
		this.stageDono = stageDono;
	}

	public Filial showDialog() {
		Filial filial = null;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("FilialDialog.fxml"));
		try {
			AnchorPane filialDialog = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("seleciona filial");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(stageDono);
			Scene scene = new Scene(filialDialog);
			dialogStage.setScene(scene);
			FilialDialogController controller = loader.getController();
			controller.setStageDialog(dialogStage);
			dialogStage.showAndWait();
			filial = controller.getFilial();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return filial;

	}

}
