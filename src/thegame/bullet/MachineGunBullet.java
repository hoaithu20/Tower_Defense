package thegame.bullet;

import javafx.scene.image.Image;
import thegame.Config;
import thegame.enemy.Enemy;

public class MachineGunBullet extends Bullet {
    public MachineGunBullet(double posX, double posY) {
        super(posX, posY);
        this.demage = Config.MACHINE_GUN_BULLET_DEMAGE;
        this.speed = Config.MACHINE_GUN_BULLET_SPEED;
        this.imgB = new Image("file:image/towerDefense_tile273.png");
    }
}
