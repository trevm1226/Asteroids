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

        //Creates two Strings to track the keys pressed and released
        String press = "";
        String release = "";

        //Gets the keys that are being pressed and released at this moment
        for(Integer key : keys)
        {
           if(Mayflower.isKeyPressed(key))
            {
               // System.out.println("Key Pressed: " + key);
              //  System.out.println(key);
                press += keyMap.get(key) + ",";
                //System.out.println(press);
            }
            if(!Mayflower.isKeyDown(key) && Mayflower.wasKeyDown(key))
            {
                release += keyMap.get(key) + "re,";
                //System.out.println(release);
            }
        }

        //Removes the annoying comma at the ends of the Strings if any
        if(press.length() > 0){press = press.substring(0, press.length() - 1);}
        if(release.length() > 0){release = release.substring(0, release.length() - 1);}

        //Turns the large Strings into smaller chunks
        String[] pressed = press.split(",");
        String[] released = release.split(",");

        //Loops through the keys pressed and released and processes them if they are not empty
        for(String p : pressed)
        {
            if(!p.equals(""))
            {
                mode.processPress(p);
                System.out.println(p);
            }
        }
        for(String r : released)
        {
            if(!r.equals(""))
            {
                mode.processRelease(r);
                System.out.println(r);
            }
        }

    }

}