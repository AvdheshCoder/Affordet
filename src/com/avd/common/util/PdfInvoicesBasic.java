package com.avd.common.util;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.AFRelationshipValue;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ICC_Profile;
import com.itextpdf.text.pdf.PdfAConformanceLevel;
import com.itextpdf.text.pdf.PdfAWriter;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfDate;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfFileSpecification;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;
import com.itextpdf.text.xml.xmp.PdfAXmpWriter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
 
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
 
import org.xml.sax.SAXException;
 

 
/**
 * Reads invoice data from a test database and creates ZUGFeRD invoices
 * (Basic profile).
 * @author Bruno Lowagie
 */
public class PdfInvoicesBasic {
    public static final String DEST = "C:/opt/A.pdf";
  
    public static final String FONT = "C:/opt/Fonts/OpenSans-Regular.ttf";
    public static final String FONTB = "C:/opt/Fonts/OpenSans-Bold.ttf";
 
    protected Font font6;
    protected Font font10;
    protected Font font10b;
    protected Font font12;
    protected Font font12b;
    protected Font font14;
    protected Font font14c;
 
    public static void main(String[] args) throws Exception{
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        PdfInvoicesBasic app = new PdfInvoicesBasic();
        app.createPdf();
     
       
    }
 
    public PdfInvoicesBasic() throws DocumentException, IOException {
        BaseFont bf = BaseFont.createFont(FONT, BaseFont.WINANSI, BaseFont.EMBEDDED);
        BaseFont bfb = BaseFont.createFont(FONTB, BaseFont.WINANSI, BaseFont.EMBEDDED);
        font6 = new Font(bf, 6);
        font10 = new Font(bf, 10);
        font10b = new Font(bfb, 10);
        font12 = new Font(bf, 12);
        font12b = new Font(bfb, 12);
        font14 = new Font(bf, 14);
        font14c =  new Font(bfb,14,Font.NORMAL,BaseColor.LIGHT_GRAY);
        
    }
 
    public void createPdf() throws Exception {
        String dest = String.format(DEST);
 
 
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        // step 3
        document.open();
        // step 4
       
        // header
        Chunk glue = new Chunk(new VerticalPositionMark());
        Paragraph p;
        p = new Paragraph("BALAJI TRADERS", font14c);
        p.add(new Chunk(glue));
        p.add("INVOICE");
        document.add(p);
     /*   p = new Paragraph("", font14c);
        p.setAlignment(Element.ALIGN_LEFT);
        document.add(p);*/
        p = new Paragraph("Date: "+convertDate(new Date(), "MMM dd, yyyy"), font6);
        p.setAlignment(Element.ALIGN_RIGHT);
        document.add(p);
        p = new Paragraph("Bill Id#: 244323242412",font6);
        p.setAlignment(Element.ALIGN_RIGHT);
        document.add(p);
        p = new Paragraph("CustomerId: [123]",font6);
        p.setAlignment(Element.ALIGN_RIGHT);
        document.add(p);
 
        // Address seller / buyer
        PdfPTable table = new PdfPTable(1);
        table.setWidthPercentage(100);
        PdfPCell seller = getPartyAddress("Manish Gupta",
                "1/234 Malviya nagar , Jaipur",
                "202017",
                "9876632323",
                "manish@gmail.com");
        table.addCell(seller);
       /* PdfPCell buyer = getPartyAddress("To:",
        		 "A",
                 "B",
                 "A",
                 "B",
                 "A",
                 "B");
        table.addCell(buyer);
        seller = getPartyTax( "[A,B]".split(""),
        		"[A,B]".split(""));
        table.addCell(seller);
        buyer = getPartyTax( "[A,B]".split(""),
        		"[A,B]".split(""));
        table.addCell(buyer);*/
        document.add(table);
        
        
        document.add(getTotalsTable(
       		 
                "1,2,3,4".split(","),
                "RiceBag,WheatBag,BeanBag,FlourBag".split(","),
                "100,150,250,350".split(","),
                "2,4,5,1".split(","),
                "200,600,1250,350".split(",")));

 
        // line items
        table = new PdfPTable(1);
        table.setWidthPercentage(100);
        table.setSpacingBefore(10);
        table.setSpacingAfter(10);
        
        PdfPCell cell = getCell("Comment", Element.ALIGN_LEFT, font12b);  
        cell.setBorder(PdfPCell.NO_BORDER);
        table.addCell(cell);
    
       
        cell = getCell("1. Please check all the items are mentioned in bill", Element.ALIGN_LEFT, font10);
        cell.setBorder(PdfPCell.NO_BORDER);
     
        table.addCell(cell);
        
        
        cell = getCell("2. Kindly check bill is not tampered", Element.ALIGN_LEFT, font10);
        cell.setBorder(PdfPCell.NO_BORDER);
        table.addCell(cell);
        cell = getCell("3. For more details please visit our website", Element.ALIGN_LEFT, font10);
        cell.setBorder(PdfPCell.NO_BORDER);
       
        table.addCell(cell);
      
        document.add(table);
 
        // grand totals
    
        p = new Paragraph("Thank You For Your Business", font10b);
        p.setAlignment(Element.ALIGN_CENTER);
        document.add(p);
 
        // step 5
        document.close();
    }
 
    public PdfPCell getPartyAddress(String who, String name, String line1, String line2, String line3) {
        PdfPCell cell = new PdfPCell();
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.addElement(new Paragraph(who, font12b));
        cell.addElement(new Paragraph(name, font12));
        cell.addElement(new Paragraph(line1, font12));
        cell.addElement(new Paragraph(line2, font12));
        cell.addElement(new Paragraph(line3, font12));
      
        return cell;
    }
    public PdfPCell getPartyTax(String[] taxId, String[] taxSchema) {
        PdfPCell cell = new PdfPCell();
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.addElement(new Paragraph("Tax ID(s):", font10b));
        if (taxId.length == 0) {
            cell.addElement(new Paragraph("Not applicable", font10));
        }
        else {
            int n = taxId.length;
            for (int i = 0; i < n; i++) {
                cell.addElement(new Paragraph(String.format("%s: %s", taxSchema[i], taxId[i]), font10));
            }
        }
        return cell;
    }
 
    public PdfPTable getTotalsTable(
            String[] type, String[] percentage, String base[], String tax[], String currency[]) throws DocumentException {
        PdfPTable table = new PdfPTable(5);
        table.setSpacingBefore(20);
        table.setSpacingAfter(10);
        table.setWidthPercentage(100);
        table.setWidths(new int[]{1, 3, 1, 1, 2});
        table.addCell(getCell("PID", Element.ALIGN_LEFT, font12b));
        table.addCell(getCell("Product name", Element.ALIGN_LEFT, font12b));
        table.addCell(getCell("Price:", Element.ALIGN_LEFT, font12b));
        table.addCell(getCell("Qty:", Element.ALIGN_LEFT, font12b));
        table.addCell(getCell("Subtotal:", Element.ALIGN_LEFT, font12b));
        int n = type.length;
        for (int i = 0; i < n; i++) {
            table.addCell(getCell(type[i], Element.ALIGN_RIGHT, font12));
            table.addCell(getCell(percentage[i], Element.ALIGN_RIGHT, font12));
            table.addCell(getCell(base[i], Element.ALIGN_RIGHT, font12));
            table.addCell(getCell(tax[i], Element.ALIGN_RIGHT, font12));
        //    double total = Double.parseDouble(base[i]) + Double.parseDouble(tax[i]);
            table.addCell(getCell(currency[i], Element.ALIGN_RIGHT, font12));
           
        }
        PdfPCell cell = getCell("", Element.ALIGN_LEFT, font12b);
        cell.setColspan(3);
        cell.setBorder(PdfPCell.NO_BORDER);
        table.addCell(cell);
        cell = getCell("TOTAL", Element.ALIGN_LEFT, font12b);
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.setColspan(1);
        table.addCell(cell);
        cell = getCell("Rs.2400", Element.ALIGN_RIGHT, font12b);
        cell.setBorder(PdfPCell.NO_BORDER);
        table.addCell(cell);
        return table;
    }
 
    public PdfPCell getCell(String value, int alignment, Font font) {
        PdfPCell cell = new PdfPCell();
        cell.setUseAscender(true);
        cell.setUseDescender(true);
        Paragraph p = new Paragraph(value, font);
        p.setAlignment(alignment);
        cell.addElement(p);
        return cell;
    }
 
    public Paragraph getPaymentInfo(String ref, String[] bic, String[] iban) {
        Paragraph p = new Paragraph(String.format(
                "Please wire the amount due to our bank account using the following reference: %s",
                ref), font12);
        int n = bic.length;
        for (int i = 0; i < n; i++) {
            p.add(Chunk.NEWLINE);
            p.add(String.format("BIC: %s - IBAN: %s", bic[i], iban[i]));
        }
        return p;
    }
 
    public String convertDate(Date d, String newFormat) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(newFormat);
        return sdf.format(d);
    }
}
