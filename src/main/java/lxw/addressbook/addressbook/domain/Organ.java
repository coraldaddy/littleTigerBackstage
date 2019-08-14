package lxw.addressbook.addressbook.domain;

public class Organ {
    private Integer id;

    private String organName;

    private String parentOrganName;

    private String organInfo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName == null ? null : organName.trim();
    }

    public String getParentOrganName() {
        return parentOrganName;
    }

    public void setParentOrganName(String parentOrganName) {
        this.parentOrganName = parentOrganName == null ? null : parentOrganName.trim();
    }

    public String getOrganInfo() {
        return organInfo;
    }

    public void setOrganInfo(String organInfo) {
        this.organInfo = organInfo == null ? null : organInfo.trim();
    }
}