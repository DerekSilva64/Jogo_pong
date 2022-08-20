package com.danxter;

import java.awt.*;
import java.util.Random;

public class Ball {

    public static double coordenateX, coordenateY;
    public double directionX, directionY, speed = 2.5;
    public int height, whidth, angle;

    public Ball(int x, int y){
        
        coordenateX = x;
        coordenateY = y;
        height = 3;
        whidth = 3;

        angle = new Random().nextInt(60) + 160 ;
        directionX = Math.cos(Math.toRadians(angle));
        directionY = Math.sin(Math.toRadians(angle));

    }

    public void tick(){

        if(coordenateY +(directionY * speed) + height >= Game.height){
            directionY *= -1;
        } else if(coordenateY +(directionY * speed) + height < 0){
            directionY *= -1;
        }
        if(coordenateX >= Game.whidth){
            Score.scoreEnemy++;
            System.out.println("| PLACAR |");
            System.out.println("Jogador: " + Score.scorePlayer);
            System.out.println("Inimigo: " + Score.scoreEnemy + "\n");
            new Game();
            return;
        } else if(coordenateX < 0){
            Score.scorePlayer++;
            System.out.println("| PLACAR |");
            System.out.println("Jogador: " + Score.scorePlayer);
            System.out.println("Inimigo: " + Score.scoreEnemy + "\n");
            new Game();
            return;
        }

        Rectangle borderBall = new Rectangle((int) (coordenateX + (directionX * speed)), (int) (coordenateY +(directionY * speed)), whidth, height);
        Rectangle borderPlayer = new Rectangle(Game.player.coordenateX, Game.player.coordenateY, Game.player.whidth, Game.player.height);
        Rectangle borderEnemy  = new Rectangle((int) Game.enemy.coordenateX,(int) Game.enemy.coordenateY, Game.enemy.whidth, Game.enemy.height);

        if(borderBall.intersects(borderPlayer)){
            angle = new Random().nextInt(60) + 160 ;
            directionX = Math.cos(Math.toRadians(angle));
            directionY = Math.sin(Math.toRadians(angle));

            if(directionX > 0){
                directionX *=-1;
            }
        } else if(borderBall.intersects(borderEnemy)){
            angle = new Random().nextInt(60) + 160 ;
            directionX = Math.cos(Math.toRadians(angle));
            directionY = Math.sin(Math.toRadians(angle));
            if(directionX < 0){
                directionX *=-1;
            }
        }

        coordenateX += directionX * speed;
        coordenateY += directionY * speed;

    }

    public void render(Graphics g){
        g.setColor(Color.yellow);
        g.fillRect((int) coordenateX,(int) coordenateY, whidth, height);
    }

}
