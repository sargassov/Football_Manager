package StadiumMenuOptions;

import manager.MenuClass;
import manager.Tournament;

public class ToPreviousMenu implements StadiumMenuOptionInterface{
    @Override
    public void getOption(Tournament rfpl) { MenuClass.gameMenu(); }
}
