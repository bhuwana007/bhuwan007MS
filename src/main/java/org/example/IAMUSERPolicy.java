package org.example;

import software.amazon.awssdk.services.iam.IamClient;
import software.amazon.awssdk.services.iam.model.AttachUserPolicyRequest;
import software.amazon.awssdk.services.iam.model.AttachUserPolicyResponse;
import software.amazon.awssdk.services.iam.model.IamException;

public class IAMUSERPolicy {
    public static void main(String[] args) {
        try {
            IamClient iamClient=IamClient.builder().build();
            String userName="javaUser";
            String arnPolicy="arn:aws:iam::937550337302:policy/FirstPolicy";

            AttachUserPolicyRequest attachUserPolicyRequest=AttachUserPolicyRequest.builder()
                    .userName(userName)
                    .policyArn(arnPolicy)
                    .build();
            AttachUserPolicyResponse attachUserPolicyResponse=iamClient.attachUserPolicy(attachUserPolicyRequest);
            System.out.println("attached");
            iamClient.close();
        }catch (IamException e)
        {
          System.out.println(e.getStackTrace());
        }

    }
}
