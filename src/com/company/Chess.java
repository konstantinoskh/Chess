package com.company;

import java.util.Scanner;

public class Chess {
    private Piece[][] board;

    // set up the board for the start of the game
    public Chess() {
        board = new Piece[8][8];
        // create the pawns
        for (int c=0; c<8; c++) {
            board[1][c] = new Piece(1, c, false);
            board[6][c] = new Piece(6, c, true);
        }
        board[0][3] = new King("A4", false);
    }

    // print the current board layout
    public void display() {
        for (int r=0; r<8; r++) {
            for (int c=0; c<8; c++) {
                if (board[r][c] != null) {
                    System.out.print(board[r][c].getSymbol() + " ");
                } else {
                    System.out.print("_ ");  // blank square
                }
            }
            System.out.println();  // start a new row
        }
    }
    public Piece getPieceAt(String position){
        int row = ChessUtils.getRowFromPosition(position);
        int column = ChessUtils.getColumnFromPosition(position);
        return board[row][column];
    }

    public void move(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the place to move: ");
        String startPosition = input.nextLine();
        System.out.println("Enter the square to move to: ");
        String endPosition = input.nextLine();
        Piece toMove = getPieceAt(startPosition);
        boolean validMove = false;
        if (toMove != null) {
            validMove = toMove.isValidMove(endPosition);
        }
        if (validMove){
            System.out.println(toMove.getSymbol() + " moves to " + endPosition);

            int startRow = ChessUtils.getRowFromPosition(startPosition);
            int endRow = ChessUtils.getRowFromPosition(endPosition);
            int startColumn = ChessUtils.getColumnFromPosition(startPosition);
            int endColumn = ChessUtils.getColumnFromPosition(endPosition);

            board[endRow][endColumn] = board[startRow][startColumn];
            board[startRow][startColumn] = null;
            toMove.setPosition(endPosition);
        } else {
            System.out.println("You can't do that!");
        }
    }
}
