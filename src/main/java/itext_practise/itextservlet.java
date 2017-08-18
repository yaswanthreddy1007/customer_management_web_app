package itext_practise;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

public class itextservlet extends HttpServlet {
	
	public static final String DEST = "E:/lucky-I.T/JAVA Advanced/Eclipse_JEE_Workspace/customer_management_system/src/main/java/pdfoutputs/helloworld.pdf";

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException 
	{
	        try {
	        	File file = new File(DEST);
		        file.getParentFile().mkdirs();
		        new itextservlet().createPdf(DEST);
	        }catch (Exception e) {
				// TODO: handle exception
	        	System.out.println("Exception "+e);
			}
	}
	
	public void createPdf(String dest) throws IOException {
        //Initialize PDF writer
        PdfWriter writer = new PdfWriter(dest);
 
        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);
 
        // Initialize document
        Document document = new Document(pdf);
 
        //Add paragraph to the document
        document.add(new Paragraph("Hello World!"));
 
        //Close document
        document.close();
    }

}
