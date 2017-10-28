package midterm;

import java.util.ArrayList;

public class Solution {
	private ArrayList<Cell> path = new ArrayList<Cell>();
	int row =0; int column=0; //top left indexes
	
	public Solution() {
		
	}
	public ArrayList<Cell> findPath(int[][] maze){
				
		boolean isComplete =false;
		boolean isNoBlocked= false;
		//make sure row and column indexes are still in bounds
		if(row >=0 && row <maze.length && column >=0 && column <maze[0].length) {
			//no block		
			if(maze[row][column]==1) {
				path.add(new Cell(row,column));
				isNoBlocked =true;
			}
		}
		
		if(isNoBlocked) {
			//bottom right indexes		
			if(row==maze.length-1 && column==maze[0].length-1) {
				isComplete=true; //at the bottom right
			}
			else {
				row++;//next row
				findPath(maze);
				if(!isComplete) {
					column++;//next column
					findPath(maze);
				}		
			} 		
		}	
		return path;
	}  
}
