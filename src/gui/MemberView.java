package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Dog;
import model.Member;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class MemberView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel northPanel = new JPanel();
	private final JLabel memberLabel = new JLabel("Member:");
	private final JLabel nameLabel = new JLabel("Name:");
	private final JLabel emailLabel = new JLabel("E-mail:");
	private final JLabel phoneLabel = new JLabel("Phone:");
	private final JTextField nameTextField = new JTextField();
	private final JTextField emailTextField = new JTextField();
	private final JTextField phoneTextField = new JTextField();
	private final JPanel southPanel = new JPanel();
	private final JButton cancelButton = new JButton("Cancel");
	private final JButton updateButton = new JButton("Save/Create");
	private final JPanel centerPanel = new JPanel();
	private final JScrollPane listScrollPane = new JScrollPane();
	private final JList<Dog> dogList = new JList<>();
	private DefaultListModel<Dog> dogListModel = new DefaultListModel<>();
	private Member member;
	private final JPanel centerNorthPanel = new JPanel();
	private final JLabel dogsLabel = new JLabel("Dogs:");
	private final JPanel centerSouthPanel = new JPanel();
	private final JButton btnNewButton = new JButton("New button");
	private final JButton btnNewButton_1 = new JButton("New button");
	private final JButton btnNewButton_2 = new JButton("New button");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberView frame = new MemberView(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MemberView(Member member) {
		this.member = member;
		phoneTextField.setColumns(10);
		emailTextField.setColumns(10);
		nameTextField.setColumns(10);
		DogListCellRenderer dlcr = new DogListCellRenderer();
		
		dogList.setCellRenderer(dlcr);
		initGUI();
		displayDogs();
		setMemberTextLabels(member);
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
				setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		contentPane.add(northPanel, BorderLayout.NORTH);
		GridBagLayout gbl_northPanel = new GridBagLayout();
		gbl_northPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_northPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_northPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_northPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		northPanel.setLayout(gbl_northPanel);
		
		GridBagConstraints gbc_memberLabel = new GridBagConstraints();
		gbc_memberLabel.insets = new Insets(0, 0, 5, 5);
		gbc_memberLabel.gridx = 0;
		gbc_memberLabel.gridy = 0;
		northPanel.add(memberLabel, gbc_memberLabel);
		
		GridBagConstraints gbc_nameLabel = new GridBagConstraints();
		gbc_nameLabel.anchor = GridBagConstraints.EAST;
		gbc_nameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nameLabel.gridx = 1;
		gbc_nameLabel.gridy = 1;
		northPanel.add(nameLabel, gbc_nameLabel);
		
		GridBagConstraints gbc_nameTextField = new GridBagConstraints();
		gbc_nameTextField.insets = new Insets(0, 0, 5, 0);
		gbc_nameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameTextField.gridx = 2;
		gbc_nameTextField.gridy = 1;
		northPanel.add(nameTextField, gbc_nameTextField);
		
		GridBagConstraints gbc_emailLabel = new GridBagConstraints();
		gbc_emailLabel.anchor = GridBagConstraints.EAST;
		gbc_emailLabel.insets = new Insets(0, 0, 5, 5);
		gbc_emailLabel.gridx = 1;
		gbc_emailLabel.gridy = 2;
		northPanel.add(emailLabel, gbc_emailLabel);
		
		GridBagConstraints gbc_emailTextField = new GridBagConstraints();
		gbc_emailTextField.insets = new Insets(0, 0, 5, 0);
		gbc_emailTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_emailTextField.gridx = 2;
		gbc_emailTextField.gridy = 2;
		northPanel.add(emailTextField, gbc_emailTextField);
		
		GridBagConstraints gbc_phoneLabel = new GridBagConstraints();
		gbc_phoneLabel.anchor = GridBagConstraints.EAST;
		gbc_phoneLabel.insets = new Insets(0, 0, 0, 5);
		gbc_phoneLabel.gridx = 1;
		gbc_phoneLabel.gridy = 3;
		northPanel.add(phoneLabel, gbc_phoneLabel);
		
		GridBagConstraints gbc_phoneTextField = new GridBagConstraints();
		gbc_phoneTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_phoneTextField.gridx = 2;
		gbc_phoneTextField.gridy = 3;
		northPanel.add(phoneTextField, gbc_phoneTextField);
		
		contentPane.add(southPanel, BorderLayout.SOUTH);
		southPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		updateButton.setHorizontalAlignment(SwingConstants.RIGHT);
		southPanel.add(updateButton);
		cancelButton.setHorizontalAlignment(SwingConstants.RIGHT);
		southPanel.add(cancelButton);
		
		contentPane.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout(0, 0));
		centerPanel.add(listScrollPane);
		
		listScrollPane.setViewportView(dogList);
		FlowLayout fl_centerNorthPanel = (FlowLayout) centerNorthPanel.getLayout();
		fl_centerNorthPanel.setAlignment(FlowLayout.LEFT);
		
		centerPanel.add(centerNorthPanel, BorderLayout.NORTH);
		
		centerNorthPanel.add(dogsLabel);
		FlowLayout flowLayout = (FlowLayout) centerSouthPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		centerPanel.add(centerSouthPanel, BorderLayout.SOUTH);
		
		centerSouthPanel.add(btnNewButton);
		
		centerSouthPanel.add(btnNewButton_1);
		
		centerSouthPanel.add(btnNewButton_2);
	}
	
	public void setMemberTextLabels(Member member) {
		nameTextField.setText(member.getName());
		emailTextField.setText(member.getEmail());
		phoneTextField.setText(member.getPhone());
	}
	
	public void displayDogs() {
		ArrayList<Dog> dogs = new ArrayList<>();
		dogs = member.getDogs();
		dogListModel.addAll(dogs);
		dogList.setModel(dogListModel);
	}

}
