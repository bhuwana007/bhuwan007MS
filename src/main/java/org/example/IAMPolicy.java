package org.example;

import software.amazon.awssdk.core.exception.SdkException;
import software.amazon.awssdk.services.iam.IamClient;
import software.amazon.awssdk.services.iam.model.*;

public class IAMPolicy
{
    public static void main(String[] args) throws RuntimeException {
        try {
            IamClient iamClient = IamClient.builder().build();

            ListPoliciesRequest listPoliciesRequest = ListPoliciesRequest.builder().build();
            ListPoliciesResponse listPoliciesResponse = iamClient.listPolicies(listPoliciesRequest);
            for (Policy policy : listPoliciesResponse.policies()) {
                System.out.println(policy.policyName());
            }
            iamClient.close();
        } catch (SdkException e) {
            throw new RuntimeException(e);
        }
    }
}
