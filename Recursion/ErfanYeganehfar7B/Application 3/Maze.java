
/**
 * This program searches for a path through a maze, 0 means that the path is accessible while 1's represent walls.
 * Entrances are any col or row with an index of 0, exit are at a max location (4). The objective is to reach the exit from the start
 * This program takes a 5x5 maze and determines whether the maze can be completed from start to finish.
 * @author Erfan Yeganehfar
 * @version 1.0 April 14, 2019
 * Ms.Krasteva
 */
public class Maze {

	/**
	 * This method checks every possible entrance of the maze for a possible path
	 * @param arr the array passed into the method to check for a possible path
	 * @return a boolean representing whether the 5x5 maze has a possible path
	 */
	private static boolean startMaze (int[] [] arr){
    	return findPath (arr, 0, 0) || findPath (arr, 0, 1) || findPath (arr, 0, 2) || findPath (arr, 0, 3) || findPath (arr, 0, 4) || findPath (arr, 1, 0) || findPath (arr, 2, 0) || findPath (arr, 3, 0) || findPath (arr, 4, 0);
    }

	/**
	 * The findPath method checks if the current index is a valid index in the maze,
	 * it also checks if the current index is an exit.
	 * If none of the conditions above are satisfied, then the current index is changed to 2 (representing a visited index)
	 * and findPath is called again to see if any of the cardinal directions are possible paths
	 * @param gridMaze the 5x5 maze to be checked whether it contains a path
	 * @param row the current row index in the maze
	 * @param col the current column index in the maze
	 * @return whether the maze has a path from start to finish
	 */
	private static boolean findPath(int[] [] gridMaze, int row, int col) {
		if (row < 0 || row > 4 || col < 0 || col > 4 || gridMaze[row][col] == 1 ||  gridMaze[row][col] == 2)
			return false;
		else if (gridMaze[row][col] == 0 && (row == 4 || col == 4))
			return true;
		gridMaze[row][col] = 2;
		return findPath(gridMaze, row + 1, col) || findPath(gridMaze, row - 1, col) || findPath(gridMaze, row, col + 1) || findPath(gridMaze, row, col - 1);
	}

	/**
	 * The main method instantiates the maze and starts the maze
	 * @param args Unsigned args
	 */
    public static void main(String[] args) {
    	int[][] maze= {{1,0,1,1,1},
    				   {1,0,0,0,1},
    				   {1,0,1,0,1},
    				   {1,0,1,0,1},
    				   {1,1,1,0,1}};
        System.out.println(startMaze(maze));
    }
}