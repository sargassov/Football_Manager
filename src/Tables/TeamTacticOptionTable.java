package Tables;

import TeamMenuOptions.TeamTacticOption;
import manager.*;
import strategies.ConcretStrategy;

import static java.lang.System.out;
import static manager.Corrector.getS;

public class TeamTacticOptionTable extends Table implements Data{

    private Tournament rfpl;
    private static int spVal;
    private Player targetPlayer;
    private TeamTacticOption tacticOption;

    public TeamTacticOptionTable(TeamTacticOption tacticOption, int spVal){
        TeamTacticOptionTable.spVal = spVal;
        this.tacticOption = tacticOption;
    }


    @Override
    public void toPrint(Tournament rfpl) {

        this.rfpl = rfpl;

        out.print("\n\n" + getS(spVal) + "U S E F U L   S T R A T E G Y  ");
        Corrector.wordUpperCase(rfpl.myTeam.name);
        out.println("\n\n\n\n");
        int coef = 0;
        for (ConcretStrategy concretStrategy : rfpl.myTeam.strategy.getConcretStrategyList()) {
            targetPlayer = tacticOption.getTargetPlayer(rfpl, coef);

            if(targetPlayer == null){
                if(coef < 11) out.print(getS(spVal));
                if (coef == 11) out.println("\n\n");
                if(coef > 10) out.print(getS(48));
                out.println("Without Player (0) ");
                coef++;
                continue;
            }

            if (coef < 11) {

                if (concretStrategy.position.equals(Position.GOALKEEPER)) out.println(getS(spVal) + "Goalkeeper: " +
                        targetPlayer.name + " (" + targetPlayer.gkAble + ") " + isCaptain(targetPlayer));
                else if (concretStrategy.position.equals(Position.DEFENDER)) out.println(getS(spVal) + "Defender: " +
                        targetPlayer.name + " (" + targetPlayer.defAble + ") " + isCaptain(targetPlayer));
                else if (concretStrategy.position.equals(Position.MIDFIELDER)) out.println(getS(spVal) + "Midfielder: " +
                        targetPlayer.name + " (" + targetPlayer.midAble + ") " + isCaptain(targetPlayer));
                else out.println(getS(spVal) + "Forward: " +
                            targetPlayer.name + " (" + targetPlayer.forwAble + ") " + isCaptain(targetPlayer));
            }
            else if (coef == 11) out.println("\n\n");
            if(coef > 10) out.println(getS(48) + "Substitution: " + targetPlayer.name);
            coef++;
        }
        out.println("\n\n\t\tTeam Power: " + rfpl.myTeam.teamPower / 11 + "\n");
        //system("pause");
        out.println("\n\n" + getS(32) +"If you choose a new strategy this placement will be lost\n\n\n\n\n"
                + getS(44) + "==> 1. (4 - 4 - 2)" +
                "\n\n\n\n" + getS(44) + "==> 2. (3 - 5 - 2)\n\n\n\n" + getS(44) +"==> 3. (3 - 4 - 3)" +
                "\n\n\n\n" + getS(44) + "==> 4. (4 - 5 - 1)\n\n\n\n" + getS(44) + "==> 5. (5 - 4 - 1)" +
                "\n\n\n\n" + getS(44) + "==> 0. Back to previos menu\n");
    }


    private String isCaptain(Player player){
        if(player.isCapitan)
            return "CAPTAIN";
        return "";
    }
}
