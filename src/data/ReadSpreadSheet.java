/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.IOException;

/**
 *
 * @author breno.santos.o2b_dot
 */
public class ReadSpreadSheet {
    
    public void readSpreadSheet(String filePath) throws IOException{
        System.out.println("Valor pos zero " + GetColumnValues.getValuesBOPColumn(filePath).get(0));
        System.out.println("Valor ult pos" + GetColumnValues.getValuesBOPColumn(filePath).get(GetColumnValues.getValuesBOPColumn(filePath).size()-1));
    }
}
