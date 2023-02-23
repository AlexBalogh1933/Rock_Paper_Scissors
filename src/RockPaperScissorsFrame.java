import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RockPaperScissorsFrame extends JFrame
{
    private JPanel mainPanel, topPanel, selectPanel, quitPanel;
    private JLabel title;
    private ImageIcon rockIcon, paperIcon, scissorIcon;
    private JButton rockButton, paperButton, scissorButton;
    private JButton quitButton;
    private ActionListener quit = new QuitListener();
    private ActionListener rockSelection = new RockListener();
    private ActionListener paperSelection = new PaperListener();
    private ActionListener scissorsSelection = new ScissorsListener();

    public RockPaperScissorsFrame()
    {
        setTitle("Rock Paper Scissors Game");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        topPanel = new JPanel();
        selectPanel = new JPanel();
        quitPanel = new JPanel();

        title = new JLabel("Welcome to Rock Paper Scissors");
        rockIcon = new ImageIcon("src/rock.png");
        paperIcon = new ImageIcon("src/paper.png");
        scissorIcon = new ImageIcon("src/scissors.png");

        Image rockImage = rockIcon.getImage();
        Image rocknewIMG = rockImage.getScaledInstance(100,100, Image.SCALE_SMOOTH);
        rockIcon = new ImageIcon((rocknewIMG));

        Image paperImage = paperIcon.getImage();
        Image papernewIMG = paperImage.getScaledInstance(100,100, Image.SCALE_SMOOTH);
        paperIcon = new ImageIcon((papernewIMG));

        Image scissorImage = scissorIcon.getImage();
        Image scissornewIMG = scissorImage.getScaledInstance(100,100, Image.SCALE_SMOOTH);
        scissorIcon = new ImageIcon((scissornewIMG));

        rockButton = new JButton("Rock", rockIcon);
        rockButton.addActionListener(rockSelection);
        paperButton = new JButton("Paper", paperIcon);
        paperButton.addActionListener(paperSelection);
        scissorButton = new JButton("Scissors", scissorIcon);
        scissorButton.addActionListener(scissorsSelection);

        quitButton = new JButton("Quit");
        quitButton.addActionListener(quit);

        add(mainPanel);
        mainPanel.setLayout(new BorderLayout(0,200));
        mainPanel.add(topPanel, BorderLayout.NORTH);
        topPanel.setLayout(new GridLayout(1,2));
        mainPanel.add(selectPanel, BorderLayout.CENTER);
        selectPanel.setLayout(new GridLayout(1,3,100,0));
        mainPanel.add(quitPanel, BorderLayout.SOUTH);
        quitPanel.setLayout(new GridLayout(1,1));

        // Top
        topPanel.add(title);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Times New Roman", Font.PLAIN, 40));

        // Select
        selectPanel.add(rockButton);
        rockButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
        rockButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,4));
        selectPanel.add(paperButton);
        paperButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
        paperButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,4));
        selectPanel.add(scissorButton);
        scissorButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
        scissorButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,4));

        // Bottom/Quit
        quitPanel.add(quitButton);
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
            System.out.println("Picked Rock");
        }
    }
    private class PaperListener implements ActionListener
    {
        public void actionPerformed(ActionEvent AE)
        {
            System.out.println("Picked Paper");
        }
    }
    private class ScissorsListener implements ActionListener
    {
        public void actionPerformed(ActionEvent AE)
        {
            System.out.println("Picked Scissors");
        }
    }
}
