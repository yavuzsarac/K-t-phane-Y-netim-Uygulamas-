import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class reAddOccupiedBook extends JFrame {
    private JPanel panel1;
    private JComboBox<String> bookSelector;
    private JButton addButton;
    private JButton returnButton;

    public reAddOccupiedBook() throws FileNotFoundException, IOException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setVisible(true);
        add(panel1);
        setTitle("Kitap Ekle");
        setLocationRelativeTo(null);

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

        DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<>();
        ArrayList<String> books = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\KEY\\IdeaProjects\\newLibraryManagement\\occupied_books.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                books.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        for (String book : books) {
            dcbm.addElement(book);
        }
        bookSelector.setModel(dcbm);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedBook = bookSelector.getSelectedItem().toString();
                books.remove(selectedBook);

                try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\KEY\\IdeaProjects\\newLibraryManagement\\occupied_books.txt"))) {
                    for (String book : books) {
                        bw.write(book);
                        bw.newLine();
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                try (BufferedWriter bw1 = new BufferedWriter(new FileWriter("C:\\Users\\KEY\\IdeaProjects\\newLibraryManagement\\book_database.txt", true))) {
                    bw1.write(  selectedBook + "\n");
                    bw1.newLine();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                new manageBooks();
                setVisible(false);
            }
        });
    }


}

