
import com.avirato.service.UserApiService;
import com.avirato.model.service.RootLogin;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cristian
 */
public class TestAvirato {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        
        UserApiService uas = new UserApiService();
        //uas.getAllUserRequest();
        //uas.getSingleUser();
        //uas.postUserRequest();
        //uas.putUserRequest();
        //uas.deleteUserRequest();
        //uas.loginRequest();
        RootLogin rl = new RootLogin("eve.holt@reqres.in","cityslicka"); uas.loginRequestRootLogin(rl);
        //uas.loginPostRequest(rl);
        
        //ClienteHttp cliente = new ClienteHttp();
        //System.out.println(cliente.sendRquestWithAuthHeader());
                
    }
    
}
