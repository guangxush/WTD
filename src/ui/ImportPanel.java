/**
 * @ClassName:     ImportPanel.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * 
 * @author          wangxiaoyu
 * @version         V1.0  
 * @Date           2017年12月18日 下午7:11:48 
 */
package ui;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import tools.PropertyUtil;
import tools.PythonService;

public class ImportPanel extends JPanel {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger("ImportPanel");

    public static MyIconButton buttonChooseFile;
    public static MyIconButton buttonWash;

    public static JProgressBar progressTotal;
    public static JLabel labelTotal;//处理进度
    //public static JLabel labelDataPreprogress;//数据预处理
    public static JLabel labelImportData;//导入出租车轨迹
    public static JLabel labelSuccessNumber;
    public static JLabel labelFailNumber;
    public static JLabel labelTotalNumber;
    public static JLabel textfieldSuccessNumber;
    public static JLabel textfieldFailNumber;
    public static JLabel textfieldTotalNumber;
    public static JTextField  textfieldfilepath;
    private static PythonService service;

    public static boolean isRunning = false;

    /**
     * 构造
     */
    public ImportPanel() {
        super(true);
        initialize();
        addComponent();
        setContent();
        addListener();
    }

    /**
     * 初始化
     */
    private void initialize() {
        this.setBackground(ConstantsUI.MAIN_BACK_COLOR);
        this.setLayout(new BorderLayout());
        service = new PythonService();
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

        JLabel labelTitle = new JLabel(PropertyUtil.getProperty("ds.ui.status.title"));
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
        panelCenter.setLayout(new GridLayout(3, 1));

        // 标题Grid
      /*  JPanel panelGridStatus = new JPanel();
        panelGridStatus.setBackground(ConstantsUI.MAIN_BACK_COLOR);
        panelGridStatus.setLayout(new FlowLayout(FlowLayout.LEFT, ConstantsUI.MAIN_H_GAP, 0));*/

        //labelDataPreprogress = new JLabel(PropertyUtil.getProperty("ds.ui.status.ready"));
        //labelDataPreprogress.setFont(new Font(PropertyUtil.getProperty("ds.ui.font.family"), 1, 15));
       

       // labelDataPreprogress.setPreferredSize(ConstantsUI.LABLE_SIZE);
       // panelGridStatus.add(labelDataPreprogress);

        // 来源/目标 Grid
        JPanel panelGridFromTo = new JPanel();
        panelGridFromTo.setBackground(ConstantsUI.MAIN_BACK_COLOR);
        panelGridFromTo.setLayout(new FlowLayout(FlowLayout.LEFT, ConstantsUI.MAIN_H_GAP, 0));

        labelImportData = new JLabel(PropertyUtil.getProperty("ds.ui.import.dataimport"));
        labelImportData.setFont(ConstantsUI.FONT_NORMAL);
        labelImportData.setPreferredSize(ConstantsUI.LABLE_SIZE);
        textfieldfilepath = new JTextField();
        textfieldfilepath.setFont(ConstantsUI.FONT_NORMAL);
        textfieldfilepath.setPreferredSize(ConstantsUI.TEXT_FIELD_SIZE_ITEM);
        //文件路径需要确定，按钮图片需要更换
        buttonChooseFile = new MyIconButton(ConstantsUI.ICON_CHOOSE_FILE, ConstantsUI.ICON_CHOOSE_FILE_ENABLE,ConstantsUI.ICON_CHOOSE_FILE_DISABLE, ""); 
        buttonWash = new MyIconButton(ConstantsUI.ICON_IMPORT_FILE, ConstantsUI.ICON_IMPORT_FILE_ENABLE,ConstantsUI.ICON_IMPORT_FILE_DISABLE, ""); 
        panelGridFromTo.add(labelImportData);
        panelGridFromTo.add(textfieldfilepath);
        panelGridFromTo.add(buttonChooseFile);
        panelGridFromTo.add(buttonWash);

        // 详情Grid
        JPanel panelGridDetail = new JPanel();
        panelGridDetail.setBackground(ConstantsUI.MAIN_BACK_COLOR);
        panelGridDetail.setLayout(new FlowLayout(FlowLayout.LEFT, ConstantsUI.MAIN_H_GAP, 0));

        labelSuccessNumber = new JLabel(PropertyUtil.getProperty("ds.ui.import.successnumber"));
        labelFailNumber = new JLabel(PropertyUtil.getProperty("ds.ui.import.failednumber"));
        labelTotalNumber = new JLabel(PropertyUtil.getProperty("ds.ui.import.totalnumber"));
        textfieldSuccessNumber = new JLabel();
        textfieldFailNumber = new JLabel();
        textfieldTotalNumber = new JLabel();
        textfieldSuccessNumber.setPreferredSize(new Dimension(80, 30));
        textfieldFailNumber.setPreferredSize(new Dimension(80, 30));
        textfieldTotalNumber.setPreferredSize(new Dimension(80, 30));
        labelSuccessNumber.setFont(ConstantsUI.FONT_NORMAL);
        labelFailNumber.setFont(ConstantsUI.FONT_NORMAL);
        labelTotalNumber.setFont(ConstantsUI.FONT_NORMAL);
        labelSuccessNumber.setPreferredSize(new Dimension(240, 30));
        labelFailNumber.setPreferredSize(new Dimension(236, 30));
        //labelTotalNumber.setPreferredSize(ConstantsUI.LABLE_SIZE);
        labelTotalNumber.setPreferredSize(new Dimension(236, 30));

        panelGridDetail.add(labelSuccessNumber);
        panelGridDetail.add(textfieldSuccessNumber);
        panelGridDetail.add(labelFailNumber);
        panelGridDetail.add(textfieldFailNumber);
        panelGridDetail.add(labelTotalNumber);
        panelGridDetail.add(textfieldTotalNumber);
        // 进度Grid
        JPanel panelGridProgress = new JPanel();
        panelGridProgress.setBackground(ConstantsUI.MAIN_BACK_COLOR);
        panelGridProgress.setLayout(new GridLayout(2, 1, ConstantsUI.MAIN_H_GAP, 0));
        JPanel panelTotalProgress = new JPanel();
        panelTotalProgress.setBackground(ConstantsUI.MAIN_BACK_COLOR);
        panelTotalProgress.setLayout(new FlowLayout(FlowLayout.LEFT, ConstantsUI.MAIN_H_GAP, 20));

        JLabel labelTotal = new JLabel(PropertyUtil.getProperty("ds.ui.status.progress.current"));
 
        labelTotal.setFont(ConstantsUI.FONT_NORMAL);
       
        progressTotal = new JProgressBar();

        Dimension preferredSizeLabel = new Dimension(80, 30);
        labelTotal.setPreferredSize(preferredSizeLabel);
        Dimension preferredSizeProgressbar = new Dimension(640, 20);
        labelTotal.setPreferredSize(preferredSizeProgressbar);
        progressTotal.setPreferredSize(preferredSizeProgressbar);
        progressTotal.setMaximum(100);progressTotal.setMinimum(0);progressTotal.setValue(0);
        panelTotalProgress.add(labelTotal);
        panelTotalProgress.add(progressTotal);

        panelGridProgress.add(panelTotalProgress);
        //panelCenter.add(panelGridStatus);
        panelCenter.add(panelGridFromTo);
        panelCenter.add(panelGridProgress);
        panelCenter.add(panelGridDetail);

        return panelCenter;
    }

 

    /**
     * 设置状态面板组件内容
     */
    public static void setContent() {

    }

    /**
     * 为各组件添加事件监听
     */
 
    
    private void addListener() {
    	buttonChooseFile.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	JFileChooser chooser = new JFileChooser();             //设置选择器  
            	chooser.setMultiSelectionEnabled(true);             //设为多选  
            	int returnVal = chooser.showOpenDialog(buttonChooseFile);        //是否打开文件选择框  
            	System.out.println("returnVal="+returnVal);  
            	  
            	if (returnVal == JFileChooser.APPROVE_OPTION) {          //如果符合文件类型  
            	  
            	String filepath = chooser.getSelectedFile().getAbsolutePath();      //获取绝对路径  
            	System.out.println(filepath);  
            	  
            	  
            	//String s = chooser.getSelectedFile().getName();  //输出相对路径  
            	textfieldfilepath.setText(filepath);
            	  
            	}  
            }
        });
    	buttonWash.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	String s = textfieldfilepath.getText();
            	service.doExec(s);
            	 new Thread(new Runnable() {
             	    public void run() {
             	     for (int i = 1; i < 101; i++) {
             	      try {
             	       Thread.sleep(100);
             	       progressTotal.setValue(i);
             	      } catch (InterruptedException ie) {
             	      }
             	     }
             	    textfieldSuccessNumber.setText("1200");
             	   textfieldFailNumber.setText("0");
             	  textfieldTotalNumber.setText("1200");
             	    }
            
             	   }).start();
            }
        });
       
         
    }

    
   
}
