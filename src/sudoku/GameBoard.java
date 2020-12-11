
package sudoku;

public class GameBoard {

    private char[][] solution;
    private char[][] solutionM;
    private char[][] solutionH;
    private char[][] initial;
    private char[][] initialM;
    private char[][] initialH;
    private char[][] player;

    private int level;

    public GameBoard() {
        solution = new char[][]
                {
                        {'8','7','9','4','3','5','2','1','6'},
                        {'3','6','2','9','7','1','5','4','8'},
                        {'5','1','4','8','2','6','7','3','9'},
                        {'9','5','6','7','4','8','1','2','3'},
                        {'1','4','7','3','6','2','8','9','5'},
                        {'2','3','8','5','1','9','4','6','7'},
                        {'7','8','1','6','9','4','3','5','2'},
                        {'6','2','5','1','8','3','9','7','4'},
                        {'4','9','3','2','5','7','6','8','1'}
                };


        solutionM = new char[][]
                {
                        {'8','7','9','4','3','5','2','1','6'},
                        {'3','6','2','9','7','1','5','4','8'},
                        {'5','1','4','8','2','6','7','3','9'},
                        {'9','5','6','7','4','8','1','2','3'},
                        {'1','4','7','3','6','2','8','9','5'},
                        {'2','3','8','5','1','9','4','6','7'},
                        {'7','8','1','6','9','4','3','5','2'},
                        {'6','2','5','1','8','3','9','7','4'},
                        {'4','9','3','2','5','7','6','8','1'}
                };

        solutionH = new char[][]
                {
                        {'8','7','9','4','3','5','2','1','6'},
                        {'3','6','2','9','7','1','5','4','8'},
                        {'5','1','4','8','2','6','7','3','9'},
                        {'9','5','6','7','4','8','1','2','3'},
                        {'1','4','7','3','6','2','8','9','5'},
                        {'2','3','8','5','1','9','4','6','7'},
                        {'7','8','1','6','9','4','3','5','2'},
                        {'6','2','5','1','8','3','9','7','4'},
                        {'4','9','3','2','5','7','6','8','1'}
                };

        initial = new char[][]
                {
                        {'8','-','-','-','-','5','2','-','-'},
                        {'-','6','-','9','-','1','5','4','8'},
                        {'5','-','-','8','-','6','-','3','-'},
                        {'-','-','6','7','-','8','1','2','3'},
                        {'1','4','-','-','-','-','8','-','-'},
                        {'-','-','-','5','1','-','4','6','-'},
                        {'7','-','-','6','-','-','3','5','2'},
                        {'6','2','5','-','-','-','-','7','-'},
                        {'4','-','3','-','5','7','6','-','-'}

                };
        initialM = new char[][]
                {
                        {'8','-','-','-','-','5','2','-','-'},
                        {'-','6','-','9','-','1','5','4','8'},
                        {'5','-','-','8','-','6','-','3','-'},
                        {'-','-','6','7','-','8','1','2','3'},
                        {'1','4','-','-','-','-','8','-','-'},
                        {'-','-','-','5','1','-','4','6','-'},
                        {'7','-','-','6','-','-','3','5','2'},
                        {'6','2','5','-','-','-','-','7','-'},
                        {'4','-','3','-','5','7','6','-','-'}
                };

        initialH = new char[][]
                {
                        {'8','-','-','-','-','5','2','-','-'},
                        {'-','6','-','9','-','1','5','4','8'},
                        {'5','-','-','8','-','6','-','3','-'},
                        {'-','-','6','7','-','8','1','2','3'},
                        {'1','4','-','-','-','-','8','-','-'},
                        {'-','-','-','5','1','-','4','6','-'},
                        {'7','-','-','6','-','-','3','5','2'},
                        {'6','2','5','-','-','-','-','7','-'},
                        {'4','-','3','-','5','7','6','-','-'}
                };

        player = new char[9][9];
    }

    public char[][] getSolution() {
        return solution;
    }

    public char[][] getSolutionM() {
        return solutionM;
    }

    public char[][] getSolutionH() {
        return solutionH;
    }

    public char[][] getInitial() {
        return initial;
    }

    public char[][] getInitialM() {
        return initialM;
    }

    public char[][] getInitialH() {
        return initialH;
    }

    public char[][] getPlayer() {
        return player;
    }

    public int getLevel(){
        return level;
    }

    public void setLevel(int level){
        this.level=level;
    }

    public void modifyPlayer(char val, int row, int col) {

        if (initial[row][col] == '-') {

            player[row][col] = val;
        }

    }
    public void modifyPlayerM(char val, int row, int col) {
        if (initialM[row][col] == '-') {
            player[row][col] = val;
        }

    }
    public void modifyPlayerH(char val, int row, int col) {
        if (initialH[row][col] == '-') {
            player[row][col] = val;
        }

    }
    public boolean checkForSuccess() {
        for(int row = 0; row<9; row++) {
            for(int col = 0; col<9; col++) {

                if(initial[row][col] == '-') {
                    if(player[row][col] != solution[row][col]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
    public boolean checkForSuccessM() {
        if(player[0][0]==solutionM[0][0])
            return true;

        return false;
    }
    public boolean checkForSuccessH() {
        for(int row = 0; row<9; row++) {
            for(int col = 0; col<9; col++) {
                if(initialH[row][col] == '-') {
                    if(player[row][col] != solutionH[row][col]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}