/*
 * SbApp: Open Source software for novelists and authors.
 * Original idea 2008 - 2012 Martin Mustun
 * Copyrigth (C) Favdb
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */
package storybook.ui.dialog.edit;

import com.toedter.calendar.JDateChooser;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JPanel;
import storybook.model.hbn.entity.Gender;
import storybook.model.hbn.entity.Person;
import storybook.toolkit.DateUtil;
import storybook.toolkit.I18N;
import storybook.toolkit.swing.ColorUtil;
import storybook.toolkit.swing.htmleditor.HtmlEditor;
import static storybook.ui.dialog.edit.CommonBox.findGender;
import static storybook.ui.dialog.edit.CommonBox.findPersonAbbreviation;
import static storybook.ui.dialog.edit.CommonBox.getCbCategory;
import static storybook.ui.dialog.edit.CommonBox.isMultiLbContains;
import static storybook.ui.dialog.edit.CommonBox.isCbEquals;
import static storybook.ui.dialog.edit.DlgErrorMessage.abbreviationExists;
import static storybook.ui.dialog.edit.DlgErrorMessage.mandatoryField;

/**
 *
 * @author favdb
 */
public class EditPerson extends javax.swing.JPanel {

	Editor parent;
	private Person person;
	private JDateChooser dateBirthday = new JDateChooser();
	private final CardLayout cardBirth = new CardLayout(0, 0);
	private JDateChooser dateDayOfDeath = new JDateChooser();
	private final CardLayout cardDeath = new CardLayout(0, 0);
	private final CardLayout cardText = new CardLayout(0, 0);
	private final CardLayout cardNotes = new CardLayout(0, 0);
	private final HtmlEditor notes = new HtmlEditor();
	private final HtmlEditor text = new HtmlEditor();

	/**
	 * Creates new form EditPerson2
	 */
	public EditPerson() {
		initComponents();
	}

	EditPerson(Editor e, Person p) {
		parent = e;
		person = p;
		initComponents();
		setDateField(dateBirthday, paneBirthday, "birth");
		setDateField(dateDayOfDeath, paneDayOfDeath, "death");
		paneNotes.setLayout(cardNotes);
		paneNotes.add(notes);
		cardNotes.show(paneNotes, "notes");
		paneText.setLayout(cardText);
		paneText.add(text);
		cardText.show(paneText, "text");
		initUI();
	}

	private void initUI() {
		if (person == null)
			person = createNewPerson();
		//dateBirthday.setMinimumSize(new Dimension(120, 20));
		txId.setText(person.getId() + "");
		txFirstName.setText(person.getFirstname());
		txLastName.setText(person.getLastname());
		txAbbreviation.setText(person.getAbbreviation());
		txOccupation.setText(person.getOccupation());
		dateBirthday.setDate(person.getBirthday());
		dateDayOfDeath.setDate(person.getDayofdeath());
		txColor.setBackground(ColorUtil.darker(person.getJColor(), 0.05D));
		CommonBox.loadCbCategory(parent.parent, cbCategory, person);
		CommonBox.loadCbGenders(parent.parent, cbGender, person);
		CommonBox.loadLbAttributes(parent.parent, lbAttributes, person);
		notes.setText(person.getNotes());
		text.setText(person.getDescription());
		parent.setSize(500, 325);
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
	 * content of this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txFirstName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txLastName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbGender = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cbCategory = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        btNextBirthday = new javax.swing.JButton();
        btFirstBirthday = new javax.swing.JButton();
        btLastBirthday = new javax.swing.JButton();
        btPreviousBirthday = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btLastDeath = new javax.swing.JButton();
        btPreviousDeath = new javax.swing.JButton();
        btNextDeath = new javax.swing.JButton();
        btFirstDeath = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txOccupation = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txColor = new javax.swing.JTextField();
        btColor = new javax.swing.JButton();
        btColorDelete = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txAbbreviation = new javax.swing.JTextField();
        paneDayOfDeath = new javax.swing.JPanel();
        paneBirthday = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lbAttributes = new javax.swing.JList();
        btAddAttributes = new javax.swing.JButton();
        btAttributesRemove = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        paneText = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        paneNotes = new javax.swing.JPanel();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("storybook/resources/messages"); // NOI18N
        jLabel4.setText(bundle.getString("msg.common.id")); // NOI18N

        txId.setEditable(false);
        txId.setFocusable(false);

        jLabel1.setText(bundle.getString("msg.dlg.person.firstname")); // NOI18N

        jLabel2.setText(bundle.getString("msg.dlg.person.lastname")); // NOI18N

        jLabel3.setText(bundle.getString("msg.dlg.person.gender")); // NOI18N

        cbGender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText(bundle.getString("msg.common.category")); // NOI18N

        cbCategory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText(bundle.getString("msg.dlg.person.birthday")); // NOI18N

        btNextBirthday.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storybook/resources/icons/16x16/next.png"))); // NOI18N
        btNextBirthday.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btFirstBirthday.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storybook/resources/icons/16x16/first.png"))); // NOI18N
        btFirstBirthday.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btLastBirthday.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storybook/resources/icons/16x16/last.png"))); // NOI18N
        btLastBirthday.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btPreviousBirthday.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storybook/resources/icons/16x16/previous.png"))); // NOI18N
        btPreviousBirthday.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setText(bundle.getString("msg.dlg.person.death")); // NOI18N

        btLastDeath.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storybook/resources/icons/16x16/last.png"))); // NOI18N
        btLastDeath.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btPreviousDeath.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storybook/resources/icons/16x16/previous.png"))); // NOI18N
        btPreviousDeath.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btNextDeath.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storybook/resources/icons/16x16/next.png"))); // NOI18N
        btNextDeath.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btFirstDeath.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storybook/resources/icons/16x16/first.png"))); // NOI18N
        btFirstDeath.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setText(bundle.getString("msg.dlg.person.occupation")); // NOI18N

        jLabel9.setText(bundle.getString("msg.common.color")); // NOI18N

        btColor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storybook/resources/icons/16x16/palette.png"))); // NOI18N
        btColor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btColorDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storybook/resources/icons/16x16/delete.png"))); // NOI18N
        btColorDelete.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel10.setText(bundle.getString("msg.dlg.person.abbr")); // NOI18N

        paneDayOfDeath.setBackground(new java.awt.Color(164, 155, 146));
        paneDayOfDeath.setMinimumSize(new java.awt.Dimension(120, 20));
        paneDayOfDeath.setPreferredSize(new java.awt.Dimension(140, 20));

        javax.swing.GroupLayout paneDayOfDeathLayout = new javax.swing.GroupLayout(paneDayOfDeath);
        paneDayOfDeath.setLayout(paneDayOfDeathLayout);
        paneDayOfDeathLayout.setHorizontalGroup(
            paneDayOfDeathLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );
        paneDayOfDeathLayout.setVerticalGroup(
            paneDayOfDeathLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        paneBirthday.setBackground(new java.awt.Color(164, 155, 146));
        paneBirthday.setMinimumSize(new java.awt.Dimension(120, 20));
        paneBirthday.setPreferredSize(new java.awt.Dimension(140, 20));

        javax.swing.GroupLayout paneBirthdayLayout = new javax.swing.GroupLayout(paneBirthday);
        paneBirthday.setLayout(paneBirthdayLayout);
        paneBirthdayLayout.setHorizontalGroup(
            paneBirthdayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );
        paneBirthdayLayout.setVerticalGroup(
            paneBirthdayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel9)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbGender, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txAbbreviation, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
                            .addComponent(txFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txId, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(paneDayOfDeath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(paneBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btFirstBirthday)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btPreviousBirthday)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btNextBirthday)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btLastBirthday))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(btFirstDeath)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btPreviousDeath)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btNextDeath)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btLastDeath))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txOccupation, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txColor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btColor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btColorDelete))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txAbbreviation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btNextBirthday)
                    .addComponent(jLabel6)
                    .addComponent(btLastBirthday)
                    .addComponent(btPreviousBirthday)
                    .addComponent(btFirstBirthday)
                    .addComponent(paneBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(paneDayOfDeath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btFirstDeath)
                    .addComponent(btNextDeath)
                    .addComponent(btLastDeath)
                    .addComponent(btPreviousDeath)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txOccupation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btColorDelete)
                    .addComponent(btColor)
                    .addComponent(txColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap())
        );

        jTabbedPane1.addTab(bundle.getString("msg.common"), jPanel1); // NOI18N

        lbAttributes.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lbAttributes);

        btAddAttributes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storybook/resources/icons/16x16/plus.png"))); // NOI18N

        btAttributesRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storybook/resources/icons/16x16/minus.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btAddAttributes)
                    .addComponent(btAttributesRemove))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btAddAttributes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAttributesRemove)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab(bundle.getString("msg.common.attributes"), jPanel2); // NOI18N

        javax.swing.GroupLayout paneTextLayout = new javax.swing.GroupLayout(paneText);
        paneText.setLayout(paneTextLayout);
        paneTextLayout.setHorizontalGroup(
            paneTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 492, Short.MAX_VALUE)
        );
        paneTextLayout.setVerticalGroup(
            paneTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab(bundle.getString("msg.common.description"), jPanel3); // NOI18N

        javax.swing.GroupLayout paneNotesLayout = new javax.swing.GroupLayout(paneNotes);
        paneNotes.setLayout(paneNotesLayout);
        paneNotesLayout.setHorizontalGroup(
            paneNotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 492, Short.MAX_VALUE)
        );
        paneNotesLayout.setVerticalGroup(
            paneNotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneNotes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneNotes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab(bundle.getString("msg.common.notes"), jPanel4); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddAttributes;
    private javax.swing.JButton btAttributesRemove;
    private javax.swing.JButton btColor;
    private javax.swing.JButton btColorDelete;
    private javax.swing.JButton btFirstBirthday;
    private javax.swing.JButton btFirstDeath;
    private javax.swing.JButton btLastBirthday;
    private javax.swing.JButton btLastDeath;
    private javax.swing.JButton btNextBirthday;
    private javax.swing.JButton btNextDeath;
    private javax.swing.JButton btPreviousBirthday;
    private javax.swing.JButton btPreviousDeath;
    private javax.swing.JComboBox cbCategory;
    private javax.swing.JComboBox cbGender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JList lbAttributes;
    private javax.swing.JPanel paneBirthday;
    private javax.swing.JPanel paneDayOfDeath;
    private javax.swing.JPanel paneNotes;
    private javax.swing.JPanel paneText;
    private javax.swing.JTextField txAbbreviation;
    private javax.swing.JTextField txColor;
    private javax.swing.JTextField txFirstName;
    private javax.swing.JTextField txId;
    private javax.swing.JTextField txLastName;
    private javax.swing.JTextField txOccupation;
    // End of variables declaration//GEN-END:variables

	private Person createNewPerson() {
		Person p = new Person();
		p.setFirstname("");
		p.setLastname("");
		p.setJColor(Color.LIGHT_GRAY);
		return (p);
	}

	private String DateToString(Date date) {
		if (date == null)
			return ("");
		DateFormat formatter;
		if (DateUtil.isZeroTimeDate(date)) {
			formatter = I18N.getLongDateFormatter();
			date = DateUtil.getZeroTimeDate(date);
		} else
			formatter = I18N.getDateTimeFormatter();
		return (formatter.format(date));
	}

	public boolean isModified() {
		if (!txFirstName.getText().equals(person.getFirstname()))
			return (true);
		if (!txLastName.getText().equals(person.getLastname()))
			return (true);
		if (!txAbbreviation.getText().equals(person.getAbbreviation()))
			return (true);
		if (!txOccupation.getText().equals(person.getOccupation()))
			return (true);
		if (!dateBirthday.getDate().equals(person.getBirthday()))
			return(true);
		if (!dateDayOfDeath.getDate().equals(person.getDayofdeath()))
			return(true);
		if (!txColor.getBackground().equals(ColorUtil.darker(person.getJColor(), 0.05D)))
			return (true);
		if (!isCbEquals(cbCategory, person.getCategory().getName()))
			return (true);
		if (!isCbEquals(cbGender, person.getGender().getName()))
			return (true);
		if (!isMultiLbContains(lbAttributes, person.getAttributes()))
			return (true);
		if (!notes.getText().equals(person.getNotes()))
			return (true);
		if (!text.getText().equals(person.getDescription()))
			return (true);
		return (false);
	}

	public String saveData() {
		String rt = ctrlData();
		if (rt.equals("")) {
			person.setFirstname(txFirstName.getText());
			person.setLastname(txLastName.getText());
			person.setAbbreviation(txAbbreviation.getText());
			person.setOccupation(txOccupation.getText());
			person.setBirthday(dateBirthday.getDate());
			person.setDayofdeath(dateDayOfDeath.getDate());
			person.setCategory(getCbCategory(parent.parent, cbCategory));
			Gender gender = findGender(parent.parent, cbGender.getSelectedItem().toString());
			person.setGender(gender);
		}
		return (rt);
	}

	private String ctrlData() {
		if ("".equals(txFirstName.getText()) && "".equals(txLastName.getText()))
			return (mandatoryField("msg.dlg.person.lastname"));
		if ("".equals(txAbbreviation.getText()))
			if (!"".equals(txFirstName.getText()))
				txAbbreviation.setText(txFirstName.getText().substring(0, 2));
			else if (!"".equals(txLastName.getText()))
				txAbbreviation.setText(txLastName.getText().substring(0, 2));
		if (findPersonAbbreviation(parent.parent, txAbbreviation.getText()))
			return (abbreviationExists("msg.dlg.person.abbr"));
		return ("");
	}

	private void setDateField(JDateChooser date, JPanel pane, String str) {
		CardLayout card = new CardLayout(0, 0);
		date.setMinimumSize(new Dimension(120, 20));
		date.setDateFormatString("dd/mm/yyyy");
		pane.setLayout(card);
		card.show(pane, str);
		pane.add(date);
	}

}
