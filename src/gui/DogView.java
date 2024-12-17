package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.IllegalFormatException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import ctrl.RegisterDogCtrl;
import model.Dog;

public class DogView extends JDialog
{

	private static final int CURRENT_YEAR = 2024;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldDogName;
	private JTextField textFieldFeeYear;
	private JLabel lblIsFeeDue;
	private JButton btnConfirm;
	private Dog doggy;
	private RegisterDogCtrl dogRegister;
	private JLabel lblNotANumber;

	/**
	 * Create the frame.
	 */
	public DogView(Dog doggy, RegisterDogCtrl dogRegister)
	{
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setModal(true);
		this.dogRegister = dogRegister;
		this.doggy = doggy;
		initGui();
		fillInfo();
	}

	/**
	 * Fills out the text boxes with the current info of the dog Also makes the
	 * button have the appropriate symbol.
	 */
	private void fillInfo()
	{
		if (doggy != null)
		{
			String dogName = doggy.getName();
			String feeYear = "" + doggy.getFeeYear(); // Concatinate int into String
			textFieldDogName.setText(dogName);
			textFieldFeeYear.setText(feeYear);
			if (doggy.isFeeDue(CURRENT_YEAR)) {
				lblIsFeeDue.setText("Fee is due");
			}
			else {
				lblIsFeeDue.setText("Fee is not due");
			}
			
			btnConfirm.setText("✓");
		} else
		{
			btnConfirm.setText("+");
		}
	}

	/**
	 * Registers a dog with the given information if a dog wasn
	 */
	private void confirmDog()
	{
		try
		{
			int feeYear = Integer.parseInt(textFieldFeeYear.getText());
			String dogName = textFieldDogName.getText();
			if (doggy == null)
			{
				// If doggy is null, then a dog is being registered not updated
				dogRegister.registerDog(dogName, feeYear);
			} else
			{
				// This implementation is problematic.
				// If 2 dogs have the same name, this might not update the correct one
				dogRegister.updateDog(doggy.getName(), dogName, feeYear);
			}
			dispose();
		} catch (NumberFormatException e)
		{
			lblNotANumber.setText("MUST BE A NUMBER!");
		}

	}

	/**
	 * Auto generated UI code
	 */
	private void initGui()
	{
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel west = new JPanel();
		contentPane.add(west, BorderLayout.WEST);

		JLabel lblSpacer = new JLabel("    ");
		west.add(lblSpacer);

		JPanel north = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) north.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		contentPane.add(north, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Dog: ");
		north.add(lblNewLabel);

		JPanel south = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) south.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		contentPane.add(south, BorderLayout.SOUTH);

		btnConfirm = new JButton(" ");
		btnConfirm.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				confirmDog();
			}
		});
		south.add(btnConfirm);

		JButton btnNewButton_1 = new JButton("X");
		btnNewButton_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose(); // Closes window without any model updates.
			}
		});
		south.add(btnNewButton_1);

		JPanel center = new JPanel();
		contentPane.add(center, BorderLayout.CENTER);
		GridBagLayout gbl_center = new GridBagLayout();
		gbl_center.columnWidths = new int[]
		{ 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_center.rowHeights = new int[]
		{ 0, 0, 0, 0 };
		gbl_center.columnWeights = new double[]
		{ 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_center.rowWeights = new double[]
		{ 0.0, 0.0, 0.0, Double.MIN_VALUE };
		center.setLayout(gbl_center);

		JLabel lblDogName = new JLabel("Name:");
		lblDogName.setHorizontalAlignment(SwingConstants.TRAILING);
		GridBagConstraints gbc_lblDogName = new GridBagConstraints();
		gbc_lblDogName.anchor = GridBagConstraints.EAST;
		gbc_lblDogName.insets = new Insets(0, 0, 5, 5);
		gbc_lblDogName.gridx = 0;
		gbc_lblDogName.gridy = 0;
		center.add(lblDogName, gbc_lblDogName);

		textFieldDogName = new JTextField();
		GridBagConstraints gbc_textFieldDogName = new GridBagConstraints();
		gbc_textFieldDogName.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDogName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDogName.gridx = 1;
		gbc_textFieldDogName.gridy = 0;
		center.add(textFieldDogName, gbc_textFieldDogName);
		textFieldDogName.setColumns(10);

		JLabel lblTextFieldSpacer = new JLabel("                               ");
		GridBagConstraints gbc_lblTextFieldSpacer = new GridBagConstraints();
		gbc_lblTextFieldSpacer.insets = new Insets(0, 0, 5, 5);
		gbc_lblTextFieldSpacer.gridx = 2;
		gbc_lblTextFieldSpacer.gridy = 0;
		center.add(lblTextFieldSpacer, gbc_lblTextFieldSpacer);

		JLabel lblFeeYear = new JLabel("Fee Year:");
		lblFeeYear.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblFeeYear = new GridBagConstraints();
		gbc_lblFeeYear.anchor = GridBagConstraints.EAST;
		gbc_lblFeeYear.insets = new Insets(0, 0, 5, 5);
		gbc_lblFeeYear.gridx = 0;
		gbc_lblFeeYear.gridy = 1;
		center.add(lblFeeYear, gbc_lblFeeYear);

		textFieldFeeYear = new JTextField();
		GridBagConstraints gbc_textFieldFeeYear = new GridBagConstraints();
		gbc_textFieldFeeYear.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldFeeYear.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldFeeYear.gridx = 1;
		gbc_textFieldFeeYear.gridy = 1;
		center.add(textFieldFeeYear, gbc_textFieldFeeYear);
		textFieldFeeYear.setColumns(10);

		lblNotANumber = new JLabel("");
		lblNotANumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblNotANumber.setForeground(Color.RED);
		GridBagConstraints gbc_lblNotANumber = new GridBagConstraints();
		gbc_lblNotANumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblNotANumber.gridx = 2;
		gbc_lblNotANumber.gridy = 1;
		center.add(lblNotANumber, gbc_lblNotANumber);

		JLabel lblFeeDue = new JLabel("Fee due:");
		GridBagConstraints gbc_lblFeeDue = new GridBagConstraints();
		gbc_lblFeeDue.insets = new Insets(0, 0, 0, 5);
		gbc_lblFeeDue.anchor = GridBagConstraints.EAST;
		gbc_lblFeeDue.gridx = 0;
		gbc_lblFeeDue.gridy = 2;
		center.add(lblFeeDue, gbc_lblFeeDue);

		lblIsFeeDue = new JLabel("");
		lblIsFeeDue.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblIsFeeDue = new GridBagConstraints();
		gbc_lblIsFeeDue.anchor = GridBagConstraints.LINE_START;
		gbc_lblIsFeeDue.insets = new Insets(0, 0, 0, 5);
		gbc_lblIsFeeDue.gridx = 1;
		gbc_lblIsFeeDue.gridy = 2;
		center.add(lblIsFeeDue, gbc_lblIsFeeDue);
	}
}
