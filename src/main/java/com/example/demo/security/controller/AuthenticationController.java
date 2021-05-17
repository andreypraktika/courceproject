package com.example.demo.security.controller;

import com.example.demo.security.AppUserDetailsService;
import com.example.demo.security.dto.AuthResultData;
import com.example.demo.security.dto.JwtBody;
import com.example.demo.security.jwt.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.example.demo.security.filter.JwtRequestFilter.ACCESS_TOKEN;


@RestController
@CrossOrigin
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenUtil jwtTokenUtil;

    @Autowired
    private AppUserDetailsService userDetailsService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public AuthResultData createAuthenticationToken(@RequestBody JwtBody authenticationRequest, HttpServletResponse response) throws Exception {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        final var accessToken = new Cookie(ACCESS_TOKEN, token);
        response.addCookie(accessToken);
        return new AuthResultData();
    }

    @GetMapping(value = "/userlogout")
    public ResponseEntity<String> logout(HttpServletResponse response, HttpServletRequest request) throws Exception {
        response.setHeader("Set-Cookie", null);
        for (Cookie cookie : request.getCookies()) {
            String cookieName = cookie.getName();
            Cookie delete = new Cookie(cookieName, null);
            delete.setMaxAge(0);
            response.addCookie(delete);
        }
        return new ResponseEntity<>("Logged out", HttpStatus.OK);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            System.out.println("Authenticated");
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}