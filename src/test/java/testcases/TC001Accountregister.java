package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.homepage;
import pageobjects.Accountregistrationpage;
import testbase.baseclass;

public class TC001Accountregister extends baseclass {

    @Test
    void validation(){
        logger.info("************starting*******");
        try {
            homepage hmp = new homepage(driver);
            hmp.clickmyacc();
            logger.info("moved to my acc");
            hmp.chooseregister();
            logger.info("moved registration page");

            Accountregistrationpage accr = new Accountregistrationpage(driver);
            String fname = randomString();
            logger.info("providing the information ");
            accr.setFirstname(fname.toUpperCase());
            accr.setlastname(randomString().toUpperCase());
            accr.setmail(randomString() + "@gmail.com");
            accr.setphonenum(randomnum());

            String pass = randompass();

            accr.setPassword(fname + "@" + pass);
            accr.setconfmpass(fname + "@" + pass);
            accr.setnewsletter();
            accr.setagree();
            accr.clickcontinuebtn();
            logger.info("final validation ");
            Assert.assertEquals(accr.successmsg(), "Congratulations! Your new account has been successfully created!");
        }catch(Exception e){
            logger.error("test failed...");
            logger.debug("debug loggs");
            Assert.fail(e.getMessage());
        }
        logger.info("successfully validated");
    }

}
