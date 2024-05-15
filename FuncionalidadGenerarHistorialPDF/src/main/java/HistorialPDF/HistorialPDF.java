package HistorialPDF;

import IHistorialPDF.IHistorialPDF;
import com.itextpdf.text.BaseColor;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bell
 */
public class HistorialPDF implements IHistorialPDF {

    public HistorialPDF() {
    }

    public void generarPDF(DefaultTableModel modeloTabla) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String fechaHoraActual = sdf.format(new Date());
        String nombreArchivo = "RegistroHistorial" + fechaHoraActual + ".pdf";

        com.itextpdf.text.Document documento = new com.itextpdf.text.Document(PageSize.A4.rotate());
        try {
            PdfWriter writer = PdfWriter.getInstance(documento, new FileOutputStream(nombreArchivo));

           

            documento.open();
            PdfContentByte cb = writer.getDirectContent();
           
            cb.setColorStroke(BaseColor.RED);
            cb.rectangle(1, 1, 840, 1000); // Coordenadas x, y, ancho, alto del rectángulo
            cb.stroke();
            

            Paragraph titulo = new Paragraph("Registro de Compras", FontFactory.getFont("Tahoma",
                    22,
                    Font.BOLD,
                    BaseColor.RED));
            titulo.setAlignment(Element.ALIGN_CENTER);
            documento.add(titulo);

            SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String fechaGeneracion = sdf2.format(new Date());
            Paragraph fecha = new Paragraph("Fecha de generación: " + fechaGeneracion);
            fecha.setAlignment(Element.ALIGN_CENTER);
            documento.add(fecha);

            documento.add(new Paragraph("\n"));
            PdfPTable tablaPDF = new PdfPTable(modeloTabla.getColumnCount());
            tablaPDF.setWidthPercentage(100);

            for (int i = 0; i < modeloTabla.getColumnCount(); i++) {
                PdfPCell celda = new PdfPCell(new Paragraph(modeloTabla.getColumnName(i)));
                celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                tablaPDF.addCell(celda);
            }

            for (int i = 0; i < modeloTabla.getRowCount(); i++) {
                for (int j = 0; j < modeloTabla.getColumnCount(); j++) {
                    PdfPCell celda = new PdfPCell(new Paragraph(modeloTabla.getValueAt(i, j).toString()));
                    celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                    tablaPDF.addCell(celda);
                }
            }

            documento.add(tablaPDF);

            documento.close();

            System.out.println("PDF generado correctamente.");

        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    
}
