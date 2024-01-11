package org.example;
import software.amazon.awssdk.services.iam.IamClient;
import software.amazon.awssdk.services.iam.model.*;

import java.util.List;

public class createIAMUser {

    public static void main(String[] args) {

        try (IamClient iamClient = IamClient.builder().build()) {

            ListUsersRequest listUsersRequest=ListUsersRequest.builder().build();
            ListUsersResponse listUsersResponse=iamClient.listUsers(listUsersRequest);
            List<User> usrList=listUsersResponse.users();
            for (User usr:usrList)
            {
                System.out.println(usr.userName());
            }
            /* System.out.println(createUserResponse); */
            UpdateUserRequest updateUserRequest= UpdateUserRequest.builder()
                    .userName("firstUser1")
                    .newUserName("javaUser").build();
            iamClient.updateUser(updateUserRequest);
        } catch (IamException exception) {
            exception.getStackTrace();
        }

    }
}
