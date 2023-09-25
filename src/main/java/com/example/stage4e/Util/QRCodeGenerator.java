package com.example.stage4e.Util;

import com.example.stage4e.Entities.Booking;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

@Component
public class QRCodeGenerator {
    public static void generateQRCode(Booking booking) throws WriterException, IOException {
        String qrCodePath = "D:\\Stage\\CodeQR";
        String qrCodeName = qrCodePath + booking.getBookingId() + "-QRCODE.png";
        var qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(
                        "ID Booking : "+ booking.getBookingId() + "\n" +
                        "Start Date : "+ booking.getStartDate() + "\n" +
                        "End Date : "+booking.getEndDate() + "\n" +
                        "Booker Phone : "+booking.getBookerPhone() + "\n" +
                        "Duration : "+booking.getDuration() + "\n" +
                        "Places : "+booking.getPlaces() , BarcodeFormat.QR_CODE , 400,400);
        Path path = FileSystems.getDefault().getPath(qrCodeName);

            MatrixToImageWriter.writeToPath(bitMatrix,"PNG",path);

    }
}
