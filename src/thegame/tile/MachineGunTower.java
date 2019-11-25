package thegame.tile;

import javafx.scene.image.Image;
import thegame.Config;
import thegame.bullet.Bullet;
import thegame.bullet.MachineGunBullet;

import java.awt.*;

public class MachineGunTower extends Tower {
    public MachineGunTower(double posX, double posY) {
        super(posX, posY);
        this.imgT = new Image("file:image/towerDefense_tile250.png");
        this.gunImageT = new Image("file:image/towerDefense_tile181.png");
        this.range = Config.MACHINE_GUN_TOWER_RANGE;
        this.price = Config.MACHINE_GUN_TOWER_PRICE;
    }

    @Override
    public MachineGunBullet spawnBullet() {
        MachineGunBullet machineGunBullet = new MachineGunBullet(posX, posY);
        return machineGunBullet;
    }
}
