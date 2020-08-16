package com.marian.university.controller;

import com.marian.university.entity.ERoles;
import com.marian.university.entity.Role;
import com.marian.university.entity.StudentDetails;
import com.marian.university.entity.User;
import com.marian.university.payload.UserModel;
import com.marian.university.payload.request.LoginRequest;
import com.marian.university.payload.request.SignupRequest;
import com.marian.university.payload.responce.JwtResponse;
import com.marian.university.payload.responce.MessageResponse;
import com.marian.university.repository.RoleRepository;
import com.marian.university.repository.UserRepository;
import com.marian.university.security.jwt.JwtUtils;
import com.marian.university.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin2")
    public ResponseEntity<?> usthenticateUser(@Valid @RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        System.out.println("CONTROLLER TOKEN\t"+ jwt);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item-> item.getAuthority())
                .collect(Collectors.toList());
        System.out.println("ROLEs");
        for (String s :roles ) {
            System.out.println(s);
        }



//        ResponseEntity<?> r;
//        r = new ResponseEntity.ok(new JwtResponse(
//                jwt,
//                userDetails.getId(),
//                userDetails.getUsername(),
//                userDetails.getEmail(),
//                roles                ));
//        JwtResponse  jwtResponse = new JwtResponse(
//                jwt,userDetails.getId(),userDetails.getUsername(),userDetails.getEmail(),roles
//        );
//        System.out.println(jwtResponse.getEmail()+" "+ jwtResponse.getToken());
        ResponseEntity<JwtResponse> ok = ResponseEntity.ok(new JwtResponse(
                jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
        /*ResponseEntity<JwtResponse> ok = ResponseEntity.ok(new JwtResponse(
                jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles
        ));*/
        System.out.println("email.body\t"+ ok.getBody().getRoles().get(0).toString());
        return ok;
    }

    @PostMapping("/signin")
    public UserModel usthenticateUser2(@Valid @RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        System.out.println("CONTROLLER TOKEN\t"+ jwt);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//        List<String> roles = userDetails.getAuthorities().stream()
//                .map(item-> item.getAuthority())
//                .collect(Collectors.toList());
//        System.out.println("ROLEs");
//        for (String s :roles ) {
//            System.out.println(s);
//        }
        UserModel modelUser = new UserModel(userDetails,jwt);



        return modelUser;
    }
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest){
        System.out.println("+++++++++++++++++");
        System.out.println(signupRequest.getEmail());
        if (userRepository.existsByUserName(signupRequest.getUsername())){
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }
        if (userRepository.existsByEmail(signupRequest.getEmail())){
            return ResponseEntity.badRequest().body(new MessageResponse("Error email is alreade in use"));
        }
        //create new user account
        User user = new User(signupRequest.getUsername(),signupRequest.getEmail(),encoder.encode(signupRequest.getPassword()));
        Set<String> strRoles = signupRequest.getRole();
        Set<Role> roles = new HashSet<>();
        if (strRoles==null){
            Role userRole = roleRepository.findByNameRole(ERoles.ROLE_USER).orElseThrow(()->new RuntimeException("Error Role is not found"));
            roles.add(userRole);
        }else {
            strRoles.forEach(role->{
                switch (role){
                    case "admin": Role adminRole = roleRepository.findByNameRole(ERoles.ROLE_ADMIN)
                            .orElseThrow(()->new RuntimeException("Role1 is not found"));
                        roles.add(adminRole);
                        break;
                    case "user": Role userRole  = roleRepository.findByNameRole(ERoles.ROLE_USER)
                            .orElseThrow(()->new RuntimeException("Error2 role is not found"));
                        break;
                    default:Role defaultRole  = roleRepository.findByNameRole(ERoles.ROLE_USER)
                            .orElseThrow(()->new RuntimeException("Error3 role is not found"));
                        break;
                }
            });
        }
        user.setRole(roles);
        user.setStudentDetails(new StudentDetails());// створення студенських можливостей
        userRepository.save(user);
        return ResponseEntity.ok(new MessageResponse("User Register successfully"));


    }
}
