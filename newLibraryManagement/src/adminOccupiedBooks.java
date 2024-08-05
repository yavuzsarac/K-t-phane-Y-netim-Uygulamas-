import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class adminOccupiedBooks extends JFrame{
    private JPanel panel1;
    private JLabel bookList;
    private JButton returnButton;

    public adminOccupiedBooks(){
    setVisible(true);
    add(panel1);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(500, 500);
    setLocationRelativeTo(null);
    setTitle("Alınmış Kitap Listesi");

        try (
    BufferedReader fileReader = new BufferedReader(new FileReader("C:\\Users\\KEY\\IdeaProjects\\newLibraryManagement\\occupied_books.txt"))) {
        StringBuilder userText = new StringBuilder();
        String line;
        while ((line = fileReader.readLine()) != null) {
            userText.append(line).append("\n");
        }
            bookList.setText("<html>" + userText.toString().replace("\n", "<br>") + "</html>");
    } catch (
    FileNotFoundException e) {
            bookList.setText("File not found!");
        e.printStackTrace();
    } catch (
    IOException e) {
            bookList.setText("Error reading file!");
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
