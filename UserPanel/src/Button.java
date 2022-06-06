public class Button extends UserPanel{
    private static int priceSpecialCoffee = 1000;
    private static int pricePlainCoffee = 700;
    private static int priceBlackCoffee = 500;

    public static int getButtonClick(String btnCoffee){
        return switch (btnCoffee) {
            case "고급커피" -> priceSpecialCoffee;
            case "일반커피" -> pricePlainCoffee;
            case "블랙커피" -> priceBlackCoffee;
            default -> 0;
        };
    }
}
