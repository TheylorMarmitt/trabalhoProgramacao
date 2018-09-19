package principal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import principal.dao.AbstractFactory;
import principal.dao.FuncionarioDAO;
import principal.model.Funcionario;

public class LoginController {
	

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfSenha;

    @FXML
    private Button btnEntrar;
    
    private FuncionarioDAO funcionarioDao = AbstractFactory.get().funcionarioDao(); 
    
    @FXML
    void entrar(ActionEvent event) {
    	Funcionario f = new Funcionario();
    	if(funcionarioDao.verificaEmail(tfEmail.getText()) != null) {
    		f = funcionarioDao.verificaEmail(tfEmail.getText());    		
    	}else {
    		// retorna alert com erro de email
    	}
    	if(f.getEmail().equals(tfEmail.getText()) && f.getSenha().equals(tfSenha.getText())) {
    		Main.changeScreen(TipoTela.MENU);
    	}else {
    		// retorna alert com erro de senha
    	}
    }

}
