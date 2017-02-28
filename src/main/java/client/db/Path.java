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
        if(uid==null || req==null){ return null; }
        return getUserRequestPath(uid, req.action);
    }

    public static String getUserResponsePath(String uid, innoticon.ds.Req req){
        if(uid==null || req==null){ return null; }
        return getUserResponsePath(uid, req.action);
    }
    public static String getUserResponsePath(String uid, innoticon.ds.Req req, innoticon.ds.Res.Key key) {
        if(uid==null || req==null){ return null; }
        return getUserResponsePath(uid, req.action, key);
    }

    public static String getUserRequestPath(String uid, innoticon.ds.Action action){
        if(uid==null || action==null || action.key==null || action.key.s==null){ return null; }
        return getUserRequestRootPath(uid) + "/" + action.key.s.hex();
    }

    public static String getUserResponsePath(String uid, innoticon.ds.Action action){
        if(uid==null || action==null || action.key==null || action.key.s==null){ return null; }
        return getUserResponseRootPath(uid) + "/" + action.key.s.hex() + "/main";
    }
    public static String getUserResponsePath(String uid, innoticon.ds.Action action, innoticon.ds.Res.Key key) {
        if(uid==null || action==null || action.key==null || action.key.s==null || action.key.c==null || key==null){ return null; }
        return getUserResponseRootPath(uid) + "/" + action.key.s.hex() + "/" + action.key.c.hex() + "/" + key.hex();
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
    public static String getUserProfileMainDescriptionPath(String uid) {
        if(uid==null){ return null; }
        return getUserProfileMainPath(uid) + "/description";
    }


    public static String getUserProfileMainNamePath(String uid) {
        if(uid==null){ return null; }
        return getUserProfileMainPath(uid) + "/name";
    }
    public static String getUserProfilePath(String uid, String provider) {
        if(uid==null || provider==null){ return null; }
        return getUserProfileRootPath(uid) + "/" + provider;
    }

    public static String getUserApiRootPath(String uid) { return getUserRootPath(uid) + "/api"; }
    public static String getUserApiPath(String uid, String name){ return getUserApiRootPath(uid) + "/" + name; }

    public static String getUserInboxRootPath(String uid) {
        if(uid==null){ return null; }
        return getUserRootPath(uid) + "/inbox";
    }

    public static String getUserEnvelopePath(String uid, innoticon.ds.Envelope envelope){
        if(uid==null || envelope==null || envelope.action==null || envelope.action.key==null){
            return null;
        }
        return getUserInboxRootPath(uid) + "/" + envelope.action.key.hex();
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

    public static String getUserFriendProfilePath(String uid, String friend){
        if(uid==null || friend==null){ return null; }
        return getUserFriendRootPath(uid) + "/" + friend + "/profile";
    }

    public static String getUserBlockRootPath(String uid){
        if(uid==null){ return null; }
        return getUserRootPath(uid) + "/block";
    }

    public static String getUserBlockPath(String uid, String user){
        if(uid==null || user==null) { return null; }
        return getUserRootPath(uid) + "/block/" + user + "/timestamp";
    }

    public static String getUserMuteRootPath(String uid){
        if(uid==null){ return null; }
        return getUserRootPath(uid) + "/mute";
    }

    public static String getUserMutePath(String uid, String user){
        if(uid==null || user==null) { return null; }
        return getUserRootPath(uid) + "/mute/" + user + "/timestamp";
    }

    public static String getUserMuteInboxPath(String uid, String user){
        if(uid==null || user==null) { return null; }
        return getUserRootPath(uid) + "/mute/" + user + "/inbox";
    }

    public static String getUserDialogRootPath(String uid){
        if(uid==null){ return null; }
        return getUserRootPath(uid) + "/dialog";
    }

    public static String getUserDialogPath(String uid, innoticon.req.Dialog.Key key){
        if(uid==null || key==null){ return null; }
        return getUserDialogRootPath(uid) + "/" + key.hex();
    }

    public static String getUserDialogFriendRootPath(String uid){
        if(uid==null){ return null; }
        return getUserDialogRootPath(uid) + "/friend";
    }

    public static String getUserDialogFriendRootPath(String uid, String friend, innoticon.ds.Envelope envelope){
        String root = getUserDialogFriendRootPath(uid);
        if(root==null || friend==null || envelope==null || envelope.action==null || envelope.action.key==null){
            return null;
        }
        return root + "/" + friend + "/" + envelope.action.key.hex();
    }

    public static String getUserDialogFriendSummaryRootPath(String uid){
        String root = getUserDialogFriendRootPath(uid);
        if(root==null){
            return null;
        }
        return root + "/summary";
    }

    public static String getUserDialogFriendSummaryPath(String uid, String friend){
        String root = getUserDialogFriendRootPath(uid);
        if(root==null || friend==null){
            return null;
        }
        return root + "/summary/" + friend;
    }
}