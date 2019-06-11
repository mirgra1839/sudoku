package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class sudoktry {
	
	private ArrayList<ArrayList<Integer>> previousGenerate, previousVerify;
	//------------#
	//Sudoku board#
	//------------#
	
	private ArrayList<Integer> board;
	//-------------------------#
	//Sudoku semi-covered board#
	//-------------------------#
	
	private ArrayList<Integer> player;
	
	public sudoktry() {
		clear();
	}
	//---------------------------------------#
	//Clears and reinitializes the ArrayLists#
	//---------------------------------------#
	
	public void clear() {
		board = new ArrayList<Integer>(Collections.nCopies(81, 0));
		player = new ArrayList<Integer>(Collections.nCopies(81, 0));
		previousGenerate = new ArrayList<ArrayList<Integer>>();
		previousVerify = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < 81; i++) {
			previousGenerate.add(new ArrayList<Integer>());
			previousVerify.add(new ArrayList<Integer>());
		}
	}
	//---------------------------------------------------------------#
	//Generates a random int number between the max and min parameter#
	//---------------------------------------------------------------#
	
	private int generateRandom(int max, int min) {
		return new Random().nextInt(max) + min;
	}
	
	@SuppressWarnings("unused")
	private void generateRandomBoard() {
		for (int i = 0; i < board.size(); i++) {
			board.set(i, generateRandom(9, 1));
		}
	}
	
	//-----------------------------------------------------#
	//Creates a board with only 20 to 40 elements uncovered#
	//-----------------------------------------------------#
	
	public void generatePlayer() {
		generatePlayer(generateRandom(40, 20));
	}

	//--------------------------------------------------------#
	//return an ArrayList containing the player's Sudoku board#
	//--------------------------------------------------------#
	
	public ArrayList<Integer> getPlayer() {
		return player;
	}
	
	//------------------------------------------------------------------------#
	//Generates the player's board by putting the number of elements specified#
	//------------------------------------------------------------------------#
	
	public void generatePlayer(int num) {
		for (int i = 0; i < num; i++) {
			ArrayList<Integer> zerosIndex = getIndexes(player, 0);
			int rand = generateRandom(zerosIndex.size() - 1, 0);

			player.set(zerosIndex.get(rand), board.get(zerosIndex.get(rand)));
		}
	}
	public String sudokuString(ArrayList<Integer> l) {
		String sudoku = "";
		for (int i : l) {
			if (i == 0) {
				sudoku += ".";
			} else {
				sudoku += i;
			}
		}
		return sudoku;
	}
	
	//----------------------------------------------------------------#
	//Generates the board by calling the method generateBoard(int num)#
	//----------------------------------------------------------------#
	
	public void generateBoard() {
		generateBoard(0);
	}
	
	//-----------------------------------------------------------#
	//method generating the Sudoku using a backtracking algorithm#
	//-----------------------------------------------------------#
	
	private void generateBoard(int num) {
		if (!fullBoard() && !checkBoard(board)) {
			ArrayList<Integer> available = complement(
					combineArrayList(Arrays.asList(getNeighbours(num, board), previousGenerate.get(num))));

			if (available.size() == 0) {
				board.set(num, 0);
				previousGenerate.get(num).clear();

				generateBoard(num - 1);
			} else {
				board.set(num, available.get(generateRandom(available.size(), 0)));
				previousGenerate.get(num).add(board.get(num));

				generateBoard(num + 1);
			}
		}
	}
	
	//----------------------------------------------------#
	//Checks if there are more than two possible solutions#
	//----------------------------------------------------#
	
	private boolean solve(int num, ArrayList<Integer> zeros) {
		ArrayList<Integer> available = complement(
				combineArrayList(Arrays.asList(getNeighbours(num, player), previousVerify.get(num))));

		if (available.size() == 0) {
			if (num == zeros.get(0)) {
				return true;
			} else {
				player.set(num, 0);
				previousVerify.get(num).clear();

				return solve(zeros.get(zeros.indexOf(num) - 1), zeros);
			}
		} else {
			player.set(num, available.get(0));
			previousVerify.get(num).add(player.get(num));

			if (num == zeros.get(zeros.size() - 1)) {
				if (available.size() == 1 && player.equals(board)) {
					return solve(num, zeros);
				} else {
					return false;
				}
			} else {
				return solve(zeros.get(zeros.indexOf(num) + 1), zeros);
			}
		}
	}
	
	//------------------------------------------------------------------------------------#
	//Returns an ArrayList containing the every number in the specified block in the board#
	//@param num the block number
	//------------------------------------------------------------------------------------#
	
	private ArrayList<Integer> getBlock(int num, ArrayList<Integer> list) {
		ArrayList<Integer> temp = new ArrayList<Integer>();

		int t = num % 3 * 3 + (num / 3) * 27;

		for (int i = t; i < t + 20; i += 9) {
			temp.addAll(list.subList(i, i + 3));
		}

		return removeZeros(temp);
	}
	
	//--------------------------------------------------------------------------------------------#
	//Returns an ArrayList containing the every number in the specified vertical line in the board#
	//(the most left one is 0 and the most right one is 8)
	//@param num  the vertical line number
	//--------------------------------------------------------------------------------------------#
	
	private ArrayList<Integer> getVerticalLine(int num, ArrayList<Integer> list) {
		ArrayList<Integer> temp = new ArrayList<Integer>();

		for (int i = num; i < num + 81; i += 9) {
			temp.add(list.get(i));
		}

		return removeZeros(temp);
	}
	
	//---------------------------------------------------------------------------#
	//Returns an ArrayList containing the every number in the specified horizontal
	//line in the board (the top one is 0 and the bottom is 8)
	//@param num  the horizontal line number
	//---------------------------------------------------------------------------#
	
	private ArrayList<Integer> getHorizontalLine(int num, ArrayList<Integer> list) {
		return removeZeros(new ArrayList<Integer>(list.subList(num * 9, num * 9 + 9)));
	}
	
	//------------------------------------------------------------#
	//Checks if the block if full and valid (no duplicate numbers)#
	//@param num the block number
	//------------------------------------------------------------#
	
	private boolean checkBlock(int num, ArrayList<Integer> list) {
		return 9 == removeDuplicates(getBlock(num, list)).size();
	}
	
	//--------------------------------------------------------------------#
	//Checks if the vertical line if full and valid (no duplicate numbers)#
	//@param num the vertical line number
	//--------------------------------------------------------------------#
	
	private boolean checkVerticalLine(int num, ArrayList<Integer> list) {
		return 9 == removeDuplicates(getVerticalLine(num, list)).size();
	}
	
	//----------------------------------------------------------------------#
	//Checks if the horizontal line if full and valid (no duplicate numbers)#
	//@param num the horizontal line number
	//----------------------------------------------------------------------#
	
	private boolean checkHorizontalLine(int num, ArrayList<Integer> list) {
		return 9 == removeDuplicates(getHorizontalLine(num, list)).size();
	}
	
	//---------------------------------------------------#
	//Checks if the board is full, does not have any zero#
	//@return true if the board is full, false otherwise
	//---------------------------------------------------#
	
	private boolean fullBoard() {
		return !board.contains(0);
	}
	
	//------------------------------------------------#
	//Checks if the board conforms to the Sudoku rules#
	//@return true if the board is valid, false otherwise
	//------------------------------------------------#
	
	public boolean checkBoard(ArrayList<Integer> list) {
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				if (!(checkVerticalLine(col, list) || checkHorizontalLine(row, list)
						|| checkBlock(row / 3 * 3 + col / 3, list))) {
					return false;
				}
			}
		}

		return true;
	}
	
	//--------------------------------------------------------------------------------#
	//Returns an ArrayList containing every location of the value inside the ArrayList#
	//@param num   an ArrayList representing the Sudoku board
	//@return an ArrayList containing the index of the elements equal to value
	//--------------------------------------------------------------------------------#
	 
	private ArrayList<Integer> getIndexes(ArrayList<Integer> num, Integer value) {
		ArrayList<Integer> temp = new ArrayList<Integer>();

		for (int i = 0; i < num.size(); i++) {
			if (value.equals(num.get(i))) {
				temp.add(i);
			}
		}

		return temp;
	}
	
	//---------------------------------------------------------------------------------------------#
	//Returns an ArrayList with the elements (from 1 to 9) that are not part of parameter ArrayList#
	//@param num an ArrayList containing elements from 1 to 9 inclusively
	//@return an ArrayList with those numbers
	//---------------------------------------------------------------------------------------------#
	
	private ArrayList<Integer> complement(ArrayList<Integer> num) {
		ArrayList<Integer> temp = new ArrayList<Integer>();

		for (int i = 1; i < 10; i++) {
			if (!num.contains(i)) {
				temp.add(i);
			}
		}

		return temp;
	}
	
	//----------------------------------------------------------------------------------------#
	//Gets an ArrayList of the neighbours of the specified location (num) inside the ArrayList#
	//@param num  the location of the element
	//@return an ArrayList with the neighbours of the location (without any duplicates)
	//----------------------------------------------------------------------------------------#
	
	private ArrayList<Integer> getNeighbours(int num, ArrayList<Integer> list) {
		return removeZeros(removeDuplicates(combineArrayList(Arrays.asList(getVerticalLine(num % 9, list),
				getHorizontalLine(num / 9, list), getBlock((num / 9) / 3 * 3 + (num % 9) / 3, list)))));
	}
	
	//----------------------------------------------------------#
	//Combines every ArrayList in the List to a single ArrayList#
	//----------------------------------------------------------#
	
	private ArrayList<Integer> combineArrayList(List<ArrayList<Integer>> list) {
		ArrayList<Integer> temp = new ArrayList<Integer>();

		for (ArrayList<Integer> i : list) {
			temp.addAll(i);
		}

		return temp;
	}
	
	//-----------------------------------------#
	//Removes every zeros in the ArrayList-----#
	//@param num an ArrayList containing zeros
	//@return an ArrayList without any zeros
	//-----------------------------------------#
	
	private ArrayList<Integer> removeZeros(ArrayList<Integer> num) {
		num.removeAll(Collections.singleton(0));
		return num;
	}
	
	//------------------------------------------------#
	//Removes the duplicate elements from an ArrayList#
	//@param num an ArrayList containing duplicates elements
	//@return an ArrayList without duplicates elements
	//------------------------------------------------#
	
	private ArrayList<Integer> removeDuplicates(ArrayList<Integer> num) {
		return new ArrayList<Integer>(new HashSet<Integer>(num));
	}
	
	//--------------------------------------------------#
	//Creates a Sudoku board with the provided ArrayList#
	//@param num ArrayList representing a Sudoku board
	//@return String representation of the Sudoku board
	//--------------------------------------------------#
	
	public String printBoard(ArrayList<Integer> num) {
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < 81; i++) {

			/*if (i != 0 && i % 27 == 0) {
				sb.append("\n  ");
				for (int j = 0; j < 13; j++) {
					sb.append("_ ");
				}
				
				sb.append("\n");
			}*/
			

			/*if (i % 9 == 0) {
				sb.append("\n");
				sb.append(" ");
			}*/
			

			/*if (i % 3 == 0 && i % 9 != 0) {
				sb.append(" ");
			}*/
			

			if (num.get(i) != 0) {
				//sb.append(" ");
			//} else {
				sb.append(num.get(i));
			}
			//sb.append(" ");
			
		}

		return sb.toString();
	}
	public String toString() {
		return printBoard(board);
	}
	
	
	public static void main(String[] args) {
		sudoktry sudoku = new sudoktry();
		sudoku.generateBoard();
		sudoku.generatePlayer();
		System.out.println(sudoku.toString());
	}
}

