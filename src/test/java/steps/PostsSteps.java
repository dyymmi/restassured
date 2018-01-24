package steps;

import actions.PostsActions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import domain.Post;
import org.junit.Assert;
import utils.ResponseHelper;
import utils.ResponseHolder;

public class PostsSteps {
    private ResponseHolder responseHolder;
    private static PostsActions postsActions = new PostsActions();

    public PostsSteps(ResponseHolder responseHolder) {
        this.responseHolder = responseHolder;
    }

    @When("^I get post for id (\\d+)$")
    public void iGetPostForId(int id) {
        responseHolder.setResponse(postsActions.getPostForId(id));
    }

    @Then("^Returned post should have id (\\d+)$")
    public void returnedPostShouldHaveId(int id) throws Throwable {
        Post post = ResponseHelper.getObjectFromResponse(responseHolder.getResponse(), Post.class);
        Assert.assertEquals("Post id is not correct", id, post.getId());
    }

    @And("^title should be \"([^\"]*)\"$")
    public void titleShouldBe(String title) throws Throwable {
        Post post = ResponseHelper.getObjectFromResponse(responseHolder.getResponse(), Post.class);
        Assert.assertEquals("Post title does not match", title, post.getTitle());
    }

    @And("^userId should be (\\d+)$")
    public void useridShouldBe(int id) throws Throwable {
        Post post = ResponseHelper.getObjectFromResponse(responseHolder.getResponse(), Post.class);
        Assert.assertEquals("User ID is incorrect", id, post.getUserId());
    }

}
