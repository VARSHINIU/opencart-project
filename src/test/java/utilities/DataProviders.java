package utilities;

import org.testng.annotations.DataProvider;
import utilities.resourceExcelUtils;

import java.awt.image.ImagingOpException;
import java.io.IOException;


public class DataProviders {


    @DataProvider(name = "loginValidInvaliddatas")
    public String[][] logindatas() throws IOException {
        String path= System.getProperty("user.dir")+"\\Excelfiles\\Login.xlsx";
           resourceExcelUtils xutil=new resourceExcelUtils(path);
           int rows=xutil.getRowCount("Sheet1");
           int cols=xutil.getCellCount("Sheet1",0);

            String[][] login=new String[rows][cols];
           for(int i=1;i<=rows;i++){
               for(int j=0;j<cols;j++){
                   login[i-1][j]=xutil.getCellData("Sheet1",i,j);
               }
           }
           return login;
    }

}
