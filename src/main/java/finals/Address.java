package finals;

public class Address {
    private final String detail;
    private final String postCode;

    public Address(String detail, String postCode) {
        this.detail = detail;
        this.postCode = postCode;
    }

    public String getDetail() {
        return this.detail;
    }

    public String getPostCode() {
        return this.postCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == Address.class) {
            var ad = (Address) obj;
            return this.getDetail().equals(ad.getDetail()) && this.getPostCode().equals(ad.getPostCode());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return detail.hashCode() + postCode.hashCode() * 31;
    }
}

