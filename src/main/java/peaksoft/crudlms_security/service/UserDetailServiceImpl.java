package peaksoft.crudlms_security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import peaksoft.crudlms_security.model.MyUser;
import peaksoft.crudlms_security.model.UserAuth;
import peaksoft.crudlms_security.repository.UserAuthRepository;

public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserAuthRepository authRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAuth userAuth = authRepository.getUserAuthByUsername(username);
        if (userAuth == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
        return new MyUser(userAuth);
    }
}
