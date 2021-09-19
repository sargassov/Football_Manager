package GameMenuInterfaces;
import manager.Tournament;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;
public class QuitInterface implements GameMenuInterface {



    @Override
    public void Do(Tournament rfpl) {
            out.println("QUIT");

    }

    @Override
    public void toPrintMenu(List<String> fields) {

    }
}
