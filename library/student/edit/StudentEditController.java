package library.student.edit;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import library.Main;
import library.dao.impls.StudentRepository;
import library.dao.interfaces.IBookRepository;
import library.entities.Student;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class StudentEditController implements Initializable {
    public TextField txtName;
    public TextField txtEmail;
    public TextField txtTel;
    public static Student editedStudent;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (editedStudent != null){
            txtName.setText(editedStudent.getName());
            txtEmail.setText(editedStudent.getEmail());
            txtTel.setText(editedStudent.getTel());
        }
    }

    public void submit(ActionEvent actionEvent) {
        try {
            String name = txtName.getText();
            String email = txtEmail.getText();
            String tel = txtTel.getText();
            editedStudent.setName(name);
            editedStudent.setEmail(email);
            editedStudent.setTel(tel);
            StudentRepository rp = new StudentRepository();
            if (rp.update(editedStudent)){
                backToList(null);
            }else {
                System.out.println("Error");
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void backToList(ActionEvent actionEvent) throws Exception{
        Parent listBook = FXMLLoader.load(getClass().getResource("../list/list.fxml"));
        Main.rootStage.setTitle("Books");
        Main.rootStage.setScene(new Scene(listBook,800,600));
    }

    public void delete(ActionEvent actionEvent) {
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Student?");
            alert.setHeaderText("Are you sure delete student"+editedStudent.getName());
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get() == ButtonType.OK){
                StudentRepository rp  = new StudentRepository();
                if (rp.delete(editedStudent)){
                    backToList(null);
                }else {
                    System.out.println("Error");
                }
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
