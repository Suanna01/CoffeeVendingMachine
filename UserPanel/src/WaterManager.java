public class WaterManager extends UserPanel {
    private static int remainWaterAmount = 90;    //하나의 커피에 18ml 들어감.

    public  static boolean checkWaterAvailable(){
        if (getRemainWaterAmount() >= 18) {
            setWater();
            return true;
        }
        else {
            UserPanel.displayPromptNoWater();
            Controller.returnChange(MoneyManager.getCash());    //투입한 돈 배출
            UserPanel.selectCoffee();
            return false;
        }
    }

    public static int getRemainWaterAmount(){
        return remainWaterAmount;
    }

    public static void setWater(){
        remainWaterAmount -= 20;
    }
}
