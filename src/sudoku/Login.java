
package sudoku;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;



public class Login implements Initializable{

    @FXML Button playBtn;
    @FXML Button btnExit;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void playBtnPressed() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../fxml/layout.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 440, 600);
        Stage stage = new Stage();
        stage.setTitle("SUDOKU");
        stage.setScene(scene);
        stage.show();
        Stage stage2 = (Stage) playBtn.getScene().getWindow();
        stage2.close();
    }
    public void exitButtonPressed(){
        Stage stage2 = (Stage) btnExit.getScene().getWindow();
        stage2.close();
    }
    public int at(){
        return 0;
    }

}
