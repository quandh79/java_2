package canteenManager.dao;

import canteenManager.database.Connector;
import canteenManager.model.Bill;
import canteenManager.model.Hoadon;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class HoadonRepository implements DAOInterface<Hoadon> {

    @Override
    public ArrayList<Hoadon> all() {
        ArrayList<Hoadon> ls = new ArrayList<>();
        try {
            String sql_txt = "SELECT * FROM hoadon";
            Connector conn = Connector.getInstance();
            ResultSet rs = conn.query(sql_txt);
            while (rs.next()){
                int idHd = rs.getInt("idHoaDon");
                int totalHd = rs.getInt("totalHoadon");
                Date dateHd = rs.getDate("dateBill");
                String noteHd = rs.getString("noteHoaDon");
                Hoadon h = new Hoadon(idHd,totalHd,dateHd,noteHd);
                ls.add(h);


            }
        }catch (Exception e){System.out.println(e.getMessage());}
        return ls;
    }

    @Override
    public boolean creat(Hoadon hoadon) {
        try {
            String sql_txt = "insert into hoadon(totalHoaDon,dateBill,noteHoaDon) values(?,?,?)";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(Hoadon.getTotalBill());
            arr.add(Hoadon.getDateBill());
            arr.add(Hoadon.getNoteBill());
            if (conn.execute(sql_txt,arr)){return true;}
        }catch (Exception e){}
        return false;
    }

    @Override
    public boolean delete(Hoadon hoadon) {
        return false;
    }

    @Override
    public Hoadon findOne(Integer id) {
        return null;
    }
}
