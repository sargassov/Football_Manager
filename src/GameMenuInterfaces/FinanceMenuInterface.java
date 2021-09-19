package GameMenuInterfaces;

import manager.Corrector;
import manager.Tournament;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class FinanceMenuInterface implements GameMenuInterface {

    @Override
    public void Do(Tournament rfpl) {
        while(true){
            toPrintMenu(rfpl.interfaces.get(6).fields);
            int choise = Corrector.inputIntMethod(0, 3);
            rfpl.financeMenuOptionsInterfaces.get(choise).getOption(rfpl);
        }
    }

    @Override
    public void toPrintMenu(List<String> fields) {
        for (String string : fields) {
            out.println(string);
        }
    }
}
