/**
 * @ClassName:     ConstantsTools.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * 
 * @author          wangxiaoyu
 * @version         V1.0  
 * @Date           2017年12月18日 下午5:27:25 
 */
package tools;

import java.io.File;

import ui.ConstantsUI;

public class ConstantsTools {
	/**
	 * 配置文件
	 */
	// 配置文件 路径
	public final static String PATH_CONFIG = ConstantsUI.CURRENT_DIR + File.separator + "config" + File.separator
			+ "config.xml";

	/**
	 * properties路径
	 */
	public final static String PATH_PROPERTY = ConstantsUI.CURRENT_DIR + File.separator + "config" + File.separator
			+ "zh-cn.properties";
}
