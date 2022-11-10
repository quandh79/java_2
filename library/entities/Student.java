package library.entities;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import library.Main;
import library.book.edit.BookEditController;
import library.student.edit.StudentEditController;

public class Student {
    public static Integer id;
    public static String name;
    public static String email;
    public static String tel;
    public Button edit;

    public Student() {
    }

    public Student(Integer id, String name, String email, String tel) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.tel = tel;
        this.edit = new Button("Edit");
        this.edit.setOnAction((event)->{
            try {
                StudentEditController.editedStudent = this;
                Parent edit = FXMLLoader.load(getClass().getResource("../student/edit/edit.fxml"));
                Main.rootStage.setScene(new Scene(edit,800,600));
            }catch (Exception e){

            }

        });


    }
    public Button getEdit() {
        return edit;
    }


    public static Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String toString() {
        return getName();
    }
}
