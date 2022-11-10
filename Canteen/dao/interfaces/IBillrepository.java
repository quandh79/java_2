package Canteen.dao.interfaces;

import Canteen.entities.Bill;

import java.util.ArrayList;

public interface IBillrepository<B> {
    ArrayList<Bill> all();
    boolean create(Bill bill);
    boolean update(Bill bill);
    boolean delete(Bill bill);
    Bill finOne(Integer id);

}
