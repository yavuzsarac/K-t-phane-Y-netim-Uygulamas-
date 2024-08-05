import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class newUser extends JFrame{
    private JPanel panel1;
    private JPanel mainPanel;
    private JLabel askUsername;
    private JTextField username;
    private JButton saveUsername;
    private userLoginScreen userLoginScreen;

    public newUser(){
        add(panel1);
        setVisible(true);
        setTitle("Kayıt Ol");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350,350);
        setLocationRelativeTo(null);


        saveUsername.addActionListener(new ActionListener() {
            BufferedWriter writer = null;
            String s;

            public void actionPerformed(ActionEvent e) {
                try {
                    writer = new BufferedWriter(new FileWriter(("C:\\Users\\KEY\\IdeaProjects\\newLibraryManagement\\user_database.txt"), true));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    s = username.getText();
                    writer.write("\n" + s);
                    writer.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
setVisible(false);
                new userLoginScreen();
            }
        });
    }
}
