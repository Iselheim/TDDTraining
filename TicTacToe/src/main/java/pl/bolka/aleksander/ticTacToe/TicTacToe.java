package pl.bolka.aleksander.ticTacToe;

public class TicTacToe {

    private Board board;

    private Sign nextSign;

    public TicTacToe() {
        this.board = new Board();
        nextSign = Sign.CROSS;
    }


    public boolean play(int x, int y) {
        board.getRow(x).setField(y, nextPlayer());
        nextSign = changePlayer();
        return checkWin();
    }

    public Sign nextPlayer() {
        return nextSign;
    }

    private Sign changePlayer() {
        if (nextSign.equals(Sign.CROSS)) {
            return Sign.CIRCLE;
        } else {
            return Sign.CROSS;
        }
    }

    private boolean checkWin() {
        if (rowWinRule()){
            return true;
        }
        if (columnWinRule()){
            return true;
        }

        return false;
    }

    private boolean columnWinRule() {
        for (int i = 1; i <= 3; i++) {
            if (checkColumnWin(i)){
                return true;
            }
        }
        return false;
    }

    private boolean checkColumnWin(int i) {
        int crossColumnCount = 0;
        int circleColumnCount = 0;
        for (Row row : board.getRows().values()) {
            switch (row.getField(i)) {
                case CIRCLE:
                    circleColumnCount++;
                    break;
                case CROSS:
                    crossColumnCount++;
                    break;
            }
        }
        if (crossColumnCount == 3 || circleColumnCount == 3) {
            return true;
        }
        return false;
    }

    private boolean rowWinRule() {
        for (Row row : board.getRows().values()) {
            if (checkRowWin(row)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkRowWin(Row row) {
        int crossRowCount = 0;
        int circleRowCount = 0;
        for (Sign sign : row.getFields().values()) {
            switch (sign) {
                case CROSS:
                    crossRowCount++;
                    break;
                case CIRCLE:
                    circleRowCount++;
                    break;
            }
        }
        if (circleRowCount == 3 || crossRowCount == 3) {
            return true;
        }
        return false;
    }
}
