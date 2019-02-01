package com.spaceship.util;

import org.apache.log4j.Logger;

import com.spaceship.exceptions.SpaceshipBoardException;
import com.spaceship.model.board.Spaceship;
import com.spaceship.model.board.SpaceshipBoard;

public class SpaceshipBoardUtil {

    private static final Logger LOGGER = Logger.getLogger(SpaceshipBoardUtil.class);

    private SpaceshipBoardUtil() {
    }

    /**
     * Check numbers of neighbours are marked
     */
    public static int checkQuadrant(int i, int j, int[][] board) throws SpaceshipBoardException {
        Integer count = 0;

        // if the cell mark is within limit
        if (i >= 0 && i < SpaceshipBoard.BOARD_COL && j >= 0 && j < SpaceshipBoard.BOARD_ROW) {
            count += isLeftColumnExists(i, j, board, count);

            count += isRightColumnExists(i, j, board, count);

            count += isBottomRowExisits(i, j, board, count);

            count += isTopRowExists(i, j, board, count);

        } else {
            count = -1;
            LOGGER.info("This cell is out of boundary.");
        }
        return count;
    }

    /**
     * Check numbers of neighbours are marked
     */
    public static int checkQuadrant(int i, int j, int[][] board, Spaceship spaceship) throws SpaceshipBoardException {
        Integer count = 0;

        // if the cell mark is within limit
        if (i >= 0 && i < SpaceshipBoard.BOARD_COL && j >= 0 && j < SpaceshipBoard.BOARD_ROW) {

            Integer rawCheck = i + spaceship.getRows();
            Integer colCheck = j + spaceship.getCols();

            if (rawCheck >= 0 && rawCheck < SpaceshipBoard.BOARD_COL && colCheck >= 0 && colCheck < SpaceshipBoard.BOARD_ROW) {
                count = handleAreaCondition(i, j, board, spaceship, count);
            } else {
                count = -1;
                LOGGER.info("This cell is out of boundary.");
            }

        } else {
            count = -1;
            LOGGER.info("This cell is out of boundary.");
        }
        return count;
    }

    private static Integer handleAreaCondition(int i, int j, int[][] board, Spaceship spaceship, Integer count) {
        Integer newCount = count;
        for (int rawCount = i; rawCount < i + spaceship.getRows(); rawCount++) {
            for (int colCount = j; colCount < j + spaceship.getCols(); colCount++) {
                if(board[rawCount][colCount] != 0) {
                    newCount += 1;
                }
            }
        }
        return newCount;
    }

    /**
     * Check if there is exist a top row
     */
    private static int isTopRowExists(int i, int j, int[][] board, int count) {
        int newCount = 0;
        if (i - 1 >= 0) {
            // check i-1, j
            if (board[i - 1][j] != 0) {
                newCount = count + 1;
            }

            // check if diagonal cell exist
            if (j - 1 >= 0 && board[i - 1][j - 1] != 0) {
                newCount = count + 1;
            }

            if (j + 1 < SpaceshipBoard.BOARD_COL && board[i - 1][j + 1] != 0) {
                newCount = count + 1;
            }
        }
        return newCount;
    }

    /**
     * Check if there exist a bottom row
     */
    private static int isBottomRowExisits(int i, int j, int[][] board, int count) {
        int newCount = 0;
        if (i + 1 < SpaceshipBoard.BOARD_ROW) {
            // check i+1, j
            if (board[i + 1][j] != 0) {
                newCount = count + 1;
            }

            // check if diagonal cell exist
            if (j - 1 >= 0 && board[i + 1][j - 1] != 0) {
                newCount = count + 1;
            }

            // check i+1, j+1
            if (j + 1 < SpaceshipBoard.BOARD_COL && board[i + 1][j + 1] != 0) {
                newCount = count + 1;
            }
        }
        return newCount;
    }

    /**
     * Check if right column exist
     */
    private static int isRightColumnExists(int i, int j, int[][] board, int count) {
        if (j + 1 < SpaceshipBoard.BOARD_COL && board[i][j + 1] != 0) {
            return count + 1;
        }
        return count;
    }

    /**
     * Check if left column exist
     */
    private static int isLeftColumnExists(int i, int j, int[][] board, int count) {
        if (j - 1 >= 0 && board[i][j - 1] != 0) {
            return count + 1;
        }
        return count;
    }

}
