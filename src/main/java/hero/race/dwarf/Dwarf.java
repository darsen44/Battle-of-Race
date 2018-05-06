package hero.race.dwarf;

import hero.Hero;

public abstract class Dwarf extends Hero {
    public Dwarf() {
        super(5, 45, 15, 20, 5);
    }

    @Override
    public String toString() {
        return "Dwarf{" +
                "charisma=" + charisma +
                ", stamina=" + stamina +
                ", intellect=" + intellect +
                ", agility=" + agility +
                ", concentration=" + concentration +
                '}';
    }
}

