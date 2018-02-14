package client;

import mayflower.Actor;
import mayflower.MayflowerImage;

public class Player extends Actor {
    private String color;
    private MayflowerImage img;
    private String gamemode;

    public Player(String color) {
        this.color = color;
        img = new MayflowerImage("rsrc/"+color+".png");
    }

    @Override
    public void act() {


    }
    public void setColor(String color)
    {
        setImage("rsrc/"+color+".png");

    }

    public String getColor() {
        return color;
    }
    public void setGamemode(String gamemode)
    {
        this.gamemode = gamemode;
    }
}
