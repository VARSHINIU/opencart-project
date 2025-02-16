package testcases;
import pageobjects.MyAccountpage;
import pageobjects.homepage;
import pageobjects.itemspage;
import pageobjects.loginpage;
import testbase.baseclass;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TC003AddToCart extends baseclass{
   @Test
     void itemaddtocart(){
      try {
         homepage hm = new homepage(driver);
         hm.clickmyacc();
         hm.chooselogin();

         loginpage lgn = new loginpage(driver);
         lgn.emaillogin(p.getProperty("email"));
         lgn.passlogin(p.getProperty("password"));
         lgn.clicklogin();

         MyAccountpage macc = new MyAccountpage(driver);
         macc.desktopstomacs();


         itemspage itm = new itemspage(driver);
         itm.addingtocart();
         assertTrue(itm.sucessmsgcart());
      } catch (Exception e) {
         throw new RuntimeException(e);
      }


   }

}
