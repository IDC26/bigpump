import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class KeyPresser {

    public static int pressKeyEveryInterval(Robot robot, int key, int interval, int duration) {
        long startTime = System.currentTimeMillis();
        int keyPressCount = 0;

        while ((System.currentTimeMillis() - startTime) < duration * 1000) {
            robot.keyPress(key);
            robot.keyRelease(key);
            keyPressCount++;
            System.out.println("E was pressed " + keyPressCount + " times");

            try {
                TimeUnit.SECONDS.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return keyPressCount;
    }

    public static void performSequenceAfterDuration(Robot robot) {
        // Press the number "4" key two times
        robot.keyPress(KeyEvent.VK_4);
        robot.keyRelease(KeyEvent.VK_4);
        
        try {
            TimeUnit.SECONDS.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        robot.keyPress(KeyEvent.VK_4);
        robot.keyRelease(KeyEvent.VK_4);
        
        try {
            TimeUnit.SECONDS.sleep(13);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Hold "W" for 4 seconds
        robot.keyPress(KeyEvent.VK_W);
        
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        robot.keyRelease(KeyEvent.VK_W);

        // Hold "S" for 4 seconds
        robot.keyPress(KeyEvent.VK_S);
        
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        robot.keyRelease(KeyEvent.VK_S);
    }

    public static void main(String[] args) {
        int interval = 32;  // seconds
        int duration = 8 * 60;  // 8 minutes in seconds

        System.out.println("Starting in 5 seconds...");

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Robot robot = new Robot();

            while (true) {
                TimeUnit.SECONDS.sleep(4);
                // Step 1: Press "E" every 32 seconds for 25 minutes
                int keyPressCount = pressKeyEveryInterval(robot, KeyEvent.VK_E, interval, duration);

                // Print how many times "E" was pressed
                System.out.println("'E' was pressed " + keyPressCount + " times in " + duration +  "minutes.");

                // Step 2: Perform the sequence after 25 minutes
                performSequenceAfterDuration(robot);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
