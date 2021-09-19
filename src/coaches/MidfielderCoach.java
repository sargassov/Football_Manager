package coaches;

import coaches.Coach;
import manager.Position;

public class MidfielderCoach extends Coach {
    public MidfielderCoach(String name){
        coachPos = Position.MIDFIELDER;
        this.name = name;
    }
}
