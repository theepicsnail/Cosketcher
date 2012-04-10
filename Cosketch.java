import java.awt.Point;


public class Cosketch {
    public static enum SIZE {SMALL,MEDIUM,LARGE};
    public static enum TOOL {PEN, LINE, ARROW, CIRCLE, RECTANGLE};//, TEXT}
    
    private Point   penTool  = new Point(20,250),
                    lineTool = new Point(60,250),
                    arrowTool= new Point(100,250),
                    circleTool=new Point(140,250),
                    rectTool = new Point(180,250),
                    
                    erase    = new Point(50,270),
                    eraseAll = new Point(20,320),
                    
                    sizeS    = new Point(20,300),
                    sizeM    = new Point(60,300),
                    sizeL    = new Point(100,300),
    
                    screenOff= new Point(241,63);
    
    private int offX, offY;
    private Mouse mouse;
    public Cosketch(int offx, int offy){
        this.offX= offx;
        this.offY= offy;
        this.mouse = new Mouse();
    }
    
    private void click(Point p){
        mouse.moveTo(p.x+offX, p.y+offY);
        mouse.click();
    }
    public void setSize(SIZE s){
        switch(s){
            case SMALL:    click(sizeS); break;
            case MEDIUM:   click(sizeM); break;
            case LARGE:    click(sizeL); break;
        }
    }
    
    public void eraseAll(){
        click(erase);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        click(eraseAll);
    }

    public void setTool(TOOL t) {
        switch (t) {
        case PEN:       click(penTool);   break;
        case LINE:      click(lineTool);  break;
        case ARROW:     click(arrowTool); break;
        case CIRCLE:    click(circleTool);break;
        case RECTANGLE: click(rectTool);  break;
        //case TEXT:
        }
    }
    public void setTool(TOOL t, SIZE s){
        setTool(t);
        setSize(s);
    }
    
    public void moveTo(int x, int y){
        mouse.moveTo(x+screenOff.x+offX, y+screenOff.y+offY);
    }
    public void click(){
        mouse.click();
    }
    public void drag(int x, int y, int x2, int y2){
        moveTo(x,y);
        mouse.press();
        moveTo(x2,y2);
        mouse.release();
    }
}
