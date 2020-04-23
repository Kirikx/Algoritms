package com.kirikomp.Game;

class Doctor extends Hero {

    public Doctor(int heal, String name, int damage, int addHeal, String typeHero) {
        super(heal, name, damage, addHeal, typeHero);
    }

    @Override
    void hit(Hero hero) {
        System.out.println("Доктор не может бить!");
    }

    @Override
    void healing(Hero hero) {
        hero.addHealth(addHeal);
    }
}
