import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class App extends JFrame
{
     final private Font mainFont = new Font("Segoe print", Font.BOLD, 18);
    public void initialize(){

        JLabel first=new JLabel("Welcome to Number Guessing Game");
        first.setFont(mainFont);
        first.setBorder(BorderFactory.createEmptyBorder(20,0,30,0));

        JLabel sec=new JLabel("Select Difficulty");
        sec.setFont(mainFont);
        sec.setBorder(BorderFactory.createEmptyBorder(20,120,30,50));

        String[] Diff={"Easy","Medium","Hard"};
        JComboBox cb=new JComboBox<>(Diff);
        cb.setFont(mainFont);
        cb.setBorder(BorderFactory.createEmptyBorder(20,80,30,80));

        JPanel nob = new JPanel();
        nob.setLayout(new GridLayout(0, 1, 10, 10));
        nob.setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 20));
        nob.add(first);
        nob.add(sec);
        nob.add(cb);
        

        JButton start=new JButton("Start");
        JPanel but=new JPanel();
        start.setFont(mainFont);
        but.setLayout(new GridLayout(0,1,10,10));
        but.setBorder(BorderFactory.createEmptyBorder(30,140,50,140));
        but.add(start);
        start.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Game gm=new Game();
                gm.initialize();
                
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });
        
        add(but,BorderLayout.SOUTH);
        add(nob,BorderLayout.NORTH);
        setTitle("Number Guessing Game");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400, 500);
        setMinimumSize(new Dimension(350, 450));
        //setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) throws Exception {
        App app=new App();
        app.initialize();
    }
}
