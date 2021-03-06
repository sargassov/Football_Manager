package FinanceMenuOptions;

import Tables.ExpensesTable;
import manager.Corrector;
import manager.Tournament;

public class ExpensesOption implements FinanceMenuOptionsInterface {

    private static final int sVal = 40;

    @Override
    public void getOption(Tournament rfpl) {

        System.out.print("\n\n\n\n" + Corrector.getS(sVal));
        Corrector.wordUpperCase("expenses mode " + rfpl.myTeam.name);
        System.out.println("\n\n");

        new ExpensesTable().toPrint(rfpl);

        int choise = Corrector.inputIntMethod(0, 2);


    }
}
