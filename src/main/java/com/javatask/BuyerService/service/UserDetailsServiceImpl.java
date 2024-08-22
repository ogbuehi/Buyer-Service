package com.javatask.BuyerService.service;

import com.javatask.BuyerService.dao.BuyerDao;
import com.javatask.BuyerService.model.Buyer;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final BuyerDao buyerDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Buyer> user = buyerDao.findByUserName(username);
        if (user.isEmpty()){
            System.out.println("Couldn't find user");
            throw new UsernameNotFoundException("USER NOT FOUND");
        }
        return new UserPrincipal(user.get());
    }

}
