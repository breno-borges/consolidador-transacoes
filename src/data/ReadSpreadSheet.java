/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author breno.santos.o2b_dot
 */
public class ReadSpreadSheet {
    
    private List<String> bopColumnValues;
    private List<String> multiColumnValues;
    private List<String> analyzerColumnValues;
    
    public void readSpreadSheet(String filePath) throws IOException{
        this.bopColumnValues = GetColumnValues.getValuesBOPColumn(filePath);
        this.multiColumnValues = GetColumnValues.getValuesMultiColumn(filePath);
        this.analyzerColumnValues = GetColumnValues.getValuesAnalyzerColumn(filePath);
        
        Collections.sort(this.bopColumnValues);
        Collections.sort(this.multiColumnValues);
        Collections.sort(this.analyzerColumnValues);
    }

    public List<String> getBopColumnValues() {
        return bopColumnValues;
    }

    public List<String> getMultiColumnValues() {
        return multiColumnValues;
    }

    public List<String> getAnalyzerColumnValues() {
        return analyzerColumnValues;
    }
    
}
