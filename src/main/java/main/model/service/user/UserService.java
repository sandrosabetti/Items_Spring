package main.model.service.user;

import main.model.entity.User;

public interface UserService {

    User getUser(String login);

}