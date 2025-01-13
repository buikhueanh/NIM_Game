import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private int startNum;
    private int maximumPerMove;
    private int numRound;
    Random r = new Random();
    public Game(int startNum, int maximumPerMove) {
        this.startNum = startNum;
        this.maximumPerMove = maximumPerMove;
        numRound = 1;
    }
    public void playEasyGame() {
        int left = startNum;
        int numRemove;
        int yourMove = 0;
        System.out.printf("The game starts with %d sticks.%n", startNum);
        display(startNum);
        System.out.println("Whoever removes the final stick will win the game.");
        System.out.printf("Your maximum sticks per move is %d. %n", maximumPerMove);
        System.out.println("The computer will start first.");
        while (left != 0) {
            System.out.println("It's the computer's turn.");
            if (left <= maximumPerMove) {
                numRemove = left;
            }
            else {
                numRemove = computerMoveEasy();
            }
            System.out.printf("The computer removed %d.%n", numRemove);
            left-=numRemove;
            numRound++;
            System.out.printf("There are %d left. %n", left);
            display(left);
            if (left == 0) {
                System.out.println("!!! You lost. The computer is the winner !!!");
                return;
            }
            System.out.println("It's your turn.");
            System.out.println("Enter the number of sticks that you want to remove: ");
            while (true) {
                try {
                    Scanner s = new Scanner(System.in);
                    yourMove = s.nextInt();
                    if ((yourMove <= 0) || (yourMove > maximumPerMove)) {
                        System.out.printf("Please re-enter a valid number between 1 and %d:%n", maximumPerMove);
                        continue;
                    }
                    else if (yourMove > left) {
                        System.out.println("You can only remove sticks up to the current number. Please re-enter:");
                        continue;
                    }
                    else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.printf("Invalid type. Please re-enter a valid number between 1 and %d:%n", maximumPerMove);
                    continue;
                }
            }
            left-=yourMove;
            numRound++;
            System.out.printf("There are %d left.%n", left);
            display(left);
            if (left == 0) {
                System.out.println("!!! You are the winner !!!");
                return;
            }
        }
    }

    public void playHardGame() {
        int left = startNum;
        int numRemove;
        int yourMove = 0;
        System.out.printf("The game starts with %d sticks.%n", startNum);
        display(startNum);
        System.out.println("Whoever removes the final stick will win the game.");
        System.out.printf("Your maximum sticks per move is %d. %n", maximumPerMove);
        System.out.println("The computer will start first.");
        while (left != 0) {
            System.out.println("It's the computer's turn.");
            if (left <= maximumPerMove) {
                numRemove = left;
            }
            else {
                numRemove = computerMoveHard(yourMove);
            }
            System.out.printf("The computer removed %d.%n", numRemove);
            left-=numRemove;
            numRound++;
            System.out.printf("There are %d left. %n", left);
            display(left);
            if (left == 0) {
                System.out.println("!!! You lost. The computer is the winner !!!");
                return;
            }
            System.out.println("It's your turn.");
            System.out.println("Enter the number of sticks that you want to remove: ");
            while (true) {
                try {
                    Scanner s = new Scanner(System.in);
                    yourMove = s.nextInt();
                    if ((yourMove <= 0) || (yourMove > maximumPerMove)) {
                        System.out.printf("Please re-enter a valid number between 1 and %d:%n", maximumPerMove);
                        continue;
                    }
                    else if (yourMove > left) {
                        System.out.println("You can only remove sticks up to the current number. Please re-enter:");
                        continue;
                    }
                    else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.printf("Invalid type. Please re-enter a valid number between 1 and %d:%n", maximumPerMove);
                    continue;
                }
            }
            left-=yourMove;
            numRound++;
            System.out.printf("There are %d left.%n", left);
            display(left);
            if (left == 0) {
                System.out.println("!!! You are the winner !!!");
                return;
            }
        }
    }

    public void playAIImplementedGame() {
        int left = startNum;
        int numRemove;
        int yourMove = 0;
        System.out.printf("The game starts with %d sticks.%n", startNum);
        display(startNum);
        System.out.println("Whoever removes the final stick will win the game.");
        System.out.printf("Your maximum sticks per move is %d. %n", maximumPerMove);
        System.out.println("The computer will start first.");
        while (left != 0) {
            System.out.println("It's the computer's turn.");
            numRemove = alphaBeta(left);
            System.out.printf("The computer removed %d.%n", numRemove);
            left-=numRemove;
            numRound++;
            System.out.printf("There are %d left. %n", left);
            display(left);
            if (left == 0) {
                System.out.println("!!! You lost. The computer is the winner !!!");
                return;
            }
            System.out.println("It's your turn.");
            System.out.println("Enter the number of sticks that you want to remove: ");
            while (true) {
                try {
                    Scanner s = new Scanner(System.in);
                    yourMove = s.nextInt();
                    if ((yourMove <= 0) || (yourMove > maximumPerMove)) {
                        System.out.printf("Please re-enter a valid number between 1 and %d:%n", maximumPerMove);
                        continue;
                    }
                    else if (yourMove > left) {
                        System.out.println("You can only remove sticks up to the current number. Please re-enter:");
                        continue;
                    }
                    else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.printf("Invalid type. Please re-enter a valid number between 1 and %d:%n", maximumPerMove);
                    continue;
                }
            }
            left-=yourMove;
            numRound++;
            System.out.printf("There are %d left.%n", left);
            display(left);
            if (left == 0) {
                System.out.println("!!! You are the winner !!!");
                return;
            }
        }
    }

    private int computerMoveHard(int yourMove) {
        int compMove;
        int block = maximumPerMove + 1;
        if (numRound == 1) {
            compMove = startNum % block;
            if (compMove == 0) {
                compMove = r.nextInt(maximumPerMove) + 1;
            }
        }
        else {
            compMove = block - yourMove;
        }
        return compMove;
    }

    private int computerMoveEasy() {
        return r.nextInt(maximumPerMove) + 1;
    }

//    AI Implementation
    private int alphaBeta(int currStick) {
        int alpha = -1;
        int beta = +1;
        int value = -1;
        int revStick = 1;
        int v;
        for (int i = 1; i < maximumPerMove; i++) {
            int possibleLeft = currStick - i;
            if (possibleLeft >= 0) {
                v = minValue(possibleLeft, alpha, beta);
                if (v > value) {
                    value = v;
                }
                if (value > alpha) {
                    alpha = value;
                    revStick = i;
                }
            }
        }
        return revStick;
    }
    private int minValue(int currStick, int alpha, int beta) {
        int value;
        if (currStick == 0) {
            return +1;
        }
        value = +1;
        int v;
        for (int i = 1; i <= maximumPerMove; i++) {
            int possibleLeft = currStick - i;
            if (possibleLeft >= 0) {
                v = maxValue(possibleLeft, alpha, beta);
                if (v < value) {
                    value = v;
                }
                if (value <= alpha) {
                    return value;
                }
                if (value < beta) {
                    beta = value;
                }
            }
        }
        return value;
    }

    private int maxValue(int currStick, int alpha, int beta) {
        int value;
        if (currStick == 0) {
            return -1;
        }
        value = -1;
        int v;
        for (int i = 1; i <= maximumPerMove; i++) {
            int possibleLeft = currStick - i;
            if (possibleLeft >= 0) {
                v = minValue(possibleLeft, alpha, beta);
                if (v > value) {
                    value = v;
                }
                if (value > beta) {
                    return value;
                }
                if (value > alpha) {
                    alpha = value;
                }
            }
        }
        return value;
    }

    private void display(int numSticks) {
        if (numSticks == 0) {
            System.out.println("[Uh oh, no more sticks to display]");
        }
        else {
            for (int i = 0; i < numSticks; i++) {
                System.out.print("| ");
            }
        }
        System.out.println();
    }
}
