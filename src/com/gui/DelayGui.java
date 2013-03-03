package com.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.code.Main;
/**
 * 
 * @author Dries007
 *
 */
public class DelayGui extends JDialog
{
	private static final long serialVersionUID = 2050763759084102598L;
	private JTextField textField;
	private JDialog instance;

	/**
	 * Create the dialog.
	 */
	public DelayGui()
	{
		instance = this;
		this.setAlwaysOnTop(true);
		setTitle("Settings");
		setBounds(100, 100, 284, 97);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						Main.instance().delay = Integer.parseInt(textField.getText());
						instance.setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						instance.setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.CENTER);
			{
				JLabel lblTimePerMove = new JLabel("Time per move: ");
				panel.add(lblTimePerMove);
			}
			{
				textField = new JTextField();
				panel.add(textField);
				textField.setText(Main.instance().delay + "");
				textField.setColumns(5);
			}
			{
				JLabel lblMs = new JLabel("ms");
				panel.add(lblMs);
			}
		}
	}

}
