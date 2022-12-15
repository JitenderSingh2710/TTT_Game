package com.jitenderbairwa.tic_tac_toe;

import java.util.Scanner;

public class TTT{
     private player player1,player2;
     private Board board;
     private int PlayerNumber=0;
     public void startGame() {
         Scanner s=new Scanner(System.in);
         player1 = takePlayerInput(++PlayerNumber);
         player2 = takePlayerInput(++PlayerNumber);
         if (player1.getSymbol() == player2.getSymbol()) {
             //reset the symbol again.
             System.out.println("Symbol Already Taken!! Please enter different symbol");
             player2.setSymbol(s.next().charAt(0));
         }
         //create a board
          board =new Board(player1.getSymbol(), player2.getSymbol());
         //and now play the game
         boolean player1Turn=true;
         int result=board.INCOMPLETE;
         while(result==board.INCOMPLETE||result==board.INVALIDPOSITION){
         if(player1Turn){
             System.out.println( "Player-1 "+player1.getPlayerName()+"'s turn");
             System.out.println("Enter x:");
             int x=s.nextInt();
             System.out.println("Enter y:");
             int y=s.nextInt();
             result=board.move(player1.getSymbol(),x,y);
             if(result==board.INVALIDPOSITION){
                 System.out.println("Invalid position Please Try Again!!");
                 continue;
             }
         }
         else{
             System.out.println( "Player-2 "+player2.getPlayerName()+"'s turn");
             System.out.println("Enter x:");
             int x=s.nextInt();
             System.out.println("Enter y:");
             int y=s.nextInt();
             result=board.move(player2.getSymbol(),x,y);
             if(result==board.INVALIDPOSITION) {
                 System.out.println("Invalid position Please Try Again!!");
                 continue;
             }
         }
         player1Turn=!player1Turn;
         board.print();
         }
         if(result==board.PLAYER1WIN){
             System.out.println("Player-1  "+player1.getPlayerName()+" Wins!!!!");
         }
         else  if(result==board.PLAYER2WIN){
             System.out.println("Player-2  "+player2.getPlayerName()+" Wins!!!!");
         }
         else if(result== board.DRAW) {
             System.out.println("Draw!!!");
         }
     }
         //this function take player name and construct the board and start the game;
         private player takePlayerInput(int num){
             Scanner sc=new Scanner(System.in);
             System.out.println("Enter name "+num+" player:");
             String player_Name=sc.nextLine();
             System.out.println("Enter symbol "+num+" player:");
             char symbol=sc.next().charAt(0);
             player p=new player(player_Name,symbol);
             return p;
         }
    public static void main(String[] args) {
        TTT open =new TTT();
        open.startGame();
    }
}
