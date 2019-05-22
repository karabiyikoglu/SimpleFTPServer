package tr.com.karabiyikoglu.ftpserver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.StringTokenizer;
import java.util.Vector;

public class FTPGui extends javax.swing.JFrame implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** FTP Gui Formu Olu�turuluyor */
	public FTPGui() {
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			javax.swing.SwingUtilities.updateComponentTreeUI(this);

		} catch (Exception e) {
			e.printStackTrace();
		}
		initComponents();
		root = new File(System.getProperty("user.dir"));
		kullaniciYukle();
		banlistesiYukle();
	}

	// <editor-fold defaultstate="collapsed" desc=" Generated Code
	// ">//GEN-BEGIN:initComponents
	private void initComponents() {
		buttonGroup1 = new javax.swing.ButtonGroup();
		buttonGroup2 = new javax.swing.ButtonGroup();
		jTabbedPane1 = new javax.swing.JTabbedPane();
		jPanel1 = new javax.swing.JPanel();
		Baslat = new javax.swing.JButton();
		Durdur = new javax.swing.JButton();
		jPanel6 = new javax.swing.JPanel();
		localmi = new javax.swing.JRadioButton();
		internetmi = new javax.swing.JRadioButton();
		jPanel7 = new javax.swing.JPanel();
		urlLabel = new javax.swing.JLabel();
		jPanel8 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		upl = new javax.swing.JLabel();
		dwl = new javax.swing.JLabel();
		jSeparator2 = new javax.swing.JSeparator();
		jPanel2 = new javax.swing.JPanel();
		kul_listesi = new javax.swing.JComboBox();
		kullaniciAlani = new javax.swing.JTextField();
		sifreAlani = new javax.swing.JTextField();
		sifretekrarAlani = new javax.swing.JTextField();
		kokklasorAlani = new javax.swing.JTextField();
		eklemeGozat = new javax.swing.JButton();
		yazmaizni = new javax.swing.JCheckBox();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		kaydet = new javax.swing.JButton();
		silButon = new javax.swing.JButton();
		jPanel3 = new javax.swing.JPanel();
		jPanel9 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		portNumarasi = new javax.swing.JTextField();
		jLabel9 = new javax.swing.JLabel();
		zamanAsimi = new javax.swing.JComboBox();
		jPanel4 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jList1 = new javax.swing.JList();
		jScrollPane2 = new javax.swing.JScrollPane();
		jList2 = new javax.swing.JList();
		jLabel10 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		banButon = new javax.swing.JButton();
		jPanel5 = new javax.swing.JPanel();
		jLabel12 = new javax.swing.JLabel();
		jScrollPane3 = new javax.swing.JScrollPane();
		jList3 = new javax.swing.JList();
		unbanButon = new javax.swing.JButton();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenuBaslat = new javax.swing.JMenuItem();
		jMenuDurdur = new javax.swing.JMenuItem();
		jSeparator1 = new javax.swing.JSeparator();
		jMenuCikis = new javax.swing.JMenuItem();
		jMenu2 = new javax.swing.JMenu();
		jMenuItem1 = new javax.swing.JMenuItem();
		jMenuItem2 = new javax.swing.JMenuItem();
		jMenuItem3 = new javax.swing.JMenuItem();
		jMenuItem4 = new javax.swing.JMenuItem();
		jMenu4 = new javax.swing.JMenu();
		jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
		jRadioButtonMenuItem2 = new javax.swing.JRadioButtonMenuItem();
		jMenu3 = new javax.swing.JMenu();
		jMenuHakkinda = new javax.swing.JMenuItem();

		getContentPane().setLayout(null);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("IK Ftp Server");
		setResizable(false);
		jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				jTabbedPane1StateChanged(evt);
			}
		});

		jPanel1.setLayout(null);

		Baslat.setText("Ba\u015flat");
		Baslat.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				BaslatActionPerformed(evt);
			}
		});

		jPanel1.add(Baslat);
		Baslat.setBounds(70, 170, 120, 50);

		Durdur.setText("Durdur");
		Durdur.setEnabled(false);
		Durdur.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				DurdurActionPerformed(evt);
			}
		});

		jPanel1.add(Durdur);
		Durdur.setBounds(230, 170, 120, 50);

		jPanel6.setLayout(null);

		jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Ftp Uygulama Yeri"));
		buttonGroup1.add(localmi);
		localmi.setSelected(true);
		localmi.setText("Localhost");
		localmi.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
		localmi.setMargin(new java.awt.Insets(0, 0, 0, 0));
		jPanel6.add(localmi);
		localmi.setBounds(30, 30, 90, 15);

		buttonGroup1.add(internetmi);
		internetmi.setText("\u0130nternet");
		internetmi.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
		internetmi.setMargin(new java.awt.Insets(0, 0, 0, 0));
		jPanel6.add(internetmi);
		internetmi.setBounds(150, 30, 80, 15);

		jPanel1.add(jPanel6);
		jPanel6.setBounds(70, 90, 280, 60);

		jPanel7.setLayout(null);

		jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Server URL"));
		urlLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
		urlLabel.setForeground(new java.awt.Color(242, 0, 0));
		urlLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		urlLabel.setText("\u00c7al\u0131\u015fm\u0131yor");
		jPanel7.add(urlLabel);
		urlLabel.setBounds(60, 20, 160, 30);

		jPanel1.add(jPanel7);
		jPanel7.setBounds(70, 10, 280, 70);

		jPanel8.setLayout(null);

		jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Y\u00fcklenen - \u0130ndirilen",
				javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
		jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel2.setText("Y\u00fcklenen");
		jPanel8.add(jLabel2);
		jLabel2.setBounds(40, 20, 80, 14);

		jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel3.setText("\u0130ndirilen");
		jPanel8.add(jLabel3);
		jLabel3.setBounds(170, 20, 80, 14);

		upl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		upl.setText("0 KB");
		jPanel8.add(upl);
		upl.setBounds(10, 50, 130, 20);

		dwl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		dwl.setText("0 KB");
		jPanel8.add(dwl);
		dwl.setBounds(140, 50, 130, 20);

		jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
		jPanel8.add(jSeparator2);
		jSeparator2.setBounds(140, 30, 10, 50);

		jPanel1.add(jPanel8);
		jPanel8.setBounds(70, 230, 280, 90);

		jTabbedPane1.addTab("Genel", jPanel1);

		jPanel2.setLayout(null);

		jPanel2.setToolTipText("Kullan\u0131c\u0131lar");
		kul_listesi.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				kul_listesiItemStateChanged(evt);
			}
		});

		jPanel2.add(kul_listesi);
		kul_listesi.setBounds(180, 50, 130, 22);

		jPanel2.add(kullaniciAlani);
		kullaniciAlani.setBounds(150, 90, 160, 20);

		jPanel2.add(sifreAlani);
		sifreAlani.setBounds(150, 120, 160, 20);

		jPanel2.add(sifretekrarAlani);
		sifretekrarAlani.setBounds(150, 150, 160, 20);

		jPanel2.add(kokklasorAlani);
		kokklasorAlani.setBounds(150, 180, 160, 20);

		eklemeGozat.setText("G\u00f6zat");
		eklemeGozat.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				eklemeGozatActionPerformed(evt);
			}
		});

		jPanel2.add(eklemeGozat);
		eklemeGozat.setBounds(320, 173, 80, 30);

		yazmaizni.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
		yazmaizni.setMargin(new java.awt.Insets(0, 0, 0, 0));
		jPanel2.add(yazmaizni);
		yazmaizni.setBounds(150, 210, 20, 13);

		jLabel4.setText("Kullan\u0131c\u0131 Ad\u0131 :");
		jPanel2.add(jLabel4);
		jLabel4.setBounds(64, 90, 80, 20);

		jLabel5.setText("\u015eifre :");
		jPanel2.add(jLabel5);
		jLabel5.setBounds(104, 120, 40, 20);

		jLabel6.setText("\u015eifre Tekrar :");
		jPanel2.add(jLabel6);
		jLabel6.setBounds(64, 150, 80, 20);

		jLabel7.setText("K\u00f6k Klas\u00f6r :");
		jPanel2.add(jLabel7);
		jLabel7.setBounds(74, 180, 70, 20);

		jLabel8.setText("Yazma ve Silme \u0130zni :");
		jPanel2.add(jLabel8);
		jLabel8.setBounds(24, 210, 120, 14);

		kaydet.setText("Kaydet");
		kaydet.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				kaydetActionPerformed(evt);
			}
		});

		jPanel2.add(kaydet);
		kaydet.setBounds(120, 270, 80, 23);

		silButon.setText("Sil");
		silButon.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				silButonActionPerformed(evt);
			}
		});

		jPanel2.add(silButon);
		silButon.setBounds(220, 270, 80, 23);

		jTabbedPane1.addTab("Kullan\u0131c\u0131lar", jPanel2);

		jPanel3.setLayout(null);

		jPanel9.setLayout(null);

		jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ayarlar",
				javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
		jLabel1.setText("Port Numaras\u0131 :");
		jPanel9.add(jLabel1);
		jLabel1.setBounds(50, 20, 90, 20);

		portNumarasi.setText("21");
		jPanel9.add(portNumarasi);
		portNumarasi.setBounds(150, 20, 90, 20);

		jLabel9.setText("Ba\u011flant\u0131 Zaman A\u015f\u0131m\u0131 :");
		jPanel9.add(jLabel9);
		jLabel9.setBounds(10, 50, 130, 20);

		zamanAsimi.setModel(
				new javax.swing.DefaultComboBoxModel(new String[] { "10 dk", "20 dk", "30 dk", "60 dk", "Limitsiz" }));
		jPanel9.add(zamanAsimi);
		zamanAsimi.setBounds(150, 50, 110, 22);

		jPanel3.add(jPanel9);
		jPanel9.setBounds(50, 90, 300, 100);

		jTabbedPane1.addTab("Ayarlar", jPanel3);

		jPanel4.setLayout(null);

		iptablosu = new javax.swing.DefaultListModel();
		jList1.setModel(iptablosu);
		jList1.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				jList1FocusGained(evt);
			}

			public void focusLost(java.awt.event.FocusEvent evt) {
				jList1FocusLost(evt);
			}
		});
		jList1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jList1MouseClicked(evt);
			}
		});

		jScrollPane1.setViewportView(jList1);

		jPanel4.add(jScrollPane1);
		jScrollPane1.setBounds(50, 60, 140, 240);

		zamantablosu = new javax.swing.DefaultListModel();
		jList2.setModel(zamantablosu);
		jScrollPane2.setViewportView(jList2);

		jPanel4.add(jScrollPane2);
		jScrollPane2.setBounds(190, 60, 150, 240);

		jLabel10.setText("IP Numaras\u0131");
		jPanel4.add(jLabel10);
		jLabel10.setBounds(60, 40, 110, 14);

		jLabel11.setText("Ba\u011flant\u0131 Zaman\u0131");
		jPanel4.add(jLabel11);
		jLabel11.setBounds(200, 40, 110, 14);

		banButon.setText("IP BAN");
		banButon.setEnabled(false);
		banButon.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				banButonActionPerformed(evt);
			}
		});

		jPanel4.add(banButon);
		banButon.setBounds(70, 310, 110, 23);

		jTabbedPane1.addTab("Ba\u011flant\u0131lar", jPanel4);

		jPanel5.setLayout(null);

		jLabel12.setText("Banlanm\u0131\u015f IP Numaralar\u0131 ");
		jPanel5.add(jLabel12);
		jLabel12.setBounds(110, 30, 150, 14);

		ipbantablosu = new javax.swing.DefaultListModel();
		jList3.setModel(ipbantablosu);
		jList3.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jList3MouseClicked(evt);
			}
		});

		jScrollPane3.setViewportView(jList3);

		jPanel5.add(jScrollPane3);
		jScrollPane3.setBounds(120, 50, 140, 210);

		unbanButon.setText("\u00c7\u0131kar");
		unbanButon.setEnabled(false);
		unbanButon.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				unbanButonActionPerformed(evt);
			}
		});

		jPanel5.add(unbanButon);
		unbanButon.setBounds(140, 280, 110, 23);

		jTabbedPane1.addTab("Banlanm\u0131\u015f IP", jPanel5);

		getContentPane().add(jTabbedPane1);
		jTabbedPane1.setBounds(30, 40, 410, 370);

		jMenu1.setText("FTP Server");
		jMenuBaslat.setText("Ba\u015flat");
		jMenuBaslat.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuBaslatActionPerformed(evt);
			}
		});

		jMenu1.add(jMenuBaslat);

		jMenuDurdur.setText("Durdur");
		jMenuDurdur.setEnabled(false);
		jMenuDurdur.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuDurdurActionPerformed(evt);
			}
		});

		jMenu1.add(jMenuDurdur);

		jMenu1.add(jSeparator1);

		jMenuCikis.setText("\u00c7\u0131k\u0131\u015f");
		jMenuCikis.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuCikisActionPerformed(evt);
			}
		});

		jMenu1.add(jMenuCikis);

		jMenuBar1.add(jMenu1);

		jMenu2.setText("D\u00fczen");
		jMenuItem1.setText("Kullan\u0131c\u0131lar");
		jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem1ActionPerformed(evt);
			}
		});

		jMenu2.add(jMenuItem1);

		jMenuItem2.setText("Ayarlar");
		jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem2ActionPerformed(evt);
			}
		});

		jMenu2.add(jMenuItem2);

		jMenuItem3.setText("Ba\u011flant\u0131lar");
		jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem3ActionPerformed(evt);
			}
		});

		jMenu2.add(jMenuItem3);

		jMenuItem4.setText("Banlanm\u0131\u015f IP");
		jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem4ActionPerformed(evt);
			}
		});

		jMenu2.add(jMenuItem4);

		jMenuBar1.add(jMenu2);

		jMenu4.setText("G\u00f6r\u00fcn\u00fcm");
		buttonGroup2.add(jRadioButtonMenuItem1);
		// jRadioButtonMenuItem1.setSelected(true);
		jRadioButtonMenuItem1.setText("Java");
		jRadioButtonMenuItem1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButtonMenuItem1ActionPerformed(evt);
			}
		});

		jMenu4.add(jRadioButtonMenuItem1);

		buttonGroup2.add(jRadioButtonMenuItem2);
		jRadioButtonMenuItem2.setSelected(true);
		jRadioButtonMenuItem2.setText("Windows");
		jRadioButtonMenuItem2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButtonMenuItem2ActionPerformed(evt);
			}
		});

		jMenu4.add(jRadioButtonMenuItem2);

		jMenuBar1.add(jMenu4);

		jMenu3.setText("Hakk\u0131nda");
		jMenuHakkinda.setText("Hakk\u0131nda");
		jMenuHakkinda.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuHakkindaActionPerformed(evt);
			}
		});

		jMenu3.add(jMenuHakkinda);

		jMenuBar1.add(jMenu3);

		setJMenuBar(jMenuBar1);

		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width - 482) / 2, (screenSize.height - 476) / 2, 482, 476);
	}// </editor-fold>//GEN-END:initComponents

	private void jRadioButtonMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jRadioButtonMenuItem1ActionPerformed
		try {
			javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			javax.swing.SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}// GEN-LAST:event_jRadioButtonMenuItem1ActionPerformed

	private void jRadioButtonMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jRadioButtonMenuItem2ActionPerformed
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			javax.swing.SwingUtilities.updateComponentTreeUI(this);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}// GEN-LAST:event_jRadioButtonMenuItem2ActionPerformed

	private void jMenuHakkindaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuHakkindaActionPerformed
		String cumle = "IK FTP SERVER PROGRAMI\n";
		cumle = cumle + "Bu Program �stanbul �niversitesi Bilgisayar M�hendisli�imi B�l�m�\n";
		cumle = cumle
				+ "Diploma 2 Projesi kapsam�nda 1306020028 �smail Karab�y�ko�lu\n taraf�ndan yap�lm��t�r.\n\n2006";
		javax.swing.JOptionPane.showMessageDialog(this, cumle, "�K FTP SERVER", 1);

	}// GEN-LAST:event_jMenuHakkindaActionPerformed

	private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem4ActionPerformed
		jTabbedPane1.setSelectedIndex(4);

	}// GEN-LAST:event_jMenuItem4ActionPerformed

	private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem3ActionPerformed
		jTabbedPane1.setSelectedIndex(3);

	}// GEN-LAST:event_jMenuItem3ActionPerformed

	private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem2ActionPerformed
		jTabbedPane1.setSelectedIndex(2);

	}// GEN-LAST:event_jMenuItem2ActionPerformed

	private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem1ActionPerformed
		jTabbedPane1.setSelectedIndex(1);

	}// GEN-LAST:event_jMenuItem1ActionPerformed

	private void jMenuCikisActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuCikisActionPerformed
		System.exit(1);

	}// GEN-LAST:event_jMenuCikisActionPerformed

	private void jMenuBaslatActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuBaslatActionPerformed
		serverBaslat();
	}// GEN-LAST:event_jMenuBaslatActionPerformed

	private void jMenuDurdurActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuDurdurActionPerformed
		serverDurdur();
	}// GEN-LAST:event_jMenuDurdurActionPerformed

	private void unbanButonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_unbanButonActionPerformed
		Vector liste = new Vector();
		try {

			FileReader okuyucuNesne = new FileReader("ipban.txt");
			BufferedReader tamponNesne = new BufferedReader(okuyucuNesne);
			String satir = tamponNesne.readLine();
			while (satir != null) {
				liste.addElement(satir);
				satir = tamponNesne.readLine();
			}
		}

		catch (FileNotFoundException excep) {
			System.out.println("Bu isimde bir dosya bulunamadi ...");
		} catch (IOException excep) {
			System.out.println("Bir \"exception\" olustu ...");
		}
		liste.remove(jList3.getSelectedIndex());
		try {
			FileOutputStream streamNesne = new FileOutputStream("ipban.txt");
			PrintWriter yazdirici = new PrintWriter(streamNesne);
			for (int i = 0; i < liste.size(); i++)
				yazdirici.println(liste.get(i).toString());
			yazdirici.close();
		}

		catch (FileNotFoundException excep) {
			System.out.println("Bu isimde bir dosya bulunamadi ...");
		} catch (IOException excep) {
			System.out.println("Bir \"exception\" olustu ...");
		}
		ipbantablosu.remove(jList3.getSelectedIndex());

	}// GEN-LAST:event_unbanButonActionPerformed

	private void jList3MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jList3MouseClicked
		if (ipbantablosu.getSize() > 0)
			unbanButon.setEnabled(true);

	}// GEN-LAST:event_jList3MouseClicked

	private void banButonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_banButonActionPerformed
		if (!ipbantablosu.contains(jList1.getSelectedValue())) {
			try {
				FileOutputStream streamNesne = new FileOutputStream("ipban.txt", true);
				PrintWriter yazdirici = new PrintWriter(streamNesne);
				yazdirici.println(jList1.getSelectedValue().toString());
				ipbantablosu.addElement(jList1.getSelectedValue().toString());
				yazdirici.close();
			}

			catch (FileNotFoundException excep) {
				System.out.println("Bu isimde bir dosya bulunamadi ...");
			} catch (IOException excep) {
				System.out.println("Bir \"exception\" olustu ...");
			}
		}

	}// GEN-LAST:event_banButonActionPerformed

	private void jList1FocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_jList1FocusGained

	}// GEN-LAST:event_jList1FocusGained

	private void jList1FocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_jList1FocusLost

	}// GEN-LAST:event_jList1FocusLost

	private void jList1MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jList1MouseClicked
		if (iptablosu.getSize() > 0)
			banButon.setEnabled(true);

	}// GEN-LAST:event_jList1MouseClicked

	private void silButonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_silButonActionPerformed
		Users[] temp = new Users[kullaniciSayisi()];
		try {
			int j = 0;
			FileReader okuyucuNesne = new FileReader("users.txt");
			BufferedReader tamponNesne = new BufferedReader(okuyucuNesne);
			String satir = tamponNesne.readLine();
			while (satir != null) {
				StringTokenizer girdi = new StringTokenizer(satir, ",");
				temp[j++] = new Users(girdi.nextToken(), girdi.nextToken(), girdi.nextToken(), girdi.nextToken());
				satir = tamponNesne.readLine();
			}
			tamponNesne.close();
		}

		catch (FileNotFoundException excep) {
			System.out.println("Bu isimde bir dosya bulunamadi ...");
		} catch (IOException excep) {
			System.out.println("Bir \"exception\" olustu ...");
		}
		try {
			FileOutputStream streamNesne = new FileOutputStream("users.txt");
			PrintWriter yazdirici = new PrintWriter(streamNesne);
			for (int i = 0; i < temp.length; i++) {
				if (temp[i].getKullanici().equals(kul_listesi.getSelectedItem().toString()))
					continue;
				yazdirici.println(temp[i].getKullanici() + "," + temp[i].getSifre() + "," + temp[i].getKok_klasor()
						+ "," + temp[i].isYazma_izni());
			}

			yazdirici.close();
		}

		catch (FileNotFoundException excep) {
			System.out.println("Bu isimde bir dosya bulunamadi ...");
		} catch (IOException excep) {
			System.out.println("Bir \"exception\" olustu ...");
		}

		kul_listesi.removeItemAt(kul_listesi.getSelectedIndex());
	}// GEN-LAST:event_silButonActionPerformed

	private void kaydetActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_kaydetActionPerformed
		String kuladi = "", sifre = "", sifretekrar = "", dosya = "";
		boolean izin = false, yenimi = true;
		kuladi = kullaniciAlani.getText();
		sifre = sifreAlani.getText();
		sifretekrar = sifretekrarAlani.getText();
		dosya = kokklasorAlani.getText();
		izin = yazmaizni.isSelected();
		if (kuladi.equals("")) {
			javax.swing.JOptionPane.showMessageDialog(this, "Kullan�c� Alani Bo� ge�ilmez", "Hata", 0);
		} else if (sifre.equals("")) {
			javax.swing.JOptionPane.showMessageDialog(this, "�ifre Alani Bo� ge�ilmez", "Hata", 0);
		} else if (!sifre.equals(sifretekrar.toString())) {
			javax.swing.JOptionPane.showMessageDialog(this, "�ifreyi Do�ru Onaylay�n", "Hata", 0);
		} else {
			Users[] temp = new Users[kullaniciSayisi()];
			try {
				int j = 0;
				FileReader okuyucuNesne = new FileReader("users.txt");
				BufferedReader tamponNesne = new BufferedReader(okuyucuNesne);
				String satir = tamponNesne.readLine();
				while (satir != null) {
					StringTokenizer girdi = new StringTokenizer(satir, ",");
					temp[j++] = new Users(girdi.nextToken(), girdi.nextToken(), girdi.nextToken(), girdi.nextToken());
					satir = tamponNesne.readLine();
				}
				tamponNesne.close();
			}

			catch (FileNotFoundException excep) {
				System.out.println("Bu isimde bir dosya bulunamadi ...");
			} catch (IOException excep) {
				System.out.println("Bir \"exception\" olustu ...");
			}
			try {
				FileOutputStream streamNesne = new FileOutputStream("users.txt");
				PrintWriter yazdirici = new PrintWriter(streamNesne);
				for (int i = 0; i < temp.length; i++) {
					if (temp[i].getKullanici().equals(kuladi)) {
						yazdirici.println(kuladi + "," + sifre + "," + dosya + "," + izin);
						yenimi = false;
					} else {
						yazdirici.println(temp[i].getKullanici() + "," + temp[i].getSifre() + ","
								+ temp[i].getKok_klasor() + "," + temp[i].isYazma_izni());

					}
				}
				if (yenimi) {
					yazdirici.println(kuladi + "," + sifre + "," + dosya + "," + izin);
					kul_listesi.addItem(kuladi);
				}
				yazdirici.close();
				javax.swing.JOptionPane.showMessageDialog(this, "Kaydedildi", "Bilgi", 1);
				sifreAlani.setText("");
				sifretekrarAlani.setText("");

			}

			catch (FileNotFoundException excep) {
				System.out.println("Bu isimde bir dosya bulunamadi ...");
			} catch (IOException excep) {
				System.out.println("Bir \"exception\" olustu ...");
			}
		}
	}// GEN-LAST:event_kaydetActionPerformed

	private void kul_listesiItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_kul_listesiItemStateChanged
		try {
			String kullanici = "", temp = "";
			temp = kul_listesi.getSelectedItem().toString();
			FileReader okuyucuNesne = new FileReader("users.txt");
			BufferedReader tamponNesne = new BufferedReader(okuyucuNesne);
			String satir = tamponNesne.readLine();
			while (satir != null) {
				StringTokenizer girdi = new StringTokenizer(satir, ",");
				kullanici = girdi.nextToken();
				if (kullanici.equals(temp.toString())) {
					kullaniciAlani.setText(kullanici);
					girdi.nextToken();
					kokklasorAlani.setText(girdi.nextToken());
					if (girdi.nextToken().equals("true"))
						yazmaizni.setSelected(true);
					else
						yazmaizni.setSelected(false);
				}
				satir = tamponNesne.readLine();
			}
		} catch (Exception hata) {
			System.out.println(hata);
		}
	}// GEN-LAST:event_kul_listesiItemStateChanged

	private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {// GEN-FIRST:event_jTabbedPane1StateChanged

	}// GEN-LAST:event_jTabbedPane1StateChanged

	private void eklemeGozatActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_eklemeGozatActionPerformed
		javax.swing.JFileChooser jfilechooser = new javax.swing.JFileChooser();
		jfilechooser.setFileSelectionMode(1);
		jfilechooser.setCurrentDirectory(root);
		jfilechooser.setDialogTitle(" Kaynak Klas�r� Se�in");
		int i = jfilechooser.showOpenDialog(this);
		if (i == 1)
			return;
		File file = jfilechooser.getSelectedFile();
		if (file != null && file.exists() && file.isDirectory()) {
			kokklasorAlani.setText(file.getAbsolutePath());
			root = file;
		}
	}// GEN-LAST:event_eklemeGozatActionPerformed

	private void DurdurActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_DurdurActionPerformed
		serverDurdur();
	}// GEN-LAST:event_DurdurActionPerformed

	public void serverBaslat() {
		thread1 = new Thread(this);
		thread1.start();
		Baslat.setEnabled(false);
		Durdur.setEnabled(true);
		jMenuBaslat.setEnabled(false);
		jMenuDurdur.setEnabled(true);
		portNumarasi.setEnabled(false);
		zamanAsimi.setEnabled(false);
		localmi.setEnabled(false);
		internetmi.setEnabled(false);
	}

	public void serverDurdur() {
		if (thread1.isAlive()) {
			thread1.stop();

		}
		try {
			serversocket.close();
		} catch (Exception hata) {
			System.out.println(hata);
		}
		Baslat.setEnabled(true);
		Durdur.setEnabled(false);
		jMenuBaslat.setEnabled(true);
		jMenuDurdur.setEnabled(false);
		portNumarasi.setEnabled(true);
		zamanAsimi.setEnabled(true);
		localmi.setEnabled(true);
		internetmi.setEnabled(true);
		urlLabel.setText("�al��m�yor");
	}

	public void kullaniciYukle() {
		kul_listesi.removeAllItems();
		try {
			String kullanici = "";
			FileReader okuyucuNesne = new FileReader("users.txt");
			BufferedReader tamponNesne = new BufferedReader(okuyucuNesne);
			String satir = tamponNesne.readLine();
			while (satir != null) {
				StringTokenizer girdi = new StringTokenizer(satir, ",");
				kullanici = girdi.nextToken();
				kul_listesi.addItem(kullanici);
				satir = tamponNesne.readLine();
			}
		}

		catch (FileNotFoundException excep) {
			System.out.println("Bu isimde bir dosya bulunamadi ...");
		} catch (IOException excep) {
			System.out.println("Bir \"exception\" olustu ...");
		}
		yuklendimi = false;
	}

	public void banlistesiYukle() {
		try {

			FileReader okuyucuNesne = new FileReader("ipban.txt");
			BufferedReader tamponNesne = new BufferedReader(okuyucuNesne);
			String satir = tamponNesne.readLine();
			while (satir != null) {
				ipbantablosu.addElement(satir.toString());
				satir = tamponNesne.readLine();
			}
		}

		catch (FileNotFoundException excep) {
			System.out.println("Bu isimde bir dosya bulunamadi ...");
		} catch (IOException excep) {
			System.out.println("Bir \"exception\" olustu ...");
		}
	}

	public int kullaniciSayisi() {
		int sayi = 0;
		try {

			FileReader okuyucuNesne = new FileReader("users.txt");
			BufferedReader tamponNesne = new BufferedReader(okuyucuNesne);
			String satir = tamponNesne.readLine();
			while (satir != null) {
				sayi++;
				satir = tamponNesne.readLine();
			}
		}

		catch (FileNotFoundException excep) {
			System.out.println("Bu isimde bir dosya bulunamadi ...");
		} catch (IOException excep) {
			System.out.println("Bir \"exception\" olustu ...");
		}
		return sayi;
	}

	private void BaslatActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_BaslatActionPerformed
		serverBaslat();
	}// GEN-LAST:event_BaslatActionPerformed

	public InetAddress getIP() {
		InetAddress adres = null;
		try {
			if (localmi.isSelected()) {
				adres = InetAddress.getByName("127.0.0.1");
			} else {
				Socket socket = new Socket("www.google.com", 80);
				adres = socket.getLocalAddress();
			}
		} catch (Exception hata) {
			javax.swing.JOptionPane.showMessageDialog(this, hata.getMessage(), "�K Ftp Server", 0);
		}

		return adres;
	}

	public void run() {
		try {
			InetAddress inetaddress = getIP();
			int portnum = Integer.parseInt(portNumarasi.getText());
			StringBuffer stringbuffer = new StringBuffer(100);
			stringbuffer.append("227 Entering Passive Mode (");
			byte abyte0[] = inetaddress.getAddress();
			int i = abyte0.length;
			for (int j = 0; j < i; j++)
				stringbuffer.append(abyte0[j] & 0xff).append(',');

			PA = stringbuffer.toString();
			serversocket = new ServerSocket(portnum, 10, inetaddress);

			stringbuffer.setLength(0);
			stringbuffer.append("ftp://");
			for (int k = 0; k < i; k++)
				stringbuffer.append(abyte0[k] & 0xff).append('.');

			stringbuffer.setLength(stringbuffer.length() - 1);
			if (portnum != 21)
				stringbuffer.append(":" + portnum + "/");
			else
				stringbuffer.append("/");
			urlLabel.setText(stringbuffer.toString());
			stringbuffer = null;
			do {
				Socket socket1 = serversocket.accept();
				ipYaz(socket1);
				if (ipbantablosu.contains(socket1.getInetAddress().toString())) {
					socket1.close();
					continue;
				}
				Users kullanicilar[] = new Users[kullaniciSayisi()];
				try {
					int j = 0;
					FileReader okuyucuNesne = new FileReader("users.txt");
					BufferedReader tamponNesne = new BufferedReader(okuyucuNesne);
					String satir = tamponNesne.readLine();
					while (satir != null) {
						StringTokenizer girdi = new StringTokenizer(satir, ",");
						String kullaniciadi = girdi.nextToken();
						if (kullaniciadi.equals("anonymous")) {
							girdi.nextToken();
							kullanicilar[j++] = new Users(kullaniciadi, "", girdi.nextToken(), girdi.nextToken());
						} else
							kullanicilar[j++] = new Users(kullaniciadi, girdi.nextToken(), girdi.nextToken(),
									girdi.nextToken());
						satir = tamponNesne.readLine();
					}
				}

				catch (FileNotFoundException excep) {
					System.out.println("Bu isimde bir dosya bulunamadi ...");
				} catch (IOException excep) {
					System.out.println("Bir \"exception\" olustu ...");
				}
				(new Thread(new FtpConnection(kullanicilar, socket1, inetaddress))).start();
			} while (true);
		} catch (Exception exception) {
			javax.swing.JOptionPane.showMessageDialog(this, exception.getMessage(), "�K Ftp Server", 0);
		}

	}

	public void ipYaz(Socket ipsocket) {

		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("dd.MM.yyyy HH:mm");
		Calendar tarih = Calendar.getInstance();
		if (!iptablosu.contains(ipsocket.getInetAddress().toString())) {
			zamantablosu.addElement(df.format(tarih.getTime()));
			iptablosu.addElement(ipsocket.getInetAddress().toString());
		}
	}

	public static void uploadyaz(String s) {
		upl.setText(s + "KB");// Kilobayt Cinsinden Toplam Upload Miktar�n� yaz�yoruz
	}

	public static void downloadyaz(String s) {
		dwl.setText(s + "KB");// Kilobayt Cinsinden Toplam Download Miktar�n� yaz�yoruz
	}

	public static boolean limitsizMi() {
		if (zamanAsimi.getSelectedItem().equals("Limitsiz"))
			return true;
		else
			return false;
	}

	public static int zaman_Asimi() {
		if (zamanAsimi.getSelectedItem().equals("10 dk"))
			return 10 * 60000;
		else if (zamanAsimi.getSelectedItem().equals("20 dk"))
			return 20 * 60000;
		else if (zamanAsimi.getSelectedItem().equals("30 dk"))
			return 30 * 60000;
		else if (zamanAsimi.getSelectedItem().equals("60 dk"))
			return 60 * 60000;
		else
			return 0;
	}

	File root;
	public static String PA = "";
	private Thread thread1;
	boolean yuklendimi = true;
	private javax.swing.DefaultListModel iptablosu;
	private javax.swing.DefaultListModel zamantablosu;
	private javax.swing.DefaultListModel ipbantablosu;
	public static ServerSocket serversocket;
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton Baslat;
	private javax.swing.JButton Durdur;
	private javax.swing.JButton banButon;
	private javax.swing.ButtonGroup buttonGroup1;
	private javax.swing.ButtonGroup buttonGroup2;
	private static javax.swing.JLabel dwl;
	private javax.swing.JButton eklemeGozat;
	private javax.swing.JRadioButton internetmi;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JList jList1;
	private javax.swing.JList jList2;
	private javax.swing.JList jList3;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenu jMenu3;
	private javax.swing.JMenu jMenu4;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuItem jMenuBaslat;
	private javax.swing.JMenuItem jMenuCikis;
	private javax.swing.JMenuItem jMenuDurdur;
	private javax.swing.JMenuItem jMenuHakkinda;
	private javax.swing.JMenuItem jMenuItem1;
	private javax.swing.JMenuItem jMenuItem2;
	private javax.swing.JMenuItem jMenuItem3;
	private javax.swing.JMenuItem jMenuItem4;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JPanel jPanel6;
	private javax.swing.JPanel jPanel7;
	private javax.swing.JPanel jPanel8;
	private javax.swing.JPanel jPanel9;
	private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
	private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JSeparator jSeparator2;
	private javax.swing.JTabbedPane jTabbedPane1;
	private javax.swing.JButton kaydet;
	private javax.swing.JTextField kokklasorAlani;
	private javax.swing.JComboBox kul_listesi;
	private javax.swing.JTextField kullaniciAlani;
	private javax.swing.JRadioButton localmi;
	private javax.swing.JTextField portNumarasi;
	private javax.swing.JTextField sifreAlani;
	private javax.swing.JTextField sifretekrarAlani;
	private javax.swing.JButton silButon;
	private javax.swing.JButton unbanButon;
	private static javax.swing.JLabel upl;
	private javax.swing.JLabel urlLabel;
	private javax.swing.JCheckBox yazmaizni;
	private static javax.swing.JComboBox zamanAsimi;
	// End of variables declaration//GEN-END:variables

}
