package Game.traitement;

import javafx.scene.image.Image;

public class Sbire extends Enemy{
    private static Image img = new Image(Player.class.getResource("assets/image/galagaenemy3.png").toExternalForm());
    private static Image bullet = new Image(Player.class.getResource("assets/image/galagaenemybullet.png").toExternalForm());

    public Sbire(int x, int y, int w, int h) {
        super(x, y, w, h, img, 1, bullet);
    }
}
