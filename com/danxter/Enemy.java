package com.danxter;
import java.awt.*;

public class Enemy {

    public double coordenateX, coordenateY;
    public int height, whidth;

    public Enemy(int x, int y){
        coordenateX = x;
        coordenateY = y;
        height = 30;
        whidth = 5;
    }

    public void tick(){

        coordenateY += (Game.ball.coordenateY - coordenateY - 5) * 0.07;

        if(coordenateY + height > Game.height){
            coordenateY = Game.height - height;
        } else if(coordenateY < 0){
            coordenateY = 0;
        }

    }

    public void render(Graphics g){
        g.setColor(Color.red);
        g.fillRect((int) coordenateX,(int) coordenateY, whidth, height);
    }

}
