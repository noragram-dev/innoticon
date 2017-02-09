package firebase.db;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 7.
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class Path {
    public static String getUserRootPath(String uid){ return "/user/" + uid; }

    public static String getUserClientRootPath(String uid){ return getUserRootPath(uid) + "/client"; }
    public static String getUserClientPath(String uid, String device, String app){ return getUserClientRootPath(uid) + "/" + device + "/" + app; }
    public static String getUserClientRequestRootPath(String uid){ return getUserClientRootPath(uid) + "/request"; }
    public static String getUserClientRequestPath(String uid, String client, String action){ return getUserClientRequestRootPath(uid) + "/" + client + "/" + action; }

    public static String getUserProfileRootPath(String uid){ return getUserRootPath(uid) + "/profile"; }
    public static String getUserProfileMainPath(String uid){ return getUserProfileRootPath(uid) + "/main"; }
    public static String getUserProfilePath(String uid, String provider){ return getUserProfileRootPath(uid) + "/" + provider; }

    public static String getUserInboxRootPath(String uid){ return getUserRootPath(uid) + "/inbox"; }
    public static String getUserInvitationInboxRootPath(String uid){ return getUserInboxRootPath(uid) + "/invitation"; }
    public static String getUserMessageInboxRootPath(String uid){ return getUserInboxRootPath(uid) + "/message"; }

    public static String getUserFriendRootPath(String uid){ return getUserRootPath(uid) + "/friend"; }
    public static String getUserFriendPath(String uid, String friend){ return getUserFriendRootPath(uid) + "/" + friend; }
}