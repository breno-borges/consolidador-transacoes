/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import forms.MainMenu;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author breno.santos.o2b_dot
 */
public class GetColumnValues {

    private static Workbook workbook;
    public static short[] finded  = new short[3];

    // Metodo que recupera os valores da coluna e joga em uma lista e uso essa lista para preencher a lista da coluna encontrada
    private static List<String> getValues(int columnIndex, Sheet sheet) throws FileNotFoundException, IOException {
        // Coletar os valores da coluna a partir do indice
        List<String> textValues = new ArrayList<>();
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                Cell textCell = row.getCell(columnIndex);
                if (textCell != null && textCell.getCellType() == CellType.STRING) {
                    textValues.add(textCell.getStringCellValue());
                }
            }
        }

        return textValues;
    }
    

    // Metodo que retorna uma lista de documentos da coluna BOP
    public static List<String> getValuesBOPColumn(String filePath) throws FileNotFoundException, IOException {
        List<String> bopDocuments;

        // Carrega a planilha do Excel
        FileInputStream inputStream = new FileInputStream(filePath);
        if (filePath.endsWith(".xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } else if (filePath.endsWith(".xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        }

        Sheet sheet = workbook.getSheetAt(0); // Obtém a primeira linha
        String column = "BOP"; //Informa qual coluna procurar
        int columnIndex = FindColumn.findColumn(sheet, column); //Traz o índice da coluna operacao

        if (columnIndex == -1) {
            JOptionPane.showMessageDialog(null, "Coluna '" + column + "' não encontrada na planilha.");
            MainMenu.setPath(null);
            finded[0] = 0;
            return null;
        }
        finded[0] = 1;

        bopDocuments = getValues(columnIndex, sheet);
        inputStream.close();
        workbook.close();

        return bopDocuments;
    }

    // Metodo que retorna uma lista de documentos da coluna Multi
    public static List<String> getValuesMultiColumn(String filePath) throws FileNotFoundException, IOException {
        List<String> multiDocuments;

        // Carrega a planilha do Excel
        FileInputStream inputStream = new FileInputStream(filePath);
        if (filePath.endsWith(".xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } else if (filePath.endsWith(".xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        }

        Sheet sheet = workbook.getSheetAt(0); // Obtém a primeira linha
        String column = "Multi"; //Informa qual coluna procurar
        int columnIndex = FindColumn.findColumn(sheet, column); //Traz o índice da coluna operacao

        if (columnIndex == -1) {
            JOptionPane.showMessageDialog(null, "Coluna '" + column + "' não encontrada na planilha.");
            MainMenu.setPath(null);
            finded[1] = 0;
            return null;
        }
        finded[1] = 1;

        multiDocuments = getValues(columnIndex, sheet);
        inputStream.close();
        workbook.close();
        
        return multiDocuments;
    }

    // Metodo que retorna uma lista de documentos da coluna Analyzer
    public static List<String> getValuesAnalyzerColumn(String filePath) throws FileNotFoundException, IOException {
        List<String> analyzerDocuments;

        // Carrega a planilha do Excel
        FileInputStream inputStream = new FileInputStream(filePath);
        if (filePath.endsWith(".xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } else if (filePath.endsWith(".xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        }

        Sheet sheet = workbook.getSheetAt(0); // Obtém a primeira linha
        String column = "Analyzer"; //Informa qual coluna procurar
        int columnIndex = FindColumn.findColumn(sheet, column); //Traz o índice da coluna operacao

        if (columnIndex == -1) {
            JOptionPane.showMessageDialog(null, "Coluna '" + column + "' não encontrada na planilha.");
            MainMenu.setPath(null);
            finded[2] = 0;
            return null;
        }
        finded[2] = 1;

        analyzerDocuments = getValues(columnIndex, sheet);
        inputStream.close();
        workbook.close();

        return analyzerDocuments;
    }
}
