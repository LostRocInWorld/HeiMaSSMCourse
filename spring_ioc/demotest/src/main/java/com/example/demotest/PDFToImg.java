package com.example.demotest;

import com.lowagie.text.pdf.PdfReader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import javax.swing.filechooser.FileSystemView;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

/**
 * @Classname Test
 * @Descrption TODO
 * @Date 2021/6/17下午 10:57
 * @Created By Dustin_Peng
 */
public class PDFToImg {

    public static void main(String[] args) {
//        ArrayList<File> files = listAllFiles("C:\\Users\\Dustin_Peng\\Desktop\\TEST", ".pdf");
//        System.out.println(files);
        try {
            FileSystemView fsv= FileSystemView.getFileSystemView();
            File homeDirectory = fsv.getHomeDirectory();
            pdf2png(homeDirectory.getAbsolutePath()+"\\PDFToImg",  1200);
            //某个线程占用导致JVM不退出
//            System.out.println(Thread.getAllStackTraces().entrySet());
        }catch (Exception e){
            e.printStackTrace();
        } finally{
            //没啥办法，强行退出
            System.exit(0);
        }

    }

    /**
     *
     * @param fileFolderpath pdf的文件路径
     * @param dpi 解析度
     */
    public static void pdf2png(String fileFolderpath, int dpi) {
        PDDocument pdDocument =null;
        try {
            ArrayList<File> pdfFiles = listAllFiles(fileFolderpath, ".pdf");
            int imagename = 0;
            if (pdfFiles == null || pdfFiles.size() == 0) {
                return;
            } else {
                for (File f : pdfFiles) {
                    pdDocument = PDDocument.load(f);
                    PDFRenderer renderer = new PDFRenderer(pdDocument);
                    PdfReader pdfReader = new PdfReader(f.getAbsolutePath());
                    int pages = pdfReader.getNumberOfPages();
                    BufferedImage bufferedImage = renderer.renderImageWithDPI(0, dpi);
                    ImageIO.write(bufferedImage, "svg", new File(f.getParent()+"\\"+f.getName().replaceAll(".[a-zA-Z]+$","")+".svg"));
                    imagename++;
                    System.out.println("输出图片成功");
                    pdDocument.close();
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally{
        }

    }

    /**
     * 获取文件夹下指定后缀的文件List
     * @param folder 目标文件夹
     * @param fileFormat 目标格式
     * @return
     */
    private static ArrayList<File> listAllFiles(String folder, String fileFormat) {
        ArrayList<File> getFiles = new ArrayList<>();
//        FileFilter fileFilter = new FileFilter() {
//            @Override
//            public boolean accept(File pathname) {
//                if (pathname.getName().endsWith(fileFormat)) {
//                    return true;
//                }
//                return false;
//            }
//        };
        File fileFolder = new File(folder);

        File[] files = fileFolder.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                ArrayList<File> files1 = listAllFiles(f.getAbsolutePath(), fileFormat);
                getFiles.addAll(files1);
            }
//            System.out.println(f);
            if (f.getName().endsWith(fileFormat)) {
                getFiles.add(f);
            }
        }

        return getFiles;
    }
}
