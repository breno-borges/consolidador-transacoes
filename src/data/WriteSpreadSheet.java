package data;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
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
    
    public void writeXlsOrXlsx(String originalFilePath, 
                               List<String> addedBop, 
                               List<String> addedMulti, 
                               List<String> addedAnalyzer) throws IOException {
        
        // Ordenar as listas
        Collections.sort(addedBop);
        Collections.sort(addedMulti);
        Collections.sort(addedAnalyzer);
        
        Workbook workbook = null;
        String outputFileName; // Nome do arquivo de saída que será salvo
        String sheetName = "Dados Adicionados"; // Nome da planilha

        // Determina o tipo de Workbook e o nome do arquivo de saída
        if (originalFilePath.endsWith(".xls")) {
            workbook = new HSSFWorkbook();
            outputFileName = originalFilePath.replace(".xls", "").concat("_adicionados.xls");
        } else if (originalFilePath.endsWith(".xlsx")) {
            workbook = new XSSFWorkbook();
            outputFileName = originalFilePath.replace(".xlsx", "").concat("_adicionados.xlsx");
        } else {
            throw new IllegalArgumentException("Formato de arquivo não suportado. Use .xls ou .xlsx.");
        }
        
        // Criar a planilha
        Sheet sheet = workbook.createSheet(sheetName); 
        
        // Obter o tamanho máximo das listas para garantir que todas as linhas sejam escritas
        int maxRows = Math.max(addedBop.size(), Math.max(addedMulti.size(), addedAnalyzer.size()));

        // Criar o cabeçalho
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("BOP");
        headerRow.createCell(1).setCellValue("Multi");
        headerRow.createCell(2).setCellValue("Analyzer");
        
        // Preencher as linhas com os dados das listas
        for (int i = 0; i < maxRows; i++) {
            Row row = sheet.createRow(i + 1); // +1 para pular a linha do cabeçalho

            if (i < addedBop.size()) {
                Cell cell = row.createCell(0);
                cell.setCellValue(addedBop.get(i));
            }

            if (i < addedMulti.size()) {
                Cell cell = row.createCell(1);
                cell.setCellValue(addedMulti.get(i));
            }

            if (i < addedAnalyzer.size()) {
                Cell cell = row.createCell(2);
                cell.setCellValue(addedAnalyzer.get(i));
            }
        }

        // Auto-ajustar a largura das colunas para o conteúdo
        for (int i = 0; i < 3; i++) {
            sheet.autoSizeColumn(i);
        }

        // Escrever o conteúdo do Workbook para um arquivo
        try (FileOutputStream outputStream = new FileOutputStream(outputFileName)) {
            workbook.write(outputStream);
            JOptionPane.showMessageDialog(null, "Arquivo criado com sucesso para conferência em: " + outputFileName);
        } catch (IOException e) {
            throw new IOException("Erro ao criar o arquivo Excel: " + e.getMessage(), e);
        } finally {
            if (workbook != null) {
                try {
                    workbook.close();
                } catch (IOException e) {
                    System.err.println("Erro ao fechar o workbook: " + e.getMessage());
                }
            }
        }
    }
}
