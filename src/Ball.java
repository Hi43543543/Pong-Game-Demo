import java.awt.*;

import static utils.Constants.*;

public class Ball extends Sprite {
    private double vx;
    private double vy;

    public Ball() {
        super(BALL_IMAGE_PATH, 200, 145, BALL_WIDTH, BALL_HEIGHT);
        resetBall();
    }

    public void resetBall() {
    }

    @Override
    public void tick() {
        pos.translate((int) vx, (int) vy);
        vx = BALL_SPEED;
        vy = BALL_SPEED;

        pos.x = Math.clamp(pos.x, 0, BOARD_WIDTH - PLAYER_WIDTH);
        pos.y = Math.clamp(pos.y, 0, BOARD_HEIGHT - PLAYER_HEIGHT);
    }
}