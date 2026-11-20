package warung.util;

import warung.model.User;

public final class Session {
    private static User user;
    private Session() {}
    public static User getUser() { return user; }
    public static void setUser(User pengguna) { user = pengguna; }
    public static void clear() { user = null; }
}
