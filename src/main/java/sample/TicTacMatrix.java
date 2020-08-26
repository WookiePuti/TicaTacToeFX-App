package sample;

public class TicTacMatrix {
    private TicTacField[][] ticTacs;
    private int size;
    private HelperMap helperMap;

    public TicTacMatrix(int size) {
        helperMap = new HelperMap();
        this.size = size;
        this.ticTacs =new TicTacField[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.ticTacs[i][j] = new TicTacField();
            }
        }
    }

    public boolean setField(TicTacKind kind, int x, int y){
        return this.ticTacs[x][y].setFieldKind(kind);
    }

    public WinKind checkWin(){

        //horizontal
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {

                if (!ticTacs[i][j].equals(ticTacs[i][j+1])) break;
                if (j==size-2) return helperMap.getWinKind(ticTacs[i][j].getFieldKind());
            }
        }

        // verical
        for (int j = 0; j < size-1; j++) {
            for (int i = 0; i < size ; i++) {
                if (!ticTacs[i][j].equals(ticTacs[i][j+1])) break;
                if (j==size-2) return helperMap.getWinKind(ticTacs[i][j].getFieldKind());
            }
        }

        //bias
        for (int row = 0; row < size; row++) {
            if (!ticTacs[row][row].equals(ticTacs[row+1][row+1])) break;
            if (row==size-2) return helperMap.getWinKind(ticTacs[row][row].getFieldKind());

        }

        for (int row = 0; row < size; row++) {
            if (!ticTacs[row][size-row-1].equals(ticTacs[row+1][size-(row+1)-1])) break;
            if (row==size-2) return helperMap.getWinKind(ticTacs[row][size-row-1].getFieldKind());

        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (ticTacs[i][j].getFieldKind()==TicTacKind.EMPTY) return WinKind.INPLAY;
            }
        }


        return WinKind.DRAW;
    }

    public TicTacKind getStatusSield(int x, int y){
        return this.ticTacs[x][y].getFieldKind();
    }
}

