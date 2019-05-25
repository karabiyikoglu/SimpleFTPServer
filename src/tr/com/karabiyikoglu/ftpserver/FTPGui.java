package tr.com.karabiyikoglu.ftpserver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.BindException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

public class FTPGui extends javax.swing.JFrame implements Runnable {
	
	public static List<FtpConnection> connectionList = new ArrayList<>();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** FTP Gui Formu Olu�turuluyor */
	public FTPGui() {
		initComponents();
		root = new File(System.getProperty("user.dir"));
		loadUsers();
		loadBannedIpList();
	}

	// <editor-fold defaultstate="collapsed" desc=" Generated Code
	// ">//GEN-BEGIN:initComponents
	private void initComponents() {
		buttonGroup1 = new javax.swing.ButtonGroup();
		buttonGroup2 = new javax.swing.ButtonGroup();
		jTabbedPane1 = new javax.swing.JTabbedPane();
		jPanel1 = new javax.swing.JPanel();
		btnStart = new javax.swing.JButton();
		btnStop = new javax.swing.JButton();
		jPanel6 = new javax.swing.JPanel();
		isLocalRadio = new javax.swing.JRadioButton();
		internetmi = new javax.swing.JRadioButton();
		jPanel7 = new javax.swing.JPanel();
		urlLabel = new javax.swing.JLabel();
		jPanel8 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		uploadLabel = new javax.swing.JLabel();
		downloadLabel = new javax.swing.JLabel();
		jSeparator2 = new javax.swing.JSeparator();
		jPanel2 = new javax.swing.JPanel();
		userList = new javax.swing.JComboBox<String>();
		txtUsername = new javax.swing.JTextField();
		txtPassword = new javax.swing.JTextField();
		txtPassword2 = new javax.swing.JTextField();
		txtRootFolder = new javax.swing.JTextField();
		btnBrowse = new javax.swing.JButton();
		checkWritePermission = new javax.swing.JCheckBox();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		saveButton = new javax.swing.JButton();
		deleteButton = new javax.swing.JButton();
		jPanel3 = new javax.swing.JPanel();
		jPanel9 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		txtPortNumber = new javax.swing.JTextField();
		jLabel9 = new javax.swing.JLabel();
		cmbTimeOut = new javax.swing.JComboBox<String>();
		jPanel4 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jList1 = new javax.swing.JList<String>();
		jScrollPane2 = new javax.swing.JScrollPane();
		jList2 = new javax.swing.JList<String>();
		jLabel10 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		btnBanIp = new javax.swing.JButton();
		jPanel5 = new javax.swing.JPanel();
		jLabel12 = new javax.swing.JLabel();
		jScrollPane3 = new javax.swing.JScrollPane();
		lstBannedIP = new javax.swing.JList<String>();
		removeBanButton = new javax.swing.JButton();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenuStart = new javax.swing.JMenuItem();
		jMenuStop = new javax.swing.JMenuItem();
		jSeparator1 = new javax.swing.JSeparator();
		jMenuExit = new javax.swing.JMenuItem();
		jMenu2 = new javax.swing.JMenu();
		jMenuItem1 = new javax.swing.JMenuItem();
		jMenuItem2 = new javax.swing.JMenuItem();
		jMenuItem3 = new javax.swing.JMenuItem();
		jMenuItem4 = new javax.swing.JMenuItem();
		jMenu4 = new javax.swing.JMenu();
		jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
		jRadioButtonMenuItem2 = new javax.swing.JRadioButtonMenuItem();
		jMenu3 = new javax.swing.JMenu();
		jMenuAbout = new javax.swing.JMenuItem();

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

		btnStart.setText("Start");
		btnStart.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				startActionPerformed(evt);
			}
		});

		jPanel1.add(btnStart);
		btnStart.setBounds(70, 170, 120, 50);

		btnStop.setText("Stop");
		btnStop.setEnabled(false);
		btnStop.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				stopActionPerformed(evt);
			}
		});

		jPanel1.add(btnStop);
		btnStop.setBounds(230, 170, 120, 50);

		jPanel6.setLayout(null);

		jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Ftp Adress"));
		buttonGroup1.add(isLocalRadio);
		isLocalRadio.setSelected(true);
		isLocalRadio.setText("Localhost");
		isLocalRadio.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
		isLocalRadio.setMargin(new java.awt.Insets(0, 0, 0, 0));
		jPanel6.add(isLocalRadio);
		isLocalRadio.setBounds(30, 30, 90, 15);

		buttonGroup1.add(internetmi);
		internetmi.setText("Internet");
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
		urlLabel.setText("Stopped");
		jPanel7.add(urlLabel);
		urlLabel.setBounds(60, 20, 160, 30);

		jPanel1.add(jPanel7);
		jPanel7.setBounds(70, 10, 280, 70);

		jPanel8.setLayout(null);

		jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Uploaded - Downloaded",
				javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
		jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel2.setText("Uploaded");
		jPanel8.add(jLabel2);
		jLabel2.setBounds(40, 20, 80, 14);

		jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel3.setText("Downloaded");
		jPanel8.add(jLabel3);
		jLabel3.setBounds(170, 20, 80, 14);

		uploadLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		uploadLabel.setText("0 KB");
		jPanel8.add(uploadLabel);
		uploadLabel.setBounds(10, 50, 130, 20);

		downloadLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		downloadLabel.setText("0 KB");
		jPanel8.add(downloadLabel);
		downloadLabel.setBounds(140, 50, 130, 20);

		jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
		jPanel8.add(jSeparator2);
		jSeparator2.setBounds(140, 30, 10, 50);

		jPanel1.add(jPanel8);
		jPanel8.setBounds(70, 230, 280, 90);

		jTabbedPane1.addTab("General", jPanel1);

		jPanel2.setLayout(null);

		jPanel2.setToolTipText("Users");
		userList.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				userListItemStateChanged(evt);
			}
		});

		jPanel2.add(userList);
		userList.setBounds(180, 50, 130, 22);

		jPanel2.add(txtUsername);
		txtUsername.setBounds(150, 90, 160, 20);

		jPanel2.add(txtPassword);
		txtPassword.setBounds(150, 120, 160, 20);

		jPanel2.add(txtPassword2);
		txtPassword2.setBounds(150, 150, 160, 20);

		jPanel2.add(txtRootFolder);
		txtRootFolder.setBounds(150, 180, 160, 20);

		btnBrowse.setText("Browse");
		btnBrowse.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				browseActionPerformed(evt);
			}
		});

		jPanel2.add(btnBrowse);
		btnBrowse.setBounds(312, 180, 80, 30);

		checkWritePermission.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
		checkWritePermission.setMargin(new java.awt.Insets(0, 0, 0, 0));
		jPanel2.add(checkWritePermission);
		checkWritePermission.setBounds(216, 210, 20, 13);

		jLabel4.setText("Username :");
		jPanel2.add(jLabel4);
		jLabel4.setBounds(64, 90, 80, 20);

		jLabel5.setText("Password :");
		jPanel2.add(jLabel5);
		jLabel5.setBounds(64, 120, 80, 20);

		jLabel6.setText("Re-type Password :");
		jPanel2.add(jLabel6);
		jLabel6.setBounds(20, 150, 130, 20);

		jLabel7.setText("Root Folder :");
		jPanel2.add(jLabel7);
		jLabel7.setBounds(54, 180, 90, 20);

		jLabel8.setText("Write and Delete Permission :");
		jPanel2.add(jLabel8);
		jLabel8.setBounds(14, 210, 200, 20);

		saveButton.setText("Save");
		saveButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				saveActionPerformed(evt);
			}
		});

		jPanel2.add(saveButton);
		saveButton.setBounds(120, 270, 80, 23);

		deleteButton.setText("Delete");
		deleteButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				deleteButonActionPerformed(evt);
			}
		});

		jPanel2.add(deleteButton);
		deleteButton.setBounds(220, 270, 80, 23);

		jTabbedPane1.addTab("Users", jPanel2);

		jPanel3.setLayout(null);

		jPanel9.setLayout(null);

		jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Settings",
				javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
		jLabel1.setText("Port Number :");
		jPanel9.add(jLabel1);
		jLabel1.setBounds(50, 20, 90, 20);

		txtPortNumber.setText("21");
		jPanel9.add(txtPortNumber);
		txtPortNumber.setBounds(150, 20, 90, 20);

		jLabel9.setText("Connection Timeout :");
		jPanel9.add(jLabel9);
		jLabel9.setBounds(10, 50, 130, 20);

		cmbTimeOut.setModel(
				new javax.swing.DefaultComboBoxModel<String>(new String[] { "10 min", "20 min", "30 min", "60 min", "Unlimited" }));
		jPanel9.add(cmbTimeOut);
		cmbTimeOut.setBounds(150, 50, 110, 22);

		jPanel3.add(jPanel9);
		jPanel9.setBounds(50, 90, 300, 100);

		jTabbedPane1.addTab("Settings", jPanel3);

		jPanel4.setLayout(null);

		ipTable = new javax.swing.DefaultListModel<String>();
		jList1.setModel(ipTable);
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

		timeTable = new javax.swing.DefaultListModel<String>();
		jList2.setModel(timeTable);
		jScrollPane2.setViewportView(jList2);

		jPanel4.add(jScrollPane2);
		jScrollPane2.setBounds(190, 60, 150, 240);

		jLabel10.setText("IP Number");
		jPanel4.add(jLabel10);
		jLabel10.setBounds(60, 40, 110, 14);

		jLabel11.setText("Connected Time");
		jPanel4.add(jLabel11);
		jLabel11.setBounds(200, 40, 110, 14);

		btnBanIp.setText("IP BAN");
		btnBanIp.setEnabled(false);
		btnBanIp.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				banButonActionPerformed(evt);
			}
		});

		jPanel4.add(btnBanIp);
		btnBanIp.setBounds(70, 310, 110, 23);

		jTabbedPane1.addTab("Connections", jPanel4);

		jPanel5.setLayout(null);

		jLabel12.setText("Banned IP Numbers ");
		jPanel5.add(jLabel12);
		jLabel12.setBounds(110, 30, 150, 14);

		bannedIpTable = new javax.swing.DefaultListModel<String>();
		lstBannedIP.setModel(bannedIpTable);
		lstBannedIP.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jList3MouseClicked(evt);
			}
		});

		jScrollPane3.setViewportView(lstBannedIP);

		jPanel5.add(jScrollPane3);
		jScrollPane3.setBounds(120, 50, 140, 210);

		removeBanButton.setText("Remove");
		removeBanButton.setEnabled(false);
		removeBanButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				unbanButonActionPerformed(evt);
			}
		});

		jPanel5.add(removeBanButton);
		removeBanButton.setBounds(140, 280, 110, 23);

		jTabbedPane1.addTab("Banned IP", jPanel5);

		getContentPane().add(jTabbedPane1);
		jTabbedPane1.setBounds(30, 40, 410, 370);

		jMenu1.setText("FTP Server");
		jMenuStart.setText("Start");
		jMenuStart.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuBaslatActionPerformed(evt);
			}
		});

		jMenu1.add(jMenuStart);

		jMenuStop.setText("Stop");
		jMenuStop.setEnabled(false);
		jMenuStop.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuDurdurActionPerformed(evt);
			}
		});

		jMenu1.add(jMenuStop);

		jMenu1.add(jSeparator1);

		jMenuExit.setText("Exit");
		jMenuExit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuCikisActionPerformed(evt);
			}
		});

		jMenu1.add(jMenuExit);

		jMenuBar1.add(jMenu1);

		jMenu2.setText("View");
		jMenuItem1.setText("Users");
		jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem1ActionPerformed(evt);
			}
		});

		jMenu2.add(jMenuItem1);

		jMenuItem2.setText("Settings");
		jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem2ActionPerformed(evt);
			}
		});

		jMenu2.add(jMenuItem2);

		jMenuItem3.setText("Connections");
		jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem3ActionPerformed(evt);
			}
		});

		jMenu2.add(jMenuItem3);

		jMenuItem4.setText("Banned IP");
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
		jMenuAbout.setText("Hakk\u0131nda");
		jMenuAbout.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuHakkindaActionPerformed(evt);
			}
		});

		jMenu3.add(jMenuAbout);

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
		cumle = cumle + "Bu Program İstanbul Üniversitesi Bilgisayar Mühendisliği Bölümü\n";
		cumle = cumle
				+ "Diploma 2 Projesi kapsamında 1306020028 İsmail Karabıyıkoğlu\n tarafından yapılmıştır.\n\n2006";
		javax.swing.JOptionPane.showMessageDialog(this, cumle, "İK FTP SERVER", 1);

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
		startServer();
	}// GEN-LAST:event_jMenuBaslatActionPerformed

	private void jMenuDurdurActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuDurdurActionPerformed
		stopServer();
	}// GEN-LAST:event_jMenuDurdurActionPerformed

	private void unbanButonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_unbanButonActionPerformed
		Vector<String> ipBanList = new Vector<String>();
		try {

			FileReader fileReader = new FileReader(IConstants.FILE_IP_BAN);
			BufferedReader bufReader = new BufferedReader(fileReader);
			String line = bufReader.readLine();
			while (line != null) {
				ipBanList.addElement(line);
				line = bufReader.readLine();
			}
			bufReader.close();
			fileReader.close();
		}catch (FileNotFoundException excep) {
			System.out.println("File not found ...");
		} catch (IOException excep) {
			System.out.println("Bir \"exception\" olustu ...");
		}
		ipBanList.remove(lstBannedIP.getSelectedIndex());
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(IConstants.FILE_IP_BAN);
			PrintWriter printWriter = new PrintWriter(fileOutputStream);
			for (int i = 0; i < ipBanList.size(); i++)
				printWriter.println(ipBanList.get(i).toString());
			printWriter.close();
			fileOutputStream.close();
		}

		catch (FileNotFoundException excep) {
			System.out.println("File not found ...");
		} catch (IOException excep) {
			System.out.println("Bir \"exception\" olustu ...");
		}
		bannedIpTable.remove(lstBannedIP.getSelectedIndex());

	}// GEN-LAST:event_unbanButonActionPerformed

	private void jList3MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jList3MouseClicked
		if (bannedIpTable.getSize() > 0)
			removeBanButton.setEnabled(true);

	}// GEN-LAST:event_jList3MouseClicked

	private void banButonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_banButonActionPerformed
		if (!bannedIpTable.contains(jList1.getSelectedValue())) {
			try {
				FileOutputStream streamNesne = new FileOutputStream(IConstants.FILE_IP_BAN, true);
				PrintWriter yazdirici = new PrintWriter(streamNesne);
				yazdirici.println(jList1.getSelectedValue().toString());
				bannedIpTable.addElement(jList1.getSelectedValue().toString());
				yazdirici.close();
			}

			catch (FileNotFoundException excep) {
				System.out.println("File not found ...");
			}
		}

	}// GEN-LAST:event_banButonActionPerformed

	private void jList1FocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_jList1FocusGained

	}// GEN-LAST:event_jList1FocusGained

	private void jList1FocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_jList1FocusLost

	}// GEN-LAST:event_jList1FocusLost

	private void jList1MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jList1MouseClicked
		if (ipTable.getSize() > 0)
			btnBanIp.setEnabled(true);

	}// GEN-LAST:event_jList1MouseClicked

	private void deleteButonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_silButonActionPerformed
		Users[] temp = new Users[getUserCount()];
		try {
			int j = 0;
			FileReader fileReader = new FileReader(IConstants.FILE_USERS);
			BufferedReader bufReader = new BufferedReader(fileReader);
			String line = bufReader.readLine();
			while (line != null) {
				StringTokenizer input = new StringTokenizer(line, ",");
				temp[j++] = new Users(input.nextToken(), input.nextToken(), input.nextToken(), input.nextToken());
				line = bufReader.readLine();
			}
			bufReader.close();
		}

		catch (FileNotFoundException excep) {
			System.out.println("File not found ...");
		} catch (IOException excep) {
			System.out.println("Bir \"exception\" olustu ...");
		}
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(IConstants.FILE_USERS);
			PrintWriter printWriter = new PrintWriter(fileOutputStream);
			for (int i = 0; i < temp.length; i++) {
				if (temp[i].getUsername().equals(userList.getSelectedItem().toString()))
					continue;
				printWriter.println(temp[i].getUsername() + "," + temp[i].getPassword() + "," + temp[i].getRootFolder()
						+ "," + temp[i].isWritePermission());
			}

			printWriter.close();
		}

		catch (FileNotFoundException excep) {
			System.out.println("File not found ...");
		}

		userList.removeItemAt(userList.getSelectedIndex());
	}// GEN-LAST:event_silButonActionPerformed

	private void saveActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_kaydetActionPerformed
		String username = "", password = "", passwordConfirm = "", fileName = "";
		boolean izin = false, isNewRecord = true;
		username = txtUsername.getText();
		password = txtPassword.getText();
		passwordConfirm = txtPassword2.getText();
		fileName = txtRootFolder.getText();
		izin = checkWritePermission.isSelected();
		if (username.equals("")) {
			javax.swing.JOptionPane.showMessageDialog(this, "Enter username", "Error", 0);
		} else if (password.equals("")) {
			javax.swing.JOptionPane.showMessageDialog(this, "Enter password", "Error", 0);
		} else if (!password.equals(passwordConfirm.toString())) {
			javax.swing.JOptionPane.showMessageDialog(this, "Password not matched", "Error", 0);
		} else {
			Users[] temp = new Users[getUserCount()];
			try {
				int j = 0;
				FileReader fileReader = new FileReader(IConstants.FILE_USERS);
				BufferedReader bufReader = new BufferedReader(fileReader);
				String line = bufReader.readLine();
				while (line != null) {
					StringTokenizer input = new StringTokenizer(line, ",");
					temp[j++] = new Users(input.nextToken(), input.nextToken(), input.nextToken(), input.nextToken());
					line = bufReader.readLine();
				}
				bufReader.close();
			}

			catch (FileNotFoundException excep) {
				System.out.println("File not found ...");
			} catch (IOException excep) {
				System.out.println("Bir \"exception\" olustu ...");
			}
			try {
				FileOutputStream fileOutputStream = new FileOutputStream(IConstants.FILE_USERS);
				PrintWriter printWriter = new PrintWriter(fileOutputStream);
				for (int i = 0; i < temp.length; i++) {
					if (temp[i].getUsername().equals(username)) {
						printWriter.println(username + "," + password + "," + fileName + "," + izin);
						isNewRecord = false;
					} else {
						printWriter.println(temp[i].getUsername() + "," + temp[i].getPassword() + ","
								+ temp[i].getRootFolder() + "," + temp[i].isWritePermission());

					}
				}
				if (isNewRecord) {
					printWriter.println(username + "," + password + "," + fileName + "," + izin);
					userList.addItem(username);
				}
				printWriter.close();
				javax.swing.JOptionPane.showMessageDialog(this, "Save successfull", "Bilgi", 1);
				txtPassword.setText("");
				txtPassword2.setText("");

			}

			catch (FileNotFoundException excep) {
				System.out.println("File not found ...");
			}
		}
	}// GEN-LAST:event_kaydetActionPerformed

	private void userListItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_kul_listesiItemStateChanged
		try {
			String username = "", temp = "";
			temp = userList.getSelectedItem().toString();
			FileReader fileReader = new FileReader(IConstants.FILE_USERS);
			BufferedReader bufReader = new BufferedReader(fileReader);
			String line = bufReader.readLine();
			while (line != null) {
				StringTokenizer input = new StringTokenizer(line, ",");
				username = input.nextToken();
				if (username.equals(temp.toString())) {
					txtUsername.setText(username);
					input.nextToken();
					txtRootFolder.setText(input.nextToken());
					if (input.nextToken().equals("true"))
						checkWritePermission.setSelected(true);
					else
						checkWritePermission.setSelected(false);
				}
				line = bufReader.readLine();
			}
			bufReader.close();
		} catch (Exception hata) {
			System.out.println(hata);
		}
	}// GEN-LAST:event_kul_listesiItemStateChanged

	private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {// GEN-FIRST:event_jTabbedPane1StateChanged

	}// GEN-LAST:event_jTabbedPane1StateChanged

	private void browseActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_eklemeGozatActionPerformed
		javax.swing.JFileChooser jfilechooser = new javax.swing.JFileChooser();
		jfilechooser.setFileSelectionMode(1);
		jfilechooser.setCurrentDirectory(root);
		jfilechooser.setDialogTitle(" Choose Root Folder");
		int i = jfilechooser.showOpenDialog(this);
		if (i == 1)
			return;
		File file = jfilechooser.getSelectedFile();
		if (file != null && file.exists() && file.isDirectory()) {
			txtRootFolder.setText(file.getAbsolutePath());
			root = file;
		}
	}// GEN-LAST:event_eklemeGozatActionPerformed

	private void stopActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_DurdurActionPerformed
		stopServer();
	}// GEN-LAST:event_DurdurActionPerformed

	public void startServer() {
		serverThread = new Thread(this);
		serverThread.start();
		btnStart.setEnabled(false);
		btnStop.setEnabled(true);
		jMenuStart.setEnabled(false);
		jMenuStop.setEnabled(true);
		txtPortNumber.setEnabled(false);
		cmbTimeOut.setEnabled(false);
		isLocalRadio.setEnabled(false);
		internetmi.setEnabled(false);
		isServerStarted = true;
	}

	public void stopServer() {
		try {
			isServerStarted = false;
			if(serversocket != null) {
				serversocket.close();
			}
		} catch (Exception error) {
			System.out.println(error);
		}
		btnStart.setEnabled(true);
		btnStop.setEnabled(false);
		jMenuStart.setEnabled(true);
		jMenuStop.setEnabled(false);
		txtPortNumber.setEnabled(true);
		cmbTimeOut.setEnabled(true);
		isLocalRadio.setEnabled(true);
		internetmi.setEnabled(true);
		urlLabel.setText("Stopped");
		serverThread = null;
		for(FtpConnection ftpConnection : connectionList) {
			ftpConnection.stopConnection();
		}
		connectionList.removeAll(connectionList);
	}

	public void loadUsers() {
		userList.removeAllItems();
		try {
			String user = "";
			FileReader fileReader = new FileReader(IConstants.FILE_USERS);
			BufferedReader bufReader = new BufferedReader(fileReader);
			String line = bufReader.readLine();
			while (line != null) {
				StringTokenizer input = new StringTokenizer(line, ",");
				user = input.nextToken();
				userList.addItem(user);
				line = bufReader.readLine();
			}
			bufReader.close();
		}

		catch (FileNotFoundException excep) {
			System.out.println("File not found ...");
		} catch (IOException excep) {
			System.out.println("Bir \"exception\" olustu ...");
		}
		isLoaded = false;
	}

	public void loadBannedIpList() {
		try {

			FileReader fileReader = new FileReader(IConstants.FILE_IP_BAN);
			BufferedReader bufReader = new BufferedReader(fileReader);
			String line = bufReader.readLine();
			while (line != null) {
				bannedIpTable.addElement(line.toString());
				line = bufReader.readLine();
			}
			bufReader.close();
		}

		catch (FileNotFoundException excep) {
			System.out.println("File not found ...");
		} catch (IOException excep) {
			System.out.println("Bir \"exception\" olustu ...");
		}
	}

	public int getUserCount() {
		int sayi = 0;
		try {

			FileReader fileReader = new FileReader(IConstants.FILE_USERS);
			BufferedReader bufReader = new BufferedReader(fileReader);
			String line = bufReader.readLine();
			while (line != null) {
				sayi++;
				line = bufReader.readLine();
			}
			bufReader.close();
		}

		catch (FileNotFoundException excep) {
			System.out.println("Bu isimde bir dosya bulunamadi ...");
		} catch (IOException excep) {
			System.out.println("Bir \"exception\" olustu ...");
		}
		return sayi;
	}

	private void startActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_BaslatActionPerformed
		startServer();
	}// GEN-LAST:event_BaslatActionPerformed

	public InetAddress getIP() {
		InetAddress adres = null;
		try {
			if (isLocalRadio.isSelected()) {
				adres = InetAddress.getByName("127.0.0.1");
			} else {
				Socket socket = new Socket("www.google.com", 80);
				adres = socket.getLocalAddress();
				socket.close();
			}
		} catch (Exception hata) {
			javax.swing.JOptionPane.showMessageDialog(this, hata.getMessage(), "�K Ftp Server", 0);
		}

		return adres;
	}

	public void run() {
		try {
			InetAddress inetaddress = getIP();
			int portnum = Integer.parseInt(txtPortNumber.getText());
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
				addIpToList(socket1);
				if (bannedIpTable.contains(socket1.getInetAddress().toString())) {
					socket1.close();
					continue;
				}
				Users users[] = new Users[getUserCount()];
				try {
					int j = 0;
					FileReader fileReader = new FileReader(IConstants.FILE_USERS);
					BufferedReader bufReader = new BufferedReader(fileReader);
					String line = bufReader.readLine();
					while (line != null) {
						StringTokenizer input = new StringTokenizer(line, ",");
						String username = input.nextToken();
						if (username.equals("anonymous")) {
							input.nextToken();
							users[j++] = new Users(username, "", input.nextToken(), input.nextToken());
						} else
							users[j++] = new Users(username, input.nextToken(), input.nextToken(),
									input.nextToken());
						line = bufReader.readLine();
					}
					bufReader.close();
				}

				catch (FileNotFoundException excep) {
					System.out.println("Bu isimde bir dosya bulunamadi ...");
				} catch (IOException excep) {
					System.out.println("Bir \"exception\" olustu ...");
				}
				FtpConnection newConnection = new FtpConnection(users, socket1, inetaddress);
				connectionList.add(newConnection);
				(new Thread(newConnection)).start();
			} while (true);
		}catch(BindException exception) {
			javax.swing.JOptionPane.showMessageDialog(this, "Choose different port(greater than 1023) : "+exception.getMessage(), "İK Ftp Server", 0);
			if(isServerStarted) {
				stopServer();
			}
		}catch (SocketException exception) {
			javax.swing.JOptionPane.showMessageDialog(this, exception.getMessage(), "İK Ftp Server", 0);
			if(isServerStarted) {
				stopServer();
			}
		}catch (Exception exception) {
			javax.swing.JOptionPane.showMessageDialog(this, exception.getMessage(), "İK Ftp Server", 0);
			if(isServerStarted) {
				stopServer();
			}
		}

	}

	public void addIpToList(Socket ipsocket) {

		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("dd.MM.yyyy HH:mm");
		Calendar tarih = Calendar.getInstance();
		if (!ipTable.contains(ipsocket.getInetAddress().toString())) {
			timeTable.addElement(df.format(tarih.getTime()));
			ipTable.addElement(ipsocket.getInetAddress().toString());
		}
	}

	public static void writeUploadedInfo(String s) {
		uploadLabel.setText(s + "KB");// Kilobayt Cinsinden Toplam Upload Miktar�n� yaz�yoruz
	}

	public static void witeDownloadedInfo(String s) {
		downloadLabel.setText(s + "KB");// Kilobayt Cinsinden Toplam Download Miktar�n� yaz�yoruz
	}

	public static boolean isUnlimited() {
		if (cmbTimeOut.getSelectedItem().equals("Limitsiz"))
			return true;
		else
			return false;
	}

	public static int getTimeOut() {
		if (cmbTimeOut.getSelectedItem().equals("10 min"))
			return 10 * 60000;
		else if (cmbTimeOut.getSelectedItem().equals("20 min"))
			return 20 * 60000;
		else if (cmbTimeOut.getSelectedItem().equals("30 min"))
			return 30 * 60000;
		else if (cmbTimeOut.getSelectedItem().equals("60 min"))
			return 60 * 60000;
		else
			return 0;
	}

	File root;
	private boolean isServerStarted = false;
	public static String PA = "";
	private Thread serverThread;
	boolean isLoaded = true;
	private javax.swing.DefaultListModel<String> ipTable;
	private javax.swing.DefaultListModel<String> timeTable;
	private javax.swing.DefaultListModel<String> bannedIpTable;
	public static ServerSocket serversocket;
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnStart;
	private javax.swing.JButton btnStop;
	private javax.swing.JButton btnBanIp;
	private javax.swing.ButtonGroup buttonGroup1;
	private javax.swing.ButtonGroup buttonGroup2;
	private static javax.swing.JLabel downloadLabel;
	private javax.swing.JButton btnBrowse;
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
	private javax.swing.JList<String> jList1;
	private javax.swing.JList<String> jList2;
	private javax.swing.JList<String> lstBannedIP;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenu jMenu3;
	private javax.swing.JMenu jMenu4;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuItem jMenuStart;
	private javax.swing.JMenuItem jMenuExit;
	private javax.swing.JMenuItem jMenuStop;
	private javax.swing.JMenuItem jMenuAbout;
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
	private javax.swing.JButton saveButton;
	private javax.swing.JTextField txtRootFolder;
	private javax.swing.JComboBox<String> userList;
	private javax.swing.JTextField txtUsername;
	private javax.swing.JRadioButton isLocalRadio;
	private javax.swing.JTextField txtPortNumber;
	private javax.swing.JTextField txtPassword;
	private javax.swing.JTextField txtPassword2;
	private javax.swing.JButton deleteButton;
	private javax.swing.JButton removeBanButton;
	private static javax.swing.JLabel uploadLabel;
	private javax.swing.JLabel urlLabel;
	private javax.swing.JCheckBox checkWritePermission;
	private static javax.swing.JComboBox<String> cmbTimeOut;
	// End of variables declaration//GEN-END:variables

}
