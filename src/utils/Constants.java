package utils;

public final class Constants {
    private Constants() {
        // prevents instantiation
    }

    // Board constants
    public static final int BOARD_WIDTH = 600;
    public static final int BOARD_HEIGHT = 450;
    // A delay of 25 milliseconds results in a frame rate of 45 FPS.
    public static final int TICK_DELAY = 25;

    // Player constants

    public static final String BALL_IMAGE_PATH = "resources/Ball.png";
    public static final int BALL_WIDTH = 76;
    public static final int BALL_HEIGHT = 82;
    public static final int BALL_SPEED = 7;

    // Wall constants
    public static final String WALL_IMAGE_PATH = "resources/wall.png";
    public static final int WALL_WIDTH = 55;
    public static final int WALL_HEIGHT = 75;

    // Paddle constants
    public static final String PADDLE_IMAGE_PATH = "resources/Paddle left.png";
    public static final int PADDLE_WIDTH = 18;
    public static final int PADDLE_HEIGHT = 97;
    public static final int PADDLE_SPEED = 5;

}
