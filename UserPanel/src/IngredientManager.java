public class IngredientManager extends UserPanel {
    private static int remainCoffeeAmount = 200;    //총 커피 용액 양 = 200ml (하나의 커피에 20ml씩 들어감.)
    private static int remainSugarAmount = 100;    //총 설탕 양 = 100g (하나의 커피에 10g씩 들어감.)
    private static int remainCreamAmount = 80;    //총 크림 양 = 100g (하나의 커피에 10g씩 들어감.)

    public static boolean checkIngredientAvailable(String selection){    //필요한 모든 재료 확인
        switch (selection) {
            case "고급커피":    //고급커피 재료 : 커피, 크림
                if (checkCoffeeAvailable() && checkCreamAvailable()) {    //필요한 재료가 모두 있을 시,
                    checkCupWaterAvailable(selection);    //컵, 물 있을 시,
                    return true;
                }
                //필요한 재료가 하나라도 없는 경우
                else {
                    System.out.println("재료 부족");
                    Controller.returnChange(MoneyManager.getCash());    //투입한 돈 배출
                    UserPanel.selectCoffee();
                }
            case "일반커피":    //일반커피 재료 : 커피, 설탕
                if (checkCoffeeAvailable() && checkSugarAvailable()) {
                    checkCupWaterAvailable(selection);    //컵, 물 있을 시,
                    return true;
                }
                else {
                    System.out.println("재료 부족");
                    Controller.returnChange(MoneyManager.getCash());    //투입한 돈 배출
                    UserPanel.selectCoffee();
                }
            case "블랙커피":    //블랙커피 재료 : 커피
                if (checkCoffeeAvailable()) {
                    checkCupWaterAvailable(selection);    //컵, 물 있을 시,
                    return true;
                }
                else {
                    System.out.println("재료 부족");
                    Controller.returnChange(MoneyManager.getCash());    //투입한 돈 배출
                    UserPanel.selectCoffee();
                }
            default:
                System.out.println("고장");
                System.exit(0);
                break;
        }
        return false;
    }

    public static boolean checkCoffeeAvailable(){
        return remainCoffeeAmount >= 20;
    }

    public static boolean checkCreamAvailable(){
        return remainCreamAmount >= 10;
    }

    public static boolean checkSugarAvailable(){
        return remainSugarAmount >= 10;
    }

    public static int getRemainCoffeeAmount(){
        return remainCoffeeAmount;
    }
    public static int getRemainSugarAmount(){
        return remainSugarAmount;
    }
    public static int getRemainCreamAmount(){
        return remainCreamAmount;
    }
    public static void setRemainCoffeeAmount(int coffeeAmount){
        remainCoffeeAmount = coffeeAmount;
    }
    public static void setRemainSugarAmount(int sugarAmount){
        remainSugarAmount = sugarAmount;
    }
    public static void setRemainCreamAmount(int creamAmount){
        remainCreamAmount = creamAmount;
    }
    public static void checkCupWaterAvailable(String selection){
        if (CupManager.checkCupAvailable() && WaterManager.checkWaterAvailable())
            System.out.printf("%s 제조를 시작합니다...\n", selection);
    }
}
