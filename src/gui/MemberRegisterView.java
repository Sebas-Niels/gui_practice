package gui;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberRegisterView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private MemberTableModel mtm;
	private final JPanel northPanel = new JPanel();
	private final JPanel centerPanel = new JPanel();
	private final JPanel southPanel = new JPanel();
	private final JPanel northCenterPanel = new JPanel();
	private final JPanel centerCenterPanel = new JPanel();
	private final JPanel southCenterPanel = new JPanel();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable tblMembers = new JTable();
	private final JButton btnSelect = new JButton("Select");
	private final JButton btnAddMember = new JButton("Add Member");
	private ArrayList<Member> members = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberRegisterView frame = new MemberRegisterView(null);
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
	public MemberRegisterView(ArrayList<Member> members) {
		this.members = members;
		initGUI();
		initMTM();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
				setContentPane(contentPane);
				contentPane.setLayout(new BorderLayout(0, 0));
		
		contentPane.add(northPanel, BorderLayout.NORTH);
		
		contentPane.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout(0, 0));
		
		centerPanel.add(northCenterPanel, BorderLayout.NORTH);
		
		centerPanel.add(centerCenterPanel, BorderLayout.CENTER);
		centerCenterPanel.setLayout(new BorderLayout(0, 0));
		
		centerCenterPanel.add(scrollPane, BorderLayout.CENTER);
		tblMembers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane.setViewportView(tblMembers);
		
		centerPanel.add(southCenterPanel, BorderLayout.SOUTH);
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectClicked();
			}
		});
		
		southCenterPanel.add(btnSelect);
		btnAddMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addMemberClicked();
			}
		});
		
		southCenterPanel.add(btnAddMember);
		
		contentPane.add(southPanel, BorderLayout.SOUTH);
	}
	
	public void initMTM() {
		mtm = new MemberTableModel(members);
//		Member testM = new Member("t", "t", "t");
//		mtm.add(testM);
		tblMembers.setModel(mtm);
	}
	
	public void selectClicked() {
		Member member = getSelectedMember();
		System.out.println(member);
	}
	
	private Member getSelectedMember() {
		int rowIndex = tblMembers.getSelectedRow();
		Member returnString = mtm.getDataAt(rowIndex);
		return returnString;
	}
	
	private void addMemberClicked() {
		MemberView mv = new MemberView(null);
		mv.setVisible(true);
		
//		members.add(new Member("ClickTest", "ClickTest", "ClickTest"));
//		mtm.setData(members);
	}

}
