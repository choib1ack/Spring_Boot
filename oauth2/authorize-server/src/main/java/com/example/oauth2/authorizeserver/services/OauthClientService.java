package com.example.oauth2.authorizeserver.services;

import com.example.oauth2.authorizeserver.models.entities.OauthClientEntity;

import java.util.List;

public interface OauthClientService {
    List<OauthClientEntity> getOauthClientList();

    OauthClientEntity getOauthClientById(String id);

    OauthClientEntity getOauthClientByClientId(String clientId);
}
