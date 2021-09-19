package TrainingMenuOptions;

import manager.MenuClass;
import manager.Tournament;

public class ToPreviousMenu implements TrainingMenuOptionsInterface {
    @Override
    public void GetOption(Tournament rfpl) {
        MenuClass.gameMenu();

    }
}
