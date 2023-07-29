package Pages;

import Base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends PageBase {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    private final By countryDropdownList = By.id("BillingNewAddress_CountryId");
    private final By cityTxtBox = By.id("BillingNewAddress_City");
    private final By addressTxtBox = By.id("BillingNewAddress_Address1");
    private final By zipCodeTxtBox = By.id("BillingNewAddress_ZipPostalCode");
    private final By phoneNumberTxtBox = By.id("BillingNewAddress_PhoneNumber");
    private final By billingAddressContinueBtn = By.cssSelector("#billing-buttons-container > .button-1.new-address-next-step-button");
    private final By shippingMethodContinueBtn = By.cssSelector(".button-1.shipping-method-next-step-button");
    private final By paymentMethodContinueBtn = By.cssSelector(".button-1.payment-method-next-step-button");
    private final By paymentInformationContinueBtn = By.cssSelector(".button-1.payment-info-next-step-button");
    private final By confirmInformationContinueBtn = By.cssSelector(".button-1.confirm-order-next-step-button");
    private final By orderSuccessMessage = By.cssSelector(".section.order-completed > div.title > strong");

    public void finishOrder (String country,String city,String address, String zipCode,String phoneNumber) {
        selectFromDropDown(countryDropdownList,country);
        setTxtBoxText(cityTxtBox,city);
        setTxtBoxText(addressTxtBox,address);
        setTxtBoxText(zipCodeTxtBox,zipCode);
        setTxtBoxText(phoneNumberTxtBox,phoneNumber);
        clickButton(billingAddressContinueBtn);
        clickButton(shippingMethodContinueBtn);
        clickButton(paymentMethodContinueBtn);
        clickButton(paymentInformationContinueBtn);
        clickButton(confirmInformationContinueBtn);
    }

    public String getOrderSuccessMessage(){
        waitTillElementAppear(orderSuccessMessage,15);
        return getElementText(orderSuccessMessage);
    }


}
