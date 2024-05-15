
package HistorialPDF;

import IHistorialPDF.IHistorialPDF;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
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
public class HistorialPDF implements IHistorialPDF{

    public HistorialPDF()  {
    }
    
    public void generarPDF(DefaultTableModel modeloTabla) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String fechaHoraActual = sdf.format(new Date());
        String nombreArchivo = "RegistroHistorial" + fechaHoraActual + ".pdf";

        com.itextpdf.text.Document documento = new com.itextpdf.text.Document(PageSize.A4.rotate());
        try {
            PdfWriter writer = PdfWriter.getInstance(documento, new FileOutputStream(nombreArchivo));

            writer.setPageEvent(new PageNumeration());

            

            documento.open();

            Font fontTitulo = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
            Paragraph titulo = new Paragraph("Registro de Compras", fontTitulo);
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

    class PageNumeration extends PdfPageEventHelper {

        @Override
        public void onEndPage(PdfWriter writer, com.itextpdf.text.Document document) {
            try {
                int numeroPagina = writer.getPageNumber();
                Paragraph numeroPaginaParrafo = new Paragraph("Página " + numeroPagina);
                document.add(numeroPaginaParrafo);
            } catch (DocumentException ex) {
                Logger.getLogger(HistorialPDF.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
     
}
