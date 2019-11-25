package thegame.bullet;

import javafx.scene.canvas.GraphicsContext;
import thegame.GameEntities;
import thegame.enemy.Enemy;
import thegame.tile.GameTile;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import thegame.tile.SniperTower;
import thegame.tile.Tower;

import java.awt.*;

public class Bullet extends GameEntities {
    public double speed ;
    public double demage;
    public Enemy closet;
    public Image imgB = new Image("file:image/towerDefense_tile274.png");

    public Bullet(double posX, double posY) {
        super(posX, posY);
    }

    public void setCloset(Enemy closet) {
        this.closet = closet;
    }

    public Enemy getCloset() {
        return closet;
    }

    public void setPos() {

        double x=Math.abs(posX-closet.getPosX());
        double y=Math.abs(posY-closet.getPosY());
        double Xmove=speed*x/Math.sqrt(x*x+y*y);
        double Ymove=speed*y/Math.sqrt(x*x+y*y);

        if(posX > closet.getPosX())
            posX-=Xmove;
        else
            posX+=Xmove;

        if(posY > closet.getPosY())
            posY-=Ymove;
        else
            posY+=Ymove;
    }

    public boolean reachCloset() {
        if(closet!=null) {
            if (Math.sqrt((posX- closet.getPosX()) * (posX - closet.getPosX()) + (posY - closet.getPosY()) * (posY - closet.getPosY())) < speed) {
                return (true);
            }
            return (false);
        }
        return (true);
    }

    public void drawBullet(GraphicsContext gc) {
        gc.drawImage(imgB, this.posX, this.posY);
    }

}
