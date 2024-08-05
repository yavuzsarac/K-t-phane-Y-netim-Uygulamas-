import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class userPortal extends JFrame {
    private JButton takeBook;
    private JButton returnBook;
    private JButton availableBooks;
    private JPanel mainPanel;
    private JLabel welcomeMessage;
    private JLabel chooseMessage;
    //private JComboBox redCB;
   // private JComboBox greenCB;
    //private JComboBox blueCB;
    private JLabel colorSelector;
    private JSlider redSlider;
    private JSlider greenSlider;
    private JSlider blueSlider;
    private static int r,g,b;

    public userPortal(){
        add(mainPanel);
        setTitle("Kullanıcı Menüsü");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(1000,1000);



        // MENÜ RENK DEĞİŞTİRİCİ OPSİYONEL (buton)

       /* DefaultComboBoxModel redCBModel = new DefaultComboBoxModel();
        redCB.setModel(redCBModel);
        DefaultComboBoxModel greenCBModel = new DefaultComboBoxModel();
        greenCB.setModel(greenCBModel);
        DefaultComboBoxModel blueCBModel = new DefaultComboBoxModel();
        blueCB.setModel(blueCBModel);

        ArrayList<String> number = new ArrayList<>();
        for(int i = 0 ; i<256 ; i++){
            number.add(Integer.toString(i));
        }
        redCBModel.addAll(number);
        greenCBModel.addAll(number);
        blueCBModel.addAll(number);


        redCB.setSelectedIndex(0);
        greenCB.setSelectedIndex(0);
        blueCB.setSelectedIndex(0);


        redCB.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                r = (int)redCB.getSelectedIndex();
                g = (int)greenCB.getSelectedIndex();
                b = (int)blueCB.getSelectedIndex();
                mainPanel.setBackground(new Color(r,g,b));
            }
        });

        blueCB.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                r = (int)redCB.getSelectedIndex();
                g = (int)greenCB.getSelectedIndex();
                b = (int)blueCB.getSelectedIndex();
                mainPanel.setBackground(new Color(r,g,b));
            }
        });

        greenCB.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                r = (int)redCB.getSelectedIndex();
                g = (int)greenCB.getSelectedIndex();
                b = (int)blueCB.getSelectedIndex();
                mainPanel.setBackground(new Color(r,g,b));
            }
        });
*/

        //MENÜ RENK DEĞİŞTİRİCİ (slider)
        redSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                r=(int) redSlider.getValue();
                g=(int) greenSlider.getValue();
                b=(int) blueSlider.getValue();
                mainPanel.setBackground(new Color(r,g,b));
                if(r < 50 && g < 50 && b < 50){
                    welcomeMessage.setForeground(Color.WHITE);
                    chooseMessage.setForeground(Color.WHITE);
                    colorSelector.setForeground(Color.white);

                }
                else if(r  > 200 && g  > 200 && b  > 200){
                    welcomeMessage.setForeground(Color.black);
                    chooseMessage.setForeground(Color.black);
                    colorSelector.setForeground(Color.black);

                }
            }
        });
        greenSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                r=(int) redSlider.getValue();
                g=(int) greenSlider.getValue();
                b=(int) blueSlider.getValue();
                mainPanel.setBackground(new Color(r,g,b));
                if(r < 50 && g < 50 && b < 50){
                    welcomeMessage.setForeground(Color.WHITE);
                    chooseMessage.setForeground(Color.WHITE);
                    colorSelector.setForeground(Color.white);

                }
                else if(r > 200 && g  > 200 && b  > 200){
                    welcomeMessage.setForeground(Color.black);
                    chooseMessage.setForeground(Color.black);
                    colorSelector.setForeground(Color.black);

                }
            }
        });
        blueSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                r=(int) redSlider.getValue();
                g=(int) greenSlider.getValue();
                b=(int) blueSlider.getValue();
                mainPanel.setBackground(new Color(r,g,b));
                if(r < 50 && g < 50 && b < 50){
                    welcomeMessage.setForeground(Color.WHITE);
                    chooseMessage.setForeground(Color.WHITE);
                    colorSelector.setForeground(Color.white);
                }
                else if(r  > 200 && g  > 200 && b  > 200){
                    welcomeMessage.setForeground(Color.black);
                    chooseMessage.setForeground(Color.black);
                    colorSelector.setForeground(Color.black);

                }
            }
        });


        availableBooks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new bookList();
            }
        });
        takeBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new borrowBook();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        returnBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new returnBook();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}



