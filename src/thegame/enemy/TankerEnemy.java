package thegame.enemy;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import thegame.Config;

public class TankerEnemy extends Enemy {
    public TankerEnemy(double posX, double posY, int status) {
        super(posX, posY, status);
        this.img = new Image("file:image/towerDefense_tile269.png");
        this.gunImg = new Image("file:image/towerDefense_tile292.png");
        this.speed = Config.TANKER_ENEMY_SPEED;
        this.healthy = Config.TANKER_ENEMY_HEALTH;
        this.reward = Config.TANKER_ENEMY_REWARD;
        this.armor = Config.TANKER_ENEMY_ARMOR;
    }

    @Override
    public void drawBlood(GraphicsContext gc) {
        gc.strokeRect(posX+17, posY - 2, 30, 5 );
        gc.setFill(Color.RED);
        gc.fillRect(posX+17 , posY -2, 30 , 5);
        gc.setFill(Color.BLUE);
        double x =((Config.TANKER_ENEMY_HEALTH- this.getHealthy())/Config.TANKER_ENEMY_HEALTH)*30;
        if(x>30) x =30;
        gc.fillRect(posX + 17 + 30 - x, posY -2 ,x , 5);

    }
}
