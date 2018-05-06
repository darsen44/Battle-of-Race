package util;

import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public static String chooseNameOfHero(){
        String userInput = scanner.next().trim();
        while(true){
            if(!userInput.isEmpty()) return userInput;
            Message.errorEmptyInput();
        }
    }

    public static int checkingRangeInput(int count){
        while (true) {
            String userInput = scanner.next().trim();

            if (!userInput.isEmpty() && userInput.matches("\\d+")) {
                int num = Integer.parseInt(userInput);

                if (num >= 1 && num <=count ) {
                    return num ;
                }
            }
            System.out.println("Wrong Input, please select from range[1:"+ count +"]");
        }
    }
}
