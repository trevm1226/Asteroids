package client;

import mayflower.Actor;
import mayflower.net.Client;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GameClient extends Client implements GameMode
{
    private GameWorld world;
    private Map<Integer,SpaceActor> actorMap;

    public GameClient()
    {
        this("localhost");
    }

    public GameClient(String ip)
    {
        System.out.println("Connecting");
        this.connect(ip, 1234);
        System.out.println("Connected");
        actorMap = new HashMap<Integer, SpaceActor>();
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
                int v = Integer.parseInt(parts2[4]);
                int i = Integer.parseInt(parts2[5]);

                        if (type.equals("ship")) {
                            SpaceActor a;
                        if(!actorMap.containsKey(i)&&!actorMap.isEmpty()) {
                           a = new spaceshipActor(x, y, r, v, i);
                        }
                        else{
                            a=actorMap.get(i);a.setRotation(r);a.setLocation(x,y);a.setVelocity(v);
                            }
                        actorMap.put(i,a);
                            actors.add(a);
                    }
                if (type.equals("turret")) {
                    SpaceActor a;
                    if(!actorMap.containsKey(i)&&!actorMap.isEmpty()) {
                        a = new turret(x, y, r, i);
                    }
                    else{
                        a=actorMap.get(i);a.setRotation(r);a.setLocation(x,y);a.setVelocity(v);
                    }
                    actorMap.put(i,a);
                    actors.add(a);
                }
                if (type.equals("asteroid")) {
                    SpaceActor a;
                    if(!actorMap.containsKey(i)&&!actorMap.isEmpty()) {
                        a = new Asteroid(x, y, r, v, i);
                    }
                    else{
                        a=actorMap.get(i);a.setRotation(r);a.setLocation(x,y);a.setVelocity(v);
                    }
                    actorMap.put(i,a);
                    actors.add(a);
                }

                System.out.println(actorMap.toString());
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
