package entity;
import java.util.Date;
public class Claim {
    private int claimId;
    private String claimNumber;
    private Date dateFiled;
    private double claimAmount;
    private String status;
    private String policy; 
    private client client;
    
    public Claim() {}
    public Claim(int claimId, String claimNumber, Date dateFiled, double claimAmount, String status, String policy, client client) {
        this.claimId = claimId;
        this.claimNumber = claimNumber;
        this.dateFiled = dateFiled;
        this.claimAmount = claimAmount;
        this.status = status;
        this.policy = policy;
        this.client = client;
    }
    public int getClaimId() {
        return claimId;
    }
    public void setClaimId(int claimId) {
        this.claimId = claimId;
    }
    public String getClaimNumber() {
        return claimNumber;
    }
    public void setClaimNumber(String claimNumber) {
        this.claimNumber = claimNumber;
    }
    public Date getDateFiled() {
        return dateFiled;
    }
    public void setDateFiled(Date dateFiled) {
        this.dateFiled = dateFiled;
    }
    public double getClaimAmount() {
        return claimAmount;
    }
    public void setClaimAmount(double claimAmount) {
        this.claimAmount = claimAmount;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getPolicy() {
        return policy;
    }
    public void setPolicy(String policy) {
        this.policy = policy;
    }
    public client getClient() {
        return client;
    }
    public void setClient(client client) {
        this.client = client;
    }
    public String toString() {
        return "Claim [claimId=" + claimId + ", claimNumber=" + claimNumber + ", dateFiled=" + dateFiled + ", claimAmount=" + claimAmount +
                ", status=" + status + ", policy=" + policy + ", client=" + client + "]";
    }
}
