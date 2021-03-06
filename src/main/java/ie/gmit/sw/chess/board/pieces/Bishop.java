package ie.gmit.sw.chess.board.pieces;

import ie.gmit.sw.chess.board.ChessBoard;
import ie.gmit.sw.chess.board.Position;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class Bishop extends Piece {

    public Bishop(ChessBoard board, Colour colour) {

        super(board, colour);
    }

    @Override
    public String getName(){
        return super.getName() + "Bishop";
    }

    @Override
    public Collection<Position> getPossiblePositions() {
        Collection<Position> validPositions = new HashSet<>();

        //loop to traverse every possible position diagonally
        int x = position.x();
        int y = position.y();
        do {
            x++;
            y++;
            if (checkPositions(validPositions, x, y)) {
                continue;
            }
            break; // there was a piece blocking this direction
        } while (x < board.size() && y < board.size()); // until we hit the bottom right corner

        x = position.x();
        y = position.y();
        do {
            x--;
            y++;
            if (checkPositions(validPositions, x, y)) {
                continue;
            }
            break; // there was a piece blocking this direction
        } while (x >= 0 && y < board.size()); // until we hit the bottom left corner

        x = position.x();
        y = position.y();
        do {
            x++;
            y--;
            if (checkPositions(validPositions, x, y)) {
                continue;
            }
            break; // there was a piece blocking this direction
        } while (x < board.size() && y >= 0); // until we hit the top right corner

        x = position.x();
        y = position.y();
        do {
            x--;
            y--;
            if(checkPositions(validPositions, x, y)) {
                continue;
            }
            break; // there was a piece blocking this direction
        } while (x >= 0 && y >= 0); // until we hit the top left corner
        return validPositions;
    }


    private boolean checkPositions(Collection<Position> validPositions, int x, int y) {
        Position next = new Position(x, y); // get the position at x,y
        if(!board.isOnBoard(next)){
            return false;
        }

        if (board.posIsEmpty(next)) {
            validPositions.add(next);
            return true;
        }

        // if we're here it means there is a piece.
        Piece piece = board.getAt(next);
        if (piece.colour != colour) {
            validPositions.add(next);
        }
        return false;
    }

}