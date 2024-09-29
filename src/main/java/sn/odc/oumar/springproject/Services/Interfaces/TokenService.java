package sn.odc.oumar.springproject.Services.Interfaces;

import org.springframework.security.core.Authentication;

public interface TokenService {
    String generateToken(Authentication authentication);
    boolean validateToken(String token);
    Long getUserIdFromToken(String token);
}