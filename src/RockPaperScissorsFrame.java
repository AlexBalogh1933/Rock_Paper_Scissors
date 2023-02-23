import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RockPaperScissorsFrame extends JFrame
{
    private JPanel mainPanel, topPanel, selectPanel, scorePanel, quitScorePanel;
    private JLabel title;
    private ImageIcon rockIcon, paperIcon, scissorIcon;
    private JButton rockButton, paperButton, scissorButton;
    private JButton quitButton;
    private JLabel playerWinsLabel, computerWinsLabel, tiesLabel;
    private JTextField playerWinsTA, computerWinsTA, tiesTA;
    private JTextArea gameResults;
    private JScrollPane scroll;
    private ActionListener quit = new QuitListener();
    private ActionListener rockSelection = new RockListener();
    private ActionListener paperSelection = new PaperListener();
    private ActionListener scissorsSelection = new ScissorsListener();
    public int playerWinsNum, computerWinsNum, tiesNum;

    public RockPaperScissorsFrame()
    {
        setTitle("Rock Paper Scissors Game");
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        topPanel = new JPanel();
        selectPanel = new JPanel();
        quitScorePanel = new JPanel();

        title = new JLabel("Welcome to Rock Paper Scissors");
        rockIcon = new ImageIcon("src/rock.png");
        paperIcon = new ImageIcon("src/paper.png");
        scissorIcon = new ImageIcon("src/scissors.png");

        Image rockImage = rockIcon.getImage();
        Image rocknewIMG = rockImage.getScaledInstance(75,75, Image.SCALE_SMOOTH);
        rockIcon = new ImageIcon((rocknewIMG));

        Image paperImage = paperIcon.getImage();
        Image papernewIMG = paperImage.getScaledInstance(75,75, Image.SCALE_SMOOTH);
        paperIcon = new ImageIcon((papernewIMG));

        Image scissorImage = scissorIcon.getImage();
        Image scissornewIMG = scissorImage.getScaledInstance(75,75, Image.SCALE_SMOOTH);
        scissorIcon = new ImageIcon((scissornewIMG));

        rockButton = new JButton("Rock", rockIcon);
        rockButton.addActionListener(rockSelection);
        paperButton = new JButton("Paper", paperIcon);
        paperButton.addActionListener(paperSelection);
        scissorButton = new JButton("Scissors", scissorIcon);
        scissorButton.addActionListener(scissorsSelection);

        playerWinsTA = new JTextField("Player Wins: "+ playerWinsNum);
        playerWinsTA.setEditable(false);
        computerWinsTA = new JTextField("Computer Wins: " + computerWinsNum);
        computerWinsTA.setEditable(false);
        tiesTA = new JTextField("Ties: " + tiesNum);
        tiesTA.setEditable(false);

        gameResults = new JTextArea(6,30);
        scroll = new JScrollPane(gameResults);

        quitButton = new JButton("Quit");
        quitButton.addActionListener(quit);

        add(mainPanel);
        mainPanel.setLayout(new BorderLayout(0,75));
        mainPanel.add(topPanel, BorderLayout.NORTH);
        topPanel.setLayout(new GridLayout(1,2));
        mainPanel.add(selectPanel, BorderLayout.CENTER);
        selectPanel.setLayout(new GridLayout(2,3,100,50));
        mainPanel.add(quitScorePanel, BorderLayout.SOUTH);
        quitScorePanel.setLayout(new GridLayout(2,1));

        // Top
        topPanel.add(title);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Times New Roman", Font.PLAIN, 40));

        // Select
        selectPanel.add(rockButton);
        rockButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        rockButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,4));
        selectPanel.add(paperButton);
        paperButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        paperButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,4));
        selectPanel.add(scissorButton);
        scissorButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        scissorButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,4));
        selectPanel.add(playerWinsTA);
        playerWinsTA.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        selectPanel.add(computerWinsTA);
        computerWinsTA.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        selectPanel.add(tiesTA);
        tiesTA.setFont(new Font("Times New Roman", Font.PLAIN, 25));

        // Bottom/Quit
        quitScorePanel.add(scroll);
        gameResults.setFont(new Font("Times New Roman", Font.BOLD, 25));
        quitScorePanel.add(quitButton);
        quitButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
    }

    private class QuitListener implements ActionListener
    {
        public void actionPerformed(ActionEvent AE)
        {
            System.exit(0);
        }
    }

    private class RockListener implements ActionListener
    {
        public void actionPerformed(ActionEvent AE)
        {
            gameResults.append("Picked Rock" + "\n");
        }
    }
    private class PaperListener implements ActionListener
    {
        public void actionPerformed(ActionEvent AE)
        {
            gameResults.append("Picked Paper" + "\n");
        }
    }
    private class ScissorsListener implements ActionListener
    {
        public void actionPerformed(ActionEvent AE)
        {
            gameResults.append("Picked Scissors" + "\n");
        }
    }
}
