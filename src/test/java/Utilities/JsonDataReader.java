package Utilities;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;

public class JsonDataReader {

    public String firstName,lastName,password,newPassword, successRegisterMessage,enquiryText,enquirySuccessMessage,
            searchText,logoutLinkText,passwordChangedMessage,orderSuccessMessage,currencyValue,currencySymbol,
            wishlistSuccessMessage,productName,reviewSuccessMessage,reviewText,reviewTitle,cartSuccessMessage,
            country,city,address,zipCode,phone;

    public void readJsonFile() {
        JsonParser parser = new JsonParser();
        try {
            Object obj = parser.parse(new FileReader("src/test/java/Utilities/Data.json"));
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
            country = jsonObject.get("country").getAsString();
            city = jsonObject.get("city").getAsString();
            address = jsonObject.get("address").getAsString();
            zipCode = jsonObject.get("zip code").getAsString();
            phone = jsonObject.get("phone").getAsString();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
