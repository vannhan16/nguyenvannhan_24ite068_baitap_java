package Chapter1.Exrecise1_5;

public class InvoiceItem {
    private String id;
    private String desc;
    private int qty;
    private double unitPrice;

    public InvoiceItem(String id, String decs, int qty, double unitPrice) {
        this.id = id;
        this.desc = decs;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }
    public String getId(){
        return id;
    }
    public String getDesc(){
        return desc;
    }
    public int getQty(){
        return qty;
    }
    public void setQty(int qty){
        this.qty = qty;
    }
    public double getUnitPrice(){
        return unitPrice;
    }
    public void setUnitPrice(double unitPrice){
        this.unitPrice = unitPrice;
    }
    public double getTotal(){
        return qty * unitPrice;
    }

    @Override
    public String toString() {
        return "InvoiceItem{" +
                "desc='" + desc + '\'' +
                ", id='" + id + '\'' +
                ", qty=" + qty +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
