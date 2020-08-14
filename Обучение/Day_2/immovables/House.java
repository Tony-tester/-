package Day_2.immovables;

public class House extends ResidentialPremise {
    private double costByMeter;
    private double costByItem;

    public double getCostByMeter() {
        return costByMeter;
    }
    public void setCostByMeter(double costByMeter) {
        this.costByMeter = costByMeter;
    }
    public double getCostByItem() {
        return this.costByItem = costByMeter * getArea();
    }
    @Override
    public String toString() {
        return "Дом " + "площадью " + getArea() + " кв. м. имеет комнат - "  + getNumberOfRooms() +
                " стоимость кв метра " + getCostByMeter() + " руб и стоит дом " + getCostByItem() + " руб.";
    }
}
