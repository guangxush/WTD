/**
 * @ClassName:     PredictingPanel.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * 
 * @author          wangxiaoyu
 * @version         V1.0  
 * @Date           2017年12月19日 上午10:31:23 
 */
package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import tools.PropertyUtil;

public class PredictingPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private static JPanel panelTraining;
	private static JPanel panelPredicting;
	public static JPanel settingPanelMain;
	private static JPanel settingPanelTraining;
	private static JPanel settingPanelPredicting;

	/**
	 * 构造
	 */
	public PredictingPanel() {
		initialize();
		addComponent();
		addListener();
	}

	/**
	 * 初始化
	 */
	private void initialize() {
		this.setBackground(ConstantsUI.MAIN_BACK_COLOR);
		this.setLayout(new BorderLayout());
		settingPanelTraining = new SettingPanelTraining();
		settingPanelPredicting = new SettingPanelPredicting();
	}

	/**
	 * 添加组件
	 */
	private void addComponent() {

		this.add(getUpPanel(), BorderLayout.NORTH);
		this.add(getCenterPanel(), BorderLayout.CENTER);

	}

	/**
	 * 上部面板
	 * 
	 * @return
	 */
	private JPanel getUpPanel() {
		JPanel panelUp = new JPanel();
		panelUp.setBackground(ConstantsUI.MAIN_BACK_COLOR);
		panelUp.setLayout(new FlowLayout(FlowLayout.LEFT, ConstantsUI.MAIN_H_GAP, 5));

		JLabel labelTitle = new JLabel(PropertyUtil.getProperty("ds.ui.predicting.title"));
		labelTitle.setFont(ConstantsUI.FONT_TITLE);
		labelTitle.setForeground(ConstantsUI.TOOL_BAR_BACK_COLOR);
		panelUp.add(labelTitle);

		return panelUp;
	}

	/**
	 * 中部面板
	 * 
	 * @return
	 */
	private JPanel getCenterPanel() {
		// 中间面板
		JPanel panelCenter = new JPanel();
		panelCenter.setBackground(ConstantsUI.MAIN_BACK_COLOR);
		panelCenter.setLayout(new BorderLayout());

		// 列表Panel
		JPanel panelList = new JPanel();
		Dimension preferredSize = new Dimension(245, ConstantsUI.MAIN_WINDOW_HEIGHT);
		panelList.setPreferredSize(preferredSize);
		panelList.setBackground(new Color(62, 62, 62));
		panelList.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

		panelTraining = new JPanel();
		panelTraining.setBackground(new Color(69, 186, 121));
		panelTraining.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 13));
		Dimension preferredSizeListItem = new Dimension(245, 48);
		panelTraining.setPreferredSize(preferredSizeListItem);
		panelPredicting = new JPanel();
		panelPredicting.setBackground(ConstantsUI.TOOL_BAR_BACK_COLOR);
		panelPredicting.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 13));
		panelPredicting.setPreferredSize(preferredSizeListItem);

		JLabel labelOption = new JLabel(PropertyUtil.getProperty("ds.ui.predicting.training"));
		JLabel labelAbout = new JLabel(PropertyUtil.getProperty("ds.ui.predicting.predicte"));
		Font fontListItem = new Font(PropertyUtil.getProperty("ds.ui.font.family"), 0, 15);
		labelOption.setFont(fontListItem);
		labelAbout.setFont(fontListItem);
		labelOption.setForeground(Color.white);
		labelAbout.setForeground(Color.white);
		panelTraining.add(labelOption);
		panelPredicting.add(labelAbout);

		panelList.add(panelTraining);
		panelList.add(panelPredicting);

		// 设置Panel
		settingPanelMain = new JPanel();
		settingPanelMain.setBackground(ConstantsUI.MAIN_BACK_COLOR);
		settingPanelMain.setLayout(new BorderLayout());
		settingPanelMain.add(settingPanelTraining);

		panelCenter.add(panelList, BorderLayout.WEST);
		panelCenter.add(settingPanelMain, BorderLayout.CENTER);

		return panelCenter;
	}

	/**
	 * 为相关组件添加事件监听
	 */
	private void addListener() {
		panelTraining.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				panelTraining.setBackground(new Color(69, 186, 121));
				panelPredicting.setBackground(ConstantsUI.TOOL_BAR_BACK_COLOR);

				PredictingPanel.settingPanelMain.removeAll();
				PredictingPanel.settingPanelMain.add(settingPanelTraining);
				AppMainWindow.predictingPanel.updateUI();

			}
		});

		panelPredicting.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				panelPredicting.setBackground(new Color(69, 186, 121));
				panelTraining.setBackground(ConstantsUI.TOOL_BAR_BACK_COLOR);

				PredictingPanel.settingPanelMain.removeAll();
				PredictingPanel.settingPanelMain.add(settingPanelPredicting);
				AppMainWindow.predictingPanel.updateUI();

			}
		});

	}
}
