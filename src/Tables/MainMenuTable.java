package Tables;

import manager.Corrector;
import manager.Tournament;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static java.lang.System.out;

public class MainMenuTable extends Table implements Data{

    private Tournament rfpl;
    private List<String> fields;

    public MainMenuTable(List<String> fields){
        this.fields = fields;
    }


    @Override
    public void toPrint(Tournament rfpl) {
        this.rfpl = rfpl;

        Corrector.notNullChecking(fields);

        for (String string : fields) {
            if(!string.contains("NEXT")) out.println(string);
            else{
                String newString = string + "    (" +
                        + rfpl.currentDate.get(Calendar.DAY_OF_MONTH) + " " +
                        monthInWord(rfpl.currentDate.get(Calendar.MONTH)) + " "
                        + rfpl.currentDate.get(Calendar.YEAR) + ")";
                out.println(newString);
            }
        }
    }

    private static String monthInWord(int num){

        List<String> months = Arrays.asList("January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");

        return months.get(num);
    }
}
