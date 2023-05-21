
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nec
 */
public class Myfunc {
    public ImageIcon resizePic(String picPath, byte[] BLOBpic, int wdth, int hgt) {
        ImageIcon myImage;
        if (picPath != null) {
            myImage = new ImageIcon(picPath);
        }else {
            myImage = new ImageIcon(BLOBpic);
        }
        
        Image img = myImage.getImage().getScaledInstance(wdth, hgt, Image.SCALE_SMOOTH);
        ImageIcon myPicture = new ImageIcon(img);
        
        return myPicture;
    }
    
    public String browseImage(JLabel lbl) {
        String path = null;
        JFileChooser filec = new JFileChooser();
        filec.setCurrentDirectory(new File(System.getProperty("user.home")));
        
        //File extension
        FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("*.Images", "png", "jpg", "gif");
        filec.addChoosableFileFilter(fileFilter);
        
        int fileState = filec.showSaveDialog(null);
        
        // If the user select a file
        if (fileState == JFileChooser.APPROVE_OPTION) {
            File selectedFile = filec.getSelectedFile();
            path = selectedFile.getAbsolutePath();
            //imagePth = path;
            // Display the image in the JLabel
            lbl.setIcon(resizePic(path, null, lbl.getWidth(), lbl.getHeight()));
            //jLabelPic.setIcon(new ImageIcon(path));
            
        }
        // If the user cancel
        else if (fileState == JFileChooser.CANCEL_OPTION) {
            System.out.println("No Image Selected");
        }
        
        return path;
    }
}
