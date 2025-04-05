import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VerificaSquillaci {
    private JFrame frame;
    private JTextField textField;
    private JLabel lblResult;
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                VerificaSquillaci window = new VerificaSquillaci();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    public VerificaSquillaci() {
        initialize();
    }
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 773, 533);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // ComboBox per selezionare il mezzo
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setModel(new DefaultComboBoxModel<>(new String[]{"", "AUTO 3€", "MOTO 2€", "BICI 1€"}));
        comboBox.setBounds(80, 57, 162, 30);
        frame.getContentPane().add(comboBox);

        JLabel lblTitle = new JLabel("MEZZO COSTO.ORA");
        lblTitle.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        lblTitle.setBounds(47, 18, 226, 29);
        frame.getContentPane().add(lblTitle);

        JLabel lblOre = new JLabel("NUMERO ORE");
        lblOre.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        lblOre.setBounds(119, 238, 167, 46);
        frame.getContentPane().add(lblOre);

        textField = new JTextField();
        textField.setBounds(308, 238, 96, 46);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblArrow = new JLabel("----------->");
        lblArrow.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        lblArrow.setBounds(429, 238, 120, 46);
        frame.getContentPane().add(lblArrow);

        JLabel lblEuro = new JLabel("€");
        lblEuro.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        lblEuro.setBounds(549, 246, 45, 30);
        frame.getContentPane().add(lblEuro);

        lblResult = new JLabel("0");
        lblResult.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        lblResult.setBounds(589, 246, 67, 26);
        frame.getContentPane().add(lblResult);

        JButton btnCalcola = new JButton("CALCOLA");
        btnCalcola.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnCalcola.setBounds(510, 300, 127, 30);
        frame.getContentPane().add(btnCalcola);

        JButton btnEsci = new JButton("ESCI");
        btnEsci.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnEsci.setBounds(647, 300, 85, 30);
        frame.getContentPane().add(btnEsci);

        // RadioButton per lo sconto
        JRadioButton rdbtnSconto = new JRadioButton("SCONTO");
        rdbtnSconto.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        rdbtnSconto.setBounds(510, 38, 155, 30);
        frame.getContentPane().add(rdbtnSconto);

        JRadioButton rdbtnNoSconto = new JRadioButton("NO SCONTO", true);
        rdbtnNoSconto.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        rdbtnNoSconto.setBounds(510, 96, 176, 30);
        frame.getContentPane().add(rdbtnNoSconto);

        // radio button (per selezionarne solo uno)
        ButtonGroup gruppoSconto = new ButtonGroup();
        gruppoSconto.add(rdbtnSconto);
        gruppoSconto.add(rdbtnNoSconto);

        JLabel lblSconto = new JLabel("10%");
        lblSconto.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        lblSconto.setBounds(665, 18, 67, 60);
        frame.getContentPane().add(lblSconto);

        // pulsante "CALCOLA"
        btnCalcola.addActionListener(e -> {
            try {
                String mezzo = (String) comboBox.getSelectedItem();
                int ore = Integer.parseInt(textField.getText());

                if (ore < 0) {
                    JOptionPane.showMessageDialog(frame, "Inserire un numero di ore valido!", "Errore", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                double costoOra = 0;
                if ("AUTO 3€".equals(mezzo)) costoOra = 3;
                else if ("MOTO 2€".equals(mezzo)) costoOra = 2;
                else if ("BICI 1€".equals(mezzo)) costoOra = 1;

                if (costoOra == 0) {
                    JOptionPane.showMessageDialog(frame, "Seleziona un mezzo di trasporto!", "Errore", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                double costoTotale = costoOra * ore;
                if (rdbtnSconto.isSelected()) {
                    costoTotale *= 0.9;  // Sconto del 10%
                }

                //risultato
                lblResult.setText(String.format("%.2f", costoTotale));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Inserisci un numero valido di ore!", "Errore", JOptionPane.ERROR_MESSAGE);
            }
        });

        // pulsante "ESCI"
        btnEsci.addActionListener(e -> System.exit(0));
    }
}

