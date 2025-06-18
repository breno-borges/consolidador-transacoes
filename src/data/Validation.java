/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap; // Para contar ocorrências
import java.util.Map;     // Para contar ocorrências

/**
 *
 * @author breno.santos.o2b_dot
 */
public class Validation {

    private ReadSpreadSheet readSpreadSheet;
    private List<String> addedAnalyzer = new ArrayList<>();
    private List<String> addedMulti = new ArrayList<>();
    private List<String> addedBOP = new ArrayList<>();
    private int initialSizeBOP;
    private int initialSizeMulti;
    private int initialSizeAnalyzer;
    
    
    public Validation(ReadSpreadSheet readSpreadSheet) {
        this.readSpreadSheet = readSpreadSheet;
    }

    
    public void validation() {

        // Seta os valores iniciais das listas
        this.initialSizeBOP = readSpreadSheet.getBopColumnValues().size();
        this.initialSizeMulti = readSpreadSheet.getMultiColumnValues().size();
        this.initialSizeAnalyzer = readSpreadSheet.getAnalyzerColumnValues().size();
        
        // Loop principal para equalizar as listas em tamanho e contagem de elementos
        while (!(readSpreadSheet.getBopColumnValues().size() == readSpreadSheet.getMultiColumnValues().size()
                && readSpreadSheet.getMultiColumnValues().size() == readSpreadSheet.getAnalyzerColumnValues().size())) {

            // Mapeia as ocorrências de cada elemento para cada lista
            Map<String, Integer> bopCounts = new HashMap<>();
            for (String s : readSpreadSheet.getBopColumnValues()) {
                bopCounts.put(s, bopCounts.getOrDefault(s, 0) + 1);
            }

            Map<String, Integer> multiCounts = new HashMap<>();
            for (String s : readSpreadSheet.getMultiColumnValues()) {
                multiCounts.put(s, multiCounts.getOrDefault(s, 0) + 1);
            }

            Map<String, Integer> analyzerCounts = new HashMap<>();
            for (String s : readSpreadSheet.getAnalyzerColumnValues()) {
                analyzerCounts.put(s, analyzerCounts.getOrDefault(s, 0) + 1);
            }

            // Coleta todos os elementos únicos que existem em qualquer uma das listas
            List<String> allUniqueElements = new ArrayList<>();
            for (String s : bopCounts.keySet()) {
                if (!allUniqueElements.contains(s)) allUniqueElements.add(s);
            }
            for (String s : multiCounts.keySet()) {
                if (!allUniqueElements.contains(s)) allUniqueElements.add(s);
            }
            for (String s : analyzerCounts.keySet()) {
                if (!allUniqueElements.contains(s)) allUniqueElements.add(s);
            }

            boolean changedThisIteration = false; // Para verificar se alguma adição ocorreu

            // Itera sobre todos os elementos únicos para sincronizar suas contagens
            for (String element : allUniqueElements) {
                int bopOccurrences = bopCounts.getOrDefault(element, 0);
                int multiOccurrences = multiCounts.getOrDefault(element, 0);
                int analyzerOccurrences = analyzerCounts.getOrDefault(element, 0);

                int maxOccurrences = Math.max(bopOccurrences, Math.max(multiOccurrences, analyzerOccurrences));

                // Adicionar ao BOP se faltar ocorrências
                if (bopOccurrences < maxOccurrences) {
                    int needed = maxOccurrences - bopOccurrences;
                    for (int i = 0; i < needed; i++) {
                        readSpreadSheet.getBopColumnValues().add(element);
                        addedBOP.add(element);
                        changedThisIteration = true;
                    }
                }
                
                // Adicionar ao Multi se faltar ocorrências
                if (multiOccurrences < maxOccurrences) {
                    int needed = maxOccurrences - multiOccurrences;
                    for (int i = 0; i < needed; i++) {
                        readSpreadSheet.getMultiColumnValues().add(element);
                        addedMulti.add(element);
                        changedThisIteration = true;
                    }
                }

                // Adicionar ao Analyzer se faltar ocorrências
                if (analyzerOccurrences < maxOccurrences) {
                    int needed = maxOccurrences - analyzerOccurrences;
                    for (int i = 0; i < needed; i++) {
                        readSpreadSheet.getAnalyzerColumnValues().add(element);
                        addedAnalyzer.add(element);
                        changedThisIteration = true;
                    }
                }
            }
            
            
            int currentMaxSize = Math.max(readSpreadSheet.getBopColumnValues().size(),
                                          Math.max(readSpreadSheet.getMultiColumnValues().size(),
                                                   readSpreadSheet.getAnalyzerColumnValues().size()));

            // Preencher a lista BOP para atingir o tamanho atual máximo
            while (readSpreadSheet.getBopColumnValues().size() < currentMaxSize) {
                if (!readSpreadSheet.getMultiColumnValues().isEmpty() && readSpreadSheet.getBopColumnValues().size() < readSpreadSheet.getMultiColumnValues().size()) {
                    String elementToFill = readSpreadSheet.getMultiColumnValues().get(readSpreadSheet.getBopColumnValues().size());
                    readSpreadSheet.getBopColumnValues().add(elementToFill);
                    addedBOP.add(elementToFill);
                    changedThisIteration = true;
                } else if (!readSpreadSheet.getAnalyzerColumnValues().isEmpty() && readSpreadSheet.getBopColumnValues().size() < readSpreadSheet.getAnalyzerColumnValues().size()) {
                    String elementToFill = readSpreadSheet.getAnalyzerColumnValues().get(readSpreadSheet.getBopColumnValues().size());
                    readSpreadSheet.getBopColumnValues().add(elementToFill);
                    addedBOP.add(elementToFill);
                    changedThisIteration = true;
                } else if (!readSpreadSheet.getBopColumnValues().isEmpty()) { // Fallback para duplicar da própria lista
                    String lastElement = readSpreadSheet.getBopColumnValues().get(readSpreadSheet.getBopColumnValues().size() - 1);
                    readSpreadSheet.getBopColumnValues().add(lastElement);
                    addedBOP.add(lastElement);
                    changedThisIteration = true;
                } else { // Lista BOP vazia e outras também esgotadas ou vazias
                    String placeholder = "FILLER_BOP_" + System.nanoTime();
                    readSpreadSheet.getBopColumnValues().add(placeholder);
                    addedBOP.add(placeholder);
                    changedThisIteration = true;
                }
            }
            
            // Preencher a lista Multi para atingir o tamanho atual máximo
            while (readSpreadSheet.getMultiColumnValues().size() < currentMaxSize) {
                 if (!readSpreadSheet.getBopColumnValues().isEmpty() && readSpreadSheet.getMultiColumnValues().size() < readSpreadSheet.getBopColumnValues().size()) {
                    String elementToFill = readSpreadSheet.getBopColumnValues().get(readSpreadSheet.getMultiColumnValues().size());
                    readSpreadSheet.getMultiColumnValues().add(elementToFill);
                    addedMulti.add(elementToFill);
                    changedThisIteration = true;
                } else if (!readSpreadSheet.getAnalyzerColumnValues().isEmpty() && readSpreadSheet.getMultiColumnValues().size() < readSpreadSheet.getAnalyzerColumnValues().size()) {
                    String elementToFill = readSpreadSheet.getAnalyzerColumnValues().get(readSpreadSheet.getMultiColumnValues().size());
                    readSpreadSheet.getMultiColumnValues().add(elementToFill);
                    addedMulti.add(elementToFill);
                    changedThisIteration = true;
                } else if (!readSpreadSheet.getMultiColumnValues().isEmpty()) { // Fallback para duplicar da própria lista
                    String lastElement = readSpreadSheet.getMultiColumnValues().get(readSpreadSheet.getMultiColumnValues().size() - 1);
                    readSpreadSheet.getMultiColumnValues().add(lastElement);
                    addedMulti.add(lastElement);
                    changedThisIteration = true;
                } else { // Lista Multi vazia e outras também esgotadas ou vazias
                    String placeholder = "FILLER_MULTI_" + System.nanoTime();
                    readSpreadSheet.getMultiColumnValues().add(placeholder);
                    addedMulti.add(placeholder);
                    changedThisIteration = true;
                }
            }

            // Preencher a lista Analyzer para atingir o tamanho atual máximo
            while (readSpreadSheet.getAnalyzerColumnValues().size() < currentMaxSize) {
                if (!readSpreadSheet.getBopColumnValues().isEmpty() && readSpreadSheet.getAnalyzerColumnValues().size() < readSpreadSheet.getBopColumnValues().size()) {
                    String elementToFill = readSpreadSheet.getBopColumnValues().get(readSpreadSheet.getAnalyzerColumnValues().size());
                    readSpreadSheet.getAnalyzerColumnValues().add(elementToFill);
                    addedAnalyzer.add(elementToFill);
                    changedThisIteration = true;
                } else if (!readSpreadSheet.getMultiColumnValues().isEmpty() && readSpreadSheet.getAnalyzerColumnValues().size() < readSpreadSheet.getMultiColumnValues().size()) {
                    String elementToFill = readSpreadSheet.getMultiColumnValues().get(readSpreadSheet.getAnalyzerColumnValues().size());
                    readSpreadSheet.getAnalyzerColumnValues().add(elementToFill);
                    addedAnalyzer.add(elementToFill);
                    changedThisIteration = true;
                } else if (!readSpreadSheet.getAnalyzerColumnValues().isEmpty()) { // Fallback para duplicar da própria lista
                    String lastElement = readSpreadSheet.getAnalyzerColumnValues().get(readSpreadSheet.getAnalyzerColumnValues().size() - 1);
                    readSpreadSheet.getAnalyzerColumnValues().add(lastElement);
                    addedAnalyzer.add(lastElement);
                    changedThisIteration = true;
                } else { // Lista Analyzer vazia e outras também esgotadas ou vazias
                    String placeholder = "FILLER_ANALYZER_" + System.nanoTime();
                    readSpreadSheet.getAnalyzerColumnValues().add(placeholder);
                    addedAnalyzer.add(placeholder);
                    changedThisIteration = true;
                }
            }
        }
    }

    public void result() {
        System.out.println("--- Resultados da Validação ---");
        System.out.println("Tamanho inicial da BOP: " + initialSizeBOP);
        System.out.println("Tamanho inicial da Multi: " + initialSizeMulti);
        System.out.println("Tamanho inicial da Analyzer: " + initialSizeAnalyzer);
        System.out.println("Tamanho final da BOP: " + readSpreadSheet.getBopColumnValues().size());
        System.out.println("Tamanho final da Multi: " + readSpreadSheet.getMultiColumnValues().size());
        System.out.println("Tamanho final da Analyzer: " + readSpreadSheet.getAnalyzerColumnValues().size());
        System.out.println("Total de elementos adicionados ao Analyzer: " + addedAnalyzer.size());
        System.out.println("Total de elementos adicionados ao Multi: " + addedMulti.size());
        System.out.println("Total de elementos adicionados ao BOP: " + addedBOP.size());
        
        System.out.println("Multi Added (detalhes):");
        for(String element : addedMulti){
            System.out.println(element);
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
    
    public List<String> getAddedAnalyzer() {
        return new ArrayList<>(addedAnalyzer); 
    }

    public List<String> getAddedMulti() {
        return new ArrayList<>(addedMulti);
    }

    public List<String> getAddedBOP() {
        return new ArrayList<>(addedBOP);
    }
}