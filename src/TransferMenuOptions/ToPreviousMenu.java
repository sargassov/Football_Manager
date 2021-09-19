package TransferMenuOptions;

import manager.MenuClass;
import manager.Tournament;

public class ToPreviousMenu implements TransferMenuOptionsInterface {
    @Override
    public void GetOption(Tournament rfpl) {
        MenuClass.gameMenu();
    }
}
