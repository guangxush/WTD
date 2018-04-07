/**
 * @ClassName:     MyPanel.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * 
 * @author          wangxiaoyu
 * @version         V1.0  
 * @Date           2018年1月3日 下午9:56:30 
 */
package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
	 private Image image=null;
     
     
     public Image getImage() {
 		return image;
 	}


 	public void setImage(Image image) {
 		this.image = image;
 	}


 	public void paint(Graphics g){
         try {
            
             g.drawImage(image, 0, 0, 550, 400, null);
         } catch (Exception e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
     }
}
