import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class CommentsTest extends FunctionalTest {
    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Test
    public void CommentTest() throws Exception {
        CommentsTest commentsTest = given().when().get("/comments/1").as(CommentsTest.class);

        assertTrue(commentsTest.postId == 1);
        assertTrue(commentsTest.id == 1);
        assertTrue(commentsTest.email.equals("Eliseo@gardner.biz"));
    }
}
