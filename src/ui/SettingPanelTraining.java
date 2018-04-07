/**
 * @ClassName:     SettingPanelTraining.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * 
 * @author          wangxiaoyu
 * @version         V1.0  
 * @Date           2017年12月19日 上午10:42:46 
 */
package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tools.Chooser;
import tools.PropertyUtil;
import tools.PythonService;

public class SettingPanelTraining extends JPanel {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger("SettingPanelTraining");

    public static MyIconButton buttonBeginTraining;
    public static MyIconButton buttonStopTraining;
    public static MyIconButton buttonSaveModel;
    
    //public static JLabel labelSettingParameter;//参数设置
    public static JLabel labelNetworkLayer;//网络层数
    public static JLabel labelDropoutRate;//dropout率
    public static JLabel labelAccuracyThreshold;//准确率阈值
    public static JLabel labelModelAccuracy;//模型准确率
    public static JLabel labelModelCurrent;//模型变化
    
    
    public static JTextField  textfieldNetworkLayer;
    public static JTextField  textfieldDropoutRate;
    public static JTextField  textfieldAccuracyThreshold;
    private Image image;
    public static MyPanel  panelRightCenter;
   
    private static PythonService service;

    public static boolean isRunning = false;

    /**
     * 构造
     */
    public SettingPanelTraining() {
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
    private JPanel getUpPanel() {
        JPanel panelUp = new JPanel();
        panelUp.setBackground(ConstantsUI.MAIN_BACK_COLOR);
        panelUp.setLayout(new FlowLayout(FlowLayout.LEFT, ConstantsUI.MAIN_H_GAP, 5));

        JLabel labelTitle = new JLabel(PropertyUtil.getProperty("ds.ui.predicting.training"));
        labelTitle.setFont(ConstantsUI.FONT_TITLE);
        labelTitle.setForeground(ConstantsUI.TOOL_BAR_BACK_COLOR);
        panelUp.add(labelTitle);

        return panelUp;
    }


    /**
     * 左边面板
     *
     * @return
     */
    
    private JPanel getCenterPanel() {
    	 JPanel panelCenter = new JPanel();
         panelCenter.setBackground(ConstantsUI.MAIN_BACK_COLOR);
         panelCenter.setLayout(new BorderLayout());
         JPanel panelLeft= new JPanel();
         panelLeft.setBackground(ConstantsUI.MAIN_BACK_COLOR);
         panelLeft.setLayout(new GridLayout(2, 1));
    	
       //参数设置
         JPanel panelUpLeft = new JPanel();
         panelUpLeft.setBackground(ConstantsUI.MAIN_BACK_COLOR);
         panelUpLeft.setPreferredSize(new Dimension(250, 250));
         panelUpLeft.setLayout(new FlowLayout(FlowLayout.LEFT, ConstantsUI.CLUSTER_MAIN_H_GAP, 5));
    
       /* JPanel panelUpLeft = new JPanel();
        panelUpLeft.setBackground(ConstantsUI.MAIN_BACK_COLOR);
        panelUpLeft.setLayout(new GridLayout(3, 2));*/
        
        labelDropoutRate = new JLabel(PropertyUtil.getProperty("ds.ui.predicting.dropout"));
        labelNetworkLayer = new JLabel(PropertyUtil.getProperty("ds.ui.predicting.networklayer"));
        labelAccuracyThreshold = new JLabel(PropertyUtil.getProperty("ds.ui.predicting.accuracyth"));
        labelDropoutRate.setFont(ConstantsUI.FONT_NORMAL);
        labelDropoutRate.setPreferredSize(ConstantsUI.LABLE_SIZE_ITEM);
        labelNetworkLayer.setFont(ConstantsUI.FONT_NORMAL);
        labelNetworkLayer.setPreferredSize(ConstantsUI.LABLE_SIZE_ITEM);
        labelAccuracyThreshold.setFont(ConstantsUI.FONT_NORMAL);
        labelAccuracyThreshold.setPreferredSize(ConstantsUI.LABLE_SIZE_ITEM);
        textfieldNetworkLayer = new JTextField();
        textfieldNetworkLayer.setPreferredSize(ConstantsUI.TEXT_FIELD_SIZE_ITEM);
        //textfieldNetworkLayer.setBounds(10, 10, 200, 30);
        textfieldNetworkLayer.setText("5");
        textfieldDropoutRate = new JTextField();
        textfieldDropoutRate.setPreferredSize(ConstantsUI.TEXT_FIELD_SIZE_ITEM);
        //textfieldDropoutRate.setBounds(10, 10, 200, 30);
        textfieldDropoutRate.setText("0.5");
        textfieldAccuracyThreshold = new JTextField();
        textfieldAccuracyThreshold.setPreferredSize(ConstantsUI.TEXT_FIELD_SIZE_ITEM);
        //textfieldAccuracyThreshold.setBounds(10, 10, 200, 30);
        textfieldAccuracyThreshold.setText("0.88");
        panelUpLeft.add(labelNetworkLayer);
        panelUpLeft.add(textfieldNetworkLayer);
        panelUpLeft.add(labelDropoutRate);
        panelUpLeft.add(textfieldDropoutRate);
        panelUpLeft.add(labelAccuracyThreshold);
        panelUpLeft.add(textfieldAccuracyThreshold);
        buttonBeginTraining = new MyIconButton(ConstantsUI.ICON_START, ConstantsUI.ICON_START_ENABLE,ConstantsUI.ICON_START_DISABLE, ""); 
        buttonStopTraining = new MyIconButton(ConstantsUI.ICON_STOP_T, ConstantsUI.ICON_STOP_T_ENABLE,ConstantsUI.ICON_STOP_T_DISABLE, "");
        panelUpLeft.add(buttonBeginTraining);
        panelUpLeft.add(buttonStopTraining);
        panelLeft.add(panelUpLeft);
        
        //中部按钮
        
        /*JPanel panelCenterLeft = new JPanel();
        panelCenterLeft.setBackground(ConstantsUI.MAIN_BACK_COLOR);
        panelCenterLeft.setLayout(new FlowLayout(FlowLayout.LEFT, ConstantsUI.MAIN_H_GAP, 5));
        buttonBeginTraining = new MyIconButton(ConstantsUI.ICON_STOP, ConstantsUI.ICON_STOP_ENABLE,ConstantsUI.ICON_STOP_DISABLE, ""); 
        buttonStopTraining = new MyIconButton(ConstantsUI.ICON_STOP, ConstantsUI.ICON_STOP_ENABLE,ConstantsUI.ICON_STOP_DISABLE, "");
        panelCenterLeft.add(buttonBeginTraining);
        panelCenterLeft.add(buttonStopTraining);
        panelLeft.add(panelCenterLeft);*/
        
        
        JPanel panelDownLeft = new JPanel();
        panelDownLeft.setBackground(ConstantsUI.MAIN_BACK_COLOR);
        panelDownLeft.setLayout(new FlowLayout(FlowLayout.LEFT));
        labelModelAccuracy = new JLabel(PropertyUtil.getProperty("ds.ui.predicting.modelaccuracy"));
        labelModelAccuracy.setFont(ConstantsUI.FONT_NORMAL);
        labelModelAccuracy.setPreferredSize(ConstantsUI.PREDICTING_LABLE_SIZE_ITEM );
        panelDownLeft.add(labelModelAccuracy);
        panelLeft.add(panelDownLeft);
        
        panelCenter.add(panelLeft,BorderLayout.WEST);
        
       panelRightCenter = new MyPanel();
        try{
            image = ImageIO.read(new File("C:/Users/wangxiaoyu/Documents/Tencent Files/952958435/FileRecv/MobileFile/图片/图片/tes.png"));
            }catch (Exception e)
            {
            	
            }
        panelRightCenter.setImage(image);
        panelRightCenter.setBackground(ConstantsUI.MAIN_BACK_COLOR);
        panelRightCenter.setLayout(new BorderLayout());
        //上部
        JPanel panelUpCenter = new JPanel();
        panelUpCenter.setBackground(ConstantsUI.MAIN_BACK_COLOR);
        panelUpCenter.setLayout(new FlowLayout(FlowLayout.LEFT, ConstantsUI.MAIN_H_GAP, 5));
        labelModelCurrent = new JLabel(PropertyUtil.getProperty("ds.ui.predicting.modelcurrent"));
        labelModelCurrent.setFont(ConstantsUI.FONT_NORMAL);
        labelModelCurrent.setPreferredSize(ConstantsUI.PREDICTING_LABLE_SIZE_ITEM);
        buttonSaveModel = new MyIconButton(ConstantsUI.ICON_SAVE_T, ConstantsUI.ICON_SAVE_T_ENABLE,ConstantsUI.ICON_SAVE_T_DISABLE, "");
        panelUpCenter.add(labelModelCurrent);
        panelUpCenter.add(buttonSaveModel);
        JPanel panelDownCenter = new JPanel();
        panelDownCenter.setBackground(ConstantsUI.MAIN_BACK_COLOR);
        panelDownCenter.setLayout(new FlowLayout(FlowLayout.LEFT, ConstantsUI.MAIN_H_GAP, 5));
        panelRightCenter.add(panelUpCenter,BorderLayout.NORTH);
        panelRightCenter.add(panelDownCenter,BorderLayout.CENTER);
        
        panelCenter.add(panelRightCenter,BorderLayout.CENTER);
        
        return panelCenter;
    }

    /**
     * 中部面板
     *
     * @return
     */
   /* private JPanel getCenterPanel() {
        // 中间面板
        JPanel panelCenter = new JPanel();
        panelCenter.setBackground(ConstantsUI.MAIN_BACK_COLOR);
        panelCenter.setLayout(new FlowLayout(FlowLayout.LEFT, ConstantsUI.MAIN_H_GAP, 5));
        //上部
        JPanel panelUpCenter = new JPanel();
        panelUpCenter.setBackground(ConstantsUI.MAIN_BACK_COLOR);
        panelUpCenter.setLayout(new FlowLayout(FlowLayout.LEFT, ConstantsUI.MAIN_H_GAP, 5));
        labelModelCurrent = new JLabel(PropertyUtil.getProperty("ds.ui.status.ready"));
        labelModelCurrent.setFont(new Font(PropertyUtil.getProperty("ds.ui.font.family"), 1, 15));
        labelModelCurrent.setPreferredSize(ConstantsUI.LABLE_SIZE);
        buttonSaveModel = new MyIconButton(ConstantsUI.ICON_STOP, ConstantsUI.ICON_STOP_ENABLE,ConstantsUI.ICON_STOP_DISABLE, "");
        panelUpCenter.add(labelModelCurrent);
        panelUpCenter.add(buttonSaveModel);
        JPanel panelDownCenter = new JPanel();
        panelDownCenter.setBackground(ConstantsUI.MAIN_BACK_COLOR);
        panelDownCenter.setLayout(new FlowLayout(FlowLayout.LEFT, ConstantsUI.MAIN_H_GAP, 5));
        panelCenter.add(panelUpCenter);
        panelCenter.add(panelDownCenter);
        return panelCenter;
    }*/

 

    /**
     * 设置状态面板组件内容
     */
    public static void setContent() {

    }

    /**
     * 为各组件添加事件监听
     */
    private void addListener() {
    	buttonBeginTraining.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	String s1 = textfieldNetworkLayer.getText();
            	String s2 = textfieldDropoutRate.getText();
            	String s3 = textfieldAccuracyThreshold.getText();
            	service.doExec(s1+s2+s3);
            	try{
                	//image=ImageIO.read(new File("C:/Users/wangxiaoyu/Documents/Tencent Files/952958435/FileRecv/MobileFile/图片/图片/acc.png"));
                	image=ImageIO.read(new File("./icon/acc.png"));
                	panelRightCenter.setImage(image);
                	panelRightCenter.repaint();
                	}catch (Exception e1){
                		e1.printStackTrace();
                	}
            }
        });
    	buttonStopTraining.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	service.doExec("");
            }
        });
    	buttonSaveModel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	service.doExec("");
            }
        });
         
    }
}
