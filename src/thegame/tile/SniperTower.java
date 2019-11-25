package thegame.tile;

import javafx.scene.image.Image;
import thegame.Config;
import thegame.bullet.Bullet;
import thegame.bullet.SniperBullet;

public class SniperTower extends Tower {
    public SniperTower() {}
    public SniperTower(double posX, double posY) {
        super(posX, posY);
        this.imgT = new Image("file:image/towerDefense_tile206.png");
        this.gunImageT = new Image("file:image/towerDefense_tile181.png");
        this.range = Config.SNIPER_TOWER_RANGE;
        this.price = Config.SNIPER_TOWER_PRICE;
    }

    @Override
    public SniperBullet spawnBullet() {
        SniperBullet sniperBullet = new SniperBullet(posX, posY);
        return sniperBullet;
    }

}
