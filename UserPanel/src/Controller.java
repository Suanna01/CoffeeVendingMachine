public class Controller extends UserPanel {
    public static void getCustomerSelection(int price, String selection) {
        //1
        //필요한 모든 재료가 있는 경우
        if (IngredientManager.checkIngredientAvailable(selection)){    //커피 종류에 따라 필요한 재료가 모두 있을 시,
            if (MoneyManager.checkChangeAvailable(price, UserPanel.getCash())){    //잔돈이 있을 시,
                CoffeeManufacturer.getIngredient(selection);    //커피 재료 배출
                WaterManager.getRemainWaterAmount();    //물 배출
                Dispenser.releaseSelection();    //완성된 커피 배출
                returnChange(MoneyManager.getChange());    //잔돈 배출
            }
            //잔돈이 없는 경우
            else{
                System.out.println("잔돈 없음");
                returnChange(MoneyManager.getCash());    //투입한 금액 배출
            }
        }
        //2
        //필요한 재료가 하나라도 없는 경우
        else {
            displayPromptCoffeeBtn();    //매진 메시지 띄움
            blockCoffeeBtn(selection);    //해당 커피 버튼 막음
            returnCash();    //투입한 금액 돌려줌
        }
    }

    public static void displayPromptCoffeeBtn(){
        System.out.println("매진");
    }

    public static void returnChange(int change){
        System.out.printf("                           투입구 |________|  ----> %d 배출\n", change);
    }

    public static void blockCoffeeBtn(String selection){
        switch (selection) {
            case "고급커피" -> {
                System.out.println("================================================");
                System.out.println();
                System.out.println("     \\___/           \\___/          \\___/     ");
                System.out.println("      \\_/             \\_/            \\_/      ");
                System.out.println("- 고급커피(1000원) 2. 일반커피(700원) 3. 블랙커피(500원) ");
                System.out.println();
                System.out.println("================================================");
                System.out.println("                           투입구 |________|      ");
            }
            case "일반커피" -> {
                System.out.println("================================================");
                System.out.println();
                System.out.println("     \\___/           \\___/          \\___/     ");
                System.out.println("      \\_/             \\_/            \\_/      ");
                System.out.println("1. 고급커피(1000원) - 일반커피(700원) 3. 블랙커피(500원) ");
                System.out.println();
                System.out.println("================================================");
                System.out.println("                           투입구 |________|      ");
            }
            case "블랙커피" -> {
                System.out.println("================================================");
                System.out.println();
                System.out.println("     \\___/           \\___/          \\___/     ");
                System.out.println("      \\_/             \\_/            \\_/      ");
                System.out.println("1. 고급커피(1000원) 2. 일반커피(700원) - 블랙커피(500원) ");
                System.out.println();
                System.out.println("================================================");
                System.out.println("                           투입구 |________|      ");
            }
        }
    }

    public static void resetCash(){
        UserPanel.setCash(0);
    }
}
