import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FrameClass extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FrameClass() {

		initComponents();

	}

	private void initComponents() {

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		JFrame frame = new JFrame("STC HL7 HIPAA SCRUBBER");
		frame.getContentPane().setMaximumSize(new Dimension(2147483647, 100));
		frame.setSize(500, 467);
		frame.setResizable(true);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 494, 0 };
		gridBagLayout.rowHeights = new int[] { 50, 157, 50, 157, 50 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 1.0 };
		frame.getContentPane().setLayout(gridBagLayout);

		final JTextArea textArea1 = new JTextArea();
		textArea1.setSize(200, 200);

		textArea1.setLineWrap(true);
		textArea1.setVisible(true);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		frame.getContentPane().add(panel, gbc_panel);

		JButton btnPasteFromClipboard = new JButton("Paste From Clipboard");
		panel.add(btnPasteFromClipboard);
		
		
		//

		// TEXT AREA
		final JTextArea textArea = new JTextArea();
		textArea.setMaximumSize(new Dimension(300, 300));
		textArea.setMinimumSize(new Dimension(22, 22));
		textArea.setSize(200, 200);

		textArea.setLineWrap(true);

		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setMaximumSize(new Dimension(100, 32767));
		scroll.setPreferredSize(new Dimension(150, 24));
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		GridBagConstraints gbc_scroll = new GridBagConstraints();
		gbc_scroll.fill = GridBagConstraints.BOTH;
		gbc_scroll.insets = new Insets(0, 0, 5, 0);
		gbc_scroll.gridx = 0;
		gbc_scroll.gridy = 1;
		frame.getContentPane().add(scroll, gbc_scroll);

		JLabel lblInput = new JLabel("Input");
		scroll.setColumnHeaderView(lblInput);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		frame.getContentPane().add(panel_1, gbc_panel_1);

		JButton btnScrub = new JButton("Scrub");
		panel_1.add(btnScrub);

		btnPasteFromClipboard.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt, textArea, textArea1);
			}
		});
		
		btnScrub.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt, textArea, textArea1);
			}
		});

		JScrollPane scroll1 = new JScrollPane(textArea1);
		scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scroll1 = new GridBagConstraints();
		gbc_scroll1.insets = new Insets(0, 0, 5, 0);
		gbc_scroll1.fill = GridBagConstraints.BOTH;
		gbc_scroll1.gridx = 0;
		gbc_scroll1.gridy = 3;
		frame.getContentPane().add(scroll1, gbc_scroll1);

		JLabel lblOutput = new JLabel("Output");
		scroll1.setColumnHeaderView(lblOutput);

		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 4;
		frame.getContentPane().add(panel_2, gbc_panel_2);

		JButton btnNewButton = new JButton("Copy To Clipboard");
		panel_2.add(btnNewButton);
		
		btnNewButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				
				jButtonCopyToClipActionPerformed(evt, textArea, textArea1);
			}
		});
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pack();
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt, JTextArea textArea, JTextArea textArea1) {
		String input = textArea.getText();

		textArea1.setText(ScrubHL7.ValidateHL7(input));
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt, JTextArea textArea, JTextArea textArea1) {
		textArea.setText(getClipboardContents());
	}

	private void jButtonCopyToClipActionPerformed(java.awt.event.ActionEvent evt, JTextArea textArea, JTextArea textArea1) {
		String input = textArea1.getText();

		setClipboardContents(input);
	


	}

	public void setClipboardContents(String aString) {
		StringSelection stringSelection = new StringSelection(aString);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection,stringSelection);
	}

	public String getClipboardContents() {
		String result = "";
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		// odd: the Object param of getContents is not currently used
		Transferable contents = clipboard.getContents(null);
		boolean hasTransferableText = (contents != null) && contents.isDataFlavorSupported(DataFlavor.stringFlavor);
		if (hasTransferableText) {
			try {
				result = (String) contents.getTransferData(DataFlavor.stringFlavor);
			} catch (UnsupportedFlavorException ex) {
				// highly unlikely since we are using a standard DataFlavor
				System.out.println(ex);
				ex.printStackTrace();
			} catch (IOException ex) {
				System.out.println(ex);
				ex.printStackTrace();
			}
		}
		return result;
	}

}
