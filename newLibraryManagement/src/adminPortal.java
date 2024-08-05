import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class adminPortal extends JFrame {
    private JPanel mainPanel;
    private JLabel welcomeMessage;
    private JButton showUserlist;
    private JButton bookList;
    private JButton borrowedBook;
    private JButton bookMenu;
    private adminShowUser adminShowUser1;
    private adminOccupiedBooks adminOccupiedBooks;
    private bookList showBookList;


    public adminPortal() throws IOException {
    add(mainPanel);
    setTitle("Yönetici Menüsü");
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setSize(500,500);

        showUserlist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new adminShowUser();
            }
        });
        borrowedBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
         new adminOccupiedBooks();
            }
        });

        bookList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new bookList();
            }
        });
        bookMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new manageBooks();
               setVisible(false);
            }
        });
    }
}