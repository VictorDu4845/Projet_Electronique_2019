package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import java.awt.Color;

public class VueThermo {

	public JFrame frame;
	private JTextField Grp8;
	private JTextField txtTemperatureActuelle;
	private JTextField txtTemperatureMin;
	private JTextField txtTemperatureMax;
	private JTextField minField;
	public int min=-30;
	public int max=70;
	//public int tempMax = 100;
	private JTextField maxField;

	public VueThermo() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.YELLOW);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Grp8 = new JTextField("Bienvenue sur la sonde de temperature du groupe 8 ");
		Grp8.setBounds(58, 11, 299, 20);
		frame.getContentPane().add(Grp8);
		Grp8.setColumns(10);
		Grp8.setEditable(false);
		
		txtTemperatureActuelle = new JTextField();
		txtTemperatureActuelle.setText("Temperature Actuelle : ");
		txtTemperatureActuelle.setBounds(10, 56, 136, 20);
		frame.getContentPane().add(txtTemperatureActuelle);
		txtTemperatureActuelle.setColumns(10);
		txtTemperatureActuelle.setEditable(false);
		
		txtTemperatureMin = new JTextField();
		txtTemperatureMin.setText("Temperature Min : ");
		txtTemperatureMin.setBounds(10, 87, 136, 20);
		frame.getContentPane().add(txtTemperatureMin);
		txtTemperatureMin.setColumns(10);
		txtTemperatureMin.setEditable(false);
		
		txtTemperatureMax = new JTextField();
		txtTemperatureMax.setText("Temperature Max : ");
		txtTemperatureMax.setBounds(10, 118, 136, 20);
		frame.getContentPane().add(txtTemperatureMax);
		txtTemperatureMax.setColumns(10);
		txtTemperatureMax.setEditable(false);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btnExit);
		
		JTextArea tmpAct = new JTextArea();
		tmpAct.setBounds(156, 54, 47, 20);
		frame.getContentPane().add(tmpAct);
		tmpAct.setEditable(false);
		tmpAct.setText("20 °");
		
		JSlider sliderMin = new JSlider();
		sliderMin.setBounds(213, 81, 200, 26);
		frame.getContentPane().add(sliderMin);
		
		JSlider sliderMax = new JSlider();
		sliderMax.setBounds(213, 112, 200, 26);
		frame.getContentPane().add(sliderMax);
		
		minField = new JTextField();
		minField.setBounds(156, 87, 47, 20);
		frame.getContentPane().add(minField);
		minField.setColumns(10);
		minField.setEditable(false);
		
		maxField = new JTextField();
		maxField.setBounds(156, 118, 47, 20);
		frame.getContentPane().add(maxField);
		maxField.setColumns(10);
		maxField.setEditable(false);
		
		sliderMin.addChangeListener(new ChangeListener() {
        	public void stateChanged(ChangeEvent arg0) {
                       	min=sliderMin.getValue(); 
                       	minField.setText(min+"");
                       	sliderMin.setMaximum(70);
                       	sliderMin.setMinimum(-30);
                       	
        	}
});
		
		sliderMax.addChangeListener(new ChangeListener() {
        	public void stateChanged(ChangeEvent arg0) {
                       	min=sliderMax.getValue(); 
                       	maxField.setText(min+"");
                     	sliderMax.setMaximum(70);
                     	sliderMax.setMinimum(-30);
                       	
        	}
		});
	
	
	}
}
