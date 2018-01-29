package actions;

import controllers.UsersController;
import io.restassured.response.Response;
import specs.DefaultSpecStrategy;

public class UsersActions {
    private static UsersController usersController = new UsersController(new DefaultSpecStrategy());

    public Response getUserForId(int id) {
        return usersController.getUser(id);
    }
}
