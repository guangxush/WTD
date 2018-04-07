﻿/**
 * @ClassName:     MyIconButton.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * 
 * @author          wangxiaoyu
 * @version         V1.0  
 * @Date           2017年12月18日 下午5:43:22 
 */
package ui;

import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MyIconButton extends JButton {
	private static final long serialVersionUID = 1L;
	private ImageIcon iconEnable, iconDisable;
	private String tip;

	/**
	 * 构造
	 * 
	 * @param iconNormal
	 *            默认图标
	 * @param iconEnable
	 *            激活图标
	 * @param iconDisable
	 *            失效图标
	 * @param tip
	 *            提示
	 */
	public MyIconButton(ImageIcon iconNormal, ImageIcon iconEnable, ImageIcon iconDisable, String tip) {
		super(iconNormal);

		this.iconEnable = iconEnable;
		this.iconDisable = iconDisable;
		this.tip = tip;

		initialize();
		setUp();
	}

	/**
	 * 初始化，设置按钮属性：无边，无焦点渲染，无内容区，各边距0
	 */
	private void initialize() {
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.setContentAreaFilled(false);
		this.setFocusable(true);
		this.setMargin(new Insets(0, 0, 0, 0));
	}

	/**
	 * 设置按钮图标：鼠标移过、按压、失效的图标 和设置按钮提示
	 */
	private void setUp() {
		this.setRolloverIcon(iconEnable);
		// this.setSelectedIcon(iconEnable);
		this.setPressedIcon(iconEnable);
		this.setDisabledIcon(iconDisable);

		if (!tip.equals("")) {
			this.setToolTipText(tip);
		}

	}
}