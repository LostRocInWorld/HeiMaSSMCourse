package com.example.demotest;


import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;


public class URLConnectionExample11 {
    public static void main(String[] args){
        try{
            Properties prop = System.getProperties();
//             Set the address of the proxy server to be used for http access
//            prop.setProperty("http.proxyHost","172.17.32.183");
//             Set the port of the proxy server to use for http access
//            prop.setProperty("http.proxyPort","8080");
            URL url=new URL("http://eip.sh.pegatroncorp.com/");
            URLConnection urlcon=url.openConnection();
            InputStream stream=urlcon.getInputStream();
            int i;
            while((i=stream.read())!=-1){
                System.out.print((char)i);
            }

        }catch(Exception e){
            System.out.println(e);}
    }
}
