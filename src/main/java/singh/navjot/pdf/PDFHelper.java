package singh.navjot.pdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class PDFHelper 
{
	public static final String dest = "E:/lucky-I.T/JAVA Advanced/Eclipse_JEE_Workspace/customer_management_system/src/main/java/pdfoutputs/helloworld.pdf";
	Document document;
	Font chapterFont;
	
	public String initialisepdf( String useremail )
	{
		File file = new File(dest);
//		System.out.println("parentfile: "+file.getParentFile().mkdirs());
//        file.getParentFile().mkdirs();
	
        
         document = new Document();
        try {
        	
			PdfWriter.getInstance(document, new FileOutputStream(dest));
			document.open();
	        Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLDITALIC);
	        Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);
	        Chunk chunk = new Chunk("To", chapterFont);
	        Chapter chapter = new Chapter(new Paragraph(chunk), 1);
	        chapter.setNumberDepth(0);
	        chapter.add(new Paragraph(useremail, paragraphFont));
	        document.add(chapter);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return dest;
        
	}
	
	public void createtable(int row, int coln, ArrayList<String> alitem, ArrayList<String> alprice, ArrayList<String> alquantity)
	{
		int n = row*coln;
		double tax = 0.10;
		int subtotal=0;
		double total=0;
		
       try {
//    	   								   col_no
    	   PdfPTable table = new PdfPTable(coln);
    	   
    	   table.addCell("ITEM");
    	   table.addCell("PRICE");
    	   table.addCell("QUANTITY");
    	   table.addCell("SUBTOTAL");
    	   table.addCell("TAX");
    	   table.addCell("TOTAL");
    	   
           for(int i = 0; i < row; i++)           // <= n, n is no. of cells in table; n/col_no = rows_no
           {
        	   subtotal = Integer.valueOf(alprice.get(i)) * Integer.valueOf(alquantity.get(i));
        	   
        	   total = (subtotal*tax) + subtotal;
        	   
               table.addCell(alitem.get(i));
               table.addCell(""+alprice.get(i));
               table.addCell(""+alquantity.get(i));
               table.addCell(""+subtotal);
               table.addCell("10%");
               table.addCell(""+total);
           }
           document.add(table);
    	   
       }catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	public void closepdf()
	{
		try {
			
			document.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
