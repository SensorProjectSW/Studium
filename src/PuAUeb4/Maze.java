package PuAUeb4;

public class Maze {
    static int[][] maze = { {4, 10, 6, 12, 12, 10, 6, 12, 14, 8},
                            {6, 9, 3, 4, 12, 11, 5, 8, 5, 10},
                            {5, 10, 3, 6, 10, 5, 12, 14, 12, 9},
                            {6, 9, 3, 3, 3, 6, 10, 1, 6, 10},
                            {5, 10, 5, 11, 5, 9, 3, 6, 9, 3},
                            {2, 3, 6, 13, 12, 10, 5, 13, 8, 3},
                            {3, 3, 3, 6, 10, 5, 12, 12, 10, 3},
                            {3, 5, 9, 3, 5, 10, 6, 10, 5, 11},
                            {3, 6, 10, 3, 2, 5, 9, 7, 8, 3},
                            {5, 9, 5, 13, 13, 12, 8, 5, 12, 9}
                          };

    static int h = maze.length; // height of the maze
    static int w = maze[0].length; // width of the maze

    static int s_x = 0; // start at this x-coordinate
    static int s_y = 0; // start at this y-coordinate
    static int t_x = 0; // destination is at this x-coordinate
    static int t_y = h - 1; // destination is at this y-coordinate

    public static void display() {
		for (int i = 0; i < h; ++i) {
			// draw the north edge
			for (int j = 0; j < w; ++j) {
				System.out.print((maze[i][j] & 1) == 0 ? "+---" : "+   ");
			}
			System.out.println("+");
			// draw the west edge and waypoints
			for (int j = 0; j < w; ++j) {
                String d = (maze[i][j] & 8) == 0 ? "| " : "  ";
                if((maze[i][j] & 16) != 0) { // is waypoint
                    d += "*";
                } else if(j == s_x && i == s_y) { // is start
                    d += "s";
                } else if(j == t_x && i == t_y) { // is exit
                    d += "t";
                } else {
                    d += " ";
                }
                d += " ";
				System.out.print(d);
			}
			System.out.println("|");
		}
		// draw the bottom line
		for (int j = 0; j < w; ++j) {
			System.out.print("+---");
		}
		System.out.println("+");
	}

    /// set a waypoint for the given position (x, y)
    public static void setWaypoint(int x, int y) {
        maze[y][x] |= 16;
    }

    /// unset a waypoint for the given position (x, y)
    public static void unsetWaypoint(int x, int y) {
        maze[y][x] &= 15;
    }

    /// return true iff (if and only if) there is a waypoint set for the given position (x, y)
    public static boolean isWaypoint(int x, int y) {
        return (maze[y][x] & 16) != 0;
    }

    /// return true iff we can move from the given position (x, y) into the given direction
    public static boolean check(int x, int y, char dir) {
        int cell = maze[y][x];
        switch(dir) {
            case 'N':
                return (cell & 1) != 0;
            case 'S':
                return (cell & 2) != 0;
            case 'E':
                return (cell & 4) != 0;
            case 'W':
                return (cell & 8) != 0;
            default:
                System.out.println("Error: Unknown direction!");
                return false;
        }
    }

    /// return true iff there is a path from (s_x, s_y) to (t_x, t_y)
    /// if yes: additionally set waypoints for one possible path
    public static boolean search() {
        return searchRec(s_x, s_y);
    }

    /// helper method for a recursive solution
    public static boolean searchRec(int x, int y) {
        if (isWaypoint(x,y)) {
            return false;
        }
        if (x == t_x && y == t_y) {
            unsetWaypoint(x,y);
            return true;
        }
        setWaypoint(x,y);
        if (check(x,y,'S')) { //nach unten?
            if (searchRec(x, y+1)) {
                return true;
            }
        }
        if (check(x,y,'E')) { //nach rechts?
            if (searchRec(x+1, y)) {
                return true;
            }
        }
        if (check(x,y,'W')) { //nach links?
            if (searchRec(x-1, y)) {
                return true;
            }
        }
        if (check(x,y, 'N')) { //nach oben?
            if (searchRec(x, y-1)) {
                return true;
            }
        }
        unsetWaypoint(x,y);
        return false;
    }

	public static void main(String[] args) {
        display();
        System.out.println(search());
        display();
	}
}
