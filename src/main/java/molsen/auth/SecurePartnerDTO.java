package molsen.auth;

public class SecurePartnerDTO {

    private final Long partnerId;
    private final String partnerName;

    SecurePartnerDTO(Long partnerId, String partnerName) {
        this.partnerId = partnerId;
        this.partnerName = partnerName;
    }

    public Long getPartnerId() {
        return partnerId;
    }

    public String getPartnerName() {
        return partnerName;
    }
}
