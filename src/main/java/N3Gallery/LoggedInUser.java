package N3Gallery;

import N3Gallery.model.User;

public class LoggedInUser {
  private static LoggedInUser instance;
  private User user;

  public static LoggedInUser getInstance() {
    if (instance == null) {
      instance = new LoggedInUser();
    }

    return instance;
  }

  public void set(User user) {
    this.user = user;
  }

  public User get() {
    return this.user;
  }
}
