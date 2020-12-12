package sudoku;
import java.awt.Color;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.fxml.Initializable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class Controller implements Initializable {

    @FXML Button button_one;
    @FXML Button button_two;
    @FXML Button button_three;
    @FXML Button button_four;
    @FXML Button button_five;
    @FXML Button button_six;
    @FXML Button button_seven;
    @FXML Button button_eight;
    @FXML Button button_nine;
    @FXML Button btnStart;
    @FXML Button btnStop;
    @FXML Button btnExit;
    @FXML Canvas canvas;
    @FXML Label labelTimer;
    @FXML RadioButton radioEasy;
    @FXML RadioButton radioMedium;
    @FXML RadioButton radioHard;


    GameBoard gameboard;
    int player_selected_row;
    int player_selected_col;
    private int            seconds;
    int oldr;
    int oldc;
    int level=0;
    private long lastTime = 0;
    AnimationTimer timer;
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        player_selected_col=0;
        player_selected_row=0;
        btnStop.setDisable(true);

        GraphicsContext context = canvas.getGraphicsContext2D();

        timer= new AnimationTimer() {

            @Override
            public void handle(long now) {
                if (lastTime != 0) {
                    if (now > lastTime + 1_000_000_000) {
                        seconds++;
                        labelTimer.setText(Integer.toString(seconds) + " .s");
                        lastTime = now;
                    }
                } else {
                    lastTime = now;

                }
            }
        };
        ToggleGroup tg= new ToggleGroup();
        radioEasy.setToggleGroup(tg);
        radioMedium.setToggleGroup(tg);
        radioHard.setToggleGroup(tg);
        canvas.setDisable(true);
    }

    public void canvasMouseClicked() {

        canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                int mouse_x = (int) event.getX();
                int mouse_y = (int) event.getY();


                player_selected_row = (int) (mouse_y / 30);
                player_selected_col = (int) (mouse_x / 30);

                drawOnCanvas(canvas.getGraphicsContext2D());
            }
        });
    }

    boolean clicked = false;
    public void buttonStartPressed() {

        if(radioEasy.isSelected()){
            btnStop.setDisable(false);
            gameboard = new GameBoard();
            canvas.setDisable(false);
            GraphicsContext context = canvas.getGraphicsContext2D();
            level=1;
            drawOnCanvas(context);

            this.seconds = -1;
            timer.start();
            this.clicked = true;
            disableStartComp(true);
            disableGameMenu(false);
            btnStop.setDisable(false);
        }
        if(radioMedium.isSelected()){
            btnStop.setDisable(false);
            gameboard = new GameBoard();
            canvas.setDisable(false);
            GraphicsContext context = canvas.getGraphicsContext2D();
            level=2;
            drawOnCanvas(context);
            this.seconds = -1;
            timer.start();
            this.clicked = true;
            disableStartComp(true);
            disableGameMenu(false);
            btnStop.setDisable(false);
        }
        if(radioHard.isSelected()){
            btnStop.setDisable(false);
            gameboard = new GameBoard();
            canvas.setDisable(false);
            GraphicsContext context = canvas.getGraphicsContext2D();
            level=3;
            drawOnCanvas(context);
            this.seconds = -1;
            timer.start();
            this.clicked = true;
            disableStartComp(true);
            disableGameMenu(false);
            btnStop.setDisable(false);
        }

    }
    public void buttonStopPressed() {
        timer.stop();
        if(btnStop.getText().equals("RESUME")){
            btnStop.setText("STOP");
            canvas.setVisible(true);
            canvas.setDisable(false);
            disableGameMenu(false);
            timer.start();
        }
        else if(btnStop.getText().equals("STOP")){
            btnStop.setText("RESUME");
            canvas.setVisible(false);
            canvas.setDisable(true);
            disableGameMenu(true);
            timer.stop();
        }

    }

    public void modify(char a){
        switch (level) {
            case 1:
                gameboard.modifyPlayer(a, player_selected_row, player_selected_col);
                break;
            case 2:
                gameboard.modifyPlayerM(a, player_selected_row, player_selected_col);
                break;
            case 3:
                gameboard.modifyPlayerH(a, player_selected_row, player_selected_col);
                break;
            default:
                break;
        }
    }

    public void buttonZeroPressed() {

        if(this.clicked){
            modify('0');


            drawOnCanvas(canvas.getGraphicsContext2D());
        }

    }
    public void buttonExitPressed() {

        if(this.clicked){
            modify('0');

            drawOnCanvas(canvas.getGraphicsContext2D());
        }

    }


    public void buttonOnePressed() {

        if(this.clicked){
            modify('1');
            drawOnCanvas(canvas.getGraphicsContext2D());
        }

    }
    public void buttonTwoPressed() {
        if(this.clicked){
            modify('2');
            drawOnCanvas(canvas.getGraphicsContext2D());
        }

    }

    public void buttonThreePressed() {
        if(this.clicked){
            modify('3');
            drawOnCanvas(canvas.getGraphicsContext2D());
        }

    }

    public void buttonFourPressed() {
        if(this.clicked){
            modify('4');
            drawOnCanvas(canvas.getGraphicsContext2D());
        }
    }

    public void buttonFivePressed() {
        if(this.clicked){
            modify('5');
            drawOnCanvas(canvas.getGraphicsContext2D());
        }
    }

    public void buttonSixPressed() {
        if(this.clicked){
            modify('6');
            drawOnCanvas(canvas.getGraphicsContext2D());
        }
    }

    public void buttonSevenPressed() {
        if(this.clicked){
            modify('7');
            drawOnCanvas(canvas.getGraphicsContext2D());
        }
    }

    public void buttonEightPressed() {
        if(this.clicked){
            modify('8');
            drawOnCanvas(canvas.getGraphicsContext2D());
        }
    }

    public void buttonNinePressed() {
        if(this.clicked){
            modify('9');
            drawOnCanvas(canvas.getGraphicsContext2D());
        }
    }

    public void check(GraphicsContext context){
        switch (level) {
            case 1:
                if(gameboard.checkForSuccess() == true) {

                    context.setFill(javafx.scene.paint.Color.GREEN);
                    context.setFont(new Font(20));
                    context.fillText("SUCCESS! YOUR TIME IS "+seconds+" SEC", 0, 315);
                    disableStartComp(false);
                    disableGameMenu(true);
                    btnStop.setDisable(true);
                    canvas.setDisable(true);
                    timer.stop();

                }
                break;
            case 2:
                if(gameboard.checkForSuccessM()== true) {

                    context.setFill(javafx.scene.paint.Color.GREEN);

                    context.setFont(new Font(32));

                    context.fillText("SUCCESS! YOUR TIME IS "+seconds+"SEC", 0, 250);
                    disableStartComp(false);
                    disableGameMenu(true);
                    btnStop.setDisable(true);
                    canvas.setDisable(true);
                    timer.stop();

                }
                break;
            case 3:
                if(gameboard.checkForSuccessH() == true) {

                    context.setFill(javafx.scene.paint.Color.GREEN);
                    context.setFont(new Font(32));

                    context.fillText("SUCCESS! YOUR TIME IS "+seconds+"SEC", 0, 250);

                    disableStartComp(false);
                    disableGameMenu(true);
                    btnStop.setDisable(true);
                    canvas.setDisable(true);
                    timer.stop();

                }
                break;
            default:
                break;
        }
    }

    private void disableGameMenu(boolean check){
        if(check){
            button_one.setDisable(true);
            button_two.setDisable(true);
            button_three.setDisable(true);
            button_four.setDisable(true);
            button_five.setDisable(true);
            button_six.setDisable(true);
            button_seven.setDisable(true);
            button_eight.setDisable(true);
            button_nine.setDisable(true);
        }
        else{
            button_one.setDisable(false);
            button_two.setDisable(false);
            button_three.setDisable(false);
            button_four.setDisable(false);
            button_five.setDisable(false);
            button_six.setDisable(false);
            button_seven.setDisable(false);
            button_eight.setDisable(false);
            button_nine.setDisable(false);
        }

    }
    private void disableStartComp(boolean check){
        if(check){
            btnStart.setDisable(true);
            radioEasy.setDisable(true);
            radioMedium.setDisable(true);
            radioHard.setDisable(true);
        }
        else{
            btnStart.setDisable(false);
            radioEasy.setDisable(false);
            radioMedium.setDisable(false);
            radioHard.setDisable(false);
        }
    }

    private void drawOnCanvas(GraphicsContext context) {

        context.clearRect(0, 0, 480, 480);
        for(int row = 0; row<9; row++) {
            for(int col = 0; col<9; col++) {

                int position_y = row * 30 + 2;

                int position_x = col * 30 + 2;
                context.setFill(javafx.scene.paint.Color.WHITE);
                if(row <3 || row >5 && row<9){
                    if(col<3 || col>5 && col<9){
                        context.setFill(javafx.scene.paint.Color.LIGHTGREY);
                    }
                }
                else if(row >2 || row >8 ){
                    if(col>2 && col<6 || col>8 ){
                        context.setFill(javafx.scene.paint.Color.LIGHTGREY);
                    }
                }

                int width = 26;

                context.fillRoundRect(position_x, position_y, width, width, 10, 10);
            }
        }


        check(context);
        context.setStroke(javafx.scene.paint.Color.BLUE);
        context.setLineWidth(2);

        context.strokeRoundRect(player_selected_col * 30 + 2, player_selected_row * 30 + 2, 26, 26, 10, 10);
        char[][] initial = gameboard.getInitialM();

        switch (level) {
            case 1:
                initial = gameboard.getInitial();
                break;
            case 2:
                initial = gameboard.getInitialM();
                break;
            case 3:
                initial = gameboard.getInitialH();
                break;
            default:
                break;
        }

        for(int row = 0; row<9; row++) {
            for(int col = 0; col<9; col++) {

                int position_y = row * 30 + 20;

                int position_x = col * 30 +10;

                context.setFill(javafx.scene.paint.Color.BLACK);

                context.setFont(new Font(20));

                if(initial[row][col]!='-') {

                    context.fillText(initial[row][col] + "", position_x, position_y);
                }
            }
        }

        char[][] player = gameboard.getPlayer();

        for(int row = 0; row<9; row++) {
            for(int col = 0; col<9; col++) {

                int position_y = row * 30 + 20;

                int position_x = col * 30 +10;

                context.setFill(javafx.scene.paint.Color.BLUE);

                context.setFont(new Font(20));

                if(player[row][col]!='-') {
                    for(int r = 0; r<9; r++) {
                        if(player[row][col]==initial[r][col]){
                            context.setFill(javafx.scene.paint.Color.RED);
                            context.setStroke(javafx.scene.paint.Color.RED);
                            context.setLineWidth(1);
                            context.strokeRoundRect(col * 30 + 2, r * 30 + 2, 26, 26, 10, 10);
                            break;
                        }
                    }
                    for(int c = 0; c<9; c++) {
                        if(player[row][col]==initial[row][c]){
                            context.setFill(javafx.scene.paint.Color.RED);
                            context.setStroke(javafx.scene.paint.Color.RED);

                            context.setLineWidth(1);

                            context.strokeRoundRect(c * 30 + 2, row * 30 + 2, 26, 26, 10, 10);
                            break;
                        }

                    }

                    context.fillText(player[row][col] + "", position_x, position_y);
                }
            }
        }
    }
}
