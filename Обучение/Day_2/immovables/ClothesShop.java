package Day_2.immovables;

public class ClothesShop {
    private double costByMeter;
    private double costByItem;
    private double area;
    public String shopName;

    public double getArea() {
        return area;
    }
    public void setArea(double area) {
        this.area = area;
    }

    public double getCostByMeter() {
        return costByMeter;
    }
    public void setCostByMeter(double costByMeter) {
        this.costByMeter = costByMeter;
    }
    public double getCostByItem() {
        return costByItem = getArea()*getCostByMeter();
    }


    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
    @Override
    public String toString() {
        return "Магазин "+ getShopName() + " площадью " + getArea() +
                " кв м  " + " стоимость кв метра " +  getCostByMeter() +
                " руб и стоит " + getCostByItem() + " руб.";
    }
}
