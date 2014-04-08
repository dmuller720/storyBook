/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storybook.ui.dialog.edit;

import org.hibernate.Session;
import storybook.model.BookModel;
import storybook.model.hbn.dao.GenderDAOImpl;
import storybook.model.hbn.entity.Gender;
import storybook.toolkit.I18N;
import static storybook.toolkit.TextUtil.isNumber;
import storybook.ui.MainFrame;
import static storybook.ui.dialog.edit.DlgErrorMessage.wrongFormat;

/**
 *
 * @author favdb
 */
public class EditGender extends javax.swing.JPanel {

	Editor parent;
	MainFrame mainFrame;
	Gender gender;

	/**
	 * Creates new form EditGender
	 */
	public EditGender() {
		initComponents();
	}

	public EditGender(Editor m, Gender g) {
		parent = m;
		mainFrame = parent.parent;
		gender = g;
		initUI();
	}

	private void initUI() {
		if (gender != null) {
			txtId.setText(Long.toString(gender.getId()));
			txName.setText(gender.getName());
			txChildhood.setText(Integer.toString(gender.getChildhood()));
			txAdolescence.setText(Integer.toString(gender.getAdolescence()));
			txAdulthood.setText(Integer.toString(gender.getAdulthood()));
			txRetirement.setText(Integer.toString(gender.getRetirement()));
		} else
			gender = createNewGender();
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
        btIcon = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txChildhood = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txAdolescence = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txAdulthood = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txRetirement = new javax.swing.JTextField();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("storybook/resources/messages"); // NOI18N
        lbId.setText(bundle.getString("msg.common.id")); // NOI18N

        txtId.setEditable(false);

        jLabel1.setText(bundle.getString("msg.common.icon")); // NOI18N

        btIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storybook/resources/icons/16x16/person.png"))); // NOI18N

        jLabel2.setText(bundle.getString("msg.common.gender")); // NOI18N

        jLabel3.setText(bundle.getString("msg.chart.gantt.childhood")); // NOI18N

        jLabel4.setText(bundle.getString("msg.chart.gantt.adolescence")); // NOI18N

        jLabel5.setText(bundle.getString("msg.chart.gantt.adulthood")); // NOI18N

        jLabel6.setText(bundle.getString("msg.chart.gantt.retirement")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                        .addGap(289, 289, 289))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txName)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(23, 23, 23)
                                .addComponent(txAdulthood, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btIcon))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txRetirement))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txChildhood, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                                    .addComponent(txAdolescence))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(btIcon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txChildhood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txAdolescence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txAdulthood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txRetirement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btIcon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lbId;
    private javax.swing.JTextField txAdolescence;
    private javax.swing.JTextField txAdulthood;
    private javax.swing.JTextField txChildhood;
    private javax.swing.JTextField txName;
    private javax.swing.JTextField txRetirement;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables

	public void set(Gender g) {
		gender = g;
		initUI();
	}

	public boolean isOK() {
		boolean rc = true;
		return (rc);
	}

	private Gender createNewGender() {
		BookModel model = mainFrame.getDocumentModel();
		Session session = model.beginTransaction();
		GenderDAOImpl dao = new GenderDAOImpl(session);
		model.commit();
		Gender rgender = new Gender();
		return (rgender);
	}

	public boolean isModified() {
		boolean rc = false;
		if (!txChildhood.getText().equals(Integer.toString(gender.getChildhood())))
			return (true);
		if (!txAdolescence.getText().equals(Integer.toString(gender.getAdolescence())))
			return (true);
		if (!txAdulthood.getText().equals(Integer.toString(gender.getAdulthood())))
			return (true);
		if (!txRetirement.getText().equals(Integer.toString(gender.getRetirement())))
			return (true);
		return (rc);
	}

	public String saveData() {
		String rt = ctrlData();
		if ("".equals(rt)) {
			gender.setChildhood(Integer.getInteger(txChildhood.getText()));
			gender.setAdolescence(Integer.getInteger(txAdolescence.getText()));
			gender.setAdulthood(Integer.getInteger(txAdulthood.getText()));
			gender.setRetirement(Integer.getInteger(txRetirement.getText()));
		}
		return (rt);
	}

	private String ctrlData() {
		if (!isNumber(txChildhood.getText()))
			return (wrongFormat(I18N.getMsg("msg.chart.gantt.childhood")));
		if (!isNumber(txAdolescence.getText()))
			return (wrongFormat(I18N.getMsg("msg.chart.gantt.adolescence")));
		if (!isNumber(txAdulthood.getText()))
			return (wrongFormat(I18N.getMsg("msg.chart.gantt.adulthood")));
		if (!isNumber(txRetirement.getText()))
			return (wrongFormat(I18N.getMsg("msg.chart.gantt.retirement")));
		return ("");
	}
}
