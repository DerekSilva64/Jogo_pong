package com.danxter;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        JFrame frame = new JFrame("Pong");

        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(game);
        frame.pack();
        frame.setLocationRelativeTo(null);

        ImageIcon logo = new ImageIcon("com/danxter/imgs/logo.png");
        frame.setIconImage(logo.getImage());

        frame.setVisible(true);

        new Thread(game).start();
    }

}
