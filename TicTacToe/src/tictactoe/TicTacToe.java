// tic tac toe program
package tictactoe;

import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        System.out.println("Welcome to my tic tac toe gameplay.");
        System.out.println("Pick an opponent:");
        System.out.println("1: Computer\n2: A friend of yours");
        Scanner input = new Scanner(System.in);
        String answer = input.nextLine();
        if (answer.equals("1")) {
            System.out.println("You picked vs Computer.");
            System.out.println("Choose a level:");
            System.out.println("1: Begginer\n2: Advanced");
            answer = input.nextLine();
            if (answer.equalsIgnoreCase("1")) {
                vsComputer.playEasy();
            } else if (answer.equals("2")) {
                vsComputer.playHard();
            }
        } else if (answer.equals("2")) {
            vsPlayer.play();
        }
    }

}
