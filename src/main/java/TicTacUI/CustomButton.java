package TicTacUI;

import javafx.scene.control.Button;

public class CustomButton extends Button {
    private int x;
    private int y;

    public CustomButton(String text, int x, int y) {
        super(text);
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
