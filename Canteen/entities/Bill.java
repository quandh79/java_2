package Canteen.entities;

import java.util.Date;

public class Bill {
    public Integer id;
    public Date dateBill;
    public Integer total;
    public String note;

    public Bill() {
    }

    public Bill(Integer id, Date dateBill, Integer total, String note) {
        this.id = id;
        this.dateBill = dateBill;
        this.total = total;
        this.note = note;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateBill() {
        return dateBill;
    }

    public void setDateBill(Date dateBill) {
        this.dateBill = dateBill;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
