package thegame;

import javafx.scene.canvas.GraphicsContext;

public class GameEntities {
    public double posX;
    public double posY;

    public GameEntities() {};

    public GameEntities(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public void draw(GraphicsContext graphicsContext) {};
}
