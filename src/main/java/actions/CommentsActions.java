package actions;

import controllers.CommentsController;
import io.restassured.response.Response;
import specs.DefaultSpecStrategy;

public class CommentsActions {

    private static CommentsController commentsController = new CommentsController(new DefaultSpecStrategy());

    public Response getCommentForId(int id) {
        return commentsController.getComment(id);
    }

}
