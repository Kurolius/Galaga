package Game.traitement;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Sprite extends Rectangle {
    boolean dead = false;
    boolean canShoot = true;
    boolean movingRight = false;
    boolean movingLeft = false;
    boolean movingUp = false;
    boolean movingDown = false;
    boolean movingNorthWest = false;
    boolean movingNorthEast = false;
    boolean movingSouthWest = false;
    boolean movingSouthEast = false;
    int enemyType = 0;
    final String type;

    public Sprite(int x, int y, int w, int h, String type, String imageLocation)
    {
        super(w, h, Color.BLACK);
        Image image = new Image(getClass().getResource(imageLocation).toExternalForm());
        this.setFill(new ImagePattern(image));

        this.type = type;
        setTranslateX(x);
        setTranslateY(y);
    }
    public Sprite(int x, int y, int w, int h, String type, Image img)
    {
        super(w, h, Color.BLACK);
        Image image = img;
        this.setFill(new ImagePattern(image));

        this.type = type;
        setTranslateX(x);
        setTranslateY(y);
    }


    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public boolean isCanShoot() {
        return canShoot;
    }

    public void setCanShoot(boolean canShoot) {
        this.canShoot = canShoot;
    }

    public boolean getCanShoot() {
        return this.canShoot;
    }

    public boolean isMovingRight() {
        return movingRight;
    }

    public void setMovingRight(boolean movingRight) {
        this.movingRight = movingRight;
    }

    public boolean isMovingLeft() {
        return movingLeft;
    }

    public void setMovingLeft(boolean movingLeft) {
        this.movingLeft = movingLeft;
    }

    public boolean isMovingUp() {
        return movingUp;
    }

    public void setMovingUp(boolean movingUp) {
        this.movingUp = movingUp;
    }

    public boolean isMovingDown() {
        return movingDown;
    }

    public void setMovingDown(boolean movingDown) {
        this.movingDown = movingDown;
    }

    public boolean isMovingNorthWest() {
        return movingNorthWest;
    }

    public void setMovingNorthWest(boolean movingNorthWest) {
        this.movingNorthWest = movingNorthWest;
    }

    public boolean isMovingNorthEast() {
        return movingNorthEast;
    }

    public void setMovingNorthEast(boolean movingNorthEast) {
        this.movingNorthEast = movingNorthEast;
    }

    public boolean isMovingSouthWest() {
        return movingSouthWest;
    }

    public void setMovingSouthWest(boolean movingSouthWest) {
        this.movingSouthWest = movingSouthWest;
    }

    public boolean isMovingSouthEast() {
        return movingSouthEast;
    }

    public void setMovingSouthEast(boolean movingSouthEast) {
        this.movingSouthEast = movingSouthEast;
    }

    public int getEnemyType() {
        return enemyType;
    }

    public void setEnemyType(int enemyType) {
        this.enemyType = enemyType;
    }

    public String getType() {
        return type;
    }

    public void moveLeft(int x) { setTranslateX(getTranslateX() - x); }

    public void moveRight(int x)
    {
        setTranslateX(getTranslateX() + x);
    }

    public void moveUp(int y)
    {
        setTranslateY(getTranslateY() - y);
    }

    public void moveDown(int y)
    {
        setTranslateY(getTranslateY() + y);
    }

    public  void moveNorthWest(int x, int y){ setTranslateX(getTranslateX() - x); setTranslateY(getTranslateY() - y);}

    public void moveNorthEast(int x, int y){ setTranslateX(getTranslateX() + x); setTranslateY(getTranslateY() - y);}

    public void moveSouthWest(int x, int y){ setTranslateX(getTranslateX() - x); setTranslateY(getTranslateY() + y);}

    public void moveSouthEast(int x, int y){ setTranslateX(getTranslateX() + x); setTranslateY(getTranslateY() + y);}
}
