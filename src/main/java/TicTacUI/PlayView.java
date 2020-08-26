package TicTacUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import sample.TicTacKind;
import sample.TicTacMatrix;
import sample.WinKind;


public class PlayView {
    private TicTacMatrix gameMatrix;
    private int size;
    private HelperNamesMap helperData;
    private TicTacKind playerTurn;
    private HelperNamesMap displayData;


    public PlayView(TicTacMatrix gameMatrix, int size, HelperNamesMap helperData) {
        this.gameMatrix = gameMatrix;
        this.size = size;
        this.helperData = helperData;
        playerTurn = TicTacKind.CIRCLE;


    }

    public Parent getView(){
        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        CustomButton[][] btns = new CustomButton[size][size];
        Label playerInfo = new Label("Player turn: "+this.playerTurn.name());
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                btns[i][j] = new CustomButton("",i, j);
                layout.add(btns[i][j], j, i);
                btns[i][j].setOnMouseClicked((mouseEvent -> {

                    if(gameMatrix.setField(this.playerTurn, ((CustomButton) mouseEvent.getSource()).getX(), ((CustomButton) mouseEvent.getSource()).getY())){
                        btns[((CustomButton) mouseEvent.getSource()).getX()][((CustomButton) mouseEvent.getSource()).getY()].setText(helperData.getShortcut(this.playerTurn));
                        if (this.playerTurn==TicTacKind.CIRCLE){
                            this.playerTurn = TicTacKind.CROSS;
                        }
                        else{
                            this.playerTurn = TicTacKind.CIRCLE;
                        }

                        WinKind winKind = gameMatrix.checkWin();
                        System.out.println(gameMatrix.getStatusSield(0,0));
                        if (winKind!=WinKind.INPLAY){
                            playerInfo.setText("Win "+ winKind.name());
                        }
                    }
                    playerInfo.setText("Player turn: "+this.playerTurn.name());

                    for (int k = 0; k < size; k++) {
                        StringBuilder builder = new StringBuilder("");
                        for (int l = 0; l < size; l++) {
                            builder.append(gameMatrix.getStatusSield(k, l));
                            builder.append(" ");
                        }
                        System.out.println(builder.toString());
                    }

                }));
            }
        }
        layout.add(playerInfo, size, 0);
        return layout;
    }
}
