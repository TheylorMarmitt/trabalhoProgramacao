package principal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import principal.dao.AbstractFactory;
import principal.dao.FuncionarioDAO;
import principal.model.Funcionario;

public class LoginController {
	


    @FXML
    private TextField tfEmail;

    @FXML
    private Button btnEntrar;

    @FXML
    private PasswordField pfSenha;
    
    private FuncionarioDAO funcionarioDao = AbstractFactory.get().funcionarioDao(); 
    
    @FXML
    void entrar(ActionEvent event) {
//    	Funcionario f = new Funcionario();
//    	AlertaFactory alerta = new AlertaFactory();
//    	if(funcionarioDao.verificaEmail(tfEmail.getText()) != null) {
//    		f = funcionarioDao.verificaEmail(tfEmail.getText());    		
//    	}else {
//    		alerta.mensagemDeAlerta("Email não reconhecido");
//    	}
//    	if(f.getEmail().equals(tfEmail.getText()) && f.getSenha().equals(pfSenha.getText())) {
    		Main.changeScreen(TipoTela.MENU);
//    	}else {
//    		alerta.mensagemDeAlerta("Senha incompatível");
//    	}
    }

}
