package com.company;

public class King extends Piece{
    private boolean isCheck;

    public King(String position, boolean isBlack) {
        super(position, isBlack);
        symbol = 'K';
        isCheck = false;
    }

    //Kings can move in 1 square in any direction
    public boolean isValidMove(String targetPosition) {
        String position = getPosition();
        int currentRowPosition = ChessUtils.getRowFromPosition(position);
        int currentColumnPosition = ChessUtils.getColumnFromPosition(position);
        int targetRow = ChessUtils.getRowFromPosition(targetPosition);
        int targetColumn = ChessUtils.getColumnFromPosition(targetPosition);
        if ((targetRow - currentRowPosition) == 0 && (targetColumn - currentColumnPosition) == 0){
            return false;
        }else return (targetRow - currentRowPosition) <= 1 && (targetRow - currentRowPosition) >= -1 && (targetColumn - currentColumnPosition) <= 1 && (targetColumn - currentColumnPosition) >= -1;

    }
}
