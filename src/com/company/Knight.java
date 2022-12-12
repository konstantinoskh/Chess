package com.company;

public class Knight extends Piece {

    public Knight(String position, boolean isBlack) {
        super(position, isBlack);
        symbol = 'N';
    }

    public boolean isValidMove(String targetPosition) {
        String position = getPosition();
        int currentRowPosition = ChessUtils.getRowFromPosition(position);
        int currentColumnPosition = ChessUtils.getColumnFromPosition(position);
        int targetRow = ChessUtils.getRowFromPosition(targetPosition);
        int targetColumn = ChessUtils.getColumnFromPosition(targetPosition);
        if ((targetRow - currentRowPosition) == 0 && (targetColumn - currentColumnPosition) == 0) {
            return false;
        } else if (Math.abs((targetRow - currentRowPosition)) == 2 && Math.abs((targetColumn - currentColumnPosition)) == 1) {
            return true;
        } else return Math.abs((targetRow - currentRowPosition)) == 1 && Math.abs((targetColumn - currentColumnPosition)) == 2;
    }
}