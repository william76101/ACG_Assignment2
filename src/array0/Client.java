package array0;



import java.io.*;
import java.net.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author William_Standard
 */
public class Client {
    
    public static void main(String [] args ) throws IOException {
        
        int filesize=1022386;
        int bytesRead;
        int currentTot = 0;
        
        
Socket socket = new Socket("127.0.0.1",15123);
byte [] bytearray = new byte [filesize]; 
InputStream is = socket.getInputStream(); 
FileOutputStream fos = new FileOutputStream("copy.doc"); 
BufferedOutputStream bos = new BufferedOutputStream(fos); 
bytesRead = is.read(bytearray,0,bytearray.length); 
currentTot = bytesRead;

do { bytesRead = is.read(bytearray, currentTot, (bytearray.length-currentTot)); 
if(bytesRead >= 0) currentTot += bytesRead; } 

while(bytesRead > -1); 

bos.write(bytearray, 0 , currentTot); bos.flush(); 

bos.close(); socket.close(); } }

//Read more: http://mrbool.com/file-transfer-between-2-computers-with-java/24516#ixzz3uZYmFf1d