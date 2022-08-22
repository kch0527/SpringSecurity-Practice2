package security.example.springsecuritypractice2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RoleService {

    public List<String> addRoleType(){
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_USER");
        return roles;
    }
}
