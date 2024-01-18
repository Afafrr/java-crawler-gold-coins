/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crawlerr;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

/**
 *
 * @author Mateusz
 */
public class CreatePDF {

    /**
     * Method is using reusable writePages method to create PDF document and
     * then save it.
     *
     * @param Arrays - takes various number of arrays to be converted to pdf
     * @throws java.io.IOException
     */
    public void createPDF(ArrayList<Coin>... Arrays) throws IOException {

        try (PDDocument document = new PDDocument()) {
            for (ArrayList<Coin> array : Arrays) {
                if (array != null) {
                    writePages(document, array);
                }
            }

            File file = new File("D:/PdfBox_Examples.pdf");
            document.save(file);
        }
        System.out.println("PDF Created");
    }
    /**
     * Method writePages is writing data on pages, every array on new page and
     * adds another page if content is longer
     *
     * @param firstPage - creating new page
     * @param initX - x position of new rectangle
     * @param initY - y position of new rectangle
     * @param cellHeight - height of table cell
     * @param firstCellWidth - first cell width used for price
     * @param secondCellWidth - second cell width used for name
     * @param colCount - number of columns
     * @throws IOException
     */

    PDPage firstPage;
    float initX;
    float initY;
    float cellHeight;
    float firstCellWidth;
    float secondCellWidth;
    int colCount;

    /**
     *
     * @param document
     * @param Arr1
     * @throws IOException
     */
    public void writePages(PDDocument document, ArrayList<Coin> Arr1) throws IOException {

        firstPage = new PDPage(PDRectangle.A4);
        initX = 15;
        initY = (firstPage.getMediaBox().getHeight()) - 15;
        cellHeight = 13;
        firstCellWidth = 100;
        secondCellWidth = firstPage.getMediaBox().getWidth();
        colCount = 2;

        document.addPage(firstPage);
        PDPageContentStream contentStream = new PDPageContentStream(document, firstPage);

        printText(contentStream, "NEW TABLE", document);
        initY -= cellHeight;

        for (Coin item : Arr1) {
            for (int j = 1; j <= colCount; j++) {

                if (j == 1) {
                    contentStream.addRect(initX, initY, firstCellWidth, -cellHeight);
                    printText(contentStream, Double.toString(item.price), document);
                }
                if (j == 2) {
                    contentStream.addRect(initX, initY, secondCellWidth, -cellHeight);
                    printText(contentStream, item.name, document);

                }
                initX += firstCellWidth;
            }
            if (initY < 50) {
                firstPage = new PDPage(PDRectangle.A4);
                document.addPage(firstPage);
                contentStream.close();
                contentStream = new PDPageContentStream(document, firstPage);
                initY = (firstPage.getMediaBox().getHeight()) - 15;
            }

            initX = 15;
            initY -= cellHeight;
        }
        contentStream.close();
    }

    /**
     * Method used to print text on desired contentStream
     *
     * @param contentStream
     * @param text
     * @param document
     * @throws java.io.IOException
     */
    public void printText(PDPageContentStream contentStream, String text, PDDocument document) throws IOException {
        contentStream.setFont(PDType0Font.load(document, PDDocument.class.getResourceAsStream(
                "/org/apache/pdfbox/resources/ttf/LiberationSans-Regular.ttf")), 10);
        contentStream.beginText();
        contentStream.newLineAtOffset(initX, initY - cellHeight + 10);

        contentStream.showText(text);
        contentStream.endText();
    }
}
