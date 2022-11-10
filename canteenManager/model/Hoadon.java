package canteenManager.model;

import java.time.LocalDate;
import java.util.Date;

public class Hoadon {
    public Integer billId;
    public static Integer totalBill;
    public static Date dateBill;
    public static String noteBill;

    public Hoadon(Integer billId, LocalDate dt, Integer totalHoaDon, String noteHoaDon) {
    }

    public Hoadon(Integer billId, Integer totalBill, Date dateBill, String noteBill) {
        this.billId = billId;
        this.totalBill = totalBill;
        this.dateBill = dateBill;
        this.noteBill = noteBill;
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public static Integer getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(Integer totalBill) {
        this.totalBill = totalBill;
    }

    public static Date getDateBill() {
        return dateBill;
    }

    public void setDateBill(Date dateBill) {
        this.dateBill = dateBill;
    }

    public static String getNoteBill() {
        return noteBill;
    }

    public void setNoteBill(String noteBill) {
        this.noteBill = noteBill;
    }
}
