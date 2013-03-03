package com.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.code.Direction;
import com.code.Main;
/**
 * 
 * @author Dries007
 *
 */
public class MainGui extends JFrame
{
	static final long serialVersionUID = 6543735630335188024L;
	ArrayList<String> lawnObjects = new ArrayList<String>();
	JPanel contentPane;
	JPanel panel_General;
	JPanel panel_Controls;
	JButton btnGo;
	JPanel panel_Lawn_Objects;
	JPanel panel_HQ;
	JLabel label_2;
	JTextField txtHQX;
	JLabel label_3;
	JPanel panel_Size;
	JLabel label_4;
	JTextField txtLawnX;
	JLabel label_5;
	JTextField txtLawnY;
	JCheckBox checkbxShowGui;
	JLabel label;
	JTextField txtTRuns;
	JLabel label_1;
	JTextField txtPRuns;
	JPanel panel_RunSettings_1;
	JPanel panel;
	JPanel panel_StartDirection;
	JRadioButton rdbtnUp;
	final ButtonGroup buttonGroup = new ButtonGroup();
	JRadioButton rdbtnRight;
	JRadioButton rdbtnDown;
	JRadioButton rdbtnLeft;
	JPanel panel_RobotMower;
	JLabel lblWith;
	JTextField txtWith;
	JPanel panel_Objects_Add;
	JPanel panel_Objects_List;
	JTextField txtToAddMinX;
	JLabel lblY;
	JTextField txtToAddMaxX;
	JLabel lblMinX;
	JLabel lblMinY;
	JLabel lblMaxY;
	JTextField txtToAddMinY;
	JTextField txtToAddMaxY;
	JButton btnAdd;
	JList<String> listObj;
	JButton btnRemoveSelected;
	JTextField txtHQY;
	private JLabel lblRandomTurnChance;
	private JPanel panel_2;
	private JLabel lblIn;
	private JTextField txtRnd;
	private JPanel panel_1;
	private JLabel lblPixelsPerUnit;
	private JTextField txtppu;
	private JPanel panel_3;
	private JLabel lblTimemove;
	private JTextField txTimePerMove;
	private JLabel lblMs;

	/**
	 * Create the frame.
	 */
	public MainGui()
	{
		/*
		 * DEBUG !!
		 */

		lawnObjects.add("20;20;50;50");

		/*
		 * End DEBUG
		 */

		setTitle("RoboMower");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 400, 600, 400);
		setMinimumSize(new Dimension(700, 400));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel_RunSettings = new JPanel();
		panel_RunSettings.setBorder(new TitledBorder(new EtchedBorder(), "Run settings"));
		contentPane.add(panel_RunSettings, BorderLayout.WEST);
		GridBagLayout gbl_panel_RunSettings = new GridBagLayout();
		gbl_panel_RunSettings.columnWidths = new int[] { 113, 0 };
		gbl_panel_RunSettings.rowHeights = new int[] { 51, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_RunSettings.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_RunSettings.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel_RunSettings.setLayout(gbl_panel_RunSettings);

		panel_RunSettings_1 = new JPanel();
		GridBagConstraints gbc_panel_RunSettings_1 = new GridBagConstraints();
		gbc_panel_RunSettings_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_RunSettings_1.fill = GridBagConstraints.BOTH;
		gbc_panel_RunSettings_1.gridx = 0;
		gbc_panel_RunSettings_1.gridy = 0;
		panel_RunSettings.add(panel_RunSettings_1, gbc_panel_RunSettings_1);
		GridBagLayout gbl_panel_RunSettings_1 = new GridBagLayout();
		gbl_panel_RunSettings_1.columnWidths = new int[] { 55, 46, 0 };
		gbl_panel_RunSettings_1.rowHeights = new int[] { 20, 0, 0 };
		gbl_panel_RunSettings_1.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_RunSettings_1.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_RunSettings_1.setLayout(gbl_panel_RunSettings_1);

		label = new JLabel("Total runs: ");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		panel_RunSettings_1.add(label, gbc_label);

		txtTRuns = new JTextField();
		GridBagConstraints gbc_txtTRuns = new GridBagConstraints();
		gbc_txtTRuns.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtTRuns.insets = new Insets(0, 0, 5, 0);
		gbc_txtTRuns.gridx = 1;
		gbc_txtTRuns.gridy = 0;
		panel_RunSettings_1.add(txtTRuns, gbc_txtTRuns);
		txtTRuns.setText("1");
		txtTRuns.setColumns(5);

		label_1 = new JLabel("Parallel runs:");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.WEST;
		gbc_label_1.insets = new Insets(0, 0, 0, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 1;
		panel_RunSettings_1.add(label_1, gbc_label_1);

		txtPRuns = new JTextField();
		GridBagConstraints gbc_txtPRuns = new GridBagConstraints();
		gbc_txtPRuns.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtPRuns.gridx = 1;
		gbc_txtPRuns.gridy = 1;
		panel_RunSettings_1.add(txtPRuns, gbc_txtPRuns);
		txtPRuns.setText("" + Runtime.getRuntime().availableProcessors());
		txtPRuns.setColumns(5);

		checkbxShowGui = new JCheckBox("Show GUIs");
		checkbxShowGui.setSelected(true);
		GridBagConstraints gbc_checkbxShowGui = new GridBagConstraints();
		gbc_checkbxShowGui.insets = new Insets(0, 0, 5, 0);
		gbc_checkbxShowGui.gridx = 0;
		gbc_checkbxShowGui.gridy = 1;
		panel_RunSettings.add(checkbxShowGui, gbc_checkbxShowGui);

		lblRandomTurnChance = new JLabel("Random turn chance:");
		GridBagConstraints gbc_lblRandomTurnChance = new GridBagConstraints();
		gbc_lblRandomTurnChance.insets = new Insets(0, 0, 5, 0);
		gbc_lblRandomTurnChance.gridx = 0;
		gbc_lblRandomTurnChance.gridy = 2;
		panel_RunSettings.add(lblRandomTurnChance, gbc_lblRandomTurnChance);

		panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 3;
		panel_RunSettings.add(panel_2, gbc_panel_2);

		lblIn = new JLabel("1 in ");
		panel_2.add(lblIn);

		txtRnd = new JTextField();
		txtRnd.setText("5");
		panel_2.add(txtRnd);
		txtRnd.setColumns(2);

		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 4;
		panel_RunSettings.add(panel_1, gbc_panel_1);

		lblPixelsPerUnit = new JLabel("Pixels per unit:");
		panel_1.add(lblPixelsPerUnit);

		txtppu = new JTextField();
		txtppu.setText("5");
		panel_1.add(txtppu);
		txtppu.setColumns(1);

		panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 5;
		panel_RunSettings.add(panel_3, gbc_panel_3);

		lblTimemove = new JLabel("Time/move:");
		panel_3.add(lblTimemove);

		txTimePerMove = new JTextField();
		txTimePerMove.setText("1");
		panel_3.add(txTimePerMove);
		txTimePerMove.setColumns(3);

		lblMs = new JLabel("ms");
		panel_3.add(lblMs);

		panel_General = new JPanel();
		panel_General.setBorder(new TitledBorder(new EtchedBorder(), "General"));
		contentPane.add(panel_General, BorderLayout.CENTER);
		panel_General.setLayout(new BorderLayout(0, 0));

		panel_Lawn_Objects = new JPanel();
		panel_Lawn_Objects.setBorder(new TitledBorder(new EtchedBorder(), "Objects"));
		panel_General.add(panel_Lawn_Objects, BorderLayout.CENTER);
		GridBagLayout gbl_panel_Lawn_Objects = new GridBagLayout();
		gbl_panel_Lawn_Objects.columnWidths = new int[] { 0, 0 };
		gbl_panel_Lawn_Objects.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_Lawn_Objects.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_Lawn_Objects.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panel_Lawn_Objects.setLayout(gbl_panel_Lawn_Objects);

		panel_Objects_Add = new JPanel();
		panel_Objects_Add.setBorder(new TitledBorder(new EtchedBorder(), "Add"));
		GridBagConstraints gbc_panel_Objects_Add = new GridBagConstraints();
		gbc_panel_Objects_Add.insets = new Insets(0, 0, 5, 0);
		gbc_panel_Objects_Add.fill = GridBagConstraints.BOTH;
		gbc_panel_Objects_Add.gridx = 0;
		gbc_panel_Objects_Add.gridy = 0;
		panel_Lawn_Objects.add(panel_Objects_Add, gbc_panel_Objects_Add);
		GridBagLayout gbl_panel_Objects_Add = new GridBagLayout();
		gbl_panel_Objects_Add.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel_Objects_Add.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_Objects_Add.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_Objects_Add.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_Objects_Add.setLayout(gbl_panel_Objects_Add);

		lblMinX = new JLabel("min X:");
		GridBagConstraints gbc_lblMinX = new GridBagConstraints();
		gbc_lblMinX.insets = new Insets(0, 0, 5, 5);
		gbc_lblMinX.gridx = 0;
		gbc_lblMinX.gridy = 0;
		panel_Objects_Add.add(lblMinX, gbc_lblMinX);

		txtToAddMinX = new JTextField();
		txtToAddMinX.setText("1");
		GridBagConstraints gbc_txtToAddMinX = new GridBagConstraints();
		gbc_txtToAddMinX.insets = new Insets(0, 0, 5, 5);
		gbc_txtToAddMinX.gridx = 1;
		gbc_txtToAddMinX.gridy = 0;
		panel_Objects_Add.add(txtToAddMinX, gbc_txtToAddMinX);
		txtToAddMinX.setColumns(5);

		lblMinY = new JLabel("min Y:");
		GridBagConstraints gbc_lblMinY = new GridBagConstraints();
		gbc_lblMinY.insets = new Insets(0, 0, 5, 5);
		gbc_lblMinY.gridx = 2;
		gbc_lblMinY.gridy = 0;
		panel_Objects_Add.add(lblMinY, gbc_lblMinY);

		txtToAddMinY = new JTextField();
		txtToAddMinY.setText("1");
		GridBagConstraints gbc_txtToAddMinY = new GridBagConstraints();
		gbc_txtToAddMinY.insets = new Insets(0, 0, 5, 5);
		gbc_txtToAddMinY.gridx = 3;
		gbc_txtToAddMinY.gridy = 0;
		panel_Objects_Add.add(txtToAddMinY, gbc_txtToAddMinY);
		txtToAddMinY.setColumns(5);

		lblY = new JLabel("max X:");
		GridBagConstraints gbc_lblY = new GridBagConstraints();
		gbc_lblY.insets = new Insets(0, 0, 0, 5);
		gbc_lblY.gridx = 0;
		gbc_lblY.gridy = 1;
		panel_Objects_Add.add(lblY, gbc_lblY);

		txtToAddMaxX = new JTextField();
		txtToAddMaxX.setText("1");
		GridBagConstraints gbc_txtToAddMaxX = new GridBagConstraints();
		gbc_txtToAddMaxX.insets = new Insets(0, 0, 0, 5);
		gbc_txtToAddMaxX.gridx = 1;
		gbc_txtToAddMaxX.gridy = 1;
		panel_Objects_Add.add(txtToAddMaxX, gbc_txtToAddMaxX);
		txtToAddMaxX.setColumns(5);

		lblMaxY = new JLabel("max Y:");
		GridBagConstraints gbc_lblMaxY = new GridBagConstraints();
		gbc_lblMaxY.insets = new Insets(0, 0, 0, 5);
		gbc_lblMaxY.gridx = 2;
		gbc_lblMaxY.gridy = 1;
		panel_Objects_Add.add(lblMaxY, gbc_lblMaxY);

		txtToAddMaxY = new JTextField();
		txtToAddMaxY.setText("1");
		GridBagConstraints gbc_txtToAddMaxY = new GridBagConstraints();
		gbc_txtToAddMaxY.insets = new Insets(0, 0, 0, 5);
		gbc_txtToAddMaxY.gridx = 3;
		gbc_txtToAddMaxY.gridy = 1;
		panel_Objects_Add.add(txtToAddMaxY, gbc_txtToAddMaxY);
		txtToAddMaxY.setColumns(5);

		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					int minX = Integer.parseInt(txtToAddMinX.getText());
					int minY = Integer.parseInt(txtToAddMinY.getText());
					int maxX = Integer.parseInt(txtToAddMaxX.getText());
					int maxY = Integer.parseInt(txtToAddMaxY.getText());

					lawnObjects.add(minX + ";" + minY + ";" + maxX + ";" + maxY);
					listObj.updateUI();
				}
				catch (Exception e)
				{
					txtToAddMinX.setText("");
					txtToAddMinY.setText("");
					txtToAddMaxX.setText("");
					txtToAddMaxY.setText("");
				}
			}
		});
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.gridx = 4;
		gbc_btnAdd.gridy = 1;
		panel_Objects_Add.add(btnAdd, gbc_btnAdd);

		panel_Objects_List = new JPanel();
		panel_Objects_List.setBorder(new TitledBorder(new EtchedBorder(), "List"));
		GridBagConstraints gbc_panel_Objects_List = new GridBagConstraints();
		gbc_panel_Objects_List.fill = GridBagConstraints.BOTH;
		gbc_panel_Objects_List.gridx = 0;
		gbc_panel_Objects_List.gridy = 1;
		panel_Lawn_Objects.add(panel_Objects_List, gbc_panel_Objects_List);
		panel_Objects_List.setLayout(new BorderLayout(0, 0));

		listObj = new JList<String>();
		listObj.setModel(new AbstractListModel<String>()
		{
			private static final long serialVersionUID = -929725121262949108L;

			public int getSize()
			{
				return lawnObjects.size();
			}

			public String getElementAt(int index)
			{
				return lawnObjects.get(index);
			}
		});
		panel_Objects_List.add(listObj);

		btnRemoveSelected = new JButton("Remove Selected");
		btnRemoveSelected.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if (!listObj.isSelectionEmpty())
				{
					lawnObjects.remove(listObj.getSelectedIndex());
					listObj.updateUI();
					listObj.clearSelection();
				}
			}
		});
		panel_Objects_List.add(btnRemoveSelected, BorderLayout.SOUTH);

		panel = new JPanel();
		panel_General.add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 149, 0 };
		gbl_panel.rowHeights = new int[] { 52, 0, 0, 86, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		panel_Size = new JPanel();
		GridBagConstraints gbc_panel_Size = new GridBagConstraints();
		gbc_panel_Size.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_Size.insets = new Insets(0, 0, 5, 0);
		gbc_panel_Size.gridx = 0;
		gbc_panel_Size.gridy = 0;
		panel.add(panel_Size, gbc_panel_Size);
		panel_Size.setBorder(new TitledBorder(new EtchedBorder(), "Lawn size"));

		label_4 = new JLabel("X:");
		panel_Size.add(label_4);

		txtLawnX = new JTextField();
		txtLawnX.setText("100");
		txtLawnX.setColumns(5);
		panel_Size.add(txtLawnX);

		label_5 = new JLabel("Y:");
		panel_Size.add(label_5);

		txtLawnY = new JTextField();
		txtLawnY.setText("100");
		txtLawnY.setColumns(5);
		panel_Size.add(txtLawnY);

		panel_HQ = new JPanel();
		GridBagConstraints gbc_panel_HQ = new GridBagConstraints();
		gbc_panel_HQ.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_HQ.insets = new Insets(0, 0, 5, 0);
		gbc_panel_HQ.gridx = 0;
		gbc_panel_HQ.gridy = 1;
		panel.add(panel_HQ, gbc_panel_HQ);
		panel_HQ.setBorder(new TitledBorder(new EtchedBorder(), "Base station"));

		label_2 = new JLabel("X:");
		panel_HQ.add(label_2);

		txtHQX = new JTextField();
		txtHQX.setText("0");
		txtHQX.setColumns(5);
		panel_HQ.add(txtHQX);

		label_3 = new JLabel("Y:");
		panel_HQ.add(label_3);

		txtHQY = new JTextField();
		txtHQY.setText("0");
		txtHQY.setColumns(5);
		panel_HQ.add(txtHQY);

		panel_StartDirection = new JPanel();
		GridBagConstraints gbc_panel_StartDirection = new GridBagConstraints();
		gbc_panel_StartDirection.insets = new Insets(0, 0, 5, 0);
		gbc_panel_StartDirection.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_StartDirection.gridx = 0;
		gbc_panel_StartDirection.gridy = 2;
		panel.add(panel_StartDirection, gbc_panel_StartDirection);
		panel_StartDirection.setBorder(new TitledBorder(new EtchedBorder(), "Start direction"));
		GridBagLayout gbl_panel_StartDirection = new GridBagLayout();
		gbl_panel_StartDirection.columnWidths = new int[] { -6, 4, -15, 0 };
		gbl_panel_StartDirection.rowHeights = new int[] { 23, 0, 0, 0 };
		gbl_panel_StartDirection.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_StartDirection.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_StartDirection.setLayout(gbl_panel_StartDirection);

		rdbtnUp = new JRadioButton("Up\r\n");
		buttonGroup.add(rdbtnUp);
		rdbtnUp.setSelected(true);
		GridBagConstraints gbc_rdbtnUp = new GridBagConstraints();
		gbc_rdbtnUp.anchor = GridBagConstraints.NORTH;
		gbc_rdbtnUp.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnUp.gridx = 1;
		gbc_rdbtnUp.gridy = 0;
		panel_StartDirection.add(rdbtnUp, gbc_rdbtnUp);

		rdbtnLeft = new JRadioButton("Left");
		buttonGroup.add(rdbtnLeft);
		GridBagConstraints gbc_rdbtnLeft = new GridBagConstraints();
		gbc_rdbtnLeft.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnLeft.anchor = GridBagConstraints.NORTH;
		gbc_rdbtnLeft.gridx = 0;
		gbc_rdbtnLeft.gridy = 1;
		panel_StartDirection.add(rdbtnLeft, gbc_rdbtnLeft);

		rdbtnRight = new JRadioButton("Right");
		buttonGroup.add(rdbtnRight);
		GridBagConstraints gbc_rdbtnRight = new GridBagConstraints();
		gbc_rdbtnRight.anchor = GridBagConstraints.NORTH;
		gbc_rdbtnRight.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnRight.gridx = 2;
		gbc_rdbtnRight.gridy = 1;
		panel_StartDirection.add(rdbtnRight, gbc_rdbtnRight);

		rdbtnDown = new JRadioButton("Down");
		buttonGroup.add(rdbtnDown);
		GridBagConstraints gbc_rdbtnDown = new GridBagConstraints();
		gbc_rdbtnDown.anchor = GridBagConstraints.NORTH;
		gbc_rdbtnDown.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnDown.gridx = 1;
		gbc_rdbtnDown.gridy = 2;
		panel_StartDirection.add(rdbtnDown, gbc_rdbtnDown);

		panel_RobotMower = new JPanel();
		GridBagConstraints gbc_panel_RobotMower = new GridBagConstraints();
		gbc_panel_RobotMower.anchor = GridBagConstraints.NORTH;
		gbc_panel_RobotMower.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_RobotMower.gridx = 0;
		gbc_panel_RobotMower.gridy = 3;
		panel.add(panel_RobotMower, gbc_panel_RobotMower);
		panel_RobotMower.setBorder(new TitledBorder(new EtchedBorder(), "RobotMower"));

		lblWith = new JLabel("With:");
		panel_RobotMower.add(lblWith);

		txtWith = new JTextField();
		txtWith.setText("2");
		txtWith.setColumns(5);
		panel_RobotMower.add(txtWith);

		panel_Controls = new JPanel();
		contentPane.add(panel_Controls, BorderLayout.SOUTH);
		panel_Controls.setLayout(new BorderLayout(0, 0));

		btnGo = new JButton("Go!");
		btnGo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				go();
			}
		});
		panel_Controls.add(btnGo);
	}

	public void go()
	{
		makeDisabled();

		Main main = Main.instance();

		main.sizeX = Integer.parseInt(txtLawnX.getText()) + 2;
		main.sizeY = Integer.parseInt(txtLawnY.getText()) + 2;

		main.HQx = Integer.parseInt(txtHQX.getText()) + 1;
		main.HQy = Integer.parseInt(txtHQY.getText()) + 1;

		main.runs = Integer.parseInt(txtTRuns.getText());
		main.cores = Integer.parseInt(txtPRuns.getText());
		main.with = Integer.parseInt(txtWith.getText());
		main.rnd = Integer.parseInt(txtRnd.getText());

		main.maxSize = Integer.parseInt(txtppu.getText());
		main.showGuis = checkbxShowGui.isSelected();
		main.delay = Integer.parseInt(txTimePerMove.getText());

		if (rdbtnUp.isSelected()) main.direction = Direction.North;
		else if (rdbtnRight.isSelected()) main.direction = Direction.East;
		else if (rdbtnDown.isSelected()) main.direction = Direction.South;
		else if (rdbtnLeft.isSelected()) main.direction = Direction.West;

		main.opbjects = lawnObjects;

		main.go();
		setVisible(false);
		dispose();
	}

	private void makeDisabled()
	{
		btnGo.setEnabled(false);
		btnAdd.setEnabled(false);
		btnRemoveSelected.setEnabled(false);
		txtHQX.setEnabled(false);
		txtHQY.setEnabled(false);
		txtLawnX.setEnabled(false);
		txtLawnY.setEnabled(false);
		txtPRuns.setEnabled(false);
		txtToAddMaxX.setEnabled(false);
		txtToAddMaxY.setEnabled(false);
		txtToAddMinX.setEnabled(false);
		txtToAddMinY.setEnabled(false);
		txtTRuns.setEnabled(false);
		txtWith.setEnabled(false);
		checkbxShowGui.setEnabled(false);
		rdbtnDown.setEnabled(false);
		rdbtnLeft.setEnabled(false);
		rdbtnRight.setEnabled(false);
		rdbtnUp.setEnabled(false);
		txtRnd.setEnabled(false);
	}
}
