package thegame.enemy;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import thegame.Config;
import thegame.tile.Tower;

import java.awt.*;

public class NormalEnemy extends Enemy {


    public NormalEnemy(double posX, double posY, int status) {
        super(posX, posY, status);
        img = new Image("file:image/towerDefense_tile248.png");
        this.speed =  Config.NORMAL_ENEMY_SPEED;
        this.healthy = Config.NORMAL_ENEMY_HEALTH;
        this.reward = Config.NORMAL_ENEMY_REWARD;
        this.armor = Config.NORMAL_ENEMY_ARMOR;
    }

    @Override
    public void drawBlood(GraphicsContext gc) {
        gc.strokeRect(posX+17, posY - 2, 30, 5 );
        gc.setFill(Color.RED);
        gc.fillRect(posX+17 , posY -2, 30 , 5);
        gc.setFill(Color.BLUE);

        double x = ((Config.NORMAL_ENEMY_HEALTH - this.getHealthy()) / Config.NORMAL_ENEMY_HEALTH) * 30;
        if(x>30) x =30;
        gc.fillRect(posX + 17 + 30 - x, posY - 2, x, 5);

    }

}
