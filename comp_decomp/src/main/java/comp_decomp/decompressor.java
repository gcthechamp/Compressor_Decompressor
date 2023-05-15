/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp_decomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

/**
 *
 * @author Gopal Satyam
 */
public class decompressor {
    public static void decompress(File file) throws IOException
    {
     String fileDirectory = file.getParent();
     
     FileInputStream fis = new FileInputStream(file);
     GZIPInputStream gzip = new GZIPInputStream(fis); //To read the compressed file
     FileOutputStream fos = new FileOutputStream(fileDirectory + "/DecompressedFile"); //To read the original file
     
     byte[] buffer = new byte[1024]; //To read compressed file as an array of bytes
     int len;
     
     //Reading compressed file, getting back original file and writing the original file
     while((len = gzip.read(buffer))!=-1)
         fos.write(buffer,0,len);
     
     gzip.close();
     fos.close();
     fis.close();
    }
    
    public static void main(String[] args) throws IOException
    {
        File path = new File("D:/Compressed_Decompressed/CompressedFile.gz");
        decompress(path);
    }
}
