package com.kirikomp.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class GameFrame extends JFrame {
    private static final int WIN_HEIGHT = 500;
    private static final int WIN_WIDTH = 800;
    private int ROUNDS = 0;
    private DefaultListModel<String> modelFirstCommand = new DefaultListModel<>();
    private DefaultListModel<String> modelSecondCommand = new DefaultListModel<>();
    private ArrayList<Hero> team1 = new ArrayList<>();
    private ArrayList<Hero> team2 = new ArrayList<>();
    private Game game;
    private Random randomHeal = new Random();
    private Random randomDamage = new Random();
    private Random randomAddHeel = new Random();
    private JTextArea textArea;
    private boolean nameBoolean1 = true;
    private boolean nameBoolean2 = true;
    private boolean nameBoolean3 = true;

    public int getRounds() {
        return ROUNDS;
    }

    public ArrayList<Hero> getTeam1() {
        return team1;
    }

    public ArrayList<Hero> getTeam2() {
        return team2;
    }

    public boolean checkCountCircle(String str) {
        int d;
        try {
            d = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            clearMessages();
            addMessage("Вводимое значение должно быть числом.");
            return false;
        }
        if (d < 0) {
            clearMessages();
            addMessage("Вводимое значение должно быть положительным.");
            return false;
        }
        if (d > 10) {
            clearMessages();
            addMessage("Вводимое значение должно быть меньше 10.");
            return false;
        }
        ROUNDS = d;
        return true;
    }

    public String initHero(String typeHero, ArrayList<Hero> team) {
        int heal = randomHeal.nextInt(50);
        int damage = randomDamage.nextInt(20);
        String name;
        if (team.isEmpty() || team.stream().filter(hero -> hero.typeHero.equals(typeHero)).findAny().orElse(null) == null) {
            switch (typeHero) {
                case "Warrior":
                    heal += 200;
                    damage += 50;
                    if (nameBoolean1) {
                        name = "Тигрилл";
                        nameBoolean1 = false;
                    } else {
                        name = "Минитавр";
                    }
                    team.add(new Warrior(heal, name, damage, 0, typeHero));
                    return typeHero + ": " + name + " (жизнь = " + heal + ", урон = " + damage + ")";
                case "Assasin":
                    heal += 100;
                    damage += 70;
                    if (nameBoolean2) {
                        name = "Акалина";
                        nameBoolean2 = false;
                    } else {
                        name = "МТСДжинкс";
                    }
                    team.add(new Assasin(heal, name, damage, 0, typeHero));
                    return typeHero + ": " + name + " (жизнь = " + heal + ", урон = " + damage + ")";
                case "Doctor":
                    heal += 100;
                    if (nameBoolean3) {
                        name = "Жанка";
                        nameBoolean3 = false;
                    } else {
                        name = "З-ой";
                    }
                    int addHeal = randomAddHeel.nextInt(20) + 40;
                    team.add(new Doctor(heal, name, 0, 60, typeHero));
                    return typeHero + ": " + name + " (жизнь = " + heal + ", лечение = " + addHeal + ")";

            }
        } else {
            clearMessages();
            addMessage("В команде может быть только 1 " + typeHero + " !!!");
        }
        return null;
    }

    public void addMessage(String message) {
        textArea.append(message);
        textArea.append("\n");
    }

    public void clearMessages() {
        textArea.setText("");
    }

    public GameFrame() {

        String[] heros = {"Warrior", "Assasin", "Doctor"};
        game = new Game(this);

        setTitle("Hero Game");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIN_WIDTH, WIN_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);

        JComboBox<String> bookList1 = new JComboBox<>(heros);
        JComboBox<String> bookList2 = new JComboBox<>(heros);

        JButton butLeft = new JButton("Добавить");
        JButton butRight = new JButton("Добавить");

        JList<String> listLeft = new JList<>(modelFirstCommand);
        JList<String> listRight = new JList<>(modelSecondCommand);

        JTextField textField = new JTextField("1");
        JButton butStart = new JButton("Играть");
        JButton butClose = new JButton("Закрыть");

        textArea = new JTextArea(12, 1);

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        //выподающий JComboBox первой команды
        c.weightx = 0.45;
        c.weighty = 0.02;
        c.gridx = 0;
        c.gridy = 0;
        add(bookList1, c);

        c.weightx = 0.05;
        c.gridx = 1;
        add(butLeft, c);

        //выподающий JComboBox второй команды
        c.weightx = 0.45;
        c.gridx = 2;
        add(bookList2, c);

        c.weightx = 0.05;
        c.gridx = 3;
        add(butRight, c);

        //состав первой команды
        c.weightx = 1;
        c.weighty = 0.4;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        c.insets = new Insets(0, 5, 0, 5);
        add(new JScrollPane(listLeft), c);

        //состав второй команды
        c.gridx = 2;
        add(new JScrollPane(listRight), c);

        //количесво раундов
        c.weighty = 0.01;
        c.weightx = 0.2;
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
//        add(new JLabel("Укажите кол-во раундов:"), c);

//        c.gridx = 1;
//        add(textField, c);

//        c.gridx = 1;
        add(butStart, c);

        c.gridx = 2;
        add(butClose, c);

        //табло результатов
        c.weighty = 0.4;
        c.weightx = 1;
        c.gridwidth = 4;
        c.gridx = 0;
        c.gridy = 3;
        add(textArea, c);


        butLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) bookList1.getSelectedItem();
                if (modelFirstCommand.getSize() < 3) {
                    String hero = initHero(selected, team1);
                    if (hero != null) {
                        modelFirstCommand.addElement(hero);
                    }
                } else {
                    clearMessages();
                    addMessage("В команде не может быть более 3 героев!!!");
                }
            }
        });

        butRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) bookList2.getSelectedItem();
                if (modelSecondCommand.getSize() < 3) {
                    modelSecondCommand.addElement(initHero(selected, team2));
                } else {
                    clearMessages();
                    addMessage("В команде не может быть более 3 героев!!!");
                }
            }
        });

        butStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!checkCountCircle(textField.getText())) return;
                if (team1.size() != team2.size()) {
                    clearMessages();
                    addMessage("В командах должно быть равное количество игроков.");
                    return;
                }
                if (team1.size() == 0) {
                    clearMessages();
                    addMessage("Нужно подобрать команды");
                    return;
                }
                game.start();
            }
        });

        butClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        setVisible(true);

    }
}
