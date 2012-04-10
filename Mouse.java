import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;


public class Mouse {
    private Robot rob;
    public Mouse(){
        try {
            this.rob = new Robot();
            rob.setAutoDelay(10);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
    public void moveTo(int x, int y){
        rob.mouseMove(x, y);
    }
    public void click(){
        press(); 
        release();
    }
    public void press(){
        rob.mousePress(InputEvent.BUTTON1_MASK);
    }
    public void release(){
        rob.mouseRelease(InputEvent.BUTTON1_MASK);
    }
}
