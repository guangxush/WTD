/**
 * @ClassName:     SettingPanelPredicting.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * 
 * @author          wangxiaoyu
 * @version         V1.0  
 * @Date           2017年12月19日 下午1:52:39 
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

import tools.PropertyUtil;
import tools.PythonService;

public class SettingPanelPredicting extends JPanel {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger("SettingPanelPredicting");

    public static MyIconButton buttonPredicting;
    
    //public static JLabel labelSettingParameter;//参数设置
    public static JLabel labelStartPoint;//出发点
    public static JLabel labelStartTime;//出发时间
    public static JLabel labelStartDirction;//出发方向
    
    public static JLabel labelCostTime;//预计时间
    public static JLabel labelAccuracy;//预测准确率
    public static JLabel labelAccuracyl;//预测准确率
    public static JLabel labelLocation;//预测位置
    
    
    public static JTextField  textfieldStartPoint;
    public static JTextField  textfieldStartTime;
    public static JTextField  textfieldStartDirction;
    public static JTextField  textfieldCostTime;
    public static MyPanel  panelRightCenter;
    
    private static PythonService service;
    private Image image;
    public static boolean isRunning = false;

    /**
     * 构造
     */
    public SettingPanelPredicting() {
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

        JLabel labelTitle = new JLabel(PropertyUtil.getProperty("ds.ui.predicting.predicte"));
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
       
        
        labelStartPoint = new JLabel(PropertyUtil.getProperty("ds.ui.predicting.startpoint"));
        labelStartTime = new JLabel(PropertyUtil.getProperty("ds.ui.predicting.starttime"));
        labelStartDirction = new JLabel(PropertyUtil.getProperty("ds.ui.predicting.startdirection"));
        labelCostTime = new JLabel(PropertyUtil.getProperty("ds.ui.predicting.costtime"));
        labelStartPoint.setFont(ConstantsUI.FONT_NORMAL);
        labelStartPoint.setPreferredSize(ConstantsUI.LABLE_SIZE_ITEM);
        labelStartTime.setFont(ConstantsUI.FONT_NORMAL);
        labelStartTime.setPreferredSize(ConstantsUI.LABLE_SIZE_ITEM);
        labelStartDirction.setFont(ConstantsUI.FONT_NORMAL);
        labelStartDirction.setPreferredSize(ConstantsUI.LABLE_SIZE_ITEM);
        labelCostTime.setFont(ConstantsUI.FONT_NORMAL);
        labelCostTime.setPreferredSize(ConstantsUI.LABLE_SIZE_ITEM);
        
        
        
        textfieldStartPoint = new JTextField();
        textfieldStartPoint.setPreferredSize(ConstantsUI.TEXT_FIELD_SIZE_ITEM);
        //textfieldStartPoint.setBounds(10, 10, 200, 30);
        textfieldStartPoint.setText("121.577481,31.117646");
        textfieldStartTime = new JTextField();
        textfieldStartTime.setPreferredSize(ConstantsUI.TEXT_FIELD_SIZE_ITEM);
        //textfieldStartTime.setBounds(10, 10, 200, 30);
        textfieldStartTime.setText("15:00:00");
        textfieldStartDirction = new JTextField();
        textfieldStartDirction.setPreferredSize(ConstantsUI.TEXT_FIELD_SIZE_ITEM);
        //textfieldStartDirction.setBounds(10, 10, 200, 30);
        textfieldStartDirction.setText("g");
        textfieldCostTime = new JTextField();
        textfieldCostTime.setPreferredSize(ConstantsUI.TEXT_FIELD_SIZE_ITEM);
        //textfieldCostTime.setBounds(10, 10, 200, 30);
        textfieldCostTime.setText("");
        
        panelUpLeft.add(labelStartPoint);
        panelUpLeft.add(textfieldStartPoint);
        panelUpLeft.add(labelStartTime);
        panelUpLeft.add(textfieldStartTime);
        panelUpLeft.add(labelStartDirction);
        panelUpLeft.add(textfieldStartDirction);
        //panelUpLeft.add(labelCostTime);
        //panelUpLeft.add(textfieldCostTime);
        
        /*//中部按钮
        JPanel panelCenterLeft = new JPanel();
        panelCenterLeft.setBackground(ConstantsUI.MAIN_BACK_COLOR);
        panelCenterLeft.setLayout(new FlowLayout(FlowLayout.LEFT, ConstantsUI.MAIN_H_GAP, 5));
        buttonPredicting = new MyIconButton(ConstantsUI.ICON_STOP, ConstantsUI.ICON_STOP_ENABLE,ConstantsUI.ICON_STOP_DISABLE, ""); 
        
        panelCenterLeft.add(buttonPredicting);*/
        
        
        JPanel panelDownLeft = new JPanel();
        panelDownLeft.setBackground(ConstantsUI.MAIN_BACK_COLOR);
        panelDownLeft.setLayout(new FlowLayout(FlowLayout.LEFT));
        labelAccuracy = new JLabel(PropertyUtil.getProperty("ds.ui.predicting.successaccuracy"));
        labelAccuracy.setFont(ConstantsUI.FONT_NORMAL);
        labelAccuracy.setPreferredSize(ConstantsUI.LABLE_SIZE_ITEM);
        labelAccuracyl = new JLabel();
        labelAccuracyl.setFont(ConstantsUI.FONT_NORMAL);
        labelAccuracyl.setPreferredSize(ConstantsUI.LABLE_SIZE_ITEM);
        buttonPredicting = new MyIconButton(ConstantsUI.ICON_PREDICT, ConstantsUI.ICON_PREDICT_ENABLE,ConstantsUI.ICON_PREDICT_DISABLE, ""); 
        panelDownLeft.add(buttonPredicting);
        panelDownLeft.add(labelAccuracy);
        panelDownLeft.add(labelAccuracyl);
        panelLeft.add(panelUpLeft);
        panelLeft.add(panelDownLeft);
        
        panelRightCenter = new MyPanel();
        try{
            image = ImageIO.read(new File("./icon/tes.png"));
            }catch (Exception e)
            {
            	
            }
        panelRightCenter.setImage(image);
        panelRightCenter.setBackground(ConstantsUI.MAIN_BACK_COLOR);
        panelRightCenter.setLayout(new BorderLayout());
        
        
        //上部
        //JPanel panelUpCenter = new JPanel();
       // panelUpCenter.setBackground(ConstantsUI.MAIN_BACK_COLOR);
       // panelUpCenter.setLayout(new FlowLayout(FlowLayout.LEFT, ConstantsUI.MAIN_H_GAP, 5));
        panelCenter.add(panelLeft,BorderLayout.WEST);
        panelCenter.add(panelRightCenter,BorderLayout.CENTER);
        
        return panelCenter;
    }

    /**
     * 中部面板
     *
     * @return
     */
    /*private JPanel getCenterPanel() {
        // 中间面板
        JPanel panelCenter = new JPanel();
        panelCenter.setBackground(ConstantsUI.MAIN_BACK_COLOR);
        panelCenter.setLayout(new FlowLayout(FlowLayout.LEFT, ConstantsUI.MAIN_H_GAP, 5));
        //上部
      
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
    	buttonPredicting.addActionListener(new ActionListener() {
    		
            @Override
            public void actionPerformed(ActionEvent e) {
            	textfieldStartPoint.getText();
            	textfieldStartTime.getText();
            	textfieldStartDirction.getText();
            	service.doExec("");
            	labelAccuracyl.setText("0.87");
            	try{
                	//image=ImageIO.read(new File("C:/Users/wangxiaoyu/Documents/Tencent Files/952958435/FileRecv/MobileFile/图片/图片/acc.png"));
                	image=ImageIO.read(new File("./icon/5.png"));
                	panelRightCenter.setImage(image);
                	panelRightCenter.repaint();
                	}catch (Exception e1){
                		e1.printStackTrace();
                	}
            }
        });
    	
         
    }
}
