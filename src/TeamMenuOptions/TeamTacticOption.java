package TeamMenuOptions;
import Tables.TeamTacticOptionTable;
import manager.*;
import strategies.ConcretStrategy;

import java.util.*;
import static manager.Corrector.getS;
import static java.lang.System.out;

public class TeamTacticOption implements TeamMenuOptionsInterface {

    //private Player targetPlayer;
    private static int spVal = 40;
    Scanner scanner;

    @Override
    public void getOption(Tournament rfpl) {

        new TeamTacticOptionTable(this, spVal).toPrint(rfpl);
        scanner = new Scanner(System.in);

        int choise = Corrector.inputIntMethod(0, 5);
        choise--;

        if(choise < 0) return;

        else rfpl.myTeam.strategy = rfpl.strategies.get(choise);
        rfpl.myTeam.teamPower = 0;

        for (Player player : rfpl.myTeam.playerList) {
            player.strategyPlace = -100;
            if(player.isCapitan){
                player.isCapitan = false;
            }
        }
        printPlayers(rfpl);
    }

    private void printPlayers(Tournament rfpl) {
        int currentPosition = 0;
        out.println("\n\n" + getS(40) + "C H O O S I N G   A   P L A C E M E N T\n");
        for(ConcretStrategy allReplacement : rfpl.myTeam.strategy.getConcretStrategyList()){
            int currentPositionToPrint = 0;
            for(ConcretStrategy closedReplacement : rfpl.myTeam.strategy.getConcretStrategyList()){
                if(currentPositionToPrint < 11) out.print(getS(40) + closedReplacement.position + " ");
                else out.print(getS(40) + "Sub " + closedReplacement.position + " ");
                Player targetPlayer = getTargetPlayer(rfpl, (short)currentPositionToPrint);
                if(targetPlayer != null){
                    out.println(targetPlayer.name);
                }
                else out.println();
                if(currentPositionToPrint == 10 || currentPositionToPrint == 17) out.println("\n");
                currentPositionToPrint++;
            }
            out.println("Team power = " + rfpl.myTeam.teamPower / 11 + "\n\n" + getS(44) +"OTHER PLAYERS IN TEAM:\nCount\tName                       " +
                    "Natio\tNum\tPos\t\tGk\tDef\tMid\tForw\tCap\tYear\tPrice\n");
            int currentPlayerInTeam = 0;
            ArrayList<Integer>numbersToChoose = new ArrayList<>();
            for(Player player : rfpl.myTeam.playerList){
                if(player.strategyPlace < 0){
                    if(player.position.equals(allReplacement.position)){
                        numbersToChoose.add(currentPlayerInTeam);
                        out.println(currentPlayerInTeam + 1 + "\t\t" + Corrector.inspacer(player.name) + player.natio + "\t\t" + player.number +
                                "\t" + player.position + "\t\t" + player.gkAble + "\t" + player.defAble + "\t" +
                                player.midAble + "\t" + player.forwAble + "\t\t" + player.captainAble + "\t" +
                                player.yearBirth + "\t" + player.price);
                    }
                }
                currentPlayerInTeam++;
            }
            out.println("\nEnter a count number to edi" +
                    "t a " + allReplacement.position + ": ");
            int count = Corrector.inputNumberFromTheList(numbersToChoose);
            rfpl.myTeam.playerList.get(count).strategyPlace = (int)currentPosition;
            if (currentPosition < 11) {
                rfpl.myTeam.teamPower += rfpl.myTeam.playerList.get(count).power;
            }
            currentPosition++;
        }
    }

    public Player getTargetPlayer(Tournament rfpl, int coef){
        for(Player player : rfpl.myTeam.playerList){
            if(player.strategyPlace == coef){
                return player;
            }
        }
        return null;
    }


}

