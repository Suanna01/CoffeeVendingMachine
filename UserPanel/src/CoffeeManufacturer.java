public class CoffeeManufacturer extends UserPanel {
    public static void getIngredient(String selection){    //사용자가 선택한 커피에 따라 필요한 재료 가져옴.
        switch (selection) {
            case "고급커피" -> {
                getCream();
                getCoffee();
            }
            case "일반커피" -> {
                getSugar();
                getCoffee();
            }
            case "블랙커피" -> getCoffee();
            default -> {
                System.out.println("재료 가져오기 고장");
                System.exit(0);
            }
        }
        Dispenser.releaseMixedIngredient();    //재료 섞음
    }
    public static void getCoffee() {    //커피를 만드는 데 필요한 용량만큼 Minus
        IngredientManager.setRemainCoffeeAmount(IngredientManager.getRemainCoffeeAmount() - 20);
    }
    public static void getSugar(){
        IngredientManager.setRemainSugarAmount(IngredientManager.getRemainSugarAmount() - 10);
    }
    public static void getCream(){
        IngredientManager.setRemainCreamAmount(IngredientManager.getRemainCreamAmount() - 10);
    }
}
