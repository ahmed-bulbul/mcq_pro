package com.bulbul.examportal.controller.acl;


import com.bulbul.examportal.service.impl.acl.UserDetailsServiceImpl;
import com.bulbul.examportal.config.JwtUtils;
import com.bulbul.examportal.entity.acl.JwtRequest;
import com.bulbul.examportal.entity.acl.JwtResponse;
import com.bulbul.examportal.entity.acl.User;
import com.bulbul.examportal.error.InvalidCredentialsException;
import com.bulbul.examportal.error.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@CrossOrigin("*")
public class AuthenticateController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    //generate token
    @PostMapping("/generateToken")
    public ResponseEntity<?> generateToken(@Valid @RequestBody JwtRequest jwtRequest) throws Exception {

        try {
            authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());

        }catch (UserNotFoundException e){
            e.printStackTrace();
            throw new Exception("User not found");
        }

        //authenticate
        UserDetails userDetails=this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username,String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));

        }catch (DisabledException e){
            throw new Exception("User Disabled"+ e.getMessage());
        }catch (BadCredentialsException e){
            throw new InvalidCredentialsException("Invalid Credentials");
        }
    }

    //return the details of current user
    @GetMapping("/currentUser")
    public User getCurrentUser(Principal principal){
        return ((User)this.userDetailsService.loadUserByUsername(principal.getName()));
    }
}
