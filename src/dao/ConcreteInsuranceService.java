package dao;
import entity.Policy;
import java.util.List;
public class ConcreteInsuranceService extends InsuranceServiceImpl {
    public Policy getPolicy(int policyId) {
        return policies.stream()
                .filter(policy -> policy.getPolicyId() == policyId)
                .findFirst()
                .orElse(null);
    }
    public List<Policy> getAllPolicies() {
        return policies;
    }
}
