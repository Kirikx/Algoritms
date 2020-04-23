package com.kirikomp.Game;

abstract class Hero {

    protected int health;
    protected String name;
    protected int damage;
    protected int addHeal;
    protected String typeHero;
    protected boolean isAlive = true;

    public Hero(int health, String name, int damage, int addHeal, String typeHero) {
        this.health = health;
        this.name = name;
        this.damage = damage;
        this.addHeal = addHeal;
        this.typeHero = typeHero;
    }


    abstract void hit(Hero hero);

    abstract void healing(Hero hero);

    void causeDamage(int damage) {
        if(health < 0) {
            System.out.println("Герой уже мертвый!");
            this.isAlive = false;
        } else {
            health -= damage;
        }

    }

    public int getHealth() {
        return health;
    }

    void addHealth(int health) {
        this.health += health;
    }

    void info() {

        System.out.println(name + " " + (health < 0 ? "Герой мертвый" : health) + " " + damage);
    }

    String getInfo() {
        return name + " " + (health < 0 ? "Герой мертвый" : health) + " " + damage;
    }
}
