package Canteen.dao.impls;

import Canteen.dao.interfaces.IDetailRepository;
import Canteen.entities.Detail;
import Canteen.helper.Connector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class DetailRepository implements IDetailRepository {
    @Override
    public ArrayList<Detail> all() {
        ArrayList<Detail> ls = new ArrayList<>();
       try {
           String sql_txt = "select * from detail";
           Connector conn = Connector.getInstance();
           ResultSet rs = conn.query(sql_txt);
           while (rs.next()){
               int id = rs.getInt("id");
               int billId = rs.getInt("idBill");
               int productId = rs.getInt("idProduct");
               int qty = rs.getInt("qty");
               int total = rs.getInt("total");
               String note = rs.getString("note");
               Detail d = new Detail(id,billId,productId,qty,total,note);
               ls.add(d);
           }
       }catch (Exception e){System.out.println(e.getMessage());}
       return ls;
    }

    @Override
    public boolean create(Detail detail) {
        return false;
    }

    @Override
    public boolean update(Detail detail) {
        return false;
    }

    @Override
    public boolean delete(Detail detail) {
        return false;
    }

    @Override
    public Detail finOne(Integer id) {
        return null;
    }
}
