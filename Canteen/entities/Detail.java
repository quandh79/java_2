package Canteen.entities;

public class Detail {
    public Integer id;
    public Integer billId;
    public Integer productId;
    public Integer qty;
    public Integer total;
    public String note;

    public Detail() {
    }

    public Detail(Integer id, Integer billId, Integer productId, Integer qty, Integer total, String note) {
        this.id = id;
        this.billId = billId;
        this.productId = productId;
        this.qty = qty;
        this.total = total;
        this.note = note;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
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
