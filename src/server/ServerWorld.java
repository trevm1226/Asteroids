package server;

import mayflower.Actor;
import mayflower.Timer;
import mayflower.World;
import mayflower.net.Server;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ServerWorld extends World
{
    private Server server;
    private Timer timer;

    public ServerWorld(Server server)
    {
        setBackground("img/background.png");
        timer = new Timer(750000);
        this.server = server;

        //addObject(new spaceshipActor(100,100,45),100,100);
        addObject(new Asteroid( 100,100,90, 5),100,100);

    }

    @Override
    public void addObject(Actor a, int x, int y)
    {
        super.addObject(a, x, y);
        System.out.println("Adding: "+ a + " to " + x +", " + y);
    }

    @Override
    public void act()
    {
        if(timer.isDone())
        {
            List<SpaceActor> actors = getObjects(SpaceActor.class);
            for(SpaceActor actor : actors)
            {
               actor.tick();
            }

            //System.out.println("tick: " + this.getObjects().size());
            //System.out.println("tick: " + server);
            timer.reset();
            if(null != server)
            {
                server.send(this.toString());
            }
        }
    }

    public String toString()
    {
        String str = "";

        List<BoxActor> actors = getObjects(BoxActor.class);
        for(Actor actor : actors)
        {
            str += actor.toString() + ":";
        }

        return str;
    }
}
