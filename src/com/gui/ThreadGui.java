package com.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.code.Main;
import com.code.MowerThread;
/**
 * 
 * @author Dries007
 *
 */
public class ThreadGui extends JFrame implements Runnable
{
	private static final long serialVersionUID = -17756349149769783L;
	/*
	 * Pixel ratio
	 */
	public static int SIZE = 10;
	public JPanel[] panes;
	private JScrollPane scrollPane;
	private JPanel panel;
	private MowerThread mower;
	public boolean init = false;
	private String name;
	private Rectangle pos;

	/**
	 * Create the frame.
	 */
	public ThreadGui(MowerThread mower, String name, Rectangle pos)
	{
		this.mower = mower;
		this.name = name;
		this.pos = pos;

		Thread thread = new Thread(this, name);
		thread.start();
	}

	@Override
	public void run()
	{
		setBounds(pos);
		Dimension size = new Dimension((Main.instance().sizeX * SIZE) + 19, (Main.instance().sizeY * SIZE) + 42);
		setTitle(name);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(size);
		
		getContentPane().setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		getContentPane().add(scrollPane);

		panel = new JPanel();
		scrollPane.setViewportView(panel);

		panes = new JPanel[Main.instance().lawn.length];

		GroupLayout layout = new GroupLayout(panel);
		panel.setLayout(layout);

		SequentialGroup pgY = layout.createSequentialGroup();
		ParallelGroup pgX = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);

		for (int y = Main.instance().sizeY - 1; y >= 0; y--)
		{
			SequentialGroup X = layout.createSequentialGroup();
			ParallelGroup Y = layout.createParallelGroup();
			for (int x = 0; x < Main.instance().sizeX; x++)
			{
				int i = (x + (Main.instance().sizeX * y));

				panes[i] = new JPanel();

				panes[i].setSize(new Dimension(SIZE, SIZE));
				panes[i].setMaximumSize(new Dimension(SIZE, SIZE));
				panes[i].setMinimumSize(new Dimension(SIZE, SIZE));
				panes[i].setBackground(mower.get(new int[] { x, y }).getColor());

				X.addComponent(panes[i]);
				Y.addComponent(panes[i]);
			}
			pgX.addGroup(X);
			pgY.addGroup(Y);
		}

		layout.setHorizontalGroup(pgX);
		layout.setVerticalGroup(pgY);

		setVisible(true);
		init = true;
	}
}
