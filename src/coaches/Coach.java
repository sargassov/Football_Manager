package coaches;

import manager.Player;
import manager.Position;

public class Coach {
    public CoachProgram currentCoachProgram = CoachProgram.STANDART;
    public String name;
    public Player playerOnTrain = null;
    public Coach(){}
    public Position coachPos;
    public int levelOfCoach;
    public int wage;

}
