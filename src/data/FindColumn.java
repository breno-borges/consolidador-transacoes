package data;

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter; // Importar DataFormatter
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class FindColumn {
    public static int findColumn(Sheet sheet, String column) throws FileNotFoundException, IOException {

        int columnIndex = -1;
        Row headerRow = sheet.getRow(0);

        if (headerRow == null) {
            JOptionPane.showMessageDialog(null, "A planilha não possui uma linha de cabeçalho.");
            return -1;
        }

        DataFormatter formatter = new DataFormatter(); // Instanciar DataFormatter

        for (Cell cell : headerRow) {
            String cellValue = formatter.formatCellValue(cell); 

            if (cellValue.equalsIgnoreCase(column)) {
                columnIndex = cell.getColumnIndex();
                break;
            }
        }

        if (columnIndex == -1) {
            JOptionPane.showMessageDialog(null, "Coluna '" + column + "' não encontrada na planilha.");
            return 0;
        }

        return columnIndex;
    }
}