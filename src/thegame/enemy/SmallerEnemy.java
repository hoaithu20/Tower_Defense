package thegame.enemy;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import thegame.Config;

import java.util.Collection;

public class SmallerEnemy extends Enemy {
    public SmallerEnemy(double posX, double posY, int status) {
        super(posX, posY, status);
        this.img = new Image("file:image/towerDefense_tile271.png");
        this.speed = Config.SMALLER_ENEMY_SPEED;
        this.reward = Config.SMALLER_ENEMY_REWARD;
        this.armor = Config.SMALLER_ENEMY_ARMOR;
        this.healthy = Config.SMALLER_ENEMY_HEALTH;
    }

    @Override
    public void drawBlood(GraphicsContext gc) {
        gc.strokeRect(posX+17, posY - 2, 30, 5 );
        gc.setFill(Color.RED);
        gc.fillRect(posX+17 , posY -2, 30 , 5);
        gc.setFill(Color.BLUE);
        double x =((Config.SMALLER_ENEMY_HEALTH - this.getHealthy())/Config.SMALLER_ENEMY_HEALTH)*30;
        if(x>30) x = 30;
        gc.fillRect(posX + 17 + 30 - x, posY -2 ,x , 5);

    }
}
