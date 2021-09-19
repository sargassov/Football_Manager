package manager;
import CalendarMenuOptions.CalendarMenuOptionsInterface;
import CalendarMenuOptions.PlayingCalendar;
import CalendarMenuOptions.VisualCalendar;
import FinanceMenuOptions.*;
import GameMenuInterfaces.*;
import StadiumMenuOptions.*;
import TeamMenuOptions.*;
import TrainingMenuOptions.CoachesMenu;
import TrainingMenuOptions.TrainingMenuOptionsInterface;
import TrainingMenuOptions.TrainingProgramsMenu;
import TransferMenuOptions.BuyingPlayerOption;
import TransferMenuOptions.SellPlayerOption;
import TransferMenuOptions.TransferMenuOptionsInterface;
import finance.Bank;
import finance.Sponsor;
import strategies.Strategy;
import time.Day;
import time.DayMatch;

import java.util.*;

import static java.lang.System.out;

public class Tournament {
    public String name;
    public Team[] teams;
    public ArrayList<Player>youthPool;
    public ArrayList<Bank>banks;
    public ArrayList<Sponsor>sponsorList;
    public ArrayList<ArrayList<DayMatch>>shedule;
    public ArrayList<ArrayList<Day>> calendar;
    public ArrayList<GameMenuInterface> userInterfaces;
    public ArrayList<TeamMenuOptionsInterface> TeamMenuInterfaces;
    public ArrayList<TrainingMenuOptionsInterface> trainingMenuOptionsInterfaces;
    public ArrayList<TransferMenuOptionsInterface> transferMenuOptionsInterfaces;
    public ArrayList<CalendarMenuOptionsInterface> calendarMenuOptionsInterfaces;
    public ArrayList<FinanceMenuOptionsInterface> financeMenuOptionsInterfaces;
    public ArrayList<StadiumMenuOptionInterface> stadiumMenuOptionInterfaces;
    public Team myTeam = null;
    public List<Strategy> strategies;
    public List<Interface>interfaces;
    public Calendar currentDate;
    public Interface transferPrintInterface;
    public Interface visualCalendarInterface;
    public boolean wasAtTheYouthAcademy = false;
    public int indexOfUserTeam;
    private static final String TRANSFER_INTERFACE = "src\\textFiles\\transfer_interface.txt";
    private static final String VISUAL_CALENDAR_INTERFACE = "src\\textFiles\\visualCalendarInterface.txt";

    public Tournament(String NameOfLeague){
        name = NameOfLeague;
        teams = new Team[16];
        strategies = null;
        optionConstructor();
        interfaces = null;
        currentDate = new GregorianCalendar(2019, Calendar.AUGUST,1);
        transferPrintInterface = new Interface(TRANSFER_INTERFACE);
        visualCalendarInterface = new Interface(VISUAL_CALENDAR_INTERFACE);
    }

    private void optionConstructor() {
        sheduleConstructor();
        calendarConstructor();
        IntefaceConstructor();
        teamMenuInterfacesConstructor();
        trainingMenuInterfaceConstructor();
        transferMenuInterfaceConstructor();
        calendarMenuInterfacesConstructor();
        financeMenuInterfacesConstructor();
        stadiumMenuInterfacesConstructor();
    }

    private void stadiumMenuInterfacesConstructor() {
        stadiumMenuOptionInterfaces = new ArrayList<>(Arrays.asList(
                new StadiumMenuOptions.ToPreviousMenu(),
                new InfoOption(),
                new SetTicketCostOption(),
                new SplitSectorsOption(),
                new MarketOption(),
                new BuildSittingPlaceOption()
        ));
    }

    private void financeMenuInterfacesConstructor(){
        financeMenuOptionsInterfaces = new ArrayList<>(Arrays.asList(
                new FinanceMenuOptions.ToPreviousMenu(),
                new RevenueOption(),
                new ExpensesOption(),
                new BanksOption()));
    }

    private void calendarMenuInterfacesConstructor(){
        calendarMenuOptionsInterfaces = new ArrayList<>(Arrays.asList(
                new CalendarMenuOptions.ToPreviousMenu(),
                new PlayingCalendar(),
                new VisualCalendar()));
    }

    private void transferMenuInterfaceConstructor(){
        transferMenuOptionsInterfaces = new ArrayList<>(Arrays.asList(
                new TransferMenuOptions.ToPreviousMenu(),
                new BuyingPlayerOption(),
                new SellPlayerOption()));
    }

    private void trainingMenuInterfaceConstructor(){
        trainingMenuOptionsInterfaces = new ArrayList<>(Arrays.asList(
                new TrainingMenuOptions.ToPreviousMenu(),
                new CoachesMenu(),
                new TrainingProgramsMenu()));
    }

    private void teamMenuInterfacesConstructor(){
        TeamMenuInterfaces = new ArrayList<>(Arrays.asList(
                new TeamMenuOptions.ToPreviousMenu(),
                new ListPlayerOption(),
                new TeamTacticOption(),
                new CaptainChoosingOption(),
                new PlayerEditorOption(),
                new YouthAcademyOption()));
    }

    private void sheduleConstructor(){
        shedule = new ArrayList<ArrayList<DayMatch>>();
        for(short a = 0; a < 30; a++){
            ArrayList<DayMatch> DmOuter = new ArrayList<DayMatch>();
            for(short b = 0; b < 8; b++){
                DayMatch DmInner = new DayMatch();
                DmOuter.add(DmInner);
            }
            shedule.add(DmOuter);
        }
    }

    private void calendarConstructor(){
        calendar = new ArrayList<>();
        int[] buffshort = {31,30,31,30,31,31,29,31,30,31,30};

        for(int s : buffshort){
            ArrayList<Day> month = new ArrayList<>();
            for(short x = 0; x < s; x++){
                Day day = new Day();
                month.add(day);
            }

            out.println(month.size());
            calendar.add(month);
        }
    }

    private void IntefaceConstructor(){
        userInterfaces = new ArrayList<>(Arrays.asList(
                new QuitInterface(),
                new NextMatchMenuInterface(),
                new TeamMenuInterface(),
                new TrainingMenuInterface(),
                new TransferMenuInterface(),
                new CalendarMenuInterface(),
                new FinanceMenuInterface(),
                new StadiumMenuInterface(),
                new LeagueMenuInterface(),
                new CheatCodeMenuInterface()));
    }
}
