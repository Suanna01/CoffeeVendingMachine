public class MoneyManager extends UserPanel {
    private static int remainMoneyAmount = 10000;
    private static int change;

    public static boolean checkChangeAvailable(int price, int cash){
        setChange(price, cash);    //잔돈 계산
        if (getChange() <= remainMoneyAmount) {    //잔돈을 줄 수 있다면,
            setMoneyStackPop(change);    //돈 스택에서 잔돈만큼 Minus
            return true;
        }
        else {
            UserPanel.displayPromptNoMoney();
            Controller.returnChange(MoneyManager.getCash());    //투입한 돈 배출
            UserPanel.selectCoffee();
            return false;
        }
    }

    public static int getChange(){
        return change;
    }

    public static void setChange(int price, int cash){
        change = cash - price;
    }

    public static void setMoneyStackPop(int change){
        remainMoneyAmount -= change;
    }

    public static int getRemainMoneyAmount(){
        return remainMoneyAmount;
    }
}
