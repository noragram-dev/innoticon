package client.db;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 7.
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class Path {
    public static String getUserRootPath(String uid){
        if(uid==null){ return null; }
        return "/user/" + uid;
    }

    public static String getUserClientRootPath(String uid){
        if(uid==null){ return null; }
        return getUserRootPath(uid) + "/client";
    }
    public static String getUserClientPath(String uid, String device, String app) {
        if(uid==null || device==null || app==null){ return null; }
        return getUserClientRootPath(uid) + "/" + device + "/" + app;
    }
    
    public static String getUserRequestRootPath(String uid){
        if(uid==null){ return null; }
        return getUserRootPath(uid) + "/request";
    }
    public static String getUserResponseRootPath(String uid){
        if(uid==null){ return null; }
        return getUserRootPath(uid) + "/response";
    }

    public static String getUserRequestPath(String uid, innoticon.ds.Req req){
        if(uid==null || req==null || req.action==null || req.action.key==null || req.action.key.s==null){ return null; }
        return getUserRequestRootPath(uid) + "/" + req.action.key.s.hex();
    }

    public static String getUserResponsePath(String uid, innoticon.ds.Req req){
        if(uid==null || req==null || req.action==null || req.action.key==null || req.action.key.s==null){ return null; }
        return getUserResponseRootPath(uid) + "/" + req.action.key.s.hex() + "/main";
    }
    public static String getUserResponsePath(String uid, innoticon.ds.Req req, innoticon.ds.Res.Key key) {
        if(uid==null || req==null || req.action==null || req.action.key==null || req.action.key.s==null || req.action.key.c==null || key==null){ return null; }
        return getUserResponseRootPath(uid) + "/" + req.action.key.s.hex() + "/" + req.action.key.c.hex() + "/" + key.hex();
    }

    public static String getUserProfileRootPath(String uid){
        if(uid==null){ return null; }
        return getUserRootPath(uid) + "/profile";
    }
    public static String getUserProfileMainPath(String uid) {
        if(uid==null){ return null; }
        return getUserProfileRootPath(uid) + "/main";
    }
    public static String getUserProfileMainEmailPath(String uid) {
        if(uid==null){ return null; }
        return getUserProfileMainPath(uid) + "/email";
    }
    public static String getUserProfileMainPhonePath(String uid) {
        if(uid==null){ return null; }
        return getUserProfileMainPath(uid) + "/phone";
    }
    public static String getUserProfileMainNamePath(String uid) {
        if(uid==null){ return null; }
        return getUserProfileMainPath(uid) + "/name";
    }
    public static String getUserProfilePath(String uid, String provider) {
        if(uid==null || provider==null){ return null; }
        return getUserProfileRootPath(uid) + "/" + provider;
    }

    public static String getUserInboxRootPath(String uid) {
        if(uid==null){ return null; }
        return getUserRootPath(uid) + "/inbox";
    }
    public static String getUserInvitationInboxRootPath(String uid) {
        if(uid==null){ return null; }
        return getUserInboxRootPath(uid) + "/invitation";
    }

    public static String getUserInvitationPath(String uid, String friend){
        if(uid==null || friend==null){ return null; }
        return getUserInvitationInboxRootPath(uid) + "/" + friend;
    }

    public static String getUserMessageInboxRootPath(String uid) {
        if (uid == null) {
            return null;
        }
        return getUserInboxRootPath(uid) + "/message";
    }

    public static String getUserFriendRootPath(String uid) {
        if(uid==null){ return null; }
        return getUserRootPath(uid) + "/friend";
    }
    public static String getUserFriendPath(String uid, String friend) {
        if(uid==null || friend==null){ return null; }
        return getUserFriendRootPath(uid) + "/" + friend;
    }

    public static String getUserFriendUpdateTimePath(String uid, String friend){
        if(uid==null || friend==null){ return null; }
        return getUserFriendRootPath(uid) + "/" + friend + "/update";
    }
}