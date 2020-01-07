/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author Δημήτρης
 */
public class PrintToScreen {
    
    public static void ScreenResult(String[] tictactoeArray) {
        System.out.println("");
        System.out.print("_" + tictactoeArray[1] + "_|_" + tictactoeArray[2] + "_|_" + tictactoeArray[3] + "_");
        System.out.println("");
        System.out.print("_" + tictactoeArray[4] + "_|_" + tictactoeArray[5] + "_|_" + tictactoeArray[6] + "_");
        System.out.println("");
        System.out.print("_" + tictactoeArray[7] + "_|_" + tictactoeArray[8] + "_|_" + tictactoeArray[9] + "_");
        System.out.println("");
        System.out.println("");
    }
    
    
}
