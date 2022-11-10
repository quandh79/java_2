package canteenManager.hoadon;

import canteenManager.Main;
import canteenManager.dao.HoadonRepository;
import canteenManager.dao.ProductRepository;
import canteenManager.enums.RepoType;
import canteenManager.factory.RepositoryFactory;
import canteenManager.model.Hoadon;
import canteenManager.model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class HoaDonController implements Initializable {


    public TableView<Hoadon> tbHoaDon;
    public TableColumn<Hoadon,Integer> tdHoaDonTotal;
    public TableColumn<Hoadon, Date> tdHoaDondate;
    public TableColumn<Hoadon,String> tdHoaDonNote;
    public TableColumn<Hoadon,Integer> tdHoaDonId;
    public DatePicker dateHoaDon;
    public TextArea txtNoteHoaDon;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       tdHoaDonId.setCellValueFactory(new PropertyValueFactory<Hoadon,Integer>("idHoaDon"));
       tdHoaDonTotal.setCellValueFactory(new PropertyValueFactory<Hoadon,Integer>("totalHoaDon"));
       tdHoaDondate.setCellValueFactory(new PropertyValueFactory<Hoadon,Date>("dateBill"));
       tdHoaDonNote.setCellValueFactory(new PropertyValueFactory<Hoadon,String>("noteHoaDon"));
       ObservableList<Hoadon> ls = FXCollections.observableArrayList();
       HoadonRepository rp = (HoadonRepository) RepositoryFactory.creatRepository(RepoType.HOADON);
       ls.addAll(rp.all());
       tbHoaDon.setItems(ls);

        
    }

    public void goHome(ActionEvent actionEvent)throws Exception {
        Parent listBook = FXMLLoader.load(getClass().getResource("../home.fxml"));
        Main.rootStage.setTitle("Bill");
        Main.rootStage.setScene(new Scene(listBook,800,600));
    }

    public void goCTHD(ActionEvent actionEvent)throws Exception {
        Parent listBook = FXMLLoader.load(getClass().getResource("../bills/list/list.fxml"));
        Main.rootStage.setTitle("Bill");
        Main.rootStage.setScene(new Scene(listBook,800,600));
    }

    public void submit(ActionEvent actionEvent) {
        try {
            LocalDate dt = dateHoaDon.getValue();
            String noteHoaDon = txtNoteHoaDon.getText();
            Integer totalHoaDon = 1;
            Hoadon hoadon = new Hoadon(null,dt,totalHoaDon,noteHoaDon);
            HoadonRepository h = new HoadonRepository();
            if (h.creat(hoadon)){

            }else {System.out.println("Error");}
        }catch (Exception e){}
    }
}
