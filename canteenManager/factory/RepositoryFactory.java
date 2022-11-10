package canteenManager.factory;

import canteenManager.dao.BillRepository;
import canteenManager.dao.DAOInterface;
import canteenManager.dao.HoadonRepository;
import canteenManager.dao.ProductRepository;
import canteenManager.enums.RepoType;

public class RepositoryFactory {
    private RepositoryFactory(){
    }
    public static DAOInterface creatRepository(RepoType type){
        switch (type){
            case Product:return new ProductRepository();
            case BILL:return new BillRepository();
            case HOADON:return new HoadonRepository();
            default:throw new IllegalArgumentException("thiếu ts");
        }
    }
}
