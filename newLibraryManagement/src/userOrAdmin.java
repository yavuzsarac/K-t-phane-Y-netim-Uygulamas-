import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class userOrAdmin extends JFrame {
    private JPanel panel1;
    private JButton selectAdmin;
    private JButton selectUser;
    private JLabel chooser;
    private adminLoginScreen adminLoginScreen;
    private userLoginScreen userLoginScreen;
    public userOrAdmin()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250,250);
        setVisible(true);
        add(panel1);
        setTitle("Giriş");
        setLocationRelativeTo(null);




        selectAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new adminLoginScreen();
                setVisible(false);
            }
        });
        selectUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new userLoginScreen();
                setVisible(false);
            }
        });
    }

}
