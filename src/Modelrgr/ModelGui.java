package Modelrgr;

import java.awt.Frame;
import widgets.ChooseRandom;
import java.awt.Rectangle;
import java.awt.Dimension;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import widgets.Diagram;
import java.awt.GridBagConstraints;
import java.util.EventObject;

import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JLabel;

import process.Dispatcher;
import process.DispatcherFinishListener;
import widgets.ChooseData;
import java.awt.Color;

public class ModelGui extends Frame {

	private static final long serialVersionUID = 1L;
	private JTabbedPane jTabbedPane = null;
	private JPanel jPanel = null;
	private JPanel jPanel1 = null;
	private Diagram diagram1 = null;
	private Diagram diagram2 = null;
	private Diagram diagram3 = null;
	private Diagram diagram4 = null;
	private JButton jButtonStart = null;
	private Diagram diagram5 = null;
	private JButton jButtonStart2 = null;
	private JPanel jPanelText = null;
	private JTextPane jTextPane = null;
	private JPanel jPanelPasR = null;
	private JLabel jLabel1 = null;
	private ChooseRandom chooseRandomPass = null;
	private JPanel jPanelPlainR = null;
	private JLabel jLabel2 = null;
	private ChooseRandom chooseRandomPlain = null;
	private JPanel jPanelPasPlMax = null;
	private JLabel jLabel3 = null;
	private ChooseData chooseDataPasPlMax = null;
	private JPanel jPanelQueryPass = null;
	private JLabel jLabel4 = null;
	private ChooseData chooseDataQueryPass = null;
	private JPanel jPanelPlCount = null;
	private JLabel jLabel5 = null;
	private ChooseData chooseDataPlCount = null;
	private JPanel jPanelTimeCl = null;
	private JLabel jLabel6 = null;
	private ChooseData chooseDataTimeCl = null;
	private JPanel jPanelModel = null;
	private JLabel jLabel7 = null;
	private ChooseData chooseDataModel = null;
	private JPanel jPanelStRnd = null;
	private JLabel jLabel8 = null;
	private ChooseRandom chooseRandomSt = null;
	/**
	 * This is the default constructor
	 */
	public ModelGui() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setLayout(null);
		this.setSize(528, 578);
		this.setTitle("РГР");

		this.add(getJTabbedPane(), null);
		this.add(getJPanelPasR(), null);
		this.add(getJPanelPlainR(), null);
		this.add(getJPanelPasPlMax(), null);
		this.add(getJPanelQueryPass(), null);
		this.add(getJPanelPlCount(), null);
		this.add(getJPanelTimeCl(), null);
		this.add(getJPanelModel(), null);
		this.add(getJPanelStRnd(), null);
	}

	/**
	 * This method initializes jTabbedPane	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */
	private JTabbedPane getJTabbedPane() {
		if (jTabbedPane == null) {
			jTabbedPane = new JTabbedPane();
			jTabbedPane.setBounds(new Rectangle(268, 31, 252, 541));
			jTabbedPane.addTab("Тест моделі", null, getJPanel(), null);
			jTabbedPane.addTab("Статистика", null, getJPanel1(), null);
		}
		return jTabbedPane;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.setLayout(null);
			jPanel.setName("Тест моделі");
			jPanel.add(getDiagram1(), null);
			jPanel.add(getDiagram2(), null);
			jPanel.add(getDiagram3(), null);
			jPanel.add(getDiagram4(), null);
			jPanel.add(getJButtonStart(), null);
		}
		return jPanel;
	}

	/**
	 * This method initializes jPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jPanel1 = new JPanel();
			jPanel1.setLayout(null);
			jPanel1.add(getDiagram5(), null);
			jPanel1.add(getJButtonStart2(), null);
			jPanel1.add(getJPanelText(), null);
		}
		return jPanel1;
	}

	/**
	 * This method initializes diagram1	
	 * 	
	 * @return widgets.Diagram	
	 */
	public Diagram getDiagram1() {
		if (diagram1 == null) {
			diagram1 = new Diagram();
			diagram1.setBounds(new Rectangle(1, -1, 247, 118));
			diagram1.setPainterColor(Color.red);
			diagram1.setTitleText("Літаки в ангарі");
		}
		return diagram1;
	}

	/**
	 * This method initializes diagram2	
	 * 	
	 * @return widgets.Diagram	
	 */
	public Diagram getDiagram2() {
		if (diagram2 == null) {
			diagram2 = new Diagram();
			diagram2.setBounds(new Rectangle(1, 116, 247, 119));
			diagram2.setPainterColor(Color.green);
			diagram2.setTitleText("Черга до касира");
		}
		return diagram2;
	}

	/**
	 * This method initializes diagram3	
	 * 	
	 * @return widgets.Diagram	
	 */
	public Diagram getDiagram3() {
		if (diagram3 == null) {
			diagram3 = new Diagram();
			diagram3.setBounds(new Rectangle(1, 235, 246, 120));
			diagram3.setPainterColor(Color.magenta);
			diagram3.setTitleText("Черга до стюардеси");
		}
		return diagram3;
	}

	/**
	 * This method initializes diagram4	
	 * 	
	 * @return widgets.Diagram	
	 */
	public Diagram getDiagram4() {
		if (diagram4 == null) {
			diagram4 = new Diagram();
			diagram4.setBounds(new Rectangle(1, 355, 245, 125));
			diagram4.setPainterColor(Color.blue);
			diagram4.setTitleText("Черга до літака");
		}
		return diagram4;
	}

	/**
	 * This method initializes jButtonStart	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonStart() {
		if (jButtonStart == null) {
			jButtonStart = new JButton();
			jButtonStart.setBounds(new Rectangle(1, 480, 244, 32));
			jButtonStart.setText("Старт");
			jButtonStart.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ModelGui.this.startTest();
				}
			});
			jButtonStart.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButtonStart;
	}

	/**
	 * This method initializes diagram5	
	 * 	
	 * @return widgets.Diagram	
	 */
	public Diagram getDiagram5() {
		if (diagram5 == null) {
			diagram5 = new Diagram();
			diagram5.setBounds(new Rectangle(0, 0, 247, 182));
			diagram5.setTitleText("Гістограмма для черги до касира");
		}
		return diagram5;
	}

	/**
	 * This method initializes jButtonStart2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonStart2() {
		if (jButtonStart2 == null) {
			jButtonStart2 = new JButton();
			jButtonStart2.setBounds(new Rectangle(1, 345, 246, 168));
			jButtonStart2.setText("СТАРТ");
			jButtonStart2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ModelGui.this.StartStat();
				}
			});
		}
		return jButtonStart2;
	}

	/**
	 * This method initializes jPanelText	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelText() {
		if (jPanelText == null) {
			jPanelText = new JPanel();
			jPanelText.setLayout(null);
			jPanelText.setBounds(new Rectangle(1, 183, 245, 161));
			jPanelText.add(getJTextPane(), null);
		}
		return jPanelText;
	}

	/**
	 * This method initializes jTextPane	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane() {
		if (jTextPane == null) {
			jTextPane = new JTextPane();
			jTextPane.setBounds(new Rectangle(1, 0, 243, 159));
		}
		return jTextPane;
	}

	/**
	 * This method initializes jPanelPasR	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelPasR() {
		if (jPanelPasR == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("Закон надходження пасажирів");
			jLabel1.setBounds(new Rectangle(30, 1, 188, 16));
			jPanelPasR = new JPanel();
			jPanelPasR.setLayout(null);
			jPanelPasR.setBounds(new Rectangle(9, 29, 258, 54));
			jPanelPasR.setToolTipText("Закон надхлдження пасажирів");
			jPanelPasR.add(jLabel1, null);
			jPanelPasR.add(getChooseRandomPass(), null);
		}
		return jPanelPasR;
	}

	/**
	 * This method initializes chooseRandomPass	
	 * 	
	 * @return widgets.ChooseRandom	
	 */
	public ChooseRandom getChooseRandomPass() {
		if (chooseRandomPass == null) {
			chooseRandomPass = new ChooseRandom();
			chooseRandomPass.setBounds(new Rectangle(4, 18, 235, 35));
		}
		return chooseRandomPass;
	}

	/**
	 * This method initializes jPanelPlainR	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelPlainR() {
		if (jPanelPlainR == null) {
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(15, 0, 211, 16));
			jLabel2.setText("Закон визначення часу перельоту");
			jPanelPlainR = new JPanel();
			jPanelPlainR.setLayout(null);
			jPanelPlainR.setBounds(new Rectangle(9, 81, 258, 53));
			jPanelPlainR.add(jLabel2, null);
			jPanelPlainR.add(getChooseRandomPlain(), null);
		}
		return jPanelPlainR;
	}

	/**
	 * This method initializes chooseRandomPlain	
	 * 	
	 * @return widgets.ChooseRandom	
	 */
	public ChooseRandom getChooseRandomPlain() {
		if (chooseRandomPlain == null) {
			chooseRandomPlain = new ChooseRandom();
			chooseRandomPlain.setBounds(new Rectangle(3, 18, 234, 35));
		}
		return chooseRandomPlain;
	}

	/**
	 * This method initializes jPanelPasPlMax	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelPasPlMax() {
		if (jPanelPasPlMax == null) {
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(82, 2, 98, 16));
			jLabel3.setText("Місткість літака");
			jPanelPasPlMax = new JPanel();
			jPanelPasPlMax.setLayout(null);
			jPanelPasPlMax.setBounds(new Rectangle(9, 195, 257, 76));
			jPanelPasPlMax.add(jLabel3, null);
			jPanelPasPlMax.add(getChooseDataPasPlMax(), null);
		}
		return jPanelPasPlMax;
	}

	/**
	 * This method initializes chooseDataPasPlMax	
	 * 	
	 * @return widgets.ChooseData	
	 */
	public ChooseData getChooseDataPasPlMax() {
		if (chooseDataPasPlMax == null) {
			chooseDataPasPlMax = new ChooseData();
			chooseDataPasPlMax.setBounds(new Rectangle(13, 20, 232, 48));
			chooseDataPasPlMax.setTitle("Місткість літака");
			chooseDataPasPlMax.setText("5");
			chooseDataPasPlMax.addCaretListener(new javax.swing.event.CaretListener() {
				public void caretUpdate(javax.swing.event.CaretEvent e) {
					if (ModelGui.this.getJPanel().isShowing()) {
						ModelGui.this.getDiagram4().setVerticalMaxText(
						ModelGui.this.chooseDataPasPlMax.getText());
					}
				}
			});
		}
		return chooseDataPasPlMax;
	}

	/**
	 * This method initializes jPanelQueryPass	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelQueryPass() {
		if (jPanelQueryPass == null) {
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(86, 2, 93, 16));
			jLabel4.setText("Довжина черги");
			jPanelQueryPass = new JPanel();
			jPanelQueryPass.setLayout(null);
			jPanelQueryPass.setBounds(new Rectangle(9, 270, 257, 75));
			jPanelQueryPass.add(jLabel4, null);
			jPanelQueryPass.add(getChooseDataQueryPass(), null);
		}
		return jPanelQueryPass;
	}

	/**
	 * This method initializes chooseDataQueryPass	
	 * 	
	 * @return widgets.ChooseData	
	 */
	public ChooseData getChooseDataQueryPass() {
		if (chooseDataQueryPass == null) {
			chooseDataQueryPass = new ChooseData();
			chooseDataQueryPass.setBounds(new Rectangle(19, 24, 221, 48));
			chooseDataQueryPass.setTitle("Довжина черги");
			chooseDataQueryPass.setText("20");
			chooseDataQueryPass.addCaretListener(new javax.swing.event.CaretListener() {
				public void caretUpdate(javax.swing.event.CaretEvent e) {
					if (ModelGui.this.getJPanel().isShowing()) {
						ModelGui.this.getDiagram2().setVerticalMaxText(
						ModelGui.this.chooseDataQueryPass.getText());
						ModelGui.this.getDiagram3().setVerticalMaxText(
						ModelGui.this.chooseDataQueryPass.getText());
					}
					if (ModelGui.this.getJPanel1().isShowing()) {
						ModelGui.this.getDiagram5().setVerticalMaxText(
						ModelGui.this.chooseDataQueryPass.getText());
					}
				}
			});
		}
		return chooseDataQueryPass;
	}

	/**
	 * This method initializes jPanelPlCount	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelPlCount() {
		if (jPanelPlCount == null) {
			jLabel5 = new JLabel();
			jLabel5.setBounds(new Rectangle(79, 3, 100, 15));
			jLabel5.setText("Кількість літаків");
			jPanelPlCount = new JPanel();
			jPanelPlCount.setLayout(null);
			jPanelPlCount.setBounds(new Rectangle(8, 345, 257, 76));
			jPanelPlCount.add(jLabel5, null);
			jPanelPlCount.add(getChooseDataPlCount(), null);
		}
		return jPanelPlCount;
	}

	/**
	 * This method initializes chooseDataPlCount	
	 * 	
	 * @return widgets.ChooseData	
	 */
	public ChooseData getChooseDataPlCount() {
		if (chooseDataPlCount == null) {
			chooseDataPlCount = new ChooseData();
			chooseDataPlCount.setBounds(new Rectangle(26, 21, 209, 46));
			chooseDataPlCount.setTitle("Кількість літаків");
			chooseDataPlCount.setText("5");
			chooseDataPlCount.addCaretListener(new javax.swing.event.CaretListener() {
				public void caretUpdate(javax.swing.event.CaretEvent e) {
					if (ModelGui.this.getJPanel().isShowing()) {
						ModelGui.this.getDiagram1().setVerticalMaxText(
						ModelGui.this.chooseDataPlCount.getText());
					}
				}
			});
		}
		return chooseDataPlCount;
	}

	/**
	 * This method initializes jPanelTimeCl	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelTimeCl() {
		if (jPanelTimeCl == null) {
			jLabel6 = new JLabel();
			jLabel6.setBounds(new Rectangle(52, 1, 149, 17));
			jLabel6.setText("Час на обслуговування");
			jPanelTimeCl = new JPanel();
			jPanelTimeCl.setLayout(null);
			jPanelTimeCl.setBounds(new Rectangle(9, 420, 256, 76));
			jPanelTimeCl.add(jLabel6, null);
			jPanelTimeCl.add(getChooseDataTimeCl(), null);
		}
		return jPanelTimeCl;
	}

	/**
	 * This method initializes chooseDataTimeCl	
	 * 	
	 * @return widgets.ChooseData	
	 */
	public ChooseData getChooseDataTimeCl() {
		if (chooseDataTimeCl == null) {
			chooseDataTimeCl = new ChooseData();
			chooseDataTimeCl.setBounds(new Rectangle(13, 23, 220, 49));
			chooseDataTimeCl.setText("5");
			chooseDataTimeCl.setTitle("Час обслуговування");
		}
		return chooseDataTimeCl;
	}

	/**
	 * This method initializes jPanelModel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelModel() {
		if (jPanelModel == null) {
			jLabel7 = new JLabel();
			jLabel7.setBounds(new Rectangle(77, 1, 111, 15));
			jLabel7.setText("Час моделювання");
			jPanelModel = new JPanel();
			jPanelModel.setLayout(null);
			jPanelModel.setBounds(new Rectangle(9, 496, 256, 77));
			jPanelModel.add(jLabel7, null);
			jPanelModel.add(getChooseDataModel(), null);
		}
		return jPanelModel;
	}

	/**
	 * This method initializes chooseDataModel	
	 * 	
	 * @return widgets.ChooseData	
	 */
	public ChooseData getChooseDataModel() {
		if (chooseDataModel == null) {
			chooseDataModel = new ChooseData();
			chooseDataModel.setBounds(new Rectangle(16, 25, 215, 48));
			chooseDataModel.setTitle("Час моделювання");
			chooseDataModel.setText("100");
			chooseDataModel.addCaretListener(new javax.swing.event.CaretListener() {
				public void caretUpdate(javax.swing.event.CaretEvent e) {
					if (ModelGui.this.getJPanel().isShowing()) {
						ModelGui.this.getDiagram1().setHorizontalMaxText(
						ModelGui.this.chooseDataModel.getText());
						ModelGui.this.getDiagram2().setHorizontalMaxText(
						ModelGui.this.chooseDataModel.getText());
						ModelGui.this.getDiagram3().setHorizontalMaxText(
						ModelGui.this.chooseDataModel.getText());
						ModelGui.this.getDiagram4().setHorizontalMaxText(
						ModelGui.this.chooseDataModel.getText());
					}
					if (ModelGui.this.getJPanel1().isShowing()) {
						ModelGui.this.getDiagram5().setHorizontalMaxText(
						ModelGui.this.chooseDataModel.getText());
					}
				}
			});
		}
		return chooseDataModel;
	}
	
	
	 private void startTest() {
		 final Dispatcher dispatcher = new Dispatcher();
		 Factory factory = new Factory(this);
		 Model model = factory.createModel(dispatcher);
		 model.initForTest();
		 getJButtonStart().setEnabled(false);
		 getDiagram1().clear();
		 getDiagram2().clear();
		 getDiagram3().clear();
		 getDiagram4().clear();
		 dispatcher.addDispatcherFinishListener(
				 new DispatcherFinishListener() {


				@Override
				public void onDispatcherFinish(EventObject arg0) {
					ModelGui.this.getJButtonStart().setEnabled(true);
					
				}
				 });
				 dispatcher.start(); 
	 }

	public int getMaxClients() {
		return this.getChooseDataQueryPass().getInt();
	}

	public Object getChooseDataFinishTime() {
		return null;
	}

	/**
	 * This method initializes jPanelStRnd	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelStRnd() {
		if (jPanelStRnd == null) {
			jLabel8 = new JLabel();
			jLabel8.setBounds(new Rectangle(26, 0, 200, 15));
			jLabel8.setText("Час супроводу до місця посадки");
			jPanelStRnd = new JPanel();
			jPanelStRnd.setLayout(null);
			jPanelStRnd.setBounds(new Rectangle(9, 134, 258, 61));
			jPanelStRnd.add(jLabel8, null);
			jPanelStRnd.add(getChooseRandomSt(), null);
		}
		return jPanelStRnd;
	}

	/**
	 * This method initializes chooseRandomSt	
	 * 	
	 * @return widgets.ChooseRandom	
	 */
	public ChooseRandom getChooseRandomSt() {
		if (chooseRandomSt == null) {
			chooseRandomSt = new ChooseRandom();
			chooseRandomSt.setBounds(new Rectangle(4, 23, 230, 35));
		}
		return chooseRandomSt;
	}
	 
	
	public void StartStat(){
		Dispatcher dispatcher = new Dispatcher();
		Factory factory = new Factory(this);
		final Model model = factory.createModel(dispatcher);
		 model.initForStat();
		 getDiagram5().clear();
		 getJTextPane().setText("");
		 getJButtonStart2().setEnabled(false);
		 new DispatcherFinishListener() {
			
			@Override
			public void onDispatcherFinish(EventObject arg0) {
				ModelGui.this.getJButtonStart2().setEnabled(true);
				model.getHistoForQueueToCashier().showRelFrec(
				ModelGui.this.getDiagram5());
				ModelGui.this.getJTextPane().setText(
				model.getHistoForQueueToCashier().toString());
				ModelGui.this.getJTextPane().select(0, 0);
				ModelGui.this.getJButtonStart2().setEnabled(true);
			}
		};
			 dispatcher.start();
			 
	}

}  //  @jve:decl-index=0:visual-constraint="130,14"
