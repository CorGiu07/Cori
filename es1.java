//SQUILLACI ALESSANDRO 4 A INF 01/03/2025
package esercitazione;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class es1 {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private static final String[] valute = {"Euro (Italia)", "Dollaro (USA)", "Sterlina (Regno Unito)", "Yen (Giappone)", "Franco (Svizzera)"};
    private static final Map<String, Double> tassiCambio = new HashMap<>();
    
    static {
        tassiCambio.put("Euro (Italia)", 1.0);
        tassiCambio.put("Dollaro (USA)", 1.3909);
        tassiCambio.put("Sterlina (Regno Unito)", 0.82534);
        tassiCambio.put("Yen (Giappone)", 156.122);
        tassiCambio.put("Franco (Svizzera)", 0.9366);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    es1 window = new es1();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public es1() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 573, 479);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JComboBox<String> comboBox = new JComboBox<>(valute);
        comboBox.setBounds(25, 90, 187, 30);
        frame.getContentPane().add(comboBox);
        
        JComboBox<String> comboBox_1 = new JComboBox<>(valute);
        comboBox_1.setBounds(249, 90, 187, 30);
        frame.getContentPane().add(comboBox_1);
        
        JLabel lblNewLabel = new JLabel("CONVERTITORE VALUTE");
        lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 30));
        lblNewLabel.setBounds(25, 10, 276, 48);
        frame.getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_2 = new JLabel("IMPORTO DA CONVERTIRE:");
        lblNewLabel_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
        lblNewLabel_2.setBounds(25, 214, 207, 48);
        frame.getContentPane().add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("IMPORTO FINALE:");
        lblNewLabel_3.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
        lblNewLabel_3.setBounds(249, 227, 134, 23);
        frame.getContentPane().add(lblNewLabel_3);
        
        textField = new JTextField();
        textField.setBounds(25, 267, 144, 30);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setBounds(249, 267, 144, 30);
        textField_1.setEditable(false);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);
        
        JButton btnConvert = new JButton("Converti");
        btnConvert.setBounds(168, 374, 120, 40);
        frame.getContentPane().add(btnConvert);
        
        btnConvert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(textField.getText());
                    String from = (String) comboBox.getSelectedItem();
                    String to = (String) comboBox_1.getSelectedItem();
                    
                    if (from != null && to != null) {
                        double rateFrom = tassiCambio.get(from);
                        double rateTo = tassiCambio.get(to);
                        double result = amount * (rateTo / rateFrom);
                        textField_1.setText(String.format("%.2f", result));
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Inserisci un valore numerico valido", "Errore", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}


