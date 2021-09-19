package manager;

import Tables.MainMenuTable;
import coaches.Manager;

import java.util.*;

import static java.lang.System.out;

public class MenuClass {

    private static Tournament rfpl;
    private static String name;
    private static String lastname;
    private static String club;
    private static Scanner scanner = new Scanner(System.in);
    private static final String ENTER_NAME = "\n\nEnter your name: ";
    private static final String ENTER_LASTNAME = "\n\nEnter your lastname: ";
    private static final String ENTER_MANAGE_TEAM = "\n\nEnter a manage team: ";



    public static void newGameMenu(Tournament tournament){

        rfpl = tournament;

        out.print(ENTER_NAME);
        //name = scanner.nextLine();
        name = "Mark";////////////////////////////////////////////////////////////////////////////

        out.print(ENTER_LASTNAME);
        //lastname = scanner.nextLine();
        lastname = "Giovanni";////////////////////////////////////////////////////////////////////////
        lastname += " ";
        lastname += name;
        out.println("\n\n");

        for (Team team : rfpl.teams) {
            out.print("\t\t||" + team.name + "||\n");
        }
        out.print(ENTER_MANAGE_TEAM);
        //cin >> club;///////////////////////////////////////////////////////////////////////////
        //club = scanner.nextLine();
        club = "CSKA";

        isClub();
    }

    private static void isClub() {
        boolean teamExist = false;
        for (Team team : rfpl.teams) {
            if (club.equals(team.name)) {
                teamExist = true;
                rfpl.myTeam = team;
                rfpl.indexOfUserTeam = rfpl.myTeam.teamCounter();
                Manager manager = new Manager(lastname);
                rfpl.myTeam.coaches.set(0, manager);
                break;
            }
        }
        if (!teamExist) {
            MessageClass.incorrectName();
            scanner = new Scanner(System.in);
            club = scanner.nextLine();
            isClub();
        }
    }

    public static void gameMenu(){
        new MainMenuTable(rfpl.interfaces.get(0).fields).toPrint(rfpl);
        int choise = Corrector.inputIntMethod(0, 9);
        rfpl.userInterfaces.get(choise).Do(rfpl);
    }



}
