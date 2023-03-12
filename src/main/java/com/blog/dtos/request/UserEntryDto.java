package com.blog.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntryDto {

    private int id;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

}
