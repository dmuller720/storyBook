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

import java.awt.CardLayout;
import storybook.model.hbn.entity.Idea;
import storybook.toolkit.I18N;
import storybook.toolkit.swing.htmleditor.HtmlEditor;
import static storybook.ui.dialog.edit.CommonBox.loadCbCategory;
import static storybook.ui.dialog.edit.CommonBox.loadCbStatus;
import static storybook.ui.dialog.edit.DlgErrorMessage.mandatoryField;

/**
 *
 * @author favdb
 */
public class EditIdea extends javax.swing.JPanel {

    Editor parent;
    Idea idea;
    private final CardLayout cardNotes = new CardLayout(0, 0);
    private final HtmlEditor notes = new HtmlEditor();

    /**
     * Creates new form EditIdea
     */
    public EditIdea() {
	initComponents();
    }

    EditIdea(Editor a, Idea i) {
	initComponents();
	parent = a;
	idea = i;
	paneNotes.setLayout(cardNotes);
	paneNotes.add(notes);
	cardNotes.show(paneNotes, "notes");
	initUI();
    }

    private void initUI() {
	if (idea == null) {
	    idea = createNewIdea();
	}
	loadCbCategory(parent.parent, cbCategory, idea);
	loadCbStatus(cbStatus, idea);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cbStatus = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cbCategory = new javax.swing.JComboBox();
        paneNotes = new javax.swing.JPanel();
        btStatusClear = new javax.swing.JButton();
        btCategoryClear = new javax.swing.JButton();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("storybook/resources/messages"); // NOI18N
        lbId.setText(bundle.getString("msg.common.id")); // NOI18N

        txtId.setEditable(false);

        jLabel1.setText(bundle.getString("msg.common.status")); // NOI18N

        cbStatus.setEditable(true);
        cbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText(bundle.getString("msg.common.category")); // NOI18N

        cbCategory.setEditable(true);
        cbCategory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        paneNotes.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("msg.common.notes"))); // NOI18N

        javax.swing.GroupLayout paneNotesLayout = new javax.swing.GroupLayout(paneNotes);
        paneNotes.setLayout(paneNotesLayout);
        paneNotesLayout.setHorizontalGroup(
            paneNotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        paneNotesLayout.setVerticalGroup(
            paneNotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 208, Short.MAX_VALUE)
        );

        btStatusClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storybook/resources/icons/16x16/clear.png"))); // NOI18N
        btStatusClear.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btCategoryClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storybook/resources/icons/16x16/clear.png"))); // NOI18N
        btCategoryClear.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(lbId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                        .addGap(253, 253, 253))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btStatusClear)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btCategoryClear)))
                        .addContainerGap())))
            .addComponent(paneNotes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btStatusClear)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(paneNotes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btCategoryClear)))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCategoryClear;
    private javax.swing.JButton btStatusClear;
    private javax.swing.JComboBox cbCategory;
    private javax.swing.JComboBox cbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbId;
    private javax.swing.JPanel paneNotes;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables

    private Idea createNewIdea() {
	Idea i = new Idea();
	i.setId(-1L);
	i.setStatus(0);
	i.setCategory("");
	i.setNote("");
	return (i);
    }

    boolean isModified() {
	if (idea.getStatus() != cbStatus.getSelectedIndex()) {
	    return (true);
	}
	if (!idea.getCategory().equals(cbStatus.getSelectedItem().toString())) {
	    return (true);
	}
	if (!idea.getNotes().equals(notes.getText())) {
	    return (true);
	}
	return (false);
    }

    public String getData() {
	String rt = ctrlData();
	if ("".equals(rt)) {
	    idea.setStatus(cbStatus.getSelectedIndex());
	    idea.setNotes(notes.getText());
	    idea.setCategory(cbCategory.getSelectedItem().toString());
	}
	return (rt);
    }

    private String ctrlData() {
	if (cbStatus.getSelectedIndex() == -1) {
	    return (mandatoryField(I18N.getMsg("msg.common.status")));
	}
	if ("".equals(notes.getText())) {
	    return (mandatoryField(I18N.getMsg("msg.common.notes")));
	}
	return ("");
    }
}
