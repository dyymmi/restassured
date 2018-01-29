package steps;

import actions.UsersActions;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.ResponseHelper;
import utils.ResponseHolder;

public class UsersSteps {
    private ResponseHolder responseHolder;
    private static UsersActions usersActions = new UsersActions();

    public UsersSteps(ResponseHolder responseHolder) {
        this.responseHolder = responseHolder;
    }

    @When("^I get user for id (\\d+)$")
    public void iGetUserForId(int id) throws Throwable {
        responseHolder.setResponse(usersActions.getUserForId(id));
    }

    @Then("^returned JSON is compliant with \"([^\"]*)\"$")
    public void returnedJSONIsCompliantWith(String schema) throws Throwable {
        ResponseHelper.validateResponseSchema(responseHolder.getResponse(), schema);
    }
}
