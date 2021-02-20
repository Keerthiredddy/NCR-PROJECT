package com.ncr.chess;

import static com.ncr.chess.ChessBoard.*;

public class Pawn {

    private ChessBoard chessBoard;
    private int xCoordinate;
    private int yCoordinate;
    private PieceColor pieceColor;

    public Pawn(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard =  chessBoard;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int value) {
        this.xCoordinate = value;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int value) {
        this.yCoordinate = value;
    }

    public PieceColor getPieceColor() {
        return this.pieceColor;
    }

    private void setPieceColor(PieceColor value) {
        pieceColor = value;
    }

    public void move(MovementType movementType, int newX, int newY) {
        if(movementType.equals(MovementType.MOVE)){
            if(newX >= 0 && newX < MAX_BOARD_WIDTH && newY >= 0 && newY < MAX_BOARD_HEIGHT && !(getPieces(newX,newY) instanceof Pawn)) {
                if(PieceColor.BLACK.equals(getPieceColor()) &&  newX == getXCoordinate() &&  newY == getYCoordinate() - 1 ){
                    setXCoordinate(newX);
                    setYCoordinate(newY);
                } else if(PieceColor.WHITE.equals(getPieceColor()) &&  newX == getXCoordinate() &&  newY == getYCoordinate() + 1) {
                    setXCoordinate(newX);
                    setYCoordinate(newY);
                }
            }
        }
    }

    @Override
    public String toString() {
        return getCurrentPositionAsString();
    }

    protected String getCurrentPositionAsString() {
        String eol = System.lineSeparator();
        return String.format("Current X: {1}{0}Current Y: {2}{0}Piece Color: {3}", eol, xCoordinate, yCoordinate, pieceColor);
    }
}
