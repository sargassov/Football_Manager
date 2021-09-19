package GameMenuInterfaces;
import manager.Tournament;

import java.util.ArrayList;
import java.util.List;

public interface GameMenuInterface {
    public void Do(Tournament rfpl);
    public void toPrintMenu(List<String> fields);

}
