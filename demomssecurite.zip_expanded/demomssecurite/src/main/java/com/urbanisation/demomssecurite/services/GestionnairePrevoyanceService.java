package com.urbanisation.demomssecurite.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.urbanisation.demomssecurite.dao.GestionnairePrevoyanceRepository;
import com.urbanisation.demomssecurite.dao.RoleRepository;
import com.urbanisation.demomssecurite.entity.GestionnairePrevoyance;
import com.urbanisation.demomssecurite.entity.Role;

import java.util.*;

@Service
public class GestionnairePrevoyanceService implements UserDetailsService {

    private final GestionnairePrevoyanceRepository gestionnairePrevoyanceRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public GestionnairePrevoyanceService(GestionnairePrevoyanceRepository gestionnairePrevoyanceRepository,
                                         RoleRepository roleRepository,
                                         BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.gestionnairePrevoyanceRepository = gestionnairePrevoyanceRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public GestionnairePrevoyanceService() {
		this.gestionnairePrevoyanceRepository = null;
		this.roleRepository = null;
		this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
	}

	public void sauveGestionnairePrevoyance(GestionnairePrevoyance gestionnairePrevoyance) {
        gestionnairePrevoyance.setMotdepasse(bCryptPasswordEncoder.encode(gestionnairePrevoyance.getMotdepasse()));
        gestionnairePrevoyance.setActive(true);
        Role gestionnairePrevoyanceRole = roleRepository.findByRole("ADMIN");
        gestionnairePrevoyance.setRoles(new HashSet<>(Arrays.asList(gestionnairePrevoyanceRole)));
        gestionnairePrevoyanceRepository.save(gestionnairePrevoyance);
    }

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        GestionnairePrevoyance gestionnairePrevoyance = gestionnairePrevoyanceRepository.findByMail(mail);
        if (gestionnairePrevoyance != null) {
            List<GrantedAuthority> autorisations = getGestionnairePrevoyanceAutorisation(gestionnairePrevoyance.getRoles());
            return autoriserGestionnairePrevoyance(gestionnairePrevoyance, autorisations);
        } else {
            throw new UsernameNotFoundException("Non autorisé.");
        }
    }

    private List<GrantedAuthority> getGestionnairePrevoyanceAutorisation(Set<Role> gestionnairePrevoyanceRoles) {
        Set<GrantedAuthority> roles = new HashSet<>();
        gestionnairePrevoyanceRoles.forEach((role) -> {
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        });

        return new ArrayList<>(roles);
    }

    private UserDetails autoriserGestionnairePrevoyance(GestionnairePrevoyance gestionnairePrevoyance, List<GrantedAuthority> autorisations) {
        return new org.springframework.security.core.userdetails.User(
                gestionnairePrevoyance.getMail(),
                gestionnairePrevoyance.getMotdepasse(),
                gestionnairePrevoyance.isActive(),
                true,
                true,
                true,
                autorisations
        );
    }

	public GestionnairePrevoyance findByMail(String mail) {
		// TODO Auto-generated method stub
		return null;
	}
}

