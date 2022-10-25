package models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Data
public class users {
    @NonNull
    private int id;
    @NonNull
    private String F_name;
    @NonNull
    private String S_name;

    private String user_name;
    private String pass_word;

    public users(int id, @NonNull String f_name, @NonNull String s_name, String user_name, String pass_word) {
        this.id = id;
        F_name = f_name;
        S_name = s_name;
        this.user_name = user_name;
        this.pass_word = pass_word;
    }

    @NonNull
    public int getId() {
        return id;
    }

    @NonNull
    public String getF_name() {
        return F_name;
    }

    @NonNull
    public String getS_name() {
        return S_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getPass_word(){
        return pass_word;
    }


    //    private
}
