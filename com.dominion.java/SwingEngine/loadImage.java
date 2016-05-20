package SwingEngine;

import java.net.URL;

import javax.swing.ImageIcon;

public class loadImage {
	
	public static ImageIcon load(Class<?> classfile, String path){
		
		URL url = classfile.getResource(path);
		ImageIcon icon = null;
		
		try {
			icon = new ImageIcon(url);
			System.out.println(icon);
			return icon;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(icon);
			return null;
		}
		
	}

}
