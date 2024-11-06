package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;
import pages.LoginPages;
import pages.RoomPages;
import utilities.JSUtils;
import utilities.WaitUtils;

public class RoomCreationStepDefs {
LoginPages login=new LoginPages();
RoomPages roomPages=new RoomPages();
public static int roomNumber;
public static String roomID;


    @When("admin clicks Items&Titles button")
    public void adminClicksItemsTitlesButton() {
        login.itemsdAndTitles.click();

    }



    @And("clicks on Create A New Room button")
    public void clicksOnCreateANewRoomButton() {

        WaitUtils.waitForClickablility(login.createANewRoom,5);
        login.createANewRoom.click();
    }

    @And("enters roomNumber into Room Number field")
    public void entersRoomNumberIntoRoomNumberField() {
         roomNumber= Faker.instance().number().numberBetween(10000,100000);
         roomPages.roomNumberInput.sendKeys(roomNumber+"");
    }

    @And("chooses {string} from the dropdown")
    public void choosesFromTheDropdown(String string) {
        Select select= new Select(roomPages.roomTypeDropDown);
        select.selectByIndex(1);
    }

    @And("clicks Status box")
    public void clicksStatusBox() {
        roomPages.statusCheckbox.click();
    }

    @And("enters {string} into Price field")
    public void entersIntoPriceField(String price) {
        roomPages.priceInput.sendKeys(price);
    }

    @And("enters {string} into Description field")
    public void entersIntoDescriptionField(String description) {
        roomPages.descriptionInput.sendKeys(description);
    }

    @And("clicks on Save button")
    public void clicksOnSaveButton() {
        JSUtils.JSscrollIntoView(roomPages.saveSubmitButton);
        WaitUtils.waitFor(3);
        roomPages.saveSubmitButton.click();
    }

    @Then("verify the new room is created")
    public void verifyTheNewRoomIsCreated() {
        WaitUtils.waitForVisibility(roomPages.alertMessage,3);
        roomID=  roomPages.alertMessage.getText().replaceAll("[^0-9]","");
    }

}
