package team;

import hero.*;
import hero.race.dwarf.Mechanist;
import hero.race.dwarf.Warrior;
import hero.race.elf.Gunslinger;
import hero.race.elf.Mage;
import hero.race.human.Paladin;
import hero.race.human.Priest;
import lombok.Getter;
import util.*;

import java.util.*;


public class Team implements Color {
    private final int NUMBER_OF_HEROES = 3;
    private static final int NUMBER_OF_TYPES_OF_HEROES = 6;
    @Getter
    private static Map<Integer, Hero> mapHero = new HashMap<>();
    private static Map<Integer,Hero> h = new HashMap<>(); //intermediate map for choosing a hero


    public Team() {
        Message.infoMessage();
        chooseMembers();
        chooseLeader();
        Hero.upgradePoints();

    }

    private void chooseMembers() {
        for (int i = 0; i < NUMBER_OF_HEROES; i++) {
            chooseHero(i);
        }
    }

    private void chooseHero(int i) {
        Message.raceInfo();
        System.out.println(YELLOW + "\tChoose " + (i + 1) + " member of your team: ");
        Message.allHeroesNames();
        Hero hero = selectHero();
        System.out.println(YELLOW + "\tEnter name of " + (i + 1) + " member: ");
        hero.setName(Input.chooseNameOfHero());
        mapHero.put(i + 1, hero);
    }

    private static Hero selectHero(){
        int num = Input.checkingRangeInput(NUMBER_OF_TYPES_OF_HEROES);
        h.put(1,new Mechanist());
        h.put(2,new Warrior());
        h.put(3,new Gunslinger());
        h.put(4,new Mage());
        h.put(5,new Paladin());
        h.put(6,new Priest());
        return h.get(num);

    }

    private void chooseLeader() {
        MembersInfo();
        System.out.print(YELLOW + "Select leader of team: ");
        int leader = Input.checkingRangeInput(NUMBER_OF_HEROES);
        mapHero.get(leader).setLeader(true);
        System.out.println("Leader is " + CYAN + mapHero.get(leader).getName() + " : " + mapHero.get(leader).toString());

    }

    private void MembersInfo() {
        System.out.print(RED + "Your team: ");
        for (int i = 0; i < 3; i++) {
            System.out.print(GREEN + "[" + mapHero.get(i + 1).getName() + ": " + CYAN + mapHero.get(i + 1).toString()
                    + GREEN + " -> " + CYAN + (i + 1) + GREEN + "]");
        }
        System.out.println();
    }

//    private void upgradePoints() {
//        System.out.println(RED + "\tNow you should upgrade your hero. You have " +
//                GREEN + "10" + RED + " points for that");
//        Collection<Hero> hero = mapHero.values();
//        for (Hero h : hero) {
//            System.out.println("\t\tUpgrade " + GREEN + h.getName() + ": " + h.toString());
//            distributingUpgradePoints(h);
//        }
//    }
//    private static int chooseCountOfExtraPoints(Hero hero){
//        int num = Input.checkingRangeInput(hero.getExtraPoints());
//        hero.setExtraPoints(hero.getExtraPoints() - num);
//        return num;
//    }
//
//    private void distributingUpgradePoints(Hero hero) {
//        while (hero.getExtraPoints() > 0) {
//            upgradeParameter(hero);
//            System.out.println("You have " + hero.getExtraPoints() + " extra points");
//        }
//    }
//    private static void setParameter(Hero hero, int count) {
//        System.out.println("Select parameter: ");
//        int num = Input.checkingRangeInput(NUMBER_OF_PARAMETERS);
//        switch (num){
//            case 1: hero.setCharisma(count + hero.getCharisma());break;
//            case 2: hero.setStamina(count + hero.getStamina());break;
//            case 3: hero.setIntellect(count + hero.getIntellect());break;
//            case 4: hero.setAgility(count + hero.getAgility());break;
//            case 5: hero.setConcentration(count + hero.getConcentration());break;
//        }
//    }
//    private void upgradeParameter(Hero hero) {
//        System.out.print(YELLOW + "Upgrade your hero: " + CYAN);
//        hero.printAllParameters();
//        System.out.println(YELLOW + "\tSelect count of points: ");
//        setParameter(hero, chooseCountOfExtraPoints(hero));
//    }


}
