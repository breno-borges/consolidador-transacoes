/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author breno.santos.o2b_dot
 */
public class WriteSpreadSheet {
    
    private Workbook workbook;
    private Sheet sheet;
    
    public void writeXlsOrXlsx(String filePath, List<Double> newColumnValues) throws FileNotFoundException, IOException {

        if (filePath.endsWith(".xls")) {
            workbook = new HSSFWorkbook();
            sheet = workbook.createSheet(filePath.replace(".xls", "").concat("_adicionados.xls"));
        } else if (filePath.endsWith(".xlsx")) {
            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet(filePath.replace(".xlsx", "").concat("_adicionados.xlsx"));
        }
        
        
        JOptionPane.showMessageDialog(null, "Criada nova planilha com a nova coluna acumulo!");
    }
}
