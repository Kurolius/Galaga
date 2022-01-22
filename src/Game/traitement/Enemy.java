package Game.traitement;

import javafx.scene.image.Image;


public class Enemy extends Sprite{

    private int hp;
    private Image bullet;

    public Enemy(int x, int y, int w, int h, Image img,int hp, Image bullet) {
        super(x, y, w, h, "enemy", img);
        this.hp = hp;
        this.bullet = bullet;
    }

    public int getHp() {
        return hp;
    }

    public void reduceHp(){
        hp--;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Image getBullet() {
        return bullet;
    }

    public void setBullet(Image bullet) {
        this.bullet = bullet;
    }
}
