package ie.gmit.sw.chess.board.pieces;

import ie.gmit.sw.chess.board.ChessBoard;
import ie.gmit.sw.chess.board.Position;

import java.util.List;

public class Rook extends Piece {
    public Rook(ChessBoard board, Position pos, Colour colour) {
        super(board, pos, colour);
    }

    @Override
    public List<Position> getPossiblePositions() {
        return null;
    }
}
