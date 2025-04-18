package com.example.rest.web.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpsertUserRequest {

    private UUID id;

    private String username;

    private String email;

    private String password;

}
