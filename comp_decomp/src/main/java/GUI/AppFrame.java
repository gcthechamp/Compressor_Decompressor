/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import comp_decomp.compressor;
import comp_decomp.decompressor;
import static java.awt.Color.blue;
import static java.awt.Color.green;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class AppFrame extends JFrame implements ActionListener
{
    JButton compressButton;
    JButton decompressButton;
    
    AppFrame()
    {
        compressButton = new JButton("Compress File");
        decompressButton = new JButton("Decompress File");
        
        compressButton.setBounds(250, 100, 500, 30);
        decompressButton.setBounds(250,200,500,30);
        
        compressButton.addActionListener(this);
        decompressButton.addActionListener(this);
        
        this.setTitle("CompressorDecompressor");
        this.setSize(1000,500);
        this.setVisible(true);
        this.setLayout(null);
        this.getContentPane().setBackground(blue);
        this.add(compressButton);
        this.add(decompressButton);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == compressButton)
        {
            JFileChooser fc = new JFileChooser();
            int response = fc.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION)
            {
                File file = new File(fc.getSelectedFile().getAbsolutePath());
                try
                {
                    compressor.compress(file);
                }
                catch(Exception excep)
                {
                    JOptionPane.showMessageDialog(null, excep.toString());
                }
            }
        }       
            
        if(e.getSource() == decompressButton)
        {
            JFileChooser fc = new JFileChooser();
            int response = fc.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION)
            {
                File file = new File(fc.getSelectedFile().getAbsolutePath());
                try
                {
                    decompressor.decompress(file);
                }
                catch(Exception excep)
                {
                    JOptionPane.showMessageDialog(null, excep.toString());
                }
            }
        }
    }
}
 
