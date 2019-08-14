package lxw.addressbook.addressbook.domain;

public class Sieve {
    private Integer id;

    private Integer userId;

    private String jetton;

    private String highest;

    private Integer quickNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getJetton() {
        return jetton;
    }

    public void setJetton(String jetton) {
        this.jetton = jetton == null ? null : jetton.trim();
    }

    public String getHighest() {
        return highest;
    }

    public void setHighest(String highest) {
        this.highest = highest == null ? null : highest.trim();
    }

    public Integer getQuickNum() {
        return quickNum;
    }

    public void setQuickNum(Integer quickNum) {
        this.quickNum = quickNum;
    }
}