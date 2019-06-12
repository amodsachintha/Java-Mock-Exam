package Question02;

public class Ques2a {  // Class LoginMain
    public static void main(String[] args) {
        Login login1 = Login.getInstance();
        Login login2 = Login.getInstance();

        System.out.println("Login status: " + login1.validateUser("Manju","Manju"));
        if(login1 == login2){
            System.out.println("login1 and login2 references the single object!");
        }else {
            System.out.println("Objects are different!");
        }
    }
}

class Login {
    private static Login instance = null;

    static Login getInstance() {
        if (instance == null) {
            instance = new Login();
        }
        return instance;
    }

    boolean validateUser(String username, String password) {
        return (username.equals("Manju") && password.equals("Manju"));

    }
}
