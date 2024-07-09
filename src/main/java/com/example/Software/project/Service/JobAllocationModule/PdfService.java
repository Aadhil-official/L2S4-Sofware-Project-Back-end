package com.example.Software.project.Service.JobAllocationModule;

import com.example.project_backend.DTO.PrintDTO;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Service
public class PdfService {

    public ByteArrayInputStream generateJobPdf(PrintDTO jobPrintDTO) {
        Document document = new Document(PageSize.A4);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
            Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
            Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

            Paragraph title = new Paragraph("Job Allocation Card", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            document.add(new Paragraph(" ")); // Empty line
            document.add(new Paragraph("Customer Details", subFont));
            document.add(new Paragraph("Name: " + jobPrintDTO.getCustomerName(), smallBold));
            document.add(new Paragraph("Phone: " + jobPrintDTO.getCustomerPhone(), smallBold));
            document.add(new Paragraph("Address: " + jobPrintDTO.getCustomerAddress(), smallBold));

            document.add(new Paragraph(" ")); // Empty line
            document.add(new Paragraph("Employee Details", subFont));
            document.add(new Paragraph("Name: " + jobPrintDTO.getEmployeeName(), smallBold));
            document.add(new Paragraph("Phone: " + jobPrintDTO.getEmployeePhone(), smallBold));
            document.add(new Paragraph("Designation: " + jobPrintDTO.getEmployeeDesignation(), smallBold));

            document.add(new Paragraph(" ")); // Empty line
            document.add(new Paragraph("Job Details", subFont));
            document.add(new Paragraph("Item Issue: " + jobPrintDTO.getItemIssue(), smallBold));
            document.add(new Paragraph("Location: " + jobPrintDTO.getLocation(), smallBold));
            document.add(new Paragraph("Item: " + jobPrintDTO.getItem(), smallBold));

            document.close();

        } catch (DocumentException ex) {
            ex.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }

    public ByteArrayInputStream printPdf(PrintDTO jobPrintDTO) {
        return generateJobPdf(jobPrintDTO);
    }
}
