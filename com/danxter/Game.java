package com.danxter;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable, KeyListener {

    public static int height = 120;
    public static int whidth = 240;
    public static int scale = 3;

    public BufferedImage layer = new BufferedImage(whidth, height, BufferedImage.TYPE_INT_RGB);

    public static Player player;
    public static Enemy enemy;
    public static Ball ball;

    public Game() {
        this.setPreferredSize(new Dimension(whidth * scale, height * scale));
        this.addKeyListener(this);
        player = new Player(230, 45);
        enemy = new Enemy(5, 45);
        ball = new Ball(120, 45);
    }
    
    public void tick() {
        player.tick();
        enemy.tick();
        ball.tick();
    }

    public void render() {

        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = layer.getGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, whidth, height);

        player.render(g);
        enemy.render(g);
        ball.render(g);

        g = bs.getDrawGraphics();

        g.drawImage(layer, 0, 0, whidth * scale, height * scale, null);

        bs.show();
    }

    @Override
    public void run() {
        requestFocus();
        while (true) {
            tick();
            render();

            try {
                Thread.sleep(1000 / 60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            player.up = true;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player.dowm = true;
        } else if (e.getKeyCode() == KeyEvent.VK_R){
            new Game();
        }

    }

    @Override
    public void keyReleased(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            player.up = false;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player.dowm = false;
        }
    }
    
}
