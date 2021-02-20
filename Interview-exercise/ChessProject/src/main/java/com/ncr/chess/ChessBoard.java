package com.ncr.chess;

public class ChessBoard {

    public static int MAX_BOARD_WIDTH = 7;
    public static int MAX_BOARD_HEIGHT = 7;

    private static Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[MAX_BOARD_WIDTH][MAX_BOARD_HEIGHT];
    }

    public static void setPieces(int xCoordinate, int yCoordinate, Pawn pawn) {
       pieces[xCoordinate][yCoordinate] = pawn;
    }

    public static Pawn getPieces(int xCoordinate, int yCoordinate) {
        return pieces[xCoordinate][yCoordinate];
    }

    public void addPiece(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        if (xCoordinate >= 0 && xCoordinate < MAX_BOARD_WIDTH && yCoordinate >= 0 && yCoordinate < MAX_BOARD_HEIGHT) {
            if (this.getPieces(xCoordinate, yCoordinate) instanceof Pawn) {
                pawn.setXCoordinate(-1);
                pawn.setYCoordinate(-1);
            } else {
                this.setPieces(xCoordinate, yCoordinate, pawn);
                pawn.setXCoordinate(xCoordinate);
                pawn.setYCoordinate(yCoordinate);
            }
        } else {
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
        }
    }

    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        if(xCoordinate >= 0 && xCoordinate < MAX_BOARD_WIDTH && yCoordinate >= 0 && yCoordinate < MAX_BOARD_HEIGHT) {
            return true;
        }
        return false;
    }
}
