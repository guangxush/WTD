/**
 * @ClassName:     ToolBarPanel.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * 
 * @author          wangxiaoyu
 * @version         V1.0  
 * @Date           2017年12月18日 下午5:33:45 
 */
package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import tools.PropertyUtil;

public class ToolBarPanel extends JPanel{
	private static final long serialVersionUID = 1L;

	private static MyIconButton buttonimporting;
	private static MyIconButton buttonclustering;
	private static MyIconButton buttonpredicting;
	/**
	 * 构造
	 */
	public ToolBarPanel() {
		initialize();
		addButtion();
		addListener();
	}

	/**
	 * 初始化
	 */
	private void initialize() {
		Dimension preferredSize = new Dimension(48, ConstantsUI.MAIN_WINDOW_HEIGHT);
		this.setPreferredSize(preferredSize);
		this.setMaximumSize(preferredSize);
		this.setMinimumSize(preferredSize);
		this.setBackground(ConstantsUI.TOOL_BAR_BACK_COLOR);
		this.setLayout(new GridLayout(2, 1));
	}

	/**
	 * 添加工具按钮
	 */
	private void addButtion() {

		JPanel panelUp = new JPanel();
		panelUp.setBackground(ConstantsUI.TOOL_BAR_BACK_COLOR);
		panelUp.setLayout(new FlowLayout(-2, -2, -4));
		JPanel panelDown = new JPanel();
		panelDown.setBackground(ConstantsUI.TOOL_BAR_BACK_COLOR);
		panelDown.setLayout(new BorderLayout(0, 0));

		buttonimporting = new MyIconButton(ConstantsUI.ICON_STATUS_ENABLE, ConstantsUI.ICON_STATUS_ENABLE,
				ConstantsUI.ICON_STATUS, PropertyUtil.getProperty("ds.ui.status.title"));
		buttonclustering = new MyIconButton(ConstantsUI.ICON_DATABASE, ConstantsUI.ICON_DATABASE_ENABLE,
				ConstantsUI.ICON_DATABASE, PropertyUtil.getProperty("ds.ui.database.title"));
		buttonpredicting = new MyIconButton(ConstantsUI.ICON_SCHEDULE, ConstantsUI.ICON_SCHEDULE_ENABLE,
				ConstantsUI.ICON_SCHEDULE, PropertyUtil.getProperty("ds.ui.schedule.title"));
		panelUp.add(buttonimporting);
		panelUp.add(buttonclustering);
		panelUp.add(buttonpredicting);
		this.add(panelUp);
		this.add(panelDown);

	}

	/**
	 * 为各按钮添加事件动作监听
	 */
	private void addListener() {
		buttonimporting.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				buttonimporting.setIcon(ConstantsUI.ICON_STATUS_ENABLE);
				buttonclustering.setIcon(ConstantsUI.ICON_DATABASE);
				buttonpredicting.setIcon(ConstantsUI.ICON_SCHEDULE);

				AppMainWindow.mainPanelCenter.removeAll();
				//ImportPanelPanel.setContent();
				AppMainWindow.mainPanelCenter.add(AppMainWindow.importingPanel, BorderLayout.CENTER);

				AppMainWindow.mainPanelCenter.updateUI();

			}
		});

		buttonclustering.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				buttonimporting.setIcon(ConstantsUI.ICON_STATUS);
				buttonclustering.setIcon(ConstantsUI.ICON_DATABASE_ENABLE);
				buttonpredicting.setIcon(ConstantsUI.ICON_SCHEDULE);

				
				AppMainWindow.mainPanelCenter.removeAll();
			
				AppMainWindow.mainPanelCenter.add(AppMainWindow.clusteringPanel, BorderLayout.CENTER);

				AppMainWindow.mainPanelCenter.updateUI();

			}
		});

		buttonpredicting.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				buttonimporting.setIcon(ConstantsUI.ICON_STATUS);
				buttonclustering.setIcon(ConstantsUI.ICON_DATABASE);
				buttonpredicting.setIcon(ConstantsUI.ICON_SCHEDULE_ENABLE);
				
				
				AppMainWindow.mainPanelCenter.removeAll();
				
				AppMainWindow.mainPanelCenter.add(AppMainWindow.predictingPanel, BorderLayout.CENTER);

				AppMainWindow.mainPanelCenter.updateUI();

			}
		});

		
	}
}
