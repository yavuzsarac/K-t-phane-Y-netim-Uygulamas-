import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class borrowBook extends JFrame {
    private JPanel panel1;
    private JComboBox bookSelector;
    private JButton borrowBookButton;
    private JButton returnButton;

    public borrowBook() throws FileNotFoundException, IOException {
        add(panel1);
        setTitle("Kitap Al");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(350,350);
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        BufferedReader br =null;
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\KEY\\IdeaProjects\\newLibraryManagement\\book_database.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ArrayList<String> books = new ArrayList<>();
        String list;
        while ((list = br.readLine()) != null){
            books.add(list);
        }
        for (String book : books){
            bookSelector.addItem(book);
        }

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        borrowBookButton.addActionListener(new ActionListener() {
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

                setVisible(false);
            }
        });
    }


}
