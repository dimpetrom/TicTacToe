package tictactoe;

import java.util.ArrayList;
import java.util.Scanner;

public class vsPlayer {

    public static void play() {

        Scanner input = new Scanner(System.in);
        System.out.println("");
        System.out.println("You picked vs another player");
        System.out.println("Player 1's name ");
        String player1Name = input.nextLine();
        System.out.println("Player 2's name ");
        String player2Name = input.nextLine();
        System.out.println("You can play as many times as you want.");
        System.out.println("All you have to do, is type is a number 1-9, according to the following order: ");
        String tictactoeArray[] = new String[10];

        String answer;
        int winner[] = {0, 0, 0}; // 0 computer win, 1 player win, 2 player2 win
        int numberOfPlayer1;
        int numberOfPlayer2;

        while (true) {
            boolean winnerInAMatch[] = {false, false, false}; // 1 player1 win, 2 player2 win
            for (int i = 1; i < tictactoeArray.length; i++) {
                tictactoeArray[i] = "" + i + "";
            }
            PrintToScreen.ScreenResult(tictactoeArray);
            for (int i = 1; i < tictactoeArray.length; i++) {
                tictactoeArray[i] = " ";
            }
            ArrayList<Integer> availableNumbers = new ArrayList<>();  // ΟΙ ΔΥΝΑΤΕΣ ΘΕΣΕΙΣ ΤΩΝ "X" ΚΑΙ "O" (1-9)
            for (int i = 1; i <= 9; i++) {  //ΑΡΧΙΚΟΠΟΙΗΣΗ ΤΗΣ ARRAYLIST
                availableNumbers.add(i);
            }

            for (int i = 0; i < 5; i++) {
                System.out.println("Type in a number " + player1Name +":");
                System.out.println("The available numbers are: " + availableNumbers);
                numberOfPlayer1 = input.nextInt();
                boolean cond = false;
                while (!cond) {
                    for (int j = 0; j < availableNumbers.size(); j++) {
                        if (numberOfPlayer1 == availableNumbers.get(j)) {
                            cond = true;
                            break;
                        }
                    }
                    if (!cond) {
                        System.out.println("You typed a wrong number. Try again: ");
                        numberOfPlayer1 = input.nextInt();
                    }
                }
                tictactoeArray[numberOfPlayer1] = "X";
                PrintToScreen.ScreenResult(tictactoeArray);
                if (i > 1) {
                    CheckWinner.player1Win(tictactoeArray, winner, winnerInAMatch, player1Name, player2Name);
                    if (winnerInAMatch[1]) {
                        break;
                    }
                }
                if(i==4){
                    System.out.println("");
                    System.out.println("Draw!");
                    System.out.println("Scoreboard: " + player1Name + ":" + winner[1] + " " + player2Name +":" + winner[2]);
                    break;
                }
                availableNumbers.remove(new Integer(numberOfPlayer1));
                System.out.println("Type in a number " + player2Name +":");
                System.out.println("The available numbers are: " + availableNumbers);
                numberOfPlayer2 = input.nextInt();
                boolean cond2 = false;
                while (!cond2) {
                    for (int j = 0; j < availableNumbers.size(); j++) {
                        if (numberOfPlayer2 == availableNumbers.get(j)) {
                            cond2 = true;
                            break;
                        }
                    }
                    if (!cond2) {
                        System.out.println("You typed a wrong number. Try again: ");
                        numberOfPlayer2 = input.nextInt();
                    }
                }
                tictactoeArray[numberOfPlayer2] = "O";
                if (i > 1) {
                    CheckWinner.player2Win(tictactoeArray, winner, winnerInAMatch, player1Name, player2Name);
                    if (winnerInAMatch[2]) {
                        break;
                    }
                }
                availableNumbers.remove(new Integer(numberOfPlayer2));
                PrintToScreen.ScreenResult(tictactoeArray);
            }
            System.out.println("Would you like to play another game? Y/N");
            answer = input.next();
            if (answer.equalsIgnoreCase("y")) {
                System.out.println("Good luck!");
            } else if (answer.equalsIgnoreCase("n")) {
                System.out.println("Thank you for playing.");
                break;
            }
        }
    }
}
