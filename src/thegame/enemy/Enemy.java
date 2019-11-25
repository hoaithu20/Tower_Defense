package thegame.enemy;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import thegame.GameEntities;
import thegame.bullet.Bullet;
import thegame.bullet.NormalBullet;
import thegame.tile.Tower;

public abstract class Enemy extends GameEntities {
    public double speed ;
    public double healthy;
    public double armor;
    public double reward;
    public Image img;
    public Image gunImg;
    public int status = 1;

    public Enemy(double posX, double posY, int status) {
        this.posX = posX;
        this.posY = posY;
        this.status = status;
    }
    public void setHealthy(Bullet bullet) {
        healthy-= (bullet.demage- armor);
    }

    public double getHealthy(){
        return healthy ;
    }

    public void setPos() {
        if (status == 1) {
            this.posY -= this.speed;
            if (posY <= 288) status = 2;
        }
        else if (status == 2) {
            this.posX += this.speed;
            if (posX >= 224) status = 3;
        }
        else if (status == 3) {
            this.posY -= this.speed;
            if (posY <= 96) status = 4;
        }
        else if (status == 4) {
            this.posX += this.speed;
            if (posX >= 416) status = 5;
        }
        else if (status == 5) {
            this.posY += this.speed;
            if(posY >= 352) status = 6;
        }
        else if(status == 6) this.posX += this.speed;
    }

    enum Direction {
        LEFT(180), UP(270), RIGHT(0), DOWN(90);

        int degree;

        Direction(int i) {
            degree = i;
        }

        int getDegree() {
            return degree;
        }
    }

    public void move(GraphicsContext gc) {
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);

        Direction direction = null;

        if(status == 1 || status == 3) direction = Direction.UP;
        if(status == 2 || status == 4 || status == 6) direction = Direction.RIGHT;
        if(status == 5) direction = Direction.DOWN;

        Image base, gun;

        ImageView iv = new ImageView(img);
        iv.setRotate(direction.getDegree());
        base = iv.snapshot(params, null);

        ImageView iv2 = new ImageView(gunImg);
        iv2.setRotate(direction.getDegree());
        gun = iv2.snapshot(params, null);

        gc.drawImage(base, posX, posY);
        gc.drawImage(gun, posX, posY);
    }

    public abstract void drawBlood(GraphicsContext gc);

}

