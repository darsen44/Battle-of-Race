package util;

import hero.race.dwarf.Dwarf;
import hero.race.dwarf.Mechanist;
import hero.race.dwarf.Warrior;
import hero.race.elf.Gunslinger;
import hero.race.elf.Mage;
import hero.race.human.Paladin;
import hero.race.human.Priest;

import java.awt.*;

public class Message implements Color {

    public static void infoMessage() {
        System.out.println(RED + "\t---------------------------------Battle Of Race-------------------------------\n"
                + RESET + "\tIt's simple console, RPG game. You must choose 3 member of team( leader + 2 simple member).\n"
                + "\tIn case of a leader's death or if we find special item \"the \n" +
                "\tGreat Crystal\", the game will end. The team can be compiled from the \n" +
                "\tcharacters of three races: Elf, Human, Dwarf.\n"
                + RED + "\n\t\tLets start with creating the Team:");
    }

    public static void raceInfo() {
        System.out.println(GREEN + "---------------------DWARF----------------------\n" + CYAN +
                "Mechanist or Warrior: " + RESET + "[charisma = 5, stamina = 45, intellect = 15, agility = 20, concentration = 5]" +
                GREEN + "\n---------------------ELF----------------------\n" + CYAN +
                "Gunslinger or Mage: " + RESET + "[charisma = 15, stamina = 10, intellect = 25, agility = 22, concentration = 18]" +
                GREEN + "\n---------------------HUMAN----------------------\n" + CYAN +
                "Paladin or Priest: " + RESET + "[charisma = 10, stamina = 30, intellect = 20, agility = 15, concentration = 15]");
    }

    public static void errorEmptyInput() {
        System.out.print(RED + "\tSorry, your field empty :( " + RESET);
    }

    public static void allHeroesNames() {
        System.out.println(GREEN + "[ " + CYAN + "Mechanist" + GREEN + "-> 1][ " + CYAN + "Warrior " + GREEN + "-> 2][ " + CYAN + "Gunslinger " + GREEN + "-> 3]" +
                "[ " + CYAN + "Mage " + GREEN + "-> 4][ " + CYAN + "Paladin " + GREEN + "-> 5][ " + CYAN + "Priest" + GREEN + " -> 6]");
    }
}

