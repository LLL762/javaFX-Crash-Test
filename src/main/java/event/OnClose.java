package event;

import com.example.login.exception.UnexpectedException;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import static javafx.scene.control.Alert.AlertType.CONFIRMATION;

/**
 * 02/06/2022.
 *
 * @author Laurent Lamiral
 */
public class OnClose {


    public static void close(Stage stage) {

        final Alert alert = new Alert(CONFIRMATION);
        alert.setTitle("Exist");
        alert.setHeaderText("The application will close");
        alert.setContentText("Do u want to save before existing?");


        if (alert.showAndWait().orElseThrow(UnexpectedException::new) == ButtonType.OK) {
            stage.close();
            System.exit(0);
        }

    }


}
