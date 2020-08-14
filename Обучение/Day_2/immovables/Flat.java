package Day_2.immovables;

public class Flat extends ResidentialPremise {
    private double costByMeter;
    private double costByItem;

    public double getCostByMeter() {
        return costByMeter;
    }
    public void setCostByMeter(double costByMeter) {
        this.costByMeter = costByMeter;
    }

    public double getCostByItem() {
        return this.costByItem = this.costByMeter * getArea();
    }
    @Override
    public String toString() {
        return "Квартира " + "площадью " + getArea() + " кв. м. , комнат - " + getNumberOfRooms() +
                " стоимость кв метра " + getCostByMeter() + " руб и стоит квартира " + getCostByItem() + " руб.";
    }
}
