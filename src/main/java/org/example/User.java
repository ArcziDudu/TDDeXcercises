package org.example;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@With
public class User implements Comparable<User>{
    private String name;
    private String surname;
    private String email;


    @Override
    public int compareTo(final User o) {
        return o.email.compareTo(email);
    }
}
