package tictactoe;

public class CheckWinner {

    public static void playerWin(String myArray[], int[] winner, boolean[] winnerInAMatch, String name, int i) {
        if ((myArray[1].equals("X") && myArray[2].equals("X") && myArray[3].equals("X"))
                || (myArray[4].equals("X") && myArray[5].equals("X") && myArray[6].equals("X"))
                || (myArray[7].equals("X") && myArray[8].equals("X") && myArray[9].equals("X"))
                || (myArray[1].equals("X") && myArray[4].equals("X") && myArray[7].equals("X"))
                || (myArray[2].equals("X") && myArray[5].equals("X") && myArray[8].equals("X"))
                || (myArray[3].equals("X") && myArray[6].equals("X") && myArray[9].equals("X"))
                || (myArray[1].equals("X") && myArray[5].equals("X") && myArray[9].equals("X"))
                || (myArray[3].equals("X") && myArray[5].equals("X") && myArray[7].equals("X"))) {
            System.out.println("");
            System.out.println("You Won!");
            winner[1]++;
            winnerInAMatch[1] = true;
            System.out.println("Scoreboard: " + name + ":" + winner[1] + " Computer:" + winner[0]);
            PrintToScreen.ScreenResult(myArray);
        } else if (i == 4){
            System.out.println("");
            System.out.println("Draw!");
            System.out.println("Scoreboard: " + name + ":" + winner[1] + " Computer:" + winner[0]);
            PrintToScreen.ScreenResult(myArray);
        }
    }

    public static void computerWin(String myArray[], int[] winner, boolean[] winnerInAMatch, String name, int i) {
        if ((myArray[1].equals("O") && myArray[2].equals("O") && myArray[3].equals("O"))
                || (myArray[4].equals("O") && myArray[5].equals("O") && myArray[6].equals("O"))
                || (myArray[7].equals("O") && myArray[8].equals("O") && myArray[9].equals("O"))
                || (myArray[1].equals("O") && myArray[4].equals("O") && myArray[7].equals("O"))
                || (myArray[2].equals("O") && myArray[5].equals("O") && myArray[8].equals("O"))
                || (myArray[3].equals("O") && myArray[6].equals("O") && myArray[9].equals("O"))
                || (myArray[1].equals("O") && myArray[5].equals("O") && myArray[9].equals("O"))
                || (myArray[3].equals("O") && myArray[5].equals("O") && myArray[7].equals("O"))) {
            System.out.println("");
            System.out.println("You lost!");
            winner[0]++;
            winnerInAMatch[0] = true;
            System.out.println("Scoreboard: " + name + ":" + winner[1] + " Computer:" + winner[0]);
            PrintToScreen.ScreenResult(myArray);
        } else if (i == 4){
            System.out.println("");
            System.out.println("Draw!");
            System.out.println("Scoreboard: " + name + ":" + winner[1] + " Computer:" + winner[0]);
            PrintToScreen.ScreenResult(myArray);
        }
    }

    public static void player1Win(String myArray[], int[] winner, boolean[] winnerInAMatch, String name, String name2) {
        if ((myArray[1].equals("X") && myArray[2].equals("X") && myArray[3].equals("X"))
                || (myArray[4].equals("X") && myArray[5].equals("X") && myArray[6].equals("X"))
                || (myArray[7].equals("X") && myArray[8].equals("X") && myArray[9].equals("X"))
                || (myArray[1].equals("X") && myArray[4].equals("X") && myArray[7].equals("X"))
                || (myArray[2].equals("X") && myArray[5].equals("X") && myArray[8].equals("X"))
                || (myArray[3].equals("X") && myArray[6].equals("X") && myArray[9].equals("X"))
                || (myArray[1].equals("X") && myArray[5].equals("X") && myArray[9].equals("X"))
                || (myArray[3].equals("X") && myArray[5].equals("X") && myArray[7].equals("X"))) {
            System.out.println("");
            System.out.println(name + " Won!");
            winner[1]++;
            winnerInAMatch[1] = true;
            System.out.println("Scoreboard: " + name + ":" + winner[1] + " " + name2 +":" + winner[2]);
            PrintToScreen.ScreenResult(myArray);
        }
    }

    public static void player2Win(String myArray[], int[] winner, boolean[] winnerInAMatch, String name, String name2) {
        if ((myArray[1].equals("O") && myArray[2].equals("O") && myArray[3].equals("O"))
                || (myArray[4].equals("O") && myArray[5].equals("O") && myArray[6].equals("O"))
                || (myArray[7].equals("O") && myArray[8].equals("O") && myArray[9].equals("O"))
                || (myArray[1].equals("O") && myArray[4].equals("O") && myArray[7].equals("O"))
                || (myArray[2].equals("O") && myArray[5].equals("O") && myArray[8].equals("O"))
                || (myArray[3].equals("O") && myArray[6].equals("O") && myArray[9].equals("O"))
                || (myArray[1].equals("O") && myArray[5].equals("O") && myArray[9].equals("O"))
                || (myArray[3].equals("O") && myArray[5].equals("O") && myArray[7].equals("O"))) {
            System.out.println("");
            System.out.println(name2 + " Won!");
            winner[2]++;
            winnerInAMatch[2] = true;
            System.out.println("Scoreboard: " + name + ":" + winner[1] + " " + name2 +":" + winner[2]);
            PrintToScreen.ScreenResult(myArray);
        }
    }

}
