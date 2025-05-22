import javax.swing.*;
import java.awt.*;
import java.util.Random;
import static utils.Constants.*;

public class Ball extends Sprite {
    private double vx;
    private double vy;
    private int rally = 0;
    Random r= new Random();

    public Ball() {
        super(BALL_IMAGE_PATH, 0, 0, BALL_WIDTH, BALL_HEIGHT);
        resetBall();
    }

    public void resetBall() {
        pos.x = BOARD_WIDTH / 2 - BALL_WIDTH / 2;
        pos.y = BOARD_HEIGHT / 2 - BALL_HEIGHT / 2;

        int r1 = r.nextInt(4);
        vx = BALL_SPEED;
        vy = BALL_SPEED;
        if (r1 == 0 || r1 == 3) {
            vy = -BALL_SPEED;
        }
        if (r1 == 2 || r1 == 3) {
            vx = -BALL_SPEED;
        }
        rally = 0;
    }

    public int getRally() {
        return rally;
    }

    @Override
    public void tick() {
        pos.translate((int) vx, (int) vy);
    }

    public void bounceLeft() {
        vx = -Math.abs(vx) * 1.05;
        rally++;
    }

    public void bounceRight() {
        vx = Math.abs(vx) * 1.05;
        rally++;
    }
    public void flipVy() {
        vy = -vy;
    }
    public void flipVx() {
        vx = -vx;
    }
}