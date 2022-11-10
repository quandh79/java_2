package Canteen.bill.list;

import Canteen.dao.impls.BillReposityory;
import Canteen.entities.Bill;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class BillListController implements Initializable {
    public TableView<Bill> tbBill;

    public TableColumn<Bill,Integer> tdId;
    public TableColumn<Bill,Date> tdDate;
    public TableColumn<Bill,Integer> tdTotal;
    public TableColumn<Bill,String> tdNote;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tdId.setCellValueFactory(new PropertyValueFactory<Bill,Integer>("id"));
        tdDate.setCellValueFactory(new PropertyValueFactory<Bill,Date>("dateBill"));
        tdTotal.setCellValueFactory(new PropertyValueFactory<Bill,Integer>("total"));
        tdNote.setCellValueFactory(new PropertyValueFactory<Bill,String>("note"));

        ObservableList<Bill> ls = FXCollections.observableArrayList();
        BillReposityory rp = new BillReposityory();
        ls.addAll(rp.all());
        tbBill.setItems(ls);
    }
}
