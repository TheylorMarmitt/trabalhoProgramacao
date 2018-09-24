package principal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;

public class MenuController {

    @FXML
    private Menu mniCadastroFilial;

    @FXML
    void abreTelaCadastroFilial(ActionEvent event) {
    	Main.changeScreen(TipoTela.CADASTROFILIAL);
    }

    @FXML
    void abreTelaCadastroVeiculo(ActionEvent event) {
    	Main.changeScreen(TipoTela.CADASTROVEICULO);

    }
}
