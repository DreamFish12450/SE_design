package main.com.wswenyue.db.domain;

public class Amount {
    String username;
    int vip_level;
    int total_amount;

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "Amount{" +
                "username='" + username + '\'' +
                ", vip_level=" + vip_level +
                ", total_amount=" + total_amount +
                '}';
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getVip_level() {
        return vip_level;
    }

    public void setVip_level(int vip_level) {
        this.vip_level = vip_level;
    }

    public int getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(int total_amount) {
        this.total_amount = total_amount;
    }

    public Amount(String username, int vip_level, int total_amount) {
        this.username = username;
        this.vip_level = vip_level;
        this.total_amount = total_amount;
    }
}
