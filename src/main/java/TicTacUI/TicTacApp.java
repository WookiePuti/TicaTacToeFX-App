package TicTacUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.TicTacMatrix;

public class TicTacApp extends Application {
    private TicTacMatrix gameMatrix;
    private int size;

    @Override
    public void init() throws Exception {
        this.size = 3;
        this.gameMatrix = new TicTacMatrix(size);
    }

    @Override
    public void start(Stage stage) throws Exception {
        PlayView playView = new PlayView(gameMatrix, size, new HelperNamesMap());
        BorderPane layout = new BorderPane();
        layout.setCenter(playView.getView());
        Scene view = new Scene(layout, 400, 300);
        view.getStylesheets().add("TicTacUI/tictacStyle.css");
        stage.setScene(view);
        stage.show();

    }
    public static void main(String[] args) {
        launch(TicTacApp.class);
    }
}
