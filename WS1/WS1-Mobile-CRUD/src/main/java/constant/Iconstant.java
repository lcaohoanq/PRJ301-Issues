package constant;

import util.EnvUtils;

public class Iconstant {
    public static final String GOOGLE_CLIENT_ID = EnvUtils.get("GOOGLE_CLIENT_ID");
    public static final String GOOGLE_CLIENT_SECRET = EnvUtils.get("GOOGLE_CLIENT_SECRET");
    public static final String GOOGLE_REDIRECT_URI = EnvUtils.get("GOOGLE_REDIRECT_URI");
    public static final String GOOGLE_GRANT_TYPE = EnvUtils.get("GOOGLE_GRANT_TYPE");
    public static final String GOOGLE_LINK_GET_TOKEN = EnvUtils.get("GOOGLE_LINK_GET_TOKEN");
    public static final String GOOGLE_LINK_GET_USER_INFO = EnvUtils.get("GOOGLE_LINK_GET_USER_INFO");
}
