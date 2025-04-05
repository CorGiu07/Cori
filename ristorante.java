package pizzeria;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ristorante {

	private JFrame frame;
	private JTextField textFieldTavolo, textFieldPax;
	private JTextField textFieldPizzaMarinara, textFieldPizzaMargherita;
	private JTextField textFieldTotPizzaMarinara, textFieldTotPizzaMargherita, textFieldTotPizze;
	private JTextField textFieldBibitaAcqua, textFieldBibitaCola, textFieldBibitaBirra, textFieldBibitaCocaCola;
	private JTextField textFieldTotBibitaAcqua, textFieldTotBibitaCola, textFieldTotBibitaBirra, textFieldTotBibitaCocaCola, textFieldTotBibite;
	private JTextField textFieldTotCoperti, textFieldTotaleFinale;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				ristorante window = new ristorante();
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public ristorante() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(64, 0, 128));
		frame.setBounds(100, 100, 916, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// Tavolo e coperti
		JLabel lblTavolo = new JLabel("TAVOLO");
		lblTavolo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 30));
		lblTavolo.setBounds(38, 35, 134, 45);
		frame.getContentPane().add(lblTavolo);

		textFieldTavolo = new JTextField();
		textFieldTavolo.setBounds(182, 54, 96, 19);
		frame.getContentPane().add(textFieldTavolo);
		textFieldTavolo.setColumns(10);

		JLabel lblPax = new JLabel("PAX   € 1,00");
		lblPax.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 30));
		lblPax.setBounds(38, 90, 177, 42);
		frame.getContentPane().add(lblPax);

		textFieldPax = new JTextField();
		textFieldPax.setBounds(220, 108, 96, 19);
		frame.getContentPane().add(textFieldPax);
		textFieldPax.setColumns(10);
		textFieldPax.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				calcolaTotali();
			}
		});

		JLabel lblTotCoperti = new JLabel("TOT.COPERTI    €");
		lblTotCoperti.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 30));
		lblTotCoperti.setBounds(429, 46, 228, 34);
		frame.getContentPane().add(lblTotCoperti);

		textFieldTotCoperti = new JTextField();
		textFieldTotCoperti.setBounds(667, 54, 96, 19);
		textFieldTotCoperti.setEditable(false);
		frame.getContentPane().add(textFieldTotCoperti);
		textFieldTotCoperti.setColumns(10);

		// Sezione Pizze
		JLabel lblPizzaMarinara = new JLabel("MARINARA € 4,00 N°");
		lblPizzaMarinara.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 30));
		lblPizzaMarinara.setBounds(38, 160, 350, 30);
		frame.getContentPane().add(lblPizzaMarinara);

		textFieldPizzaMarinara = new JTextField();
		textFieldPizzaMarinara.setBounds(400, 165, 45, 19);
		frame.getContentPane().add(textFieldPizzaMarinara);
		textFieldPizzaMarinara.setColumns(10);
		textFieldPizzaMarinara.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				calcolaTotali();
			}
		});

		JLabel lblPizzaMargherita = new JLabel("MARGHERITA € 5,00 N°");
		lblPizzaMargherita.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 30));
		lblPizzaMargherita.setBounds(38, 200, 350, 30);
		frame.getContentPane().add(lblPizzaMargherita);

		textFieldPizzaMargherita = new JTextField();
		textFieldPizzaMargherita.setBounds(400, 205, 45, 19);
		frame.getContentPane().add(textFieldPizzaMargherita);
		textFieldPizzaMargherita.setColumns(10);
		textFieldPizzaMargherita.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				calcolaTotali();
			}
		});

		JLabel lblTotPizze = new JLabel("TOT PIZZE €");
		lblTotPizze.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 30));
		lblTotPizze.setBounds(600, 180, 150, 30);
		frame.getContentPane().add(lblTotPizze);

		textFieldTotPizze = new JTextField();
		textFieldTotPizze.setBounds(750, 185, 80, 25);
		textFieldTotPizze.setEditable(false);
		frame.getContentPane().add(textFieldTotPizze);
		textFieldTotPizze.setColumns(10);

		// Sezione Bibite
		JLabel lblBibitaAcqua = new JLabel("ACQUA € 1,50              N°");
		lblBibitaAcqua.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 30));
		lblBibitaAcqua.setBounds(38, 250, 350, 30);
		frame.getContentPane().add(lblBibitaAcqua);

		textFieldBibitaAcqua = new JTextField();
		textFieldBibitaAcqua.setBounds(400, 255, 45, 19);
		frame.getContentPane().add(textFieldBibitaAcqua);
		textFieldBibitaAcqua.setColumns(10);
		textFieldBibitaAcqua.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				calcolaTotali();
			}
		});

		JLabel lblBibitaCola = new JLabel("SPRITE € 2,00              N°");
		lblBibitaCola.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 30));
		lblBibitaCola.setBounds(38, 290, 350, 30);
		frame.getContentPane().add(lblBibitaCola);

		textFieldBibitaCola = new JTextField();
		textFieldBibitaCola.setBounds(400, 295, 45, 19);
		frame.getContentPane().add(textFieldBibitaCola);
		textFieldBibitaCola.setColumns(10);
		textFieldBibitaCola.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				calcolaTotali();
			}
		});

		JLabel lblBibitaCocaCola = new JLabel("COCA COLA € 2,50       N°");
		lblBibitaCocaCola.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 30));
		lblBibitaCocaCola.setBounds(38, 330, 350, 30);
		frame.getContentPane().add(lblBibitaCocaCola);

		textFieldBibitaCocaCola = new JTextField();
		textFieldBibitaCocaCola.setBounds(400, 335, 45, 19);
		frame.getContentPane().add(textFieldBibitaCocaCola);
		textFieldBibitaCocaCola.setColumns(10);
		textFieldBibitaCocaCola.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				calcolaTotali();
			}
		});

		JLabel lblTotaleBibite = new JLabel("TOTALE BIBITE €");
		lblTotaleBibite.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 30));
		lblTotaleBibite.setBounds(549, 250, 201, 30);
		frame.getContentPane().add(lblTotaleBibite);

		textFieldTotBibite = new JTextField();
		textFieldTotBibite.setBounds(750, 255, 80, 25);
		textFieldTotBibite.setEditable(false);
		frame.getContentPane().add(textFieldTotBibite);
		textFieldTotBibite.setColumns(10);

		// Totale finale
		JLabel lblTotale = new JLabel("TOTALE  €");
		lblTotale.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 30));
		lblTotale.setBounds(586, 409, 134, 42);
		frame.getContentPane().add(lblTotale);

		textFieldTotaleFinale = new JTextField();
		textFieldTotaleFinale.setBounds(717, 409, 96, 30);
		textFieldTotaleFinale.setEditable(false);
		frame.getContentPane().add(textFieldTotaleFinale);
		textFieldTotaleFinale.setColumns(10);
	}

	private void calcolaTotali() {
		try {
			int pax = Integer.parseInt(textFieldPax.getText());
			textFieldTotCoperti.setText(String.format("%.2f", pax * 1.00));

			int marinara = Integer.parseInt(textFieldPizzaMarinara.getText());
			int margherita = Integer.parseInt(textFieldPizzaMargherita.getText());
			double totPizze = (marinara * 4.00) + (margherita * 5.00);
			textFieldTotPizze.setText(String.format("%.2f", totPizze));

			int acqua = Integer.parseInt(textFieldBibitaAcqua.getText());
			int cola = Integer.parseInt(textFieldBibitaCola.getText());
			int cocaCola = Integer.parseInt(textFieldBibitaCocaCola.getText());

			double totBibite = (acqua * 1.50) + (cola * 2.00) + (cocaCola * 2.50);
			textFieldTotBibite.setText(String.format("%.2f", totBibite));

			double totaleFinale = (pax * 1.00) + totPizze + totBibite;
			textFieldTotaleFinale.setText(String.format("%.2f", totaleFinale));
		} catch (NumberFormatException e) {
			textFieldTotCoperti.setText("0.00");
			textFieldTotPizze.setText("0.00");
			textFieldTotBibite.setText("0.00");
			textFieldTotaleFinale.setText("0.00");
		}
	}
}