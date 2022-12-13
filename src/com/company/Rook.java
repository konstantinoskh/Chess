package com.company;

import java.util.ArrayList;

public class Rook extends Piece {
    private boolean hasCastle;

    public Rook(String position, boolean isBlack) {
        super(position, isBlack);
        symbol = 'R';
    }

    public boolean isValidMove(String targetPosition) {
        String position = getPosition();
        int currentRowPosition = ChessUtils.getRowFromPosition(position);
        int currentColumnPosition = ChessUtils.getColumnFromPosition(position);
        int targetRow = ChessUtils.getRowFromPosition(targetPosition);
        int targetColumn = ChessUtils.getColumnFromPosition(targetPosition);
        if ((targetRow - currentRowPosition) == 0 && (targetColumn - currentColumnPosition) == 0) {
            return false;
        } else if
        (Math.abs(targetRow - currentRowPosition) <= 8 && (targetColumn - currentColumnPosition) == 0) {
            return true;
        }else
            return (Math.abs(targetColumn - currentColumnPosition) <=8 && (targetRow - currentRowPosition) == 0);
    }
    public ArrayList<String> passesThrough(String targetPosition) {
        String position = getPosition();
        int currentRowPosition = ChessUtils.getRowFromPosition(position);
        int currentColumnPosition = ChessUtils.getColumnFromPosition(position);
        int targetRow = ChessUtils.getRowFromPosition(targetPosition);
        int targetColumn = ChessUtils.getColumnFromPosition(targetPosition);

        ArrayList<String> squares = new ArrayList<>();
        if (isValidMove(targetPosition)) {
            int row = currentRowPosition+1;
            do{
                int col = currentColumnPosition+1;
                do{
                    squares.add(ChessUtils.getPositionFromCoords(row, col));
                    col++;
                }while(col<targetColumn);
            row++;
        }while (row<targetRow);
    }
        return squares;
    }
}