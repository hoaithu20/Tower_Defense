package thegame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameStage {
    private int width;
    private int height;
    private Image img1 = new Image("file:image/towerDefense_tile203.png");
    private Image img2 = new Image("file:image/towerDefense_tile249.png");
    private Image img3 = new Image("file:image/towerDefense_tile250.png");

    ImageView imageView1 = new ImageView(img1);
    ImageView imageView2 = new ImageView(img2);
    ImageView imageView3 = new ImageView(img3);

    private Button button1 = new Button("a",imageView1);

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public static final String[][] MAP_SPRITES = new String[][] {
            { "024","024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "249", "206", "250" },
            { "024","024", "024", "003", "047", "047", "047", "004", "024", "024", "024" },
            { "024","024", "024", "025", "299", "001", "002", "023", "024", "024", "024" },
            { "024","024", "024", "025", "023", "024", "025", "023", "024", "024", "024" },
            { "024","003", "047", "048", "023", "024", "025", "023", "024", "024", "024" },
            { "024","025", "299", "001", "027", "024", "025", "046", "047", "047", "047" },
            { "024","025", "023", "024", "024", "024", "026", "001", "001", "001", "001" },
            { "024","025", "023", "024", "024", "024", "024", "024", "024", "024", "024" },
    };

    public static final String[][] Icon = new String[][] {
            {"999", "135", "137", "0", "0", "0","0","0","0","0","0"},
            {"0", "", "0", "0", "0", "132","0","0","0","134","0"},
            {"0", "021", "0", "0", "0", "0","0","0","0","0","0"},
            {"044", "0", "0", "0", "0", "0","0","0","0","0","0"},
            {"0", "0", "0", "0", "0", "0","0","","0","0","0"},
            {"0", "0", "0", "0", "0", "0","0","0","0","0","0"},
            {"019", "0", "0", "020", "0", "0","0","021","0","0","0"},
            {"0", "0", "0", "0", "0", "0","0","0","131","130","0"}

    };


}
