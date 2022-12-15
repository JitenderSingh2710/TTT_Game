package com.jitenderbairwa.tic_tac_toe;

import javax.swing.*;

public class Board {
    //board class should know the symbol of the player and size of the board
    private  char[][]Board;
    private  int boardSize=3;
    //count manage the  number of spaces filled.
    private  int count ;
    private   char player1Symbol,player2Symbol;
    private    final char  EMPTY=' ';
    public  final int PLAYER1WIN=1;
    public  final int PLAYER2WIN=2;
    public  final int DRAW=3;
    public  final int INCOMPLETE=4;
    public  final int INVALIDPOSITION=5;

    public Board(char player1Symbol,char player2Symbol) {
        Board =new char[boardSize][boardSize];
        for (int i =0; i<boardSize;i++) {
            for (int j = 0; j < boardSize; j++) {
                Board[i][j] = EMPTY;
            }
        }
        this.player1Symbol = player1Symbol;
        this.player2Symbol = player2Symbol;
    }

        public  int move(char symbol,int x,int y){
        if(x>=boardSize||x<0||y>=boardSize||y<0||Board[x][y]!=EMPTY){
            return INVALIDPOSITION;
        }
        Board[x][y]=symbol;
        count++;
        //when all rows have same char
        if(Board[x][0]==Board[x][1]&&Board[x][0]==Board[x][2]){
            return symbol==player1Symbol ? PLAYER1WIN:PLAYER2WIN;
        }
        //if all column are same
            if(Board[0][y]==Board[1][y]&&Board[0][y]==Board[2][y]) {
                return symbol == player1Symbol ? PLAYER1WIN : PLAYER2WIN;
            }
            //check diagonal condition
            if (Board[0][0]!=EMPTY&&Board[0][0] == Board[1][1]&&Board[0][0]==Board[2][2]) {
                return symbol == player1Symbol ? PLAYER1WIN : PLAYER2WIN;
            }
            if (Board[0][2]!=EMPTY&&Board[0][2] == Board[1][1]&&Board[0][2]==Board[2][0]) {
                return symbol == player1Symbol ? PLAYER1WIN : PLAYER2WIN;
            }
            if(count==boardSize*boardSize){
                return DRAW;
            }
            return INCOMPLETE;
        }
        public  void print(){
            for(int i=0;i<boardSize;i++){
                for(int j=0;j<boardSize;j++){
                    System.out.print("|  "  +Board[i][j]  +"  |");
                }
                System.out.println();
            }
            System.out.println("---------------");
        }
    }

