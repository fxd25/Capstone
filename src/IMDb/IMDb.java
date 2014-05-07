package IMDb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class IMDb {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Map<String, ExcelRow> data = new HashMap<String, ExcelRow>();
		try {
			FileInputStream file = new FileInputStream(new File("D:\\Sem-3\\Capstone\\Movies-Final.xls"));


			HSSFWorkbook workbook = new HSSFWorkbook(file);


			HSSFSheet sheet = workbook.getSheetAt(0);


			Iterator<Row> rowIterator = sheet.iterator();

			while(rowIterator.hasNext()){
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				Cell cell  = cellIterator.next();
				ExcelRow rowObj1 = data.get(cell.getStringCellValue());
				if(rowObj1 == null){
					ExcelRow rowObj2 = new ExcelRow();
					rowObj2.setMovieId(cell.getStringCellValue());
					Cell placeCell = cellIterator.next();
					rowObj2.setwPlace(placeCell.getStringCellValue());
					Cell dateCell = cellIterator.next();
					rowObj2.setwDate(dateCell.getStringCellValue());
					data.put(rowObj2.getMovieId(), rowObj2);
				}
				else{
					String movieId = rowObj1.getMovieId();
					String wPlace = rowObj1.getwPlace();
					String wDate = rowObj1.getwDate();
					String uPlace = rowObj1.getuPlace();
					String uDate = rowObj1.getuDate();
					String uKPlace = rowObj1.getuKPlace();
					String uKDate = rowObj1.getuKDate();
					String gPlace = rowObj1.getgPlace();
					String gDate = rowObj1.getgDate();
					String iPlace = rowObj1.getiPlace();
					String iDate = rowObj1.getiDate();
					
					data.remove(movieId);
					
					ExcelRow rowObj2 = new ExcelRow();
					rowObj2.setMovieId(movieId);
					rowObj2.setwPlace(wPlace);
					rowObj2.setwDate(wDate);
					
					if(uPlace == null){
						Iterator<Cell> cellIterator1 = row.cellIterator();
						cellIterator1.next();
						Cell placeCell = cellIterator1.next();
						if(placeCell.getStringCellValue().equalsIgnoreCase("USA")){
							rowObj2.setuPlace("USA");
							Cell dateCell = cellIterator1.next();
							rowObj2.setuDate(dateCell.getStringCellValue());
						}
					}
					
					else{
						rowObj2.setuPlace(uPlace);
						rowObj2.setuDate(uDate);
					}
					
					if(uKPlace == null){
						Iterator<Cell> cellIterator1 = row.cellIterator();
						cellIterator1.next();
						Cell placeCell = cellIterator1.next();
						if(placeCell.getStringCellValue().equalsIgnoreCase("UK")){
							rowObj2.setuKPlace("UK");
							Cell dateCell = cellIterator1.next();
							rowObj2.setuKDate(dateCell.getStringCellValue());
						}
					}
					
					else{
						rowObj2.setuKPlace(uKPlace);
						rowObj2.setuKDate(uKDate);	
					}
					
					if(gPlace == null){
						Iterator<Cell> cellIterator1 = row.cellIterator();
						cellIterator1.next();
						Cell placeCell = cellIterator1.next();
						if(placeCell.getStringCellValue().equalsIgnoreCase("Germany")){
							rowObj2.setgPlace("Germany");
							Cell dateCell = cellIterator1.next();
							rowObj2.setgDate(dateCell.getStringCellValue());
						}
					}
					
					else{
						rowObj2.setgPlace(gPlace);
						rowObj2.setgDate(gDate);
					}
					
					if(iPlace == null){
						Iterator<Cell> cellIterator1 = row.cellIterator();
						cellIterator1.next();
						Cell placeCell = cellIterator1.next();
						if(placeCell.getStringCellValue().equalsIgnoreCase("India")){
							rowObj2.setiPlace("India");
							Cell dateCell = cellIterator1.next();
							rowObj2.setiDate(dateCell.getStringCellValue());
						}
					}
					
					else{
						rowObj2.setiPlace(iPlace);
						rowObj2.setiDate(iDate);
					}
					data.put(movieId, rowObj2);
				}
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Required Dates");
		
		Set<String> keySet = data.keySet();
		int rowNo = 0;
		for(String key : keySet){
			Row row = sheet.createRow(rowNo++);
			ExcelRow rowObj = data.get(key);
			Cell cellId = row.createCell(0);
			cellId.setCellValue(rowObj.getMovieId());
			Cell cellW = row.createCell(1);
			cellW.setCellValue(rowObj.getwDate());
			Cell cellUS = row.createCell(2);
			if(rowObj.getuDate() == null){
				cellUS.setCellValue("NA");
			}
			else{
				cellUS.setCellValue(rowObj.getuDate());
			}
			Cell cellUK = row.createCell(3);
			if(rowObj.getuKDate() == null){
				cellUK.setCellValue("NA");
			}
			else{
				cellUK.setCellValue(rowObj.getuKDate());
			}
			Cell cellG = row.createCell(4);
			if(rowObj.getgDate() == null){
				cellG.setCellValue("NA");
			}
			else{
				cellG.setCellValue(rowObj.getgDate());
			}
			Cell cellI = row.createCell(5);
			if(rowObj.getiDate() == null){
				cellI.setCellValue("NA");
			}
			else{
				cellI.setCellValue(rowObj.getiDate());
			}
		}
		
		try{
			FileOutputStream out = new FileOutputStream(new File("D:\\Sem-3\\Capstone\\test-output.xls"));
			workbook.write(out);
			out.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
