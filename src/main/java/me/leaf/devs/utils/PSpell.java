package me.leaf.devs.utils;

public class PSpell {

    public PSpell(Spell spell1, Spell spell2, Spell spell3) {

    }

    private Spell spell1;
    private Spell spell2;
    private Spell spell3;

    public Spell getSpell(int spell) {
        if(spell == 1) {
            return spell1;
        } else if(spell == 2) {
            return spell2;
        } else {
            return spell3;
        }
    }
    
}
