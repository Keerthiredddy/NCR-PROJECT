package com.ncr.chess;

import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.ncr.chess.ChessBoard.getPieces;
import static com.ncr.chess.ChessBoard.MAX_BOARD_HEIGHT;
import static com.ncr.chess.ChessBoard.MAX_BOARD_WIDTH;

@Data
public class Pawn extends Pieces{

    private static final Logger logger = LogManager.getLogger(Pawn.class);

    private ChessBoard chessBoard;
    private int xCoordinate;
    private int yCoordinate;
    private PieceColor pieceColor;

    public Pawn(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    /**
     * This method will move the piece to new X and Y coordinates position given if it is a valid move
     * @param movementType input movement type MOVE/CAPTURE
     * @param newX input new X coordinates
     * @param newY input new Y coordinates
     */
    public void move(MovementType movementType, int newX, int newY) {
        if(movementType.equals(MovementType.MOVE)){
            if(newX >= 0 && newX < MAX_BOARD_WIDTH && newY >= 0 && newY < MAX_BOARD_HEIGHT
                && !(getPieces(newX,newY) instanceof Pawn)) {
                if(PieceColor.BLACK.equals(getPieceColor()) &&  newX == getXCoordinate() &&  newY == getYCoordinate() - 1 ){
                    logger.info("Moved pawn to X " + xCoordinate + "and Y " + yCoordinate + " position and piece color " +getPieceColor());
                    setXCoordinate(newX);
                    setYCoordinate(newY);
                } else if(PieceColor.WHITE.equals(getPieceColor()) &&  newX == getXCoordinate() &&  newY == getYCoordinate() + 1) {
                    logger.info("Moved pawn to X " + xCoordinate + "and Y " + yCoordinate + " position and piece color " +getPieceColor());
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
