package thegame;

import com.sun.javafx.geom.BaseBounds;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.FontWeight;
import javafx.scene.media.Media;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import thegame.bullet.Bullet;
import thegame.bullet.MachineGunBullet;
import thegame.bullet.NormalBullet;
import thegame.bullet.SniperBullet;
import thegame.enemy.*;
import thegame.tile.MachineGunTower;
import thegame.tile.NormalTower;
import thegame.tile.SniperTower;
import thegame.tile.Tower;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main extends Application {
    public int SIZE_ENEMYS = 15;
    public GameField gameField = new GameField();
    public GameStage gameStage;
    public double mouseX = -1, mouseY = -1;
    public int kind = 0;
    public int type = 1;
    public int typeA = 0;
    public boolean PAUSE = false;

    public int inp = 0;


    public ArrayList<Enemy> enemys = new ArrayList<>();
    ArrayList<Tower> towers = new ArrayList<>();
    ArrayList<Bullet> bullets = new ArrayList<>();

    Image start1 = new Image("file:image/start1.png");
    Image go = new Image("file:image/go.png");

    Image imgT = new Image("file:image/towerDefense_tile181.png");
    Image imgT1 = new Image("file:image/towerDefense_tile249.png");
    Image imgT2 = new Image("file:image/towerDefense_tile206.png");
    Image imgT3 = new Image("file:image/towerDefense_tile250.png");
    Image imgPause = new Image("file:image/towerDefense_tile134.png");


    @Override
    public void start(Stage theStage) throws Exception {
        theStage.setTitle("TowerDefense");

        Group root = new Group();
        Scene theScene = new Scene(root);
        theStage.setScene(theScene);

        Canvas canvas = new Canvas(896, 600);


       // String path ="C:\\Users\\admin\\Downloads\\sounds";
        /*Media media = new Media("file:C:/Users/admin/Downloads/sounds/8_music.mp3");
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);*/

        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        gameField.spawnEnemy1(enemys);

        new AnimationTimer() {

            @Override
            public void handle(long l) {
                if (type == 1) {
                    gc.drawImage(start1, 0, 0);
                    canvas.setOnMouseClicked(
                            new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent mouseEvent) {
                                    if (mouseEvent.getX() > 319 && mouseEvent.getX() < 563
                                            && mouseEvent.getY() > 463 && mouseEvent.getY() < 532) {
                                        type = 2;
                                    }

                                }
                            }
                    );
                }
                else if (type == 2) {
                    gc.clearRect(0, 0, 896, 600);
                    gc.drawImage(new Image("file:image/toro.jpg"), 0, 0);

                    canvas.setOnMouseMoved(
                            new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent mouseEvent) {
                                    if (inp == 1 ) {
                                        mouseX = mouseEvent.getX();
                                        mouseY = mouseEvent.getY();
                                    } else {
                                        mouseX = -1;
                                        mouseY = -1;
                                    }
                                }
                            }
                    );

                    canvas.setOnMouseClicked(
                            new EventHandler<MouseEvent>() {
                                public void handle(MouseEvent e) {
                                    if ((e.getX() > 704 && e.getX() < 768) && e.getY() < 64 && gameField.money >= 5) {
                                        inp = 1;
                                        kind = 1;
                                    } if (e.getX() > 768 && e.getX() < 832 && e.getY() < 64 && gameField.money >= 10) {
                                        inp = 1;
                                        kind = 2;
                                    } if (e.getX() > 832 && e.getY() < 64 && gameField.money >= 15) {
                                        inp = 1;
                                        kind = 3;
                                    }  if (e.getX() <= 704 && inp > 0) {
                                        if (kind == 1) {
                                            inp = 0;
                                            towers.add(new NormalTower(e.getX() - 32, e.getY() - 32));
                                            if (towers.get(towers.size() - 1).checkArea() == false)
                                                towers.remove(towers.size() - 1);
                                            else gameField.money -= 5;
                                        } else if (kind == 2) {
                                            inp = 0;
                                            towers.add(new SniperTower(e.getX() - 32, e.getY() - 32));
                                            if (towers.get(towers.size() - 1).checkArea() == false)
                                                towers.remove(towers.size() - 1);
                                            else gameField.money -= 10;
                                        } else if (kind == 3) {
                                            inp = 0;
                                            towers.add(new MachineGunTower(e.getX() - 32, e.getY() - 32));
                                            if (towers.get(towers.size() - 1).checkArea() == false)
                                                towers.remove(towers.size() - 1);
                                            else gameField.money -= 15;
                                        }
                                    }  if(e.getX() <64 && e.getY() < 64) {
                                        PAUSE = true;
                                    }
                                    if(e.getX() >= 100 ) PAUSE = false;
                                }
                            });
                    gameField.drawMap(gc);
                    if (kind == 1 && mouseX != -1) {
                        gc.drawImage(imgT, mouseX - 32, mouseY - 32);
                        gc.drawImage(imgT1, mouseX - 32, mouseY - 32);
                    } else if (kind == 2 && mouseX != -1) {
                        gc.drawImage(imgT, mouseX - 32, mouseY - 32);
                        gc.drawImage(imgT2, mouseX - 32, mouseY - 32);
                    } else if (mouseX != -1) {
                        gc.drawImage(imgT, mouseX - 32, mouseY - 32);
                        gc.drawImage(imgT3, mouseX - 32, mouseY - 32);
                    }

                    if(PAUSE == false) {
                        if(!enemys.isEmpty()) {
                            for (int i = 0; i < enemys.size(); i++) {
                                enemys.get(i).setPos();
                            }
                        }


                        for (int i = 0; i < bullets.size(); i++) {
                            if (bullets.get(i).getCloset() != null) {
                                if (bullets.get(i).reachCloset()) {
                                    bullets.get(i).closet.setHealthy(bullets.get(i));
                                    {
                                        if (bullets.get(i).closet.getHealthy() < 0) {
                                            bullets.get(i).setCloset(null);
                                        }
                                        bullets.remove(i);
                                    }

                                } else {
                                    bullets.get(i).setPos();
                                }

                            } else {
                                bullets.remove(i);
                            }
                        }


                        for (int i = 0; i < towers.size(); i++) {

                            towers.get(i).setReady(towers.get(i).getTimeShoot() + 1);
                            towers.get(i).chooseCloset(enemys);
                            if (towers.get(i).closet != null && towers.get(i).areReady() && towers.get(i).distance(towers.get(i).closet) <= towers.get(i).range) {
                                bullets.add(towers.get(i).spawnBullet());
                                bullets.get(bullets.size() - 1).closet = towers.get(i).closet;
                                if (towers.get(i).closet.getHealthy() < 0) {
                                    towers.get(i).closet = null;
                                }
                                towers.get(i).setReady(0);
                            }
                        }
                    }

                    if(!enemys.isEmpty()) {
                        for (int i = 0; i < enemys.size(); i++) {
                            if (enemys.get(i).getPosY() <= 448) {
                                enemys.get(i).move(gc);
                                enemys.get(i).drawBlood(gc);
                            }
                        }
                    }

                    for(int i=0;i<towers.size();i++) {
                        towers.get(i).drawTower(gc);
                    }
                    for(int i=0;i<bullets.size();i++) {
                        bullets.get(i).drawBullet(gc);
                    }
                    if(!enemys.isEmpty()) gameField.removeEnemy(enemys);
                    if(!enemys.isEmpty()) {
                        for(int i=0;i<enemys.size();i++)
                            if(enemys.get(i).getHealthy() < 0) {
                                gameField.money+=enemys.get(i).reward;
                                enemys.remove(i);
                            }
                    }

                    if(gameField.checkGameOver() == true) type = 5;

                    if(enemys.isEmpty() && typeA ==0) {
                        gc.drawImage(new Image("file:image/level.jpg"), 1, 1);
                        gameField.spawnEnemy2(enemys);
                        type = 3;

                    }
                    if(enemys.isEmpty() && typeA == 4) {
                        gc.drawImage(new Image("file:image/Tw.png"), 0, 0);
                    }
                }

                else if(type == 3 && typeA != 4) {
                    canvas.setOnMouseClicked(
                            new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent mouseEvent) {
                                    if(mouseEvent.getX() >750 && mouseEvent.getX() < 866 && mouseEvent.getY() < 337 && mouseEvent.getY() > 300 ) {
                                        type = 2;
                                        typeA = 4;
                                    }
                                }
                            }
                    );

                }

                else if(type == 5) {
                    gc.drawImage(new Image("file:image/To.png"), 0, 0);
                }
                else if(type == 6){
                    gc.drawImage(new Image("file:image/Tw.png"), 0, 0);

                }
            }
        }.start();

        theStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}