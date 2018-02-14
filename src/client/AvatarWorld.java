package client;

import mayflower.Actor;
import mayflower.Mayflower;
import mayflower.World;

public class AvatarWorld extends World {

    private InputManager manager;
    private Player player;
    private Colors color1;
    private Colors color2;
    private Colors color3;
    private Colors color4;

    public AvatarWorld(InputManager manager) {

        this.manager = manager;
        player = new Player("box");
        color1 = new Colors("rsrc/box.png");
        color2 = new Colors("rsrc/box.png");
        color3 = new Colors("rsrc/box.png");
        color4 = new Colors("rsrc/box.png");
    }

    @Override
    public void act() {

    }


    public class Colors extends Actor
    {
        private String color;
        private String file;

        public Colors(String file) {
            this.file = file;
            color = file;


        } 
        public void onClick()
        {
            if(Mayflower.wasMouseClicked(this))
            player.setColor(color);
        }

        @Override
        public void act() {

        }
    }
}
