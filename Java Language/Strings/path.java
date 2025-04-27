public class path {

    public static void main(String[] args) {
        String path = "WNEENESENNN";
        int x =0;
        int y=0;
        System.out.println("x1,y1 = ("+x+","+y+")");
        for(int i =0;i<path.length();i++){
            char dir = path.charAt(i);
            if(dir=='N'){
                y++;
            }
            else if(dir=='S'){
                y--;
            }
            else if(dir=='E'){
                x++;
            }
            else {
                x--;
            }

        }
        System.out.println("x2,y2 = ("+x+","+y+")");
        float shortest_path = (float)Math.sqrt((x*x)+(y*y));
        System.out.println(shortest_path);
        

    }
    
}
