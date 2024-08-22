package com.javatask.SupplierService.service;

import com.javatask.SupplierService.dao.SupplierDao;
import com.javatask.SupplierService.model.Supplier;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final SupplierDao supplierDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Supplier> user = supplierDao.findByUserName(username);
        if (user.isEmpty()){
            System.out.println("Couldn't find user");
            throw new UsernameNotFoundException("USER NOT FOUND");
        }
        return new UserPrincipal(user.get());
    }

}
