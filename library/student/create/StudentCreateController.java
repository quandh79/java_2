package library.student.create;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import library.Main;
import library.dao.impls.StudentRepository;
import library.entities.Student;

public class StudentCreateController {
    public TextField txtName;
    public TextField txtEmail;
    public TextField txtTel;

    public void submit(ActionEvent actionEvent) {
        try {
            String name = txtName.getText();
            String email = txtEmail.getText();
            String tel = txtTel.getText();
            Student student = new Student(null,name,email,tel);
            StudentRepository rp = new StudentRepository();
            if (rp.create(student)){
                backToList();
            }else {
                System.out.println("Error");
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public void backToList() throws Exception{
        Parent listBook = FXMLLoader.load(getClass().getResource("../list/list.fxml"));
        Main.rootStage.setTitle("Books");
        Main.rootStage.setScene(new Scene(listBook,800,600));
    }
}
