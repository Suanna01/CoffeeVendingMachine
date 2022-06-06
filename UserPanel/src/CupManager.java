public class CupManager extends UserPanel {
    private static int remainCupAmount = 8;    //하나의 커피에 1개씩 필요함.

    public static boolean checkCupAvailable(){
        if (getRemainCupCount() >= 1) {    //컵이 하나라도 있으면,
            releaseCup();    //컵 하나 보냄.
            return true;
        }
        else {    //컵이 하나도 없으면,
            UserPanel.displayPromptNoCup();
            Controller.returnChange(MoneyManager.getCash());    //투입한 돈 배출
            UserPanel.selectCoffee();
            return false;
        }
    }

    public static int getRemainCupCount(){
        return remainCupAmount;
    }
    public static void releaseCup(){
        remainCupAmount--;
    }
}
