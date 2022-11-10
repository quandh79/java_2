package Canteen.detail.list;

import Canteen.dao.impls.BillReposityory;
import Canteen.dao.impls.DetailRepository;
import Canteen.entities.Detail;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ListDetailController implements Initializable {
    public TableView<Detail> tbDetail;
    public TableColumn<Detail,Integer> tdId;
    public TableColumn<Detail,Integer> tdIdBill;
    public TableColumn<Detail,Integer> tdIdProduct;
    public TableColumn<Detail,Integer> tdQty;
    public TableColumn<Detail,Integer> tdTotal;
    public TableColumn<Detail,String> tdNote;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tdId.setCellValueFactory(new PropertyValueFactory<Detail,Integer>("id"));
        tdIdBill.setCellValueFactory(new PropertyValueFactory<Detail,Integer>("idBill"));
        tdIdProduct.setCellValueFactory(new PropertyValueFactory<Detail,Integer>("idProduct"));
        tdQty.setCellValueFactory(new PropertyValueFactory<Detail,Integer>("qty"));
        tdTotal.setCellValueFactory(new PropertyValueFactory<Detail,Integer>("total"));
        tdNote.setCellValueFactory(new PropertyValueFactory<Detail,String>("note"));
        ObservableList<Detail> ls = FXCollections.observableArrayList();
        DetailRepository rp = new DetailRepository();
        ls.addAll(rp.all());
        tbDetail.setItems(ls);
    }
}
