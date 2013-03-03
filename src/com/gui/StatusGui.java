package com.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.code.Main;
/**
 * 
 * @author Dries007
 *
 */
public class StatusGui extends JFrame implements Runnable
{
	private static final long serialVersionUID = 9003690256395320157L;
	private JPanel contentPane;
	private JPanel panel_status;
	private JLabel lblRunsToDo;
	private JPanel panel_result;
	private JScrollPane scrollPane;
	private JList<String> list;
	private JLabel lbltxtAverage;
	private JLabel lblAverage;
	private JLabel lblRunsDone;
	private JLabel lblDone;
	private JLabel label1;
	private JLabel lblLawnSize;
	private JButton btnSettings;
	private Label label;
	private JLabel lblMax;
	private JLabel lblFree;
	private JLabel lblMEMfree;
	private JLabel lblMEMmax;
	private JLabel lblTotal;
	private JLabel lblMEMtotal;
	private Thread thread;
	private JPanel panel;
	private JButton btnSave;
	private StatusGui instance;

	/**
	 * Create the frame.
	 */
	public StatusGui()
	{
		instance = this;
		setTitle("Status");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Main.instance().mainGui.getBounds());
		setMinimumSize(new Dimension(390, 400));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panel_status = new JPanel();
		panel_status.setBorder(new TitledBorder(new EtchedBorder(), "Status"));
		contentPane.add(panel_status, BorderLayout.WEST);
		GridBagLayout gbl_panel_status = new GridBagLayout();
		gbl_panel_status.columnWidths = new int[] { 51, 46, 0 };
		gbl_panel_status.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_status.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_status.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_status.setLayout(gbl_panel_status);

		JLabel lblLabel1 = new JLabel("Runs to do:");
		GridBagConstraints gbc_lblLabel1 = new GridBagConstraints();
		gbc_lblLabel1.insets = new Insets(0, 0, 5, 5);
		gbc_lblLabel1.gridx = 0;
		gbc_lblLabel1.gridy = 0;
		panel_status.add(lblLabel1, gbc_lblLabel1);

		lblRunsToDo = new JLabel("0");
		GridBagConstraints gbc_lblRunsToDo = new GridBagConstraints();
		gbc_lblRunsToDo.insets = new Insets(0, 0, 5, 0);
		gbc_lblRunsToDo.gridx = 1;
		gbc_lblRunsToDo.gridy = 0;
		panel_status.add(lblRunsToDo, gbc_lblRunsToDo);

		lblRunsDone = new JLabel("Runs done:");
		GridBagConstraints gbc_lblRunsDone = new GridBagConstraints();
		gbc_lblRunsDone.insets = new Insets(0, 0, 5, 5);
		gbc_lblRunsDone.gridx = 0;
		gbc_lblRunsDone.gridy = 1;
		panel_status.add(lblRunsDone, gbc_lblRunsDone);

		lblDone = new JLabel("0");
		GridBagConstraints gbc_lblDone = new GridBagConstraints();
		gbc_lblDone.insets = new Insets(0, 0, 5, 0);
		gbc_lblDone.gridx = 1;
		gbc_lblDone.gridy = 1;
		panel_status.add(lblDone, gbc_lblDone);

		lbltxtAverage = new JLabel("Average:");
		GridBagConstraints gbc_lbltxtAverage = new GridBagConstraints();
		gbc_lbltxtAverage.insets = new Insets(0, 0, 5, 5);
		gbc_lbltxtAverage.gridx = 0;
		gbc_lbltxtAverage.gridy = 2;
		panel_status.add(lbltxtAverage, gbc_lbltxtAverage);

		lblAverage = new JLabel("0");
		GridBagConstraints gbc_lblAverage = new GridBagConstraints();
		gbc_lblAverage.insets = new Insets(0, 0, 5, 0);
		gbc_lblAverage.gridx = 1;
		gbc_lblAverage.gridy = 2;
		panel_status.add(lblAverage, gbc_lblAverage);

		label1 = new JLabel("Lawn size:");
		GridBagConstraints gbc_label1 = new GridBagConstraints();
		gbc_label1.insets = new Insets(0, 0, 5, 5);
		gbc_label1.gridx = 0;
		gbc_label1.gridy = 3;
		panel_status.add(label1, gbc_label1);

		lblLawnSize = new JLabel("0");
		GridBagConstraints gbc_lblLawnSize = new GridBagConstraints();
		gbc_lblLawnSize.insets = new Insets(0, 0, 5, 0);
		gbc_lblLawnSize.gridx = 1;
		gbc_lblLawnSize.gridy = 3;
		panel_status.add(lblLawnSize, gbc_lblLawnSize);

		label = new Label("Memory:");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 5;
		panel_status.add(label, gbc_label);

		lblFree = new JLabel("Free");
		GridBagConstraints gbc_lblFree = new GridBagConstraints();
		gbc_lblFree.insets = new Insets(0, 0, 5, 5);
		gbc_lblFree.gridx = 0;
		gbc_lblFree.gridy = 6;
		panel_status.add(lblFree, gbc_lblFree);

		lblMEMfree = new JLabel("0");
		GridBagConstraints gbc_lblMEMfree = new GridBagConstraints();
		gbc_lblMEMfree.insets = new Insets(0, 0, 5, 0);
		gbc_lblMEMfree.gridx = 1;
		gbc_lblMEMfree.gridy = 6;
		panel_status.add(lblMEMfree, gbc_lblMEMfree);

		lblMax = new JLabel("Max");
		GridBagConstraints gbc_lblMax = new GridBagConstraints();
		gbc_lblMax.insets = new Insets(0, 0, 5, 5);
		gbc_lblMax.gridx = 0;
		gbc_lblMax.gridy = 7;
		panel_status.add(lblMax, gbc_lblMax);

		lblMEMmax = new JLabel("0");
		GridBagConstraints gbc_lblMEMmax = new GridBagConstraints();
		gbc_lblMEMmax.insets = new Insets(0, 0, 5, 0);
		gbc_lblMEMmax.gridx = 1;
		gbc_lblMEMmax.gridy = 7;
		panel_status.add(lblMEMmax, gbc_lblMEMmax);

		lblTotal = new JLabel("Total");
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotal.gridx = 0;
		gbc_lblTotal.gridy = 8;
		panel_status.add(lblTotal, gbc_lblTotal);

		lblMEMtotal = new JLabel("0");
		GridBagConstraints gbc_lblMEMtotal = new GridBagConstraints();
		gbc_lblMEMtotal.insets = new Insets(0, 0, 5, 0);
		gbc_lblMEMtotal.gridx = 1;
		gbc_lblMEMtotal.gridy = 8;
		panel_status.add(lblMEMtotal, gbc_lblMEMtotal);

		panel_result = new JPanel();
		panel_result.setBorder(new TitledBorder(new EtchedBorder(), "Results"));
		contentPane.add(panel_result, BorderLayout.CENTER);
		panel_result.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		panel_result.add(scrollPane, BorderLayout.CENTER);

		list = new JList<String>();
		list.setModel(new AbstractListModel<String>()
		{
			private static final long serialVersionUID = -6015655738940355773L;

			public int getSize()
			{
				return Main.instance().results.size();
			}

			public String getElementAt(int index)
			{
				return "" + Main.instance().results.get(index);
			}
		});
		scrollPane.setViewportView(list);

		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		FlowLayout fl_panel = new FlowLayout(FlowLayout.LEFT, 5, 5);
		panel.setLayout(fl_panel);

		btnSettings = new JButton("Settings");
		panel.add(btnSettings);

		btnSave = new JButton("Save...");
		btnSave.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				JFileChooser fc = new JFileChooser();
				fc.setMultiSelectionEnabled(false);
				fc.setFileFilter(new FileNameExtensionFilter("text only","txt"));
				int i = fc.showSaveDialog(instance);
				if(i == JFileChooser.APPROVE_OPTION)
				{
					File file = fc.getSelectedFile();
					String filename = file.getName();
					String extension = filename.substring(filename.lastIndexOf(".") + 1, filename.length());
					
					String wantedExtension = "txt";
					if (extension.equalsIgnoreCase(wantedExtension))
					{
						Main.instance().saveData(file);
					}
					else if(extension.equals(filename))
					{
						file = new File(file.getAbsolutePath() + ".txt");
						Main.instance().saveData(file);
					}	
				}
			}
		});
		panel.add(btnSave);
		btnSettings.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				DelayGui dialog = new DelayGui();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});

		updateRunsToDo();
		setVisible(true);
		thread = new Thread(this, "SystemStats");
		thread.start();
	}

	public void updateRunsToDo()
	{
		lblDone.setText(Main.instance().runsDone + "");
		lblRunsToDo.setText(Main.instance().runs + "");
		lblLawnSize.setText(Main.instance().sizeX * Main.instance().sizeY + "");

		int sum = 0;
		for (int i : Main.instance().results)
		{
			sum = sum + i;
		}
		
		if (Main.instance().results.size() != 0) Main.instance().average = (int) (sum / Main.instance().results.size());
		lblAverage.setText("" + Main.instance().average);
		
		list.updateUI();
	}

	@Override
	public void run()
	{
		while (isVisible())
		{
			lblMEMfree.setText((int) (Runtime.getRuntime().freeMemory() / 1024 / 1024) + " MB");
			lblMEMfree.updateUI();
			lblMEMmax.setText((int) (Runtime.getRuntime().maxMemory() / 1024 / 1024) + " MB");
			lblMEMmax.updateUI();
			lblMEMtotal.setText((int) (Runtime.getRuntime().totalMemory() / 1024 / 1024) + " MB");
			lblMEMtotal.updateUI();
			
			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
