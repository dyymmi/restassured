package actions;

import controllers.PostsController;
import io.restassured.response.Response;
import specs.DefaultSpecStrategy;

public class PostsActions {

    private static PostsController postsController = new PostsController(new DefaultSpecStrategy());

    public Response getPostForId(int id) {
        return postsController.getPost(id);
    }
}
