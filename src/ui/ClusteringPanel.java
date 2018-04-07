/**
 * @ClassName:     ClusteringPanel.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * 
 * @author          wangxiaoyu
 * @version         V1.0  
 * @Date           2017年12月18日 下午10:50:59 
 */
package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import tools.Chooser;
import tools.PropertyUtil;
import tools.PythonService;

public class ClusteringPanel extends JPanel {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger("ClusteringPanel");

    public static MyIconButton buttoncluster;

    public static JLabel labelBeginTime;//开始时间
    public static JLabel labelEndTime;//结束时间
    public static JLabel labelPointNumber;//寻客点数目
    public static JLabel labelTitle;
    
    public static JTextField  textfieldBeginTime;
    public static JTextField  textfieldEndTime;
    public static MyPanel panelRight;
    private static PythonService service;
    public Image image;
    public static boolean isRunning = false;
    
    /**
     * 构造
     */
    public ClusteringPanel() {
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
     * 左边面板
     *
     * @return
     */
    private JPanel getUpPanel() {
        JPanel panelUp = new JPanel();
        panelUp.setBackground(ConstantsUI.MAIN_BACK_COLOR);
        panelUp.setLayout(new FlowLayout(FlowLayout.LEFT, ConstantsUI.MAIN_H_GAP, 5));

        JLabel labelTitle = new JLabel(PropertyUtil.getProperty("ds.ui.cluster.title"));
        labelTitle.setFont(ConstantsUI.FONT_TITLE);
        labelTitle.setForeground(ConstantsUI.TOOL_BAR_BACK_COLOR);
        panelUp.add(labelTitle);

        return panelUp;
    }
    private JPanel getCenterPanel() {
    	  JPanel panelCenter = new JPanel();
          panelCenter.setBackground(ConstantsUI.MAIN_BACK_COLOR);
          panelCenter.setLayout(new BorderLayout());
          JPanel panelLeft= new JPanel();
          panelLeft.setBackground(ConstantsUI.MAIN_BACK_COLOR);
          panelLeft.setLayout(new GridLayout(2, 1));
        //时间
        JPanel panelUpLeft = new JPanel();
        panelUpLeft.setBackground(ConstantsUI.MAIN_BACK_COLOR);
        panelUpLeft.setPreferredSize(new Dimension(200, 200));
        panelUpLeft.setLayout(new FlowLayout(FlowLayout.LEFT, ConstantsUI.CLUSTER_MAIN_H_GAP, 5));
        labelBeginTime = new JLabel(PropertyUtil.getProperty("ds.ui.cluster.begintime"));
        labelEndTime = new JLabel(PropertyUtil.getProperty("ds.ui.cluster.endtime"));
        labelBeginTime.setFont(ConstantsUI.FONT_NORMAL);
        labelBeginTime.setPreferredSize(ConstantsUI.LABLE_SIZE_ITEM);
        //labelBeginTime.setFont(new Font(PropertyUtil.getProperty("ds.ui.font.family"), 1, 15));
        labelEndTime.setFont(ConstantsUI.FONT_NORMAL);
        //labelEndTime.setFont(new Font(PropertyUtil.getProperty("ds.ui.font.family"), 1, 15));
         labelEndTime.setPreferredSize(ConstantsUI.LABLE_SIZE_ITEM);
        Chooser ser = Chooser.getInstance();
        textfieldBeginTime = new JTextField();
        textfieldBeginTime.setFont(ConstantsUI.FONT_NORMAL);
        textfieldBeginTime.setPreferredSize(ConstantsUI.TEXT_FIELD_SIZE_ITEM);
        
        //textfieldBeginTime.setBounds(10, 10, 300, 200);
        textfieldBeginTime.setText("2016-3-11");
        ser.register(textfieldBeginTime);
        Chooser ser2 = Chooser.getInstance();
        textfieldEndTime = new JTextField();
        textfieldEndTime.setFont(ConstantsUI.FONT_NORMAL);
        textfieldEndTime.setPreferredSize(ConstantsUI.TEXT_FIELD_SIZE_ITEM);
        //textfieldEndTime.setBounds(10, 10, 200, 30);
        textfieldEndTime.setText("2016-3-16");
        buttoncluster = new MyIconButton(ConstantsUI.ICON_CLUSTER, ConstantsUI.ICON_CLUSTER_ENABLE,ConstantsUI.ICON_CLUSTER_DISABLE, ""); 
        ser2.register(textfieldEndTime);
        panelUpLeft.add(labelBeginTime);
        panelUpLeft.add(textfieldBeginTime);
        panelUpLeft.add(labelEndTime);
        panelUpLeft.add(textfieldEndTime);
        panelUpLeft.add(buttoncluster);
       
        //下面按钮
        JPanel panelDownLeft = new JPanel();
        panelDownLeft.setPreferredSize(new Dimension(200, 200));
        panelDownLeft.setBackground(ConstantsUI.MAIN_BACK_COLOR);
        //buttoncluster = new MyIconButton(ConstantsUI.ICON_STOP, ConstantsUI.ICON_STOP_ENABLE,ConstantsUI.ICON_STOP_DISABLE, ""); 
        //panelDownLeft.add(buttoncluster);
        panelLeft.add(panelUpLeft);
        panelLeft.add(panelDownLeft);
        panelRight= new MyPanel();
        try{
        image = ImageIO.read(new File("./icon/tes.png"));
        }catch (Exception e)
        {
        	
        }
        panelRight.setImage(image);
        panelRight.setBackground(Color.BLACK);
        panelCenter.add(panelLeft,BorderLayout.WEST);
        panelCenter.add(panelRight,BorderLayout.CENTER);
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
    	buttoncluster.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	String s1 = textfieldBeginTime.getText();
            	String s2 = textfieldEndTime.getText();
            	service.doExec(s1+s2);
            	try{
            	image=ImageIO.read(new File("./icon/6.png"));
            	panelRight.setImage(image);
            	panelRight.repaint();
            	}catch (Exception e1){
            		e1.printStackTrace();
            	}
            	
            }
            
        });
    	
         
    }

    
}

