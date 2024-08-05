import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class returnBook extends JFrame {
    private JPanel panel1;
    private JComboBox bookSelector;
    private JButton returnButton;
    private JButton addButon;
    private JLabel message;

    public returnBook() throws IOException {
        add(panel1);
        setTitle("Kitap İade Et");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(250,250);
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
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\KEY\\IdeaProjects\\newLibraryManagement\\occupied_books.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                books.add(line);
            }
            br.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        for (String book : books) {
            dcbm.addElement(book);
        }
        bookSelector.setModel(dcbm);

        addButon.addActionListener(new ActionListener() {
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

                try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\KEY\\IdeaProjects\\newLibraryManagement\\book_database.txt", true))) {
                    bw.write(selectedBook);
                    bw.newLine();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }


                setVisible(false);
            }
        });
    }
}
