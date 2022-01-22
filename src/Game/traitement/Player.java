package Game.traitement;

import javafx.scene.image.Image;

public class Player extends Sprite{


    private static Image img = new Image(Player.class.getResource("assets/image/galagaplayership.png").toExternalForm());

    public Player(int x, int y, int w, int h) {
        super(x, y, w, h, "player", img);
    }
}
