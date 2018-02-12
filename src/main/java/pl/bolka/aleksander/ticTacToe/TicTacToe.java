package pl.bolka.aleksander.ticTacToe;

public class TicTacToe {

    //TODO testy + lepsze api
    private Board board;

    public TicTacToe() {
        this.board = new Board();
    }


    public void play(int x, int y) {
        if (x<1 || x>3 || y < 1|| y>3){
            throw new RuntimeException("play outside board");
        }
        if (board.getRows().get(x).getFields().get(y).equals(Sign.NONE)) {
            board.getRows().get(x).getFields().put(y,Sign.CROSS);
        }else {
            throw new RuntimeException("not empty field");
        }
    }
}
