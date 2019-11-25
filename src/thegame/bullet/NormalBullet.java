package thegame.bullet;

import javafx.scene.image.Image;
import thegame.Config;
import thegame.enemy.Enemy;

public class NormalBullet extends Bullet {
    public NormalBullet(double posX, double posY) {
        super(posX, posY);
        this.demage = Config.NORMAL_BULLET_DEMAGE;
        this.speed = Config.NORMAL_BULLET_SPEED;
        this.imgB = new Image("file:image/towerDefense_tile274.png");
    }

}
