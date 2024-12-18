package marbles_and_lava_compeition.git.utilities;

// General Java classes
import java.util.Timer;
import java.util.TimerTask;

public class Clock {

    private static int remainingSeconds;
    private static Timer timer;
    private int time;

    public Clock(int time){
        this.time = time;
    }

    public static void startCountdown(int durationInSeconds) {
        remainingSeconds = durationInSeconds;
        timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                remainingSeconds--;
            }
        };

        timer.scheduleAtFixedRate(task, 0, 1000);
    }

    public void kickOffClock(){
        startCountdown(this.time);
    }

    public int getRemainingSeconds(){
        return remainingSeconds;
    }
}
