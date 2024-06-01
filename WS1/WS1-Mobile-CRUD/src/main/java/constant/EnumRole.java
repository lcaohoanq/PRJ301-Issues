package constant;

public enum EnumRole {
    USER("US", 0),
    MANAGER("MN", 1),
    STAFF("ST", 2);

    private final int code;
    private final String prefix;

    EnumRole(String prefix, int code) {
        this.prefix = prefix;
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public String getPrefix() {
        return prefix;
    }
    
    public static EnumRole fromPrefix(String prefix) {
        for (EnumRole role : values()) {
            if (role.getPrefix().equals(prefix)) {
                return role;
            }
        }
        return null;
    }
}
