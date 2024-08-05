import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class manageBooks extends JFrame {
    private JPanel panel1;
    private JButton addBook;
    private JButton removeBook;
    private JButton returnButton;
    private JButton reAddOccupiedBook;


    public manageBooks() {
        setVisible(true);
        add(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setTitle("Kitap Menüsü");


        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new adminPortal();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                setVisible(false);
            }
        });
        addBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new addBook();
                setVisible(false);
            }
        });
        removeBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new removeBook();
                    setVisible(false);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        reAddOccupiedBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new reAddOccupiedBook();
                    setVisible(false);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
