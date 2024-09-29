package sn.odc.oumar.springproject.Web.Dtos.Response;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import sn.odc.oumar.springproject.Web.Dtos.Response.impl.Imprimable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

public class ExcelExporter<T> implements Imprimable<T> {

    @Override
    public void exportToExcel(List<T> data, String fileName) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Data");

        // Créer l'en-tête
        Row headerRow = sheet.createRow(0);
        createHeader(headerRow);

        // Remplir les données
        int rowCount = 1;
        for (T item : data) {
            Row row = sheet.createRow(rowCount++);
            fillData(row, item);
        }

        // Écrire dans le fichier
        try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void createHeader(Row headerRow) {
        // Définir les colonnes de l'en-tête
        headerRow.createCell(0).setCellValue("Colonne 1");
        headerRow.createCell(1).setCellValue("Colonne 2");
        // Ajoutez d'autres colonnes selon vos besoins
    }

    private void fillData(Row row, T item) {
        // Utiliser la réflexion pour obtenir les attributs de l'objet
        Field[] fields = item.getClass().getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true); // Rendre les champs accessibles
            try {
                Object value = fields[i].get(item); // Obtenir la valeur du champ
                if (value != null) {
                    row.createCell(i).setCellValue(value.toString()); // Remplir la cellule avec la valeur
                } else {
                    row.createCell(i).setCellValue(""); // Valeur vide si null
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace(); // Gérer l'exception selon vos besoins
            }
        }
    }


}

