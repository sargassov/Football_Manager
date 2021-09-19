package GameMenuInterfaces;
import manager.Corrector;
import manager.Tournament;

import java.util.List;

import static java.lang.System.out;


public class TeamMenuInterface implements GameMenuInterface{
    @Override
    public void Do(Tournament rfpl) {
        while (true) {
            toPrintMenu(rfpl.interfaces.get(2).fields);
            int choise = Corrector.inputIntMethod(0, 5);
            rfpl.TeamMenuInterfaces.get(choise).getOption(rfpl);
        }
    }

    @Override
    public void toPrintMenu(List<String> fields){
        for (String string : fields) {
            out.println(string);
        }
    }
}
