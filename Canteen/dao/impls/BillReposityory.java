package Canteen.dao.impls;

import Canteen.dao.interfaces.IBillrepository;
import Canteen.dao.interfaces.IRepository;
import Canteen.entities.Bill;
import Canteen.helper.Connector;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class BillReposityory implements IRepository<Bill> {


    @Override
    public ArrayList<Bill> all() {
        ArrayList<Bill> ls = new ArrayList<>();
        try {
            String sql_txt = "select * from bills ";
            Connector conn = Connector.getInstance();
            ResultSet rs = conn.query(sql_txt);
            while (rs.next()){
                int id = rs.getInt("id");
                Date date = rs.getDate("dateBill");
                int total = rs.getInt("total");
                String note = rs.getNString("note");
                Bill b = new Bill(id,date,total,note);
                ls.add(b);

            }
        }catch (Exception e){System.out.println(e.getMessage());};
        return ls;
    }

    @Override
    public boolean create(Bill bill) {
        try {
            String sql_txt = "insert into bills(date,total,note) values(?,?,?)";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(bill.getDateBill());
            arr.add(bill.getTotal());
            arr.add(bill.getNote());
            if (conn.execute(sql_txt, arr)) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean update(Bill bill) {
        try {
            String sql_txt = "update bills set dateBill=?, total=?, note=? where id=?";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(bill.getDateBill());
            arr.add(bill.getTotal());
            arr.add(bill.getNote());
            if (conn.execute(sql_txt,arr)){return true;}
        }catch (Exception e){System.out.println(e.getMessage());}
        return false;
    }

    @Override
    public boolean delete(Bill bill) {
        try {
            String sql_txt = "delete from bills where id=?";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(bill.getId());
        }catch (Exception e){}
        return false;
    }

    @Override
    public Bill findOne(Integer id) {
        try {
            String sql_txt = "select * from bills where id=?";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(id);
            ResultSet rs = conn.executeQuery(sql_txt,arr);
            while (rs.next()){
                int Id = rs.getInt("id");
                Date date = rs.getDate("dateBill");
                int total = rs.getInt("total");
                String note = rs.getString("note");
                return new Bill(id,date,total,note);
            }
        }catch (Exception e){}
        return null;
    }
}

