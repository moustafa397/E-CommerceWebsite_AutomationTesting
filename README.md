# E-CommerceWebsite_AutomationTesting


 # 🎯 *Nop Commerce*  *GUI* *Test Automation* 
### 🌐Website URL: https://demo.nopcommerce.com/










- ### ✒️ Project Tools,Features & Design:


   *Selenium Webdriver using Java.*


   *TestNG*


   *Allure Report*


   *Java-faker Library for generating data*


   *Reading test data from JSON file.*


   *Helper class for taking screenshot when a test case fail*


   *Page Object Model (POM) design pattern*




 - ### 🔭 Project Scope:


  *The project involves developing and
  executing automated test scripts to
  validate the functionality and usability of
  the web GUI of an e-commerce website.
  The goal is to ensure that the website is
  functioning as expected and providing a
  seamless user experience for
  customers,by applying E2E testing.*












 - ### 🔬 Covered Test Scenarios in this project :
#### ▶️Test Case 1: User register to the website.  ✅
1. Launch browser
2. Navigate to URL 'https://demo.nopcommerce.com/'
3. Open the register page.


4. enter valid data and click on register.
5. verify that the register completed successfully.
6. login with the registered user.


#### ▶️Test Case 2: User Login to the website.  ✅
1. Launch browser
2. Navigate to URL 'https://demo.nopcommerce.com/'
3. Open register page.
4. enter valid data and click on register.
5. verify that the register completed successfully.
6. login with the registered user.


#### ▶️Test Case 3: Registered user change account’s password.  ✅
1. Launch browser
2. Navigate to url 'https://demo.nopcommerce.com/'
3. Open register page.
4. enter valid data and click on register.
5. verify that the register completed successfully.
6. login with the registered user.
7. Navigate to my account page.
8. Navigate to change password page.
9. Enter old password and the new password.
10. verify that password changed successfully.
11. Log out from the account.
12. Log in using the new password.


#### ▶️Test Case 4: User make search for a product using search feature (Search Button).  ✅
1. Launch browser
2. Navigate to url 'https://demo.nopcommerce.com/'
3. Enter product name'HTC' in search text box and press search button.
4. Verify that all the products displayed on the search results' page related to the searched text 'HTC'.


#### ▶️Test Case 5: User make search for a product using search auto-complete..  ✅
1. Launch browser
2. Navigate to url 'https://demo.nopcommerce.com/'
3. Enter product name'HTC' in search text box and press on the first suggested product.
4. verify that the product related to the searched text 'HTC'.


#### ▶️Test Case 6: User send enquiry by contact us feature.  ✅
1. Launch browser
2. Navigate to url 'https://demo.nopcommerce.com/'
3. Scroll down and click on contact us .
4. Enter name,email & enquiry then click Submit.
5. Verify that the enquiry has been sent successfully.


#### ▶️Test Case 7: User change the currency of the website.  ✅
1. Launch browser
2. Navigate to url 'https://demo.nopcommerce.com/'
3. Get to a product by auto-suggestion search.
4. Click on the currency dropdown menu and change the currency to Euro.
5. Verify that the product price is displayed in Euro.


#### ▶️Test Case 8: User adds product to the wishlist.  ✅
1. Launch browser
2. Navigate to URL 'https://demo.nopcommerce.com/'
3. Get to a product by auto-suggestion search.
4. Click on Add to Wishlist button on the product page.
5. Verify that a success message containing 'The product has been added to your wishlist' appeared.
6. Navigate to the wishlist page.
7. verify that the product has been added to it.


#### ▶️Test Case 9: User adds product to cart.  ✅
1. Launch browser
2. Navigate to url 'https://demo.nopcommerce.com/'
3. Get to a product by auto-suggestion search.
4. Click on Add to Cart button on the product page.
5. Verify that a success message containing 'The product has been added to your shopping cart' appeared.
6. Navigate to the Shopping cart page.
7. verify that the product has been added to it.


#### ▶️Test Case 10: Registered user add product to cart and make checkout.  ✅
1. Launch browser.
2. Navigate to url 'https://demo.nopcommerce.com/'.
3. Open register page.
4. enter valid data and click on register.
5. verify that the register completed successfully.
6. login with the registered user.
4. Get to a product by auto-suggestion search.
5. Click on Add to Cart button on the product page.
6. Verify that a success message containing 'The product has been added to your shopping cart' appeared.
7. Navigate to the Shopping cart page.
8. verify that the product has been added to it.
9. Click on the check out button.
10. Click on the check box of 'i agree to terms' on the checkout page.
11. Click on checkout.
12. Enter valid billing address data and press on continue button.
13. Press on shipping method continue button.
14. Press on payment method continue button.
15. Press on payment information continue button.
16. Press on confirm information continue button.
17. Verify that a success message containing 'Your order has been successfully processed!' appeared.


#### ▶️Test Case 11: User add a review for a product..  ✅
1. Launch browser.
2. Navigate to url 'https://demo.nopcommerce.com/'.
3. Open register page.
4. enter valid data and click on register.
5. verify that the register completed successfully.
6. login with the registered user.
4. Get to a product by auto-suggestion search.
5. Click on Add reivew button on the product page.
6. Enter review title & text.
7. click on review rating radion button.
8. click on submit reiview.
9. Verify that a success message containing 'Product review is successfully added.' appeared.





















