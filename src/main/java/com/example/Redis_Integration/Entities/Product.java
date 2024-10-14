package com.example.Redis_Integration.Entities;


import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Product implements Serializable {

    private String id;
    private String name;
    private String price;
}
