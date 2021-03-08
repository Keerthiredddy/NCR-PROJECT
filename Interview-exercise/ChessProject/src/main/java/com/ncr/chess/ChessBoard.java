package com.ncr.chess;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChessBoard {

    private static final Logger logger = LogManager.getLogger(ChessBoard.class);
    public static int MAX_BOARD_WIDTH = 7;
    public static int MAX_BOARD_HEIGHT = 7;

    private static Pieces[][] pieces;

    public ChessBoard() {
        pieces = new Pieces[MAX_BOARD_WIDTH][MAX_BOARD_HEIGHT];
    }

    public static void setPieces(int xCoordinate, int yCoordinate, Pieces piece) {
        pieces[xCoordinate][yCoordinate] = piece;
    }

    public static Pieces getPieces(int xCoordinate, int yCoordinate) {
        return pieces[xCoordinate][yCoordinate];
    }

    /**
     * This method adds piece on chess board if X and Y coordinates are valid
     * and no piece already available in that position else set X and Y coordinates to -1
     * @param pawn input piece pawn object
     * @param xCoordinate input X coordinate
     * @param yCoordinate input Y coordinate
     * @param pieceColor input piece colour
     */
    public void addPiece(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        if (this.isLegalBoardPosition(xCoordinate, yCoordinate)) {
            if (this.getPieces(xCoordinate, yCoordinate) instanceof Pawn) {
                logger.info("X " + xCoordinate + "and Y " + yCoordinate + " coordinates is already having pawn");
                pawn.setXCoordinate(-1);
                pawn.setYCoordinate(-1);
            } else {
                logger.info("Added pawn to X " + xCoordinate + "and Y " + yCoordinate + " position");
                this.setPieces(xCoordinate, yCoordinate, pawn);
                pawn.setXCoordinate(xCoordinate);
                pawn.setYCoordinate(yCoordinate);
            }
        } else {
            logger.info("X " + xCoordinate + "and Y " + yCoordinate + " positions are not valid");
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
        }
        pawn.setPieceColor(pieceColor);
    }

    /**
     * This method checks the X and Y positions are valid or not on chess board
     * @param xCoordinate input X coordinate
     * @param yCoordinate input Y coordinate
     * @return true if X and Y coordinates are valid else false
     */
    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        if (xCoordinate >= 0 && xCoordinate < MAX_BOARD_WIDTH
            && yCoordinate >= 0 && yCoordinate < MAX_BOARD_HEIGHT) {
            logger.info("X " + xCoordinate + "and Y " + yCoordinate + " positions are valid");
            return true;
        }
        logger.info("X " + xCoordinate + "and Y " + yCoordinate + " positions are not valid");
        return false;
    }
}
