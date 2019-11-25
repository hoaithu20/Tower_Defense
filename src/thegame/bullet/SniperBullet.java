package thegame.bullet;

import javafx.scene.image.Image;
import thegame.Config;
import thegame.enemy.Enemy;

public class SniperBullet extends Bullet {
    public SniperBullet(double posX, double posY) {
        super(posX, posY);
        this.demage = Config.SNIPER_BULLET_DEMAGE;
        this.speed = Config.SNIPER_BULLET_SPEED;
        this.imgB = new Image("file:image/towerDefense_tile272.png");
    }
}
