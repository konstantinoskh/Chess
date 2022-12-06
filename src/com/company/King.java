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
        int targetRow = ChessUtils.getRowFromPosition(targetPosition);
        int targetColumn = ChessUtils.getColumnFromPosition(targetPosition);
        if ()
    }
}
