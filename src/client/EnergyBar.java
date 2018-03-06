package server;

import mayflower.*;
import java.util.ArrayList;
import java.util.List;

public class EnergyBar extends Actor
{
    private List<Bar> hud;
    private int capacity;
    private int xValue;

    public EnergyBar(int c, int xv)
    {
        //Creates the initial bar capacity
        capacity = c;

        //Helps the EnergyBar recognize its location
        xValue = xv;

        //Creates the initial size of the bar
        hud = new ArrayList<Bar>();
        for(int x = 0; x < c; x++)
        {
            Bar bar = new Bar();
            this.getWorld().addObject(bar, xValue,32+32*x);
            hud.add(bar);
        }
    }

    public void moPowa()
    {
        //Changes capacity
        capacity++;

        //Changes the display
        Bar bar = new Bar();
        this.getWorld().addObject(bar, xValue,32+32*(capacity-1));
        hud.add(bar);
    }

    public void yUDoDis()
    {
        //Changes the capacity
        capacity--;

        //Changes the display
        this.getWorld().removeObject(hud.get(capacity - 1));
        hud.remove(Bar.class);
    }

    public void act()
    {

    }
}
