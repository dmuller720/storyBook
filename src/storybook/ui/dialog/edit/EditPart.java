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

import storybook.model.hbn.entity.Part;
import storybook.toolkit.I18N;
import static storybook.ui.dialog.edit.DlgErrorMessage.mandatoryField;

/**
 *
 * @author favdb
 */
public class EditPart extends javax.swing.JPanel {

	private Editor parent;
	private Part part;

	/**
	 * Creates new form EditPart
	 */
	public EditPart() {
		initComponents();
	}

	public EditPart(Editor m, Part p) {
		initComponents();
		parent = m;
		part = p;
		initUI();
	}

	private void initUI() {
		if (part == null) {
			part = new Part();
			part.setId(-1L);
			txNumber.setText("");
			txName.setText("");
			return;
		}
		txID.setText(Long.toString(part.getId()));
		txNumber.setText(Integer.toString(part.getNumber()));
		txName.setText(part.getName());
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
	 * content of this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbId = new javax.swing.JLabel();
        txID = new javax.swing.JTextField();
        lbName = new javax.swing.JLabel();
        txName = new javax.swing.JTextField();
        lbNumber = new javax.swing.JLabel();
        txNumber = new javax.swing.JTextField();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("storybook/resources/messages"); // NOI18N
        lbId.setText(bundle.getString("msg.common.id")); // NOI18N

        txID.setEditable(false);
        txID.setText(" ");

        lbName.setText(bundle.getString("mag.common.name")); // NOI18N

        txName.setText(" ");

        lbNumber.setText(bundle.getString("msg.common.number")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNumber)
                    .addComponent(lbId)
                    .addComponent(lbName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txName)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txID, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 294, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbId)
                    .addComponent(txID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNumber)
                    .addComponent(txNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbName)
                    .addComponent(txName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(225, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbId;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbNumber;
    private javax.swing.JTextField txID;
    private javax.swing.JTextField txName;
    private javax.swing.JTextField txNumber;
    // End of variables declaration//GEN-END:variables

	public void set(Part p) {
		part = p;
		initUI();
	}

	public boolean isOK() {
		boolean rc = true;
		parent.setError("");
		if ((txName.getText() == null) || (txName.getText().isEmpty())) {
			parent.setError(I18N.getMsg("ERR_NAME_EMPTY"));
			rc = false;
		}
		if ((txNumber.getText() == null) || (txNumber.getText().isEmpty())) {
			parent.setError(I18N.getMsg("ERR_NUMBER_EMPTY"));
			rc = false;
		}
		int x = Integer.getInteger(txNumber.getText());
		if (x < 1) {
			parent.setError(I18N.getMsg("ERR_NUMBER_ERROR"));
			rc = false;
		}
		return (rc);
	}

	boolean isModified() {
		if (!txName.getText().equals(part.getName()))
			return (true);
		if (!txNumber.getText().equals(Integer.toString(part.getNumber())))
			return (true);
		return (false);
	}

	public String saveData() {
		String rt = ctrlData();
		if ("".equals(rt)) {
			part.setName(txName.getText());
			part.setNumber(Integer.getInteger(txNumber.getText()));
		}
		return ("");
	}

	private String ctrlData() {
		if ("".equals(txName.getText()))
			return (mandatoryField("msg.common.name"));
		if ("".equals(txNumber.getText()))
			return (mandatoryField("msg.common.number"));
		return ("");
	}

}
