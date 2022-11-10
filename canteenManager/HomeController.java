package canteenManager;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class HomeController {
    public void goToProduct(javafx.event.ActionEvent actionEvent) throws Exception {
        Parent listBook = FXMLLoader.load(getClass().getResource("product/product.fxml"));
        Main.rootStage.setTitle("Product");
        Main.rootStage.setScene(new Scene(listBook,800,600));
    }

    public void goToBill(javafx.event.ActionEvent actionEvent) throws Exception {
        Parent listBook = FXMLLoader.load(getClass().getResource("bills/list/list.fxml"));
        Main.rootStage.setTitle("Bill");
        Main.rootStage.setScene(new Scene(listBook,800,600));
    }
}
