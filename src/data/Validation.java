/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author breno.santos.o2b_dot
 */
public class Validation {

    private ReadSpreadSheet readSpreadSheet;
    private List<String> addedAnalyzer = new ArrayList<>();
    private List<String> addedMulti = new ArrayList<>();
    private List<String> addedBOP = new ArrayList<>();

    public Validation(ReadSpreadSheet readSpreadSheet) {
        this.readSpreadSheet = readSpreadSheet;
    }

    public void validation() {
        int i = 0;

        while (i < readSpreadSheet.getBopColumnValues().size()
                || i < readSpreadSheet.getMultiColumnValues().size()
                || i < readSpreadSheet.getAnalyzerColumnValues().size()) {

            String bopDocument = (i < readSpreadSheet.getBopColumnValues().size())
                    ? readSpreadSheet.getBopColumnValues().get(i) : "";
            String multiDocument = (i < readSpreadSheet.getMultiColumnValues().size())
                    ? readSpreadSheet.getMultiColumnValues().get(i) : "";
            String analyzerDocument = (i < readSpreadSheet.getAnalyzerColumnValues().size())
                    ? readSpreadSheet.getAnalyzerColumnValues().get(i) : "";

            if (bopDocument.equals(multiDocument) &&
                !analyzerDocument.equals(bopDocument) &&
                !analyzerDocument.equals(multiDocument)) {
                
                if(analyzerDocument.equals(readSpreadSheet.getBopColumnValues().get(i+1)) &&
                analyzerDocument.equals(readSpreadSheet.getMultiColumnValues().get(i+1))){
                    readSpreadSheet.getAnalyzerColumnValues().add(i + 1, analyzerDocument);
                    readSpreadSheet.getAnalyzerColumnValues().set(i, multiDocument);
                    addedAnalyzer.add(multiDocument);
                }
                else if(!analyzerDocument.equals(readSpreadSheet.getBopColumnValues().get(i+1)) &&
                !analyzerDocument.equals(readSpreadSheet.getMultiColumnValues().get(i+1))){
                    readSpreadSheet.getAnalyzerColumnValues().add(i + 1, analyzerDocument);
                    readSpreadSheet.getAnalyzerColumnValues().set(i, multiDocument);
                    addedAnalyzer.add(multiDocument);
                }
                else if(analyzerDocument.equals(readSpreadSheet.getBopColumnValues().get(i-1)) &&
                analyzerDocument.equals(readSpreadSheet.getMultiColumnValues().get(i-1)) &&
                i > 0){
                    readSpreadSheet.getMultiColumnValues().add(i + 1, multiDocument);
                    readSpreadSheet.getMultiColumnValues().set(i, analyzerDocument);
                    readSpreadSheet.getBopColumnValues().add(i + 1, bopDocument);
                    readSpreadSheet.getBopColumnValues().set(i, analyzerDocument);
                    addedMulti.add(analyzerDocument);
                    addedBOP.add(analyzerDocument);
                }
            }
            
            i++;
        }
    }
    
    public void result() {
        System.out.println("Analyzer");
        for(int i = 0; i <= addedAnalyzer.size() - 1; i++){
            System.out.println(addedAnalyzer.get(i));
        }
        
        System.out.println("BOP");
        for(int i = 0; i <= addedBOP.size() - 1; i++){
            System.out.println(addedBOP.get(i));
        }
        
        System.out.println("Multi");
        for(int i = 0; i <= addedMulti.size() - 1; i++){
            System.out.println(addedMulti.get(i));
        }
    }

    public void clearColumns() {
        readSpreadSheet.getBopColumnValues().clear();
        readSpreadSheet.getAnalyzerColumnValues().clear();
        readSpreadSheet.getMultiColumnValues().clear();
        addedAnalyzer.clear();
        addedBOP.clear();
        addedMulti.clear();
    }
}
