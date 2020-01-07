package tictactoe;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class vsComputer {

    public static void playEasy() {

        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Type in your name:");
        String playerName = input.nextLine();
        System.out.println("Hello " + playerName + ". You can play as many times as you want.");
        System.out.println("All you have to do, is type is a number 1-9, according to the following order: ");
        String tictactoeArray[] = new String[10];

        String answer;
        int winner[] = {0, 0, 0}; // 0 computer win, 1 player win, 2 player2 win
        int randomNumber;
        int numberOfPlayer;
        int numberOfComputer;

        while (true) {
            boolean winnerInAMatch[] = {false, false}; // 0 computer win, 1 player win
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
                if (i == 4) {
                    System.out.println("Type in a number");
                    System.out.println("The available numbers are: " + availableNumbers);
                    numberOfPlayer = input.nextInt();
                    while (numberOfPlayer != availableNumbers.get(0)) {
                        System.out.println("You typed a wrong number. Try again: ");
                        System.out.println("The available numbers are: " + availableNumbers);
                        numberOfPlayer = input.nextInt();
                    }
                    tictactoeArray[numberOfPlayer] = "X";
                    CheckWinner.playerWin(tictactoeArray, winner, winnerInAMatch, playerName, i);
                    break;
                }
                System.out.println("Type in a number");
                System.out.println("The available numbers are: " + availableNumbers);
                numberOfPlayer = input.nextInt();
                boolean cond = false;
                while (!cond) {
                    for (int j = 0; j < availableNumbers.size(); j++) {
                        if (numberOfPlayer == availableNumbers.get(j)) {
                            cond = true;
                            break;
                        }
                    }
                    if (!cond) {
                        System.out.println("You typed a wrong number. Try again: ");
                        numberOfPlayer = input.nextInt();
                    }
                }
                tictactoeArray[numberOfPlayer] = "X";
                if (i > 1) {
                    CheckWinner.playerWin(tictactoeArray, winner, winnerInAMatch, playerName, i);
                    if (winnerInAMatch[1]) {
                        break;
                    }
                }
                availableNumbers.remove(new Integer(numberOfPlayer));
                randomNumber = rand.nextInt(8 - 2 * i);
                numberOfComputer = availableNumbers.get(randomNumber);
                tictactoeArray[numberOfComputer] = "O";
                if (i > 1) {
                    CheckWinner.computerWin(tictactoeArray, winner, winnerInAMatch, playerName, i);
                    if (winnerInAMatch[0]) {
                        break;
                    }
                }
                availableNumbers.remove(new Integer(numberOfComputer));
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

    public static void playHard() {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        System.out.println("Type in your name:");
        String playerName = input.nextLine();
        System.out.println("Hello " + playerName + ". You can play as many times as you want.");
        System.out.println("All you have to do, is type is a number 1-9, according to the following order: ");
        String tictactoeArray[] = new String[10];

        String answer;
        int winner[] = {0, 0, 0}; // 0 computer win, 1 player win, 2 player2 win
        int numberOfPlayer[] = new int[5];
        int numberOfComputer = 0;

        while (true) {
            boolean winnerInAMatch[] = {false, false}; // 0 computer win, 1 player win
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
                if (i == 4) {
                    System.out.println("Type in a number");
                    System.out.println("The available numbers are: " + availableNumbers);
                    numberOfPlayer[i] = input.nextInt();
                    while (numberOfPlayer[i] != availableNumbers.get(0)) {
                        System.out.println("You typed a wrong number. Try again: ");
                        System.out.println("The available numbers are: " + availableNumbers);
                        numberOfPlayer[i] = input.nextInt();
                    }
                    tictactoeArray[numberOfPlayer[i]] = "X";
                    CheckWinner.playerWin(tictactoeArray, winner, winnerInAMatch, playerName, i);
                    break;
                }
                System.out.println("Type in a number");
                System.out.println("The available numbers are: " + availableNumbers);
                numberOfPlayer[i] = input.nextInt();
                boolean cond = false;
                while (!cond) {
                    for (int j = 0; j < availableNumbers.size(); j++) {
                        if (numberOfPlayer[i] == availableNumbers.get(j)) {
                            cond = true;
                            break;
                        }
                    }
                    if (!cond) {
                        System.out.println("You typed a wrong number. Try again: ");
                        numberOfPlayer[i] = input.nextInt();
                    }
                }
                tictactoeArray[numberOfPlayer[i]] = "X";
                if (i > 1) {
                    CheckWinner.playerWin(tictactoeArray, winner, winnerInAMatch, playerName, i);
                    if (winnerInAMatch[1]) {
                        break;
                    }
                }
                availableNumbers.remove(new Integer(numberOfPlayer[i]));
                if (i == 0) {
                    if (numberOfPlayer[i] == 1 || numberOfPlayer[i] == 3
                            || numberOfPlayer[i] == 7 || numberOfPlayer[i] == 9) {
                        numberOfComputer = 5;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[i] == 2) {
                        numberOfComputer = 8;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[i] == 4) {
                        numberOfComputer = 6;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[i] == 6) {
                        numberOfComputer = 4;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[i] == 8) {
                        numberOfComputer = 2;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[i] == 5) {
                        numberOfComputer = 1;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    }
                } else if (i == 1) {
                    if (numberOfPlayer[0] == 1 && numberOfPlayer[i] == 3) {
                        numberOfComputer = 2;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 1 && numberOfPlayer[i] == 2) {
                        numberOfComputer = 3;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 1 && numberOfPlayer[i] == 4) {
                        numberOfComputer = 7;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 1 && numberOfPlayer[i] == 6) {
                        numberOfComputer = 2;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 1 && numberOfPlayer[i] == 7) {
                        numberOfComputer = 4;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 1 && numberOfPlayer[i] == 8) {
                        numberOfComputer = 4;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 1 && numberOfPlayer[i] == 9) {
                        numberOfComputer = 2;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer)); // an o xrhsths evale sthn prwth kinhsh sto 1o keli

                    } else if (numberOfPlayer[0] == 2 && numberOfPlayer[i] == 1) {
                        numberOfComputer = 3;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 2 && numberOfPlayer[i] == 3) {
                        numberOfComputer = 1;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 2 && numberOfPlayer[i] == 4) {
                        numberOfComputer = 1;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 2 && numberOfPlayer[i] == 5) {
                        numberOfComputer = 7;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 2 && numberOfPlayer[i] == 6) {
                        numberOfComputer = 3;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 2 && numberOfPlayer[i] == 7) {
                        numberOfComputer = 1;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 2 && numberOfPlayer[i] == 9) {
                        numberOfComputer = 3;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer)); // an o xrhsths evale sthn prwth kinhsh sto 2o keli

                    } else if (numberOfPlayer[0] == 3 && numberOfPlayer[i] == 1) {
                        numberOfComputer = 2;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 3 && numberOfPlayer[i] == 2) {
                        numberOfComputer = 1;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 3 && numberOfPlayer[i] == 4) {
                        numberOfComputer = 2;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 3 && numberOfPlayer[i] == 6) {
                        numberOfComputer = 9;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 3 && numberOfPlayer[i] == 7) {
                        numberOfComputer = 2;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 3 && numberOfPlayer[i] == 8) {
                        numberOfComputer = 6;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 3 && numberOfPlayer[i] == 9) {
                        numberOfComputer = 6;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer)); // an o xrhsths evale sthn prwth kinhsh sto 3o keli

                    } else if (numberOfPlayer[0] == 4 && numberOfPlayer[i] == 1) {
                        numberOfComputer = 7;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 4 && numberOfPlayer[i] == 2) {
                        numberOfComputer = 1;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 4 && numberOfPlayer[i] == 3) {
                        numberOfComputer = 1;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 4 && numberOfPlayer[i] == 5) {
                        numberOfComputer = 3;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 4 && numberOfPlayer[i] == 7) {
                        numberOfComputer = 1;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 4 && numberOfPlayer[i] == 8) {
                        numberOfComputer = 7;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 4 && numberOfPlayer[i] == 9) {
                        numberOfComputer = 7;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer)); // an o xrhsths evale sthn prwth kinhsh sto 4o keli   

                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 5 && numberOfPlayer[i] == 2) {
                        numberOfComputer = 8;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 5 && numberOfPlayer[i] == 3) {
                        numberOfComputer = 7;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 5 && numberOfPlayer[i] == 4) {
                        numberOfComputer = 6;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 5 && numberOfPlayer[i] == 6) {
                        numberOfComputer = 4;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 5 && numberOfPlayer[i] == 7) {
                        numberOfComputer = 3;
                        tictactoeArray[numberOfComputer] = "O";
                    } else if (numberOfPlayer[0] == 5 && numberOfPlayer[i] == 8) {
                        numberOfComputer = 2;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 5 && numberOfPlayer[i] == 9) {
                        numberOfComputer = 7;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer)); // an o xrhsths evale sthn prwth kinhsh sto 5o keli  

                    } else if (numberOfPlayer[0] == 6 && numberOfPlayer[i] == 1) {
                        numberOfComputer = 3;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 6 && numberOfPlayer[i] == 2) {
                        numberOfComputer = 3;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 6 && numberOfPlayer[i] == 3) {
                        numberOfComputer = 9;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 6 && numberOfPlayer[i] == 5) {
                        numberOfComputer = 1;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 6 && numberOfPlayer[i] == 7) {
                        numberOfComputer = 9;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 6 && numberOfPlayer[i] == 8) {
                        numberOfComputer = 9;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 6 && numberOfPlayer[i] == 9) {
                        numberOfComputer = 3;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));// an o xrhsths evale sthn prwth kinhsh sto 6o keli  

                    } else if (numberOfPlayer[0] == 7 && numberOfPlayer[i] == 1) {
                        numberOfComputer = 4;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 7 && numberOfPlayer[i] == 2) {
                        numberOfComputer = 4;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 7 && numberOfPlayer[i] == 3) {
                        numberOfComputer = 2;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 7 && numberOfPlayer[i] == 4) {
                        numberOfComputer = 1;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 7 && numberOfPlayer[i] == 6) {
                        numberOfComputer = 8;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 7 && numberOfPlayer[i] == 8) {
                        numberOfComputer = 9;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 7 && numberOfPlayer[i] == 9) {
                        numberOfComputer = 8;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));    // an o xrhsths evale sthn prwth kinhsh sto 7o keli 

                    } else if (numberOfPlayer[0] == 8 && numberOfPlayer[i] == 1) {
                        numberOfComputer = 7;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 8 && numberOfPlayer[i] == 3) {
                        numberOfComputer = 9;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 8 && numberOfPlayer[i] == 4) {
                        numberOfComputer = 7;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 8 && numberOfPlayer[i] == 5) {
                        numberOfComputer = 1;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 8 && numberOfPlayer[i] == 6) {
                        numberOfComputer = 9;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 8 && numberOfPlayer[i] == 7) {
                        numberOfComputer = 9;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 8 && numberOfPlayer[i] == 9) {
                        numberOfComputer = 7;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));   // an o xrhsths evale sthn prwth kinhsh sto 8o keli   

                    } else if (numberOfPlayer[0] == 9 && numberOfPlayer[i] == 1) {
                        numberOfComputer = 2;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 9 && numberOfPlayer[i] == 2) {
                        numberOfComputer = 6;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 9 && numberOfPlayer[i] == 3) {
                        numberOfComputer = 6;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 9 && numberOfPlayer[i] == 4) {
                        numberOfComputer = 8;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 9 && numberOfPlayer[i] == 6) {
                        numberOfComputer = 3;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 9 && numberOfPlayer[i] == 7) {
                        numberOfComputer = 8;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 9 && numberOfPlayer[i] == 8) {
                        numberOfComputer = 7;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer)); // an o xrhsths evale sthn prwth kinhsh sto 9o keli   
                    }
                } else if (i == 2) {
                    if (numberOfPlayer[0] == 1 && numberOfPlayer[1] == 2 && numberOfPlayer[i] == 4
                            || numberOfPlayer[0] == 1 && numberOfPlayer[1] == 2 && numberOfPlayer[i] == 6
                            || numberOfPlayer[0] == 1 && numberOfPlayer[1] == 2 && numberOfPlayer[i] == 8
                            || numberOfPlayer[0] == 1 && numberOfPlayer[1] == 2 && numberOfPlayer[i] == 9) {
                        numberOfComputer = 7;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 1 && numberOfPlayer[1] == 2 && numberOfPlayer[i] == 7) {
                        numberOfComputer = 4;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer)); // 1 - 2 - ola
                    } else if (numberOfPlayer[0] == 1 && numberOfPlayer[1] == 3 && numberOfPlayer[i] == 4
                            || numberOfPlayer[0] == 1 && numberOfPlayer[1] == 3 && numberOfPlayer[i] == 6
                            || numberOfPlayer[0] == 1 && numberOfPlayer[1] == 3 && numberOfPlayer[i] == 7
                            || numberOfPlayer[0] == 1 && numberOfPlayer[1] == 3 && numberOfPlayer[i] == 9) {
                        numberOfComputer = 8;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 1 && numberOfPlayer[1] == 3 && numberOfPlayer[i] == 8) {
                        numberOfComputer = 6;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer)); // 1 - 3 - ola
                    } else if (numberOfPlayer[0] == 1 && numberOfPlayer[1] == 4 && numberOfPlayer[i] == 2
                            || numberOfPlayer[0] == 1 && numberOfPlayer[1] == 4 && numberOfPlayer[i] == 6
                            || numberOfPlayer[0] == 1 && numberOfPlayer[1] == 4 && numberOfPlayer[i] == 8
                            || numberOfPlayer[0] == 1 && numberOfPlayer[1] == 4 && numberOfPlayer[i] == 9) {
                        numberOfComputer = 3;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 1 && numberOfPlayer[1] == 4 && numberOfPlayer[i] == 3) {
                        numberOfComputer = 2;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer)); // 1 - 4 - ola
                    } else if (numberOfPlayer[0] == 1 && numberOfPlayer[1] == 6 && numberOfPlayer[i] == 3
                            || numberOfPlayer[0] == 1 && numberOfPlayer[1] == 6 && numberOfPlayer[i] == 4
                            || numberOfPlayer[0] == 1 && numberOfPlayer[1] == 6 && numberOfPlayer[i] == 7
                            || numberOfPlayer[0] == 1 && numberOfPlayer[1] == 6 && numberOfPlayer[i] == 9) {
                        numberOfComputer = 2;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 1 && numberOfPlayer[1] == 6 && numberOfPlayer[i] == 2) {
                        numberOfComputer = 3;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer)); // 1 - 6 - ola
                    } else if (numberOfPlayer[0] == 1 && numberOfPlayer[1] == 7 && numberOfPlayer[i] == 2
                            || numberOfPlayer[0] == 1 && numberOfPlayer[1] == 7 && numberOfPlayer[i] == 3
                            || numberOfPlayer[0] == 1 && numberOfPlayer[1] == 7 && numberOfPlayer[i] == 8
                            || numberOfPlayer[0] == 1 && numberOfPlayer[1] == 7 && numberOfPlayer[i] == 9) {
                        numberOfComputer = 6;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 1 && numberOfPlayer[1] == 7 && numberOfPlayer[i] == 6) {
                        numberOfComputer = 9;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer)); // 1 - 7 - ola
                    } else if (numberOfPlayer[0] == 1 && numberOfPlayer[1] == 8 && numberOfPlayer[i] == 2
                            || numberOfPlayer[0] == 1 && numberOfPlayer[1] == 8 && numberOfPlayer[i] == 3
                            || numberOfPlayer[0] == 1 && numberOfPlayer[1] == 8 && numberOfPlayer[i] == 7
                            || numberOfPlayer[0] == 1 && numberOfPlayer[1] == 8 && numberOfPlayer[i] == 9) {
                        numberOfComputer = 4;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 1 && numberOfPlayer[1] == 8 && numberOfPlayer[i] == 4) {
                        numberOfComputer = 7;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer)); // 1 - 8 - ola
                    } else if (numberOfPlayer[0] == 1 && numberOfPlayer[1] == 9 && numberOfPlayer[i] == 3
                            || numberOfPlayer[0] == 1 && numberOfPlayer[1] == 9 && numberOfPlayer[i] == 4
                            || numberOfPlayer[0] == 1 && numberOfPlayer[1] == 9 && numberOfPlayer[i] == 6
                            || numberOfPlayer[0] == 1 && numberOfPlayer[1] == 9 && numberOfPlayer[i] == 7) {
                        numberOfComputer = 8;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 1 && numberOfPlayer[1] == 9 && numberOfPlayer[i] == 8) {
                        numberOfComputer = 7;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer)); // 1 - 9 - ola
                    } else if (numberOfPlayer[0] == 2 && numberOfPlayer[1] == 1 && numberOfPlayer[i] == 4) {
                        numberOfComputer = 7;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 2 && numberOfPlayer[1] == 1 && numberOfPlayer[i] == 5) {
                        numberOfComputer = 9;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 2 && numberOfPlayer[1] == 1 && numberOfPlayer[i] == 6) {
                        numberOfComputer = 7;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 2 && numberOfPlayer[1] == 1 && numberOfPlayer[i] == 7) {
                        numberOfComputer = 4;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 2 && numberOfPlayer[1] == 1 && numberOfPlayer[i] == 9) {
                        numberOfComputer = 5;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));// 2 - 1 - ola
                    } else if (numberOfPlayer[0] == 2 && numberOfPlayer[1] == 3 && numberOfPlayer[i] == 4) {
                        numberOfComputer = 9;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 2 && numberOfPlayer[1] == 3 && numberOfPlayer[i] == 5) {
                        numberOfComputer = 7;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 2 && numberOfPlayer[1] == 3 && numberOfPlayer[i] == 6) {
                        numberOfComputer = 9;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 2 && numberOfPlayer[1] == 3 && numberOfPlayer[i] == 7) {
                        numberOfComputer = 5;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 2 && numberOfPlayer[1] == 3 && numberOfPlayer[i] == 9) {
                        numberOfComputer = 6;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));// 2 - 3 - ola
                    } else if (numberOfPlayer[0] == 2 && numberOfPlayer[1] == 4 && numberOfPlayer[i] == 3) {
                        numberOfComputer = 9;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 2 && numberOfPlayer[1] == 4 && numberOfPlayer[i] == 5) {
                        numberOfComputer = 6;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 2 && numberOfPlayer[1] == 4 && numberOfPlayer[i] == 6) {
                        numberOfComputer = 5;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 2 && numberOfPlayer[1] == 4 && numberOfPlayer[i] == 7) {
                        numberOfComputer = 3;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 2 && numberOfPlayer[1] == 4 && numberOfPlayer[i] == 9) {
                        numberOfComputer = 5;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));// 2 - 4 ola
                    } else if (numberOfPlayer[0] == 2 && numberOfPlayer[1] == 5 && numberOfPlayer[i] == 1) {
                        numberOfComputer = 9;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 2 && numberOfPlayer[1] == 5 && numberOfPlayer[i] == 4) {
                        numberOfComputer = 6;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 2 && numberOfPlayer[1] == 5 && numberOfPlayer[i] == 6) {
                        numberOfComputer = 4;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 2 && numberOfPlayer[1] == 5 && numberOfPlayer[i] == 7) {
                        numberOfComputer = 1;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 2 && numberOfPlayer[1] == 5 && numberOfPlayer[i] == 9) {
                        numberOfComputer = 1;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer)); // 2 - 5 - ola
                    } else if (numberOfPlayer[0] == 2 && numberOfPlayer[1] == 6 && numberOfPlayer[i] == 1) {
                        numberOfComputer = 7;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 2 && numberOfPlayer[1] == 6 && numberOfPlayer[i] == 4) {
                        numberOfComputer = 5;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 2 && numberOfPlayer[1] == 6 && numberOfPlayer[i] == 5) {
                        numberOfComputer = 4;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 2 && numberOfPlayer[1] == 6 && numberOfPlayer[i] == 7) {
                        numberOfComputer = 5;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 2 && numberOfPlayer[1] == 6 && numberOfPlayer[i] == 9) {
                        numberOfComputer = 1;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer)); // 2 - 6 - ola
                    } else if (numberOfPlayer[0] == 2 && numberOfPlayer[1] == 7 && numberOfPlayer[i] == 3) {
                        numberOfComputer = 5;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 2 && numberOfPlayer[1] == 7 && numberOfPlayer[i] == 4) {
                        numberOfComputer = 3;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 2 && numberOfPlayer[1] == 7 && numberOfPlayer[i] == 5) {
                        numberOfComputer = 3;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 2 && numberOfPlayer[1] == 7 && numberOfPlayer[i] == 6) {
                        numberOfComputer = 5;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 2 && numberOfPlayer[1] == 7 && numberOfPlayer[i] == 9) {
                        numberOfComputer = 5;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer)); // 2 - 7 - ola
                    } else if (numberOfPlayer[0] == 2 && numberOfPlayer[1] == 9 && numberOfPlayer[i] == 1) {
                        numberOfComputer = 5;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 2 && numberOfPlayer[1] == 9 && numberOfPlayer[i] == 4) {
                        numberOfComputer = 5;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 2 && numberOfPlayer[1] == 9 && numberOfPlayer[i] == 5) {
                        numberOfComputer = 1;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 2 && numberOfPlayer[1] == 9 && numberOfPlayer[i] == 6) {
                        numberOfComputer = 1;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 2 && numberOfPlayer[1] == 9 && numberOfPlayer[i] == 7) {
                        numberOfComputer = 5;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer)); // 2 - 9 - ola
                    } else if (numberOfPlayer[0] == 3 && numberOfPlayer[1] == 1 && numberOfPlayer[i] == 4
                            || numberOfPlayer[0] == 3 && numberOfPlayer[1] == 1 && numberOfPlayer[i] == 6
                            || numberOfPlayer[0] == 3 && numberOfPlayer[1] == 1 && numberOfPlayer[i] == 7
                            || numberOfPlayer[0] == 3 && numberOfPlayer[1] == 1 && numberOfPlayer[i] == 9) {
                        numberOfComputer = 8;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 3 && numberOfPlayer[1] == 1 && numberOfPlayer[i] == 8) {
                        numberOfComputer = 9;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer)); // 3 - 1 - ola                       
                    } else if (numberOfPlayer[0] == 3 && numberOfPlayer[1] == 2 && numberOfPlayer[i] == 4
                            || numberOfPlayer[0] == 3 && numberOfPlayer[1] == 2 && numberOfPlayer[i] == 6
                            || numberOfPlayer[0] == 3 && numberOfPlayer[1] == 2 && numberOfPlayer[i] == 7
                            || numberOfPlayer[0] == 3 && numberOfPlayer[1] == 2 && numberOfPlayer[i] == 8) {
                        numberOfComputer = 9;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 3 && numberOfPlayer[1] == 2 && numberOfPlayer[i] == 9) {
                        numberOfComputer = 6;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));   // 3 - 2 - ola 
                    } else if (numberOfPlayer[0] == 3 && numberOfPlayer[1] == 4 && numberOfPlayer[i] == 1
                            || numberOfPlayer[0] == 3 && numberOfPlayer[1] == 4 && numberOfPlayer[i] == 6
                            || numberOfPlayer[0] == 3 && numberOfPlayer[1] == 4 && numberOfPlayer[i] == 7
                            || numberOfPlayer[0] == 3 && numberOfPlayer[1] == 4 && numberOfPlayer[i] == 9) {
                        numberOfComputer = 2;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 3 && numberOfPlayer[1] == 4 && numberOfPlayer[i] == 2) {
                        numberOfComputer = 1;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));  // 3 - 4 - ola 
                    } else if (numberOfPlayer[0] == 3 && numberOfPlayer[1] == 6 && numberOfPlayer[i] == 2
                            || numberOfPlayer[0] == 3 && numberOfPlayer[1] == 6 && numberOfPlayer[i] == 4
                            || numberOfPlayer[0] == 3 && numberOfPlayer[1] == 6 && numberOfPlayer[i] == 7
                            || numberOfPlayer[0] == 3 && numberOfPlayer[1] == 6 && numberOfPlayer[i] == 8) {
                        numberOfComputer = 1;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 3 && numberOfPlayer[1] == 6 && numberOfPlayer[i] == 1) {
                        numberOfComputer = 2;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer)); // 3 - 6 - ola
                    } else if (numberOfPlayer[0] == 3 && numberOfPlayer[1] == 7 && numberOfPlayer[i] == 1
                            || numberOfPlayer[0] == 3 && numberOfPlayer[1] == 7 && numberOfPlayer[i] == 2
                            || numberOfPlayer[0] == 3 && numberOfPlayer[1] == 7 && numberOfPlayer[i] == 6
                            || numberOfPlayer[0] == 3 && numberOfPlayer[1] == 7 && numberOfPlayer[i] == 9) {
                        numberOfComputer = 8;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 3 && numberOfPlayer[1] == 7 && numberOfPlayer[i] == 8) {
                        numberOfComputer = 9;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer)); // 3 - 7 - ola
                    } else if (numberOfPlayer[0] == 3 && numberOfPlayer[1] == 8 && numberOfPlayer[i] == 1
                            || numberOfPlayer[0] == 3 && numberOfPlayer[1] == 8 && numberOfPlayer[i] == 2
                            || numberOfPlayer[0] == 3 && numberOfPlayer[1] == 8 && numberOfPlayer[i] == 7
                            || numberOfPlayer[0] == 3 && numberOfPlayer[1] == 8 && numberOfPlayer[i] == 9) {
                        numberOfComputer = 6;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 3 && numberOfPlayer[1] == 8 && numberOfPlayer[i] == 6) {
                        numberOfComputer = 9;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));  // 3 - 8 - ola
                    } else if (numberOfPlayer[0] == 3 && numberOfPlayer[1] == 9 && numberOfPlayer[i] == 1
                            || numberOfPlayer[0] == 3 && numberOfPlayer[1] == 9 && numberOfPlayer[i] == 2
                            || numberOfPlayer[0] == 3 && numberOfPlayer[1] == 9 && numberOfPlayer[i] == 7
                            || numberOfPlayer[0] == 3 && numberOfPlayer[1] == 9 && numberOfPlayer[i] == 8) {
                        numberOfComputer = 4;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 4 && numberOfPlayer[1] == 1 && numberOfPlayer[i] == 2) {
                        numberOfComputer = 3;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer)); // 3 - 9 - ola
                    } else if (numberOfPlayer[0] == 4 && numberOfPlayer[1] == 1 && numberOfPlayer[i] == 3) {
                        numberOfComputer = 2;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 4 && numberOfPlayer[1] == 1 && numberOfPlayer[i] == 5) {
                        numberOfComputer = 9;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 4 && numberOfPlayer[1] == 1 && numberOfPlayer[i] == 8) {
                        numberOfComputer = 3;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 4 && numberOfPlayer[1] == 1 && numberOfPlayer[i] == 9) {
                        numberOfComputer = 5;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer)); // 4 - 1 - ola
                    } else if (numberOfPlayer[0] == 4 && numberOfPlayer[1] == 2 && numberOfPlayer[i] == 3) {
                        numberOfComputer = 8;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 4 && numberOfPlayer[1] == 2 && numberOfPlayer[i] == 5) {
                        numberOfComputer = 8;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 4 && numberOfPlayer[1] == 2 && numberOfPlayer[i] == 7) {
                        numberOfComputer = 9;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 4 && numberOfPlayer[1] == 2 && numberOfPlayer[i] == 8) {
                        numberOfComputer = 5;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 4 && numberOfPlayer[1] == 2 && numberOfPlayer[i] == 9) {
                        numberOfComputer = 7;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer)); // 4 - 2 - ola
                    } else if (numberOfPlayer[0] == 4 && numberOfPlayer[1] == 3 && numberOfPlayer[i] == 2) {
                        numberOfComputer = 5;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 4 && numberOfPlayer[1] == 3 && numberOfPlayer[i] == 5) {
                        numberOfComputer = 7;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 4 && numberOfPlayer[1] == 3 && numberOfPlayer[i] == 7) {
                        numberOfComputer = 5;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 4 && numberOfPlayer[1] == 3 && numberOfPlayer[i] == 8) {
                        numberOfComputer = 7;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 4 && numberOfPlayer[1] == 3 && numberOfPlayer[i] == 9) {
                        numberOfComputer = 7;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer)); // 4 - 3 - ola
                    } else if (numberOfPlayer[0] == 4 && numberOfPlayer[1] == 5 && numberOfPlayer[i] == 1
                            || numberOfPlayer[0] == 4 && numberOfPlayer[1] == 5 && numberOfPlayer[i] == 2
                            || numberOfPlayer[0] == 4 && numberOfPlayer[1] == 5 && numberOfPlayer[i] == 7
                            || numberOfPlayer[0] == 4 && numberOfPlayer[1] == 5 && numberOfPlayer[i] == 8) {
                        numberOfComputer = 3;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 4 && numberOfPlayer[1] == 5 && numberOfPlayer[i] == 3) {
                        numberOfComputer = 7;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer)); // 4 - 5 - ola
                    } else if (numberOfPlayer[0] == 4 && numberOfPlayer[1] == 7 && numberOfPlayer[i] == 2) {
                        numberOfComputer = 9;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 4 && numberOfPlayer[1] == 7 && numberOfPlayer[i] == 3) {
                        numberOfComputer = 5;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 4 && numberOfPlayer[1] == 7 && numberOfPlayer[i] == 5) {
                        numberOfComputer = 3;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 4 && numberOfPlayer[1] == 7 && numberOfPlayer[i] == 8) {
                        numberOfComputer = 9;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 4 && numberOfPlayer[1] == 7 && numberOfPlayer[i] == 9) {
                        numberOfComputer = 8;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer)); // 4 - 7 - ola
                    } else if (numberOfPlayer[0] == 4 && numberOfPlayer[1] == 8 && numberOfPlayer[i] == 2) {
                        numberOfComputer = 5;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 4 && numberOfPlayer[1] == 8 && numberOfPlayer[i] == 3) {
                        numberOfComputer = 7;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 4 && numberOfPlayer[1] == 8 && numberOfPlayer[i] == 5) {
                        numberOfComputer = 2;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 4 && numberOfPlayer[1] == 8 && numberOfPlayer[i] == 7) {
                        numberOfComputer = 9;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 4 && numberOfPlayer[1] == 8 && numberOfPlayer[i] == 9) {
                        numberOfComputer = 7;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer)); // 4 - 8 - ola
                    } else if (numberOfPlayer[0] == 4 && numberOfPlayer[1] == 9 && numberOfPlayer[i] == 1) {
                        numberOfComputer = 5;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 4 && numberOfPlayer[1] == 9 && numberOfPlayer[i] == 2) {
                        numberOfComputer = 1;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 4 && numberOfPlayer[1] == 9 && numberOfPlayer[i] == 3) {
                        numberOfComputer = 1;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 4 && numberOfPlayer[1] == 9 && numberOfPlayer[i] == 5) {
                        numberOfComputer = 1;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 4 && numberOfPlayer[1] == 9 && numberOfPlayer[i] == 8) {
                        numberOfComputer = 5;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer)); // 4 - 9 - ola
                    } else if (numberOfPlayer[0] == 5 && numberOfPlayer[1] == 2 && numberOfPlayer[i] == 3) {
                        numberOfComputer = 7;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 5 && numberOfPlayer[1] == 2 && numberOfPlayer[i] == 4) {
                        numberOfComputer = 6;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 5 && numberOfPlayer[1] == 2 && numberOfPlayer[i] == 6) {
                        numberOfComputer = 4;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 5 && numberOfPlayer[1] == 2 && numberOfPlayer[i] == 7) {
                        numberOfComputer = 3;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 5 && numberOfPlayer[1] == 2 && numberOfPlayer[i] == 9) {
                        numberOfComputer = 4;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer)); // 5 - 2 - ola
                    } else if (numberOfPlayer[0] == 5 && numberOfPlayer[1] == 3 && numberOfPlayer[i] == 2
                            || numberOfPlayer[0] == 5 && numberOfPlayer[1] == 3 && numberOfPlayer[i] == 6
                            || numberOfPlayer[0] == 5 && numberOfPlayer[1] == 3 && numberOfPlayer[i] == 8
                            || numberOfPlayer[0] == 5 && numberOfPlayer[1] == 3 && numberOfPlayer[i] == 9) {
                        numberOfComputer = 4;
                        tictactoeArray[numberOfComputer] = "O";
                    } else if (numberOfPlayer[0] == 5 && numberOfPlayer[1] == 3 && numberOfPlayer[i] == 4) {
                        numberOfComputer = 6;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));    // 5 - 3 - ola
                    } else if (numberOfPlayer[0] == 5 && numberOfPlayer[1] == 4 && numberOfPlayer[i] == 2) {
                        numberOfComputer = 8;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 5 && numberOfPlayer[1] == 4 && numberOfPlayer[i] == 3) {
                        numberOfComputer = 7;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 5 && numberOfPlayer[1] == 4 && numberOfPlayer[i] == 7) {
                        numberOfComputer = 3;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 5 && numberOfPlayer[1] == 4 && numberOfPlayer[i] == 8) {
                        numberOfComputer = 2;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 5 && numberOfPlayer[1] == 4 && numberOfPlayer[i] == 9) {
                        numberOfComputer = 2;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer)); // 5 - 4 - ola    
                    } else if (numberOfPlayer[0] == 5 && numberOfPlayer[1] == 6 && numberOfPlayer[i] == 2
                            || numberOfPlayer[0] == 5 && numberOfPlayer[1] == 6 && numberOfPlayer[i] == 3
                            || numberOfPlayer[0] == 5 && numberOfPlayer[1] == 6 && numberOfPlayer[i] == 7
                            || numberOfPlayer[0] == 5 && numberOfPlayer[1] == 6 && numberOfPlayer[i] == 8) {
                        numberOfComputer = 7;
                        tictactoeArray[numberOfComputer] = "O";
                    } else if (numberOfPlayer[0] == 5 && numberOfPlayer[1] == 6 && numberOfPlayer[i] == 7) {
                        numberOfComputer = 3;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer)); // 5 - 6 - ola
                    } else if (numberOfPlayer[0] == 5 && numberOfPlayer[1] == 7 && numberOfPlayer[i] == 4
                            || numberOfPlayer[0] == 5 && numberOfPlayer[1] == 7 && numberOfPlayer[i] == 6
                            || numberOfPlayer[0] == 5 && numberOfPlayer[1] == 7 && numberOfPlayer[i] == 7
                            || numberOfPlayer[0] == 5 && numberOfPlayer[1] == 7 && numberOfPlayer[i] == 8) {
                        numberOfComputer = 2;
                        tictactoeArray[numberOfComputer] = "O";
                    } else if (numberOfPlayer[0] == 5 && numberOfPlayer[1] == 7 && numberOfPlayer[i] == 2) {
                        numberOfComputer = 8;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));    // 5 - 7 - ola
                    } else if (numberOfPlayer[0] == 5 && numberOfPlayer[1] == 8 && numberOfPlayer[i] == 4
                            || numberOfPlayer[0] == 5 && numberOfPlayer[1] == 8 && numberOfPlayer[i] == 6
                            || numberOfPlayer[0] == 5 && numberOfPlayer[1] == 8 && numberOfPlayer[i] == 7
                            || numberOfPlayer[0] == 5 && numberOfPlayer[1] == 8 && numberOfPlayer[i] == 9) {
                        numberOfComputer = 3;
                        tictactoeArray[numberOfComputer] = "O";
                    } else if (numberOfPlayer[0] == 5 && numberOfPlayer[1] == 8 && numberOfPlayer[i] == 3) {
                        numberOfComputer = 7;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer)); // 5 - 8 - ola
                    } else if (numberOfPlayer[0] == 5 && numberOfPlayer[1] == 9 && numberOfPlayer[i] == 2
                            || numberOfPlayer[0] == 5 && numberOfPlayer[1] == 9 && numberOfPlayer[i] == 3
                            || numberOfPlayer[0] == 5 && numberOfPlayer[1] == 9 && numberOfPlayer[i] == 6
                            || numberOfPlayer[0] == 5 && numberOfPlayer[1] == 9 && numberOfPlayer[i] == 8) {
                        numberOfComputer = 4;
                        tictactoeArray[numberOfComputer] = "O";
                    } else if (numberOfPlayer[0] == 5 && numberOfPlayer[1] == 9 && numberOfPlayer[i] == 4) {
                        numberOfComputer = 6;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));   // 5 - 9 - telos
                    } else if (numberOfPlayer[0] == 6 && numberOfPlayer[1] == 1 && numberOfPlayer[i] == 2) {
                        numberOfComputer = 5;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 6 && numberOfPlayer[1] == 1 && numberOfPlayer[i] == 5) {
                        numberOfComputer = 9;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 6 && numberOfPlayer[1] == 1 && numberOfPlayer[i] == 7) {
                        numberOfComputer = 9;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 6 && numberOfPlayer[1] == 1 && numberOfPlayer[i] == 8) {
                        numberOfComputer = 9;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 6 && numberOfPlayer[1] == 1 && numberOfPlayer[i] == 9) {
                        numberOfComputer = 5;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));   // 6 - 1 - ola  
                    } else if (numberOfPlayer[0] == 6 && numberOfPlayer[1] == 2 && numberOfPlayer[i] == 1) {
                        numberOfComputer = 3;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 6 && numberOfPlayer[1] == 2 && numberOfPlayer[i] == 3) {
                        numberOfComputer = 1;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 6 && numberOfPlayer[1] == 2 && numberOfPlayer[i] == 5) {
                        numberOfComputer = 8;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 6 && numberOfPlayer[1] == 2 && numberOfPlayer[i] == 7) {
                        numberOfComputer = 3;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 6 && numberOfPlayer[1] == 2 && numberOfPlayer[i] == 8) {
                        numberOfComputer = 5;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));  // 6 - 2 - ola
                    } else if (numberOfPlayer[0] == 6 && numberOfPlayer[1] == 3 && numberOfPlayer[i] == 1) {
                        numberOfComputer = 2;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 6 && numberOfPlayer[1] == 3 && numberOfPlayer[i] == 2) {
                        numberOfComputer = 1;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 6 && numberOfPlayer[1] == 3 && numberOfPlayer[i] == 5) {
                        numberOfComputer = 7;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 6 && numberOfPlayer[1] == 3 && numberOfPlayer[i] == 7) {
                        numberOfComputer = 5;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 6 && numberOfPlayer[1] == 3 && numberOfPlayer[i] == 8) {
                        numberOfComputer = 1;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer)); // 6 - 3 - ola
                    } else if (numberOfPlayer[0] == 6 && numberOfPlayer[1] == 5 && numberOfPlayer[i] == 2
                            || numberOfPlayer[0] == 6 && numberOfPlayer[1] == 5 && numberOfPlayer[i] == 3
                            || numberOfPlayer[0] == 6 && numberOfPlayer[1] == 5 && numberOfPlayer[i] == 7
                            || numberOfPlayer[0] == 6 && numberOfPlayer[1] == 5 && numberOfPlayer[i] == 8) {
                        numberOfComputer = 1;
                        tictactoeArray[numberOfComputer] = "O";
                    } else if (numberOfPlayer[0] == 6 && numberOfPlayer[1] == 5 && numberOfPlayer[i] == 1) {
                        numberOfComputer = 9;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer)); // 6 - 5 - ola
                    } else if (numberOfPlayer[0] == 6 && numberOfPlayer[1] == 7 && numberOfPlayer[i] == 1) {
                        numberOfComputer = 3;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 6 && numberOfPlayer[1] == 7 && numberOfPlayer[i] == 2) {
                        numberOfComputer = 3;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 6 && numberOfPlayer[1] == 7 && numberOfPlayer[i] == 3) {
                        numberOfComputer = 5;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 6 && numberOfPlayer[1] == 7 && numberOfPlayer[i] == 5) {
                        numberOfComputer = 3;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 6 && numberOfPlayer[1] == 7 && numberOfPlayer[i] == 8) {
                        numberOfComputer = 5;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));    // 6 - 7 - ola
                    } else if (numberOfPlayer[0] == 6 && numberOfPlayer[1] == 8 && numberOfPlayer[i] == 1) {
                        numberOfComputer = 9;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 6 && numberOfPlayer[1] == 8 && numberOfPlayer[i] == 2) {
                        numberOfComputer = 5;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 6 && numberOfPlayer[1] == 8 && numberOfPlayer[i] == 5) {
                        numberOfComputer = 2;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 6 && numberOfPlayer[1] == 8 && numberOfPlayer[i] == 7) {
                        numberOfComputer = 9;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 6 && numberOfPlayer[1] == 8 && numberOfPlayer[i] == 9) {
                        numberOfComputer = 7;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));    // 6 - 8 - ola
                    } else if (numberOfPlayer[0] == 6 && numberOfPlayer[1] == 9 && numberOfPlayer[i] == 1) {
                        numberOfComputer = 5;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 6 && numberOfPlayer[1] == 9 && numberOfPlayer[i] == 2) {
                        numberOfComputer = 7;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 6 && numberOfPlayer[1] == 9 && numberOfPlayer[i] == 5) {
                        numberOfComputer = 1;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 6 && numberOfPlayer[1] == 9 && numberOfPlayer[i] == 7) {
                        numberOfComputer = 8;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 6 && numberOfPlayer[1] == 9 && numberOfPlayer[i] == 8) {
                        numberOfComputer = 7;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));    // 6 - 9 - ola
                    } else if (numberOfPlayer[0] == 7 && numberOfPlayer[1] == 1 && numberOfPlayer[i] == 2
                            || numberOfPlayer[0] == 7 && numberOfPlayer[1] == 1 && numberOfPlayer[i] == 3
                            || numberOfPlayer[0] == 7 && numberOfPlayer[1] == 1 && numberOfPlayer[i] == 8
                            || numberOfPlayer[0] == 7 && numberOfPlayer[1] == 1 && numberOfPlayer[i] == 9) {
                        numberOfComputer = 6;
                        tictactoeArray[numberOfComputer] = "O";
                    } else if (numberOfPlayer[0] == 7 && numberOfPlayer[1] == 1 && numberOfPlayer[i] == 6) {
                        numberOfComputer = 8;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));   // 7 - 1 - ola 
                    } else if (numberOfPlayer[0] == 7 && numberOfPlayer[1] == 2 && numberOfPlayer[i] == 1
                            || numberOfPlayer[0] == 7 && numberOfPlayer[1] == 2 && numberOfPlayer[i] == 3
                            || numberOfPlayer[0] == 7 && numberOfPlayer[1] == 2 && numberOfPlayer[i] == 8
                            || numberOfPlayer[0] == 7 && numberOfPlayer[1] == 2 && numberOfPlayer[i] == 9) {
                        numberOfComputer = 4;
                        tictactoeArray[numberOfComputer] = "O";
                    } else if (numberOfPlayer[0] == 7 && numberOfPlayer[1] == 2 && numberOfPlayer[i] == 4) {
                        numberOfComputer = 1;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer)); // 7 - 2 - ola
                    } else if (numberOfPlayer[0] == 7 && numberOfPlayer[1] == 3 && numberOfPlayer[i] == 1
                            || numberOfPlayer[0] == 7 && numberOfPlayer[1] == 3 && numberOfPlayer[i] == 4
                            || numberOfPlayer[0] == 7 && numberOfPlayer[1] == 3 && numberOfPlayer[i] == 6
                            || numberOfPlayer[0] == 7 && numberOfPlayer[1] == 3 && numberOfPlayer[i] == 9) {
                        numberOfComputer = 8;
                        tictactoeArray[numberOfComputer] = "O";
                    } else if (numberOfPlayer[0] == 7 && numberOfPlayer[1] == 3 && numberOfPlayer[i] == 8) {
                        numberOfComputer = 9;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer)); // 7 - 3 - ola
                    } else if (numberOfPlayer[0] == 7 && numberOfPlayer[1] == 4 && numberOfPlayer[i] == 2
                            || numberOfPlayer[0] == 7 && numberOfPlayer[1] == 4 && numberOfPlayer[i] == 3
                            || numberOfPlayer[0] == 7 && numberOfPlayer[1] == 4 && numberOfPlayer[i] == 6
                            || numberOfPlayer[0] == 7 && numberOfPlayer[1] == 4 && numberOfPlayer[i] == 8) {
                        numberOfComputer = 9;
                        tictactoeArray[numberOfComputer] = "O";
                    } else if (numberOfPlayer[0] == 7 && numberOfPlayer[1] == 4 && numberOfPlayer[i] == 9) {
                        numberOfComputer = 8;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));  // 7 - 4 - ola  
                    } else if (numberOfPlayer[0] == 7 && numberOfPlayer[1] == 6 && numberOfPlayer[i] == 1
                            || numberOfPlayer[0] == 7 && numberOfPlayer[1] == 6 && numberOfPlayer[i] == 3
                            || numberOfPlayer[0] == 7 && numberOfPlayer[1] == 6 && numberOfPlayer[i] == 4
                            || numberOfPlayer[0] == 7 && numberOfPlayer[1] == 6 && numberOfPlayer[i] == 9) {
                        numberOfComputer = 8;
                        tictactoeArray[numberOfComputer] = "O";
                    } else if (numberOfPlayer[0] == 7 && numberOfPlayer[1] == 6 && numberOfPlayer[i] == 8) {
                        numberOfComputer = 9;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));  // 7 - 6 - ola
                    } else if (numberOfPlayer[0] == 7 && numberOfPlayer[1] == 8 && numberOfPlayer[i] == 2
                            || numberOfPlayer[0] == 7 && numberOfPlayer[1] == 8 && numberOfPlayer[i] == 3
                            || numberOfPlayer[0] == 7 && numberOfPlayer[1] == 8 && numberOfPlayer[i] == 4
                            || numberOfPlayer[0] == 7 && numberOfPlayer[1] == 8 && numberOfPlayer[i] == 6) {
                        numberOfComputer = 1;
                        tictactoeArray[numberOfComputer] = "O";
                    } else if (numberOfPlayer[0] == 7 && numberOfPlayer[1] == 8 && numberOfPlayer[i] == 1) {
                        numberOfComputer = 4;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));  // 7 - 8 - ola  
                    } else if (numberOfPlayer[0] == 7 && numberOfPlayer[1] == 9 && numberOfPlayer[i] == 1
                            || numberOfPlayer[0] == 7 && numberOfPlayer[1] == 9 && numberOfPlayer[i] == 3
                            || numberOfPlayer[0] == 7 && numberOfPlayer[1] == 9 && numberOfPlayer[i] == 4
                            || numberOfPlayer[0] == 7 && numberOfPlayer[1] == 9 && numberOfPlayer[i] == 6) {
                        numberOfComputer = 2;
                        tictactoeArray[numberOfComputer] = "O";
                    } else if (numberOfPlayer[0] == 7 && numberOfPlayer[1] == 9 && numberOfPlayer[i] == 2) {
                        numberOfComputer = 6;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));    // 7 - 9 - ola
                    } else if (numberOfPlayer[0] == 8 && numberOfPlayer[1] == 1 && numberOfPlayer[i] == 3) {
                        numberOfComputer = 9;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 8 && numberOfPlayer[1] == 1 && numberOfPlayer[i] == 4) {
                        numberOfComputer = 5;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 8 && numberOfPlayer[1] == 1 && numberOfPlayer[i] == 5) {
                        numberOfComputer = 9;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 8 && numberOfPlayer[1] == 1 && numberOfPlayer[i] == 6) {
                        numberOfComputer = 9;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 8 && numberOfPlayer[1] == 1 && numberOfPlayer[i] == 9) {
                        numberOfComputer = 5;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));  // 8 - 1 - ola   
                    } else if (numberOfPlayer[0] == 8 && numberOfPlayer[1] == 3 && numberOfPlayer[i] == 1) {
                        numberOfComputer = 7;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 8 && numberOfPlayer[1] == 3 && numberOfPlayer[i] == 4) {
                        numberOfComputer = 7;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 8 && numberOfPlayer[1] == 3 && numberOfPlayer[i] == 5) {
                        numberOfComputer = 7;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 8 && numberOfPlayer[1] == 3 && numberOfPlayer[i] == 6) {
                        numberOfComputer = 5;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 8 && numberOfPlayer[1] == 3 && numberOfPlayer[i] == 7) {
                        numberOfComputer = 5;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer)); // 8 - 3 - ola
                    } else if (numberOfPlayer[0] == 8 && numberOfPlayer[1] == 4 && numberOfPlayer[i] == 1) {
                        numberOfComputer = 7;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 8 && numberOfPlayer[1] == 4 && numberOfPlayer[i] == 3) {
                        numberOfComputer = 7;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 8 && numberOfPlayer[1] == 4 && numberOfPlayer[i] == 5) {
                        numberOfComputer = 6;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 8 && numberOfPlayer[1] == 4 && numberOfPlayer[i] == 6) {
                        numberOfComputer = 5;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 8 && numberOfPlayer[1] == 4 && numberOfPlayer[i] == 7) {
                        numberOfComputer = 1;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));  // 8 - 4 - ola 
                    } else if (numberOfPlayer[0] == 8 && numberOfPlayer[1] == 5 && numberOfPlayer[i] == 4
                            || numberOfPlayer[0] == 8 && numberOfPlayer[1] == 5 && numberOfPlayer[i] == 6
                            || numberOfPlayer[0] == 8 && numberOfPlayer[1] == 5 && numberOfPlayer[i] == 7
                            || numberOfPlayer[0] == 8 && numberOfPlayer[1] == 5 && numberOfPlayer[i] == 9) {
                        numberOfComputer = 1;
                        tictactoeArray[numberOfComputer] = "O";
                    } else if (numberOfPlayer[0] == 8 && numberOfPlayer[1] == 5 && numberOfPlayer[i] == 1) {
                        numberOfComputer = 9;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer)); // 8 - 5 - ola
                    } else if (numberOfPlayer[0] == 8 && numberOfPlayer[1] == 6 && numberOfPlayer[i] == 1) {
                        numberOfComputer = 9;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 8 && numberOfPlayer[1] == 6 && numberOfPlayer[i] == 3) {
                        numberOfComputer = 9;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 8 && numberOfPlayer[1] == 6 && numberOfPlayer[i] == 4) {
                        numberOfComputer = 5;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 8 && numberOfPlayer[1] == 6 && numberOfPlayer[i] == 5) {
                        numberOfComputer = 4;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 8 && numberOfPlayer[1] == 6 && numberOfPlayer[i] == 9) {
                        numberOfComputer = 3;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer)); // 8 - 6 - ola   
                    } else if (numberOfPlayer[0] == 8 && numberOfPlayer[1] == 7 && numberOfPlayer[i] == 1) {
                        numberOfComputer = 4;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 8 && numberOfPlayer[1] == 7 && numberOfPlayer[i] == 3) {
                        numberOfComputer = 5;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 8 && numberOfPlayer[1] == 7 && numberOfPlayer[i] == 4) {
                        numberOfComputer = 1;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 8 && numberOfPlayer[1] == 7 && numberOfPlayer[i] == 5) {
                        numberOfComputer = 3;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 8 && numberOfPlayer[1] == 7 && numberOfPlayer[i] == 6) {
                        numberOfComputer = 1;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer)); // 8 - 7 - ola
                    } else if (numberOfPlayer[0] == 8 && numberOfPlayer[1] == 9 && numberOfPlayer[i] == 1) {
                        numberOfComputer = 5;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 8 && numberOfPlayer[1] == 9 && numberOfPlayer[i] == 3) {
                        numberOfComputer = 6;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 8 && numberOfPlayer[1] == 9 && numberOfPlayer[i] == 4) {
                        numberOfComputer = 3;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 8 && numberOfPlayer[1] == 9 && numberOfPlayer[i] == 5) {
                        numberOfComputer = 1;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));
                    } else if (numberOfPlayer[0] == 8 && numberOfPlayer[1] == 9 && numberOfPlayer[i] == 6) {
                        numberOfComputer = 3;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));   // 8 - 9 - ola
                    } else if (numberOfPlayer[0] == 9 && numberOfPlayer[1] == 1 && numberOfPlayer[i] == 3
                            || numberOfPlayer[0] == 9 && numberOfPlayer[1] == 1 && numberOfPlayer[i] == 4
                            || numberOfPlayer[0] == 9 && numberOfPlayer[1] == 1 && numberOfPlayer[i] == 6
                            || numberOfPlayer[0] == 9 && numberOfPlayer[1] == 1 && numberOfPlayer[i] == 7) {
                        numberOfComputer = 8;
                        tictactoeArray[numberOfComputer] = "O";
                    } else if (numberOfPlayer[0] == 9 && numberOfPlayer[1] == 1 && numberOfPlayer[i] == 8) {
                        numberOfComputer = 6;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));  // 9 - 1 - ola
                    } else if (numberOfPlayer[0] == 9 && numberOfPlayer[1] == 2 && numberOfPlayer[i] == 1
                            || numberOfPlayer[0] == 9 && numberOfPlayer[1] == 2 && numberOfPlayer[i] == 3
                            || numberOfPlayer[0] == 9 && numberOfPlayer[1] == 2 && numberOfPlayer[i] == 7
                            || numberOfPlayer[0] == 9 && numberOfPlayer[1] == 2 && numberOfPlayer[i] == 8) {
                        numberOfComputer = 6;
                        tictactoeArray[numberOfComputer] = "O";
                    } else if (numberOfPlayer[0] == 9 && numberOfPlayer[1] == 2 && numberOfPlayer[i] == 6) {
                        numberOfComputer = 3;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));  // 9 - 2 - ola   
                    } else if (numberOfPlayer[0] == 9 && numberOfPlayer[1] == 3 && numberOfPlayer[i] == 1
                            || numberOfPlayer[0] == 9 && numberOfPlayer[1] == 3 && numberOfPlayer[i] == 2
                            || numberOfPlayer[0] == 9 && numberOfPlayer[1] == 3 && numberOfPlayer[i] == 7
                            || numberOfPlayer[0] == 9 && numberOfPlayer[1] == 3 && numberOfPlayer[i] == 8) {
                        numberOfComputer = 4;
                        tictactoeArray[numberOfComputer] = "O";
                    } else if (numberOfPlayer[0] == 9 && numberOfPlayer[1] == 3 && numberOfPlayer[i] == 4) {
                        numberOfComputer = 8;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer)); // 9 - 3 - ola
                    } else if (numberOfPlayer[0] == 9 && numberOfPlayer[1] == 4 && numberOfPlayer[i] == 1
                            || numberOfPlayer[0] == 9 && numberOfPlayer[1] == 4 && numberOfPlayer[i] == 3
                            || numberOfPlayer[0] == 9 && numberOfPlayer[1] == 4 && numberOfPlayer[i] == 6
                            || numberOfPlayer[0] == 9 && numberOfPlayer[1] == 4 && numberOfPlayer[i] == 7) {
                        numberOfComputer = 8;
                        tictactoeArray[numberOfComputer] = "O";
                    } else if (numberOfPlayer[0] == 9 && numberOfPlayer[1] == 4 && numberOfPlayer[i] == 8) {
                        numberOfComputer = 7;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));   // 9 - 4 - ola 
                    } else if (numberOfPlayer[0] == 9 && numberOfPlayer[1] == 6 && numberOfPlayer[i] == 1
                            || numberOfPlayer[0] == 9 && numberOfPlayer[1] == 6 && numberOfPlayer[i] == 2
                            || numberOfPlayer[0] == 9 && numberOfPlayer[1] == 6 && numberOfPlayer[i] == 4
                            || numberOfPlayer[0] == 9 && numberOfPlayer[1] == 6 && numberOfPlayer[i] == 8) {
                        numberOfComputer = 7;
                        tictactoeArray[numberOfComputer] = "O";
                    } else if (numberOfPlayer[0] == 9 && numberOfPlayer[1] == 6 && numberOfPlayer[i] == 7) {
                        numberOfComputer = 8;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));  // 9 - 6 - ola   
                    } else if (numberOfPlayer[0] == 9 && numberOfPlayer[1] == 7 && numberOfPlayer[i] == 1
                            || numberOfPlayer[0] == 9 && numberOfPlayer[1] == 7 && numberOfPlayer[i] == 3
                            || numberOfPlayer[0] == 9 && numberOfPlayer[1] == 7 && numberOfPlayer[i] == 4
                            || numberOfPlayer[0] == 9 && numberOfPlayer[1] == 7 && numberOfPlayer[i] == 6) {
                        numberOfComputer = 2;
                        tictactoeArray[numberOfComputer] = "O";
                    } else if (numberOfPlayer[0] == 9 && numberOfPlayer[1] == 7 && numberOfPlayer[i] == 2) {
                        numberOfComputer = 6;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));  // 9 - 7 - ola 
                    } else if (numberOfPlayer[0] == 9 && numberOfPlayer[1] == 8 && numberOfPlayer[i] == 1
                            || numberOfPlayer[0] == 9 && numberOfPlayer[1] == 8 && numberOfPlayer[i] == 2
                            || numberOfPlayer[0] == 9 && numberOfPlayer[1] == 8 && numberOfPlayer[i] == 4
                            || numberOfPlayer[0] == 9 && numberOfPlayer[1] == 8 && numberOfPlayer[i] == 6) {
                        numberOfComputer = 3;
                        tictactoeArray[numberOfComputer] = "O";
                    } else if (numberOfPlayer[0] == 9 && numberOfPlayer[1] == 8 && numberOfPlayer[i] == 3) {
                        numberOfComputer = 6;
                        tictactoeArray[numberOfComputer] = "O";
                        availableNumbers.remove(new Integer(numberOfComputer));  // 9 - 8 - ola                        
                    }
                } else if (i == 3) {
                    int randomNumber = rand.nextInt(8 - 2 * i);
                    numberOfComputer = availableNumbers.get(randomNumber);
                    tictactoeArray[numberOfComputer] = "O";
                    availableNumbers.remove(new Integer(numberOfComputer));
                }
                if (i > 1) {
                    CheckWinner.computerWin(tictactoeArray, winner, winnerInAMatch, playerName, i);
                    if (winnerInAMatch[0]) {
                        break;
                    }
                }
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
