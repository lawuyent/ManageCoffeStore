package main;
import entity.login;


public class Auth {

    public static login User = null;

    public static void clear() {
        Auth.User = null;
    }

    public static boolean isLogin() {
        return Auth.User != null;
    }
    
    public static boolean isManager(){
        return  Auth.isLogin() && Boolean.valueOf(User.getChucvu());
    }
}

