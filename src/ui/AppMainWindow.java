/**
 * @ClassName:     AppMainWindow.java
 * @Description:   TODO 
 * 
 * @author          wangxiaoyu
 * @version         V1.0  
 * @Date           2017年12月18日 下午2:59:37 
 */
package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class AppMainWindow {
	private static final Logger logger = Logger.getLogger("AppMainWindow");
	 private JFrame frame;

	    private static JPanel mainPanel;
	    public static JPanel mainPanelCenter;

	    public static ImportPanel importingPanel;
	    public static ClusteringPanel clusteringPanel;
	    public static PredictingPanel predictingPanel;

	    /**
	     * 程序入口main
	     */
	    public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                    AppMainWindow window = new AppMainWindow();
	                    window.frame.setVisible(true);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	    }

	    /**
	     * 构造，创建APP
	     */
	    public AppMainWindow() {
	        initialize();
	        //StatusPanel.buttonStartSchedule.doClick();
	    }

	    /**
	     * 初始化frame内容
	     */
	    private void initialize() {
	        logger.info("==================AppInitStart");
	        // 设置系统默认样式
	        /*try {
	            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |UnsupportedLookAndFeelException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }*/

	        // 初始化主窗口
	        frame = new JFrame();
	        frame.setBounds(ConstantsUI.MAIN_WINDOW_X, ConstantsUI.MAIN_WINDOW_Y, ConstantsUI.MAIN_WINDOW_WIDTH,
	                ConstantsUI.MAIN_WINDOW_HEIGHT);
	        frame.setTitle(ConstantsUI.APP_NAME);
	        frame.setIconImage(ConstantsUI.IMAGE_ICON);
	        frame.setBackground(ConstantsUI.MAIN_BACK_COLOR);
	        mainPanel = new JPanel(true);
	        mainPanel.setBackground(Color.white);
	        mainPanel.setLayout(new BorderLayout());

	        ToolBarPanel toolbar = new ToolBarPanel();
	        importingPanel = new ImportPanel();
	        clusteringPanel = new ClusteringPanel();
	        predictingPanel = new PredictingPanel();
	        

	        mainPanel.add(toolbar, BorderLayout.WEST);

	        mainPanelCenter = new JPanel(true);
	        mainPanelCenter.setLayout(new BorderLayout());
	       

	        mainPanel.add(mainPanelCenter, BorderLayout.CENTER);
	        frame.add(mainPanel);

	        frame.addWindowListener(new WindowListener() {

	            @Override
	            public void windowOpened(WindowEvent e) {
	                // TODO Auto-generated method stub

	            }

	            @Override
	            public void windowIconified(WindowEvent e) {
	                // TODO Auto-generated method stub

	            }

	            @Override
	            public void windowDeiconified(WindowEvent e) {
	                // TODO Auto-generated method stub

	            }

	            @Override
	            public void windowDeactivated(WindowEvent e) {
	                // TODO Auto-generated method stub

	            }

	            @Override
	            public void windowClosing(WindowEvent e) {
	               /* if (!StatusPanel.buttonStartSchedule.isEnabled()) {
	                    JOptionPane.showMessageDialog(AppMainWindow.statusPanel,
	                            PropertyUtil.getProperty("ds.ui.mainwindow.exitconfirm"), "Sorry~", JOptionPane.WARNING_MESSAGE);
	                } else {
	                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                }*/

	            }

	            @Override
	            public void windowClosed(WindowEvent e) {

	            }

	            @Override
	            public void windowActivated(WindowEvent e) {

	            }
	        });
	        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	        logger.info("==================AppInitEnd");
	    }
}
