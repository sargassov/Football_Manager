package time;

import manager.Stadium;
import manager.Team;
import manager.Tournament;

import java.util.Calendar;

public class DayMatch extends Day {
    public Team home;
    public Team away;
    public Stadium stadium;
    public static Tournament rfpl;

    public DayMatch(){}

    public void setHome(Team home) {
        this.home = home;
    }

    public void setAway(Team away) {
        this.away = away;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public static void setRfpl(Tournament rfpl) {
        DayMatch.rfpl = rfpl;
    }


    @Override
    public String toString(){
        return date.get(Calendar.DAY_OF_MONTH) + " " + date.get(Calendar.MONTH) + " " + date.get(Calendar.YEAR) +
                " (" + home.name + " " + away.name + ") " + stadium.getTitle();
    }



}
