package steps;

import actions.CommentsActions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import domain.Comment;
import org.junit.Assert;
import utils.ResponseHelper;
import utils.ResponseHolder;

public class CommentsSteps {
    private ResponseHolder responseHolder;
    private static CommentsActions commentsActions = new CommentsActions();

    public CommentsSteps(ResponseHolder responseHolder) {
        this.responseHolder = responseHolder;
    }

    @When("^I get comment for id (\\d+)$")
    public void iGetCommentForId(int id) {
        responseHolder.setResponse(commentsActions.getCommentForId(id));
    }

    @Then("^Returned comment should have id (\\d+)$")
    public void returnedCommentShouldHaveIdCommentId(int id) throws Throwable {
        Comment comment = ResponseHelper.getObjectFromResponse(responseHolder.getResponse(), Comment.class);
        Assert.assertEquals("Comment id is not correct", id, comment.getId());
    }

    @And("^name should be \"([^\"]*)\"$")
    public void nameShouldBe(String name) throws Throwable {
        Comment comment = ResponseHelper.getObjectFromResponse(responseHolder.getResponse(), Comment.class);
        Assert.assertEquals("Name is incorrect", name, comment.getName());
    }

    @And("^email should be \"([^\"]*)\"$")
    public void emailShouldBe(String email) throws Throwable {
        Comment comment = ResponseHelper.getObjectFromResponse(responseHolder.getResponse(), Comment.class);
        Assert.assertEquals("Emails do not match", email, comment.getEmail());
    }
}
