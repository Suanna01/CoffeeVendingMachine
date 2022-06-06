import java.util.Scanner;

public class UserPanel {
    private static int cash = 0;    //사용자가 낸 금액
    private static String selection;    //사용자가 고른 커피 이름

    public static void main(String[] args) {

        //처음 Panel
        System.out.println("================================================");
        System.out.println();
        System.out.println("     \\___/           \\___/          \\___/     ");
        System.out.println("      \\_/             \\_/            \\_/      ");
        System.out.println("1. 고급커피(1000원) 2. 일반커피(700원) 3. 블랙커피(500원) ");
        System.out.println();
        System.out.println("================================================");

        //커피 종류 선택
        //투입한 금액보다 더 높은 금액의 커피를 선택할 시, 주문 가능한 커피를 입력할 때까지 반복문을 돈다.
        //투입한 금액에 따라 주문 가능한 커피의 LED를 키고, LED가 켜진 커피만 주문 받음.
        selectCoffee();
    }

    public static void selectCoffee(){
        cash = 0;
        Scanner scn = new Scanner(System.in);
        while (cash != -1){
            System.out.print("                           투입구 |________|  <---- ");
            cash += scn.nextInt();    //사용자 : 돈 투입
            if (cash >= 500 && cash < 700){    //투입금이 500원 이하일 때,
                ledLightOnUnder500();    //500원 이하인 커피의 LED만 켬.
                selection = scn.next();    //사용자 : 주문할 커피를 입력함.
                orderBlackCoffee(selection);    //투입금액 이하의 커피 선택 시, Controller로 넘겨서 재료 검사 시작.
            }
            else if (cash >= 700 && cash < 1000){    //투입금이 700원 이하일 때,
                ledLightOnUnder700();
                selection = scn.next();
                orderBlackCoffee(selection);
                orderPlainCoffee(selection);
            }
            else if (cash >= 1000){    //투입금이 1000원 이하일 때,
                ledLightOnUnder1000();
                selection = scn.next();
                orderBlackCoffee(selection);
                orderPlainCoffee(selection);
                orderSpecialCoffee(selection);
            }
            if(cash == -1)  //-1이 입력되면 자판기 운영 종료
                break;
        }
    }

    public static int getCash(){
        return cash;
    }

    public static void setCash(int cash1){
        cash = cash1;
    }

    public static int getPrice(String selection){
        return Button.getButtonClick(selection);
    }

    public static String getSelection(){
        return selection;
    }

    public static void orderSpecialCoffee(String selection){
        if (selection.equals("고급커피"))
            Controller.getCustomerSelection(getPrice(selection), getSelection());
    }
    public static void orderPlainCoffee(String selection){
        if (selection.equals("일반커피"))
            Controller.getCustomerSelection(getPrice(selection), getSelection());
    }
    public static void orderBlackCoffee(String selection){
        if (selection.equals("블랙커피"))
            Controller.getCustomerSelection(getPrice(selection), getSelection());
    }

    public static void ledLightOnUnder500(){
        System.out.println();
        System.out.println("================================================");
        System.out.println();
        System.out.println("     \\___/           \\___/          \\___/     ");
        System.out.println("      \\_/             \\_/            \\_/      ");
        System.out.println("O 고급커피(1000원) O 일반커피(700원) ✪ 블랙커피(500원) ");
        System.out.println();
        System.out.println("================================================");
        System.out.print("주문할 커피의 이름을 입력하세요 : ");
    }

    public static void ledLightOnUnder700(){
        System.out.println();
        System.out.println("================================================");
        System.out.println();
        System.out.println("     \\___/           \\___/          \\___/     ");
        System.out.println("      \\_/             \\_/            \\_/      ");
        System.out.println("O 고급커피(1000원) ✪ 일반커피(700원) ✪ 블랙커피(500원) ");
        System.out.println();
        System.out.println("================================================");
        System.out.print("주문할 커피의 이름을 입력하세요 : ");
    }

    public static void ledLightOnUnder1000(){
        System.out.println();
        System.out.println("================================================");
        System.out.println();
        System.out.println("     \\___/           \\___/          \\___/     ");
        System.out.println("      \\_/             \\_/            \\_/      ");
        System.out.println("✪ 고급커피(1000원) ✪ 일반커피(700원) ✪ 블랙커피(500원) ");
        System.out.println();
        System.out.println("================================================");
        System.out.print("주문할 커피의 이름을 입력하세요 : ");
    }

    public static void displayPromptNoCup(){
        System.out.println("컵 소진");
    }

    public static void displayPromptNoWater(){
        System.out.println("물 소진");
    }

    public static void displayPromptNoMoney(){
        System.out.println("돈 소진");
    }

    public static void returnCash(){
        System.out.printf("%s원 배출\n", MoneyManager.getChange());
    }
}
