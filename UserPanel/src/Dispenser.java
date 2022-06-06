public class Dispenser extends UserPanel {
    public static void releaseMixedIngredient(){
        System.out.println();
        System.out.println("배출구...");
        System.out.println("_______________________");
        System.out.println("|    ▰▰▰.  .▰▰▰    |");
        System.out.println("|         . .         |");
        System.out.println("|       \\ ../         |");
        System.out.println("|        \\~/          |");
        System.out.println("|_____________________|");
        System.out.println();
    }

    public static void releaseSelection(){
        Controller.resetCash();
        System.out.println();
        System.out.println("커피를 꺼내가세요.");
        System.out.println("_______________________");
        System.out.println("|    ~ ~        ~     |");
        System.out.println("|        ~    ~~      |");
        System.out.println("|       \\___/         |");
        System.out.println("|        \\_/          |");
        System.out.println("|_____________________|");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("-------------관리자--------------");
        System.out.printf("남은 커피 용액 : %s\n", IngredientManager.getRemainCoffeeAmount());
        System.out.printf("남은 설탕 : %s\n", IngredientManager.getRemainSugarAmount());
        System.out.printf("남은 크림 : %s\n", IngredientManager.getRemainCreamAmount());
        System.out.printf("남은 물 : %s\n", WaterManager.getRemainWaterAmount());
        System.out.printf("남은 컵 개수: %s\n", CupManager.getRemainCupCount());
        System.out.printf("남은 돈: %s\n", MoneyManager.getRemainMoneyAmount());
        System.out.println("--------------------------------");
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
