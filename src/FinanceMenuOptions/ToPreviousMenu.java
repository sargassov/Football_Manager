package FinanceMenuOptions;

import manager.MenuClass;
import manager.Tournament;

public class ToPreviousMenu implements FinanceMenuOptionsInterface {
    @Override
    public void getOption(Tournament rfpl) {
        MenuClass.gameMenu();
    }
}
