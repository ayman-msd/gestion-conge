import { Injectable } from '@angular/core';
import * as jsPDF from 'jspdf';
import html2canvas from 'html2canvas'; // Import the html2canvas library

@Injectable({
  providedIn: 'root',
})
export class PdfGeneratorService {
  async generatePdf(element: HTMLElement) {
    const pdf = new jsPDF.default();

    // Convert HTML element to canvas and then to an image
    const canvas = await html2canvas(element);
    const imgData = canvas.toDataURL('image/png');

    // Add the image to the PDF
    pdf.addImage(imgData, 'PNG', 5, 5, 250, 280); // Adjust coordinates and dimensions as needed

    // Save the PDF
    pdf.save('rapport.pdf');
  }
}
