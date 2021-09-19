package CalendarMenuOptions;

import manager.MenuClass;
import manager.Tournament;

public class ToPreviousMenu implements CalendarMenuOptionsInterface {
    @Override
    public void getOption(Tournament rfpl) {
        MenuClass.gameMenu();
    }
}
