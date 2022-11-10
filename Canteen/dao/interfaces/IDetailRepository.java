package Canteen.dao.interfaces;

import Canteen.entities.Detail;

import java.util.ArrayList;

public interface IDetailRepository {
    ArrayList<Detail> all();
    boolean create(Detail detail);
    boolean update(Detail detail);
    boolean delete(Detail detail);
    Detail finOne (Integer id);
}
