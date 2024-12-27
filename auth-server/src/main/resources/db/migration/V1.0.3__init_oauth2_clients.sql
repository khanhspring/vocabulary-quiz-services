INSERT INTO oauth2_registered_client (id, client_id, client_id_issued_at, client_secret, client_secret_expires_at,
                                      client_name, client_authentication_methods, authorization_grant_types,
                                      redirect_uris, post_logout_redirect_uris, scopes, client_settings, token_settings)
VALUES (gen_random_uuid(), 'web-app-client', CURRENT_TIMESTAMP,
        '$2a$10$q/IvY7Foyx3qESQZbQXdX.DT3mB.kvAQcL96J/S9KgKqahqT53Nue', -- secret
        NULL, 'Web app client',
        'client_secret_basic', 'refresh_token,client_credentials,authorization_code',
        'http://127.0.0.1:3000/authorized',
        'http://127.0.0.1:3000/logged-out',
        'user.read,openid,profile,quiz.read,quiz.write',
        '{"@class":"java.util.Collections$UnmodifiableMap","settings.client.require-proof-key":false,"settings.client.require-authorization-consent":false}',
        '{"@class":"java.util.Collections$UnmodifiableMap","settings.token.reuse-refresh-tokens":true,"settings.token.x509-certificate-bound-access-tokens":false,"settings.token.id-token-signature-algorithm":["org.springframework.security.oauth2.jose.jws.SignatureAlgorithm","RS256"],"settings.token.access-token-time-to-live":["java.time.Duration",300000.000000000],"settings.token.access-token-format":{"@class":"org.springframework.security.oauth2.server.authorization.settings.OAuth2TokenFormat","value":"self-contained"},"settings.token.refresh-token-time-to-live":["java.time.Duration",360000.000000000],"settings.token.authorization-code-time-to-live":["java.time.Duration",300000.000000000],"settings.token.device-code-time-to-live":["java.time.Duration",300000.000000000]}');