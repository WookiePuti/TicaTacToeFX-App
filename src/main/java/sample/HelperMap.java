package sample;

import java.util.HashMap;
import java.util.Map;

public class HelperMap {
    private Map<TicTacKind, WinKind> helpMap;

    public HelperMap() {
        helpMap = new HashMap<>();
        helpMap.put(TicTacKind.CIRCLE, WinKind.CIRCLE);
        helpMap.put(TicTacKind.CROSS, WinKind.CROSS);
    }

    public WinKind getWinKind(TicTacKind kind){
        return helpMap.get(kind);
    }
}
