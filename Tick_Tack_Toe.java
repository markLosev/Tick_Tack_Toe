package tick.tack.toe;
import java.util.Scanner;
/**
 *
 * @author Mark
 */

public class TickTackToe {

    
    private boolean isPlayerOnesTurn;
    private static boolean gameOver;
    private final String[][] board = new String[3][3];
    private Scanner reader;

  
     public static void main(String[] args) {
         boolean exit = false;
        TickTackToe playBoard = new TickTackToe();  
        playBoard.displayBoard();
        while (!exit) {
        playBoard.promptAndSetLocation2();
        if (playBoard.checkForWinner() == true) {
               break;
           }          
           playBoard.checkForEmptySpots();
           if (playBoard.isGameOver() == true) {
               break;
           }
                   
        }
        System.out.println("Game Over thanks for playing");


        }
   
    public TickTackToe () {

        isPlayerOnesTurn = true;
        gameOver = false;
        for (int row = 0; row < board.length; row++) {                       
            for (int col = 0; col < board.length; col++) {                  
                System.out.print(board[row][col] = " ");
            }
        }
        reader = new Scanner(System.in);
    }
    public boolean isGameOver() {
        return gameOver;
    }
    public void displayBoard() {
       System.out.println("A" + "  B  " + " C ");
        int i = 1;
        for (int row = 0; row < board.length; row++) {            
            System.out.print(i + " ");
            for (int col = 0; col < board.length; col++) {  
                System.out.print(board[row][col]);
                System.out.print(" | ");               
            }
            System.out.println();
            i++;
        }
     }
         
     public void promptAndSetLocation() {
        
           boolean validMove = true;
           while (validMove) {
              int number = 23;
              int letter = 24;
              System.out.println("please enter a number between 1 and 3");
              while (!reader.hasNextInt()) {
                  System.out.println("please enter an integer");
                  reader.next();
              }
              number = reader.nextInt();
              while (number < 1 || number > 3) {
                  System.out.println("this is not valid. please enter a nuber between 1 and 3");
                  if (reader.hasNextInt()) {
                      number = reader.nextInt();
                   }
                   else {
                      reader.next();
                   }
              }
              number  = number - 1;
              System.out.println(" Please enter either A, B or C");
             
              while (reader.hasNextInt()) {
                   System.out.println("Please enter either A, B or C");
                   reader.next();
              }
              String word;
              word = reader.next().trim().toUpperCase();
              while (letter != 0 && letter!= 1 && letter!= 2) {
                  switch (word) {
                      case "A":
                          letter = 0;
                          break;
                      case "B":
                          letter = 1;
                          break;
                      case "C":
                          letter = 2;
                          break;
                      default:
                          System.out.println("please enter A,  B or C. you got it buddy!!!");
                          word = reader.next().trim().toUpperCase();
                          break;
                  }
             }
       
            if (isPlayerOnesTurn && " ".equals(board [number] [letter])) {
                   board [number] [letter] = "X";
                   validMove = !validMove; 
                   isPlayerOnesTurn = !isPlayerOnesTurn;
                   displayBoard();
            }
            else if (!isPlayerOnesTurn && " ".equals(board [number] [letter])) {
                    board [number] [letter] = "O";
                    validMove = !validMove;
                    isPlayerOnesTurn = !isPlayerOnesTurn;
                    displayBoard();
             }
             else {
                    System.out.println("This spot has already been taken, please try another one");
                     displayBoard();
             } 
         
          }
        }
        
        public boolean checkForWinner () {
           String winner = "none";
           for (int row = 0; row < board.length; row++) {            
               
              for (int col = 0; col < board.length; col++) {  
                 if ((row + 1 < 3 && row - 1 > -1 && board[row][col].equals(board[row + 1][col]) && board[row][col].equals(board[row - 1][col]))) {
                     if (!winner.equals(" ")) {
                         winner = board [row][col]; 
                     }
                 }
                 if (col + 1 < 3 && col - 1 > -1 && board[row][col].equals(board[row][col + 1]) && board[row][col].equals(board[row][col - 1])) {
                     if (!winner.equals(" ")) {
                         winner = board [row][col]; 
                     }    
                 }
                 if (row + 1 < 3 && row - 1 > -1 && col + 1 < 3 && col - 1 > -1 && board[row][col].equals(board[row + 1][col + 1]) && board[row][col].equals(board[row - 1][col - 1])) {
                     if (!winner.equals(" ")) {
                         winner = board [row][col]; 
                     }    
                 }
                 if (row + 1 < 3 && row - 1 > -1 && col + 1 < 3 && col - 1 > -1 && board[row][col].equals(board[row - 1][col + 1]) && board[col][row].equals(board[row + 1][col -1])) {
                    if (!winner.equals(" ")) {
                         winner = board [row][col]; 
                     }    
                 }
              }             
           }
           if (winner.equals("X")) {
               System.out.println("player 1 is the winner!!!!");
               return true;
           }
           if (winner.equals("O")) {
               System.out.println("player 2 is the winner "); 
               return true;          
           }
           else {
               return false;
           }
        }
        public void checkForEmptySpots () {
             int emptySpots = 0;
             
             for (int row = 0; row < board.length; row++) {                       
                 for (int col = 0; col < board.length; col++) {                  
                    if (board[row][col].equals(" ")) {
                        emptySpots++;
                    }
                 }
             }
             if (emptySpots > 0) {
                System.out.println("there are still spots left continue playing");
             }
             else {
                gameOver = true;
             }
        }
        
}
