import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
       int startNum = inputStartNum();
       int maxMove = inputMaxMove(startNum);
       Game game = new Game(startNum, maxMove);
       int mode = chooseMode();
       if (mode == 1) {
           game.playEasyGame();
       }
       else if (mode == 2){
           game.playHardGame();
       }
       else {
           game.playAIImplementedGame();
       }
    }
    public static int inputStartNum() {
        int startNum;
        while (true) {
            Scanner s = new Scanner(System.in);
            try {
                System.out.println("Please enter the number of sticks that you want to start playing: ");
                startNum = s.nextInt();
                if (startNum <= 0) {
                    System.out.println("Cannot start with a negative number of sticks");
                    continue;
                }
                if (startNum >= 1000) {
                    System.out.println("The number is too big. Please re-enter a number below 1000");

                    continue;
                }
                if (startNum < 2) {
                    System.out.println("The number is too small. Please re-enter");
                    continue;
                }

                return startNum;
            } catch (InputMismatchException e) {
                System.out.println("Please re-enter a valid number");
                continue;
            }
        }
    }
    public static int inputMaxMove(int startNum) {
        int maxMove;
        while (true) {
            Scanner s = new Scanner(System.in);
            try {
                System.out.println("Please enter the maximum per move: ");
                maxMove = s.nextInt();
                if (maxMove <= 0) {
                    System.out.println("Please enter a positive number");
                    continue;
                }
                if (maxMove >= startNum) {
                    System.out.println("Please enter a number smaller than the starting number");
                    continue;
                }
                return maxMove;
            } catch (InputMismatchException e) {
                System.out.println("Please re-enter a valid number");
                continue;
            }
        }
    }
    public static int chooseMode() {
        int mode;
        while (true) {
            Scanner s = new Scanner(System.in);
            System.out.println("There are 2 Game Options:");
            System.out.println("1. Easy");
            System.out.println("2. Hard");
            System.out.println("3. AI Implemented Mode");
            System.out.println("Choose your Game Mode: ");
            try {
                mode = s.nextInt();
                switch (mode) {
                    case 1:
                        System.out.println("You are in the Easy Mode.");
                        return 1;

                    case 2:
                        System.out.println("You are in the Hard Mode.");
                        return 2;

                    case 3:
                        System.out.println("You are in the AI Implemented Mode");
                        return 3;

                    default:
                        System.out.println("Incorrect Input.");
                        continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please re-enter a valid number");
                continue;
            }
        }
    }
}