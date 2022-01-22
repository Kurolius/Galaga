package Game.traitement;

import javafx.scene.image.Image;


public class General extends Enemy{
    private Sprite fullLife;
    private Sprite midLife;
    private static Image img = new Image(Player.class.getResource("assets/image/galagaenemy2.png").toExternalForm());
    private static Image bullet = new Image(Player.class.getResource("assets/image/galagageneralbullet.png").toExternalForm());

    public General(int x, int y, int w, int h) {
        super(x, y, w, h, img, 2, bullet);
        midLife = new Sprite(x,y+h+2,w-4,10,"",new Image(getClass().getResource("assets/image/MidLife.png").toExternalForm()));
        fullLife = new Sprite(x,y+h+2,w-4,10,"",new Image(getClass().getResource("assets/image/FullLife.png").toExternalForm()));
    }
    public Sprite getFullLife(){
        return this.fullLife;
    }

    public Sprite getMidLife(){
        return this.midLife;
    }
    public void moveLeft(int x) {
        setTranslateX(getTranslateX() - x);
        this.fullLife.setTranslateX(getTranslateX() - x);
        this.midLife.setTranslateX(getTranslateX() - x);
    }

    public void moveRight(int x)
    {
        setTranslateX(getTranslateX() + x);
        this.fullLife.setTranslateX(getTranslateX() + x);
        this.midLife.setTranslateX(getTranslateX() + x);
    }

    public void moveUp(int y)
    {
        setTranslateY(getTranslateY() - y);
        this.fullLife.setTranslateY(getTranslateY() - y);
        this.midLife.setTranslateY(getTranslateY() - y);
    }

    public void moveDown(int y)
    {
        setTranslateY(getTranslateY() + y);
        this.fullLife.setTranslateY(getTranslateY() + y);
        this.midLife.setTranslateY(getTranslateY() + y);
    }
}
