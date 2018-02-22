package server;

import mayflower.Mayflower;
import mayflower.net.Client;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class InputManager
{
    private GameMode mode;
    private Map<Integer, String> keyMap;
    private Client client;

    public InputManager()
    {
        keyMap = new HashMap<Integer, String>();
        this.client = client;
    }

    public InputManager(GameMode mode)
    {
        this();
        setGameMode(mode);
    }

    public void setGameMode(GameMode mode)
    {
        this.mode = mode;
    }

    public void setKeyMap(Map<Integer, String> map)
    {
        this.keyMap = map;
    }

    public void scan()
    {
        if(null == mode)
            return;

        //read input from user
        //convert key-->action
        //pass action to game mode
        Set<Integer> keys = keyMap.keySet();
        for(Integer key : keys)
        {
            if(Mayflower.isKeyPressed(key))
            {
                System.out.println("Key Pressed: " + key);

                if (key.equals(Keyboard.KEY_UP))
                {
                    ship.addVelocity();
                    System.out.println("worked");
                }
                if (key.equals(Keyboard.KEY_DOWN))
                {
                    ship.lessVelocity();
                }
                if (key.equals(Keyboard.KEY_RIGHT))
                {
                    ship.turnRight();
                }
                if (key.equals(Keyboard.KEY_LEFT))
                {
                    ship.turnLeft();
                }
                //mode.processPress(keyMap.get(key));
                //trevorisadigus


            }
            else if(Mayflower.wasKeyDown(key))
            {
                //mode.processRelease(keyMap.get(key));
            }
        }
    }

}
