package hero;

import lombok.Getter;
import lombok.Setter;
import team.Team;
import util.Color;
import util.Input;

import java.util.Collection;

@Getter
@Setter
public abstract class Hero implements Color {
    protected String name;
    protected int charisma;
    protected int stamina;
    protected int intellect;
    protected int agility;
    protected int concentration;
    protected int health = 100;
    protected boolean isLeader = false;
    protected int extraPoints = 10;
    private static final int NUMBER_OF_PARAMETERS = 5;

    public Hero(int charisma, int stamina, int intellect, int agility, int concentration) {
        this.charisma = charisma;
        this.stamina = stamina;
        this.intellect = intellect;
        this.agility = agility;
        this.concentration = concentration;
    }

    private void printAllParameters() {
        System.out.println(RESET + this.name + ":" + this.toString() + "["
                     + GREEN + "1" + RESET + " -> charisma = " + this.charisma +
                ", " + GREEN + "2" + RESET + " -> stamina = " + this.stamina +
                ", " + GREEN + "3" + RESET + " -> intellect = " + this.intellect +
                ", " + GREEN + "4" + RESET + " -> agility = " + this.agility +
                ", " + GREEN + "5" + RESET + " -> concentration = " + this.concentration +
                ']');
    }
    public static void upgradePoints() {
        System.out.println(RED + "\tNow you should upgrade your hero. You have " +
                GREEN + "10" + RED + " points for that");
        Collection<Hero> hero = Team.getMapHero().values();
        for (Hero h : hero) {
            System.out.println("\t\tUpgrade " + GREEN + h.getName() + ": " + h.toString());
            distributingUpgradePoints(h);
        }
    }
    private static int chooseCountOfExtraPoints(Hero hero){
        int num = Input.checkingRangeInput(hero.getExtraPoints());
        hero.setExtraPoints(hero.getExtraPoints() - num);
        return num;
    }

    private static void distributingUpgradePoints(Hero hero) {
        while (hero.getExtraPoints() > 0) {
            upgradeParameter(hero);
            System.out.println("You have " + hero.getExtraPoints() + " extra points");
        }
    }
    private static void setParameter(Hero hero, int count) {
        System.out.println("Select parameter: ");
        int num = Input.checkingRangeInput(NUMBER_OF_PARAMETERS);
        switch (num){
            case 1: hero.setCharisma(count + hero.getCharisma());break;
            case 2: hero.setStamina(count + hero.getStamina());break;
            case 3: hero.setIntellect(count + hero.getIntellect());break;
            case 4: hero.setAgility(count + hero.getAgility());break;
            case 5: hero.setConcentration(count + hero.getConcentration());break;
        }
    }
    private static void upgradeParameter(Hero hero) {
        System.out.print(YELLOW + "Upgrade your hero: " + CYAN);
        hero.printAllParameters();
        System.out.println(YELLOW + "\tSelect count of points: ");
        setParameter(hero, chooseCountOfExtraPoints(hero));
    }
}
