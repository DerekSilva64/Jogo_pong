package com.danxter;
import java.awt.*;

public class Player {

    public boolean up, dowm;
    public int coordenateX, coordenateY, height, whidth;

    public Player(int x, int y){
        coordenateX = x;
        coordenateY = y;
        height = 30;
        whidth = 5;
    }

    public void tick(){

        if(up){
            coordenateY--;
        } else if(dowm){
            coordenateY++;
        }

        if(coordenateY + height > Game.height){
            coordenateY = Game.height - height;
        } else if(coordenateY < 0){
            coordenateY =0;
        }

    }

    public void render(Graphics g){

        g.setColor(Color.blue);
        g.fillRect(coordenateX, coordenateY, whidth, height);

    }

}
