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
        return (currentColumnPosition == targetColumn || currentRowPosition == targetRow);
    }
    public ArrayList<String> passesThrough(String targetPosition) {
        String position = getPosition();
        int currentRowPosition = ChessUtils.getRowFromPosition(position);
        int currentColumnPosition = ChessUtils.getColumnFromPosition(position);
        int targetRow = ChessUtils.getRowFromPosition(targetPosition);
        int targetColumn = ChessUtils.getColumnFromPosition(targetPosition);

        ArrayList<String> squares = new ArrayList<>();
        if (isValidMove(targetPosition)) {
            int row = currentRowPosition;
            do{
                int col = currentColumnPosition;
                do{
                    squares.add(ChessUtils.getPositionFromCoords(row, col));
                    col++;
                }while(col<targetColumn);
            row++;
        }while (row<targetRow);
    }
        squares.remove(0);
        return squares;
    }
}