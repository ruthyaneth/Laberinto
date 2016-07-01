
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.filechooser.FileNameExtensionFilter;

import config.HandlerLanguage;
import config.HandlerProperties;
import constant.ConstantsView;

/**
 * 
 * @author Jenny Paola Quesada, Ruth Yaneth Rojas.
 *
 */
public class WindowSelectionImage extends JPanel {

	// ------Atributtes------

	private static final long serialVersionUID = -2458709391434409738L;
	private JButton buttonOpenFile;
	private JFileChooser jFileChooser;
	private JLabel labelSelecedOtherMAze;
	private JLabel labelLevel;
	private JPanel panelMediumLevel;
	private JPanel panelLevelEasy;
	private JPanel panelDifficultLevel;
	private JLabel labelIamgen1L3;
	private JLabel labelImagen2L3;
	private JLabel labelImagen3L3;
	private JLabel labelImagen1L1;
	private JLabel labelImagen2L1;
	private JLabel labelImagen3L1;
	private JLabel labelImagen1L2;
	private JLabel labelImagen2L2;
	private JLabel labelImagen3L2;

	// ------Builder-------

	public WindowSelectionImage() {
		initComponents();
		myInit();
		try {
			changeLenguage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ------Methods--------

	private void initComponents() {

		this.jFileChooser = new JFileChooser();
		this.labelSelecedOtherMAze = new JLabel();
		this.setSize(700, 500);
		addPanelMediumLevel();
		this.labelImagen3L2 = new JLabel();
		this.labelImagen1L2 = new JLabel();
		this.labelImagen2L2 = new JLabel();
		this.panelLevelEasy = new JPanel();
		this.labelImagen3L1 = new JLabel();
		this.labelImagen1L1 = new JLabel();
		this.labelImagen2L1 = new JLabel();
		this.panelDifficultLevel = new JPanel();
		this.labelImagen3L3 = new JLabel();
		this.labelIamgen1L3 = new JLabel();
		this.labelImagen2L3 = new JLabel();
		this.labelLevel = new JLabel();
		this.buttonOpenFile = new JButton();

		this.labelSelecedOtherMAze.setFont(new Font("Snap ITC", 1, 18));

		this.labelSelecedOtherMAze.setText(ConstantsView.LABEL_SELECTED_OTHER_MAZE);

		this.labelImagen3L2.setBorder(BorderFactory.createEtchedBorder());
		this.labelImagen3L2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				li3MouseClicked(evt);
			}
		});

		this.labelImagen1L2.setBorder(BorderFactory.createEtchedBorder());
		this.labelImagen1L2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				li1MouseClicked(evt);
			}
		});

		this.labelImagen2L2.setBorder(BorderFactory.createEtchedBorder());
		this.labelImagen2L2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				li2MouseClicked(evt);
			}
		});

		GroupLayout layoutHorizontal = new GroupLayout(panelMediumLevel);
		this.panelMediumLevel.setLayout(layoutHorizontal);
		layoutHorizontal.setHorizontalGroup(layoutHorizontal.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING,
						layoutHorizontal.createSequentialGroup().addGap(37, 37, 37)
								.addComponent(labelImagen1L2, GroupLayout.PREFERRED_SIZE, 127,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
								.addComponent(labelImagen3L2, GroupLayout.PREFERRED_SIZE, 127,
										GroupLayout.PREFERRED_SIZE)
								.addGap(41, 41, 41))
				.addGroup(layoutHorizontal.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layoutHorizontal
								.createSequentialGroup().addGap(212, 212, 212).addComponent(labelImagen2L2,
										GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(219, Short.MAX_VALUE))));

		layoutHorizontal
				.setVerticalGroup(
						layoutHorizontal.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layoutHorizontal.createSequentialGroup().addContainerGap()
										.addGroup(layoutHorizontal.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(labelImagen1L2, GroupLayout.DEFAULT_SIZE, 100,
														Short.MAX_VALUE)
												.addComponent(labelImagen3L2, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addContainerGap())
								.addGroup(layoutHorizontal.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(layoutHorizontal.createSequentialGroup()
												.addContainerGap().addComponent(labelImagen2L2,
														GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
												.addContainerGap())));

		labelImagen3L1.setBorder(BorderFactory.createEtchedBorder());
		labelImagen3L1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				lf3MouseClicked(evt);
			}
		});

		labelImagen1L1.setBorder(BorderFactory.createEtchedBorder());
		labelImagen1L1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				lf1MouseClicked(evt);
			}
		});

		labelImagen2L1.setBorder(BorderFactory.createEtchedBorder());
		labelImagen2L1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				lf2MouseClicked(evt);
			}
		});

		GroupLayout jPanel6Layout = new GroupLayout(panelLevelEasy);
		panelLevelEasy.setLayout(jPanel6Layout);
		jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				jPanel6Layout.createSequentialGroup().addGap(37, 37, 37)
						.addComponent(labelImagen1L1, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
						.addComponent(labelImagen3L1, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
						.addGap(41, 41, 41))
				.addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(jPanel6Layout
								.createSequentialGroup().addGap(212, 212, 212).addComponent(labelImagen2L1,
										GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(219, Short.MAX_VALUE))));

		jPanel6Layout
				.setVerticalGroup(
						jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel6Layout.createSequentialGroup().addContainerGap()
										.addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(labelImagen1L1, GroupLayout.DEFAULT_SIZE, 100,
														Short.MAX_VALUE)
												.addComponent(labelImagen3L1, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addContainerGap())
								.addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(jPanel6Layout.createSequentialGroup()
												.addContainerGap().addComponent(labelImagen2L1,
														GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
												.addContainerGap())));

		this.labelImagen3L3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		this.labelImagen3L3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				ld3MouseClicked(evt);
			}
		});

		this.labelIamgen1L3.setBorder(BorderFactory.createEtchedBorder());
		this.labelIamgen1L3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				ld1MouseClicked(evt);
			}
		});

		labelImagen2L3.setBorder(BorderFactory.createEtchedBorder());
		labelImagen2L3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				ld2MouseClicked(evt);
			}
		});

		GroupLayout jPanel7Layout = new GroupLayout(panelDifficultLevel);
		panelDifficultLevel.setLayout(jPanel7Layout);
		jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING,
						jPanel7Layout.createSequentialGroup().addGap(37, 37, 37)
								.addComponent(labelIamgen1L3, GroupLayout.PREFERRED_SIZE, 127,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
								.addComponent(labelImagen3L3, GroupLayout.PREFERRED_SIZE, 127,
										GroupLayout.PREFERRED_SIZE)
								.addGap(41, 41, 41))
				.addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(jPanel7Layout
								.createSequentialGroup().addGap(212, 212, 212).addComponent(labelImagen2L3,
										GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(219, Short.MAX_VALUE))));
		jPanel7Layout
				.setVerticalGroup(
						jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel7Layout.createSequentialGroup().addContainerGap()
										.addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(labelIamgen1L3, GroupLayout.DEFAULT_SIZE, 100,
														Short.MAX_VALUE)
												.addComponent(labelImagen3L3, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addContainerGap())
								.addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(jPanel7Layout.createSequentialGroup()
												.addContainerGap().addComponent(labelImagen2L3,
														javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
												.addContainerGap())));

		this.labelLevel.setFont(new Font("Snap ITC", 1, 18));
		this.labelLevel.setForeground(new Color(0, 153, 255));

		this.buttonOpenFile.setFont(new java.awt.Font("Tahoma", 2, 18));
		this.buttonOpenFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				jButton1ActionPerformed(evt);

			}
		});

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				Alignment.TRAILING,
				layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelDifficultLevel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createSequentialGroup().addGap(22, 22, 22).addComponent(panelMediumLevel,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
						.addComponent(buttonOpenFile, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				.addGroup(GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(labelSelecedOtherMAze)
								.addGap(43, 43, 43))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(20, 20, 20)
								.addComponent(panelLevelEasy, javax.swing.GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(248, Short.MAX_VALUE)))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(20, 20, 20).addComponent(labelLevel)
								.addContainerGap(735, Short.MAX_VALUE))));

		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(214, 214, 214).addComponent(panelMediumLevel,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup().addGap(183, 183, 183)
								.addComponent(labelSelecedOtherMAze).addGap(18, 18, 18).addComponent(buttonOpenFile,
										GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(panelDifficultLevel, javax.swing.GroupLayout.PREFERRED_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(57, 57, 57)
								.addComponent(panelLevelEasy, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(325, Short.MAX_VALUE)))
				.addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
						.addGap(22, 22, 22).addComponent(labelLevel).addContainerGap(484, Short.MAX_VALUE))));

	}

	private void jButton1ActionPerformed(ActionEvent evt) {
		if (jFileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			File f = jFileChooser.getSelectedFile();
			new WinMaze(f, "Personalizado").setVisible(true);
		}
	}

	private void lf1MouseClicked(java.awt.event.MouseEvent evt) {
		new WinMaze(getClass().getResource("/img/facil2.png").getFile(), "Facil").setVisible(true);
	}

	private void lf2MouseClicked(java.awt.event.MouseEvent evt) {
		new WinMaze(getClass().getResource("/img/facil2.png").getFile(), "Facil").setVisible(true);
	}

	private void lf3MouseClicked(java.awt.event.MouseEvent evt) {
		new WinMaze(getClass().getResource("/img/labN1.png").getFile(), "Facil").setVisible(true);
	}

	private void li1MouseClicked(java.awt.event.MouseEvent evt) {
		new WinMaze(getClass().getResource("/img/inter1.png").getFile(), "Intermedio").setVisible(true);
	}

	private void li2MouseClicked(java.awt.event.MouseEvent evt) {
		new WinMaze(getClass().getResource("/img/inter2.png").getFile(), "Intermedio").setVisible(true);
	}

	private void li3MouseClicked(java.awt.event.MouseEvent evt) {
		new WinMaze(getClass().getResource("/img/labN2.png").getFile(), "Intermedio").setVisible(true);
	}

	private void ld1MouseClicked(java.awt.event.MouseEvent evt) {
		new WinMaze(getClass().getResource("/img/dificil1.png").getFile(), "Dificil").setVisible(true);
	}

	private void ld2MouseClicked(java.awt.event.MouseEvent evt) {
		new WinMaze(createFile("/img/labN3.png"), "Dificil").setVisible(true);
	}

	private void ld3MouseClicked(java.awt.event.MouseEvent evt) {
		new WinMaze(getClass().getResource("/img/labN4.png").getFile(), "Dificil").setVisible(true);
	}

	protected ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			return null;
		}
	}

	protected String createFile(String path) {
		String imgURL = WindowSelectionImage.class.getResource(path).getFile();
		if (imgURL != null) {
			return imgURL;
		} else {
			return null;
		}
	}

	private void myInit() {
		jFileChooser.setFileFilter(new FileNameExtensionFilter("Imagenes", "jpg", "png", "gif", "jpeg"));

		// Colocar imagenes
		labelImagen1L1.setIcon(new ImageIcon(F1.getImage()));
		labelImagen2L1.setIcon(new ImageIcon(F2.getImage()));
		labelImagen3L1.setIcon(new ImageIcon(F3.getImage()));
		labelImagen1L2.setIcon(new ImageIcon(I1.getImage()));
		labelImagen2L2.setIcon(new ImageIcon(I2.getImage()));
		labelImagen3L2.setIcon(new ImageIcon(I4.getImage()));
		labelIamgen1L3.setIcon(new ImageIcon(D1.getImage()));
		labelImagen2L3.setIcon(new ImageIcon(D2.getImage()));
		labelImagen3L3.setIcon(new ImageIcon(D3.getImage()));
	}

	private ImageIcon F1 = createImageIcon("/img/facil1.png");
	private ImageIcon F2 = createImageIcon("/img/facil2.png");
	private ImageIcon F3 = createImageIcon("/img/labN1.png");
	private ImageIcon I1 = createImageIcon("/img/inter1.png");
	private ImageIcon I2 = createImageIcon("/img/inter2.png");
	private ImageIcon I4 = createImageIcon("/img/labN2.png");
	private ImageIcon D1 = createImageIcon("/img/dificil1.png");
	private ImageIcon D2 = createImageIcon("/img/labN3.png");
	private ImageIcon D3 = createImageIcon("/img/labN4.png");

	private void addPanelMediumLevel() {
		this.panelMediumLevel = new JPanel();
	}

	public void changeLenguage() throws IOException {

		HandlerProperties handlerProperties = new HandlerProperties(HandlerLanguage.language);
		handlerProperties.load();
		// this.setTitle(handlerProperties.getProperty(ConstantsView.DEFAULT_TITLE_WIN_SELECTION));
		this.labelSelecedOtherMAze.setText(handlerProperties.getProperty(ConstantsView.LABEL_SELECTED_OTHER_MAZE));
		this.panelMediumLevel.setBorder(
				BorderFactory.createTitledBorder(handlerProperties.getProperty(ConstantsView.DEFAULT_BORDER_TITLE)));
		this.panelLevelEasy.setBorder(
				BorderFactory.createTitledBorder(handlerProperties.getProperty(ConstantsView.PANEL_LEVEL_EASY)));
		this.panelDifficultLevel.setBorder(
				BorderFactory.createTitledBorder(handlerProperties.getProperty(ConstantsView.PANEL_LEVEL_DIFFICULT)));
		this.labelLevel.setText(handlerProperties.getProperty(ConstantsView.DEFAULT_TTLE_NIVEL));
		this.buttonOpenFile.setText(handlerProperties.getProperty(ConstantsView.DEFAULT_TTLE_OPEN));
	}
}
