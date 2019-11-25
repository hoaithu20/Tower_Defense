package thegame.tile;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import thegame.Config;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import thegame.GameEntities;
import thegame.bullet.Bullet;
import thegame.enemy.Enemy;

import java.awt.*;
import java.util.ArrayList;

public abstract class Tower extends GameTile {
    public double range;
    public double demage;
    public double price;
    public int kind;
    public Enemy closet = null;
    public Image imgT;
    public Image gunImageT;
    public int timeShoot = 30;


    public Tower(){}

    public Tower(double posX, double posY) {
        super(posX, posY);
    }

    public boolean checkArea() {
        if(this.posX > 10 * Config.SIZE && this.posY > 7*Config.SIZE) return false;
        else {
            if((posX > 32 && posX < 160) && (posY > 224)) return false;

            if((posX > 160 && posX < 288) && (posY > 32 && posY < 352)) return false;

            if((posX > 288 && posX < 480) && (posY > 32 && posY < 160)) return false;

            if((posX > 352 && posX < 480) && (posY > 160) && (posY < 416)) return false;

            if((posX > 480 ) && (posY > 288 && posY < 416)) return false;

            return true;
        }
    }

    public abstract Bullet spawnBullet();

    public void chooseCloset(ArrayList<Enemy> enemies) {
        double dist = this.range;
        if (!enemies.isEmpty()) {
            for (int i = 0; i < enemies.size(); i++) {
                if(enemies.get(i).getPosY() <=448 && this.distance(enemies.get(i)) < this.range) {

                    double distance = this.distance(enemies.get(i));
                    if (distance < dist) {
                        dist = distance;
                        this.closet = enemies.get(i);
                    }
                }
            }
        }
    }

    public double angle() {
        return (180 / Math.PI) * Math.atan2(posX - closet.getPosX(), posY - closet.getPosY());
    }

    public void drawTower(GraphicsContext graphicsContext) {
        graphicsContext.drawImage(gunImageT, posX, posY);
        graphicsContext.drawImage(imgT, posX, posY);
    }

    public double distance(Enemy enemy) {
        double dX = this.posX - enemy.getPosX();
        double dY = this.posY - enemy.getPosY();
        return Math.sqrt(dX*dX + dY*dY);
    }

    public int getTimeShoot() {
        return timeShoot;
    }

    public void setReady(int timeShoot){
        this.timeShoot = timeShoot;
    }

    public boolean areReady(){
        if(timeShoot >= 30)
            return (true);
        return (false);
    }

}
