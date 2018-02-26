package server;

import mayflower.*;
import mayflower.net.Server;

import java.util.HashMap;
import java.util.Map;

public class ServerGame extends Mayflower
{
    private Map<Integer, spaceshipActor> actors;
    private ServerWorld world;

    public ServerGame(Server server)
    {
        super("Server", 1024, 768);
        actors = new HashMap<Integer, spaceshipActor>();

        world = new ServerWorld(server);
        this.setWorld(world);
    }

    public void process(int i, String s)
    {
        System.out.println(s);
        spaceshipActor actor = actors.get(i);
        if(actor != null)
        {
            switch(s)
            {
                case "up":
                    actor.makeAccel(1);
                    break;
                case "down":
                    actor.makeDecel(1);
                    break;
                case "left":
                    actor.makeTurnL(1);
                    break;
                case "right":
                    actor.makeTurnR(1);
                case "upre":
                    if(actor.isAccelerating()) break;
                    actor.makeAccel(0);
                    System.out.println("uprealesed");
                    break;
                case "downre":
                    actor.makeDecel(0);
                    break;
                case "leftre":
                    actor.makeTurnL(0);
                    break;
                case "rightre":
                    actor.makeTurnR(0);
                    break;
            }
            //actor.move(10);
        }
    }

    public void join(int i)
    {
        int x = (int)(Math.random() * 700) + 50;
        int y = (int)(Math.random() * 500) + 50;
        spaceshipActor actor = new spaceshipActor(x,y,0, i);
        world.addObject(actor, x, y);

        actors.put(i, actor);
    }

    public void leave(int i)
    {
        Actor actor = actors.get(i);
        if(null != actor)
        {
            world.removeObject(actor);
        }
    }

    @Override
    public void init()
    {
    }
}
