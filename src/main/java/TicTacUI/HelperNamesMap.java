package TicTacUI;

import sample.TicTacKind;

import java.util.HashMap;
import java.util.Map;

public class HelperNamesMap {
    private Map<TicTacKind, String> namesToDisplay;

    public HelperNamesMap() {
        this.namesToDisplay = new HashMap<>();
        namesToDisplay.put(TicTacKind.CROSS, "X");
        namesToDisplay.put(TicTacKind.CIRCLE, "O");
        namesToDisplay.put(TicTacKind.EMPTY, " ");
    }

    public String getShortcut(TicTacKind kindName){
        return this.namesToDisplay.get(kindName);
    }
}
