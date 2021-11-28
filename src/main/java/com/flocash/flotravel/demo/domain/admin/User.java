package com.flocash.flotravel.demo.domain.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;
import java.util.Set;

@Document(collection = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User  {
    private static final long serialVersionUID = 7495299960983966960L;
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String profileImg;
    private String email;
    private String mobile;
    private String password;
    private boolean expired;
    private boolean locked;
    private Set<String> userGroupIds;
    private boolean passwordExpired;
    private boolean enabled;
}
