package Pages;

import Base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MyAccountPage extends PageBase
{
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	

	private final By changePasswordLink = By.linkText("Change password");
    private final By oldPasswordTxtBox = By.id("OldPassword");
    private final By newPasswordTxtBox = By.id("NewPassword");
    private final By confirmPasswordTxtBox = By.id("ConfirmNewPassword");
    private final By changePasswordBtn = By.cssSelector("button[class='button-1 change-password-button']");
    private final By changePasswordResult = By.cssSelector("p.content");
    private final By resultCloseBtn = By.cssSelector("span.close");



	
	public void openChangePasswordPage()
	{
		clickButton(changePasswordLink);
	}

	public void changePassword(String oldPassword, String newPassword) {
        setTxtBoxText(oldPasswordTxtBox, oldPassword);
        setTxtBoxText(newPasswordTxtBox, newPassword);
        setTxtBoxText(confirmPasswordTxtBox, newPassword);
        clickButton(changePasswordBtn);
        clickButton(resultCloseBtn);
    }

    public String getChangePasswordResult (){
        return getElementText(changePasswordResult);
    }

}
