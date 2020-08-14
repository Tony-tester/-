package Day_2.immovables;

public class All {
    public static void main(String[] args) {
        Flat ordinaryFlat = new Flat();
        ordinaryFlat.setNumberOfRooms(1);
        ordinaryFlat.setArea(34.5);
        ordinaryFlat.setCostByMeter(13000);
        System.out.println(ordinaryFlat.toString());

        House privateHouse = new House();
        privateHouse.setNumberOfRooms(6);
        privateHouse.setArea(124.3);
        privateHouse.setCostByMeter(20500);
        System.out.println(privateHouse.toString());

        ClothesShop miniShop = new ClothesShop();
        miniShop.setShopName("Сундучок");
        miniShop.setArea(221.5);
        miniShop.setCostByMeter(35000);
        System.out.println(miniShop.toString());
    }
}
