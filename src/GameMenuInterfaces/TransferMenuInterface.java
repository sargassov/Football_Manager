package GameMenuInterfaces;

import manager.Corrector;
import manager.Tournament;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class TransferMenuInterface implements GameMenuInterface {

    @Override
    public void Do(Tournament rfpl) {
        while (true) {
            toPrintMenu(rfpl.interfaces.get(4).fields);
            int choise = Corrector.inputIntMethod(0, 2);
            rfpl.transferMenuOptionsInterfaces.get(choise).GetOption(rfpl);
        }
    }

    @Override
    public void toPrintMenu(List<String> fields) {
        for (String string : fields) {
            out.println(string);
        }
    }
}
