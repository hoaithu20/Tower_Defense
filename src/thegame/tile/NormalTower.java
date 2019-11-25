package thegame.tile;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import thegame.Config;
import thegame.bullet.Bullet;
import thegame.bullet.NormalBullet;

public class NormalTower extends Tower {

    public NormalTower(){}

    public NormalTower(double posX, double posY) {
        super(posX, posY);
        this.imgT = new Image("file:image/towerDefense_tile249.png");
        this.gunImageT = new Image("file:image/towerDefense_tile181.png");
        this.range = Config.NORMAL_TOWER_RANGE;
        this.price = Config.NORMAL_TOWER_PRICE;
    }

    @Override
    public Bullet spawnBullet() {
        NormalBullet normalBullet = new NormalBullet(this.posX, this.posY-32);
        return normalBullet;
    }

}
