import java.io.*;

public class UserDb {

    File file = new File("UserDetails.txt");

    public boolean validateUser(String userId, String userPin){
        boolean isUser = false;
        User user = getUser();
        if (user.getUserID().equals(userId) && user.getUserPin().equals(userPin)){
            isUser = true;
            return isUser;
        }else {
            return isUser;
        }
    }
    public User getUser(){
        User user = new User();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            user = (User) objectInputStream.readObject();
        }catch (FileNotFoundException e){
            System.out.println("File Not Found");
        }catch (IOException | ClassNotFoundException e){
            System.out.println("Class Not Found Exception ");
        }
        return user;
    }

    public boolean setUser(User user){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(user);
            objectOutputStream.close();
            fileOutputStream.close();
        }catch (FileNotFoundException e){
            System.out.println("File Not Found");
        }catch (IOException e){
            System.out.println("IOException");
        }
        return true;
    }
}
