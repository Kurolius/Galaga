package Game.traitement;

import javafx.scene.image.Image;

public class Boss extends Enemy{
    private Sprite fullLife;
    private Sprite twoTierLife;
    private Sprite oneTierLife;
    private static Image img = new Image(Player.class.getResource("assets/image/galagaenemy3.png").toExternalForm());
    private static Image bullet = new Image(Player.class.getResource("assets/image/galagabossbullet.png").toExternalForm());
    private static Image fullLifeimg = new Image(Player.class.getResource("assets/image/FullLife.png").toExternalForm());
    private static Image twoTierLifeimg = new Image(Player.class.getResource("assets/image/twoTierLife.png").toExternalForm());
    private static Image oneTierLifeimg = new Image(Player.class.getResource("assets/image/oneTierLife.png").toExternalForm());

    public Boss(int x, int y, int w, int h) {
        super(x, y, w, h, img, 3, bullet);
        twoTierLife = new Sprite(x,y+h-2,w,10,"",twoTierLifeimg);
        oneTierLife = new Sprite(x,y+h-2,w,10,"",oneTierLifeimg);
        fullLife = new Sprite(x,y+h-2,w,10,"",fullLifeimg);
    }
    public Sprite getFullLife(){
        return this.fullLife;
    }

    public Sprite getTwoTierLife(){
        return this.twoTierLife;
    }
    public Sprite getOneTierLife(){
        return this.oneTierLife;
    }
    public void moveLeft(int x) {
        setTranslateX(getTranslateX() - x);
        this.fullLife.setTranslateX(getTranslateX() - x);
        this.twoTierLife.setTranslateX(getTranslateX() - x);
        this.oneTierLife.setTranslateX(getTranslateX() - x);
    }

    public void moveRight(int x)
    {
        setTranslateX(getTranslateX() + x);
        this.fullLife.setTranslateX(getTranslateX() + x);
        this.twoTierLife.setTranslateX(getTranslateX() + x);
        this.oneTierLife.setTranslateX(getTranslateX() + x);
    }

    public void moveUp(int y)
    {
        setTranslateY(getTranslateY() - y);
        this.fullLife.setTranslateY(getTranslateY() - y);
        this.twoTierLife.setTranslateY(getTranslateY() - y);
        this.oneTierLife.setTranslateY(getTranslateY() - y);
    }

    public void moveDown(int y)
    {
        setTranslateY(getTranslateY() + y);
        this.fullLife.setTranslateY(getTranslateY() + y);
        this.twoTierLife.setTranslateY(getTranslateY() + y);
        this.oneTierLife.setTranslateY(getTranslateY() + y);
    }

}
