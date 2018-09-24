package principal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	private static Stage stage;

	/**
	 * Scenes criados como estaticos e privados para carregados no start
	 */
	private static Scene loginScene;
	private static Scene menuScene;
	private static Scene cadastroVeiculoScene;
	private static Scene cadastroFilialScene;

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;

		primaryStage.setTitle("ExemploLogin");

		/**
		 * carrega a tela de login puxando o fxml
		 */
		AnchorPane fxmlLogin = (AnchorPane) FXMLLoader.load(getClass().getResource("Login.fxml"));
		loginScene = new Scene(fxmlLogin, 800, 600);
		loginScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		/**
		 * carrega a tela de menu puxando o fxml acessada apos login
		 */
		AnchorPane fxmlMenu = (AnchorPane) FXMLLoader.load(getClass().getResource("Menu.fxml"));
		menuScene = new Scene(fxmlMenu, 800, 600);
		menuScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		/**
		 * carrega a tela de cadastro de veiculo puxando o fxml acessada apos login
		 */

		AnchorPane fxmlCadastroVeiculo = (AnchorPane) FXMLLoader.load(getClass().getResource("CadastroVeiculo.fxml"));
		cadastroVeiculoScene = new Scene(fxmlCadastroVeiculo, 800, 600);
		cadastroVeiculoScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		AnchorPane fxmlCadastroFilial = (AnchorPane) FXMLLoader.load(getClass().getResource("CadastroFilial.fxml"));
		cadastroFilialScene = new Scene(fxmlCadastroFilial, 800, 600);
		cadastroFilialScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());


		primaryStage.setScene(loginScene);
		primaryStage.show();
	}

	/**
	 * metodo que muda a screen recebendo um tipo de tela retorna uma scene
	 * previamente carregada
	 * 
	 * @param tipo
	 */
	public static void changeScreen(TipoTela tipo) {
		switch (tipo) {
		case LOGIN:
			stage.setScene(loginScene);
			break;
		case MENU:
			stage.setScene(menuScene);
			break;
		case CADASTROVEICULO:
			stage.setScene(cadastroVeiculoScene);
			break;
		case CADASTROFILIAL:
			stage.setScene(cadastroFilialScene);
			break;
		}
	}

	public static void main(String[] args) {
		System.setProperty("tipoPersistencia", TipoPersistencia.BANCO.name());
		if (args.length > 0) {
			System.setProperty("tipoConexao", args[0]);
		}
		launch(args);
	}
}
