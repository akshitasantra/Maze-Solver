import java.io.File;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class CopyOfMazeSolver {
    public static void main(String[] args) {
        List<Point> maze = readMaze("Maze1.txt");
        System.out.println(maze);
        System.out.println(isSolvable(maze));
    }

    public static List<Point> readMaze(String filename) {
        try {
            File file = new File(filename);
            Scanner scan = new Scanner(file);
            List<Point> maze = new ArrayList<Point>();
            Point one = null;
            Point two = null;
            int y = 0;
            while(scan.hasNextLine()) {
                String line = scan.nextLine();
                System.out.println(line);
                for(int x=0; x<line.length(); x++) {
                    if(line.substring(x,x+1).equals(" ")) {
                        maze.add(new Point(x,y));
                    }
                    if(line.substring(x,x+1).equals("1")) {
                        one = new Point(x,y);
                    }
                    if(line.substring(x,x+1).equals("2")) {
                        two = new Point(x,y);
                    }
                }
                y++;
            }
            maze.add(0,one);
            maze.add(two);
            return maze;
        }
        catch(Exception err) {
            err.printStackTrace();
        }
        return null;
    }

    public static boolean isAdjacent(Point a, Point b) {
        return ((b.getX() + 1 == a.getX() || b.getX() - 1 == a.getX()) && b.getY() == a.getY()) || (b.getY() + 1 == a.getY() || b.getY() - 1 == a.getY()) && b.getX() == a.getX();
    }

    public static boolean isSolvable(List<Point> maze) {
        List<Point> list2 = new ArrayList<Point>();
        list2.add(maze.get(0));
        maze.remove(0);
        while(list2.size()>0){
            if(isAdjacent(maze.get(maze.size()-1),list2.get(0))){
                return true; 
            }
            for(int i = 0; i < maze.size(); i++){
                if(isAdjacent(maze.get(i),list2.get(0))){
                    list2.add(maze.get(i));
                }
            }
            list2.remove(0);
        }
        return false;
    }
    public static class Point {
        // CLASS VARIABLES/FIELDS
        private int x;
        private int y;
        // CONSTRUCTOR: CALLED BY "NEW"
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        // GETTER/ACCESSOR METHODS
        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
        // OVERRIDE TOSTRING METHOD
        @Override
        public String toString() {
            return "("+x+","+y+")";
        }
    }
}