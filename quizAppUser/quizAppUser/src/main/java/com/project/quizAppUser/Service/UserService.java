package com.project.quizAppUser.Service;

import com.project.quizAppUser.Model.UserPrinciple;
import com.project.quizAppUser.Model.Users;
import com.project.quizAppUser.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
    private final JwtService jwtService;
    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(13);
    private final UserRepo repo;
    private AuthenticationManager authManager;
    @Autowired
    @Lazy
    public void setAuthManager(AuthenticationManager authenticationManager){
        this.authManager=authenticationManager;
    }
    public UserService(JwtService jwtService, UserRepo repo) {
        this.jwtService = jwtService;
        this.repo = repo;
    }

    public Users addUser(Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

    public List<Users> getUser() {
        return repo.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user=repo.findByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("user not found");
        }
        return new UserPrinciple(user);
    }


    public String verify(Users user) {
        Authentication authentication=authManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
            if(authentication.isAuthenticated()){
            return jwtService.generateToken(user.getUsername());
        }
        return "failed";
    }

}
