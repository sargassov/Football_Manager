package GameMenuInterfaces;

import manager.Corrector;
import manager.Tournament;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class TrainingMenuInterface implements GameMenuInterface {

    @Override
    public void Do(Tournament rfpl) {
        while (true) {
            toPrintMenu(rfpl.interfaces.get(3).fields);
            int choise = Corrector.inputIntMethod(0, 2);
            rfpl.trainingMenuOptionsInterfaces.get(choise).GetOption(rfpl);
        }
    }

    @Override
    public void toPrintMenu(List<String> fields) {
        for (String string : fields) {
            out.println(string);
        }
    }
}
