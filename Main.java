import java.awt.Point;


public class Main {
    public static int spacing = 30;
    public static void main(String[] args){
        Cosketch c = new Cosketch(1280,0);
        c.eraseAll();
        c.setTool(Cosketch.TOOL.CIRCLE, Cosketch.SIZE.SMALL);
        for(int i = 0 ; i < 30 ; i++){
            if(i%2==0)c.setSize(Cosketch.SIZE.LARGE);
            else c.setSize(Cosketch.SIZE.SMALL);
            c.drag(i*10, i*10, i*20, i*20);
        }

        
        System.exit(0);
        for(int x = 0 ; x < 800 ; x+=spacing)
            for(int y = 0 ; y < 600 ; y+=spacing){
                Point vec = field((x-400)/400.0*4,(y-300)/300.0*3);
                c.drag(x,y,x+vec.x,y+vec.y);
            }                    
    }
    public static Point field(double x, double y){
        return new Point(
                (int)(-y*10),
                (int)(x*10)
                );
    }
}
