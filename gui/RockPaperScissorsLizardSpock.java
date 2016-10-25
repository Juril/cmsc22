import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Dialog;
import java.util.*;

public class RockPaperScissorsLizardSpock extends Frame{
    private Label lblChoice, pScore, aScore, dLabel;
    private TextField playerScore, aiScore;
    private TextArea txtArea;
    private Button button, ok;
    private String computerChoice, string, winner;
    private int pChoice, choice, playerscore = 0, compscore = 0;
    private CheckboxGroup choiceGroup;
    private Dialog dialog;
    private static Random rand = new Random();

    public RockPaperScissorsLizardSpock(){
        setLayout(new FlowLayout());
        this.rand = new Random();
        dialog = new Dialog(this, "GAME OVER", true);
        txtArea = new TextArea("Result:", 10, 20);
        lblChoice = new Label("Your Choice: ");
        pScore = new Label("Player's Score");
        aScore = new Label("Computer's Score");
        playerScore = new TextField("",2);
        aiScore = new TextField("",2);
        playerScore.setEditable(false);
        aiScore.setEditable(false);
        dLabel = new Label(null);
        button = new Button("RockPaperScissorsLizardSpock!");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Checkbox tmp = choiceGroup.getSelectedCheckbox();
                string = tmp.getLabel();
                if(string.equals("ROCK")){
                    pChoice = 1;
                }
                else if(string.equals("PAPER")){
                    pChoice = 2;
                }
                else if(string.equals("SCISSORS")){
                    pChoice = 3;
                }
                else if(string.equals("LIZARD")){
                    pChoice = 4;
                }
                else if(string.equals("SPOCK")){
                    pChoice = 5;
                }

                choice = randInt(1,5);
                if(choice == 1){
                    computerChoice = "ROCK";
                }
                else
                if(choice == 2){
                    computerChoice = "PAPER";
                }
                else
                if(choice == 3){
                    computerChoice = "SCISSORS";
                }
                else
                if(choice == 4){
                    computerChoice = "LIZARD";
                }
                else
                if(choice == 5){
                    computerChoice = "SPOCK";
                }
                txtArea.append("\nPlayer chose " + string);
                txtArea.append("\nComputer chose " + computerChoice + "\n");

                if(pChoice == 1){
                    if(choice == 3 || choice == 4){
                        playerscore++;
                    }
                    else if(choice != pChoice){
                        compscore++;
                    }
                }
                else if(pChoice == 2){
                    if(choice == 1 || choice == 5){
                        playerscore++;
                    }
                    else if(choice != pChoice){
                        compscore++;
                    }
                }
                else if(pChoice == 3){
                    if(choice == 2 || choice == 4){
                        playerscore++;
                    }
                    else if(choice != pChoice){
                        compscore++;
                    }
                }
                else if(pChoice == 4){
                    if(choice == 2 || choice == 5){
                        playerscore++;
                    }
                    else if(choice != pChoice){
                        compscore++;
                    }
                }
                else if(pChoice == 5){
                    if(choice == 1 || choice == 3){
                        playerscore++;
                    }
                    else if(choice != pChoice){
                        compscore++;
                    }
                }
                playerScore.setText(String.valueOf(playerscore));
                aiScore.setText(String.valueOf(compscore));


                if(playerscore == 5){
                    txtArea.append("\nYOU WIN!");
                    winner = "You";
                    winner(winner);

                }
                else if(compscore == 5){
                    txtArea.append("\nYOU LOSE!");
                    winner = "Computer";
                    winner(winner);
                }
            }
        });
        ok = new Button("OK");
        ok.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                playerScore.setText(null);
                aiScore.setText(null);
                txtArea.setText(null);
                playerscore = 0;
                compscore = 0;
                dialog.setVisible(false);
            }
        });
        dialog.add(dLabel);
        dialog.add(ok);
        dialog.setSize(140, 80);
        dialog.setLayout(new FlowLayout());

        choiceGroup = new CheckboxGroup();
        Checkbox chkRock = new Checkbox("ROCK",choiceGroup,true);
        Checkbox chkPaper = new Checkbox("PAPER",choiceGroup,false);
        Checkbox chkScissors = new Checkbox("SCISSORS",choiceGroup,false);
        Checkbox chkLizard = new Checkbox("LIZARD",choiceGroup,false);
        Checkbox chkSpock = new Checkbox("SPOCK",choiceGroup,false);

        //adding everything to the mainframe
        add(lblChoice);
        add(chkRock);
        add(chkPaper);
        add(chkScissors);
        add(chkLizard);
        add(chkSpock);
        add(txtArea);
        add(button);
        add(pScore);
        add(playerScore);
        add(aScore);
        add(aiScore);

        setTitle("RockPaperScissorsLizardSpock");
        setSize(250, 400);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void winner(String winner){
        dLabel.setText(String.format("Game Over! %s won.",winner));
        dialog.setVisible(true);
        dialog.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public static int randInt(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }

    public static void main(String[] args){
        new RockPaperScissorsLizardSpock();
    }
}
