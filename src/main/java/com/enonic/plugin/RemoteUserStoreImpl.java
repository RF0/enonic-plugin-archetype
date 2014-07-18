package com.enonic.plugin;

import com.enonic.cms.api.plugin.ext.userstore.*;

import java.util.List;
import java.util.Set;

public class RemoteUserStoreImpl implements RemoteUserStore{

    @Override
    public Set<UserFieldType> getSupportedFieldTypes() {
        return null;
    }

    @Override
    public boolean authenticate(String s, String s2) {
        return false;
    }

    @Override
    public RemoteUser getUser(String s) {
        return null;
    }

    @Override
    public List<RemoteUser> getAllUsers() {
        return null;
    }

    @Override
    public RemoteGroup getGroup(String s) {
        return null;
    }

    @Override
    public List<RemoteGroup> getAllGroups() {
        return null;
    }

    @Override
    public boolean changePassword(String s, String s2) {
        return false;
    }

    @Override
    public boolean addPrincipal(RemotePrincipal remotePrincipal) {
        return false;
    }

    @Override
    public boolean updatePrincipal(RemotePrincipal remotePrincipal) {
        return false;
    }

    @Override
    public boolean removePrincipal(RemotePrincipal remotePrincipal) {
        return false;
    }

    @Override
    public List<RemotePrincipal> getMembers(RemoteGroup remoteGroup) {
        return null;
    }

    @Override
    public void addMembers(RemoteGroup remoteGroup, List<RemotePrincipal> remotePrincipals) {

    }

    @Override
    public void removeMembers(RemoteGroup remoteGroup, List<RemotePrincipal> remotePrincipals) {

    }

    @Override
    public List<RemoteGroup> getMemberships(RemotePrincipal remotePrincipal) {
        return null;
    }
}
