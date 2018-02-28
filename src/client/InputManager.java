package client;

import com.sun.org.apache.xpath.internal.SourceTree;
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
    private int lastKey = -1;

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
        //TODO: Make this work
        //read input from user
        //convert key-->action
        //pass action to game mode
        Set<Integer> keys = keyMap.keySet();
        for(Integer key : keys)
        {
           if(Mayflower.isKeyPressed(key))
            {
               // System.out.println("Key Pressed: " + key);
                lastKey = key;
              //  System.out.println(key);
                mode.processPress(keyMap.get(key));
            }
            if(!Mayflower.isKeyDown(lastKey)&&Mayflower.wasKeyDown(lastKey))
            {
                mode.processRelease(keyMap.get(lastKey));
            }
        }
    }

}