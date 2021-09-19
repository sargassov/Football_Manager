package TeamMenuOptions;

import manager.MenuClass;
import manager.Tournament;

public class ToPreviousMenu implements TeamMenuOptionsInterface {
    @Override
    public void getOption(Tournament rfpl) {
        MenuClass.gameMenu();
    }
}
