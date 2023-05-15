/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp_decomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/**
 *
 * @author Gopal Satyam
 */
public class compressor {
    public static void compress(File file) throws IOException
    {
        String fileDirectory = file.getParent(); //Getting the directory of the file
        
        FileInputStream fis = new FileInputStream(file); //Converting file to stream of bytes to be read
        FileOutputStream fos = new FileOutputStream(fileDirectory + "/CompressedFile.gz"); /*Output stream to be written and 
        stored as "CompressedFile.gz"*/
        GZIPOutputStream gzip = new GZIPOutputStream(fos); //To write the file into its compressed version
        
        byte[] buffer = new byte[1024]; //To read the file as an array of bytes
        int len;
        
        while((len=fis.read(buffer))!=-1) //Reading file as an array of bytes till the end of file
            gzip.write(buffer,0,len); //Writing the file from the array of bytes into a compressed file
        
        gzip.close();
        fos.close();
        fis.close();
    }
    
    public static void main(String[] args) throws IOException
    {
        File path = new File("D:/Compressed_Decompressed/SampleImage1");
        compress(path);
    }
}
