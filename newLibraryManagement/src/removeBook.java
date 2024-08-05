import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class removeBook extends JFrame {
    private JPanel panel1;
    private JComboBox<String> bookSelector;
    private JButton removeButton;

    public removeBook() throws IOException {
        add(panel1);
        setTitle("Kitap Kaldır");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250, 250);
        setVisible(true);
        setLocationRelativeTo(null);

        DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<>();
        ArrayList<String> books = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\KEY\\IdeaProjects\\newLibraryManagement\\book_database.txt"));
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

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedBook = bookSelector.getSelectedItem().toString();
                books.remove(selectedBook);

                try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\KEY\\IdeaProjects\\newLibraryManagement\\book_database.txt"))) {
                    for (String book : books) {
                        bw.write(book);
                        bw.newLine();
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\KEY\\IdeaProjects\\newLibraryManagement\\occupied_books.txt", true))) {
                    bw.write(selectedBook);
                    bw.newLine();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                new manageBooks();
                setVisible(false);
            }
        });
    }


}
