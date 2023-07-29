package utilties;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;

public class JsonDataReader {

    public String firstName,lastName,password,newPassword, successRegisterMessage,enquiryText,enquirySuccessMessage,
            searchText,logoutLinkText,passwordChangedMessage,orderSuccessMessage,currencyValue,currencySymbol,
            wishlistSuccessMessage,productName,reviewSuccessMessage,reviewText,reviewTitle,cartSuccessMessage;

    public void readJsonFile() {
        JsonParser parser = new JsonParser();
        try {
            Object obj = parser.parse(new FileReader("src/main/java/utilties/Data.json"));
            JsonObject jsonObject = (JsonObject) obj;
            firstName = jsonObject.get("first name").getAsString();
            lastName = jsonObject.get("last name").getAsString();
            password = jsonObject.get("password").getAsString();
            newPassword = jsonObject.get("new password").getAsString();
            successRegisterMessage = jsonObject.get("success register message").getAsString();
            searchText = jsonObject.get("Search text").getAsString();
            logoutLinkText = jsonObject.get("Log out link text").getAsString();
            passwordChangedMessage = jsonObject.get("password changed message").getAsString();
            orderSuccessMessage = jsonObject.get("order success message").getAsString();
            currencyValue = jsonObject.get("currency value").getAsString();
            currencySymbol = jsonObject.get("currency symbol").getAsString();
            wishlistSuccessMessage = jsonObject.get("wishlist success message").getAsString();
            productName = jsonObject.get("product name").getAsString();
            reviewSuccessMessage = jsonObject.get("review success message").getAsString();
            reviewText = jsonObject.get("review text").getAsString();
            reviewTitle = jsonObject.get("review title").getAsString();
            cartSuccessMessage = jsonObject.get("shopping cart success Message").getAsString();
            enquiryText = jsonObject.get("enquiry text").getAsString();
            enquirySuccessMessage = jsonObject.get("enquiry success message").getAsString();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
