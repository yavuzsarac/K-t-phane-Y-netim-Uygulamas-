import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class adminShowUser extends JFrame {
    private JPanel panel1;
    private JLabel userList;
    private JButton returnButton;
    private adminPortal adminPortal;

    public adminShowUser() {
        add(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setTitle("Kullanıcı Listesi");

        try (BufferedReader fileReader = new BufferedReader(new FileReader("C:\\Users\\KEY\\IdeaProjects\\newLibraryManagement\\user_database.txt"))) {
            StringBuilder userText = new StringBuilder();
            String line;
            while ((line = fileReader.readLine()) != null) {
                userText.append(line).append("\n");
            }
            userList.setText("<html>" + userText.toString().replace("\n", "<br>") + "</html>");
        } catch (FileNotFoundException e) {
            userList.setText("File not found!");
            e.printStackTrace();
        } catch (IOException e) {
            userList.setText("Error reading file!");
            e.printStackTrace();
        }

        setVisible(true);


        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             setVisible(false);
            }
        });
    }








}
