package Game;

import Game.traitement.*;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main extends Application {

    private Pane root = new Pane();
    Sprite[] enemyArray = new Sprite[30];
    private Sprite player;
    private Sprite menu;
    private Sprite gameOver;
    private double time = 0;
    private double timeCounter = 0;
    private double timeCounter2 = 0;
    private double difficulty = 0.00;
    private int enemyCount;
    private int lifeCount;
    private int score;
    private double timeCount;
    private boolean mainMenuBool = true;
    private boolean gameOverBool = false;
    private AnimationTimer timer;
    private AnimationTimer t;
    private AnimationTimer at;
    private AnimationTimer animTime;
    private AudioClip introPlayer = new AudioClip(new Media(new File("src/Game/traitement/assets/audio/galagatheme.wav").toURI().toString()).getSource());
    private AudioClip enemyOneDeathPlayer = new AudioClip(new Media(new File("src/Game/traitement/assets/audio/galagaenemy1death.wav").toURI().toString()).getSource());
    private AudioClip enemyTwoDeathPlayer = new AudioClip(new Media(new File("src/Game/traitement/assets/audio/galagaenemy2death.wav").toURI().toString()).getSource());
    private static AudioClip playerShootPlayer = new AudioClip(new Media(new File("src/Game/traitement/assets/audio/galagaplayerbulletsound.wav").toURI().toString()).getSource());
    private Label Stage = new Label("");
    private int StageCpt = 0;
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(createContent());
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Galaga");

        scene.setOnKeyPressed(e ->
        {
            switch(e.getCode())
            {
                case LEFT:
                    player.setMovingLeft(true);
                    break;
                case RIGHT:
                    player.setMovingRight(true);
                    break;
                case SPACE:
                    if(player.getCanShoot())
                       shootCut(player);
                    break;
                case ENTER:
                    if(mainMenuBool)
                    {
                        startGame();
                        mainMenuBool = false;
                    }
                    if(gameOverBool)
                    {
                        restartGame();
                    }
                    break;
            }
        });

        scene.setOnKeyReleased(e ->
        {
            switch (e.getCode())
            {
                case LEFT:
                    player.setMovingLeft(false);
                    break;
                case RIGHT:
                    player.setMovingRight(false);
                    break;
            }
        });
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Parent createContent()
    {
        animTime = new AnimationTimer()
        {
            @Override
            public void handle(long l)
            {
                timeCounter2 += 0.016;
                if(timeCounter2 > 10.0)
                {
                    player.setCanShoot(true);
                    enemysCanShoot(true,enemyArray);
                    timeCounter2 = 0;
                    animTime.stop();
                }
                //------------------BOSS--------------------
                if(enemyArray[0].getTranslateY() < 10)
                    ((Boss)enemyArray[0]).moveDown(1);
                if(enemyArray[1].getTranslateY() < 10)
                    ((Boss)enemyArray[1]).moveDown(1);
                //----------------Generals----------------------
                if(enemyArray[2].getTranslateX() < 500)
                    ((General)enemyArray[2]).moveRight(2);
                if(enemyArray[3].getTranslateX() < 350)
                    ((General)enemyArray[3]).moveRight(2);
                if(enemyArray[4].getTranslateX() < 200)
                    ((General)enemyArray[4]).moveRight(2);
                if(enemyArray[5].getTranslateX() < 50)
                    ((General)enemyArray[5]).moveRight(2);


                if(enemyArray[6].getTranslateX() > 700)
                    ((General)enemyArray[6]).moveLeft(2);
                if(enemyArray[7].getTranslateX() > 850)
                    ((General)enemyArray[7]).moveLeft(2);
                if(enemyArray[8].getTranslateX() > 1000)
                    ((General)enemyArray[8]).moveLeft(2);
                if(enemyArray[9].getTranslateX() > 1150)
                    ((General)enemyArray[9]).moveLeft(2);
                //------------------------------------------

                //------------------Soldiers------------------------
                if(enemyArray[10].getTranslateX() < 542)
                    enemyArray[10].moveRight(2);
                if(enemyArray[11].getTranslateX() < 419)
                    enemyArray[11].moveRight(2);
                if(enemyArray[12].getTranslateX() < 296)
                    enemyArray[12].moveRight(2);
                if(enemyArray[13].getTranslateX() < 173)
                    enemyArray[13].moveRight(2);
                if(enemyArray[14].getTranslateX() < 50)
                    enemyArray[14].moveRight(2);

                if(enemyArray[15].getTranslateX() > 658)
                    enemyArray[15].moveLeft(2);
                if(enemyArray[16].getTranslateX() > 781)
                    enemyArray[16].moveLeft(2);
                if(enemyArray[17].getTranslateX() > 904)
                    enemyArray[17].moveLeft(2);
                if(enemyArray[18].getTranslateX() > 1027)
                    enemyArray[18].moveLeft(2);
                if(enemyArray[19].getTranslateX() > 1150)
                    enemyArray[19].moveLeft(2);

                if(enemyArray[20].getTranslateX() < 542)
                    enemyArray[20].moveRight(2);
                if(enemyArray[21].getTranslateX() < 419)
                    enemyArray[21].moveRight(2);
                if(enemyArray[22].getTranslateX() < 296)
                    enemyArray[22].moveRight(2);
                if(enemyArray[23].getTranslateX() < 173)
                    enemyArray[23].moveRight(2);
                if(enemyArray[24].getTranslateX() < 50)
                    enemyArray[24].moveRight(2);

                if(enemyArray[25].getTranslateX() > 658)
                    enemyArray[25].moveLeft(2);
                if(enemyArray[26].getTranslateX() > 781)
                    enemyArray[26].moveLeft(2);
                if(enemyArray[27].getTranslateX() > 904)
                    enemyArray[27].moveLeft(2);
                if(enemyArray[28].getTranslateX() > 1027)
                    enemyArray[28].moveLeft(2);
                if(enemyArray[29].getTranslateX() > 1150)
                    enemyArray[29].moveLeft(2);

            }
        };

        root.setPrefSize(1280, 720);

        Image img = new Image("file:src/Game/traitement/assets/image/bg.jpg");
        BackgroundImage bImg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,  BackgroundSize.DEFAULT);
        Background bGround = new Background(bImg);
        root.setBackground(bGround);

        menu = new Sprite( 300, 100, 720, 550, "menu",new Image(getClass().getResource("traitement/assets/image/galagamenu.png").toExternalForm()) );
        gameOver = new Sprite( 300, 80, 720, 550, "gameOver",new Image(getClass().getResource("traitement/assets/image/galagagameover.png").toExternalForm()) );

        root.getChildren().add(menu);
        Font font = Font.font("ARIAL", FontWeight.BOLD, FontPosture.REGULAR, 40);
        Stage.setFont(font);
        Stage.setTextFill(Color.WHEAT);
        Stage.setTranslateX(570);
        root.getChildren().add(Stage);

        timer = new AnimationTimer()
        {
            @Override
            public void handle(long l)
            {
                update();
            }
        };

        return root;
    }

    private List<Sprite> sprites()
    {
        List<Sprite> L = new ArrayList<>();
        for (Object o:root.getChildren()) {
            if(o instanceof Sprite)
            L.add((Sprite) o);

        }
        return L;
    }

    private void startGame()
    {
        score = 0;

        root.getChildren().remove(menu);


        player = new Player( 600, 580, 104, 108);

        root.getChildren().add(player);
        lifeCount = 3;

        timer.start();

        for(int i = 1; i <= lifeCount - 1; i++)
        {
            Sprite s = new Sprite((i-1) * 56 + 10, 20, 52, 54, "playerlife",new Image(getClass().getResource("traitement/assets/image/heart.png").toExternalForm()));

            root.getChildren().add(s);
        }

        playIntro();
    }
    private void playIntro()
    {
        player.setCanShoot(false);

        introPlayer.play();
        timeCounter = 0;

        at = new AnimationTimer()
        {
            @Override
            public void handle(long l)
            {
                timeCounter += 0.016;
                if(timeCounter > 5.0)
                {
                    timeCounter = 0;
                    at.stop();
                    nextLevel();
                }
            }
        };
        at.start();
    }

    private void nextLevel()
    {
        enemyCount = 30;
        difficulty += 0.05;
        StageCpt +=1;

        Stage.setText("Stage "+StageCpt);
        enemyArray[0] = new Boss(245, -150, 150, 150);
        root.getChildren().add(enemyArray[0]);
        root.getChildren().add(((Boss)enemyArray[0]).getOneTierLife());
        root.getChildren().add(((Boss)enemyArray[0]).getTwoTierLife());
        root.getChildren().add(((Boss)enemyArray[0]).getFullLife());


        enemyArray[1] = new Boss(885, -150, 150, 150);
        root.getChildren().add(enemyArray[1]);
        root.getChildren().add(((Boss)enemyArray[1]).getOneTierLife());
        root.getChildren().add(((Boss)enemyArray[1]).getTwoTierLife());
        root.getChildren().add(((Boss)enemyArray[1]).getFullLife());

        for (int i = 2; i < 6; i++)
        {
            enemyArray[i] = new General(-50-((i-2)*110), 175 , 100, 100);
            root.getChildren().add(enemyArray[i]);
            root.getChildren().add(((General)enemyArray[i]).getMidLife());
            root.getChildren().add(((General)enemyArray[i]).getFullLife());
        }

        for (int i = 6; i < 10; i++)
        {
            enemyArray[i] = new General(1340+((i-6)*110), 175, 100, 100);
            root.getChildren().add(enemyArray[i]);
            root.getChildren().add(((General)enemyArray[i]).getMidLife());
            root.getChildren().add(((General)enemyArray[i]).getFullLife());
        }
        for (int i = 10; i < 15; i++)
        {
            enemyArray[i] = new Sbire(-50 - ((i-10)*128), 300, 50, 50);
            root.getChildren().add(enemyArray[i]);
        }
        for (int i = 15; i < 20; i++)
        {
            enemyArray[i] = new Sbire(1340 + ((i-15)*128), 300, 50, 50);
            root.getChildren().add(enemyArray[i]);
        }
        for (int i = 20; i < 25; i++)
        {
            enemyArray[i] = new Sbire(-50 -  ((i-20)*128), 375, 50, 50);
            root.getChildren().add(enemyArray[i]);
        }
        for (int i = 25; i < 30; i++)
        {
            enemyArray[i] = new Sbire(1340 + ((i-25)*128), 375, 50, 50);
            root.getChildren().add(enemyArray[i]);
        }

       enemysCanShoot(false,enemyArray);

        animTime.start();
    }

    private void restartGame()
    {
        StageCpt=0;
        Stage.setText("");
        difficulty = 0.05;
        gameOverBool = false;
        root.getChildren().removeAll(sprites());
        timer.stop();
        mainMenuBool = true;
        root.getChildren().remove(gameOver);
        root.getChildren().add(menu);
    }
    private void update()
    {
        time += 0.016;

        sprites().forEach(s ->
        {
            switch(s.getType())
            {
                case "enemybullet":
                    s.moveDown(4);
                    if(s.getBoundsInParent().intersects(player.getBoundsInParent()))
                    {
                        s.setDead(true);
                        if(lifeCount == 1)
                        {
                            player.setDead(true);
                            gameOverBool = true;
                            player.setCanShoot(false);
                            root.getChildren().add(gameOver);
                        }
                        lifeCount--;

                        updatePlayerLives();
                    }
                    if(s.getTranslateY() > 1000)
                        s.setDead(true);
                    break;

                case "playerbullet":
                    s.moveUp(4);
                    sprites().stream().filter(e -> e.getType().equals("enemy")).forEach(enemy ->
                    {
                        if(s.getBoundsInParent().intersects(enemy.getBoundsInParent()))
                        {
                            switch (enemy.getEnemyType())
                            {
                                case 1:
                                    enemyOneDeathPlayer.play();
                                    break;
                                case 2:
                                    enemyTwoDeathPlayer.play();
                                    break;
                                case 3:
                                    break;

                            }
                            if(((Enemy)enemy).getHp()-1 == 0){
                                if(enemy instanceof Boss){
                                    (((Boss)enemy).getOneTierLife()).setDead(true);
                                }
                                if(enemy instanceof General){
                                    (((General)enemy).getMidLife()).setDead(true);
                                }
                                enemy.setDead(true);
                                s.setDead(true);
                                enemyCount--;
                                score += 500;
                                System.out.println(score);

                            }else{
                                if(enemy instanceof Boss){
                                    if(((Boss)enemy).getHp()-1 == 2)
                                        (((Boss)enemy).getFullLife()).setDead(true);
                                    if(((Boss)enemy).getHp()-1 == 1)
                                        (((Boss)enemy).getTwoTierLife()).setDead(true);

                                }
                                if(enemy instanceof General){
                                    (((General)enemy).getFullLife()).setDead(true);
                                }
                                s.setDead(true);
                                ((Enemy)enemy).reduceHp();

                            }

                            if(score == 20000 || (score >= 70000 && score % 70000 == 0))
                            {
                                lifeCount++;
                                updatePlayerLives();
                            }
                        }
                        if(enemyCount == 0)
                        {
                            enemyCount = 40;
                            player.setCanShoot(false);
                            timeCount = 0;
                            t = new AnimationTimer() {
                                @Override
                                public void handle(long l) {
                                    timeCount += 0.016;
                                    if(timeCount > 8.0)
                                    {
                                        t.stop();
                                        nextLevel();
                                    }
                                }
                            };
                            t.start();
                        }
                        if(s.getTranslateY() < 0)
                            s.setDead(true);
                    });
                    break;

                case "enemy":
                    if(time > 2)
                    {
                        if(Math.random() < difficulty && s.getCanShoot())
                            shoot(s,root);
                    }
                    break;

                case "player":
                    sprites().stream().filter(e -> e.getType().equals("enemy")).forEach(enemy ->
                    {
                        if(s.getBoundsInParent().intersects(enemy.getBoundsInParent()))
                        {
                            enemy.setDead(true);
                            player.setDead(true);
                            s.setDead(true);
                        }
                    });
                    if(s.isMovingRight() == true && s.getTranslateX() < 1150)
                    {
                        s.moveRight(3);
                    }
                    if(s.isMovingLeft() == true && s.getTranslateX() > 20)
                    {
                        s.moveLeft(3);
                    }
                    break;
            }
        });

        if(time > 2)
            time = 0;

        root.getChildren().removeIf(n -> {
            if(n instanceof Sprite){
            Sprite s = (Sprite) n;
            return s.isDead();}else return false;
        });
    }
    private void updatePlayerLives()
    {
        sprites().stream().filter(e -> e.getType().equals("playerlife")).forEach(playerlife ->
        {
            root.getChildren().remove(playerlife);
        });

        for(int i = 1; i <= lifeCount - 1; i++)
        {
            Sprite t = new Sprite((i-1) * 56 + 10, 20, 52, 54, "playerlife", new Image(getClass().getResource("traitement/assets/image/heart.png").toExternalForm()));

            root.getChildren().add(t);
        }
    }
    public void shootCut(Sprite player){
        shoot(player,root);
    }
    public static void shoot(Sprite shooter, Pane root)
    {
        Sprite bullet;
        if(shooter.getType() == "player")
        {
            bullet = new Sprite((int) shooter.getTranslateX()-5 + (int) shooter.getWidth() / 2 - 5, (int) shooter.getTranslateY(), 10, 34, shooter.getType() + "bullet",new Image(Main.class.getResource("traitement/assets/image/galagaplayerbullet.png").toExternalForm()) );
            playerShootPlayer.play();
        }
        else{
            if(shooter instanceof Boss)
                bullet = new Sprite((int) shooter.getTranslateX() + (int) shooter.getWidth()/2 - 15, (int) shooter.getTranslateY() + (int) shooter.getWidth() - 5, 30, 102, shooter.getType() + "bullet",((Enemy)shooter).getBullet() );
            else if(shooter instanceof General)
                bullet = new Sprite((int) shooter.getTranslateX() + (int) shooter.getWidth()/2 - 17, (int) shooter.getTranslateY() + (int) shooter.getWidth() - 4, 34, 34, shooter.getType() + "bullet",((Enemy)shooter).getBullet() );
            else
                bullet = new Sprite((int) shooter.getTranslateX() + (int) shooter.getWidth()/2 - 5, (int) shooter.getTranslateY() + (int) shooter.getWidth() - 4 , 10, 34, shooter.getType() + "bullet",((Enemy)shooter).getBullet() );
        }



        root.getChildren().add(bullet);
    }
    public static void enemysCanShoot(boolean b,Sprite[] enemyArray)
    {
        for(int i = 0; i < 30; i++)
            enemyArray[i].setCanShoot(b);
    }
}