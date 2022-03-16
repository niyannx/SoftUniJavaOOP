package SOLIDLab.p04_InterfaceSegregation.p02_identity.interfaces;

public interface RegistrationRestrictions {
    boolean getRequireUniqueEmail();
    int getMinRequiredPasswordLength();
    int getMaxRequiredPasswordLength();
}
