package coaches;

import coaches.Coach;
import manager.Position;

public class GoalkeeperCoach extends Coach {
    public  GoalkeeperCoach(String name){
        coachPos = Position.GOALKEEPER;
        this.name = name;
    }
}
