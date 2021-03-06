package client;

import mayflower.Actor;
import mayflower.net.Client;

import java.util.LinkedList;
import java.util.List;

public class GameClient extends Client implements GameMode
{
    private GameWorld world;

    public GameClient()
    {
        this("localhost");
    }

    public GameClient(String ip)
    {
        System.out.println("Connecting");
        this.connect(ip, 1234);
        System.out.println("Connected");
    }

    public void setWorld(GameWorld world)
    {
        this.world = world;
    }

    @Override
    public void process(String s)
    {
        //System.out.println("Message From Server: " + s);

        List<Actor> actors = new LinkedList<Actor>();
        String[] parts = s.split(":");
        for(String part : parts)
        {
            if(!"".equals(part)) {
                String[] parts2 = part.split(",");
                String type = parts2[0];
                int x = Integer.parseInt(parts2[1]);
                int y = Integer.parseInt(parts2[2]);
                int r = Integer.parseInt(parts2[3]);
                int v = 0;
                if(parts2.length>4)
                    v = Integer.parseInt(parts2[4]);
                if(type.equals("ship"))
                    actors.add(new spaceshipActor(x, y, r, 0));
                if(type.equals("turret"))
                    actors.add(new turret(x, y, r));
                if(type.equals("asteroid"))
                    actors.add(new Asteroid(x,y,r,v));
            }
        }
        if(null != world) {
            world.update(actors);
        }

    }

    @Override
    public void onDisconnect(String s) {
        System.out.println("Disconnected from server");
    }

    @Override
    public void onConnect() {
        System.out.println("Connected to server!");
    }

    @Override
    public void processPress(String action) {
        //System.out.println("Sending: " + action);
        send(action);
    }

    @Override
    public void processRelease(String action) {
        send(action+"re");
        //System.out.println("Sendingre: " + action);
    }
}
