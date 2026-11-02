//package com.amit.spingSecurity.config;
//
//import java.util.Set;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import com.amit.spingSecurity.entity.AppUser;
//import com.amit.spingSecurity.entity.Permission;
//import com.amit.spingSecurity.entity.Role;
//import com.amit.spingSecurity.repo.PermissionRepository;
//import com.amit.spingSecurity.repo.RoleRepository;
//import com.amit.spingSecurity.repo.UserRepository;
//
//@Configuration
//public class DataInitializer {
//
//    @Bean
//    CommandLineRunner initializeData(
//            PermissionRepository permissionRepository,
//            RoleRepository roleRepository,
//            UserRepository userRepository,
//            PasswordEncoder passwordEncoder) {
//
//        return args -> {
//            Permission userRead = permissionRepository.save(new Permission("USER_READ"));
//            Permission userWrite = permissionRepository.save(new Permission("USER_WRITE"));
//            Permission reportRead = permissionRepository.save(new Permission("REPORT_READ"));
//            Permission reportCreate = permissionRepository.save(new Permission("REPORT_CREATE"));
//
//            Role adminRole = new Role("ADMIN");
//            adminRole.setPermissions(Set.of(userRead, userWrite, reportRead, reportCreate));
//            adminRole = roleRepository.save(adminRole);
//
//            Role userRole = new Role("USER");
//            userRole.setPermissions(Set.of(userRead, reportRead));
//            userRole = roleRepository.save(userRole);
//
//            AppUser admin = new AppUser("admin", passwordEncoder.encode("admin123"));
//            admin.setRoles(Set.of(adminRole));
//            userRepository.save(admin);
//
//            AppUser user = new AppUser("user", passwordEncoder.encode("user123"));
//            user.setRoles(Set.of(userRole));
//            userRepository.save(user);
//        };
//    }
//}
