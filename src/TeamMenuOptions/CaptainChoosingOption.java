package TeamMenuOptions;
import manager.Corrector;
import manager.Player;
import manager.Tournament;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class CaptainChoosingOption implements TeamMenuOptionsInterface {
    @Override
    public void getOption(Tournament rfpl) {
        out.print("\n\n" + Corrector.getS(40)); // тeкущего капитана добавать
        Corrector.wordUpperCase("captain choosing menu");
        out.println("\n");
        Player captain = getCaptain(rfpl.myTeam.playerList);
        if(captain == null){
            out.print(Corrector.getS(35) + "There is no captain in " + rfpl.myTeam.name +
                    ". Choose it?\n" + Corrector.getS(48) + "1 - \"Yes\"\n" +
                    Corrector.getS(48) + "0 - \"No\": ");
        }
        else{
            out.print(Corrector.getS(32) + "A captain of " + rfpl.myTeam.name + " is  ");
            Corrector.wordUpperCase(captain.name);
            out.println("(" + captain.captainAble + ")\n\n" + Corrector.getS(40) +
                    "    Do you want to change ?\n\n" + Corrector.getS(50) + "1 -\"Yes\"\n" +
                    Corrector.getS(50) + "0 - \"No\": ");
        }
        int choise = Corrector.inputIntMethod(0, 1);

        if(choise == 0) return;
        else {
            out.println(rfpl.myTeam.teamPower);
            if(captain != null && captain.strategyPlace > -1){
                rfpl.myTeam.teamPower -= captain.captainAble;
                captain.isCapitan = false;
            }

            out.println(rfpl.myTeam.teamPower);
            choosingForNewCaptain(rfpl);
        };
    }

    private void choosingForNewCaptain(Tournament rfpl) {

        out.println("Other players:\n");
        List <Player> compareCaps =  rfpl.myTeam.playerList.stream()
                .sorted((player1, player2) -> player2.captainAble - player1.captainAble)
                .collect(Collectors.toList());
        out.println("Number\t Name\t\t\tCaptain abilities\n\n");
        int count = 1;
        for(Player player : compareCaps){
            out.println(count + "\t" + Corrector.inspacer(player.name) + "\t" + player.captainAble);
            count++;
        }
        out.print("\n\nChoose a captain: ");
        int choise = Corrector.inputIntMethod(1, rfpl.myTeam.playerList.size());
        choise--;
        compareCaps.get(choise).isCapitan = true;
        out.println(rfpl.myTeam.teamPower);
        if(compareCaps.get(choise).strategyPlace > -1)
            rfpl.myTeam.teamPower += compareCaps.get(choise).captainAble;
        out.println(rfpl.myTeam.teamPower);
        out.print("\n" + Corrector.getS(40));
        Corrector.wordUpperCase(compareCaps.get(choise).name);
        out.println(" is new captain of " + rfpl.myTeam.name);
    }

    private Player getCaptain (ArrayList < Player > list) {
        Optional<Player> opt = list.stream()
                .filter(player -> player.isCapitan)
                .findAny();
        if (opt.isPresent())
            return opt.get();
        return null;
    }
}




