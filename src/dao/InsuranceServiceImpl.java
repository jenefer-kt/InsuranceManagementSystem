package dao;
import entity.Policy;
import java.util.ArrayList;
import java.util.List;
public abstract class InsuranceServiceImpl implements IPolicyService {
    protected List<Policy> policies = new ArrayList<>();
    public boolean createPolicy(Policy policy) {
        return policies.add(policy);
    }
    public abstract Policy getPolicy(int policyId);
    public abstract List<Policy> getAllPolicies();
    public boolean updatePolicy(Policy policy) {
        int index = -1;
        for (int i = 0; i < policies.size(); i++) {
            if (policies.get(i).getPolicyId() == policy.getPolicyId()) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            policies.set(index, policy);
            return true;
        }
        return false;
    }
    public boolean deletePolicy(int policyId) {
        return policies.removeIf(policy -> policy.getPolicyId() == policyId);
    }
}
