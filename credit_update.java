package creditbank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;

public class credit_update {

	private JFrame frame;
	private JTextField txtTotalCredit;
	private JTextField txtCurrentEligibleDegree;
	private JTextField txtCreditForNext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					credit_update window = new credit_update();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public credit_update() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 464, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(83, 77, -56, 22);
		frame.getContentPane().add(textArea);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(334, 123, -113, 22);
		frame.getContentPane().add(textArea_2);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBounds(389, 94, -100, 22);
		frame.getContentPane().add(textArea_3);
		
		txtTotalCredit = new JTextField();
		txtTotalCredit.setFont(new Font("Tahoma", Font.BOLD, 10));
		txtTotalCredit.setBounds(37, 69, 125, 19);
		frame.getContentPane().add(txtTotalCredit);
		txtTotalCredit.setColumns(10);
		
		txtCurrentEligibleDegree = new JTextField();
		txtCurrentEligibleDegree.setFont(new Font("Tahoma", Font.BOLD, 10));
		txtCurrentEligibleDegree.setBounds(37, 123, 152, 22);
		frame.getContentPane().add(txtCurrentEligibleDegree);
		txtCurrentEligibleDegree.setColumns(10);
		
		txtCreditForNext = new JTextField();
		txtCreditForNext.setFont(new Font("Tahoma", Font.BOLD, 10));
		txtCreditForNext.setBounds(37, 179, 152, 19);
		frame.getContentPane().add(txtCreditForNext);
		txtCreditForNext.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("CREDIT FOR NEXT DEGREE");
		lblNewLabel.setBounds(231, 182, 139, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CURRENT ELIGIBLE DEGREE");
		lblNewLabel_1.setBounds(231, 132, 162, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("TOTAL CREDIT");
		lblNewLabel_2.setBounds(232, 72, 118, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("UPDATE CREDITS");
		lblNewLabel_3.setBounds(173, 24, 101, 19);
		frame.getContentPane().add(lblNewLabel_3);
	}
}
