/**
 * @ClassName:     ConstantsUI.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * 
 * @author          wangxiaoyu
 * @version         V1.0  
 * @Date           2017年12月18日 下午5:22:57 
 */
package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

import tools.PropertyUtil;

public class ConstantsUI {
	 public final static String APP_NAME = "Where to drive";
	    public final static String APP_VERSION = "v_1.0";

	    /**
	     * 主窗口大小
	     */
	    public final static int MAIN_WINDOW_X = 240;
	    public final static int MAIN_WINDOW_Y = 100;
	    public final static int MAIN_WINDOW_WIDTH = 885;
	    public final static int MAIN_WINDOW_HEIGHT = 636;

	    /**
	     * 系统当前路径
	     */
	    public final static String CURRENT_DIR = System.getProperty("user.dir");

	    /**
	     * 主窗口图标
	     */
	    //换
	    public final static Image IMAGE_ICON = Toolkit.getDefaultToolkit().getImage(AppMainWindow.class.getResource("/WeSync.jpg"));

	    /**
	     * 主窗口背景色
	     */
	    public final static Color MAIN_BACK_COLOR = Color.WHITE;
	    public final static Color TEST_BACK_COLOR = Color.RED;

	    /**
	     * 工具栏背景色
	     */
	    public final static Color TOOL_BAR_BACK_COLOR = new Color(37, 174, 96);
	    /**
	     * 表格线条背景色
	     */
	    public final static Color TABLE_LINE_COLOR = new Color(229, 229, 229);

	    /**
	     * 字体
	     */
	    // 标题字体
	    public final static Font FONT_TITLE = new Font(PropertyUtil.getProperty("ds.ui.font.family"), 0, 27);
	    // 普通字体
	    public final static Font FONT_NORMAL = new Font(PropertyUtil.getProperty("ds.ui.font.family"), 0, 13);
	    // radio字体
	    public final static Font FONT_RADIO = new Font(PropertyUtil.getProperty("ds.ui.font.family"), 0, 15);

	    /**
	     * 主图标
	     */
	    public final static ImageIcon ICON_DATA_SYNC = new ImageIcon(
	            AppMainWindow.class.getResource("/WeSync.jpg"));
	    /**
	     * 工具栏图标
	     */
	    // 预处理 默认
	    public final static ImageIcon ICON_STATUS = new ImageIcon(
	            AppMainWindow.class.getResource("/status.png"));
	    // 预处理 激活
	    public final static ImageIcon ICON_STATUS_ENABLE = new ImageIcon(
	            AppMainWindow.class.getResource("/statusEnable.png"));
	    // 聚类 默认
	    public final static ImageIcon ICON_DATABASE = new ImageIcon(
	            AppMainWindow.class.getResource("/database.png"));
	    // 聚类 激活
	    public final static ImageIcon ICON_DATABASE_ENABLE = new ImageIcon(
	            AppMainWindow.class.getResource("/databaseEnable.png"));
	    // 预测 默认
	    public final static ImageIcon ICON_SCHEDULE = new ImageIcon(
	            AppMainWindow.class.getResource("/schedule.png"));
	    // 预测 激活
	    public final static ImageIcon ICON_SCHEDULE_ENABLE = new ImageIcon(
	            AppMainWindow.class.getResource("/scheduleEnable.png"));
	    /**
	     * 按钮 图标
	     */
	    // 按计划执行 默认
	    public final static ImageIcon ICON_CHOOSE_FILE = new ImageIcon(
	            AppMainWindow.class.getResource("/choosefile.jpg"));
	    public final static ImageIcon ICON_CHOOSE_FILE_ENABLE = new ImageIcon(
	            AppMainWindow.class.getResource("/choosefileenable.jpg"));
	    public final static ImageIcon ICON_CHOOSE_FILE_DISABLE = new ImageIcon(
	            AppMainWindow.class.getResource("/choosefiledisable.jpg"));
	    
	    public final static ImageIcon ICON_IMPORT_FILE = new ImageIcon(
	            AppMainWindow.class.getResource("/importfile.jpg"));
	    public final static ImageIcon ICON_IMPORT_FILE_ENABLE = new ImageIcon(
	            AppMainWindow.class.getResource("/importfileenable.jpg"));
	    public final static ImageIcon ICON_IMPORT_FILE_DISABLE = new ImageIcon(
	            AppMainWindow.class.getResource("/importfiledisable.jpg"));
	    
	    public final static ImageIcon ICON_CLUSTER = new ImageIcon(
	            AppMainWindow.class.getResource("/cluster.jpg"));
	    public final static ImageIcon ICON_CLUSTER_ENABLE = new ImageIcon(
	            AppMainWindow.class.getResource("/clusterenable.jpg"));
	    public final static ImageIcon ICON_CLUSTER_DISABLE = new ImageIcon(
	            AppMainWindow.class.getResource("/clusterdisable.jpg"));
	    
	    public final static ImageIcon ICON_START = new ImageIcon(
	            AppMainWindow.class.getResource("/start.jpg"));
	    public final static ImageIcon ICON_START_ENABLE = new ImageIcon(
	            AppMainWindow.class.getResource("/startenable.jpg"));
	    public final static ImageIcon ICON_START_DISABLE = new ImageIcon(
	            AppMainWindow.class.getResource("/startdisable.jpg"));
	    
	    public final static ImageIcon ICON_STOP_T = new ImageIcon(
	            AppMainWindow.class.getResource("/stopt.jpg"));
	    public final static ImageIcon ICON_STOP_T_ENABLE = new ImageIcon(
	            AppMainWindow.class.getResource("/stoptenable.jpg"));
	    public final static ImageIcon ICON_STOP_T_DISABLE = new ImageIcon(
	            AppMainWindow.class.getResource("/stoptdisable.jpg"));
	    
	    public final static ImageIcon ICON_SAVE_T = new ImageIcon(
	            AppMainWindow.class.getResource("/savet.jpg"));
	    public final static ImageIcon ICON_SAVE_T_ENABLE = new ImageIcon(
	            AppMainWindow.class.getResource("/savetenable.jpg"));
	    public final static ImageIcon ICON_SAVE_T_DISABLE = new ImageIcon(
	            AppMainWindow.class.getResource("/savetdisable.jpg"));
	    
	    public final static ImageIcon ICON_PREDICT = new ImageIcon(
	            AppMainWindow.class.getResource("/predict.jpg"));
	    public final static ImageIcon ICON_PREDICT_ENABLE = new ImageIcon(
	            AppMainWindow.class.getResource("/predictenable.jpg"));
	    public final static ImageIcon ICON_PREDICT_DISABLE = new ImageIcon(
	            AppMainWindow.class.getResource("/predictdisable.jpg"));
	    
	    public final static ImageIcon ICON_START_SCHEDULE = new ImageIcon(
	            AppMainWindow.class.getResource("/startSchedule.png"));
	    // 按计划执行 激活
	    public final static ImageIcon ICON_START_SCHEDULE_ENABLE = new ImageIcon(
	            AppMainWindow.class.getResource("/startScheduleEnable.png"));
	    // 按计划执行 失效
	    public final static ImageIcon ICON_START_SCHEDULE_DISABLE = new ImageIcon(
	            AppMainWindow.class.getResource("/startScheduleDisable.png"));
	    // 停止 默认
	    public final static ImageIcon ICON_STOP = new ImageIcon(
	            AppMainWindow.class.getResource("/stop.png"));
	    // 停止 激活
	    public final static ImageIcon ICON_STOP_ENABLE = new ImageIcon(
	            AppMainWindow.class.getResource("/stopEnable.png"));
	    // 停止 失效
	    public final static ImageIcon ICON_STOP_DISABLE = new ImageIcon(
	            AppMainWindow.class.getResource("/stopDisable.png"));
	    // 立即同步 默认
	    public final static ImageIcon ICON_SYNC_NOW = new ImageIcon(
	            AppMainWindow.class.getResource("/syncNow.png"));
	    // 立即同步 激活
	    public final static ImageIcon ICON_SYNC_NOW_ENABLE = new ImageIcon(
	            AppMainWindow.class.getResource("/syncNowEnable.png"));
	    // 立即同步 失效
	    public final static ImageIcon ICON_SYNC_NOW_DISABLE = new ImageIcon(
	            AppMainWindow.class.getResource("/syncNowDisable.png"));
	    // 测试连接 默认
	    public final static ImageIcon ICON_TEST_LINK = new ImageIcon(
	            AppMainWindow.class.getResource("/testLinkButton.png"));
	    // 测试连接 激活
	    public final static ImageIcon ICON_TEST_LINK_ENABLE = new ImageIcon(
	            AppMainWindow.class.getResource("/testLinkButtonEnable.png"));
	    // 测试连接 失效
	    public final static ImageIcon ICON_TEST_LINK_DISABLE = new ImageIcon(
	            AppMainWindow.class.getResource("/testLinkButtonDisable.png"));
	    // 保存 默认
	    public final static ImageIcon ICON_SAVE = new ImageIcon(
	            AppMainWindow.class.getResource("/saveButton.png"));
	    // 保存 激活
	    public final static ImageIcon ICON_SAVE_ENABLE = new ImageIcon(
	            AppMainWindow.class.getResource("/saveButtonEnable.png"));
	    // 保存 失效
	    public final static ImageIcon ICON_SAVE_DISABLE = new ImageIcon(
	            AppMainWindow.class.getResource("/saveButtonDisable.png"));
	    // 新建备份 默认
	    public final static ImageIcon ICON_NEW_BAK = new ImageIcon(
	            AppMainWindow.class.getResource("/newBak.png"));
	    // 新建备份 激活
	    public final static ImageIcon ICON_NEW_BAK_ENABLE = new ImageIcon(
	            AppMainWindow.class.getResource("/newBakEnable.png"));
	    // 新建备份 失效
	    public final static ImageIcon ICON_NEW_BAK_DISABLE = new ImageIcon(
	            AppMainWindow.class.getResource("/newBakDisable.png"));
	    // 删除备份 默认
	    public final static ImageIcon ICON_DEL_BAK = new ImageIcon(
	            AppMainWindow.class.getResource("/deleteBak.png"));
	    // 删除备份 激活
	    public final static ImageIcon ICON_DEL_BAK_ENABLE = new ImageIcon(
	            AppMainWindow.class.getResource("/deleteBakEnable.png"));
	    // 删除备份 失效
	    public final static ImageIcon ICON_DEL_BAK_DISABLE = new ImageIcon(
	            AppMainWindow.class.getResource("/deleteBakDisable.png"));
	    // 还原备份 默认
	    public final static ImageIcon ICON_RECOVER_BAK = new ImageIcon(
	            AppMainWindow.class.getResource("/recoverBak.png"));
	    // 还原备份 激活
	    public final static ImageIcon ICON_RECOVER_BAK_ENABLE = new ImageIcon(
	            AppMainWindow.class.getResource("/recoverBakEnable.png"));
	    // 还原备份 失效
	    public final static ImageIcon ICON_RECOVER_BAK_DISABLE = new ImageIcon(
	            AppMainWindow.class.getResource("/recoverBakDisable.png"));

	    // 清空所有备份 默认
	    public final static ImageIcon ICON_CLEAR_ALL_BAKS = new ImageIcon(
	            AppMainWindow.class.getResource("/clearAllBaks.png"));
	    // 清空所有备份 激活
	    public final static ImageIcon ICON_CLEAR_ALL_BAKS_ENABLE = new ImageIcon(
	            AppMainWindow.class.getResource("/clearAllBaksEnable.png"));
	    // 清空所有备份 失效
	    public final static ImageIcon ICON_CLEAR_ALL_BAKS_DISABLE = new ImageIcon(
	            AppMainWindow.class.getResource("/clearAllBaksDisable.png"));

	    // 表字段对应关系 默认
	    public final static ImageIcon ICON_TABLE_FIELD = new ImageIcon(
	            AppMainWindow.class.getResource("/tableFiled.png"));
	    // 表字段对应关系 激活
	    public final static ImageIcon ICON_TABLE_FIELD_ENABLE = new ImageIcon(
	            AppMainWindow.class.getResource("/tableFiledEnable.png"));
	    // 表字段对应关系 失效
	    public final static ImageIcon ICON_TABLE_FIELD_DISABLE = new ImageIcon(
	            AppMainWindow.class.getResource("/tableFiledDisable.png"));
	    // 清空Log 默认
	    public final static ImageIcon ICON_CLEAR_LOG = new ImageIcon(
	            AppMainWindow.class.getResource("/clearLog.png"));
	    // 清空Log 激活
	    public final static ImageIcon ICON_CLEAR_LOG_ENABLE = new ImageIcon(
	            AppMainWindow.class.getResource("/clearLogEnable.png"));
	    // 清空Log 失效
	    public final static ImageIcon ICON_CLEAR_LOG_DISABLE = new ImageIcon(
	            AppMainWindow.class.getResource("/clearLogDisable.png"));

	    /**
	     * 样式布局相关
	     */
	    // 主面板水平间隔
	    public final static int MAIN_H_GAP = 25;
	    public final static int CLUSTER_MAIN_H_GAP = 10;
	    // 主面板Label 大小
	    public final static Dimension LABLE_SIZE = new Dimension(1300, 30);
	    // Item Label 大小
	    public final static Dimension LABLE_SIZE_ITEM = new Dimension(78, 30);
	    public final static Dimension PREDICTING_LABLE_SIZE_ITEM = new Dimension(120, 30);
	    // Item text field 大小
	    public final static Dimension TEXT_FIELD_SIZE_ITEM = new Dimension(400, 24);
	    public final static Dimension CLUSTER_TEXT_FIELD_SIZE_ITEM = new Dimension(200, 10);
	    // radio 大小
	    public final static Dimension RADIO_SIZE = new Dimension(1300, 60);
	    // 高级选项面板Item 大小
	    public final static Dimension PANEL_ITEM_SIZE = new Dimension(1300, 40);

}
