package ch15;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class SwingCompSet1 extends JFrame {

	private JTextField nameField;
	private JComboBox<String> countryBox;
	private JCheckBox hobbyMovieCheckBox;
	private JCheckBox hobbyReadingCheckBox;
	private JCheckBox hobbyRidingCheckBox;
	private JRadioButton maleBtn;
	private JRadioButton femaleBtn;
	private DefaultActionListener actionListener = new DefaultActionListener();

	public SwingCompSet1() {
		super("스윙 컴포넌트 세트 1");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		
		// 메뉴 작성
		createMenu();
		
		// 내용 부분 폼
		createFormPart();

		// 하단 버튼
		createButtonPart();

		pack();
	}
	
	private void createMenu() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = menuBar.add(new JMenu("파일"));
		JMenuItem saveMenuItem = fileMenu.add(new JMenuItem("저장"));
		saveMenuItem.setActionCommand("save");
		saveMenuItem.addActionListener(actionListener);
		JMenuItem exitMenuItem = fileMenu.add(new JMenuItem("종료"));
		exitMenuItem.setActionCommand("exit");
		exitMenuItem.addActionListener(actionListener);
		
		JMenu helpMenu = menuBar.add(new JMenu("도움말"));
		JMenuItem aboutMenuItem = helpMenu.add(
				new JMenuItem("스윙컴포넌트셋1은"));
		aboutMenuItem.setActionCommand("about");
		aboutMenuItem.addActionListener(actionListener);
		
		setJMenuBar(menuBar);
	}
	
	private void createFormPart() {
		JPanel formPanel = new JPanel();
		formPanel.setLayout(
				new BoxLayout(formPanel, BoxLayout.PAGE_AXIS));
		
		// 이름 영역
		formPanel.add(new JLabel("이름:"));
		nameField = new JTextField("이름을 입력하세요.");
		formPanel.add(nameField);
		nameField.setAlignmentX(Component.LEFT_ALIGNMENT);

		formPanel.add(Box.createRigidArea(new Dimension(0, 10)));

		// 국가 영역
		formPanel.add(new JLabel("국가:"));
		countryBox = new JComboBox<>();
		countryBox.addItem("한국");
		countryBox.addItem("중국");
		countryBox.addItem("일본");
		countryBox.setAlignmentX(Component.LEFT_ALIGNMENT);
		formPanel.add(countryBox);

		formPanel.add(Box.createRigidArea(new Dimension(0, 10)));

		// 취미 영역
		formPanel.add(new JLabel("취미:"));
		JPanel hobbyPanel = new JPanel();

		hobbyMovieCheckBox = new JCheckBox("영화");
		hobbyReadingCheckBox = new JCheckBox("독서");
		hobbyRidingCheckBox = new JCheckBox("자전거");

		hobbyPanel.add(hobbyMovieCheckBox);
		hobbyPanel.add(hobbyReadingCheckBox);
		hobbyPanel.add(hobbyRidingCheckBox);

		hobbyPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		formPanel.add(hobbyPanel);

		formPanel.add(Box.createRigidArea(new Dimension(0, 10)));

		// 성별 영역
		formPanel.add(new JLabel("성별:"));
		JPanel fmPanel = new JPanel();
		maleBtn = new JRadioButton("남");
		femaleBtn = new JRadioButton("여");
		ButtonGroup group = new ButtonGroup();
		group.add(maleBtn);
		group.add(femaleBtn);

		fmPanel.add(maleBtn);
		fmPanel.add(femaleBtn);
		fmPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		formPanel.add(fmPanel);

		formPanel.add(Box.createRigidArea(new Dimension(0, 10)));

		// 소개 영역
		formPanel.add(new JLabel("소개:"));
		JTextArea content = new JTextArea(5, 20);
		JScrollPane contentPane = new JScrollPane(content);
		formPanel.add(contentPane);
		contentPane.setAlignmentX(Component.LEFT_ALIGNMENT);

		formPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		add(formPanel, BorderLayout.CENTER);
	}

	private void createButtonPart() {
		JPanel btnPanel = new JPanel();
		JButton saveButton = new JButton("저장");
		btnPanel.add(saveButton);
		
		saveButton.setActionCommand("save");
		saveButton.addActionListener(actionListener);
		add(btnPanel, BorderLayout.SOUTH);
	}

	private class DefaultActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
				case "save":
					showInfo();
					break;
				case "about":
					JOptionPane.showMessageDialog(null, "SwingSet 1!!!");
					break;
				case "exit":
					exit();
					break;
			}
		}
		
		private void exit() {
			SwingCompSet1.this.dispose();
		}

		private void showInfo() {
			java.util.List<String> hobbies = new ArrayList<>();
			if (hobbyMovieCheckBox.isSelected()) {
				hobbies.add(hobbyMovieCheckBox.getText());
			}
			if (hobbyReadingCheckBox.isSelected()) {
				hobbies.add(hobbyReadingCheckBox.getText());
			}
			if (hobbyRidingCheckBox.isSelected()) {
				hobbies.add(hobbyRidingCheckBox.getText());
			}
			String message = nameField.getText() + " / "
					+ countryBox.getSelectedItem() + " / "
					+ hobbies + " / " 
					+ (maleBtn.isSelected() ? "남" : femaleBtn.isSelected() ?
					   "여" : "미지정");
			
			JOptionPane.showMessageDialog(SwingCompSet1.this, message, 
				"입력 정보", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static void main(String[] args) {
		SwingCompSet1 compset = new SwingCompSet1();
		compset.setVisible(true);
	}
	
}
