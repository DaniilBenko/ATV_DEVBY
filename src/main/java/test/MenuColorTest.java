package test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;

@Listeners({TestListener.class})
public class MenuColorTest extends AbstractTest {
    @BeforeMethod
    public void beforeMethod() throws MalformedURLException {
        init();
    }

    @Test(description = "Login to YouTube account")
    public void colorCheck() throws MalformedURLException {
        SoftAssert softA = new SoftAssert();
        if (Boolean.TRUE.equals(menu.isBurberPresent()))
        {
            menu.clickBurger();
            for (int i = 0; i < 5; i++) {
                softA.assertTrue(menu.isNotSelectedColorRightMobile(i), "NO");
                System.out.println(menu.getColorChangeMobile(i));
        }}
        else
            {
            for (int i = 0; i < 5; i++) {
            softA.assertTrue(menu.isNotSelectedColorRightDesktop(i), "NO");
//            System.out.println(menu.getColorChangeDesktop(i));
         }
        }

        softA.assertAll();

    }
}