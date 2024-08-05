import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class adminLoginScreen extends JFrame {
    private JPanel panel1;
    private JPanel mainPanel;
    private JLabel username;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel password;
    private JButton loginButton;
    private JLabel errorMessage;
    private JButton returnButton;
    private adminPortal adminPortal;
    private static ArrayList<String> adminPasswordList = new ArrayList<String>();
    private static ArrayList<String> adminUsernameList = new ArrayList<>();
    private boolean girisbasari = false;
    private boolean passwordCheck = false;

    public adminLoginScreen() {
        setTitle("Yönetici Girişi");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        add(panel1);
        setLocationRelativeTo(null);

        try {
            readAdminUsernameList("C:\\Users\\KEY\\IdeaProjects\\newLibraryManagement\\admin_username_database.txt");
            readAdminPasswordList("C:\\Users\\KEY\\IdeaProjects\\newLibraryManagement\\admin_password_database.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputUsername = usernameField.getText().trim();
                String inputPassword = new String(passwordField.getPassword()).trim();

                // Reset the flags
                girisbasari = false;
                passwordCheck = false;

                // Check username
                for (String obj : adminUsernameList) {
                    if (obj.trim().equalsIgnoreCase(inputUsername)) {
                        girisbasari = true;
                        break;
                    }
                }

                // Check password if username is correct
                if (girisbasari) {
                    for (String obj : adminPasswordList) {
                        if (obj.trim().equalsIgnoreCase(inputPassword)) {
                            passwordCheck = true;
                            break;
                        }
                    }
                }

                // Evaluate the results
                if (girisbasari && passwordCheck) {
                    try {
                        new adminPortal();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    setVisible(false);
                } else if (!girisbasari) {
                    errorMessage.setText("Yanlış Kullanıcı Adı");
                } else if (!passwordCheck) {
                    errorMessage.setText("Yanlış Şifre");
                }
            }
        });
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new userOrAdmin();
                setVisible(false);
            }
        });
    }

    public static void readAdminUsernameList(String filename) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(filename));
        String s;
        while ((s = fileReader.readLine()) != null) {
            adminUsernameList.add(s);
        }
    }

    public static void readAdminPasswordList(String filename) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(filename));
        String s;
        while ((s = fileReader.readLine()) != null) {
            adminPasswordList.add(s);
        }
    }
}




