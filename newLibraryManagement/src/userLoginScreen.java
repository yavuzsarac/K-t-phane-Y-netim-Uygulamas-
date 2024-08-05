import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.*;


public class userLoginScreen extends JFrame {
    private JPanel mainPanel;
    private JLabel username;
    private JTextField textField1;
    private JButton loginButton;
    private JLabel errorWarning;
    private JPanel errorPanel;
    private JButton newUserButton;
    private JButton returnButton;
    private userPortal userPortal;
    private static ArrayList<String> userDatabase = new ArrayList<>();
    private newUser newUser;

    public userLoginScreen()  {
        add(mainPanel);
        setTitle("Kullanıcı Girişi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250,250);
        setVisible(true);
        setLocationRelativeTo(null);

        try {
            readFromFile("C:\\Users\\KEY\\IdeaProjects\\newLibraryManagement\\user_database.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        loginButton.addActionListener(new ActionListener() {
            Boolean girisbasarilimi = false;
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (String obj: userDatabase) {
                        if (obj.trim().equalsIgnoreCase(textField1.getText().trim())) {
                            girisbasarilimi = true;
                            new userPortal();
                            setVisible(false);
                        }
                    }
                    if (!girisbasarilimi) {
                        errorWarning.setText("Böyle Bir Kullanıcı Bulunamadı.");
                    }

                }
            });
        newUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new newUser();
                setVisible(false);
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

    public static void readFromFile(String filename) throws IOException {
        BufferedReader fileReader = null;
        try {
            fileReader = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        String writer;
        while ((writer = fileReader.readLine()) != null) {
            userDatabase.add(writer);


    }
}}

