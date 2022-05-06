package tests.addemployee;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import static constants.Constant.Urls.YAWARE_LOGIN_PAGE;

public class YawareAddEmployeeTest extends BaseTest {

    @BeforeTest
    public void YawareImportTest()  {
        basePage
                .open(YAWARE_LOGIN_PAGE);
        yawareLoginPage
                .enterLoginPassword()
                .clickEnter();
        yawareTimeTrackerPage
                .dropdownToggleClick();
        yawareAddEmployee
                .importEmployeesButtonClick();
        modalFileChoose
                .modalFileChooseSendKeys()
                .modalButtonClick()
                .inviteCheckboxCheck()
                .modalButtonClick();
        yawareAddEmployee
                .messageIsShown();
        basePage
                .refresh();
    }

    @Test
    public void YawareImportWindows() throws IOException, UnsupportedFlavorException {
        basePage
                .refresh();
        yawareAddEmployee
                .windowsLinkIsCorrect();
    }

    @Test
    public void YawareImportLinux() throws IOException, UnsupportedFlavorException {
        basePage
                .refresh();
        yawareAddEmployee
                .linuxLinkIsCorrect();
    }

    @Test
    public void YawareImportMacos() throws IOException, UnsupportedFlavorException {
        basePage
                .refresh();
        yawareAddEmployee
                .macosLinkIsCorrect();
    }

    @Test
    public void YawareImportResend() {
        basePage
                .refresh();
        yawareAddEmployee
                .resendInvitation()
                .messageIsShown();
    }

    @Test
    public void YawareImportDelete() {
        basePage
                .refresh();
        yawareAddEmployee
                .deleteInvitation();
        modalFileChoose
                .modalButtonClick();
        yawareAddEmployee
                .messageIsShown()
                .itemIsDeleted();
    }

}
