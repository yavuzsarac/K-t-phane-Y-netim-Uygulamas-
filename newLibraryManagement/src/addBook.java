import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class addBook extends JFrame {
    private JPanel panel1;
    private JTextField bookName;
    private JButton bookSaveButton;

    public addBook() {
        setVisible(true);
        add(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setTitle("Kitap Ekle");

        bookSaveButton.addActionListener(new ActionListener() {
            BufferedWriter writer = null;
            String s;

            public void actionPerformed(ActionEvent e) {
                try {
                    writer = new BufferedWriter(new FileWriter(("C:\\Users\\KEY\\IdeaProjects\\newLibraryManagement\\book_database.txt"), true));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    s = bookName.getText();
                    writer.write(s + "\n");
                    writer.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                setVisible(false);
                try {
                    new adminPortal();
                    setVisible(false);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


    }





}
