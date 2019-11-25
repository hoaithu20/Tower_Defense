package thegame.enemy;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import thegame.Config;

import java.util.zip.CheckedOutputStream;

public class BossEnemy extends Enemy {
    public BossEnemy(double posX, double posY, int status) {
        super(posX, posY, status);
        this.img = new Image("file:image/towerDefense_tile268.png");
        this.gunImg = new Image("file:image/towerDefense_tile291.png");
        this.speed = Config.BOSS_ENEMY_SPEED;
        this.healthy = Config.BOSS_ENEMY_HEALTH;
        this.armor = Config.BOSS_ENEMY_ARMOR;
        this.reward  = Config.BOSS_ENEMY_REWARD;

    }

    @Override
    public void drawBlood(GraphicsContext gc) {
        gc.strokeRect(posX+17, posY - 2, 30, 5 );
        gc.setFill(Color.RED);
        gc.fillRect(posX+17 , posY -2, 30 , 5);
        gc.setFill(Color.BLUE);
        double x =((Config.BOSS_ENEMY_HEALTH - this.getHealthy())/Config.BOSS_ENEMY_HEALTH)*30;
        if(x>30) x = 30;
        gc.fillRect(posX + 17 + 30 - x, posY -2 ,x , 5);

    }
}
