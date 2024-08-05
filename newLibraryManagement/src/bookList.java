import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class bookList extends JFrame {
    private JPanel panel1;
    private JButton returnButton;
    private JLabel booksList;

    public bookList() {
        setVisible(true);
        add(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setTitle("Kitap Listesi");

        try (
                BufferedReader fileReader = new BufferedReader(new FileReader("C:\\Users\\KEY\\IdeaProjects\\newLibraryManagement\\book_database.txt"))) {
            StringBuilder userText = new StringBuilder();
            String line;
            while ((line = fileReader.readLine()) != null) {
                userText.append(line).append("\n");
            }
            booksList.setText("<html>" + userText.toString().replace("\n", "<br>") + "</html>");
        } catch (
                FileNotFoundException e) {
            booksList.setText("File not found!");
            e.printStackTrace();
        } catch (
                IOException e) {
            booksList.setText("Error reading file!");
            e.printStackTrace();
        }


        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }



}
